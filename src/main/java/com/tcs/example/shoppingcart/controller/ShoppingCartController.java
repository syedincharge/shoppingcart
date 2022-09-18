package com.tcs.example.shoppingcart.controller;

import com.tcs.example.shoppingcart.entity.*;
import com.tcs.example.shoppingcart.exception.ShoppingCartEmptyException;
import com.tcs.example.shoppingcart.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartController {

    private final CountryService countryService;

    private final UsersService usersService;

    private final OrderService orderService;

    private final FavoriteService favoriteService;
    private final ProductService productService;
    private final ProductTypeService productTypeService;

    private final ShoppingCartEntryService shoppingCartService;

    @Autowired
    public ShoppingCartController(CountryService countryService,
                                  UsersService usersService,
                                  OrderService orderService,
                                  ProductService productService,
                                  FavoriteService favoriteService,
                                  ShoppingCartEntryService shoppingCartService,
                                  ProductTypeService productTypeService) {
        this.countryService = countryService;
        this.usersService = usersService;
        this.orderService = orderService;
        this.productService = productService;
        this.favoriteService = favoriteService;
        this.shoppingCartService = shoppingCartService;
        this.productTypeService = productTypeService;
    }

    @RequestMapping("/countries")
    public List<Country> showCountry() {
        return countryService.getCountries();
    }

    @RequestMapping("/countries/{id}")
    public Country showCountry(@PathVariable("id") int countryId) {
        return countryService.getCountry(countryId);
    }


    @RequestMapping("/users/{userId}/shoppingcart/products/{productId}")
    public ShoppingCartEntry showUsersShoppingCartEntry(@PathVariable("userId") int customerId, @PathVariable("productId") int productId) {
        return shoppingCartService.getProductEntryByCustomerId(customerId, productId);
    }


    @PostMapping("/users/{id}/shoppingcart/new")
    public ResponseEntity<ShoppingCartEntry> addShoppingCartEntry(@PathVariable("id") int customerId, @RequestBody ShoppingCartEntry shoppingCartEntry) {

        ShoppingCartEntry existingSCE = this.shoppingCartService.getProductEntryByCustomerId(shoppingCartEntry.getCustomerId(), shoppingCartEntry.getProductId());
        if (existingSCE != null) {
            shoppingCartEntry.setQuantity(shoppingCartEntry.getQuantity() + existingSCE.getQuantity());
            shoppingCartEntry.setId(existingSCE.getId());
        }

        ShoppingCartEntry sce = this.shoppingCartService.addToCart(shoppingCartEntry);

        return new ResponseEntity<ShoppingCartEntry>(sce, HttpStatus.OK);

    }

    @RequestMapping("/users/{userId}/orders/{id}")
    public Order showOrder(@PathVariable("userId") int customerId, @PathVariable("id") int orderId) {
        return this.orderService.getOrder(orderId);
    }

    @RequestMapping("/users/{userId}/orders")
    public List<Order> showOrders(@PathVariable("userId") int customerId) {
        return this.orderService.getOrders(customerId);
    }

    @PostMapping("/users/{userId}/orders/new")
    public ResponseEntity  addOrder(@PathVariable("userId") int customerId, @RequestBody Order order) {

        try {
            Order newOrder = this.orderService.createOrder(order);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(newOrder);
        }
        catch (ShoppingCartEmptyException scee) {
            return ResponseEntity
                    .status(HttpStatus.FAILED_DEPENDENCY)
                    .body(scee.getMessage());
        }
    }

    @RequestMapping("/products")
    public List<Product> showProducts(){
       return productService.getProducts();

    }

    @RequestMapping("/products/{id}")
    public Product showProduct(@PathVariable("id") int id){
       return productService.getProduct(id);
    }

    @PostMapping("/products/new")
    public ResponseEntity<Product> newProduct(@RequestBody Product product){
       Product p = productService.addProduct(product);
       return new ResponseEntity<Product>(p, HttpStatus.OK);

    }
    @RequestMapping("/producttypes")
    public List<ProductType> showProductTypes(){
       return  productTypeService.getProductTypes();
    }

    @RequestMapping("/producttypes/{id}")
    public ProductType showProductType(@PathVariable("id") int id){
        return  productTypeService.getProductType(id);
    }

    @PostMapping("/producttypes/new")
    public ResponseEntity<ProductType> newProductType(@RequestBody ProductType productType){
        ProductType p = productTypeService.addProductType(productType);
        return new ResponseEntity<ProductType>(p, HttpStatus.OK);

    }

    @RequestMapping("/users/{id}/favorites")
    public List<Favorite> getFavorites(@PathVariable("id") int id){
       return  favoriteService.getFavorites(id);
    }

    @PostMapping("/users/{id}/favorites/new")
    public ResponseEntity<Favorite> newFavorites(@RequestBody Favorite favorite){
       Favorite f = favoriteService.addFavorite(favorite);
       return  new ResponseEntity<Favorite>(f, HttpStatus.OK);
    }


    @RequestMapping("/users/{id}/shoppingcart")
    public List<ShoppingCartEntry> showUsersShoppingCart(@PathVariable("id") int customerId){
        return shoppingCartService.getCustomerShoppingCart(customerId);
    }

}
