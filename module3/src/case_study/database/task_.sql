use db_furama;

-- TASK 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * 
from NhanVien
where (HoTen like 'H%' or HoTen like 'T%' or HoTen like 'K%')
		and length(HoTen) <= 15;

-- TASK 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
-- Cách đúng tương đối: select (year(now()) - year(nv.NgaySinh)) as Tuoi from NhanVien nv;
select *
from KhachHang kh
where (timestampdiff(year, kh.NgaySinh, now()) between 18 and 50)
		and DiaChi in ('Đà Nẵng', 'Quảng Trị');

-- TASK 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
	-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select kh.IDKhachHang, HoTen, lk.TenLoaiKhach, COUNT(*) AS SoLanDatPhong
from
    KhachHang kh 
    inner join LoaiKhach lk on kh.IDLoaiKhach = lk.IDLoaiKhach
	inner join HopDong hd on kh.IDKhachHang = hd.IDKhachHang
where lk.TenLoaiKhach = 'Diamond'
group by IDKhachHang
order by SoLanDatPhong;

-- TASK 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
	-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phòng. 
	-- (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.IDKhachHang, kh.HoTen, lk.TenLoaiKhach, hd.IDHopDong, dv.TenDichVu, hd.NgayLamHopDong, hd.NgayKetThuc/*,
	case when hd.IDHopDong in 
		(select distinct IDHopDong from HopDongChiTiet hdct) 
		then dv.ChiPhiThue + SUM((hdct.SoLuong * dvdk.Gia)) 
	else dv.ChiPhiThue end
	as TongTien*/
from KhachHang kh
	left join LoaiKhach lk on kh.IDLoaiKhach = lk.IDLoaiKhach
    left join HopDong hd on kh.IDKhachHang = hd.IDHopDong
    left join DichVu dv on hd.IDDichVu = dv.IDDichVu
    left join HopDongChiTiet hdct on hd.IDHopDong = hdct.IDHopDong
    left join DichVuDiKem dvdk on hdct.IDDichVuDiKem = dvdk.IDDichVuDiKem
group by hd.IDHopDong;

-- TASK 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select dv.IDDichVu, dv.TenDichVu, dv.DienTich, dv.ChiPhiThue, ldv.TenLoaiDichVu
from DichVu dv
	inner join LoaiDichVu ldv on dv.IDLoaiDichVu = ldv.IDLoaiDichVu
    left join HopDong hd ON dv.IDDichVu = hd.IDDichVu
where dv.IDDichVu not in 
	(select IDDichVu from HopDong hd where year(hd.NgayLamHopDong) >= 2019);
    
-- TASK 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
	-- nhưng chưa từng được Khách hàng đặt phòng trong năm 2019.
select dv.IDDichVu, dv.TenDichVu, dv.DienTich, dv.SoNguoiToiDa, dv.ChiPhiThue, ldv.TenLoaiDichVu
from DichVu dv
	inner join LoaiDichVu ldv on dv.IDLoaiDichVu = ldv.IDLoaiDichVu
    left join HopDong hd ON dv.IDDichVu = hd.IDDichVu
where 
	dv.IDDichVu in 
		(select distinct IDDichVu from HopDong hd where year(NgayLamHopDong) = 2018) 
    and dv.IDDichVu not in 
		(select distinct IDDichVu from HopDong hd where year(NgayLamHopDong) = 2019)
group by dv.IDDichVu;

-- TASK 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
	-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
-- Cách 1:
select distinct HoTen from KhachHang;

-- Cách 2:
select HoTen from KhachHang group by HoTen;

-- Cách 3:
select HoTen from KhachHang
union
select HoTen from KhachHang;

-- TASK 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select 
	month(NgayLamHopDong) as Thang, 
	count(month(NgayLamHopDong)) as DoanhThu
from HopDong
where year(NgayLamHopDong) = 2019
group by Thang;

-- TASK 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).

