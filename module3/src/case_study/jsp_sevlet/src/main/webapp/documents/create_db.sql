CREATE DATABASE IF NOT EXISTS db_furama_casestudy;
USE db_furama_casestudy;
-- DROP DATABASE db_furama_casestudy;

CREATE TABLE role(
	role_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	role_name VARCHAR(45)
);

CREATE TABLE user(
	username VARCHAR(255) NOT NULL PRIMARY KEY,
	password VARCHAR(255) NOT NULL
);

CREATE TABLE user_role(
	role_id INT,
	username VARCHAR(255),
	PRIMARY KEY (role_id, username),
    FOREIGN KEY(role_id) REFERENCES role(role_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(username) REFERENCES user(username) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `position`(
	position_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    position_name VARCHAR(45)
);

CREATE TABLE education_degree(
	education_degree_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    education_degree_name VARCHAR(45)
);

CREATE TABLE division(
	division_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    division_name VARCHAR(45)
);

CREATE TABLE employee(
	employee_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(45),
    position_id INT,
    FOREIGN KEY(position_id) REFERENCES `position`(position_id) ON DELETE CASCADE ON UPDATE CASCADE,
    education_degree_id INT,
    FOREIGN KEY(education_degree_id) REFERENCES education_degree(education_degree_id) ON DELETE CASCADE ON UPDATE CASCADE,
    division_id INT,
    FOREIGN KEY(division_id) REFERENCES division(division_id) ON DELETE CASCADE ON UPDATE CASCADE,
    employee_birthday DATE,
    employee_id_card VARCHAR(45),
    employee_salary VARCHAR(45),
    employee_phone VARCHAR(45),
    employee_email VARCHAR(45),
    employee_address VARCHAR(45),
    username VARCHAR(255),
    FOREIGN KEY(username) REFERENCES user(username) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE attach_service(
	attach_service_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    attach_service_name VARCHAR(45),
    attach_service_cost INT,
    attach_service_unit VARCHAR(45),
    attach_service_status VARCHAR(45)
);

CREATE TABLE rent_type(
	rent_type_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    rent_type_name VARCHAR(45),
    rent_type_cost INT
);

CREATE TABLE service_type(
	service_type_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    service_type_name VARCHAR(45)
);

CREATE TABLE service(
	service_id VARCHAR(45) NOT NULL PRIMARY KEY,
    service_name VARCHAR(45),
    service_area INT,
    service_cost INT,
    service_max_people INT,
    rent_type_id INT,
    FOREIGN KEY(rent_type_id) REFERENCES rent_type(rent_type_id) ON DELETE CASCADE ON UPDATE CASCADE,
    service_type_id INT,
    FOREIGN KEY(service_type_id) REFERENCES service_type(service_type_id) ON DELETE CASCADE ON UPDATE CASCADE,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors int
);

CREATE TABLE customer_type(
	customer_type_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    customer_type_name VARCHAR(45)
);

CREATE TABLE customer(
	customer_id VARCHAR(45) NOT NULL PRIMARY KEY,
    customer_type_id INT,
    FOREIGN KEY(customer_type_id) REFERENCES customer_type(customer_type_id) ON DELETE CASCADE ON UPDATE CASCADE,
    customer_name VARCHAR(45),
    customer_birthday DATE,
    customer_gender BIT(1),
    customer_id_card VARCHAR(45),
    customer_phone VARCHAR(45),
    customer_email VARCHAR(45),
    customer_address VARCHAR(45)
);

CREATE TABLE contract(
	contract_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    contract_start_date DATE,
    contract_end_date DATE,
    contract_deposit INT,
    contract_total_money INT,
    employee_id INT,
    FOREIGN KEY(employee_id) REFERENCES employee(employee_id) ON DELETE CASCADE ON UPDATE CASCADE,
    customer_id VARCHAR(45),
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE ON UPDATE CASCADE,
    service_id VARCHAR(45),
    FOREIGN KEY(service_id) REFERENCES service(service_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE contract_detail(
	contract_detail_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    contract_id INT,
    FOREIGN KEY(contract_id) REFERENCES contract(contract_id)  ON DELETE CASCADE ON UPDATE CASCADE,
    attach_service_id INT,
    FOREIGN KEY(attach_service_id) REFERENCES attach_service(attach_service_id) ON DELETE CASCADE ON UPDATE CASCADE,
    quantity INT
);