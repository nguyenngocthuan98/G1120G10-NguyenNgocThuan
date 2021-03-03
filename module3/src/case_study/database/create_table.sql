create database db_furama;
use db_furama;

create table ViTri(
	IDViTRi int not null primary key,
    TenViTri varchar(45)
);

create table TrinhDo(
	IDTrinhDo int not null primary key,
    TrinhDo varchar(45)
);

create table BoPhan(
	IDBoPhan int not null primary key,
    TenBoPhan varchar(45)
);

create table NhanVien(
	IDNhanVien int not null primary key,
    HoTen varchar(45),
    IDViTRi int,
    foreign key(IDViTRi) references ViTri(IDViTRi),
    IDTrinhDo int,
    foreign key(IDTrinhDo) references TrinhDo(IDTrinhDo),
    IDBoPhan int,
    foreign key(IDBoPhan) references BoPhan(IDBoPhan),
    NgaySinh date,
    SoCMTND varchar(45),
    Luong varchar(45),
    SDT varchar(45),
    Email varchar(45),
    DiaChi varchar(45)
);

create table DichVuDiKem(
	IDDichVuDiKem int not null primary key,
    TenDichVuDiKem varchar(45),
    Gia int,
    DonVi int,
    TrangThaiKhaDung varchar(45)
);

create table HopDongChiTiet(
	IDHopDongChiTiet int not null primary key,
    IDHopDong int,
    foreign key(IDHopDong) references HopDong(IDHopDong),
    IDDichVuDiKem int,
    foreign key(IDDichVuDiKem) references DichVuDiKem(IDDichVuDiKem),
    SoLuong int
);

create table KieuThue(
	IDKieuThue int not null primary key,
    TenKieuThue varchar(45),
    Gia int
);

create table LoaiDichVu(
	IDLoaiDichVu int not null primary key,
    TenLoaiDichVu varchar(45)
);

create table DichVu(
	IDDichVu int not null primary key,
    TenDichVu varchar(45),
    DienTich int,
    SoTang int,
    SoNguoiToiDa int,
    ChiPhiThue varchar(45),
    IDKieuThue int,
    foreign key(IDKieuThue) references KieuThue(IDKieuThue),
    IDLoaiDichVu int,
    foreign key(IDLoaiDichVu) references LoaiDichVu(IDLoaiDichVu),
    TrangThai varchar(45)
);

create table LoaiKhach(
	IDLoaiKhach int not null primary key,
    TenLoaiKhach varchar(45)
);

create table KhachHang(
	IDKhachHang int not null primary key,
    IDLoaiKhach int,
    foreign key(IDLoaiKhach) references LoaiKhach(IDLoaiKhach),
    Hoten varchar(45),
    NgaySinh date,
    SoCMTND varchar(45),
    SDT varchar(45),
    Email varchar(45),
    DiaChi varchar(45)
);

create table HopDong(
	IDHopDong int not null primary key,
    IDNhanVien int,
    foreign key(IDNhanVien) references NhanVien(IDNhanVien),
    IDKhachHang int,
    foreign key(IDKhachHang) references KhachHang(IDKhachHang),
    IDDichVu int,
    foreign key(IDDichVu) references DichVu(IDDichVu),
    NgayLamHopDong date,
    NgayKetThuc date,
    TienDatCoc int,
    TongTien int
);
