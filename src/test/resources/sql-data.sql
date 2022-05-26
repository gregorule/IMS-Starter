INSERT INTO `customers` (`first_name`, `surname`, `email`, `phone_no`) VALUES ('jordan', 'harrison', 'jharrison@gmail.com', '0131384685');
INSERT INTO `items` (`item_name`, `price`, `in_stock`) VALUES ('Apple', 0.25, 50);
INSERT INTO `order_details` (`order_id`, `item_id`, `quantity`, `order_status`) VALUES (1, 1, 20, 'Delivered');
INSERT INTO `orders` (`customer_id`) VALUES (1);