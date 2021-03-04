use db_furama;

-- TASK 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select dvdk.TenDichVuDikem, kh.HoTen, kh.DiaChi
from LoaiKhach lk
	inner join Khachhang kh on lk.IDLoaiKhach = kh.IDLoaiKhach
	inner join HopDong hd on kh.IDKhachHang = hd.IDKhachHang
	inner join HopDongChiTiet hdct on hd.IDHopDong = hdct.IDHopDong
	inner join DichVudiKem dvdk on hdct.IDDichVuDiKem = dvdk.IDDichVuDiKem
where 
	lk.TenLoaiKhach = 'Diamond' and
	kh.DiaChi in ('Vinh', 'Quảng Ngãi');

-- TASK 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), 
-- TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
select hd.IDHopDong, nv.HoTen, kh.Hoten, kh.SDT, dv.TenDichVu, count(hdct.IDHopDongChiTiet) as SoLuongDichVuDikem, hd.TienDatCoc
from HopDong hd
	inner join NhanVien nv on hd.IDNhanVien = nv.IDNhanVien
	inner join Khachhang kh on hd.IDKhachHang = kh.IDKhachHang
	inner join DichVu dv on hd.IDDichVu = dv.IDDichVu
    left join HopDongChiTiet hdct on hd.IDHopDong = hdct.IDHopDong
where
	year(NgayLamHopDong) = 2019 and month(NgayLamHopDong) in (1,2,3) and month(NgayLamHopDong) not in (4,5,6,7,8,9,10,11,12);

-- TASK 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select 	
	dvdk.IDDichVuDiKem,
	dvdk.TenDichVuDiKem,
	dvdk.gia as Gia,
	count(hdct.IDDichVuDiKem) as SoLanSuDung
from DichVuDiKem dvdk
	inner join HopDongChiTiet hdct on hdct.IDDichVuDiKem = dvdk.IDDichVuDiKem
group by hdct.IDDichVuDiKem
having count(hdct.IDDichVuDiKem) =
	(
    select max(SoLanSuDung)
    from
		(select count(IDDichVuDiKem) as SoLanSuDung
        from HopDongChiTiet hdct
        group by IDDichVuDiKem) as SoLanSuDungDichVuDiKem
	);
    
/*-- bug
select dvdk.TenDichVuDiKem, hdct.SoLuong
from DichVuDiKem dvdk
inner join HopDongChiTiet hdct on dvdk.IDDichVuDiKem = hdct.IDDichVuDiKem
having max(hdct.SoLuong); */

-- TASK 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
select hd.IDHopDong, ldv.TenLoaiDichVu, dvdk.TenDichVuDiKem, count(hdct.IDHopDongChiTiet) as SoLanSuDung
from HopDong hd
	inner join DichVu dv on hd.IDDichVu = dv.IDDichVu
	left join LoaiDichVu ldv on dv.IDLoaiDichVu = ldv.IDLoaiDichVu
	left join HopDongChiTiet hdct on hd.IDHopDong = hdct.IDHopDong
	inner join DichVuDiKem dvdk on hdct.IDDichVuDiKem = dvdk.IDDichVuDiKem
group by hdct.IDDichVuDiKem
having count(hdct.IDHopDongChiTiet) = 1;

-- TASK 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
select nv.IDNhanVien, nv.HoTen, td.TrinhDo, bp.TenBoPhan, nv.SDT, nv.DiaChi
from NhanVien nv
	inner join TrinhDo td on nv.IDTrinhDo = td.IDTrinhDo
	inner join BoPhan bp on nv.IDBoPhan = bp.IDBoPhan
	inner join HopDong hd on nv.IDNhanVien = hd.IDNhanVien
where year(hd.NgayLamHopDong) in (2018, 2019)
group by nv.IDNhanVien
having count(hd.IDHopDong) <= 3;

-- TASK 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2021.

-- TASK 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với 
-- tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ (~ $435)
update KhachHang kh 
set kh.IDLoaiKhach = 
	(
		select lk.IDLoaiKhach from LoaiKhach lk where lk.TenLoaiKhach = 'Diamond'
	)
where kh.IDLoaiKhach = 
	(
		select lk.IDLoaiKhach from LoaiKhach lk where lk.TenLoaiKhach = 'Platinium'
	) 
    and kh.IDLoaiKhach =
    (
		select kh.IDKhachHang 
        from KhachHang kh 
			inner join HopDong hd on hd.IDKhachHang = kh.IDKhachHang 
		where year(hd.NgayLamHopDong) = 2019 
        group by IDKhachHang 
        having sum(hd.TongTien) > 435
    );

-- TASK 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).

-- TASK 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
update DichVuDiKem dvdk
set dvdk.gia = 2*dvdk.gia
where IDDichVuDiKem = 
( 
	/* hiển thị dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019*/
	select dvdk.IDDichVuDiKem
	from DichVuDiKem dvdk
		inner join HopDongChiTiet hdct on dvdk.IDDichVuDiKem = hdct.IDDichVuDiKem
		inner join HopDong hd on hd.IDHopDong = hdct.IDHopDong
	where year(hd.NgayLamHopDong) = 2019
	group by dvdk.IDDichVuDiKem
	having sum(hdct.SoLuong) > 10
);

-- TASK 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm 
-- ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select kh.IDKhachHang as ID, kh.HoTen, kh.Email, kh.SDT, kh.NgaySinh, kh.DiaChi from KhachHang kh
union all
select nv.IDNhanVien as ID, nv.HoTen, nv.Email, nv.SDT, nv.NgaySinh, nv.DiaChi from NhanVien nv;
