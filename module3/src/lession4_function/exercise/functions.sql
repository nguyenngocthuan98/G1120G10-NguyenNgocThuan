CREATE DATABASE ss4;
USE ss4;

CREATE TABLE users(
	id int,
    ten varchar(10),
    tuoi int,
    khoahoc varchar(10),
    sotien int
);

INSERT INTO users VALUES 
	(1, "Hoang", 21, "CNTT", 40000),
	(2, "Viet", 19, "DTVT", 32000),
	(3, "Thanh", 18, "KTVN", 40000),
	(4, "Nhan", 19, "CK", 45000),
	(5, "Huong", 20, "TCNH", 50000),
	(5, "Huong", 20, "TCNH", 20000);
    
-- Viết câu lệnh hiện thị tất cả các dòng có tên là Huong
SELECT * FROM users WHERE ten = "Huong";

-- Viết câu lệnh lấy ra tổng số tiền của Huong
SELECT SUM(sotien) FROM users as tong_tien WHERE ten = "Huong";

-- Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp
SELECT * FROM users GROUP BY ten;