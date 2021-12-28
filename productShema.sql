Drop schema if exists Store ;
Create Schema Store;
Use Store;

CREATE TABLE USER (
    userId INTEGER AUTO_INCREMENT NOT NULL,
    userName VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(30) NOT NULL,
    address VARCHAR(30) NOT NULL,
    phone CHAR(12),
    role TINYINT(1),
    PRIMARY KEY (userId)
);

CREATE TABLE CATEGORY (
    categoryName VARCHAR(30) NOT NULL,
    description VARCHAR(100),
    PRIMARY KEY (categoryName)
);
            
CREATE TABLE PRODUCT (
    productId INTEGER AUTO_INCREMENT NOT NULL,
    CategoryName VARCHAR(30) NOT NULL,
    name VARCHAR(30) NOT NULL,
    description VARCHAR(100) NOT NULL,
    price VARCHAR(30) NOT NULL,
    quantity VARCHAR(30) NOT NULL,
    discount CHAR(12),
    image LONG,
    PRIMARY KEY (productId),
    FOREIGN KEY (categoryName)
        REFERENCES CATEGORY (categoryName)
        ON UPDATE CASCADE
        ON DELETE CASCADE 
);
            
INSERT INTO CATEGORY 
VALUES 
	('Clothing', null),
	('Electronics', null),
    ('Fruits', null),
    ('Jewellery', null),
    ('Shoes', null),
    ('Sports', null),
    ('Watches', null);

INSERT INTO USER 
VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'shop', 'owner', 'ALEX', null, 1);




