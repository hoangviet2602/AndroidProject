-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 15, 2022 at 02:24 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phoneshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `idDH` int(11) NOT NULL,
  `idSP` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`idDH`, `idSP`, `SoLuong`, `DonGia`) VALUES
(66, 1, 1, 19999000),
(67, 2, 2, 19990000),
(68, 1, 3, 19999000),
(68, 2, 5, 19990000),
(69, 1, 2, 21500000),
(70, 1, 1, 21500000),
(71, 1, 1, 21500000),
(72, 1, 1, 21500000),
(73, 1, 2, 21500000),
(74, 1, 2, 21500000),
(74, 3, 1, 11000000),
(75, 1, 1, 21500000),
(76, 1, 1, 21500000),
(77, 2, 2, 19990000),
(77, 1, 2, 21500000);

-- --------------------------------------------------------

--
-- Table structure for table `danhmuc`
--

CREATE TABLE `danhmuc` (
  `idDM` int(11) NOT NULL,
  `TenDM` varchar(100) NOT NULL,
  `HinhAnh` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `danhmuc`
--

INSERT INTO `danhmuc` (`idDM`, `TenDM`, `HinhAnh`) VALUES
(1, 'Iphone', 'androidwebservice/drawable/apple.jpg'),
(2, 'SamSung', 'androidwebservice/drawable/samsung_logo.png'),
(3, 'Xiaomi', 'androidwebservice/drawable/xiaomi_logo.png'),
(6, 'Vivo', 'androidwebservice/drawable/vivo_logo.png'),
(7, 'Realme', 'androidwebservice/drawable/realme_logo.png'),
(8, 'Oppo', 'androidwebservice/drawable/oppo_logo.jpg'),
(9, 'Vsmart', 'androidwebservice/drawable/vsmart_ogo.jpg'),
(10, 'OnePlus', 'androidwebservice/drawable/onepluslogo2.jpg'),
(11, 'Asus', 'androidwebservice/drawable/asus_logo.png'),
(12, 'Nokia', 'androidwebservice/drawable/Nokia_logo.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

CREATE TABLE `donhang` (
  `idDH` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `TongTien` int(11) NOT NULL,
  `NgayDat` date NOT NULL DEFAULT current_timestamp(),
  `TrangThai` int(11) NOT NULL,
  `tennguoinhan` varchar(100) NOT NULL,
  `sdt` varchar(20) NOT NULL,
  `diachi` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donhang`
--

INSERT INTO `donhang` (`idDH`, `idUser`, `TongTien`, `NgayDat`, `TrangThai`, `tennguoinhan`, `sdt`, `diachi`) VALUES
(66, 1, 19999000, '2022-01-06', 0, 'Nguyễn Hoàng Việt', '0768570252', '02 Thừa Thiên Huế'),
(67, 1, 39980000, '2022-01-06', 0, 'Nguyễn Hoàng Việt', '0768570252', '02 Thanh Sơn, Hải Châu'),
(68, 1, 159947000, '2022-01-06', 1, 'Nguyễn Quốc Toản', '0768570251', '02  Nghệ An'),
(69, 1, 43000000, '2022-01-11', 0, 'Nguyễn Hoàng Việt', '0768570252', '02 Thừa Thiên Huế'),
(70, 1, 21500000, '2022-01-11', 2, 'Nguyễn Hoàng Việt', '0768570252', '02 Thừa Thiên Huế'),
(71, 1, 21500000, '2022-01-11', 1, 'Nguyễn Hoàng Việt', '0768570252', '02 Thừa Thiên Huế'),
(72, 1, 21500000, '2022-01-11', 1, 'Nguyễn Hoàng Việt', '0768570252', '02 Thừa Thiên Huế'),
(73, 1, 43000000, '2022-01-11', 2, 'Nguyễn Hoàng Việt', '0768570252', '02 Thừa Thiên Huế'),
(74, 1, 54000000, '2022-01-11', 0, 'Nguyễn Hoàng Việt', '0768570252', '02 Thừa Thiên Huế'),
(75, 1, 21500000, '2022-01-11', 1, 'Nguyễn Hoàng Việt', '0768570252', '02 Thừa Thiên Huế'),
(76, 1, 21500000, '2022-01-11', 0, 'Nguyễn Hoàng Việt', '0768570252', '02 Thừa Thiên Huế'),
(77, 1, 82980000, '2022-01-12', 0, 'Nguyễn Hoàng Việt', '0768570252', '02 Thừa Thiên Huế');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `idSP` int(11) NOT NULL,
  `idDM` int(11) NOT NULL,
  `Tittle` varchar(200) NOT NULL,
  `HinhAnh` varchar(200) NOT NULL,
  `Gia` int(11) NOT NULL,
  `UuDai` varchar(200) NOT NULL,
  `SoDanhGia` int(11) NOT NULL,
  `SoSao` int(11) NOT NULL,
  `sizemanhinh` varchar(50) DEFAULT NULL,
  `lmanhinh` varchar(50) DEFAULT NULL,
  `ram` varchar(50) DEFAULT NULL,
  `rom` varchar(50) DEFAULT NULL,
  `pin` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`idSP`, `idDM`, `Tittle`, `HinhAnh`, `Gia`, `UuDai`, `SoDanhGia`, `SoSao`, `sizemanhinh`, `lmanhinh`, `ram`, `rom`, `pin`) VALUES
(1, 1, 'iPhone 13 Pro Max 256GB I Chính hãng VN/A', 'androidwebservice/drawable/iphon13.jpg', 21500000, 'Ưu đãi đối tác 1 triệu', 13, 5, '6.1 inches', 'OLED', '4 GB', '64 GB', 'Li-Ion, sạc nhanh 20W'),
(2, 2, 'Samsung Galaxy Z Fold3 5G', 'androidwebservice/drawable/samsung1.png', 19990000, 'Ưu đãi 1 triệu đối tác', 20, 5, '5.7 inches', 'LCD', '6 GB', '128 GB', 'Li-Ion, sạc nhanh 20W'),
(3, 1, 'iPhone 13  128GB I Chính hãng VN/A', 'androidwebservice/drawable/iphon13.jpg', 11000000, 'Ưu đãi đối tác 1 triệu', 20, 4, '6.1 inches', 'FULL OLED', '8 GB', '256 GB', 'Li-Ion, sạc nhanh 20W'),
(4, 2, 'Samsung Galaxy S21 FE 5G 6GB - 128GB', 'androidwebservice/drawable/samsung_s21.jpg', 15990000, 'Khuyến mãi 5%', 45, 4, '6.4\", FHD+', 'Dynamic AMOLED', '6 GB', '128  GB', 'Exynos 2100'),
(5, 3, 'Xiaomi 11 Lite 5G NE 8GB - 256GB', 'androidwebservice/drawable/xiaomi_11.jpg', 8490000, 'Ưu đãi đối tác 1 triệu', 16, 5, '6.55\", FHD+', 'AMOLED DotDisplay', '8 Gb', '256 Gb', '4250 mAh Lithium'),
(6, 3, 'Xiaomi Redmi Note 10S 8GB-128GB', 'androidwebservice/drawable/xiaomi_note10.jpg', 6490000, 'Ưu đãi tết nguyên đán', 43, 3, '6.43\", FHD+,', 'AMOLED, 1080 x 2400', '8 Gb', '128 Gb', '5000 mAh Lithium '),
(7, 8, 'OPPO Reno6 Z 5G ', 'androidwebservice/drawable/oppo_reno6.jpg', 9490000, 'Lì xì PMH 200.000đ', 12, 5, '6.43\"  FHD+', 'AMOLED, 1080 x 2400', '8 Gb', '64 Gb', '4310 mAh  Lithium '),
(8, 8, 'OPPO A94 8GB-128GB ', 'androidwebservice/drawable/oppo_a94.jpg', 6590000, 'Giảm ngay 100.000đ', 23, 4, '6.43\" FHD+', 'AMOLED, 1080 x 2400', '8 Gb', '128 Gb', '4310 mAh Lithium '),
(9, 6, 'Vivo Y33s 8GB - 128GB', 'androidwebservice/drawable/vivo_y33s.jpg', 6690000, 'Trả góp 0%', 12, 4, '6.55\", FHD+', 'AMOLED, 1080 x 2400', '8 Gb', '128 Gb', '5000 mAh Lithium '),
(10, 6, 'Vivo V23 5G', 'androidwebservice/drawable/vivo_v23.jpg', 12490000, 'Lì xì ngày 500.000đ', 12, 4, '6.43\"  FHD+', 'AMOLED DotDisplay', '8 Gb', '128 Gb', '4250 mAh Lithium '),
(11, 7, 'Realme C21y 3GB - 32GB', 'androidwebservice/drawable/realme_c21.jpg', 2500000, 'Ưu đãi đối tác 1 triệu', 20, 4, '6.43\" FHD+', 'Dynamic AMOLED', '6 GB', '64 Gb', '4310 mAh Lithium '),
(12, 9, 'Vsmart Aris Pro 8GB-128GB', 'androidwebservice/drawable/vsmart_pro.png', 5700000, 'Lì xì 100.000đ', 45, 5, '6.4\", FHD+', 'Dynamic AMOLED', '6 GB', '128 Gb', '4310 mAh  Lithium');

-- --------------------------------------------------------

--
-- Table structure for table `thongbao`
--

CREATE TABLE `thongbao` (
  `idTB` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `Tittle` varchar(100) NOT NULL,
  `Chitiet` varchar(300) NOT NULL,
  `HinhAnh` varchar(200) NOT NULL,
  `time` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `thongbao`
--

INSERT INTO `thongbao` (`idTB`, `idUser`, `Tittle`, `Chitiet`, `HinhAnh`, `time`) VALUES
(1, 1, 'Đặt hàng thành công', 'Đơn hàng DH01 của bạn đã được đặt thành công.', 'androidwebservice/drawable/iphon13.jpg', '2022-01-11 17:02:13'),
(2, 1, 'Thông báo khuyến mãi', 'Tháng 12 deal ngon bạt ngàn: Điện thoại Samsung sale sập sàn đến 15 triệu đồng cực sốc, click xem liền', 'androidwebservice/drawable/s.PNG', '2022-01-11 17:13:13'),
(9, 1, 'Đặt hàng thành công', 'Đơn hàng 73 của bản đã được đặt thành công', 'androidwebservice/drawable/iphon13.jpg', '2022-01-11 17:33:13'),
(10, 1, 'Đặt hàng thành công', 'Đơn hàng 74 của bản đã được đặt thành công', 'androidwebservice/drawable/iphon13.jpg', '2022-01-11 17:38:39'),
(11, 1, 'Đặt hàng thành công', 'Đơn hàng 75 của bản đã được đặt thành công', 'androidwebservice/drawable/iphon13.jpg', '2022-01-11 17:44:53'),
(12, 1, 'Đặt hàng thành công', 'Đơn hàng 76 của bản đã được đặt thành công', 'androidwebservice/drawable/iphon13.jpg', '2022-01-11 17:46:09'),
(13, 1, 'Đặt hàng thành công', 'Đơn hàng 77 của bản đã được đặt thành công', 'androidwebservice/drawable/samsung1.png', '2022-01-12 22:34:01');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Pass` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `dob` date NOT NULL DEFAULT current_timestamp(),
  `address` varchar(100) NOT NULL,
  `fullname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idUser`, `Username`, `Pass`, `phone`, `dob`, `address`, `fullname`) VALUES
(1, 'viet', 'viet', '0768570252', '2022-01-04', '02 Thừa Thiên Huế', 'Nguyễn Hoàng Việt'),
(32, 'toan', '123', '1230432940', '2022-01-15', 'Nghệ An', 'Nguyễn Quốc Toản ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD KEY `idDH` (`idDH`,`idSP`),
  ADD KEY `idSP` (`idSP`);

--
-- Indexes for table `danhmuc`
--
ALTER TABLE `danhmuc`
  ADD PRIMARY KEY (`idDM`);

--
-- Indexes for table `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`idDH`),
  ADD KEY `idUser` (`idUser`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`idSP`),
  ADD KEY `idDM` (`idDM`);

--
-- Indexes for table `thongbao`
--
ALTER TABLE `thongbao`
  ADD PRIMARY KEY (`idTB`),
  ADD KEY `idUser` (`idUser`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danhmuc`
--
ALTER TABLE `danhmuc`
  MODIFY `idDM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `donhang`
--
ALTER TABLE `donhang`
  MODIFY `idDH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `idSP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `thongbao`
--
ALTER TABLE `thongbao`
  MODIFY `idTB` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD CONSTRAINT `chitietdonhang_ibfk_1` FOREIGN KEY (`idDH`) REFERENCES `donhang` (`idDH`),
  ADD CONSTRAINT `chitietdonhang_ibfk_2` FOREIGN KEY (`idSP`) REFERENCES `sanpham` (`idSP`);

--
-- Constraints for table `donhang`
--
ALTER TABLE `donhang`
  ADD CONSTRAINT `donhang_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`idDM`) REFERENCES `danhmuc` (`idDM`);

--
-- Constraints for table `thongbao`
--
ALTER TABLE `thongbao`
  ADD CONSTRAINT `thongbao_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
