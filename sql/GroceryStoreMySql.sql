-- ***********************************************************************************************
-- Author: Rosemeire Deconti
-- Date: 01/06/2021
-- Project: Develop an application to control stocks and e-commerce from a Grocery 
-- suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
-- ***********************************************************************************************
USE groceryStore;

-- ***********************************************************************************************
-- Declare date to be used in table creations
-- ***********************************************************************************************
SET @created = CURRENT_DATE();
SET @changed = CURRENT_DATE();
SET @expiration = CURRENT_DATE();

-- ***********************************************************************************************
-- Drop tables
-- ***********************************************************************************************
DROP TABLE IF EXISTS SALES;
DROP TABLE IF EXISTS PURCHASES;
DROP TABLE IF EXISTS STOCKS;
DROP TABLE IF EXISTS STORES;
DROP TABLE IF EXISTS PRODUCTS;
DROP TABLE IF EXISTS CUSTOMERS;
DROP TABLE IF EXISTS VENDORS;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS USERS1;
DROP TABLE IF EXISTS ROLES;
DROP TABLE IF EXISTS CONTACTS;
DROP TABLE IF EXISTS IMAGES;
DROP TABLE IF EXISTS AGENDA;

-- ***********************************************************************************************
-- Create table: AGENDA
-- ***********************************************************************************************
CREATE TABLE AGENDA (
	agenda_ID BIGINT NOT NULL auto_increment,
	agenda_name VARCHAR (50) NOT NULL,
	agenda_phone VARCHAR (50) NOT NULL,  
	agenda_email VARCHAR (255) NOT NULL,    
	agenda_address1 VARCHAR (255) NOT NULL,
	agenda_address2 VARCHAR (255) NOT NULL,
	agenda_address3 VARCHAR (255) NOT NULL,
	agenda_postalCode VARCHAR(20) NOT NULL DEFAULT '99999-99',
	agenda_note VARCHAR (14) NULL,
	PRIMARY KEY (agenda_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
-- Create table: IMAGES
-- ***********************************************************************************************
CREATE TABLE IMAGES (
	image_ID BIGINT NOT NULL AUTO_INCREMENT,
	image_name VARCHAR(250) NOT NULL,
	image_picture BLOB,
	image_created DATETIME NULL,
	image_changed DATETIME NULL,
	PRIMARY KEY (image_ID),
	INDEX idx_image_name (image_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO IMAGES(image_ID, image_name, image_picture, image_created, image_changed)
VALUES
	(1,'banana', load_file('/img/banana.jpg'), @created, @changed),
    (2,'batata', load_file('/img/banana.jpg'), @created, @changed),
    (3,'ceoura', load_file('c:\img\banana.jpg'), @created, @changed),
    (4,'damasco', load_file('c:\img\banana.jpg'), @created, @changed),
    (5,'framboesa', load_file('c:\img\banana.jpg'), @created, @changed),
    (6,'maça', load_file('c:\img\banana.jpg'), @created, @changed),
    (7,'melância', load_file('c:\img\banana.jpg'), @created, @changed),
    (8,'mirtilo', load_file('c:\img\banana.jpg'), @created, @changed),
    (9,'morango', load_file('c:\img\banana.jpg'), @created, @changed),
    (10,'pepino', load_file('c:\img\banana.jpg'), @created, @changed),
	(11,'pera', load_file('c:\img\banana.jpg'), @created, @changed),
	(12,'uva', load_file('c:\img\banana.jpg'), @created, @changed);
    
-- LOAD_FILE('C:/Users/adity/Desktop/New folder/a.png')

-- ***********************************************************************************************
-- Create table: CONTACTS
-- ***********************************************************************************************
CREATE TABLE CONTACTS (
	contact_ID BIGINT NOT NULL auto_increment,
	contact_name VARCHAR (50) NOT NULL,
	contact_address VARCHAR (255) NOT NULL,
	contact_phone VARCHAR (50) NOT NULL,
	contact_type INT NOT NULL,
	contact_document VARCHAR (14) NULL,
	contact_status BOOLEAN NOT NULL,
	contact_email VARCHAR (255) NOT NULL,
	contact_created DATE NOT NULL,
	contact_changed DATE NOT NULL,
	PRIMARY KEY (contact_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO CONTACTS(contact_ID, contact_name, contact_address, contact_phone, contact_type, contact_document, contact_status, contact_email, contact_created, contact_changed)
VALUES
	(1,'Fornecedor 1','Endereço 1', '9-9999-9999', 2, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(2,'Fornecedor 2','Endereço 2', '9-9999-9999', 2, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(3,'Fornecedor 3','Endereço 3', '9-9999-9999', 2, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(4,'Cliente 1','Endereço 4', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(5,'Cliente 2','Endereço 5', '9-9999-9999', 2, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(6,'Cliente 3','Endereço 6', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(7,'Empregado 1','Endereço 7', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(8,'Empregado 2','Endereço 8', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(9,'Empregado 3','Endereço 9', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(10,'MANAGER','Endereço 10', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(11,'EMPLOYEE','Endereço 11', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(13,'Loja 1','Endereço 13', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(14,'Loja 2','Endereço 14', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed),
	(15,'Loja 3','Endereço 15', '9-9999-9999', 1, '99999999999999', true, 'fakeEmail@gmail.com', @created, @changed);

-- ***********************************************************************************************
-- Create table: ROLES
-- ***********************************************************************************************   
CREATE TABLE ROLES (
	role_ID BIGINT NOT NULL auto_increment,
	role_name VARCHAR(50) NOT NULL,
	PRIMARY KEY (role_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO ROLES(role_ID, role_name) 
VALUES
	(1, 'ROLE_MANAGER'),
	(2, 'ROLE_PURCHASER'),
	(3, 'ROLE_SELLER'),
	(4, 'ROLE_STOCKER'),
	(5, 'ROLE_USER');

-- ***********************************************************************************************
-- Create table: USERS
-- ***********************************************************************************************
CREATE TABLE USERS (
	user_ID BIGINT auto_increment,
	user_name VARCHAR(50),
	user_email VARCHAR(50),    
	user_password VARCHAR(128),       
	user_status BOOLEAN,    
	user_role VARCHAR(50),
	user_firstName VARCHAR(50),
    user_lastName VARCHAR(50),  
	PRIMARY KEY (user_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- password 12345 = $2a$10$f1XHZXpdECjp5C977Y6GtuSwtL1ZwiXHxJFgHP9AgtzBxVwpMRC/e
SET @password = "$2a$10$f1XHZXpdECjp5C977Y6GtuSwtL1ZwiXHxJFgHP9AgtzBxVwpMRC/e";

INSERT INTO USERS(user_ID, user_name, user_email, user_password, user_status, user_role, user_firstName, user_lastName)
VALUES
	(1, 'MANAGER', 'manager@gmail.com',  @password, true, 'ROLE_MANAGER', 'Manager First Name', 'Manager Last Name'),
	(2, 'PURCHASER', 'purchaser@gmail.com',  @password, true, 'ROLE_PURCHASER', 'Purchaser First Name', 'Purchaser Last Name'),    
	(3, 'SELLER', 'seller@gmail.com',  @password, true, 'ROLE_SELLER', 'Seller First Name', 'Seller Last Name'),      
	(4, 'STOCKER', 'stocker@gmail.com',  @password, true, 'ROLE_STOCKER', 'Stocker First Name', 'Stocker Last Name'),  
	(5, 'USER', 'userModel@gmail.com',  @password, true, 'ROLE_USER', 'User First Name', 'User Last Name');
    
-- ***********************************************************************************************
-- Create table: USERS1
-- ***********************************************************************************************
CREATE TABLE USERS1 (
	user_ID BIGINT auto_increment,
	user_name VARCHAR(50),
	user_email VARCHAR(50),    
	user_password VARCHAR(128),     
	user_firstName VARCHAR(50),
    user_lastName VARCHAR(50),    
	user_status BOOLEAN,    
	user_roleID BIGINT,
	PRIMARY KEY (user_ID),
	FOREIGN KEY (user_roleID) REFERENCES ROLES(role_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- password 12345 = $2a$10$f1XHZXpdECjp5C977Y6GtuSwtL1ZwiXHxJFgHP9AgtzBxVwpMRC/e
SET @password = "$2a$10$f1XHZXpdECjp5C977Y6GtuSwtL1ZwiXHxJFgHP9AgtzBxVwpMRC/e";

INSERT INTO USERS1(user_ID, user_name, user_email, user_password, user_firstName, user_lastName,  user_status, user_roleID)
VALUES
	(1, 'MANAGER', 'manager@gmail.com',  @password, 'Manager First Name', 'Manager Last Name', true, 1),
	(2, 'PURCHASER', 'purchaser@gmail.com',  @password, 'Purchaser First Name', 'Purchaser Last Name', true, 2),    
	(3, 'SELLER', 'seller@gmail.com',  @password, 'Seller First Name', 'Seller Last Name', true, 3),      
	(4, 'STOCKER', 'stocker@gmail.com',  @password, 'Stocker First Name', 'Stocker Last Name', true, 4),  
	(5, 'USER', 'userModel@gmail.com',  @password, 'User First Name', 'User Last Name', true, 5);

-- ***********************************************************************************************
-- Create table: VENDORS
-- ***********************************************************************************************
CREATE TABLE VENDORS (
	vendor_ID BIGINT NOT NULL auto_increment,
	vendor_contactID BIGINT NOT NULL,
	vendor_status BOOLEAN NOT NULL,
	vendor_created DATE NOT NULL,
	vendor_changed DATE NOT NULL,
	PRIMARY KEY (vendor_ID),
	FOREIGN KEY (vendor_ContactID) REFERENCES CONTACTS(contact_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO VENDORS(vendor_ID, vendor_contactID, vendor_status, vendor_created, vendor_changed)
VALUES
	(1, 1,true, @created, @changed),
	(2, 2,true, @created, @changed),
	(3, 3,true, @created, @changed);

-- ***********************************************************************************************
-- Create table: CUSTOMERS
-- ***********************************************************************************************
CREATE TABLE CUSTOMERS (
	customer_ID BIGINT NOT NULL auto_increment,
	customer_contactID BIGINT NOT NULL,
	customer_status BOOLEAN NOT NULL,
	customer_created DATE NOT NULL,
	customer_changed DATE NOT NULL,
	PRIMARY KEY (customer_ID),
	FOREIGN KEY (customer_ContactID) REFERENCES CONTACTS(contact_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO CUSTOMERS(customer_ID, customer_contactID, customer_status, customer_created, customer_changed) 
	VALUES(1, 4,true, @created, @changed);
INSERT INTO CUSTOMERS(customer_ID, customer_contactID, customer_status, customer_created, customer_changed) 
	VALUES(2, 5,true, @created, @changed);
INSERT INTO CUSTOMERS(customer_ID, customer_contactID, customer_status, customer_created, customer_changed) 
	VALUES(3, 6,true, @created, @changed);

-- ***********************************************************************************************
-- Create table: STORES
-- ***********************************************************************************************
CREATE TABLE STORES (
	store_ID BIGINT NOT NULL auto_increment,
	store_contactID BIGINT NOT NULL,
	store_status BOOLEAN NOT NULL,
	store_created DATE NOT NULL,
	store_changed DATE NOT NULL,
	PRIMARY KEY (store_ID),
	FOREIGN KEY (store_ContactID) REFERENCES CONTACTS(contact_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO STORES(store_ID, store_contactID,  store_status, store_created, store_changed)
VALUES
	(1, 13, true, @created, @changed),
	(2, 14, true, @created, @changed),
	(3, 15, true, @created, @changed);

-- ***********************************************************************************************
-- Create table: PRODUCTS
-- ***********************************************************************************************
CREATE TABLE PRODUCTS (
	product_ID BIGINT NOT NULL auto_increment,
	product_name VARCHAR (50) NOT NULL,
	product_ean VARCHAR (13) NOT NULL,
	product_unity VARCHAR (3) NOT NULL,
	product_status BOOLEAN NOT NULL,
	product_image BLOB,
	product_price double precision not null,
	product_created DATE NOT NULL,
	product_changed DATE NOT NULL,
	PRIMARY KEY (product_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO PRODUCTS(product_ID, product_name, product_ean, product_unity, product_status, product_price, product_created, product_changed)
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
-- Create table: STOCKS
-- ***********************************************************************************************
CREATE TABLE STOCKS (
	stock_ID BIGINT NOT NULL auto_increment,
	stock_storeID BIGINT NOT NULL,
	stock_productID BIGINT NOT NULL,
	stock_amount DECIMAL NOT NULL,
	stock_expiration DATE NOT NULL,
	stock_created DATE NOT NULL,
	stock_changed DATE NOT NULL,
	PRIMARY KEY (stock_ID),
	FOREIGN KEY (stock_storeID) REFERENCES STORES(store_ID),
	FOREIGN KEY (stock_productID) REFERENCES PRODUCTS(product_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_expiration, stock_created, stock_changed)
VALUES
	(1, 1, 1, 1000, @expiration, @created, @changed),
	(2, 1, 2, 2000, @expiration, @created, @changed),
	(3, 1, 3, 3000, @expiration, @created, @changed),
	(4, 2, 4, 4000, @expiration, @created, @changed),
	(5, 2, 5, 5000, @expiration, @created, @changed),
	(6, 2, 6, 6000, @expiration, @created, @changed),
	(7, 3, 7, 7000, @expiration, @created, @changed),
	(8, 3, 8, 8000, @expiration, @created, @changed),
	(9, 3, 9, 9000, @expiration, @created, @changed),
	(10, 3, 10, 10000, @expiration, @created, @changed);

-- ***********************************************************************************************
-- Create table: SALES (OLD ONE WITHOUT ITENS)
-- ***********************************************************************************************
CREATE TABLE SALES (
	sale_ID BIGINT NOT NULL auto_increment,
	sale_storeID BIGINT NOT NULL,
	sale_customerID BIGINT NOT NULL,
	sale_productID BIGINT NOT NULL,
	sale_amount DECIMAL NOT NULL,
	sale_price DECIMAL NOT NULL,
	sale_created DATE NOT NULL,
	sale_changed DATE NOT NULL,
	PRIMARY KEY (sale_ID),
	FOREIGN KEY (sale_storeID) REFERENCES STORES(store_ID),
	FOREIGN KEY (sale_customerID) REFERENCES CUSTOMERS(customer_ID),
	FOREIGN KEY (sale_productID) REFERENCES PRODUCTS(product_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO SALES(sale_ID, sale_storeID, sale_customerID, sale_productID, sale_amount, sale_price, sale_created, sale_changed) 
	VALUES
	(1, 1, 1, 1, 1000, 2000, @created, @changed),
	(2, 2, 2, 2, 1000, 2000, @created, @changed),
	(3, 3, 3, 3, 1000, 2000, @created, @changed),
	(4, 1, 1, 4, 1000, 2000, @created, @changed),
	(5, 2, 2, 5, 1000, 2000, @created, @changed),
	(6, 3, 3, 6, 1000, 2000, @created, @changed),
	(7, 1, 1, 7, 1000, 2000, @created, @changed),
	(8, 2, 2, 8, 1000, 2000, @created, @changed),
	(9, 3, 3, 9, 1000, 2000, @created, @changed),
	(10, 3, 3, 10, 1000, 2000, @created, @changed);

-- ***********************************************************************************************
-- Create table: PURCHASES (OLD ONE WITHOUT ITENS)
-- ***********************************************************************************************
CREATE TABLE PURCHASES (
	purchase_ID BIGINT NOT NULL auto_increment,
	purchase_storeID BIGINT NOT NULL,
	purchase_vendorID BIGINT NOT NULL,
	purchase_productID BIGINT NOT NULL,
	purchase_amount DECIMAL NOT NULL,
	purchase_price DECIMAL NOT NULL,
	purchase_created DATE NOT NULL,
	purchase_changed DATE NOT NULL,
	PRIMARY KEY (purchase_ID),
	FOREIGN KEY (purchase_storeID) REFERENCES STORES(store_ID),
	FOREIGN KEY (purchase_vendorID) REFERENCES VENDORS(vendor_ID),
	FOREIGN KEY (purchase_productID) REFERENCES PRODUCTS(product_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO PURCHASES(purchase_ID, purchase_storeID, purchase_vendorID, purchase_productID, purchase_amount, purchase_price, purchase_created, purchase_changed) 
	VALUES
    (1, 1, 1, 1, 1000, 2000, @created, @changed),
	(2, 2, 2, 2, 1000, 2000, @created, @changed),
	(3, 3, 3, 3, 1000, 2000, @created, @changed),
	(4, 1, 1, 4, 1000, 2000, @created, @changed),
	(5, 2, 2, 5, 1000, 2000, @created, @changed),
	(6, 3, 3, 6, 1000, 2000, @created, @changed),
	(7, 1, 1, 7, 1000, 2000, @created, @changed),
	(8, 2, 2, 8, 1000, 2000, @created, @changed),
	(9, 3, 3, 9, 1000, 2000, @created, @changed),
	(10, 3, 3, 10, 1000, 2000, @created, @changed);
    
-- ***********************************************************************************************
-- Print data from tables
-- ***********************************************************************************************
SELECT * FROM SALES;
SELECT * FROM PURCHASES;
SELECT * FROM STOCKS;
SELECT * FROM STORES;
SELECT * FROM PRODUCTS;
SELECT * FROM CUSTOMERS;
SELECT * FROM VENDORS;
SELECT * FROM USERS;
SELECT * FROM USERS1;
SELECT * FROM ROLES;
SELECT * FROM CONTACTS;
SELECT * FROM AGENDA;
