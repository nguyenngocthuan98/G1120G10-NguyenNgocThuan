use database_design;
-- các cách tạo bảng users với khóa chính
CREATE TABLE users(
   user_id INT AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(40),
   password VARCHAR(255),
   email VARCHAR(255)
);

CREATE TABLE roles(
   role_id INT AUTO_INCREMENT,
   role_name VARCHAR(50),
   PRIMARY KEY(role_id)
);

-- ALTER TABLE table_name ADD PRIMARY KEY(primary_key_column);

CREATE TABLE userroles(
   user_id INT NOT NULL,
   role_id INT NOT NULL,
   PRIMARY KEY(user_id,role_id),
   FOREIGN KEY(user_id) REFERENCES users(user_id), -- khóa ngoại
   FOREIGN KEY(role_id) REFERENCES roles(role_id) -- khóa ngoại
);