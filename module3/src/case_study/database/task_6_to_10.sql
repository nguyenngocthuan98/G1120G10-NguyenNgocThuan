use db_furama;

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
select hd.IDHopDong, hd.NgayLamHopDong, hd.NgayKetThuc, hd.TienDatCoc, count(hdct.IDHopDongChiTiet) as SoLuongDichVuDiKem
from HopDong hd
inner join HopDongChiTiet hdct on hd.IDHopDong = hdct.IDHopDong
group by hd.IDHopDong;