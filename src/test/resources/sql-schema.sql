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