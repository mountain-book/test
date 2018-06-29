DROP DATABASE IF EXISTS ecsite4;

CREATE DATABASE IF NOT EXISTS ecsite4;
USE ecsite4;

DROP TABLE IF EXISTS login_user_transaction;

CREATE TABLE login_user_transaction(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	login_id VARCHAR(16) UNIQUE,
	login_pass VARCHAR(16),
	user_name VARCHAR(50),
	insert_date DATETIME,
	updated_date DATETIME
);

DROP TABLE IF EXISTS item_info_transaction;

CREATE TABLE item_info_transaction(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	item_name VARCHAR(30),
	item_price INT,
	item_stock INT,
	insert_date DATETIME,
	update_date DATETIME
);

DROP TABLE IF EXISTS user_buy_item_transaction;

CREATE TABLE user_buy_item_transaction(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	item_transaction_id INT,
	total_price INT,
	total_count INT,
	user_master_id VARCHAR(16),
	pay VARCHAR(30),
	insert_date DATETIME,
	delete_date DATETIME
);

INSERT INTO item_info_transaction(item_name, item_price, item_stock) VALUES("ノートBook",100,50);
INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("internous", "internous01", "test");