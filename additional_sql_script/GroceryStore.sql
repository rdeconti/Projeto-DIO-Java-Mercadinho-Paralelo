-- ***********************************************************************************************
-- Author: Rosemeire Deconti
-- Date: 01/06/2021
-- Idea from: Digital Innovation One - Bootcamp CodeAnywhere mentoring
-- Goal: Develop an application to control stocks and e-commerce from a Grocery
-- ***********************************************************************************************
-- Define database to be used
USE [GroceryStore]
GO

-- ***********************************************************************************************
-- Define permissions to user mercadinho manage all tables from database
-- ***********************************************************************************************
GRANT execute, select, insert, update, delete TO GroceryStore

-- ***********************************************************************************************
-- Declare date to be used in table creations
-- ***********************************************************************************************
DECLARE @created datetime = GETDATE();
DECLARE @changed datetime = GETDATE();
DECLARE @expiration datetime = GETDATE() + 365

-- ***********************************************************************************************
-- Drop tables
-- ***********************************************************************************************
DROP TABLE IF EXISTS STORES;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS EMPLOYEES;
DROP TABLE IF EXISTS CUSTOMERS;
DROP TABLE IF EXISTS VENDORS;
DROP TABLE IF EXISTS CONTACTS;
DROP TABLE IF EXISTS ROLES;
DROP TABLE IF EXISTS PRODUCTS;
DROP TABLE IF EXISTS STOCKS;



DROP TABLE IF EXISTS SALES;
DROP TABLE IF EXISTS PURCHASES;


DROP TABLE IF EXISTS ACCOUNTS;
DROP TABLE IF EXISTS PRODUCTS;
DROP TABLE IF EXISTS ORDER_DETAILS;
DROP TABLE IF EXISTS ORDERS;

-- ***********************************************************************************************
-- Create table: CONTACTS
-- ***********************************************************************************************
CREATE TABLE CONTACTS (
	contact_ID INT NOT NULL,
	contact_name VARCHAR (50) NOT NULL,
	contact_address VARCHAR (255) NOT NULL,
	contact_phone VARCHAR (50) NOT NULL,
	contact_type INT NOT NULL,
	contact_document VARCHAR (14) NULL,
	contact_status BIT NOT NULL,
	contact_createdon DATE NOT NULL,
	contact_changedon DATE NOT NULL,
	PRIMARY KEY (contact_ID),
);

INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(1,'Fornecedor 1','Endere�o 1', '9-9999-9999', 2, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(2,'Fornecedor 2','Endere�o 2', '9-9999-9999', 2, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(3,'Fornecedor 3','Endere�o 3', '9-9999-9999', 2, '99999999999999', 'True', @created, @changed)

INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(4,'Cliente 1','Endere�o 4', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(5,'Cliente 2','Endere�o 5', '9-9999-9999', 2, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(6,'Cliente 3','Endere�o 6', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)

INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(7,'Empregado 1','Endere�o 7', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(8,'Empregado 2','Endere�o 8', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(9,'Empregado 3','Endere�o 9', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)

INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(10,'Usu�rio 1','Endere�o 10', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(11,'Usu�rio 2','Endere�o 11', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(12,'Usu�rio 3','Endere�o 12', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)

INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(13,'Loja 1','Endere�o 13', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(14,'Loja 2','Endere�o 14', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(15,'Loja 3','Endere�o 15', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)

INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(16,'ADMINISTRATOR','Endere�o 16', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(17,'VENDOR','Endere�o 17', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(18,'CUSTOMER','Endere�o 18', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(19,'EMPLOYEE','Endere�o 19', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)
INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_createdon, contact_changedon) 
	VALUES(20,'USER','Endere�o 20', '9-9999-9999', 1, '99999999999999', 'True', @created, @changed)

-- ***********************************************************************************************
-- Create table: VENDORS
-- ***********************************************************************************************
CREATE TABLE VENDORS (
	vendor_ID INT NOT NULL,
	vendor_contactID INT NOT NULL,
	vendor_status BIT NOT NULL,
	vendor_createdon DATE NOT NULL,
	vendor_changedon DATE NOT NULL,
	PRIMARY KEY (vendor_ID),
	FOREIGN KEY (vendor_ContactID) REFERENCES CONTACTS(contact_ID)
);

INSERT INTO VENDORS(vendor_ID, vendor_contactID, vendor_status, vendor_createdon, vendor_changedon) 
	VALUES(1, 1,'True', @created, @changed)
INSERT INTO VENDORS(vendor_ID, vendor_contactID, vendor_status, vendor_createdon, vendor_changedon) 
	VALUES(2, 2,'True', @created, @changed)
INSERT INTO VENDORS(vendor_ID, vendor_contactID, vendor_status, vendor_createdon, vendor_changedon) 
	VALUES(3, 3,'True', @created, @changed)

-- ***********************************************************************************************
-- Create table: CUSTOMERS
-- ***********************************************************************************************
CREATE TABLE CUSTOMERS (
	customer_ID INT NOT NULL,
	customer_contactID INT NOT NULL,
	customer_status BIT NOT NULL,
	customer_createdon DATE NOT NULL,
	customer_changedon DATE NOT NULL,
	PRIMARY KEY (customer_ID),
	FOREIGN KEY (customer_ContactID) REFERENCES CONTACTS(contact_ID)
);

INSERT INTO CUSTOMERS(customer_ID, customer_contactID, customer_status, customer_createdon, customer_changedon) 
	VALUES(1, 4,'True', @created, @changed)
INSERT INTO CUSTOMERS(customer_ID, customer_contactID, customer_status, customer_createdon, customer_changedon) 
	VALUES(2, 5,'True', @created, @changed)
INSERT INTO CUSTOMERS(customer_ID, customer_contactID, customer_status, customer_createdon, customer_changedon) 
	VALUES(3, 6,'True', @created, @changed)

-- ***********************************************************************************************
-- Create table: EMPLOYESS
-- ***********************************************************************************************
CREATE TABLE EMPLOYEES (
	employee_ID INT NOT NULL,
	employee_contactID INT NOT NULL,
	employee_status BIT NOT NULL,
	employee_createdon DATE NOT NULL,
	employee_changedon DATE NOT NULL,
	PRIMARY KEY (employee_ID),
	FOREIGN KEY (employee_ContactID) REFERENCES CONTACTS(contact_ID)
);

INSERT INTO EMPLOYEES(employee_ID, employee_contactID, employee_status, employee_createdon, employee_changedon) 
	VALUES(1, 7,'True', @created, @changed)
INSERT INTO EMPLOYEES(employee_ID, employee_contactID, employee_status, employee_createdon, employee_changedon) 
	VALUES(2, 8,'True', @created, @changed)
INSERT INTO EMPLOYEES(employee_ID, employee_contactID, employee_status, employee_createdon, employee_changedon) 
	VALUES(3, 9,'True', @created, @changed)

-- ***********************************************************************************************
-- Create table: STORES
-- ***********************************************************************************************
CREATE TABLE STORES (
	store_ID INT NOT NULL,
	store_contactID INT NOT NULL,
	store_status BIT NOT NULL,
	store_createdon DATE NOT NULL,
	store_changedon DATE NOT NULL,
	PRIMARY KEY (store_ID),
	FOREIGN KEY (store_ContactID) REFERENCES CONTACTS(contact_ID),
);

INSERT INTO STORES(store_ID, store_contactID,  store_status, store_createdon, store_changedon) 
	VALUES(1, 13, 'TRUE', @created, @changed)
INSERT INTO STORES(store_ID, store_contactID, store_status, store_createdon, store_changedon) 
	VALUES(2, 14, 'TRUE', @created, @changed)
INSERT INTO STORES(store_ID,  store_contactID, store_status, store_createdon, store_changedon) 
	VALUES(3, 15, 'TRUE', @created, @changed)

-- ***********************************************************************************************
-- Create table: PRODUCTS
-- ***********************************************************************************************
CREATE TABLE PRODUCTS (
	product_ID INT NOT NULL,
	product_name VARCHAR (50) NOT NULL,
	product_validity DATE NOT NULL,
	product_ean VARCHAR (13) NOT NULL,
	product_unity VARCHAR (3) NOT NULL,
	product_status BIT NOT NULL,
	product_createdon DATE NOT NULL,
	product_changedon DATE NOT NULL,
	PRIMARY KEY (product_ID),
);

INSERT INTO PRODUCTS(product_ID, product_name, product_validity, product_ean, product_unity, product_status, product_createdon, product_changedon) 
	VALUES(1, 'Produto 1', @expiration, '123456789012', '1', 'TRUE', @created, @changed)
INSERT INTO PRODUCTS(product_ID, product_name, product_validity, product_ean, product_unity, product_status, product_createdon, product_changedon) 
	VALUES(2, 'Produto 1', @expiration, '123456789012', '1', 'TRUE', @created, @changed)
INSERT INTO PRODUCTS(product_ID, product_name, product_validity, product_ean, product_unity, product_status, product_createdon, product_changedon) 
	VALUES(3, 'Produto 1', @expiration, '123456789012', '1', 'TRUE', @created, @changed)
INSERT INTO PRODUCTS(product_ID, product_name, product_validity, product_ean, product_unity, product_status, product_createdon, product_changedon) 
	VALUES(4, 'Produto 1', @expiration, '123456789012', '1', 'TRUE', @created, @changed)
INSERT INTO PRODUCTS(product_ID, product_name, product_validity, product_ean, product_unity, product_status, product_createdon, product_changedon) 
	VALUES(5, 'Produto 1', @expiration, '123456789012', '1', 'TRUE', @created, @changed)
INSERT INTO PRODUCTS(product_ID, product_name, product_validity, product_ean, product_unity, product_status, product_createdon, product_changedon) 
	VALUES(6, 'Produto 1', @expiration, '123456789012', '1', 'TRUE', @created, @changed)
INSERT INTO PRODUCTS(product_ID, product_name, product_validity, product_ean, product_unity, product_status, product_createdon, product_changedon) 
	VALUES(7, 'Produto 1', @expiration, '123456789012', '1', 'TRUE', @created, @changed)
INSERT INTO PRODUCTS(product_ID, product_name, product_validity, product_ean, product_unity, product_status, product_createdon, product_changedon) 
	VALUES(8, 'Produto 1', @expiration, '123456789012', '1', 'TRUE', @created, @changed)
INSERT INTO PRODUCTS(product_ID, product_name, product_validity, product_ean, product_unity, product_status, product_createdon, product_changedon) 
	VALUES(9, 'Produto 1', @expiration, '123456789012', '1', 'TRUE', @created, @changed)
INSERT INTO PRODUCTS(product_ID, product_name, product_validity, product_ean, product_unity, product_status, product_createdon, product_changedon) 
	VALUES(10, 'Produto 1', @expiration, '123456789012', '1', 'TRUE', @created, @changed)

-- ***********************************************************************************************
-- Create table: STOCKS
-- ***********************************************************************************************
CREATE TABLE STOCKS (
	stock_ID INT NOT NULL,
	stock_storeID INT NOT NULL,
	stock_productID INT NOT NULL,
	stock_amount DECIMAL NOT NULL,
	stock_createdon DATE NOT NULL,
	stock_changedon DATE NOT NULL,
	PRIMARY KEY (stock_ID),
	FOREIGN KEY (stock_storeID) REFERENCES STORES(store_ID),
	FOREIGN KEY (stock_productID) REFERENCES PRODUCTS(product_ID),
);

INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_createdon, stock_changedon)
	VALUES(1, 1, 1, 1000, @created, @changed)
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_createdon, stock_changedon)
	VALUES(2, 1, 2, 2000, @created, @changed)
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_createdon, stock_changedon)
	VALUES(3, 1, 3, 3000, @created, @changed)
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_createdon, stock_changedon)
	VALUES(4, 2, 4, 4000, @created, @changed)
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_createdon, stock_changedon)
	VALUES(5, 2, 5, 5000, @created, @changed)
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_createdon, stock_changedon)
	VALUES(6, 2, 6, 6000, @created, @changed)
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_createdon, stock_changedon)
	VALUES(7, 3, 7, 7000, @created, @changed)
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_createdon, stock_changedon)
	VALUES(8, 3, 8, 8000, @created, @changed)
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_createdon, stock_changedon)
	VALUES(9, 3, 9, 9000, @created, @changed)
INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_createdon, stock_changedon)
	VALUES(10, 3, 10, 10000, @created, @changed)



























-- ***********************************************************************************************
-- Create table: ACCOUNTS
-- ***********************************************************************************************
create table ACCOUNTS
(
  USER_NAME VARCHAR(20) not null,
  ACTIVE    BIT not null,
  ENCRYTED_PASSWORD  VARCHAR(128) not null,
  USER_ROLE VARCHAR(20) not null
) ;
  
alter table ACCOUNTS
  add primary key (USER_NAME) ;

-- ***********************************************************************************************
-- Create table: PRODUCTS
-- ***********************************************************************************************
create table PRODUCTS
(
  CODE        VARCHAR(20) not null,
  IMAGE       image,
  NAME        VARCHAR(255) not null,
  PRICE       double precision not null,
  CREATE_DATE datetime not null
) ;
  
alter table PRODUCTS
  add primary key (CODE) ;

-- ***********************************************************************************************
-- Create table: SALES ORDERS
-- ***********************************************************************************************
create table ORDERS
(
  ID               VARCHAR(50) not null,
  AMOUNT           double precision not null,
  CUSTOMER_ADDRESS VARCHAR(255) not null,
  CUSTOMER_EMAIL   VARCHAR(128) not null,
  CUSTOMER_NAME    VARCHAR(255) not null,
  CUSTOMER_PHONE   VARCHAR(128) not null,
  ORDER_DATE       datetime not null,
  ORDER_NUM        INT not null
) ;
alter table ORDERS
  add primary key (ID) ;
alter table ORDERS
  add constraint ORDER_UK unique (ORDER_NUM) ;

-- ***********************************************************************************************
-- Create table: SALES ORDER DETAILS
-- ***********************************************************************************************
create table ORDER_DETAILS
(
  ID         VARCHAR(50) not null,
  AMOUNT     double precision not null,
  PRICE      double precision not null,
  QUANITY    INT not null,
  ORDER_ID   VARCHAR(50) not null,
  PRODUCT_ID VARCHAR(20) not null
) ;
--  
alter table ORDER_DETAILS
  add primary key (ID) ;
alter table ORDER_DETAILS
  add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID)
  references ORDERS (ID);
alter table ORDER_DETAILS
  add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID)
  references PRODUCTS (CODE);
  
-- ***********************************************************************************************
-- Create mock data: ACCOUNTS
-- ***********************************************************************************************
insert into Accounts (USER_NAME, ACTIVE, ENCRYTED_PASSWORD, USER_ROLE)
values ('employee1', 1,
'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_EMPLOYEE');
  
insert into Accounts (USER_NAME, ACTIVE, ENCRYTED_PASSWORD, USER_ROLE)
values ('manager1', 1,
'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_MANAGER');
  
-- ***********************************************************************************************
-- Create mock data: PRODUCTS
-- ***********************************************************************************************
insert into products (CODE, NAME, PRICE, CREATE_DATE)
values ('S001', 'Core Java', 100, CURRENT_TIMESTAMP  );
  
insert into products (CODE, NAME, PRICE, CREATE_DATE)
values ('S002', 'Spring for Beginners', 50, CURRENT_TIMESTAMP  );
 
insert into products (CODE, NAME, PRICE, CREATE_DATE)
values ('S003', 'Swift for Beginners', 120, CURRENT_TIMESTAMP  );
  
insert into products (CODE, NAME, PRICE, CREATE_DATE)
values ('S004', 'Oracle XML Parser', 120, CURRENT_TIMESTAMP  );
  
insert into products (CODE, NAME, PRICE, CREATE_DATE)
values ('S005', 'CSharp Tutorial for Beginers', 110, CURRENT_TIMESTAMP  );

-- ***********************************************************************************************
-- Print data from tables
-- ***********************************************************************************************
SELECT * FROM ACCOUNTS
SELECT * FROM ORDER_DETAILS
SELECT * FROM ORDERS
SELECT * FROM PRODUCTS
