-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 25, 2021 lúc 11:27 AM
-- Phiên bản máy phục vụ: 10.4.20-MariaDB
-- Phiên bản PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `cpn`
--

CREATE DATABASE `cpn` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `Id_Orders` int(11) NOT NULL,
  `RollNo` varchar(20) NOT NULL,
  `Name_Product` varchar(150) DEFAULT NULL,
  `Id_Status` int(11) DEFAULT NULL,
  `Id_User` int(11) DEFAULT NULL,
  `Id_Service` int(11) DEFAULT NULL,
  `Name_Customer` varchar(150) DEFAULT NULL,
  `Address_Customer` varchar(250) DEFAULT NULL,
  `Mobile_Customer` varchar(12) DEFAULT NULL,
  `Id_Whouse` int(11) DEFAULT NULL,
  `Weight` float DEFAULT NULL,
  `Delivery_fee` int(11) DEFAULT NULL,
  `Height` float DEFAULT NULL,
  `Wide` float DEFAULT NULL,
  `Length` float DEFAULT NULL,
  `Total_price` int(11) DEFAULT NULL,
  `Note` text DEFAULT NULL,
  `Id_Shop` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `Id_Role` int(11) NOT NULL,
  `Name_Role` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`Id_Role`, `Name_Role`) VALUES
(1, 'Admin'),
(2, 'Staff');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `service`
--

CREATE TABLE `service` (
  `Id_Service` int(11) NOT NULL,
  `Name_Service` varchar(150) DEFAULT NULL,
  `Price_Service` int(11) DEFAULT NULL,
  `Note` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `service`
--

INSERT INTO `service` (`Id_Service`, `Name_Service`, `Price_Service`, `Note`) VALUES
(1, 'Oto', 50000, 'ship bang oto'),
(2, 'Xe may', 20000, 'ship bang xe may');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `shopinfo`
--

CREATE TABLE `shopinfo` (
  `Id_Shop` int(11) NOT NULL,
  `Shopname` varchar(150) DEFAULT NULL,
  `ShopPhone` varchar(15) DEFAULT NULL,
  `Address` varchar(250) DEFAULT NULL,
  `Email` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `shopinfo`
--

INSERT INTO `shopinfo` (`Id_Shop`, `Shopname`, `ShopPhone`, `Address`, `Email`) VALUES
(1, 'Buon Ban Quan Ao Si Le', '0989898989', 'HN', 'Bbqao@gmail.com'),
(2, 'Ban Dien Thoai', '0999999999', 'ND', 'dienthoai@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `status`
--

CREATE TABLE `status` (
  `Id_Status` int(11) NOT NULL,
  `Name_Status` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `status`
--

INSERT INTO `status` (`Id_Status`, `Name_Status`) VALUES
(1, 'nhap kho'),
(2, 'xuat kho'),
(3, 'da ship');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `Id_User` int(11) NOT NULL,
  `Username` varchar(100) DEFAULT NULL,
  `Password` varchar(32) DEFAULT NULL,
  `Token` varchar(32) DEFAULT NULL,
  `Id_Role` int(11) DEFAULT NULL,
  `Active` tinyint(1) DEFAULT 0,
  `Mobile` varchar(12) DEFAULT NULL,
  `Address` varchar(250) DEFAULT NULL,
  `Fullname` varchar(150) DEFAULT NULL,
  `Email` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`Id_User`, `Username`, `Password`, `Token`, `Id_Role`, `Active`, `Mobile`, `Address`, `Fullname`, `Email`) VALUES
(1, 'Admin', 'Admin', '', 1, 1, '0909090909', 'HN', 'VNV', 'admin@gmail.com'),
(2, 'Viet', 'f6b1afe180924e5cf21fd843c1e4f366', NULL, 2, 1, '0909090901', 'HN2', 'VNV2', 'vnv@gmail.com'),
(6, 'QV', '43486ef69c2f8b2e9fd9b86997aa870b', NULL, 2, 0, '09090909QV', 'QV', 'QV', 'QV@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `warehouse`
--

CREATE TABLE `warehouse` (
  `Id_Whouse` int(11) NOT NULL,
  `Name_Whouse` varchar(150) DEFAULT NULL,
  `Address` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Note` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `warehouse`
--

INSERT INTO `warehouse` (`Id_Whouse`, `Name_Whouse`, `Address`, `Note`) VALUES
(1, 'Kho so 1', 'HN', 'Luu tru hang nhe'),
(2, 'Kho so 2', 'ND', 'Luu tru hang hoa vua tam');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `warehouse_history`
--

CREATE TABLE `warehouse_history` (
  `ID` int(11) NOT NULL,
  `Id_Whouse` int(11) DEFAULT NULL,
  `Id_Orders` int(11) DEFAULT NULL,
  `Create_At` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`Id_Orders`),
  ADD KEY `Id_Status` (`Id_Status`),
  ADD KEY `Id_User` (`Id_User`),
  ADD KEY `Id_Service` (`Id_Service`),
  ADD KEY `Id_Whouse` (`Id_Whouse`),
  ADD KEY `Id_Shop` (`Id_Shop`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`Id_Role`);

--
-- Chỉ mục cho bảng `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`Id_Service`);

--
-- Chỉ mục cho bảng `shopinfo`
--
ALTER TABLE `shopinfo`
  ADD PRIMARY KEY (`Id_Shop`);

--
-- Chỉ mục cho bảng `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`Id_Status`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Id_User`),
  ADD KEY `Id_Role` (`Id_Role`);

--
-- Chỉ mục cho bảng `warehouse`
--
ALTER TABLE `warehouse`
  ADD PRIMARY KEY (`Id_Whouse`);

--
-- Chỉ mục cho bảng `warehouse_history`
--
ALTER TABLE `warehouse_history`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Id_Whouse` (`Id_Whouse`),
  ADD KEY `Id_Orders` (`Id_Orders`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `Id_Orders` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `Id_Role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `service`
--
ALTER TABLE `service`
  MODIFY `Id_Service` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `shopinfo`
--
ALTER TABLE `shopinfo`
  MODIFY `Id_Shop` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `status`
--
ALTER TABLE `status`
  MODIFY `Id_Status` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `Id_User` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `warehouse`
--
ALTER TABLE `warehouse`
  MODIFY `Id_Whouse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `warehouse_history`
--
ALTER TABLE `warehouse_history`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`Id_Status`) REFERENCES `status` (`Id_Status`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`Id_User`) REFERENCES `users` (`Id_User`),
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`Id_Service`) REFERENCES `service` (`Id_Service`),
  ADD CONSTRAINT `orders_ibfk_4` FOREIGN KEY (`Id_Whouse`) REFERENCES `warehouse` (`Id_Whouse`),
  ADD CONSTRAINT `orders_ibfk_5` FOREIGN KEY (`Id_Shop`) REFERENCES `shopinfo` (`Id_Shop`);

--
-- Các ràng buộc cho bảng `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`Id_Role`) REFERENCES `role` (`Id_Role`);

--
-- Các ràng buộc cho bảng `warehouse_history`
--
ALTER TABLE `warehouse_history`
  ADD CONSTRAINT `warehouse_history_ibfk_1` FOREIGN KEY (`Id_Whouse`) REFERENCES `warehouse` (`Id_Whouse`),
  ADD CONSTRAINT `warehouse_history_ibfk_2` FOREIGN KEY (`Id_Orders`) REFERENCES `orders` (`Id_Orders`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
