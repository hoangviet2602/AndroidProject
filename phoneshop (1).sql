-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2022 at 10:29 AM
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
(68, 2, 5, 19990000);

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
(68, 1, 159947000, '2022-01-06', 0, 'Nguyễn Quốc Toản', '0768570251', '02  Nghệ An');

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
(3, 1, 'Iphone13 Pro Max', 'androidwebservice/drawable/iphon13.jpg', 11000000, 'Ưu đãi đối tác 1 triệu', 20, 4, '6.1 inches', 'FULL OLED', '8 GB', '256 GB', 'Li-Ion, sạc nhanh 20W');

-- --------------------------------------------------------

--
-- Table structure for table `thongbao`
--

CREATE TABLE `thongbao` (
  `idTB` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `Tittle` varchar(100) NOT NULL,
  `Chitiet` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(1, 'viet', 'viet', '0768570252', '2022-01-04', '02 Thừa Thiên Huế', 'Nguyễn Hoàng Việt');

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
  MODIFY `idDH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `idSP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `thongbao`
--
ALTER TABLE `thongbao`
  MODIFY `idTB` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
