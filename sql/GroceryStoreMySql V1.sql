﻿-- ***********************************************************************************************
-- Author: Rosemeire Deconti
-- Date: 01/06/2021
-- Project: Develop an application to control stocks and e-commerce from a Grocery 
-- suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
-- ***********************************************************************************************
USE groceryStore;

-- ***********************************************************************************************
-- Declare date to be used in table creations 
-- value 6 corresponding to role MASTERDATA
-- long texts generated with lorem ipsum
-- ***********************************************************************************************
SET @created_at = CURRENT_DATE();
SET @changed_at = CURRENT_DATE();
SET @birthdate = DATE_SUB(CURDATE(), INTERVAL 30 YEAR);
SET @expiration = CURDATE() + INTERVAL 360 DAY;
SET @created_by = 6; 
SET @changed_by = 6;
SET @describedBy = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eget felis eget diam varius mollis ut id urna. Sed ac leo non neque molestie auctor. Pellentesque condimentum arcu vitae facilisis cursus. Quisque id tincidunt metus. Nam ornare tempus sem, a commodo mauris sodales non. Mauris elementum dignissim sem. Mauris magna turpis, ullamcorper a rutrum vehicula, auctor ut libero. Etiam odio quam, efficitur et tempus feugiat, tincidunt a justo. Integer a erat aliquet, elementum neque at, accumsan lectus.';
SET @email = 'email@gmail.com';
SET @site = 'site@uol.com.br';
SET @facebook = 'https://www.facebook.com/facebook1';
SET @instagram = 'https://www.instagram.com/facebook1';
SET @linkedin = 'https://www.linkedin.com/facebook1';
SET @youtube = 'https://www.youtube.com/facebook1';

-- ***********************************************************************************************
-- Drop tables
-- ***********************************************************************************************
DROP TABLE IF EXISTS CARTS_ITEMS;				
DROP TABLE IF EXISTS CARTS;						 
DROP TABLE IF EXISTS SALES_ITEMS;
DROP TABLE IF EXISTS SALES;
DROP TABLE IF EXISTS PURCHASES_ITEMS;
DROP TABLE IF EXISTS PURCHASES;
DROP TABLE IF EXISTS MOVEMENTS;
DROP TABLE IF EXISTS STOCKS;
DROP TABLE IF EXISTS STORES;
DROP TABLE IF EXISTS PRODUCTS;
DROP TABLE IF EXISTS CUSTOMERS;
DROP TABLE IF EXISTS VENDORS;
DROP TABLE IF EXISTS EMPLOYEES;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS CONTACTS;
DROP TABLE IF EXISTS IMAGES;
   
-- ***********************************************************************************************
-- Create table: IMAGES
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE IMAGES (
	image_ID INT NOT NULL AUTO_INCREMENT,
	image_name VARCHAR(255) NOT NULL,
	image_url VARCHAR(255) NOT NULL,
	image_status BOOLEAN NOT NULL,
	image_created_at DATE NULL,
	image_changed_at DATE NULL,
	image_created_by INT NOT NULL,
	image_changed_by INT NOT NULL,
	PRIMARY KEY (image_ID),
	INDEX idx_image_name (image_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO IMAGES(image_ID, image_name, image_url, image_status, image_created_at, image_changed_at, image_created_by, image_changed_by)
VALUES
	(1,'banana', 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/banana.jpg', true, @created_at, @changed_at, @created_by, @changed_by),
    (2,'batata', 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/batata.jpg', true, @created_at, @changed_at, @created_by, @changed_by),
    (3,'ceoura', 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/cenoura.jpg', true, @created_at, @changed_at, @created_by, @changed_by),
    (4,'damasco', 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/damasco.jpg', true, @created_at, @changed_at, @created_by, @changed_by),
    (5,'framboesa', 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/framboesa.jpg', true, @created_at, @changed_at, @created_by, @changed_by),
    (6,'maça', 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/maca.jpg', true, @created_at, @changed_at, @created_by, @changed_by),
    (7,'melância', 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/melancia.jpg', true, @created_at, @changed_at, @created_by, @changed_by),
    (8,'mirtilo', 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/mirtilo.jpg', true, @created_at, @changed_at, @created_by, @changed_by),
    (9,'morango', 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/morango.jpg', true, @created_at, @changed_at, @created_by, @changed_by),
    (10,'pepino', 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/pepino.jpg', true, @created_at, @changed_at, @created_by, @changed_by),
	(11,'pera', 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/pera.jpg', true, @created_at, @changed_at, @created_by, @changed_by),
	(12,'uva', 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/uva.jpg', true, @created_at, @changed_at, @created_by, @changed_by);

-- ***********************************************************************************************
-- Create table: CONTACTS
-- type: 1 = RG, 2 = CPF, 3 = CNPJ
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE CONTACTS (
	contact_ID INT NOT NULL auto_increment,
	contact_name VARCHAR (255) NOT NULL,
	contact_email VARCHAR (255) NOT NULL,
    contact_country VARCHAR (255) NOT NULL,
    contact_state VARCHAR (255) NOT NULL,
    contact_city VARCHAR (255) NOT NULL,
    contact_district VARCHAR (255) NOT NULL,
	contact_address VARCHAR (255) NOT NULL,
    contact_number VARCHAR (255) NOT NULL,
    contact_cep VARCHAR (255) NOT NULL,
    contact_complement VARCHAR (255) NOT NULL,
	contact_phone_1 VARCHAR (255) NOT NULL,
	contact_phone_2 VARCHAR (255) NOT NULL,
	contact_whats_app VARCHAR (255) NOT NULL,
	contact_type INT NOT NULL,
	contact_document VARCHAR (255) NULL,
    contact_site VARCHAR (255) NULL,
    contact_facebook VARCHAR (255) NULL,
    contact_instagram VARCHAR (255) NULL,
    contact_linkedin VARCHAR (255) NULL,
    contact_youtube VARCHAR (255) NULL,
	contact_status BOOLEAN NOT NULL,
	contact_birthdate DATE NOT NULL,
	contact_created_at DATE NOT NULL,
	contact_changed_at DATE NOT NULL,
	contact_created_by INT NOT NULL,
	contact_changed_by INT NOT NULL,
	PRIMARY KEY (contact_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO CONTACTS(contact_ID, contact_name, contact_email, contact_country, contact_state, contact_city, contact_district, contact_address, contact_number, contact_cep, contact_complement, contact_phone_1, contact_phone_2, contact_whats_app, contact_type, contact_document, contact_site, contact_facebook, contact_instagram, contact_linkedin, contact_youtube, contact_status, contact_birthdate, contact_created_at, contact_changed_at, contact_created_by, contact_changed_by)
VALUES  

	(1, 'Fornecedor 1', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by),
	(2, 'Fornecedor 1', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by),
	(3, 'Fornecedor 2', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by),
	(4, 'Cliente 1', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by),
	(5, 'Cliente 2', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by),
	(6, 'Cliente 3', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by),
	(7, 'Empregado 1', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by),
	(8, 'Empregado 2', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by),
	(9, 'Empregado 3', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by),
	(10, 'MANAGER', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by),
	(11, 'EMPLOYEE', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by),
	(13, 'Loja 1', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by),
	(14, 'Loja 2', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by),
	(15, 'Loja 3', @email, 'País X', 'Estado X', 'Cidade X', 'Bairro X', 'Endereço X', '9999', '99999-999', 'Complemento 1', '9-9999-9999', '9-9999-9999', '9-9999-9999', 1, '99999999999999', 'site@xxx.com.br', @facebook, @instagram, @linkedin, @youtube, true, @birthdate, @created_at, @changed_at, @created_by, @changed_by);

-- ***********************************************************************************************
-- Create table: USERS
-- status: true = active / false = not active
-- type: 1=employee 2=customer
-- link: table employee / table customer
-- ***********************************************************************************************
CREATE TABLE USERS (
	user_ID INT auto_increment,
	user_code VARCHAR(255) NOT NULL,
	user_email VARCHAR(255) NOT NULL,
	user_password VARCHAR(255) NOT NULL, 
	user_role VARCHAR(255) NOT NULL,
	user_name VARCHAR(255) NOT NULL,
    user_type INT NOT NULL,
    user_link INT,
	user_status BOOLEAN NOT NULL,
	user_created_at DATE NOT NULL,
	user_changed_at DATE NOT NULL,
	user_created_by INT NOT NULL,
	user_changed_by INT NOT NULL,
	PRIMARY KEY (user_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- password 12345 = $2a$10$f1XHZXpdECjp5C977Y6GtuSwtL1ZwiXHxJFgHP9AgtzBxVwpMRC/e
SET @password = "$2a$10$f1XHZXpdECjp5C977Y6GtuSwtL1ZwiXHxJFgHP9AgtzBxVwpMRC/e";
INSERT INTO USERS(user_ID, user_code, user_email, user_password, user_role, user_name, user_type, user_link, user_status, user_created_at, user_changed_at, user_created_by, user_changed_by)
VALUES
	(1, 'MANAGER', 'manager@gmail.com',  @password, 'ROLE_MANAGER', 'Manager da Silva', 1, 1, true, @created_at, @changed_at, @created_by, @changed_by),
	(2, 'PURCHASER', 'purchaser@gmail.com',  @password, 'ROLE_PURCHASER', 'Purchaser da Silva', 1, 1, true, @created_at, @changed_at, @created_by, @changed_by),    
	(3, 'SELLER', 'seller@gmail.com',  @password, 'ROLE_SELLER', 'Seller da Silva', 1, 1, true, @created_at, @changed_at, @created_by, @changed_by),     
	(4, 'STOCKER', 'stocker@gmail.com',  @password, 'ROLE_STOCKER', 'Stocker da Silva', 1, 1, true, @created_at, @changed_at, @created_by, @changed_by), 
	(5, 'USER', 'userModel@gmail.com',  @password, 'ROLE_USER', 'User da Silva', 1, 1, true, @created_at, @changed_at, @created_by, @changed_by),
	(6, 'MASTERDATA', 'masterdata@gmail.com',  @password, 'ROLE_MASTERDATA', 'Masterdata da Silva', 1, 1, true, @created_at, @changed_at, @created_by, @changed_by);
    
-- ***********************************************************************************************
-- Create table: VENDORS
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE VENDORS (
	vendor_ID INT NOT NULL auto_increment,
	vendor_contactID INT NOT NULL,
	vendor_status BOOLEAN NOT NULL,
	vendor_created_at DATE NOT NULL,
	vendor_changed_at DATE NOT NULL,
	vendor_created_by INT NOT NULL,
	vendor_changed_by INT NOT NULL,
	PRIMARY KEY (vendor_ID),
	FOREIGN KEY (vendor_ContactID) REFERENCES CONTACTS(contact_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO VENDORS(vendor_ID, vendor_contactID, vendor_status, vendor_created_at, vendor_changed_at, vendor_created_by, vendor_changed_by)
VALUES
	(1, 1, true, @created_at, @changed_at, @created_by, @changed_by),
	(2, 2, true, @created_at, @changed_at, @created_by, @changed_by),
	(3, 3, true, @created_at, @changed_at, @created_by, @changed_by);

-- ***********************************************************************************************
-- Create table: CUSTOMERS
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE CUSTOMERS (
	customer_ID INT NOT NULL auto_increment,
	customer_contactID INT NOT NULL,
	customer_status BOOLEAN NOT NULL,
	customer_created_at DATE NOT NULL,
	customer_changed_at DATE NOT NULL,
	customer_created_by INT NOT NULL,
	customer_changed_by INT NOT NULL,    
	PRIMARY KEY (customer_ID),
	FOREIGN KEY (customer_ContactID) REFERENCES CONTACTS(contact_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO CUSTOMERS(customer_ID, customer_contactID, customer_status, customer_created_at, customer_changed_at, customer_created_by, customer_changed_by)
VALUES   
	(1, 4, true, @created_at, @changed_at, @created_by, @changed_by),
	(2, 5, true, @created_at, @changed_at, @created_by, @changed_by),
	(3, 6, true, @created_at, @changed_at, @created_by, @changed_by);
    
-- ***********************************************************************************************
-- Create table: EMPLOYEES
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE EMPLOYEES (
	employee_ID INT NOT NULL auto_increment,
	employee_contactID INT NOT NULL,
	employee_status BOOLEAN NOT NULL,
	employee_created_at DATE NOT NULL,
	employee_changed_at DATE NOT NULL,
	employee_created_by INT NOT NULL,
	employee_changed_by INT NOT NULL,    
	PRIMARY KEY (employee_ID),
	FOREIGN KEY (employee_contactID) REFERENCES CONTACTS(contact_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO EMPLOYEES(employee_ID, employee_contactID, employee_status, employee_created_at, employee_changed_at, employee_created_by, employee_changed_by)
VALUES   
	(1, 4, true, @created_at, @changed_at, @created_by, @changed_by),
	(2, 5, true, @created_at, @changed_at, @created_by, @changed_by),
	(3, 6, true, @created_at, @changed_at, @created_by, @changed_by);
    
-- ***********************************************************************************************
-- Create table: STORES
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE STORES (
	store_ID INT NOT NULL auto_increment,
	store_contactID INT NOT NULL,				-- dados de contato
    store_social VARCHAR(255), 						-- razão social
    store_municipal VARCHAR(255), 					-- inscrição municipal
	store_state VARCHAR(255), 						-- inscrição estadual
    store_activity VARCHAR(255), 					-- atividade principal da loja
	store_status BOOLEAN NOT NULL,
	store_created_at DATE NOT NULL,
	store_changed_at DATE NOT NULL,
	store_created_by INT NOT NULL,
	store_changed_by INT NOT NULL,    
	PRIMARY KEY (store_ID),
	FOREIGN KEY (store_ContactID) REFERENCES CONTACTS(contact_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO STORES(store_ID, store_contactID, store_social, store_municipal, store_state, store_activity, store_status, store_created_at, store_changed_at, store_created_by, store_changed_by)
VALUES
	(1, 13, '999999999999', '999999999999', '999999999999', '999999999999', true, @created_at, @changed_at, @created_by, @changed_by),
	(2, 14, '999999999999', '999999999999', '999999999999', '999999999999', true, @created_at, @changed_at, @created_by, @changed_by),
	(3, 15, '999999999999', '999999999999', '999999999999', '999999999999', true, @created_at, @changed_at, @created_by, @changed_by);

-- ***********************************************************************************************
-- Create table: PRODUCTS
-- product category: 1=FRUITS, 2=VEGETABLES, 3=MEAT, 4=FISH, 5=LEGUMES
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE PRODUCTS (
	product_ID INT NOT NULL auto_increment,
	product_imageID INT NOT NULL,
	product_category INT NOT NULL,
	product_name VARCHAR(255) NOT NULL,
	product_ean VARCHAR(255) NOT NULL,
	product_unity VARCHAR(255) NOT NULL,
	product_price DECIMAL NOT NULL,
    product_description VARCHAR (3000) not null,
	product_status BOOLEAN NOT NULL,
	product_created_at DATE NOT NULL,
	product_changed_at DATE NOT NULL,
	product_created_by INT NOT NULL,
	product_changed_by INT NOT NULL,    
	PRIMARY KEY (product_ID),
    FOREIGN KEY (product_imageID) REFERENCES IMAGES(image_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO PRODUCTS(product_ID, product_imageID, product_category, product_name, product_ean, product_unity, product_price, product_description, product_status, product_created_at, product_changed_at, product_created_by, product_changed_by)
VALUES
 	(1, 1, 1, 'Banana', '123456789012', 'UN', 1000, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
 	(2, 2, 2, 'Batata', '123456789012', 'UN', 1000, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
 	(3, 3, 2, 'Cenoura', '123456789012', 'UN', 1000, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
 	(4, 4, 1, 'Damasco', '123456789012', 'UN', 1000, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
 	(5, 5, 1, 'Framboesa', '123456789012', 'UN', 1000, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(6, 6, 1, 'Maçã', '123456789012', 'UN', 1000, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
 	(7, 7, 1, 'Melância', '123456789012', 'UN', 1000, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
 	(8, 8, 1, 'Mirtilo', '123456789012', 'UN', 1000, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
 	(9, 9, 1, 'Morango', '123456789012', 'UN', 1000, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
 	(10, 10, 2, 'Pepino', '123456789012', 'UN', 1000, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
    (11, 11, 1, 'Pera', '123456789012', 'UN', 1000, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
 	(12, 12, 1, 'Uva', '123456789012', 'UN', 1000, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by);
    
-- ***********************************************************************************************
-- Create table: STOCKS
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE STOCKS (
	stock_ID INT NOT NULL auto_increment,
	stock_storeID INT NOT NULL,
	stock_productID INT NOT NULL,
	stock_amount DECIMAL NOT NULL,
    stock_status BOOLEAN NOT NULL,    
	stock_expiration DATE NOT NULL,
	stock_created_at DATE NOT NULL,
	stock_changed_at DATE NOT NULL,
	stock_created_by INT NOT NULL,
	stock_changed_by INT NOT NULL,    
	PRIMARY KEY (stock_ID),
	FOREIGN KEY (stock_storeID) REFERENCES STORES(store_ID),
	FOREIGN KEY (stock_productID) REFERENCES PRODUCTS(product_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_status, stock_expiration, stock_created_at, stock_changed_at, stock_created_by, stock_changed_by)
VALUES
	(1, 1, 1, 1000, true, @expiration, @created_at, @changed_at, @created_by, @changed_by),
	(2, 1, 2, 2000, true, @expiration, @created_at, @changed_at, @created_by, @changed_by),
	(3, 1, 3, 3000, true, @expiration, @created_at, @changed_at, @created_by, @changed_by),
	(4, 2, 4, 4000, true, @expiration, @created_at, @changed_at, @created_by, @changed_by),
	(5, 2, 5, 5000, true, @expiration, @created_at, @changed_at, @created_by, @changed_by),
	(6, 2, 6, 6000, true, @expiration, @created_at, @changed_at, @created_by, @changed_by),
	(7, 3, 7, 7000, true, @expiration, @created_at, @changed_at, @created_by, @changed_by),
	(8, 3, 8, 8000, true, @expiration, @created_at, @changed_at, @created_by, @changed_by),
	(9, 3, 9, 9000, true, @expiration, @created_at, @changed_at, @created_by, @changed_by),
	(10, 3, 10, 10000, true, @expiration, @created_at, @changed_at, @created_by, @changed_by);    
    
-- *****************************************************************************************************
-- Create table: CARTS
-- stage = 1-Open, 2-Closed
-- status: true = active / false = not active
-- *****************************************************************************************************
CREATE TABLE CARTS (
	cart_ID INT NOT NULL auto_increment,
	cart_userID INT NOT NULL,
	cart_price DECIMAL NOT NULL,
    cart_stage INT NOT NULL,    
    cart_comments VARCHAR (3000) not null,
	cart_status BOOLEAN NOT NULL,
	cart_created_at DATE NOT NULL,
	cart_changed_at DATE NOT NULL,
	cart_created_by INT NOT NULL,
	cart_changed_by INT NOT NULL,    
	PRIMARY KEY (cart_ID),
	FOREIGN KEY (cart_userID) REFERENCES USERS(user_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO CARTS(cart_ID, cart_userID, cart_price, cart_stage, cart_comments, cart_status, cart_created_at, cart_changed_at, cart_created_by, cart_changed_by) 
	VALUES
	(1, 5, 3000, 2, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(2, 5, 3000, 2, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(3, 5, 3000, 2, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(4, 5, 3000, 2, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(5, 5, 3000, 2, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(6, 5, 3000, 2, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(7, 5, 3000, 2, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(8, 5, 3000, 2, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(9, 5, 3000, 2, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(10, 5, 3000, 2, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by);

-- ***********************************************************************************************
-- Create table: CARTS ITEMS
-- stage = 1-Open, 2-Closed
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE CARTS_ITEMS (
	item_ID INT NOT NULL auto_increment,
	item_orderID INT NOT NULL,    
	item_stockID INT NOT NULL,
	item_amount DECIMAL NOT NULL,
	item_price DECIMAL NOT NULL,
	item_discount DECIMAL NOT NULL,
	item_stage INT NOT NULL,
    item_status BOOLEAN NOT NULL,
    item_comments VARCHAR (3000) not null,
	item_created_at DATE NOT NULL,
	item_changed_at DATE NOT NULL,
	item_created_by INT NOT NULL,
	item_changed_by INT NOT NULL,    
	PRIMARY KEY (item_ID),
	FOREIGN KEY (item_orderID) REFERENCES CARTS(cart_ID),
	FOREIGN KEY (item_stockID) REFERENCES STOCKS(stock_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO CARTS_ITEMS(item_ID, item_orderID, item_stockID, item_amount, item_price, item_discount, item_stage, item_status, item_comments, item_created_at, item_changed_at, item_created_by, item_changed_by) 
	VALUES
	(1, 1, 1, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(2, 1, 2, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(3, 1, 3, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(4, 2, 1, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(5, 2, 2, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(6, 2, 3, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(7, 3, 1, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(8, 3, 2, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(9, 3, 3, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(10, 4, 1, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(11, 4, 2, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(12, 4, 3, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(13, 5, 1, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(14, 5, 2, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(15, 5, 3, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(16, 6, 1, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(17, 6, 2, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(18, 6, 3, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),   
    (19, 7, 1, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(20, 7, 2, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(21, 7, 3, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by), 
	(22, 8, 1, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(23, 8, 2, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(24, 8, 3, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by), 
	(25, 9, 1, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(26, 9, 2, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(27, 9, 3, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by), 
	(28, 10, 1, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(29, 10, 2, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(30, 10, 3, 1000, 2000, 100, 2, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by);      
    
-- *****************************************************************************************************
-- Create table: SALES
-- stage = 1-Open, 2-Paid, 3-Closed
-- status: true = active / false = not active
-- *****************************************************************************************************
CREATE TABLE SALES (
	sale_ID INT NOT NULL auto_increment,
	sale_customerID INT NOT NULL,
	sale_price DECIMAL NOT NULL,
    sale_stage INT NOT NULL,
    sale_comments VARCHAR (3000) not null,
	sale_status BOOLEAN NOT NULL,
	sale_created_at DATE NOT NULL,
	sale_changed_at DATE NOT NULL,
	sale_created_by INT NOT NULL,
	sale_changed_by INT NOT NULL,    
	PRIMARY KEY (sale_ID),
	FOREIGN KEY (sale_customerID) REFERENCES CUSTOMERS(customer_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO SALES(sale_ID, sale_customerID, sale_price, sale_stage, sale_comments, sale_status, sale_created_at, sale_changed_at, sale_created_by, sale_changed_by) 
	VALUES
	(1, 1, 3000, 3, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(2, 2, 3000, 3, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(3, 3, 3000, 3, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(4, 1, 3000, 3, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(5, 2, 3000, 3, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(6, 3, 3000, 3, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(7, 1, 3000, 3, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(8, 2, 3000, 3, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(9, 3, 3000, 3, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(10, 3, 3000, 3, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by);

-- ***********************************************************************************************
-- Create table: SALES ITEMS
-- Stage = 1-Open, 2-Paid, 3-Shipped, 4-Delivered, 5-Returned, 6-Closed
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE SALES_ITEMS (
	item_ID INT NOT NULL auto_increment,
	item_orderID INT NOT NULL,    
	item_stockID INT NOT NULL,
	item_amount DECIMAL NOT NULL,
	item_price DECIMAL NOT NULL,
	item_discount DECIMAL NOT NULL,
    item_stage INT NOT NULL,
    item_comments VARCHAR (3000) not null,
	item_status BOOLEAN NOT NULL,
	item_created_at DATE NOT NULL,
	item_changed_at DATE NOT NULL,
	item_created_by INT NOT NULL,
	item_changed_by INT NOT NULL,    
	PRIMARY KEY (item_ID),
	FOREIGN KEY (item_orderID) REFERENCES SALES(sale_ID),
	FOREIGN KEY (item_stockID) REFERENCES STOCKS(stock_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO SALES_ITEMS(item_ID, item_orderID, item_stockID, item_amount, item_price, item_discount, item_stage, item_comments, item_status, item_created_at, item_changed_at, item_created_by, item_changed_by) 
	VALUES
	(1, 1, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(2, 1, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(3, 1, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(4, 2, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(5, 2, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(6, 2, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(7, 3, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(8, 3, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(9, 3, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(10, 4, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(11, 4, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(12, 4, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(13, 5, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(14, 5, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(15, 5, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(16, 6, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(17, 6, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(18, 6, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),   
    (19, 7, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(20, 7, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(21, 7, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by), 
	(22, 8, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(23, 8, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(24, 8, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by), 
	(25, 9, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(26, 9, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(27, 9, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by), 
	(28, 10, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(29, 10, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(30, 10, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by);     
    
-- ***********************************************************************************************
-- Create table: PURCHASES
-- stage = 1-Open, 2-Paid, 3-Closed
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE PURCHASES (
	purchase_ID INT NOT NULL auto_increment,
	purchase_vendorID INT NOT NULL,
	purchase_price DECIMAL NOT NULL,
    purchase_stage INT NOT NULL,    
    purchase_status BOOLEAN NOT NULL,
    purchase_comments VARCHAR (3000) not null,    
	purchase_created_at DATE NOT NULL,
	purchase_changed_at DATE NOT NULL,
	purchase_created_by INT NOT NULL,
	purchase_changed_by INT NOT NULL,    
	PRIMARY KEY (purchase_ID),
	FOREIGN KEY (purchase_vendorID) REFERENCES VENDORS(vendor_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO PURCHASES(purchase_ID, purchase_vendorID, purchase_price, purchase_stage, purchase_status, purchase_comments, purchase_created_at, purchase_changed_at, purchase_created_by, purchase_changed_by) 
	VALUES
    (1, 1, 1000, 3, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(2, 2, 1000, 3, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(3, 3, 1000, 3, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(4, 1, 1000, 3, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(5, 2, 1000, 3, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(6, 3, 1000, 3, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(7, 1, 1000, 3, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(8, 2, 1000, 3, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(9, 3, 1000, 3, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by),
	(10, 3, 1000, 3, true, @describedBy, @created_at, @changed_at, @created_by, @changed_by);
    
-- ***********************************************************************************************
-- Create table: PURCHASES ITEMS
-- Stage = 1-Open, 2-Paid, 3-Shipped, 4-Received, 5-Returned, 6-Closed
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE PURCHASES_ITEMS (
	item_ID INT NOT NULL auto_increment,
	item_orderID INT NOT NULL,    
	item_stockID INT NOT NULL,
	item_amount DECIMAL NOT NULL,
	item_price DECIMAL NOT NULL,
	item_discount DECIMAL NOT NULL,
	item_stage INT NOT NULL,
    item_comments VARCHAR (3000) not null,
    item_status BOOLEAN NOT NULL,
	item_created_at DATE NOT NULL,
	item_changed_at DATE NOT NULL,
	item_created_by INT NOT NULL,
	item_changed_by INT NOT NULL,    
	PRIMARY KEY (item_ID),
	FOREIGN KEY (item_orderID) REFERENCES PURCHASES(purchase_ID),
	FOREIGN KEY (item_stockID) REFERENCES STOCKS(stock_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO PURCHASES_ITEMS(item_ID, item_orderID, item_stockID, item_amount, item_price, item_discount, item_stage, item_comments, item_status, item_created_at, item_changed_at, item_created_by, item_changed_by) 
	VALUES
	(1, 1, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(2, 1, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(3, 1, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(4, 2, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(5, 2, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(6, 2, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(7, 3, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(8, 3, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(9, 3, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(10, 4, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(11, 4, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(12, 4, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(13, 5, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(14, 5, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(15, 5, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(16, 6, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(17, 6, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(18, 6, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),   
    (19, 7, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(20, 7, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(21, 7, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by), 
	(22, 8, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(23, 8, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(24, 8, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by), 
	(25, 9, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(26, 9, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(27, 9, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by), 
	(28, 10, 1, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(29, 10, 2, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by),
	(30, 10, 3, 1000, 2000, 100, 6, @describedBy, true, @created_at, @changed_at, @created_by, @changed_by);     
    
-- ***********************************************************************************************
-- Create table: STOCK MOVEMENTS
-- status: true = active / false = not active
-- type: C=credit, D=debit, A=Adjust
-- ***********************************************************************************************
CREATE TABLE MOVEMENTS (
	movement_ID INT NOT NULL auto_increment,
	movement_stockID INT NOT NULL,
	movement_order INT NOT NULL,
    movement_item INT NOT NULL,
    movement_type CHAR NOT NULL,
	movement_date DATE NOT NULL,
	movement_amount DECIMAL NOT NULL,
	movement_status BOOLEAN NOT NULL,
	movement_created_at DATE NOT NULL,
	movement_changed_at DATE NOT NULL,
	movement_created_by INT NOT NULL,
	movement_changed_by INT NOT NULL,    
	PRIMARY KEY (movement_ID),
	FOREIGN KEY (movement_stockID) REFERENCES STOCKS(stock_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO MOVEMENTS(movement_ID, movement_stockID, movement_order, movement_item, movement_type, movement_date, movement_amount, movement_status, movement_created_at, movement_changed_at, movement_created_by, movement_changed_by) 
	VALUES
	(1, 1, 1, 1, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(2, 1, 2, 2, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(3, 1, 3, 3, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(4, 2, 1, 4, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(5, 2, 2, 5, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(6, 2, 3, 6, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(7, 3, 1, 7, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(8, 3, 2, 8, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(9, 3, 3, 9, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(10, 4, 1, 10, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(11, 4, 2, 1, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(12, 4, 3, 2, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(13, 5, 1, 3, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(14, 5, 2, 4, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(15, 5, 3, 5, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(16, 6, 1, 6, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(17, 6, 2, 7, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(18, 6, 3, 8, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
    (19, 7, 1, 9, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(20, 7, 2, 10, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(21, 7, 3, 1, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(22, 8, 1, 2, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(23, 8, 2, 3, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(24, 8, 3, 4, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(25, 9, 1, 5, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(26, 9, 2, 6, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(27, 9, 3, 7, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(28, 10, 1, 8, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(29, 10, 2, 9, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by),
	(30, 10, 3, 10, 'C', @created_at, 100, true, @created_at, @changed_at, @created_by, @changed_by);     
    
-- ***********************************************************************************************
-- Print data from tables
-- ***********************************************************************************************
SELECT * FROM CARTS;
SELECT * FROM CARTS_ITEMS;
SELECT * FROM SALES;
SELECT * FROM SALES_ITEMS;
SELECT * FROM PURCHASES;
SELECT * FROM PURCHASES_ITEMS;
SELECT * FROM STOCKS;
SELECT * FROM STORES;
SELECT * FROM PRODUCTS;
SELECT * FROM MOVEMENTS;
SELECT * FROM CUSTOMERS;
SELECT * FROM VENDORS;
SELECT * FROM EMPLOYEES;
SELECT * FROM USERS;
SELECT * FROM CONTACTS;
SELECT * FROM IMAGES;
