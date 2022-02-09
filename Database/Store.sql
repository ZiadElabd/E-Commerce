Use sql11471271;

CREATE TABLE USER (
    userId INTEGER AUTO_INCREMENT NOT NULL,
    userName VARCHAR(30) NOT NULL,
    password VARCHAR(150) NOT NULL,
    firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(30) NOT NULL,
    address VARCHAR(150) NOT NULL,
    phone CHAR(12),
    role TINYINT(1),
    PRIMARY KEY (userId, userName)
);

CREATE TABLE CATEGORY (
    categoryName VARCHAR(30) NOT NULL,
    description VARCHAR(100),
    PRIMARY KEY (categoryName)
);
            
CREATE TABLE PRODUCT (
    productId INT AUTO_INCREMENT NOT NULL,
    CategoryName VARCHAR(30) NOT NULL,
    name VARCHAR(30) NOT NULL,
    description VARCHAR(100) NOT NULL,
    price VARCHAR(30) NOT NULL,
    quantity VARCHAR(30) NOT NULL,
    discount CHAR(12),
    image LONGTEXT,
    PRIMARY KEY (productId),
    FOREIGN KEY (categoryName)
        REFERENCES CATEGORY (categoryName)
        ON UPDATE CASCADE
        ON DELETE CASCADE 
);

CREATE TABLE CART (
	userName VARCHAR(30) NOT NULL,
	productId INT NOT NULL,
	PRIMARY KEY (userName, productId),
	FOREIGN KEY (userName)
		REFERENCES USER (userName)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	FOREIGN KEY (productId)
		REFERENCES PRODUCT (productId)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE Orders (
    orderId INTEGER AUTO_INCREMENT NOT NULL,
    total_price double  NOT NULL,
    noOfItems INTEGER NOT NULL,
    date VARCHAR(30) NOT NULL,
    PRIMARY KEY (orderId)
);
            
INSERT INTO CATEGORY 
VALUES 
	('Clothing', null),
	('Electronics', null),
    ('Shoes', null),
    ('Watches', null),
    ('Jewallery', null),
    ('Sports', null);

INSERT INTO USER 
VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'shop', 'owner', 'ALEX', null, 1);




