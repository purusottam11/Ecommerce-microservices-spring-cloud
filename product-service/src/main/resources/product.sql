CREATE TABLE product(
    uniq_id VARCHAR(255),
	crawl_timestamp VARCHAR(255),
	product_url VARCHAR(1000),
	product_name VARCHAR(255),
	category INT(20),
	pid VARCHAR(255),
	retail_price INT(10),
	discounted_price INT(10),
	image VARCHAR(20000),
	is_FK_Advantage_product VARCHAR(255),
	description VARCHAR(20000),
	product_rating  VARCHAR(255),
	overall_rating VARCHAR(255),
	brand VARCHAR(255)
    );