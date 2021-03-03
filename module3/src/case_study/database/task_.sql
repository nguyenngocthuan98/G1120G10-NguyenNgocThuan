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
select IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien
from KhachHang kh
	left join LoaiKhach lk on kh.IDLoaiKhach = lk.IDLoaiKhach
    left join HopDong hd on kh.IDKhachHang = hd.IDHopDong
    left join DichVu dv on
    left join HopDongChiTiet hdct on
    left join DichVuDiKem dvdk on 
group by hd.IDHopDong;