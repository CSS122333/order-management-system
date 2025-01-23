SHOW DATABASES;

Create DATABASE IF NOT EXISTS `e-commerce`;

use `e-commerce`;

-- 创建 customer 表
CREATE TABLE IF NOT EXISTS customer (
                                        id INT PRIMARY KEY AUTO_INCREMENT,
                                        first_name VARCHAR(50) NOT NULL,
                                        last_name VARCHAR(50) NOT NULL,
                                        email VARCHAR(100) UNIQUE NOT NULL,
                                        phone VARCHAR(15)
) AUTO_INCREMENT = 1;

-- 创建 product 表
CREATE TABLE IF NOT EXISTS product (
                                       id INT PRIMARY KEY AUTO_INCREMENT,
                                       name VARCHAR(100) NOT NULL,
                                       description TEXT,
                                       price DECIMAL(10, 2) NOT NULL
) AUTO_INCREMENT = 1;

-- 创建 order 表
CREATE TABLE IF NOT EXISTS `order` (
                                       id INT PRIMARY KEY AUTO_INCREMENT,
                                       customer_id INT NOT NULL,
                                       order_date DATE NOT NULL,
                                       FOREIGN KEY (customer_id) REFERENCES customer(id)
) AUTO_INCREMENT = 1;

-- 创建 order_items 表
CREATE TABLE IF NOT EXISTS order_items (
                                           id INT PRIMARY KEY AUTO_INCREMENT,
                                           order_id INT NOT NULL,
                                           product_id INT NOT NULL,
                                           quantity INT NOT NULL,
                                           FOREIGN KEY (order_id) REFERENCES `order`(id),
                                           FOREIGN KEY (product_id) REFERENCES product(id)
) AUTO_INCREMENT = 1;