-- ***********************************************************************************************
-- Author: Rosemeire Deconti
-- Date: 01/06/2021
-- Idea from: Digital Innovation One - Bootcamp CodeAnywhere mentoring
-- Goal: Develop an application to control stocks and e-commerce from a Grocery
-- ***********************************************************************************************
-- Define database to be used

-- DROP DATABASE IF EXISTS grocerystore;
-- CREATE DATABASE grocerystore;

-- DROP SCHEMA IF EXISTS grocerstore;
-- CREATE SCHEMA grocerystore DEFAULT CHARACTER SET utf8 ;

USE groceryStore;

-- ***********************************************************************************************
-- Declare date to be used in table creations
-- ***********************************************************************************************
SET @created = CURRENT_TIMESTAMP();
SET @changed = CURRENT_TIMESTAMP();
SET @expiration = CURRENT_TIMESTAMP();

-- ***********************************************************************************************
-- Drop tables
-- ***********************************************************************************************
DROP TABLE IF EXISTS SALES;
DROP TABLE IF EXISTS PURCHASES;
DROP TABLE IF EXISTS ORDER_DETAILS;
DROP TABLE IF EXISTS ORDERS;

DROP TABLE IF EXISTS STOCKS;
DROP TABLE IF EXISTS STORES;
DROP TABLE IF EXISTS PRODUCTS;

DROP TABLE IF EXISTS CUSTOMERS;
DROP TABLE IF EXISTS VENDORS;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS ROLES;
DROP TABLE IF EXISTS CONTACTS;
DROP TABLE IF EXISTS AGENDA;

-- ***********************************************************************************************
-- Create table: AGENDA
-- ***********************************************************************************************
CREATE TABLE AGENDA (
	agenda_ID INT NOT NULL auto_increment,
	agenda_name VARCHAR (50) NOT NULL,
	agenda_phone VARCHAR (50) NOT NULL,  
	agenda_email VARCHAR (255) NOT NULL,    
	agenda_address1 VARCHAR (255) NOT NULL,
	agenda_address2 VARCHAR (255) NOT NULL,
	agenda_address3 VARCHAR (255) NOT NULL,
	agenda_postalCode VARCHAR(20) NOT NULL DEFAULT '99999-99',
	agenda_note VARCHAR (14) NULL,
	PRIMARY KEY (agenda_ID)
);

INSERT INTO AGENDA(agenda_ID, agenda_name, agenda_phone, agenda_email, agenda_address1, agenda_address2, agenda_address3,  agenda_postalCode, agenda_note) 
VALUES
	(1, 'contato1', '9-9999-9999', 'email@gemail.com', 'address1', 'address2', ' address3', '0999-99', 'blablabla'),
	(2, 'contato1', '9-9999-9999', 'email@gemail.com', 'address1', 'address2', ' address3', '0999-99', 'blablabla'),
	(3, 'contato1', '9-9999-9999', 'email@gemail.com', 'address1', 'address2', ' address3', '0999-99', 'blablabla'),
	(4, 'contato1', '9-9999-9999', 'email@gemail.com', 'address1', 'address2', ' address3', '0999-99', 'blablabla'),
	(5, 'contato1', '9-9999-9999', 'email@gemail.com', 'address1', 'address2', ' address3', '0999-99', 'blablabla'),
	(6, 'contato1', '9-9999-9999', 'email@gemail.com', 'address1', 'address2', ' address3', '0999-99', 'blablabla'),
	(7, 'contato1', '9-9999-9999', 'email@gemail.com', 'address1', 'address2', ' address3', '0999-99', 'blablabla'),
	(8, 'contato1', '9-9999-9999', 'email@gemail.com', 'address1', 'address2', ' address3', '0999-99', 'blablabla'),
	(9, 'contato1', '9-9999-9999', 'email@gemail.com', 'address1', 'address2', ' address3', '0999-99', 'blablabla'),
	(10, 'contato1', '9-9999-9999', 'email@gemail.com', 'address1', 'address2', ' address3', '0999-99', 'blablabla'),
	(11, 'contato1', '9-9999-9999', 'email@gemail.com', 'address1', 'address2', ' address3', '0999-99', 'blablabla'),
	(12, 'contato1', '9-9999-9999', 'email@gemail.com', 'address1', 'address2', ' address3', '0999-99', 'blablabla'),		
	(13, 'contato1', '9-9999-9999', 'email@gemail.com', 'address1', 'address2', ' address3', '0999-99', 'blablabla');

-- ***********************************************************************************************
-- Create table: CONTACTS
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
	VALUES(1,'Fornecedor 1','Endereço 1', '9-9999-9999', 2, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES(2,'Fornecedor 2','Endereço 2', '9-9999-9999', 2, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES(3,'Fornecedor 3','Endereço 3', '9-9999-9999', 2, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);

INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES(4,'Cliente 1','Endereço 4', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES(5,'Cliente 2','Endereço 5', '9-9999-9999', 2, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES(6,'Cliente 3','Endereço 6', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);

INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES(7,'Empregado 1','Endereço 7', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES(8,'Empregado 2','Endereço 8', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES(9,'Empregado 3','Endereço 9', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);

INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES(10,'MANAGER','Endereço 10', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES(11,'EMPLOYEE','Endereço 11', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);

INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES(13,'Loja 1','Endereço 13', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES(14,'Loja 2','Endereço 14', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_createdon, contact_changedon)
	VALUES(15,'Loja 3','Endereço 15', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);

-- ***********************************************************************************************
-- Create table: ROLES
-- ***********************************************************************************************   
CREATE TABLE ROLES (
	role_ID INT NOT NULL auto_increment,
	role_name VARCHAR(50) NOT NULL,
	PRIMARY KEY (role_ID)
);

INSERT INTO ROLES(role_ID, role_name) 
VALUES
	(1, 'ROLE_MANAGER'),
	(2, 'ROLE_CUSTOMER'), 
	(3, 'ROLE_VENDOR'),
	(4, 'ROLE_SHIPPER'),
	(5, 'ROLE_RECEIVER'),
	(6, 'ROLE_PURCHASER'),
	(7, 'ROLE_SELLER'),
	(8, 'ROLE_STOCKHOLDER'),
	(9, 'ROLE_USER');    

-- ***********************************************************************************************
-- Create table: USERS
-- ***********************************************************************************************
CREATE TABLE USERS (
	user_ID INT auto_increment,
	user_name VARCHAR(50),
	user_email VARCHAR(50),    
	user_password VARCHAR(128),     
	user_firstName VARCHAR(50),
    user_lastName VARCHAR(50),    
	user_status BOOLEAN,    
	user_roleID INT,
	PRIMARY KEY (user_id),
	FOREIGN KEY (user_roleID) REFERENCES ROLES(role_ID)
);

-- password 12345 = $2a$10$f1XHZXpdECjp5C977Y6GtuSwtL1ZwiXHxJFgHP9AgtzBxVwpMRC/e
SET @password = "$2a$10$f1XHZXpdECjp5C977Y6GtuSwtL1ZwiXHxJFgHP9AgtzBxVwpMRC/e";

INSERT INTO USERS(user_ID, user_name, user_email, user_password, user_firstName, user_lastName,  user_status, user_roleID)
VALUES
	(1, 'MANAGER', 'manager@gmail.com',  @password, 'Manager First Name', 'Manager Last Name', true, 1),
	(2, 'CUSTOMER', 'customer@gmail.com', @password, 'Customer First Name', 'Customer Last Name', true, 2),
	(3, 'VENDOR', 'vendor@gmail.com', @password, 'Vendor First Name', 'Vendor Last Name', true, 3),
	(4, 'SHIPPER', 'shipper@gmail.com',  @password, 'Shipper First Name', 'Shipper Last Name', true, 4),
	(5, 'RECEIVER', 'receiver@gmail.com',  @password, 'Receiver First Name', 'Receiver Last Name', true, 5),    
	(6, 'PURCHASER', 'purchaser@gmail.com',  @password, 'Purchaser First Name', 'Purchaser Last Name', true, 6),    
	(7, 'SELLER', 'seller@gmail.com',  @password, 'Seller First Name', 'Seller Last Name', true, 7),    
	(8, 'STOCKHOLDER', 'stockholder@gmail.com',  @password, 'Stockholder First Name', 'Stockholder Last Name', true, 8),    
	(9, 'USER', 'userModel@gmail.com',  @password, 'User First Name', 'User Last Name', true, 9);

-- ***********************************************************************************************
-- Create table: VENDORS
-- ***********************************************************************************************
CREATE TABLE VENDORS (
	vendor_ID INT NOT NULL auto_increment,
	vendor_contactID INT NOT NULL,
	vendor_status BOOLEAN NOT NULL,
	vendor_createdon DATE NOT NULL,
	vendor_changedon DATE NOT NULL,
	PRIMARY KEY (vendor_ID),
	FOREIGN KEY (vendor_ContactID) REFERENCES CONTACTS(contact_ID)
);

INSERT INTO VENDORS(vendor_ID, vendor_contactID, vendor_status, vendor_createdon, vendor_changedon) 
	VALUES(1, 1,true, @created, @changed);
INSERT INTO VENDORS(vendor_ID, vendor_contactID, vendor_status, vendor_createdon, vendor_changedon) 
	VALUES(2, 2,true, @created, @changed);
INSERT INTO VENDORS(vendor_ID, vendor_contactID, vendor_status, vendor_createdon, vendor_changedon) 
	VALUES(3, 3,true, @created, @changed);

-- ***********************************************************************************************
-- Create table: CUSTOMERS
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
	VALUES(1, 4,true, @created, @changed);
INSERT INTO CUSTOMERS(customer_ID, customer_contactID, customer_status, customer_createdon, customer_changedon) 
	VALUES(2, 5,true, @created, @changed);
INSERT INTO CUSTOMERS(customer_ID, customer_contactID, customer_status, customer_createdon, customer_changedon) 
	VALUES(3, 6,true, @created, @changed);

-- ***********************************************************************************************
-- Create table: STORES
-- ***********************************************************************************************
CREATE TABLE STORES (
	store_ID INT NOT NULL auto_increment,
	store_contactID INT NOT NULL,
	store_status BOOLEAN NOT NULL,
	store_createdon DATE NOT NULL,
	store_changedon DATE NOT NULL,
	PRIMARY KEY (store_ID),
	FOREIGN KEY (store_ContactID) REFERENCES CONTACTS(contact_ID)
);

INSERT INTO STORES(store_ID, store_contactID,  store_status, store_createdon, store_changedon) 
	VALUES(1, 13, true, @created, @changed);
INSERT INTO STORES(store_ID, store_contactID, store_status, store_createdon, store_changedon) 
	VALUES(2, 14, true, @created, @changed);
INSERT INTO STORES(store_ID,  store_contactID, store_status, store_createdon, store_changedon) 
	VALUES(3, 15, true, @created, @changed);

-- ***********************************************************************************************
-- Create table: PRODUCTS
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
 	VALUES(1, 'Banana', '123456789012', 'UN', true, 10, @created, @changed);
INSERT INTO PRODUCTS(product_ID, product_name, product_ean, product_unity, product_status, product_price, product_createdon, product_changedon) 
 	VALUES(2, 'Batata', '123456789012', 'UN', true, 10, @created, @changed);
INSERT INTO PRODUCTS(product_ID, product_name, product_ean, product_unity, product_status, product_price, product_createdon, product_changedon) 
 	VALUES(3, 'Cenoura', '123456789012', 'UN', true, 10, @created, @changed);
INSERT INTO PRODUCTS(product_ID, product_name, product_ean, product_unity, product_status, product_price, product_createdon, product_changedon) 
 	VALUES(4, 'Damasco', '123456789012', 'UN', true, 10, @created, @changed);
INSERT INTO PRODUCTS(product_ID, product_name, product_ean, product_unity, product_status, product_price, product_createdon, product_changedon) 
 	VALUES(5, 'Framboesa', '123456789012', 'UN', true, 10, @created, @changed);
INSERT INTO PRODUCTS(product_ID, product_name, product_ean, product_unity, product_status, product_price, product_createdon, product_changedon) 
	VALUES(6, 'Maçã', '123456789012', 'UN', true, 10, @created, @changed);
INSERT INTO PRODUCTS(product_ID, product_name, product_ean, product_unity, product_status, product_price, product_createdon, product_changedon) 
 	VALUES(7, 'Melância', '123456789012', 'UN', true, 10, @created, @changed);
INSERT INTO PRODUCTS(product_ID, product_name, product_ean, product_unity, product_status, product_price, product_createdon, product_changedon) 
 	VALUES(8, 'Mirtilo', '123456789012', 'UN', true, 10, @created, @changed);
INSERT INTO PRODUCTS(product_ID, product_name, product_ean, product_unity, product_status, product_price, product_createdon, product_changedon) 
 	VALUES(9, 'Morango', '123456789012', 'UN',true, 10, @created, @changed);
INSERT INTO PRODUCTS(product_ID, product_name, product_ean, product_unity, product_status, product_price, product_createdon, product_changedon) 
 	VALUES(10, 'Pepino', '123456789012', 'UN',true, 10, @created, @changed);
INSERT INTO PRODUCTS(product_ID, product_name, product_ean, product_unity, product_status, product_price, product_createdon, product_changedon) 
    VALUES(11, 'Pera', '123456789012', 'UN', true, 10, @created, @changed);
INSERT INTO PRODUCTS(product_ID, product_name, product_ean, product_unity, product_status, product_price, product_createdon, product_changedon) 
 	VALUES(12, 'Uva', '123456789012', 'UN', true, 10, @created, @changed);

-- ***********************************************************************************************
-- Create table: STOCKS
-- ***********************************************************************************************
CREATE TABLE STOCKS (
	stock_ID INT NOT NULL auto_increment,
	stock_storeID INT NOT NULL,
	stock_productID INT NOT NULL,
	stock_amount DECIMAL NOT NULL,
	stock_expiration DATE NOT NULL,
	stock_createdon DATE NOT NULL,
	stock_changedon DATE NOT NULL,
	PRIMARY KEY (stock_ID),
	FOREIGN KEY (stock_storeID) REFERENCES STORES(store_ID),
	FOREIGN KEY (stock_productID) REFERENCES PRODUCTS(product_ID)
);

INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_expiration, stock_createdon, stock_changedon)
	VALUES(1, 1, 1, 1000, @expiration, @created, @changed);
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_expiration, stock_createdon, stock_changedon)
	VALUES(2, 1, 2, 2000, @expiration, @created, @changed);
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_expiration, stock_createdon, stock_changedon)
	VALUES(3, 1, 3, 3000, @expiration, @created, @changed);
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_expiration, stock_createdon, stock_changedon)
	VALUES(4, 2, 4, 4000, @expiration, @created, @changed);
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_expiration, stock_createdon, stock_changedon)
	VALUES(5, 2, 5, 5000, @expiration, @created, @changed);
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_expiration, stock_createdon, stock_changedon)
	VALUES(6, 2, 6, 6000, @expiration, @created, @changed);
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_expiration, stock_createdon, stock_changedon)
	VALUES(7, 3, 7, 7000, @expiration, @created, @changed);
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_expiration, stock_createdon, stock_changedon)
	VALUES(8, 3, 8, 8000, @expiration, @created, @changed);
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_expiration, stock_createdon, stock_changedon)
	VALUES(9, 3, 9, 9000, @expiration, @created, @changed);
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_expiration, stock_createdon, stock_changedon)
	VALUES(10, 3, 10, 10000, @expiration, @created, @changed);

-- ***********************************************************************************************
-- Create table: SALES (OLD ONE WITHOUT ITENS)
-- ***********************************************************************************************
CREATE TABLE SALES (
	sale_ID INT NOT NULL auto_increment,
	sale_storeID INT NOT NULL,
	sale_customerID INT NOT NULL,
	sale_productID INT NOT NULL,
	sale_amount DECIMAL NOT NULL,
	sale_createdon DATE NOT NULL,
	sale_changedon DATE NOT NULL,
	PRIMARY KEY (sale_ID),
	FOREIGN KEY (sale_storeID) REFERENCES STORES(store_ID),
	FOREIGN KEY (sale_customerID) REFERENCES CUSTOMERS(customer_ID),
	FOREIGN KEY (sale_productID) REFERENCES PRODUCTS(product_ID)
);

INSERT INTO SALES(sale_ID, sale_storeID, sale_customerID, sale_productID, sale_amount, sale_createdon, sale_changedon) 
	VALUES(1, 1, 1, 1, 1000, @created, @changed);
INSERT INTO SALES(sale_ID, sale_storeID, sale_customerID, sale_productID, sale_amount, sale_createdon, sale_changedon) 
	VALUES(2, 2, 2, 2, 1000, @created, @changed);
INSERT INTO SALES(sale_ID, sale_storeID, sale_customerID, sale_productID, sale_amount, sale_createdon, sale_changedon) 
	VALUES(3, 3, 3, 3, 1000, @created, @changed);
INSERT INTO SALES(sale_ID, sale_storeID, sale_customerID, sale_productID, sale_amount, sale_createdon, sale_changedon) 
	VALUES(4, 1, 1, 4, 1000, @created, @changed);
INSERT INTO SALES(sale_ID, sale_storeID, sale_customerID, sale_productID, sale_amount, sale_createdon, sale_changedon) 
	VALUES(5, 2, 2, 5, 1000, @created, @changed);
INSERT INTO SALES(sale_ID, sale_storeID, sale_customerID, sale_productID, sale_amount, sale_createdon, sale_changedon) 
	VALUES(6, 3, 3, 6, 1000, @created, @changed);
INSERT INTO SALES(sale_ID, sale_storeID, sale_customerID, sale_productID, sale_amount, sale_createdon, sale_changedon) 
	VALUES(7, 1, 1, 7, 1000, @created, @changed);
INSERT INTO SALES(sale_ID, sale_storeID, sale_customerID, sale_productID, sale_amount, sale_createdon, sale_changedon) 
	VALUES(8, 2, 2, 8, 1000, @created, @changed);
INSERT INTO SALES(sale_ID, sale_storeID, sale_customerID, sale_productID, sale_amount, sale_createdon, sale_changedon) 
	VALUES(9, 3, 3, 9, 1000, @created, @changed);
INSERT INTO SALES(sale_ID, sale_storeID, sale_customerID, sale_productID, sale_amount, sale_createdon, sale_changedon) 
	VALUES(10, 3, 3, 10, 1000, @created, @changed);

-- ***********************************************************************************************
-- Create table: PURCHASES (OLD ONE WITHOUT ITENS)
-- ***********************************************************************************************
CREATE TABLE PURCHASES (
	purchase_ID INT NOT NULL auto_increment,
	purchase_storeID INT NOT NULL,
	purchase_vendorID INT NOT NULL,
	purchase_productID INT NOT NULL,
	purchase_amount DECIMAL NOT NULL,
	purchase_createdon DATE NOT NULL,
	purchase_changedon DATE NOT NULL,
	PRIMARY KEY (purchase_ID),
	FOREIGN KEY (purchase_storeID) REFERENCES STORES(store_ID),
	FOREIGN KEY (purchase_vendorID) REFERENCES VENDORS(vendor_ID),
	FOREIGN KEY (purchase_productID) REFERENCES PRODUCTS(product_ID)
);

INSERT INTO PURCHASES(purchase_ID, purchase_storeID, purchase_vendorID, purchase_productID, purchase_amount, purchase_createdon, purchase_changedon) 
	VALUES(1, 1, 1, 1, 1000, @created, @changed);
INSERT INTO PURCHASES(purchase_ID, purchase_storeID, purchase_vendorID, purchase_productID, purchase_amount, purchase_createdon, purchase_changedon) 
	VALUES(2, 2, 2, 2, 1000, @created, @changed);
INSERT INTO PURCHASES(purchase_ID, purchase_storeID, purchase_vendorID, purchase_productID, purchase_amount, purchase_createdon, purchase_changedon) 
	VALUES(3, 3, 3, 3, 1000, @created, @changed);
INSERT INTO PURCHASES(purchase_ID, purchase_storeID, purchase_vendorID, purchase_productID, purchase_amount, purchase_createdon, purchase_changedon) 
	VALUES(4, 1, 1, 4, 1000, @created, @changed);
INSERT INTO PURCHASES(purchase_ID, purchase_storeID, purchase_vendorID, purchase_productID, purchase_amount, purchase_createdon, purchase_changedon) 
	VALUES(5, 2, 2, 5, 1000, @created, @changed);
INSERT INTO PURCHASES(purchase_ID, purchase_storeID, purchase_vendorID, purchase_productID, purchase_amount, purchase_createdon, purchase_changedon) 
	VALUES(6, 3, 3, 6, 1000, @created, @changed);
INSERT INTO PURCHASES(purchase_ID, purchase_storeID, purchase_vendorID, purchase_productID, purchase_amount, purchase_createdon, purchase_changedon) 
	VALUES(7, 1, 1, 7, 1000, @created, @changed);
INSERT INTO PURCHASES(purchase_ID, purchase_storeID, purchase_vendorID, purchase_productID, purchase_amount, purchase_createdon, purchase_changedon) 
	VALUES(8, 2, 2, 8, 1000, @created, @changed);
INSERT INTO PURCHASES(purchase_ID, purchase_storeID, purchase_vendorID, purchase_productID, purchase_amount, purchase_createdon, purchase_changedon) 
	VALUES(9, 3, 3, 9, 1000, @created, @changed);
INSERT INTO PURCHASES(purchase_ID, purchase_storeID, purchase_vendorID, purchase_productID, purchase_amount, purchase_createdon, purchase_changedon) 
	VALUES(10, 3, 3, 10, 1000, @created, @changed);

-- ***********************************************************************************************
-- Create table: SALES ORDERS
-- ***********************************************************************************************
create table ORDERS
(
  ID               VARCHAR(50) not null auto_increment,
  AMOUNT           double precision not null,
  CUSTOMER_ADDRESS VARCHAR(255) not null,
  CUSTOMER_EMAIL   VARCHAR(128) not null,
  CUSTOMER_NAME    VARCHAR(255) not null,
  CUSTOMER_PHONE   VARCHAR(128) not null,
  ORDER_DATE       datetime not null,
  ORDER_NUM        INT not null
) ;
alter table ORDERS
  add primary key (ID);
alter table ORDERS
  add constraint ORDER_UK unique (ORDER_NUM);

-- ***********************************************************************************************
-- Create table: SALES ORDER DETAILS
-- ***********************************************************************************************
create table ORDER_DETAILS
(
  ID         VARCHAR(50) not null auto_increment,
  AMOUNT     double precision not null,
  PRICE      double precision not null,
  QUANITY    INT not null,
  ORDER_ID   VARCHAR(50) not null,
  PRODUCT_ID INT not null
) ;
--  
alter table ORDER_DETAILS
  add primary key (ID);
alter table ORDER_DETAILS
  add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID)
  references ORDERS (ID);
alter table ORDER_DETAILS
  add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID)
  references PRODUCTS (product_ID);
    
-- ***********************************************************************************************
-- Print data from tables
-- ***********************************************************************************************
SELECT * FROM SALES;
SELECT * FROM PURCHASES;
SELECT * FROM ORDER_DETAILS;
SELECT * FROM ORDERS;

SELECT * FROM STOCKS;
SELECT * FROM STORES;
SELECT * FROM PRODUCTS;

SELECT * FROM CUSTOMERS;
SELECT * FROM VENDORS;
SELECT * FROM USERS;
SELECT * FROM ROLES;
SELECT * FROM CONTACTS;
SELECT * FROM AGENDA;
