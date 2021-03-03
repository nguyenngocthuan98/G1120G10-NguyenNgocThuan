use db_furama;

-- TASK 1.	Thêm mới thông tin cho tất cả các bảng 
insert into LoaiDichVu(IDLoaiDichVu, TenLoaiDichVu) values
	(1, 'Villa'),
	(2, 'House'),
	(3, 'Room');
    
insert into KieuThue(IDKieuThue, TenKieuThue, Gia) values
(1, 'năm', 12000),
(2, 'tháng', 1000),
(3, 'ngày', 33),
(4, 'giờ', 2);

insert into DichVu
	(IDDichVu, TenDichVu, DienTich, SoTang, SoNguoiToiDa, ChiPhiThue, IDKieuThue, IDLoaiDichVu, TrangThai) values
	(1, 'Villa A1', 100, 3, 16, 500, 3, 1, 'Hoạt động'),
	(2, 'House A2', 70, 2, 10, 300, 3, 2, 'Hoạt động'),
	(3, 'Room C1', 25, 3, 2, 100, 4, 3, 'Hoạt động'),
	(4, 'House E7', 60, 3, 16, 300, 3, 2, 'Hoạt động'),
	(5, 'Villa SS', 200, 3, 20, 700, 2, 1, 'Hoạt động'),
	(6, 'Room SS', 50, 3, 16, 200, 3, 3, 'Hoạt động'),
	(7, 'Room E2', 50, 3, 16, 200, 3, 3, 'Hoạt động'),
    (8, 'House P7', 60, 3, 16, 300, 3, 2, 'Hoạt động'),
    (9, 'House K7', 60, 3, 16, 300, 3, 2, 'Hoạt động');
    
insert into DichVuDiKem(IDDichVuDiKem, TenDichVuDiKem, Gia, DonVi, TrangThaiKhaDung) values
	(1, 'Massage', 25, 1, 'Khả dụng'),
	(2, 'Karaoke', 45, 1, 'Khả dụng'),
	(3, 'Thức ăn', 10, 1, 'Khả dụng'),
	(4, 'Nước uống', 5, 1, 'Khả dụng'),
	(5, 'Thuê xe', 45, 1, 'Khả dụng');

insert into ViTri(IDViTRi, TenViTri) values 
	(1, 'Lễ tân'),
	(2, 'Phục vụ'),
	(3, 'Chuyên viên'),
	(4, 'Giám sát'),
	(5, 'Quản lý'),
	(6, 'Giám đốc');
    
insert into TrinhDo(IDTrinhDo, TrinhDo) values 
	(1, 'Trung cấp'),
	(2, 'Cao đẳng'),
	(3, 'Đại học'),
	(4, 'Sau đại học');
    
insert into BoPhan(IDBoPhan, TenBoPhan) values 
	(1, 'Sale – Marketing'),
	(2, 'Hành chính'),
	(3, 'Phục vụ'),
	(4, 'Quản lý');
    
insert into NhanVien
	(IDNhanVien, HoTen, IDViTRi, IDTrinhDo, IDBoPhan, NgaySinh, SoCMTND, Luong, SDT, Email, DiaChi) values 
	(1, 'Hoàng Lê Quang', 5, 3, 4, '1993/07/03', '891234567', '2300', '0987654321', 'wuang_nee_chan@furama.com', 'Đà Nẵng'),
	(2, 'Trần Quốc Hoàng', 4, 3, 4, '1996/02/04', '891111262', '1200', '0927483939', 'guoang_nii_san@furama.com', 'Quảng Nam'),
	(3, 'Nguyễn Hoàng Bảo Ngọc', 3, 3, 1, '1997/10/03', '891234263', '1200', '0985285078', 'ngok_pro_vjp@furama.com', 'Quảng Trị'),
	(4, 'Nguyễn Ngọc Thuần', 6, 4, 4, '1998/09/16', '621136886', '3600', '0912345678', 'daica_thuan_pro@furama.com', 'Huế'),
	(5, 'Nguyễn Hữu Nghĩa', 5, 3, 4, '1997/12/03', '891342567', '2200', '098254321', 'ngkia_ni_chan@furama.com', 'Đà Nẵng'),
	(6, 'Cái Mây', 4, 3, 1, '1997/07/03', '891234567', '2500', '0987654321', 'cloud_girl@furama.com', 'Quảng Bình'),
	(7, 'Nguyễn Vân', 1, 2, 3, '1997/07/03', '832235562', '300', '098784837', 'nguyenvan@furama.com', 'Hà Nội'),
	(8, 'Cao Hà Vũ', 1, 2, 3, '1993/07/03', '892224567', '305', '0987623121', 'caohavu@furama.com', 'Quảng Ngãi'),
	(9, 'Mai Quốc Khánh', 2, 2, 3, '1992/07/03', '89436563', '290', '0987676581', 'maiquockhanh@furama.com', 'Hà Tĩnh'),
    (10,'Trằng Guốc Goàng', 1, 2, 2, '1995/12/12', '123123123', '300000', '0909123111', 'goangtg@furama.com', 'Quảng Nam'),
	(11,'Trần Hong', 3, 2, 1, '2001/12/05', '123123456', '350000', '0909123123', 'hongt@furama.com', 'Nha Trang');

insert into LoaiKhach(IDLoaiKhach, TenLoaiKhach) values
	(1, 'Diamond'),
    (2, 'Platinium'),
    (3, 'Gold'),
    (4, 'Silver'),
    (5, 'Member');

insert into KhachHang
	(IDKhachHang, IDLoaiKhach, Hoten, NgaySinh, SoCMTND, SDT, Email, DiaChi) values
    (2, 1, 'Trần Quốc Hoàng', '1996/02/04', '891111262', '0927483939', 'guoang_nii_san@customer.com', 'Quảng Ngãi'),
	(3, 3, 'Nguyễn Hoàng Bảo Ngọc', '1997/10/03', '891234263', '0985285078', 'ngok_pro_vjp@customer.com', 'Quảng Trị'),
	(4, 1, 'Nguyễn Ngọc Thuần', '1998/09/16', '621136886', '0912345678', 'daica_thuan_pro@customer.com', 'Huế'),
	(5, 5,'Nguyễn Hữu Nghĩa', '1997/12/03', '891342567', '098254321', 'ngkia_ni_chan@customer.com', 'Đà Nẵng'),
	(6, 4, 'Cái Mây', '1997/07/03', '891234567', '0987654321', 'cloud_girl@customer.com', 'Quảng Bình'),
	(7, 1, 'Nguyễn Vân', '1997/07/03', '832235562', '098784837', 'nguyenvan@customer.com', 'Hà Nội'),
	(8, 2, 'Nguyễn Thị Tường Vi', '1992/07/03', '832235562', '098784837', 'nttv@customer.com', 'Quảng Ngãi'),
	(10, 5, 'Nguyễn Ngọc Đông', '1985/07/03', '832235562', '098784837', 'qua_tuyet_voi@customer.com', 'Cà Mau'),
    (11, 3, 'Nguyễn Ngọc Đông', '1985/01/01', '832111562', '098222837', 'dong_jp@customer.com', 'Cà Lâu');

insert into HopDong
	(IDHopDong, IDNhanVien, IDKhachHang, IDDichVu, NgayLamHopDong, NgayKetThuc, TienDatCoc, TongTien) values
	(1, 10, 4, 1, '2020/05/07', '2020/05/09', 50, 5000),
	(2, 8, 2, 2, '2020/05/07', '2020/05/09', 50, 6000),
	(3, 10, 3, 4, '2020/05/07', '2020/05/09', 50, 2000),
	(4, 8, 4, 5, '2020/06/07', '2020/06/09', 50, 1000),
	(5, 10, 5, 4, '2020/05/07', '2020/05/09', 50, 5400),
	(6, 10, 6, 8, '2020/05/07', '2020/05/09', 50, 5030),
	(7, 8, 7, 8, '2020/05/07', '2020/05/09', 50, 2300),
	(8, 10, 8, 8, '2020/05/07', '2020/01/09', 50, 5000),
	(9, 10, 6, 5, '2020/01/07', '2020/01/09', 50, 5000),
	(10, 8, 10, 9, '2020/05/07', '2020/05/09', 50, 5400),
	(11, 8, 6, 1, '2019/05/07', '2019/05/09', 50, 5000),
	(12, 10, 4, 1, '2019/05/07', '2019/05/09', 50, 5000),
	(13, 10, 5, 2, '2019/05/07', '2019/05/09', 50, 5000),
	(14, 10, 4, 4, '2019/12/12', '2019/12/14', 50, 5000),
    (15, 10, 8, 8, '2016/05/07', '2016/01/09', 50, 5000),
	(16, 10, 6, 5, '2016/01/07', '2016/01/09', 50, 5000),
    (17, 10, 8, 9, '2018/05/07', '2018/01/09', 50, 5000),
	(18, 10, 6, 5, '2018/01/07', '2018/01/09', 50, 5000);
    
insert into HopDongChiTiet(IDHopDongChiTiet, IDHopDong, IDDichVuDiKem, SoLuong) values 
(1, 2, 3, 10),
(2, 3, 4, 10),
(3, 1, 3, 11),
(4, 8, 3, 10),
(5, 5, 2, 2);
