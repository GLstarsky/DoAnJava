-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 18, 2024 lúc 03:09 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlycuahangsach`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `Ma` int(11) NOT NULL,
  `MaPhieuNhap` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieuxuat`
--

CREATE TABLE `chitietphieuxuat` (
  `Ma` int(11) NOT NULL,
  `MaPhieuXuat` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `ThanhTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chuongtrinhkhuyenmai`
--

CREATE TABLE `chuongtrinhkhuyenmai` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(100) NOT NULL,
  `NgayBD` date NOT NULL,
  `NgayKT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chuongtrinhkhuyenmai`
--

INSERT INTO `chuongtrinhkhuyenmai` (`Ma`, `Ten`, `NgayBD`, `NgayKT`) VALUES
(0, 'Giảm 30% cho 1 số sách nhất định', '2024-09-12', '2024-09-24'),
(1, 'Giảm giá tháng 9', '2024-09-01', '2024-09-30'),
(2, 'Giảm 15% cho 1 số sách nhất định', '2024-09-01', '2024-10-01'),
(5, 'Giảm giá đơn hàng', '2024-09-02', '2024-09-23'),
(6, 'Giảm siêu sốc', '2024-09-05', '2024-09-30'),
(7, 'Giảm 10% cho 1 số sách nhất định', '2024-09-01', '2024-09-30');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `Ma` int(11) NOT NULL,
  `Ho` varchar(50) NOT NULL,
  `Ten` varchar(100) NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `SoDienThoai` varchar(100) NOT NULL,
  `TinhTrang` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`Ma`, `Ho`, `Ten`, `DiaChi`, `SoDienThoai`, `TinhTrang`) VALUES
(1, 'Nguyễn', 'Hằng', 'hồ Chí Minh', '0236987456', 1),
(2, 'Thu', 'Uyên', '39 Nguyễn Thượng Hiền', '092472162', 1),
(3, 'Xuân', 'Phương', '46/10 Nguyễn Trãi', '0378583984', 1),
(4, 'Đức', 'Anh', '60 Điện Biên Phủ', '09647287223', 1),
(5, 'Nguyễn', 'Hùng', '66 Pasteur', '0957837433', 1),
(6, 'Minh', 'Hằng', '39 CMT8', '0983746274', 1),
(7, 'mi', 'mii', '23 seee', '0223434332', 1),
(8, 'Kim', 'Ngan', '23 Nguyen Thien Thuat', '0859375833', 1),
(9, 'Thanh', 'Hằng', 'ư43bfe', '0993849233', 1),
(10, 'Kim', 'Ngan', '23 Nguyen Thien Thuat', '0859375833', 1),
(11, 'Bảo', 'Hân', 'nkbbasw', '0999999999', 1),
(12, 'Bảo', 'Hân', 'nkbbasw', '0999999999', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmaitheosanpham`
--

CREATE TABLE `khuyenmaitheosanpham` (
  `Ma` varchar(15) NOT NULL,
  `MaChuongTrinh` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `PhanTramKM` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khuyenmaitheosanpham`
--

INSERT INTO `khuyenmaitheosanpham` (`Ma`, `MaChuongTrinh`, `MaSach`, `PhanTramKM`) VALUES
('GGS001', 0, 6, 30),
('GGS002', 0, 17, 30),
('GGS003', 0, 13, 30),
('GGS004', 0, 4, 30),
('GGS005', 2, 15, 15),
('GGS006', 2, 18, 15),
('GGS007', 7, 5, 10),
('GGS008', 7, 9, 10),
('GGS009', 7, 1, 10),
('GGS010', 7, 4, 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmaitheotongtien`
--

CREATE TABLE `khuyenmaitheotongtien` (
  `Ma` varchar(15) NOT NULL,
  `MaChuongTrinh` int(11) NOT NULL,
  `DieuKienApDung` int(11) NOT NULL,
  `PhanTramKM` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khuyenmaitheotongtien`
--

INSERT INTO `khuyenmaitheotongtien` (`Ma`, `MaChuongTrinh`, `DieuKienApDung`, `PhanTramKM`) VALUES
('GGHD001', 1, 500000, 10),
('GGHD002', 1, 1000000, 15),
('GGHD003', 1, 399000, 15),
('GGHD004', 6, 900000, 20),
('GGHD005', 5, 750000, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`Ma`, `Ten`) VALUES
(2, 'Công Ty Cổ Phần Phát Hành Sách Tp. HCM'),
(3, 'Trí Tuệ - Công Ty Cổ Phần Sách & Thiết Bị Giáo Dục Trí Tuệ'),
(4, 'Công Ty TNHH Văn Hóa Việt Long'),
(5, 'Công Ty TNHH Đăng Nguyên'),
(6, 'Công Ty Cổ Phần Sách Mcbooks'),
(7, 'Nhà Sách Trực Tuyến BOOKBUY.VN'),
(8, 'Quỳnh Phát - Công Ty TNHH Thương Mại Dịch Vụ Quỳnh Phát'),
(9, 'Nhà Sách Bích Quân'),
(10, 'Nhà Sách Trực Tuyến Atlazbooks'),
(11, 'Nhà Sách Ngoại Văn BOA(Books Of Awesome)');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `Ma` int(11) NOT NULL,
  `Ho` varchar(50) NOT NULL,
  `Ten` varchar(100) NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `GioiTinh` varchar(100) NOT NULL,
  `ChucVu` varchar(100) NOT NULL,
  `SoDienThoai` varchar(100) NOT NULL,
  `MucLuong` int(11) NOT NULL,
  `TinhTrang` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`Ma`, `Ho`, `Ten`, `DiaChi`, `GioiTinh`, `ChucVu`, `SoDienThoai`, `MucLuong`, `TinhTrang`) VALUES
(1, 'Phan', 'Hồng', 'Hồ Chí Minh', 'Nữ', 'Quản lý', '0236987456', 650000000, 1),
(2, 'Trần', 'Hân', '272 An Dương Vương', 'Nữ', 'Nhân viên bán', '097313272', 200000, 1),
(3, 'Lê', 'Anh', '28 Nguyen Thong', 'Nam', 'Nhân viên bán', '0954743333', 3000000, 1),
(4, 'Viet', 'Anh', '', 'Nam', 'Nhân viên nhập hàng', '0979348323', 3000000, 1),
(5, 'Thu', 'Thao', '', 'Nữ', 'Nhân viên nhập hàng', '0283490293', 3200000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`Ma`, `Ten`) VALUES
(1, 'Kim Đồng'),
(2, 'Lao Động'),
(3, 'Hội Nhà văn'),
(4, 'Chính trị quốc gia Sự thật'),
(5, 'Thanh Niên'),
(6, 'Nhã Nam'),
(7, 'Tổng hợp TP.Hồ Chí Minh'),
(8, 'Hồng Đức'),
(9, 'Nhiều NXB'),
(10, 'Quân Đội Nhân Dân'),
(11, 'Dân trí');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanloai`
--

CREATE TABLE `phanloai` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phanloai`
--

INSERT INTO `phanloai` (`Ma`, `Ten`) VALUES
(1, 'Tiểu thuyết'),
(2, 'Văn học'),
(3, 'Lịch sử'),
(4, 'Trinh thám - Hình sự'),
(5, 'Sách tự lực'),
(6, 'Tâm lý - Tình cảm'),
(7, 'Ngoại ngữ'),
(8, 'Học thuật'),
(9, 'Khác');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `Ma` int(11) NOT NULL,
  `MaNCC` int(11) NOT NULL,
  `MaNV` int(11) NOT NULL,
  `NgayTao` date NOT NULL,
  `TongTien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`Ma`, `MaNCC`, `MaNV`, `NgayTao`, `TongTien`) VALUES
(1, 2, 1, '2024-05-23', 250000),
(2, 10, 4, '2024-05-24', 8950000),
(3, 6, 5, '2024-05-24', 2350000),
(4, 3, 4, '2024-05-24', 2400000),
(5, 3, 4, '2024-05-24', 2040000),
(6, 5, 4, '2024-05-24', 1800000),
(7, 2, 5, '2024-05-24', 860000),
(8, 3, 4, '2024-05-24', 950000),
(9, 5, 5, '2024-05-24', 1348200),
(10, 4, 5, '2024-09-11', 110000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `Ma` int(11) NOT NULL,
  `NgayTao` date NOT NULL,
  `MaNV` int(11) NOT NULL,
  `MaKH` int(11) NOT NULL,
  `TongTien` int(11) NOT NULL,
  `TongTienPhaiTra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuxuat`
--

INSERT INTO `phieuxuat` (`Ma`, `NgayTao`, `MaNV`, `MaKH`, `TongTien`, `TongTienPhaiTra`) VALUES
(11, '2024-05-22', 2, 8, 282000, 216600),
(12, '2024-05-08', 3, 3, 608000, 547200),
(13, '2024-05-20', 2, 1, 221000, 221000),
(14, '2024-05-20', 2, 7, 200000, 200000),
(15, '2024-05-23', 1, 8, 112000, 112000),
(16, '2024-05-23', 1, 8, 168000, 168000),
(17, '2024-05-23', 1, 8, 167000, 167000),
(18, '2024-05-23', 2, 6, 120000, 120000),
(19, '2024-05-23', 2, 6, 120000, 120000),
(20, '2024-05-23', 1, 8, 127000, 127000),
(21, '2024-05-23', 3, 3, 420000, 348000),
(22, '2024-05-23', 1, 8, 540000, 540000),
(23, '2024-05-23', 1, 9, 1335000, 1302300),
(43, '2024-09-14', 4, 9, 205000, 205000),
(44, '2024-09-14', 1, 12, 100000, 0),
(45, '2024-09-14', 1, 12, 100000, 0),
(46, '2024-09-14', 1, 8, 356000, 356000),
(47, '2024-09-14', 1, 12, 392000, 392000),
(48, '2024-09-14', 1, 12, 78000, 78000),
(49, '2024-09-14', 5, 6, 752000, 752000),
(50, '2024-09-14', 1, 12, 120000, 120000),
(51, '2024-09-14', 1, 12, 120000, 120000),
(52, '2024-09-14', 1, 12, 37000, 37000),
(53, '2024-09-14', 4, 7, 240000, 240000),
(54, '2024-09-14', 1, 12, 572000, 564000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(100) NOT NULL,
  `TacGia` varchar(100) NOT NULL,
  `MaLoai` int(11) NOT NULL,
  `MaNXB` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `HinhAnh` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`Ma`, `Ten`, `TacGia`, `MaLoai`, `MaNXB`, `SoLuong`, `DonGia`, `HinhAnh`) VALUES
(1, 'Nhà giả kim', 'Paulo Coelho', 1, 9, 0, 80000, 'meomeo.jpg'),
(2, 'Quyền lực hướng thiện', 'Trương Quốc Ký', 1, 5, 0, 230000, 'Sach2.png'),
(3, 'Giải mã thuật tiên tri', 'Elsie Wild', 9, 8, 0, 76000, 'Sach3.png'),
(4, 'Giữa bóng tối và ánh sáng', 'Joan Chittister', 1, 8, 0, 64000, 'Sach4.png'),
(5, 'Đường Xa Nắng Mới', 'Nguyễn Tường Bách', 2, 3, 0, 180000, 'Sach5.png'),
(6, 'Cơm Bắc Giặc Nam', 'Phùng Phương Quý', 2, 10, 0, 120000, 'Sach6.png'),
(7, 'Bình Minh Phía Trước', 'Nguyễn Trọng Luân', 2, 10, 0, 120000, 'Sach7.png'),
(8, 'Linh Hồn Báo Thù', 'Joe Hill', 2, 5, 0, 167000, 'Sach8.png'),
(9, 'Nhân Gian Tiểu Mãn', 'Cô Tô A Tiêu', 2, 11, 0, 76000, 'Sach9.png'),
(10, 'Phan Huy Lê Di Cảo - Nhận Thức Lịch Sử Việt Nam', 'Phan Huy Lê', 3, 11, 0, 392000, 'Sach10.png'),
(11, 'Điện Biên Phủ - Những Trang Vàng Lịch Sử', 'Hoàng Minh Phương', 3, 5, 0, 108000, 'Sach11.png'),
(12, 'Miền Bắc - Một Thời Chiến Tranh, Một Thời Hòa Bình', 'Folke Isaksson', 3, 5, 0, 228000, 'Sach12.png'),
(13, 'Sự im lặng của bầy cừu', 'Thomas Harris', 4, 9, 0, 109000, 'Sach13.png'),
(14, 'Án mạng trên sông Nile', 'Agatha Christie', 4, 9, 0, 125000, 'Sach14.png'),
(15, 'Hỏa ngục', 'Dan Brown', 4, 9, 0, 153000, 'Sach15.png'),
(16, 'Tâm Lý Học Tội Phạm', 'Stanton E.Samenow', 4, 9, 0, 94000, 'Sach16.png'),
(17, 'Thái Nhân Cách Phía Sau Tội Ác', 'James Fallon', 4, 9, 0, 132000, 'Sach17.png'),
(18, 'Tư duy nhanh và chậm', 'Daniel Kahneman', 5, 9, 0, 201000, 'Sach18.png'),
(19, 'Mình là cá, việc của mình là bơi', 'Takeshi Furukawa', 5, 3, 0, 90000, 'Sach19.png'),
(20, 'Một Đời Quản Trị', 'Phan Văn Trường', 4, 8, 0, 80000, 'Sach30.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tacgia`
--

CREATE TABLE `tacgia` (
  `Ma` int(11) NOT NULL,
  `Ten` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tacgia`
--

INSERT INTO `tacgia` (`Ma`, `Ten`) VALUES
(1, 'Nguyễn Nhật Ánh'),
(2, 'Lê Linh'),
(3, 'Jack London'),
(4, 'Joan Chittister'),
(5, 'Trương Quốc Ký'),
(6, 'Tô Hoài'),
(7, 'Elsie Wild'),
(8, 'Shakti Gawain\r\n'),
(9, 'José Mauro de Vasconcelos'),
(10, 'Antoine de Saint-Exupéry');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`Ma`),
  ADD KEY `fk_ibfk_4` (`MaSach`),
  ADD KEY `fk_ibfk_3` (`MaPhieuNhap`);

--
-- Chỉ mục cho bảng `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD PRIMARY KEY (`Ma`),
  ADD KEY `MaSach` (`MaSach`),
  ADD KEY `chitietphieuxuat_ibfk_1` (`MaPhieuXuat`);

--
-- Chỉ mục cho bảng `chuongtrinhkhuyenmai`
--
ALTER TABLE `chuongtrinhkhuyenmai`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `khuyenmaitheosanpham`
--
ALTER TABLE `khuyenmaitheosanpham`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `Ma` (`Ma`),
  ADD KEY `MaChuongTrinh` (`MaChuongTrinh`);

--
-- Chỉ mục cho bảng `khuyenmaitheotongtien`
--
ALTER TABLE `khuyenmaitheotongtien`
  ADD PRIMARY KEY (`Ma`),
  ADD UNIQUE KEY `Ma` (`Ma`),
  ADD KEY `MaChuongTrinh` (`MaChuongTrinh`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `phanloai`
--
ALTER TABLE `phanloai`
  ADD PRIMARY KEY (`Ma`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`Ma`),
  ADD KEY `MaNCC` (`MaNCC`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Chỉ mục cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`Ma`),
  ADD KEY `MaNV` (`MaNV`),
  ADD KEY `MaKH` (`MaKH`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`Ma`),
  ADD KEY `MaNXB` (`MaNXB`),
  ADD KEY `MaLoai` (`MaLoai`);

--
-- Chỉ mục cho bảng `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`Ma`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  MODIFY `Ma` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  MODIFY `Ma` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `Ma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `Ma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `Ma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  MODIFY `Ma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `phanloai`
--
ALTER TABLE `phanloai`
  MODIFY `Ma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `Ma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  MODIFY `Ma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT cho bảng `sach`
--
ALTER TABLE `sach`
  MODIFY `Ma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT cho bảng `tacgia`
--
ALTER TABLE `tacgia`
  MODIFY `Ma` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `fk_ibfk_3` FOREIGN KEY (`MaPhieuNhap`) REFERENCES `phieunhap` (`Ma`),
  ADD CONSTRAINT `fk_ibfk_4` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`Ma`);

--
-- Các ràng buộc cho bảng `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD CONSTRAINT `fk_ibfk_1` FOREIGN KEY (`MaPhieuXuat`) REFERENCES `phieuxuat` (`Ma`),
  ADD CONSTRAINT `fk_ibfk_2` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`Ma`);

--
-- Các ràng buộc cho bảng `khuyenmaitheosanpham`
--
ALTER TABLE `khuyenmaitheosanpham`
  ADD CONSTRAINT `khuyenmaitheosanpham_ibfk_1` FOREIGN KEY (`MaChuongTrinh`) REFERENCES `chuongtrinhkhuyenmai` (`Ma`);

--
-- Các ràng buộc cho bảng `khuyenmaitheotongtien`
--
ALTER TABLE `khuyenmaitheotongtien`
  ADD CONSTRAINT `fk_ibfk_8` FOREIGN KEY (`MaChuongTrinh`) REFERENCES `chuongtrinhkhuyenmai` (`Ma`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `fk_ibfk_11` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`Ma`),
  ADD CONSTRAINT `fk_ibfk_12` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`Ma`);

--
-- Các ràng buộc cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `fk_ibfk_10` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`Ma`),
  ADD CONSTRAINT `fk_ibfk_9` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`Ma`);

--
-- Các ràng buộc cho bảng `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `fk_ibfk_7` FOREIGN KEY (`MaLoai`) REFERENCES `phanloai` (`Ma`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
