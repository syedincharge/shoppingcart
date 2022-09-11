create table countries (
  id      int,
  name    VARCHAR(60)
);

create table users (
  id      int,
  first_name    VARCHAR(60),
  last_name    VARCHAR(60),
  email    VARCHAR(80),
  password  varchar(20),
  country_id  int
);

create table products (
  id      int,
  sku      VARCHAR(30),
  name    VARCHAR(60),
  description VARCHAR(255),
  product_type int,
  price   numeric
);

create table shopping_cart (
  id      int,
  product_id   int,
  quantity  int,
  customer_id   int
);

create table orders (
  id    int,
  order_date  date,
  credit_card_last_four   VARCHAR(4),
  customer_id   int,
  order_amount  numeric,
  tax  numeric,
  shipping   numeric
);

create table order_items (
  id   int,
  order_id   int,
  product_id   int,
  quantity  int
);

create table product_types (
  id    int,
  type_name    VARCHAR(40)
);

