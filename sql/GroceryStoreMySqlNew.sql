-- ***********************************************************************************************
-- Author: Rosemeire Deconti
-- Date: 01/06/2021
-- Idea from: Digital Innovation One - Bootcamp CodeAnywhere mentoring
-- Goal: Develop an application to control stocks and e-commerce from a Grocery
-- ***********************************************************************************************
USE groceryStore;

-- ***********************************************************************************************
-- DEFINE DATE TO BE USED DURING TABLE CREATION
-- ***********************************************************************************************
SET @created = CURRENT_TIMESTAMP();
SET @changed = CURRENT_TIMESTAMP();
SET @expiration = CURRENT_TIMESTAMP();

-- ***********************************************************************************************
-- DROP TABLES
-- ***********************************************************************************************
DROP TABLE IF EXISTS SALES;
DROP TABLE IF EXISTS PURCHASES;
DROP TABLE IF EXISTS STOCKS;
DROP TABLE IF EXISTS PRODUCTS;
DROP TABLE IF EXISTS CUSTOMERS;
DROP TABLE IF EXISTS VENDORS;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS ROLES;
DROP TABLE IF EXISTS CONTACTS;

-- ***********************************************************************************************
-- * CONTACTS
-- ***********************************************************************************************
CREATE TABLE CONTACTS (
	contact_ID INT NOT NULL auto_increment,
	contact_name VARCHAR (50) NOT NULL,
	contact_address VARCHAR (255) NOT NULL,
	contact_phone VARCHAR (50) NOT NULL,
	contact_type INT NOT NULL,
	contact_document VARCHAR (14) NULL,
	contact_status BOOLEAN NOT NULL,
	contact_email VARCHAR (255) NOT NULL,
	contact_createdon DATE NOT NULL,
	contact_changedon DATE NOT NULL,
	PRIMARY KEY (contact_ID)
);

INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES
    (1,'FORNECEDOR 1','Endereço', '9-9999-9999', 2, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(2,'FORNECEDOR 2','Endereço', '9-9999-9999', 2, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(3,'FORNECEDOR 3','Endereço', '9-9999-9999', 2, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(4,'CLIENTE 1','Endereço', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(5,'CLIENTE 2','Endereço', '9-9999-9999', 2, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(6,'CLIENTE 3','Endereço', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(7,'MANAGER','Endereço', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(8,'PURCHASER','Endereço', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
    (9,'SELLER','Endereço', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
    (10,'STOCKER','Endereço', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
    (11,'USER','Endereço', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed); 

-- ***********************************************************************************************
-- * VENDORS
-- ***********************************************************************************************
CREATE TABLE VENDORS (
	vendor_ID INT NOT NULL auto_increment,
	vendor_contactID INT NOT NULL,
	vendor_status BOOLEAN NOT NULL,
	vendor_createdon DATE NOT NULL,
	vendor_changedon DATE NOT NULL,
	PRIMARY KEY (vendor_ID),
	FOREIGN KEY (vendor_contactID) REFERENCES CONTACTS(contact_ID)
);

INSERT INTO VENDORS(vendor_ID, vendor_contactID, vendor_status, vendor_createdon, vendor_changedon) 
	VALUES
    (1, 1,true, @created, @changed),
	(2, 2,true, @created, @changed),
	(3, 3,true, @created, @changed);
    
-- ***********************************************************************************************
-- * CUSTOMERS
-- ***********************************************************************************************
CREATE TABLE CUSTOMERS (
	customer_ID INT NOT NULL auto_increment,
	customer_contactID INT NOT NULL,
	customer_status BOOLEAN NOT NULL,
	customer_createdon DATE NOT NULL,
	customer_changedon DATE NOT NULL,
	PRIMARY KEY (customer_ID),
	FOREIGN KEY (customer_ContactID) REFERENCES CONTACTS(contact_ID)
);

INSERT INTO CUSTOMERS(customer_ID, customer_contactID, customer_status, customer_createdon, customer_changedon) 
	VALUES
    (1, 4,true, @created, @changed),
	(2, 5,true, @created, @changed),
	(3, 6,true, @created, @changed);
    
-- ***********************************************************************************************
-- * PRODUCTS
-- ***********************************************************************************************
CREATE TABLE PRODUCTS (
	product_ID INT NOT NULL auto_increment,
	product_name VARCHAR (50) NOT NULL,
	product_ean VARCHAR (13) NOT NULL,
	product_unity VARCHAR (3) NOT NULL,
	product_status BOOLEAN NOT NULL,
	product_image BLOB,
	product_price double precision not null,
	product_createdon DATE NOT NULL,
	product_changedon DATE NOT NULL,
	PRIMARY KEY (product_ID)
);

INSERT INTO PRODUCTS(product_ID, product_name, product_ean, product_unity, product_status, product_price, product_createdon, product_changedon) 
 	VALUES
    (1, 'Banana', '123456789012', 'UN', true, 10, @created, @changed),
 	(2, 'Batata', '123456789012', 'UN', true, 10, @created, @changed),
 	(3, 'Cenoura', '123456789012', 'UN', true, 10, @created, @changed),
 	(4, 'Damasco', '123456789012', 'UN', true, 10, @created, @changed),
 	(5, 'Framboesa', '123456789012', 'UN', true, 10, @created, @changed),
	(6, 'Maçã', '123456789012', 'UN', true, 10, @created, @changed),
 	(7, 'Melância', '123456789012', 'UN', true, 10, @created, @changed),
 	(8, 'Mirtilo', '123456789012', 'UN', true, 10, @created, @changed),
 	(9, 'Morango', '123456789012', 'UN',true, 10, @created, @changed),
 	(10, 'Pepino', '123456789012', 'UN',true, 10, @created, @changed),
    (11, 'Pera', '123456789012', 'UN', true, 10, @created, @changed),
 	(12, 'Uva', '123456789012', 'UN', true, 10, @created, @changed);    

-- ***********************************************************************************************
-- * SALES
-- ***********************************************************************************************
CREATE TABLE SALES (
	sale_ID INT NOT NULL auto_increment,
	sale_customerID INT NOT NULL,
	sale_productID INT NOT NULL,
	sale_amount DECIMAL NOT NULL,
    sale_price DECIMAL NOT NULL,
	sale_createdon DATE NOT NULL,
	sale_changedon DATE NOT NULL,
	PRIMARY KEY (sale_ID),
	FOREIGN KEY (sale_customerID) REFERENCES CUSTOMERS(customer_ID),
	FOREIGN KEY (sale_productID) REFERENCES PRODUCTS(product_ID)
);

INSERT INTO SALES(sale_ID, sale_customerID, sale_productID, sale_amount, sale_price, sale_createdon, sale_changedon) 
	VALUES
    (1, 1, 1, 1000, 2000, @created, @changed),
	(2, 2, 2, 1000, 2000, @created, @changed),
	(3, 3, 3, 1000, 2000, @created, @changed),
	(4, 1, 4, 1000, 2000, @created, @changed),
	(5, 2, 5, 1000, 2000, @created, @changed),
	(6, 3, 6, 1000, 2000, @created, @changed),
	(7, 1, 7, 1000, 2000, @created, @changed),
	(8, 2, 8, 1000, 2000, @created, @changed),
	(9, 1, 9, 1000, 2000, @created, @changed),
	(10, 1, 10, 1000, 2000, @created, @changed),
	(11, 2, 11, 1000, 2000, @created, @changed),
	(12, 3, 12, 1000, 2000, @created, @changed);

-- ***********************************************************************************************
-- * PURCHASES
-- ***********************************************************************************************
CREATE TABLE PURCHASES (
	purchase_ID INT NOT NULL auto_increment,
	purchase_vendorID INT NOT NULL,
	purchase_productID INT NOT NULL,
	purchase_amount DECIMAL NOT NULL,
	purchase_price DECIMAL NOT NULL,
	purchase_createdon DATE NOT NULL,
	purchase_changedon DATE NOT NULL,
	PRIMARY KEY (purchase_ID),
	FOREIGN KEY (purchase_vendorID) REFERENCES VENDORS(vendor_ID),
	FOREIGN KEY (purchase_productID) REFERENCES PRODUCTS(product_ID)
);

INSERT INTO PURCHASES(purchase_ID, purchase_vendorID, purchase_productID, purchase_amount, purchase_price, purchase_createdon, purchase_changedon) 
	VALUES
	(1, 1, 1, 1000, 2000, @created, @changed),
	(2, 2, 2, 1000, 2000, @created, @changed),
	(3, 3, 3, 1000, 2000, @created, @changed),
	(4, 1, 4, 1000, 2000, @created, @changed),
	(5, 2, 5, 1000, 2000, @created, @changed),
	(6, 3, 6, 1000, 2000, @created, @changed),
	(7, 1, 7, 1000, 2000, @created, @changed),
	(8, 2, 8, 1000, 2000, @created, @changed),
	(9, 3, 9, 1000, 2000, @created, @changed),
	(10, 1, 10, 1000, 2000, @created, @changed),
    (11, 2, 11, 1000, 2000, @created, @changed),
    (12, 3, 12, 1000, 2000, @created, @changed);
    
-- ***********************************************************************************************
-- * STOCKS
-- ***********************************************************************************************
CREATE TABLE STOCKS (
	stock_ID INT NOT NULL auto_increment,
	stock_productID INT NOT NULL,
	stock_amount DECIMAL NOT NULL,
	stock_expiration DATE NOT NULL,
	stock_createdon DATE NOT NULL,
	stock_changedon DATE NOT NULL,
	PRIMARY KEY (stock_ID),
	FOREIGN KEY (stock_productID) REFERENCES PRODUCTS(product_ID)
);

INSERT INTO STOCKS(stock_ID, stock_productID, stock_amount, stock_expiration, stock_createdon, stock_changedon)
	VALUES
    (1, 1, 10000, @expiration, @created, @changed),
	(2, 2, 20000, @expiration, @created, @changed),
	(3, 3, 30000, @expiration, @created, @changed),
	(4, 4, 40000, @expiration, @created, @changed),
	(5, 5, 50000, @expiration, @created, @changed),
	(6, 6, 60000, @expiration, @created, @changed),
	(7, 7, 70000, @expiration, @created, @changed),
	(8, 8, 80000, @expiration, @created, @changed),
	(9, 9, 90000, @expiration, @created, @changed),
	(10, 10, 100000, @expiration, @created, @changed),
	(11, 11, 110000, @expiration, @created, @changed),
	(12, 12, 120000, @expiration, @created, @changed);
    
-- ***********************************************************************************************
-- * ROLES
-- ***********************************************************************************************   
CREATE TABLE ROLES (
	role_ID INT NOT NULL auto_increment,
	role_name VARCHAR(50) NOT NULL,
	PRIMARY KEY (role_ID)
);

INSERT INTO ROLES(role_ID, role_name) 
VALUES
	(1, 'ROLE_MANAGER'),
	(2, 'ROLE_PURCHASER'),
	(3, 'ROLE_SELLER'),
	(4, 'ROLE_STOCKER'),
	(5, 'ROLE_USER');    

-- ***********************************************************************************************
-- * USERS
-- ***********************************************************************************************
CREATE TABLE USERS (
	user_ID INT auto_increment,
	user_contactID INT,
	user_roleID INT,    
    user_code VARCHAR(20),
	user_password VARCHAR(128),
	user_status BOOLEAN,    
	PRIMARY KEY (user_id),
	FOREIGN KEY (user_roleID) REFERENCES ROLES(role_ID),
	FOREIGN KEY (user_ContactID) REFERENCES CONTACTS(contact_ID)
);

-- password 12345 = $2a$10$f1XHZXpdECjp5C977Y6GtuSwtL1ZwiXHxJFgHP9AgtzBxVwpMRC/e
SET @password = "$2a$10$f1XHZXpdECjp5C977Y6GtuSwtL1ZwiXHxJFgHP9AgtzBxVwpMRC/e";

INSERT INTO USERS(user_ID, user_contactID, user_roleID, user_code, user_password, user_status)
VALUES
	(1, 7, 1, 'MANAGER', @password, true),
	(2, 8, 2, 'PURCHASER', @password, true),
	(3, 9, 3, 'SELLER', @password, true),   
	(4, 10, 4,'STOCKER', @password, true),   
	(5, 11, 5, 'USER', @password, true);
    
-- ***********************************************************************************************
-- Print data from tables
-- ***********************************************************************************************
SELECT * FROM SALES;
SELECT * FROM PURCHASES;
SELECT * FROM STOCKS;
SELECT * FROM PRODUCTS;
SELECT * FROM CUSTOMERS;
SELECT * FROM VENDORS;
SELECT * FROM USERS;
SELECT * FROM ROLES;
SELECT * FROM CONTACTS;