DROP DATABASE IF EXISTS beer;
CREATE DATABASE IF NOT EXISTS beer;
USE beer;

DROP TABLE IF EXISTS individual_order_status;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS price_per_six_pack_beer;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS beers;

CREATE TABLE beers (
    beer_pk int unsigned NOT NULL AUTO_INCREMENT,
    beer_id varchar(45) NOT NULL,
    beer_type enum ('Sour', 'Stout', 'Wild Ale', 'Farmhouse Ale', 'Lager', 'Ale'),
    beer_style enum ('Fruited', 'Other', 'Imperial', 'American', 'Saison', 'American Style Lager', 'Munich Dunkel Lager', 'German',
    'Light_Lager', 'American', 'Belgian_Style_Witbier', 'Belgian_Style_Witbier_Mango', 'Euro_Pale_Lager','American_IPA', 
    'Belgian_Sytle_Tripel', 'German_Style_Oktoberfest','American_Amber_Ale'),
     PRIMARY KEY (beer_pk),
     UNIQUE KEY (beer_id, beer_type, beer_style)
);
-- Add dateTimeCreated to customers to catch/track a SQL injection/hack
CREATE TABLE customers (
    customer_pk int unsigned NOT NULL AUTO_INCREMENT,
    address_fk int unsigned NOT NULL,
    customer_id varchar(40) NOT NULL,
    first_name varchar(45) NOT NULL,
    last_name varchar(45) NOT NULL,
    phone varchar(20) NOT NULL,
     PRIMARY KEY (customer_pk)
    );
   -- Add dateTimeCreated to address to catch/track a SQL injection/hack
  CREATE TABLE address (
 	address_pk int unsigned NOT NULL AUTO_INCREMENT,
  	customer_fk int unsigned NOT NULL,
 	billing_address varchar(150) NOT NULL,
  	shipping_address varchar(150) NOT NULL,
  	 PRIMARY KEY (address_pk),
  	 FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE
  );
-- Add dateTimeCreated to price_per_pie so last price adjustment can be seen
CREATE TABLE price_per_six_pack_beer (
	price_per_six_pack_beer_pk int unsigned NOT NULL AUTO_INCREMENT,
    beer_fk int unsigned NOT NULL,
  	price_per_six_pack_beer decimal(6, 2) NOT NULL,
     PRIMARY KEY (price_per_six_pack_beer_pk),
     FOREIGN KEY (beer_fk) REFERENCES beers (beer_pk) ON DELETE CASCADE
);

CREATE TABLE order_items (
	order_item_pk int unsigned NOT NULL AUTO_INCREMENT,
    beer_fk int unsigned NOT NULL,
    price_per_six_pack_beer_fk int unsigned NOT NULL,
    quantity int unsigned NOT NULL,
     PRIMARY KEY (order_item_pk),
     FOREIGN KEY (beer_fk) REFERENCES beers (beer_pk) ON DELETE CASCADE,
     FOREIGN KEY (price_per_six_pack_beer_fk) REFERENCES price_per_six_pack_beer (price_per_six_pack_beer_pk) ON DELETE CASCADE
);
-- Add dateTimeCreated to orders so a date/time stamp is created with each order creation
CREATE TABLE orders (
	order_pk int unsigned NOT NULL AUTO_INCREMENT,
    order_item_fk int unsigned NOT NULL,
    customer_fk int unsigned NOT NULL,
    order_total decimal(6, 2) NOT NULL,
     PRIMARY KEY (order_pk),
     FOREIGN KEY (order_item_fk) REFERENCES order_items (order_item_pk) ON DELETE CASCADE,
     FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE
);
-- Called order_status IndividualOrderStatus so I could make enum class called OrderStatus
-- Add dateTimeCreated to order_status so a date/time stamp is created with each order_status creation
CREATE TABLE individual_order_status (
	order_status_pk int unsigned NOT NULL AUTO_INCREMENT,
	order_fk int unsigned NOT NULL,
    customer_fk int unsigned NOT NULL,
    order_status enum('ORDER RECEIVED', 'PACKED', 'SHIPPED'),
    shipping_status enum ('PRE_TRANSIT', 'IN_TRANSIT', 'OUT_FOR_DELIVERY', 'DELIVERED'),
     PRIMARY KEY (order_status_pk),
     FOREIGN KEY (order_fk) REFERENCES orders (order_pk) ON DELETE CASCADE,
     FOREIGN KEY (customer_fk) REFERENCES customers (customer_pk) ON DELETE CASCADE
);