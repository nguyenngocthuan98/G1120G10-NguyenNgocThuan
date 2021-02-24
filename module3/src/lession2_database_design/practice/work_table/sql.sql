create database database_design;
use database_design;

create table contacts(
	contact_id int(11) not null auto_increment,
    last_name varchar(30) not null,
    first_name varchar(50) not null,
    birthday date,
    constraint contacts_pk primary key (contact_id) -- khoá chính của bảng này có tên là contacts_pk và được gán cho cột contact_id.
);

create table suppliers(
	supplier_id int(50) not null auto_increment,
    supplier_name varchar(30) not null,
    account_rep varchar(30) not null default 'abc',
    constraint suppliers_pk primary key (supplier_id)
);

alter table contacts add vui_ve varchar(12) after first_name; -- thêm cột vui_ve vào sau cột first_name
alter table contacts add vi_vuu varchar(12) first; -- thêm cột vi_vuu vào đầu bảng

alter table contacts add vui_ve varchar(12) after first_name, add vi_vuu varchar(12) first; -- cách thêm một lần nhiều cột 

alter table suppliers modify supplier_name varchar(50); -- sửa cột supplier_name varchar(30) not null thành varchar(50)
alter table contacts drop column vui_ve; -- xóa cột vui_ve
alter table contacts change column vi_vuu zi_zuu varchar(20) not null; -- đổi tên cột vi_vuu varchar(12) thành zi_zuu varchar(20)
alter table suppliers rename to supp; -- đổi tên bảng suppliers thành supp

drop table contacts, suppliers;
