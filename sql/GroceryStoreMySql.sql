-- ***********************************************************************************************
-- Author: Rosemeire Deconti
-- Date: 01/06/2021
-- Project: Develop an application to control stocks and e-commerce from a Grocery 
-- Suggested during Bootcamp CodeAnywhere mentoring promoted by Digital Innovation One
-- ***********************************************************************************************
USE groceryStore;

-- ***********************************************************************************************
-- Declare date to be used in table creations 
-- ***********************************************************************************************
SET @created_at = CURRENT_DATE();
SET @changed_at = CURRENT_DATE();
SET @expiration = CURDATE() + INTERVAL 360 DAY;
SET @created_by = 'MANAGER da Silva'; 
SET @changed_by = 'MANAGER da Silva';
SET @email = 'email@email.com.br';
SET @phone = '99-9999-9999';
SET	@whats = '88-8888-8888';
SET @cnpj = '34.685.117/0001-78';
SET @cpf = '463.234.490-72';
SET	@rg = '30.359.552-8';
SET @cep = '07776-465';
SET @ean = '7891000315507';
SET @address = 'Rua Antonio Pedro Magalhães 537, Jordanésia (Jordanésia), Cajamar, São Paulo, SP';
SET @note = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce eget felis eget diam varius mollis ut id urna. Sed ac leo non neque molestie auctor. Pellentesque condimentum arcu vitae facilisis cursus. Quisque id tincidunt metus. Nam ornare tempus sem, a commodo mauris sodales non. Mauris elementum dignissim sem. Mauris magna turpis, ullamcorper a rutrum vehicula, auctor ut libero. Etiam odio quam, efficitur et tempus feugiat, tincidunt a justo. Integer a erat aliquet, elementum neque at, accumsan lectus.';
SET @email = 'email@gmail.com';
SET @image1 = 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/banana.jpg';
SET @image2 = 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/batata.jpg';
SET @image3 = 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/cenoura.jpg';
SET @image4 = 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/damasco.jpg';
SET @image5 = 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/framboesa.jpg';
SET @image6 = 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/maca.jpg';
SET @image7 = 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/melancia.jpg';
SET @image8 = 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/mirtilo.jpg';
SET @image9 = 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/morango.jpg';
SET @image10 = 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/pepino.jpg';
SET @image11 = 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/pera.jpg';
SET @image12 = 'https://github.com/rdeconti/Projeto-DIO-Java-Mercadinho-Paralelo-Images/blob/main/uva.jpg';

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
DROP TABLE IF EXISTS AGENDAS;
   
-- ***********************************************************************************************
-- Create table: AGENDA
-- ***********************************************************************************************
CREATE TABLE AGENDAS (
	agenda_ID INT NOT NULL auto_increment,
	agenda_name VARCHAR (50) NOT NULL,
	agenda_phone VARCHAR (50) NOT NULL,  
	agenda_email VARCHAR (255) NOT NULL,    
	agenda_address1 VARCHAR (255) NOT NULL,
	agenda_address2 VARCHAR (255) NOT NULL,
	agenda_address3 VARCHAR (255) NOT NULL,
	agenda_postal VARCHAR(20) NOT NULL DEFAULT '99999-99',
	agenda_note VARCHAR (14) NULL,
	PRIMARY KEY (agenda_ID)
);

INSERT INTO AGENDAS(agenda_ID, agenda_name, agenda_phone, agenda_email, agenda_address1, agenda_address2, agenda_address3,  agenda_postal, agenda_note) 
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
-- Create table: USERS
-- status: true = active / false = not active
-- type: 1=employee 2=customer
-- link: table employee / table customer
-- ***********************************************************************************************
CREATE TABLE USERS (
	user_ID BIGINT auto_increment,
	user_code VARCHAR(255) NOT NULL,
	user_email VARCHAR(255) NOT NULL,
	user_password VARCHAR(255) NOT NULL, 
	user_role VARCHAR(255) NOT NULL,
	user_name VARCHAR(255) NOT NULL,
	user_address VARCHAR (255),
    user_cep VARCHAR (255),
	user_phone VARCHAR (255),
	user_whats VARCHAR (255),
	user_document VARCHAR (255),
	user_status BOOLEAN NOT NULL,
	PRIMARY KEY (user_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------------------------------------------------------------
-- password 12345 = $2a$10$f1XHZXpdECjp5C977Y6GtuSwtL1ZwiXHxJFgHP9AgtzBxVwpMRC/e
-- ----------------------------------------------------------------------------------

SET @password = "$2a$10$f1XHZXpdECjp5C977Y6GtuSwtL1ZwiXHxJFgHP9AgtzBxVwpMRC/e";
INSERT INTO USERS(user_ID, user_code, user_email, user_password, user_role, user_name, user_address, user_cep, user_phone, user_whats, user_document, user_status)
VALUES
	(1, 'MANAGER', 'manager@gmail.com',  @password, 'ROLE_MANAGER', 'Manager da Silva', @address, @cep, @phone, @whats, @rg, true),
	(2, 'PURCHASER', 'purchaser@gmail.com',  @password, 'ROLE_PURCHASER', 'Purchaser da Silva', @address, @cep, @phone, @whats, @rg, true),
	(3, 'SELLER', 'seller@gmail.com',  @password, 'ROLE_SELLER', 'Seller da Silva', @address, @cep, @phone, @whats, @rg, true),
	(4, 'STOCKER', 'stocker@gmail.com',  @password, 'ROLE_STOCKER', 'Stocker da Silva', @address, @cep, @phone, @whats, @rg, true),
	(5, 'USER', 'userModel@gmail.com',  @password, 'ROLE_USER', 'User da Silva', @address, @cep, @phone, @whats, @rg, true);
    
-- ***********************************************************************************************
-- Create table: VENDORS
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE VENDORS (
	vendor_ID BIGINT NOT NULL auto_increment,
    vendor_name VARCHAR (255),
	vendor_email VARCHAR (255),
	vendor_address VARCHAR (255),
    vendor_cep VARCHAR (255),
	vendor_phone VARCHAR (255),
	vendor_whats VARCHAR (255),
	vendor_document VARCHAR (255),
    vendor_note VARCHAR (3000) NULL,
	vendor_status BOOLEAN NOT NULL, 
	PRIMARY KEY (vendor_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO VENDORS(vendor_ID, vendor_name, vendor_email, vendor_address, vendor_cep, vendor_phone, vendor_whats, vendor_document, vendor_note, vendor_status)
VALUES
	(1, 'vendor 1', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (2, 'vendor 2', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (3, 'vendor 3', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (4, 'vendor 4', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (5, 'vendor 5', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (6, 'vendor 6', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (7, 'vendor 7', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (8, 'vendor 8', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (9, 'vendor 9', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (10, 'vendor 10', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (11, 'vendor 11', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (12, 'vendor 12', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (13, 'vendor 13', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (14, 'vendor 14', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (15, 'vendor 15', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (16, 'vendor 16', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (17, 'vendor 17', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (18, 'vendor 18', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (19, 'vendor 19', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (20, 'vendor 20', @email, @address, @cep, @phone, @whats, @cnpj, @note, true);
    
-- ***********************************************************************************************
-- Create table: CUSTOMERS
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE CUSTOMERS (
	customer_ID BIGINT NOT NULL auto_increment,
    customer_name VARCHAR (255),
	customer_email VARCHAR (255),
	customer_address VARCHAR (255),
    customer_cep VARCHAR (255),
	customer_phone VARCHAR (255),
	customer_whats VARCHAR (255),
	customer_document VARCHAR (255),
	customer_note VARCHAR (3000),
	customer_status BOOLEAN NOT NULL,
	PRIMARY KEY (customer_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO CUSTOMERS(customer_ID, customer_name, customer_email, customer_address, customer_cep, customer_phone, customer_whats, customer_document, customer_note, customer_status)
VALUES
	(1, 'customer 1', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (2, 'customer 2', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (3, 'customer 3', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (4, 'customer 4', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (5, 'customer 5', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (6, 'customer 6', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (7, 'customer 7', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (8, 'customer 8', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (9, 'customer 9', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (10, 'customer 10', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (11, 'customer 11', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (12, 'customer 12', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (13, 'customer 13', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (14, 'customer 14', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (15, 'customer 15', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (16, 'customer 16', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (17, 'customer 17', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (18, 'customer 18', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (19, 'customer 19', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (20, 'customer 20', @email, @address, @cep, @phone, @whats, @cnpj, @note, true);
    
-- ***********************************************************************************************
-- Create table: EMPLOYEES
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE EMPLOYEES (
	employee_ID BIGINT NOT NULL auto_increment,
    employee_name VARCHAR (255),
	employee_email VARCHAR (255),
	employee_address VARCHAR (255),
    employee_cep VARCHAR (255),
	employee_phone VARCHAR (255),
	employee_whats VARCHAR (255),
	employee_document VARCHAR (255),
	employee_note VARCHAR (3000),    
	employee_status BOOLEAN NOT NULL,
	PRIMARY KEY (employee_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO EMPLOYEES(employee_ID, employee_name, employee_email, employee_address, employee_cep, employee_phone, employee_whats, employee_document, employee_note, employee_status)
VALUES
	(1, 'employee 1', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (2, 'employee 2', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (3, 'employee 3', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (4, 'employee 4', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (5, 'employee 5', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (6, 'employee 6', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (7, 'employee 7', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (8, 'employee 8', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (9, 'employee 9', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (10, 'employee 10', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (11, 'employee 11', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (12, 'employee 12', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (13, 'employee 13', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (14, 'employee 14', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (15, 'employee 15', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (16, 'employee 16', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (17, 'employee 17', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (18, 'employee 18', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (19, 'employee 19', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (20, 'employee 20', @email, @address, @cep, @phone, @whats, @cnpj, @note, true);
    
-- ***********************************************************************************************
-- Create table: STORES
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE STORES (
	store_ID BIGINT NOT NULL auto_increment,
    store_name VARCHAR (255),
	store_email VARCHAR (255),
	store_address VARCHAR (255),
    store_cep VARCHAR (255),
	store_phone VARCHAR (255),
	store_whats VARCHAR (255),
	store_document VARCHAR (255),
	store_note VARCHAR (3000),
	store_status BOOLEAN NOT NULL,
	PRIMARY KEY (store_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO STORES(store_ID, store_name, store_email, store_address, store_cep, store_phone, store_whats, store_document, store_note, store_status)
VALUES
	(1, 'store 1', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (2, 'store 2', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (3, 'store 3', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (4, 'store 4', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (5, 'store 5', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (6, 'store 6', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (7, 'store 7', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (8, 'store 8', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (9, 'store 9', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (10, 'store 10', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (11, 'store 11', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (12, 'store 12', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (13, 'store 13', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (14, 'store 14', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (15, 'store 15', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (16, 'store 16', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (17, 'store 17', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (18, 'store 18', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (19, 'store 19', @email, @address, @cep, @phone, @whats, @cnpj, @note, true),
    (20, 'store 20', @email, @address, @cep, @phone, @whats, @cnpj, @note, true);
 
-- ***********************************************************************************************
-- Create table: PRODUCTS
-- product category: 1=FRUITS, 2=VEGETABLES, 3=MEAT, 4=FISH, 5=LEGUMES
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE PRODUCTS (
	product_ID BIGINT NOT NULL auto_increment,
	product_image VARCHAR(255) NOT NULL,
	product_category INT NOT NULL,
	product_name VARCHAR(255) NOT NULL,
	product_ean VARCHAR(255) NOT NULL,
	product_unity VARCHAR(255) NOT NULL,
	product_price DECIMAL NOT NULL,
    product_description VARCHAR (3000) not null,
	product_status BOOLEAN NOT NULL,
	PRIMARY KEY (product_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO PRODUCTS(product_ID, product_image, product_category, product_name, product_ean, product_unity, product_price, product_description, product_status)
VALUES
 	(1, @image1, 1, 'Banana', @ean, 'UN', 1000, @note, true),
 	(2, @image2, 2, 'Batata', @ean, 'UN', 1000, @note, true),
 	(3, @image3, 2, 'Cenoura', @ean, 'UN', 1000, @note, true),
 	(4, @image4, 1, 'Damasco', @ean, 'UN', 1000, @note, true),
 	(5, @image5, 1, 'Framboesa', @ean, 'UN', 1000, @note, true),
	(6, @image6, 1, 'Maçã', @ean, 'UN', 1000, @note, true),
 	(7, @image7, 1, 'Melância', @ean, 'UN', 1000, @note, true),
 	(8, @image8, 1, 'Mirtilo', @ean, 'UN', 1000, @note, true),
 	(9, @image9, 1, 'Morango', @ean, 'UN', 1000, @note, true),
 	(10, @image10, 2, 'Pepino', @ean, 'UN', 1000, @note, true),
    (11, @image11, 1, 'Pera', @ean, 'UN', 1000, @note, true),
 	(12, @image12, 1, 'Uva', @ean, 'UN', 1000, @note, true),
    (13, @image1, 1, 'Banana Premium', @ean, 'UN', 1000, @note, true),
 	(14, @image2, 2, 'Batata Premium', @ean, 'UN', 1000, @note, true),
 	(15, @image3, 2, 'Cenoura Premium', @ean, 'UN', 1000, @note, true),
 	(16, @image4, 1, 'Damasco Premium', @ean, 'UN', 1000, @note, true),
 	(17, @image5, 1, 'Framboesa Premium', @ean, 'UN', 1000, @note, true),
	(18, @image6, 1, 'Maçã Premium', @ean, 'UN', 1000, @note, true),
 	(19, @image7, 1, 'Melância Premium', @ean, 'UN', 1000, @note, true),
 	(20, @image8, 1, 'Mirtilo Premium', @ean, 'UN', 1000, @note, true),
 	(21, @image9, 1, 'Morango Premium', @ean, 'UN', 1000, @note, true),
 	(22, @image10, 2, 'Pepino Premium', @ean, 'UN', 1000, @note, true),
    (23, @image11, 1, 'Pera Premium', @ean, 'UN', 1000, @note, true),
 	(24, @image12, 1, 'Uva Premium', @ean, 'UN', 1000, @note, true);
    
-- ***********************************************************************************************
-- Create table: STOCKS
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE STOCKS (
	stock_ID BIGINT NOT NULL auto_increment,
	stock_storeID BIGINT NOT NULL,
	stock_productID BIGINT NOT NULL,
	stock_amount DECIMAL NOT NULL,
    stock_status BOOLEAN NOT NULL,    
	stock_expiration DATE NOT NULL,
	PRIMARY KEY (stock_ID),
	FOREIGN KEY (stock_storeID) REFERENCES STORES(store_ID),
	FOREIGN KEY (stock_productID) REFERENCES PRODUCTS(product_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO STOCKS(stock_ID, stock_storeID, stock_productID, stock_amount, stock_status, stock_expiration)
VALUES
	(1, 1, 1, 1000, true, @expiration),
	(2, 1, 2, 2000, true, @expiration),
	(3, 1, 3, 3000, true, @expiration),
	(4, 2, 4, 4000, true, @expiration),
	(5, 2, 5, 5000, true, @expiration),
	(6, 2, 6, 6000, true, @expiration),
	(7, 3, 7, 7000, true, @expiration),
	(8, 3, 8, 8000, true, @expiration),
	(9, 3, 9, 9000, true, @expiration),
	(10, 3, 10, 10000, true, @expiration);    
    
-- *****************************************************************************************************
-- Create table: CARTS
-- stage = 1-Open, 2-Closed
-- status: true = active / false = not active
-- *****************************************************************************************************
CREATE TABLE CARTS (
	cart_ID BIGINT NOT NULL auto_increment,
	cart_userID BIGINT NOT NULL,
	cart_price DECIMAL NOT NULL,
    cart_stage INT NOT NULL,    
    cart_comments VARCHAR (3000) not null,
	cart_status BOOLEAN NOT NULL,
	PRIMARY KEY (cart_ID),
	FOREIGN KEY (cart_userID) REFERENCES USERS(user_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO CARTS(cart_ID, cart_userID, cart_price, cart_stage, cart_comments, cart_status) 
	VALUES
	(1, 5, 3000, 2, @note, true),
	(2, 5, 3000, 2, @note, true),
	(3, 5, 3000, 2, @note, true),
	(4, 5, 3000, 2, @note, true),
	(5, 5, 3000, 2, @note, true),
	(6, 5, 3000, 2, @note, true),
	(7, 5, 3000, 2, @note, true),
	(8, 5, 3000, 2, @note, true),
	(9, 5, 3000, 2, @note, true),
	(10, 5, 3000, 2, @note, true);

-- ***********************************************************************************************
-- Create table: CARTS ITEMS
-- stage = 1-Open, 2-Closed
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE CARTS_ITEMS (
	item_ID BIGINT NOT NULL auto_increment,
	item_orderID BIGINT NOT NULL,    
	item_stockID BIGINT NOT NULL,
	item_amount DECIMAL NOT NULL,
	item_price DECIMAL NOT NULL,
	item_discount DECIMAL NOT NULL,
	item_stage INT NOT NULL,
    item_status BOOLEAN NOT NULL,
    item_comments VARCHAR (3000) not null,
	PRIMARY KEY (item_ID),
	FOREIGN KEY (item_orderID) REFERENCES CARTS(cart_ID),
	FOREIGN KEY (item_stockID) REFERENCES STOCKS(stock_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO CARTS_ITEMS(item_ID, item_orderID, item_stockID, item_amount, item_price, item_discount, item_stage, item_status, item_comments) 
	VALUES
	(1, 1, 1, 1000, 2000, 100, 2, true, @note),
	(2, 1, 2, 1000, 2000, 100, 2, true, @note),
	(3, 1, 3, 1000, 2000, 100, 2, true, @note),
	(4, 2, 1, 1000, 2000, 100, 2, true, @note),
	(5, 2, 2, 1000, 2000, 100, 2, true, @note),
	(6, 2, 3, 1000, 2000, 100, 2, true, @note),
	(7, 3, 1, 1000, 2000, 100, 2, true, @note),
	(8, 3, 2, 1000, 2000, 100, 2, true, @note),
	(9, 3, 3, 1000, 2000, 100, 2, true, @note),
	(10, 4, 1, 1000, 2000, 100, 2, true, @note),
	(11, 4, 2, 1000, 2000, 100, 2, true, @note),
	(12, 4, 3, 1000, 2000, 100, 2, true, @note),
	(13, 5, 1, 1000, 2000, 100, 2, true, @note),
	(14, 5, 2, 1000, 2000, 100, 2, true, @note),
	(15, 5, 3, 1000, 2000, 100, 2, true, @note),
	(16, 6, 1, 1000, 2000, 100, 2, true, @note),
	(17, 6, 2, 1000, 2000, 100, 2, true, @note),
	(18, 6, 3, 1000, 2000, 100, 2, true, @note),   
    (19, 7, 1, 1000, 2000, 100, 2, true, @note),
	(20, 7, 2, 1000, 2000, 100, 2, true, @note),
	(21, 7, 3, 1000, 2000, 100, 2, true, @note), 
	(22, 8, 1, 1000, 2000, 100, 2, true, @note),
	(23, 8, 2, 1000, 2000, 100, 2, true, @note),
	(24, 8, 3, 1000, 2000, 100, 2, true, @note), 
	(25, 9, 1, 1000, 2000, 100, 2, true, @note),
	(26, 9, 2, 1000, 2000, 100, 2, true, @note),
	(27, 9, 3, 1000, 2000, 100, 2, true, @note), 
	(28, 10, 1, 1000, 2000, 100, 2, true, @note),
	(29, 10, 2, 1000, 2000, 100, 2, true, @note),
	(30, 10, 3, 1000, 2000, 100, 2, true, @note);      
    
-- *****************************************************************************************************
-- Create table: SALES
-- stage = 1-Open, 2-Paid, 3-Closed
-- status: true = active / false = not active
-- *****************************************************************************************************
CREATE TABLE SALES (
	sale_ID BIGINT NOT NULL auto_increment,
	sale_customerID BIGINT NOT NULL,
	sale_price DECIMAL NOT NULL,
    sale_stage INT NOT NULL,
    sale_comments VARCHAR (3000) not null,
	sale_status BOOLEAN NOT NULL,
	PRIMARY KEY (sale_ID),
	FOREIGN KEY (sale_customerID) REFERENCES CUSTOMERS(customer_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO SALES(sale_ID, sale_customerID, sale_price, sale_stage, sale_comments, sale_status) 
	VALUES
	(1, 1, 3000, 3, @note, true),
	(2, 2, 3000, 3, @note, true),
	(3, 3, 3000, 3, @note, true),
	(4, 1, 3000, 3, @note, true),
	(5, 2, 3000, 3, @note, true),
	(6, 3, 3000, 3, @note, true),
	(7, 1, 3000, 3, @note, true),
	(8, 2, 3000, 3, @note, true),
	(9, 3, 3000, 3, @note, true),
	(10, 3, 3000, 3, @note, true);

-- ***********************************************************************************************
-- Create table: SALES ITEMS
-- Stage = 1-Open, 2-Paid, 3-Shipped, 4-Delivered, 5-Returned, 6-Closed
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE SALES_ITEMS (
	item_ID BIGINT NOT NULL auto_increment,
	item_orderID BIGINT NOT NULL,    
	item_stockID BIGINT NOT NULL,
	item_amount DECIMAL NOT NULL,
	item_price DECIMAL NOT NULL,
	item_discount DECIMAL NOT NULL,
    item_stage INT NOT NULL,
    item_comments VARCHAR (3000) not null,
	item_status BOOLEAN NOT NULL,
	PRIMARY KEY (item_ID),
	FOREIGN KEY (item_orderID) REFERENCES SALES(sale_ID),
	FOREIGN KEY (item_stockID) REFERENCES STOCKS(stock_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO SALES_ITEMS(item_ID, item_orderID, item_stockID, item_amount, item_price, item_discount, item_stage, item_comments, item_status) 
	VALUES
	(1, 1, 1, 1000, 2000, 100, 6, @note, true),
	(2, 1, 2, 1000, 2000, 100, 6, @note, true),
	(3, 1, 3, 1000, 2000, 100, 6, @note, true),
	(4, 2, 1, 1000, 2000, 100, 6, @note, true),
	(5, 2, 2, 1000, 2000, 100, 6, @note, true),
	(6, 2, 3, 1000, 2000, 100, 6, @note, true),
	(7, 3, 1, 1000, 2000, 100, 6, @note, true),
	(8, 3, 2, 1000, 2000, 100, 6, @note, true),
	(9, 3, 3, 1000, 2000, 100, 6, @note, true),
	(10, 4, 1, 1000, 2000, 100, 6, @note, true),
	(11, 4, 2, 1000, 2000, 100, 6, @note, true),
	(12, 4, 3, 1000, 2000, 100, 6, @note, true),
	(13, 5, 1, 1000, 2000, 100, 6, @note, true),
	(14, 5, 2, 1000, 2000, 100, 6, @note, true),
	(15, 5, 3, 1000, 2000, 100, 6, @note, true),
	(16, 6, 1, 1000, 2000, 100, 6, @note, true),
	(17, 6, 2, 1000, 2000, 100, 6, @note, true),
	(18, 6, 3, 1000, 2000, 100, 6, @note, true),   
    (19, 7, 1, 1000, 2000, 100, 6, @note, true),
	(20, 7, 2, 1000, 2000, 100, 6, @note, true),
	(21, 7, 3, 1000, 2000, 100, 6, @note, true), 
	(22, 8, 1, 1000, 2000, 100, 6, @note, true),
	(23, 8, 2, 1000, 2000, 100, 6, @note, true),
	(24, 8, 3, 1000, 2000, 100, 6, @note, true), 
	(25, 9, 1, 1000, 2000, 100, 6, @note, true),
	(26, 9, 2, 1000, 2000, 100, 6, @note, true),
	(27, 9, 3, 1000, 2000, 100, 6, @note, true), 
	(28, 10, 1, 1000, 2000, 100, 6, @note, true),
	(29, 10, 2, 1000, 2000, 100, 6, @note, true),
	(30, 10, 3, 1000, 2000, 100, 6, @note, true);     
    
-- ***********************************************************************************************
-- Create table: PURCHASES
-- stage = 1-Open, 2-Paid, 3-Closed
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE PURCHASES (
	purchase_ID BIGINT NOT NULL auto_increment,
	purchase_vendorID BIGINT NOT NULL,
	purchase_price DECIMAL NOT NULL,
    purchase_stage INT NOT NULL,    
    purchase_status BOOLEAN NOT NULL,
    purchase_comments VARCHAR (3000) not null,    
	PRIMARY KEY (purchase_ID),
	FOREIGN KEY (purchase_vendorID) REFERENCES VENDORS(vendor_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO PURCHASES(purchase_ID, purchase_vendorID, purchase_price, purchase_stage, purchase_status, purchase_comments) 
	VALUES
    (1, 1, 1000, 3, true, @note),
	(2, 2, 1000, 3, true, @note),
	(3, 3, 1000, 3, true, @note),
	(4, 1, 1000, 3, true, @note),
	(5, 2, 1000, 3, true, @note),
	(6, 3, 1000, 3, true, @note),
	(7, 1, 1000, 3, true, @note),
	(8, 2, 1000, 3, true, @note),
	(9, 3, 1000, 3, true, @note),
	(10, 3, 1000, 3, true, @note);
    
-- ***********************************************************************************************
-- Create table: PURCHASES ITEMS
-- Stage = 1-Open, 2-Paid, 3-Shipped, 4-Received, 5-Returned, 6-Closed
-- status: true = active / false = not active
-- ***********************************************************************************************
CREATE TABLE PURCHASES_ITEMS (
	item_ID BIGINT NOT NULL auto_increment,
	item_orderID BIGINT NOT NULL,    
	item_stockID BIGINT NOT NULL,
	item_amount DECIMAL NOT NULL,
	item_price DECIMAL NOT NULL,
	item_discount DECIMAL NOT NULL,
	item_stage INT NOT NULL,
    item_comments VARCHAR (3000) not null,
    item_status BOOLEAN NOT NULL,
	PRIMARY KEY (item_ID),
	FOREIGN KEY (item_orderID) REFERENCES PURCHASES(purchase_ID),
	FOREIGN KEY (item_stockID) REFERENCES STOCKS(stock_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO PURCHASES_ITEMS(item_ID, item_orderID, item_stockID, item_amount, item_price, item_discount, item_stage, item_comments, item_status) 
	VALUES
	(1, 1, 1, 1000, 2000, 100, 6, @note, true),
	(2, 1, 2, 1000, 2000, 100, 6, @note, true),
	(3, 1, 3, 1000, 2000, 100, 6, @note, true),
	(4, 2, 1, 1000, 2000, 100, 6, @note, true),
	(5, 2, 2, 1000, 2000, 100, 6, @note, true),
	(6, 2, 3, 1000, 2000, 100, 6, @note, true),
	(7, 3, 1, 1000, 2000, 100, 6, @note, true),
	(8, 3, 2, 1000, 2000, 100, 6, @note, true),
	(9, 3, 3, 1000, 2000, 100, 6, @note, true),
	(10, 4, 1, 1000, 2000, 100, 6, @note, true),
	(11, 4, 2, 1000, 2000, 100, 6, @note, true),
	(12, 4, 3, 1000, 2000, 100, 6, @note, true),
	(13, 5, 1, 1000, 2000, 100, 6, @note, true),
	(14, 5, 2, 1000, 2000, 100, 6, @note, true),
	(15, 5, 3, 1000, 2000, 100, 6, @note, true),
	(16, 6, 1, 1000, 2000, 100, 6, @note, true),
	(17, 6, 2, 1000, 2000, 100, 6, @note, true),
	(18, 6, 3, 1000, 2000, 100, 6, @note, true),   
    (19, 7, 1, 1000, 2000, 100, 6, @note, true),
	(20, 7, 2, 1000, 2000, 100, 6, @note, true),
	(21, 7, 3, 1000, 2000, 100, 6, @note, true), 
	(22, 8, 1, 1000, 2000, 100, 6, @note, true),
	(23, 8, 2, 1000, 2000, 100, 6, @note, true),
	(24, 8, 3, 1000, 2000, 100, 6, @note, true), 
	(25, 9, 1, 1000, 2000, 100, 6, @note, true),
	(26, 9, 2, 1000, 2000, 100, 6, @note, true),
	(27, 9, 3, 1000, 2000, 100, 6, @note, true), 
	(28, 10, 1, 1000, 2000, 100, 6, @note, true),
	(29, 10, 2, 1000, 2000, 100, 6, @note, true),
	(30, 10, 3, 1000, 2000, 100, 6, @note, true);     
    
-- ***********************************************************************************************
-- Create table: STOCK MOVEMENTS
-- status: true = active / false = not active
-- type: C=credit, D=debit, A=Adjust
-- ***********************************************************************************************
CREATE TABLE MOVEMENTS (
	movement_ID BIGINT NOT NULL auto_increment,
	movement_stockID BIGINT NOT NULL,
	movement_order INT NOT NULL,
    movement_item INT NOT NULL,
    movement_type CHAR NOT NULL,
	movement_date DATE NOT NULL,
	movement_amount DECIMAL NOT NULL,
	movement_status BOOLEAN NOT NULL,
	PRIMARY KEY (movement_ID),
	FOREIGN KEY (movement_stockID) REFERENCES STOCKS(stock_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO MOVEMENTS(movement_ID, movement_stockID, movement_order, movement_item, movement_type, movement_date, movement_amount, movement_status) 
	VALUES
	(1, 1, 1, 1, 'C', @created_at, 100, true),
	(2, 1, 2, 2, 'C', @created_at, 100, true),
	(3, 1, 3, 3, 'C', @created_at, 100, true),
	(4, 2, 1, 4, 'C', @created_at, 100, true),
	(5, 2, 2, 5, 'C', @created_at, 100, true),
	(6, 2, 3, 6, 'C', @created_at, 100, true),
	(7, 3, 1, 7, 'C', @created_at, 100, true),
	(8, 3, 2, 8, 'C', @created_at, 100, true),
	(9, 3, 3, 9, 'C', @created_at, 100, true),
	(10, 4, 1, 10, 'C', @created_at, 100, true),
	(11, 4, 2, 1, 'C', @created_at, 100, true),
	(12, 4, 3, 2, 'C', @created_at, 100, true),
	(13, 5, 1, 3, 'C', @created_at, 100, true),
	(14, 5, 2, 4, 'C', @created_at, 100, true),
	(15, 5, 3, 5, 'C', @created_at, 100, true),
	(16, 6, 1, 6, 'C', @created_at, 100, true),
	(17, 6, 2, 7, 'C', @created_at, 100, true),
	(18, 6, 3, 8, 'C', @created_at, 100, true),
    (19, 7, 1, 9, 'C', @created_at, 100, true),
	(20, 7, 2, 10, 'C', @created_at, 100, true),
	(21, 7, 3, 1, 'C', @created_at, 100, true),
	(22, 8, 1, 2, 'C', @created_at, 100, true),
	(23, 8, 2, 3, 'C', @created_at, 100, true),
	(24, 8, 3, 4, 'C', @created_at, 100, true),
	(25, 9, 1, 5, 'C', @created_at, 100, true),
	(26, 9, 2, 6, 'C', @created_at, 100, true),
	(27, 9, 3, 7, 'C', @created_at, 100, true),
	(28, 10, 1, 8, 'C', @created_at, 100, true),
	(29, 10, 2, 9, 'C', @created_at, 100, true),
	(30, 10, 3, 10, 'C', @created_at, 100, true);     

--  -----------------------------------------------------------------------------------------------------------------------------
--  ----------------------------------------------------------------------------------------------------------------------------
--  ----------------------------------------------------------------------------------------------------------------------------
--  ----------------------------------------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS ORDER_DETAILS;
DROP TABLE IF EXISTS ORDERS;
DROP TABLE IF EXISTS ACCOUNTS;
DROP TABLE IF EXISTS PRODUCTS1;

-- ***********************************************************************************************
-- Create table: PRODUCTS
-- ***********************************************************************************************
CREATE TABLE PRODUCTS1 (
	product_code INT NOT NULL,
	product_name VARCHAR (50) NOT NULL,
	product_price double precision not null,
	product_image BLOB,
    product_date datetime,
	PRIMARY KEY (product_code)
);

INSERT INTO PRODUCTS1(product_code, product_name, product_price) 
VALUES
 	(1, 'Banana', 10),
 	(2, 'Batata', 10),
 	(3, 'Cenoura', 10),
 	(4, 'Damasco', 10),
 	(5, 'Framboesa', 10),
	(6, 'Maçã', 10),
 	(7, 'Melância', 10),
 	(8, 'Mirtilo', 10),
 	(9, 'Morango', 10),
 	(10, 'Pepino', 10),
    (11, 'Pera', 10),
 	(12, 'Uva', 10);

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
  PRODUCT_ID INT not null
) ;
--  
alter table ORDER_DETAILS
  add primary key (ID) ;
alter table ORDER_DETAILS
  add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID)
  references ORDERS (ID);
alter table ORDER_DETAILS
  add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID)
  references PRODUCTS1 (product_code);
  
-- ***********************************************************************************************
-- Create table: ACCOUNTS
-- ***********************************************************************************************
create table ACCOUNTS
(
  USER_NAME VARCHAR(20) not null,
  ACTIVE	BOOLEAN NOT NULL,
  ENCRYTED_PASSWORD  VARCHAR(128) not null,
  USER_ROLE VARCHAR(20) not null
) ;
 
alter table ACCOUNTS
  add primary key (USER_NAME) ;
  
insert into Accounts (USER_NAME, ACTIVE, ENCRYTED_PASSWORD, USER_ROLE)
values ('employee1', true,
'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_EMPLOYEE');
 
insert into Accounts (USER_NAME, ACTIVE, ENCRYTED_PASSWORD, USER_ROLE)
values ('manager1', true,
'$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_MANAGER');

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
SELECT * FROM AGENDAS;
SELECT * FROM ORDER_DETAILS;
SELECT * FROM ORDERS;
SELECT * FROM ACCOUNTS;
SELECT * FROM PRODUCTS1;
