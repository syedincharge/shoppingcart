-- countries
INSERT INTO countries (id, name) VALUES (1, 'USA');
INSERT INTO countries (id, name) VALUES (2, 'FRANCE');
INSERT INTO countries (id, name) VALUES (3, 'Brazil');
INSERT INTO countries (id, name) VALUES (4, 'ITALY');
INSERT INTO countries (id, name) VALUES (5, 'CANADA');
INSERT INTO countries (id, name) VALUES (6, 'INDIA');
INSERT INTO countries (id, name) VALUES (7, 'PAKISTAN');
INSERT INTO countries (id, name) VALUES (8, 'GERMANY');
INSERT INTO countries (id, name) VALUES (9, 'UK');

INSERT INTO users (id, first_name, last_name, email, password, country_id) VALUES (1, 'Peter','Sotos','peter.sotos@tcs.com','test',1 );

INSERT INTO product_types (id, type_name) VALUES (1, 't-shirt');
INSERT INTO product_types (id, type_name) VALUES (2, 'nug');
INSERT INTO product_types (id, type_name) VALUES (3, 'hat');

INSERT INTO products (id, sku, name, description, product_type, price) VALUES (1, 'KHU123', 'Castle Coffee Mug', 'A gorgeous mug featuring a castle', 2, 15.99);
INSERT INTO products (id, sku, name, description, product_type, price) VALUES (2, 'KHU124', 'Castle T-Shirt', 'A gorgeous t-shirt featuring a castle', 1, 25.99);
INSERT INTO products (id, sku, name, description, product_type, price) VALUES (3, 'KHU125', 'Castle Hat', 'A gorgeous hat featuring a castle', 3, 19.99);

