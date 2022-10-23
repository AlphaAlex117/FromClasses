-- Author: Alexander Lafontaine

CREATE DATABASE IF NOT EXISTS AL2002hw2q2;

use AL2002hw2q2;

DROP TABLE IF EXISTS `purchase`;
DROP TABLE IF EXISTS `bought_from`;
DROP TABLE IF EXISTS `products`;
DROP TABLE IF EXISTS `product_type`;
DROP TABLE IF EXISTS `suppliers`;
DROP TABLE IF EXISTS `ingredients`;
DROP TABLE IF EXISTS `customers`;
DROP TABLE IF EXISTS `hourly_workers`;
DROP TABLE IF EXISTS `fulltime_workers`;
DROP TABLE IF EXISTS `managers`;
DROP TABLE IF EXISTS `employees`;

-- Employee Entity
CREATE TABLE `employees` (`employee_id` int, `firstname` varchar(40), `lastname` varchar(40), `address` varchar(40), `phone_num` bigint(10), 
primary key (`employee_id`)
);

-- Employee ISA Manager Entity
CREATE TABLE `managers` (`manager_id` int, `max_supervision_cap` int, `salary` decimal(10,0), `employee_id` int not null,
primary key (`manager_id`),
foreign key (`manager_id`) references `employees` (`employee_id`),
foreign key (`employee_id`) references `employees` (`employee_id`) 
on delete cascade
);

-- Employee ISA Fulltime Worker Entity
CREATE TABLE `fulltime_workers` (`ftw_id` int, `title` varchar(40), `salary` decimal(10,0),
primary key (`ftw_id`),
foreign key (`ftw_id`) references `employees` (`employee_id`) 
on delete cascade
);

-- Employee ISA Hourly Worker Entity
CREATE TABLE `hourly_workers` (`hw_id` int, `hours_per_week` int, `hourly_wage` decimal(10,0), `specialty` varchar(40),
primary key (`hw_id`),
foreign key (`hw_id`) references `employees` (`employee_id`)
on delete cascade
);

-- Customers Entity
CREATE TABLE `customers` (`cust_id` int, `firstname` varchar(40), `lastname` varchar(40), `address` varchar(40), `phone_num` bigint(10),
primary key (`cust_id`)
);

-- Ingredient Entity
CREATE TABLE `ingredients` (`item_id` int, `description` varchar(40),
primary key (`item_id`)
);

-- Suppliers Entity
CREATE TABLE `suppliers` (`supplier_name` varchar(40), `address` varchar(40),
primary key (`supplier_name`)
);

-- Product Types Entity
CREATE TABLE `product_type` (`type_name` varchar(40),
primary key (`type_name`)
);

-- Products Entity
CREATE TABLE `products` (`product_id` int, `name` varchar(40), `price` decimal(10,0), `remaining_qty` int, `hw_id` int, `type` varchar(40) not null,
primary key (`product_id`),
foreign key (`hw_id`) references `hourly_workers` (`hw_id`),
foreign key (`type`) references `product_type` (`type_name`)
);

-- Bought from Relationship
CREATE TABLE `bought_from` (`product_id` int not null, `item_id` int, `supplier_name` varchar(40), `qty` int, `price` decimal(10,0), `date_of_purchase` date,
primary key (`product_id`, `item_id`, `supplier_name`),
foreign key (`product_id`) references `products` (`product_id`),
foreign key (`item_id`) references `ingredients` (`item_id`),
foreign key (`supplier_name`) references `suppliers` (`supplier_name`)
);

-- Purchase Relationship
CREATE TABLE `purchase` (`product_id` int, `cust_id` int, `qty` int,
primary key (`product_id`, `cust_id`),
foreign key (`product_id`) references `products` (`product_id`),
foreign key (`cust_id`) references `customers` (`cust_id`)
);