DROP TABLE IF EXISTS `order_details`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `customers`; 
DROP TABLE IF EXISTS `items`;

-- USE `test_ims` ;

DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    `email` VARCHAR(50) DEFAULT NULL,
    `phone_no` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `items`;

CREATE TABLE IF NOT EXISTS `items`(
`item_id` INT(11) NOT NULL auto_increment,
`item_name` VARCHAR(50) DEFAULT NULL,
`price` DECIMAL(3,2) DEFAULT NULL,
`in_stock` INT DEFAULT NULL,
PRIMARY KEY (item_id)
);

DROP TABLE IF EXISTS `order_details`;

CREATE TABLE IF NOT EXISTS `order_details`(
`details_id` INT NOT NULL auto_increment,
`order_id` INT NOT NULL,
`item_id` INT NOT NULL,
`order_status` VARCHAR(50) NOT NULL,
`quantity` INT NOT NULL,
`cost` DECIMAL(4,2),
PRIMARY KEY(details_id),
FOREIGN KEY(order_id) REFERENCES orders(order_id),
FOREIGN KEY(item_id) REFERENCES items(item_id)
);

DROP TABLE IF EXISTS `orders`;

CREATE TABLE IF NOT EXISTS orders(
`order_id` int NOT NULL auto_increment,
`customer_id` int NOT NULL,
primary key(order_id),
foreign key(customer_id) references customers(customer_id)
);
