use db_furama;

-- TASK 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
	-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phòng. 
	-- (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.IDKhachHang, kh.HoTen, lk.TenLoaiKhach, hd.IDHopDong, dv.TenDichVu, hd.NgayLamHopDong, hd.NgayKetThuc,
	case when hd.IDHopDong in 
		(select distinct IDHopDong from HopDongChiTiet hdct) 
		then dv.ChiPhiThue + SUM((hdct.SoLuong * dvdk.Gia)) 
	else dv.ChiPhiThue end
	as TongTien
from KhachHang kh
	left join LoaiKhach lk on kh.IDLoaiKhach = lk.IDLoaiKhach
    left join HopDong hd on kh.IDKhachHang = hd.IDHopDong
    left join DichVu dv on hd.IDDichVu = dv.IDDichVu
    left join HopDongChiTiet hdct on hd.IDHopDong = hdct.IDHopDong
    left join DichVuDiKem dvdk on hdct.IDDichVuDiKem = dvdk.IDDichVuDiKem
group by hd.IDHopDong;