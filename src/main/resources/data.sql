DROP TABLE IF EXISTS order_item;
DROP TABLE IF EXISTS stock;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS store;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS staff;

CREATE TABLE staff (
 id_staff INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
 firstname varchar(30) NOT NULL,
 lastname varchar(30) NOT NULL,
 position varchar(30) NOT NULL,
 phone varchar(30) NOT NULL,
 email varchar(30) NOT NULL,
 username varchar(30) UNIQUE NOT NULL,
 password varchar(100) NOT NULL,
 hire_date date NOT NULL,
 role varchar(30) NOT NULL
);

CREATE TABLE product (
 id_product INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
 name varchar(30) NOT NULL,
 description varchar(100) NOT NULL,
 manufacturer varchar(50) NOT NULL,
 price FLOAT NOT NULL
);

CREATE TABLE customer (
 id_customer INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
 firstname varchar(30) NOT NULL,
 lastname varchar(30) NOT NULL,
 birthdate date NOT NULL,
 email varchar(30) NOT NULL,
 registration_date date NOT NULL
);

CREATE TABLE orders (
 id_order INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
 id_customer INT NOT NULL,
 id_staff INT NOT NULL,
 received_date date NOT NULL,
 status varchar(30) NOT NULL
);

CREATE TABLE order_item (
 id_order_item INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
 id_product INT NOT NULL,
 id_order INT NOT NULL,
 quantity INT NOT NULL
);

CREATE TABLE store (
 id_store INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
 id_staff INT NOT NULL,
 address varchar(30) NOT NULL,
 phone varchar(30) NOT NULL,
 open_date date NOT NULL
);

CREATE TABLE stock (
 id_stock INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
 id_product INT NOT NULL,
 id_store INT NOT NULL,
 quantity INT NOT NULL
);

INSERT INTO staff (firstname,lastname, position, phone, email, username, password, hire_date, role) VALUES
  ('Laurentiu','Ene','MANAGER','0734839325','laurre_ene@yahoo.com','manager','$2a$04$Z2TCdboQL7Vex20esa2wqeP8nMKm9NXe7OsXJx4gWy4ZzXSvBhOIG','2022-11-08','ADMIN'),
  ('Marcel','Popescu','EMPLOYEE','0712345678','u@u.u','employee','$2a$04$Z2TCdboQL7Vex20esa2wqeP8nMKm9NXe7OsXJx4gWy4ZzXSvBhOIG','2022-11-30','USER');

INSERT INTO product (name, description, manufacturer, price) VALUES
  ('product1','an excelent product','manufacturer1','123.00'),
  ('product2','an ok product','manufacturer2','55.00');

INSERT INTO customer (firstname, lastname, birthdate, email, registration_date) VALUES
  ('John','Doe','1980-11-01','c@d.d','2022-11-11'),
  ('John','Ark','1980-11-10','c@a.a','2022-11-12');

INSERT INTO orders (id_customer, id_staff, received_date, status) VALUES
  ('1','2','2023-02-01','DELIVERED'),
  ('2','2','2023-02-02','PENDING');

INSERT INTO order_item (id_product, id_order, quantity) VALUES
  ('1','1','2'),
  ('2','1','3');

INSERT INTO store (id_staff, address, phone, open_date) VALUES
  ('1','Calea Grivitei','0213501139', '2023-01-01'),
  ('1','Strada Resita','0213501140', '2023-02-01');

INSERT INTO stock (id_product, id_store, quantity) VALUES
  ('1','1','10'),
  ('1','2','11'),
  ('2','1','20'),
  ('2','2','15');