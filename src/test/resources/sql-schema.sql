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

CREATE TABLE IF NOT EXISTS order_details(
`details_id` int NOT NULL auto_increment,
`order_id` int NOT NULL,
`item_id` int NOT NULL,
`quantity` int NOT NULL,
`order_status` varchar(50) NOT NULL,
`cost` decimal(4,2) NOT NULL,
primary key(details_id),
foreign key(order_id) references orders(order_id),
foreign key(item_id) references items(item_id)
);

DROP TABLE IF EXISTS `orders`;

CREATE TABLE IF NOT EXISTS orders(
`order_id` int NOT NULL auto_increment,
`customer_id` int NOT NULL,
primary key(order_id),
foreign key(customer_id) references customers(customer_id)
);
