-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 13, 2021 at 02:37 PM
-- Server version: 8.0.19
-- PHP Version: 7.3.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `demolearnproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `id` int NOT NULL,
  `logo` varchar(45) DEFAULT NULL,
  `name` varchar(150) NOT NULL,
  `deleted` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`id`, `logo`, `name`, `deleted`) VALUES
(1, 'photo_2019-06-25_01-48-29.jpg', 'textile3333fewfwee', b'0'),
(2, '51Ftp7RcmvL._AC_.jpg', 'Editor', b'1'),
(3, 'photo_2019-06-25_01-48-29.jpg', 'Samsung', b'1'),
(4, 'photo_2021-05-22_11-11-44.jpg', 'fefwefe', b'1'),
(5, 'photo_2019-06-25_01-48-29.jpg', 'bmwhtrht', b'0'),
(6, 'photo_2019-06-25_01-48-29.jpg', 'grergeg', b'0'),
(7, 'photo_2021-05-21_10-25-38.jpg', 't4t43t43t43', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `brand_id` int DEFAULT NULL,
  `deleted` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`, `brand_id`, `deleted`) VALUES
(1, 'contact', 2, b'1'),
(2, 'teamviewer', NULL, b'0'),
(3, 'bmw', 7, b'0'),
(4, 'Computergregreg', NULL, b'0'),
(5, 'Bomba', NULL, b'0'),
(6, 'fewfef', NULL, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `file_details`
--

CREATE TABLE `file_details` (
  `id` int NOT NULL,
  `file` varchar(120) NOT NULL,
  `file_extension` varchar(255) DEFAULT NULL,
  `product_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `file_details`
--

INSERT INTO `file_details` (`id`, `file`, `file_extension`, `product_id`) VALUES
(1, '55-553498_toothless-dragon-funny-face.jpg', 'jpg', 1),
(2, 'Aladdin-Mena-Massoud-feature.jpg', 'jpg', 1),
(3, '81H0gmaQVxL._SL1500_.jpg', 'jpg', 1),
(4, 'chamber formalar.docx', 'docx', 1),
(5, 'photo_2021-06-09_17-20-52.jpg', 'jpg', 2),
(6, 'photo_2020-10-15_10-41-04.jpg', 'jpg', 2),
(7, 'photo_2021-05-21_10-25-38.jpg', 'jpg', 2),
(11, '63f4dba6d8c019268f21a72f987b1cec.jpg', 'jpg', 4),
(12, '983c5c8bd55bdc18ec2387726b38722d42-22-aladdin.rsquare.w700.jpg', 'jpg', 4),
(13, '635887123020717000-KFP3-sq1200-s76.pub-f119-4K-RGB-FIN.jpg', 'jpg', 4),
(14, '71MAqppzjrL (1).jpg', 'jpg', 4),
(15, '81H0gmaQVxL._SL1500_.jpg', 'jpg', 1),
(16, '81H0gmaQVxL._SL1500_.jpg', 'jpg', 1),
(17, '81H0gmaQVxL._SL1500_.jpg', 'jpg', 1),
(18, '81H0gmaQVxL._SL1500_.jpg', 'jpg', 1),
(19, '81H0gmaQVxL._SL1500_.jpg', 'jpg', 1),
(20, '81H0gmaQVxL._SL1500_.jpg', 'jpg', 1),
(21, 'photo_2019-06-25_01-48-29.jpg', 'jpg', 2),
(22, '81H0gmaQVxL._SL1500_.jpg', 'jpg', 2),
(23, '$_12.jfif', 'jfif', 4),
(24, 'photo_2019-06-25_01-48-29.jpg', 'jpg', 5),
(25, 'photo_2021-05-21_10-25-38.jpg', 'jpg', 5),
(26, 'photo_2019-06-25_01-48-29.jpg', 'jpg', 5),
(27, 'photo_2021-05-21_10-25-38.jpg', 'jpg', 4),
(28, '$_12.jfif', 'jfif', 6),
(29, '13х18 общий.pdf', 'pdf', 6),
(30, '51Ftp7RcmvL._AC_.jpg', 'jpg', 6),
(31, '50443ce3c49f79d3ab8b5fa7e9b273a0.jpg', 'jpg', 6);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int NOT NULL,
  `image` varchar(120) DEFAULT NULL,
  `name` varchar(120) NOT NULL,
  `price` float NOT NULL,
  `category_id` int DEFAULT NULL,
  `deleted` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `image`, `name`, `price`, `category_id`, `deleted`) VALUES
(1, 'photo_2019-06-25_01-48-29.jpg', 'apelsin', 89.8, 3, b'0'),
(2, 'photo_2019-06-25_01-48-29.jpg', 'Nokia 16 00', 88.9, 4, b'0'),
(3, 'photo_2021-05-22_11-11-44.jpg', 'ljflkfd', 15.6, 3, b'1'),
(4, 'photo_2019-06-25_01-48-29.jpg', 'qalampir', 15.2, 4, b'0'),
(5, 'photo_2019-06-25_01-48-29.jpg', 'fewfewe', 6.7, 4, b'0'),
(6, '71MAqppzjrL (1).jpg', 'gregegreregregggr', 45.6, 4, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `product_details`
--

CREATE TABLE `product_details` (
  `id` int NOT NULL,
  `name` varchar(55) NOT NULL,
  `value` varchar(55) NOT NULL,
  `product_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_details`
--

INSERT INTO `product_details` (`id`, `name`, `value`, `product_id`) VALUES
(1, 'og\'irligi', '450 gramm', 1),
(2, 'rangi ', 'qizil', 1),
(3, 'narxi', '7000', 1),
(4, 'rangi', 'kul rang', 2),
(5, 'ekran', '12 dyum', 2),
(6, 'og\'irligi', '75 gramm', 2),
(10, 'rangirang', 'qizil', 4),
(11, 'Avlodi', '12', 4),
(12, 'narxi', '1500', 4),
(13, 'fewfe', 'fewfwe', 5),
(14, 'fewfe', 'fefwe', 5),
(15, 'fefwe', 'fewfe', 5),
(16, 'gergerg', 'gregreg', 6),
(17, 'gregreg', 'gregerg', 6),
(18, 'gergrge', 'gregrgre', 6);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int NOT NULL,
  `name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'Administrator'),
(2, 'Editor'),
(3, 'Visitor');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(55) NOT NULL,
  `photos` varchar(64) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `photos`, `deleted`) VALUES
(1, 'user@user.com', 'Гыук123', 'photo_2021-06-08_13-28-43.jpg', b'0'),
(2, 'maxim@gmail.com', 'Ьфчшь123', 'photo_2020-10-15_10-41-04.jpg', b'1'),
(3, 'abbi@gmail.com', 'hrthrthth', '1ddf09d9f140c73c8f44bd5c9a325bb1.jpg', b'0'),
(4, 'xushnud@gmail.com', 'Xushnud123', 'photo_2020-10-15_10-41-04.jpg', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(4, 1),
(3, 2),
(4, 2),
(1, 3),
(3, 3),
(4, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_rdxh7tq2xs66r485cc8dkxt77` (`name`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_46ccwnsi9409t36lurvtyljak` (`name`),
  ADD KEY `FK57gpi2dtsm4euf8w2rpi7odge` (`brand_id`);

--
-- Indexes for table `file_details`
--
ALTER TABLE `file_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK74pn9o3y5x50wdmwo3y3prosy` (`product_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_jmivyxk9rmgysrmsqw15lqr5b` (`name`),
  ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`);

--
-- Indexes for table `product_details`
--
ALTER TABLE `product_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrhahp4f26x99lqf0kybcs79rb` (`product_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_8sewwnpamngi6b1dwaa88askk` (`name`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `file_details`
--
ALTER TABLE `file_details`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `product_details`
--
ALTER TABLE `product_details`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `FK57gpi2dtsm4euf8w2rpi7odge` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);

--
-- Constraints for table `file_details`
--
ALTER TABLE `file_details`
  ADD CONSTRAINT `FK74pn9o3y5x50wdmwo3y3prosy` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Constraints for table `product_details`
--
ALTER TABLE `product_details`
  ADD CONSTRAINT `FKrhahp4f26x99lqf0kybcs79rb` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
