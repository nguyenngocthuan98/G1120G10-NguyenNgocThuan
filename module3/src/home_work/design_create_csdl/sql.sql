CREATE DATABASE home_work;
USE home_work;

CREATE TABLE cong_trinh(
	mact INT NOT NULL PRIMARY KEY,
    tenct VARCHAR(255) NOT NULL,
    diadiem VARCHAR(255) NOT NULL,
    ngaycapgp DATE NOT NULL,
    ngaykc DATE NOT NULL,
    ngayht DATE NOT NULL
);

CREATE TABLE nhan_vien(
	manv INT NOT NULL PRIMARY KEY,
    hoten VARCHAR(255) NOT NULL,
    ngaysinh DATE NOT NULL,
    phai TINYINT NOT NULL,
    diachi VARCHAR(255) NOT NULL
);

CREATE TABLE bao_hiem(
	masobh INT NOT NULL PRIMARY KEY,
    ngaycap INT NOT NULL,
    thoihan DATE NOT NULL
);

CREATE TABLE phong_ban(
	mapb INT NOT NULL,
    tenpb VARCHAR(255) NOT NULL
);

CREATE TABLE ngay_cong(
	manv INT NOT NULL,
	mact INT NOT NULL,
    PRIMARY KEY(manv, mact),
    FOREIGN KEY(manv) REFERENCES nhan_vien(manv),
    FOREIGN KEY(mact) REFERENCES cong_trinh(mact)
);

ALTER TABLE nhan_vien 
	ADD mapb int NOT NULL,
	ADD FOREIGN KEY(mapb) REFERENCES phong_ban(mapb);

ALTER TABLE bao_hiem 
	ADD manv int NOT NULL,
	ADD FOREIGN KEY(manv) REFERENCES nahnvien(manv);