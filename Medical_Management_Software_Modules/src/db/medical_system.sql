-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 20, 2020 at 10:42 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `medical_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `Customer ID` int(50) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Contact No.` bigint(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`Customer ID`, `Name`, `Address`, `Contact No.`) VALUES
(1, 'Vikrant Singh', 'ujbsdby87 hhdvihsuidyvicu98vu8oi xoio8ucx89ov cv8u89 ', 9873947943),
(2, 'Jay Choudhary', 'kgksuhdkfkk bbksdhiuf kusd bfkb skdbkfhsdkyfy87 hui hidhui hkusd hk fhskd hikdhkdsbd89', 9794723398),
(3, 'Aniket Alve', 'kugukd fjbjkguk sbjd gfk bsmbn fsmnb  mbmb vbm bk ggdmz bxfmbnm bhmbmbc vnbm bmn ', 2384382523);

-- --------------------------------------------------------

--
-- Table structure for table `dealers`
--

CREATE TABLE `dealers` (
  `Dealer ID` int(50) NOT NULL,
  `Name` varchar(90) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Mobile Number` bigint(200) NOT NULL,
  `GST Number` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- Dumping data for table `dealers`
--

INSERT INTO `dealers` (`Dealer ID`, `Name`, `Address`, `Mobile Number`, `GST Number`) VALUES
(1, 'AVYS CORP', 'sgdiygfnin7yi ify87y7iyi7y iiy7yi fy8yu 98ub 89y889uo', 8987489083, 'UIG78S8D-I89U9-DS'),
(2, 'Wolters Kluwer', 'gisg kf gkbkhrskrfhuksh khk hkuh kshd89 9 ieh dkuhi	', 9873948723, 'HUKHUKSD899NSD'),
(3, 'Cerner Multum', 'HOUIHL899uoNOMO8J8OMUOU98U 98U98u9nn80u0j0u98u0udsioohj', 8998023808, 'J97DF99NIIU89-fn');

-- --------------------------------------------------------

--
-- Table structure for table `medicines`
--

CREATE TABLE `medicines` (
  `Medicine ID` bigint(150) NOT NULL,
  `Name` varchar(200) NOT NULL,
  `Med_Group` varchar(240) NOT NULL,
  `Unit Number` varchar(220) NOT NULL,
  `Company` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- Dumping data for table `medicines`
--

INSERT INTO `medicines` (`Medicine ID`, `Name`, `Med_Group`, `Unit Number`, `Company`) VALUES
(1, 'Lexapro', 'Escitalopram', 'IUUHG7IY99U', 'Heyinz'),
(2, 'Oxaydo', 'Oxycodone', 'KHK87IIYNIn', 'Eirmon'),
(3, 'Oxycontin', 'Oxycodone', 'JYGJGJGjhgkugk', 'Eirmon'),
(4, 'Oxyfast', 'Oxycodone', 'H8SYNDY', 'Konicy'),
(5, 'Codein', 'KOE Deen', 'T7Y8Y87N7IY', 'Konicy'),
(6, 'Actamin', 'Acetaminophen', 'UIKUWEHK89Y98UI', 'Hiyenz'),
(7, 'Bromo Seltze', 'Acetaminophen', 'O8UOKKINHS98NU8', 'Hiyenz'),
(8, 'Trimox', 'Amoxicillin', 'J98J8SD9U98J9', 'Konicy');

-- --------------------------------------------------------

--
-- Table structure for table `purchased_medicine_details`
--

CREATE TABLE `purchased_medicine_details` (
  `Purchase ID` bigint(150) NOT NULL,
  `Med_ID` bigint(150) NOT NULL,
  `Dealer_ID` int(50) NOT NULL,
  `Invoice No.` varchar(250) NOT NULL,
  `Quantity` int(30) NOT NULL,
  `MRP` varchar(100) NOT NULL,
  `Purchase_Price` varchar(150) NOT NULL,
  `Grand_Total` varchar(150) NOT NULL,
  `Paid_GST` varchar(150) NOT NULL,
  `Purchase_date` varchar(130) NOT NULL,
  `Expiry_date` varchar(130) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- Dumping data for table `purchased_medicine_details`
--

INSERT INTO `purchased_medicine_details` (`Purchase ID`, `Med_ID`, `Dealer_ID`, `Invoice No.`, `Quantity`, `MRP`, `Purchase_Price`, `Grand_Total`, `Paid_GST`, `Purchase_date`, `Expiry_date`) VALUES
(1, 1, 1, 'YIGGIG87N', 30, '47.5', '32', '1008.0', '5', '19/06/2020 01:42:39', '19/06/2020 01:41:06'),
(2, 2, 2, 'H76THUT86NII', 120, '76.0', '62', '7812.0', '5', '19/06/2020 01:44:02', '19/06/2020 01:41:06'),
(3, 6, 2, 'HSF8HTID3R4', 170, '85.5', '75', '13387.5', '5', '19/06/2020 01:51:11', '19/06/2020 01:50:18');

-- --------------------------------------------------------

--
-- Table structure for table `purchase_medicine_history_details`
--

CREATE TABLE `purchase_medicine_history_details` (
  `Purchase_history_ID` bigint(80) NOT NULL,
  `Med_ID` bigint(150) NOT NULL,
  `Dealer_ID` int(50) NOT NULL,
  `Invoice No.` varchar(220) NOT NULL,
  `Quantity` int(50) NOT NULL,
  `MRP` varchar(100) NOT NULL,
  `Purchase_Price` varchar(100) NOT NULL,
  `Grand_Total` varchar(100) NOT NULL,
  `Paid_GST` varchar(100) NOT NULL,
  `Purchase_Date` varchar(100) NOT NULL,
  `Expiry_Date` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- Dumping data for table `purchase_medicine_history_details`
--

INSERT INTO `purchase_medicine_history_details` (`Purchase_history_ID`, `Med_ID`, `Dealer_ID`, `Invoice No.`, `Quantity`, `MRP`, `Purchase_Price`, `Grand_Total`, `Paid_GST`, `Purchase_Date`, `Expiry_Date`) VALUES
(1, 1, 1, 'YIGGIG87N', 10, '50', '32', '336.0', '5', '19/06/2020 01:42:13', '19/06/2020 01:41:06'),
(2, 1, 1, 'YIGGIG87N', 20, '50', '32', '672.0', '5', '19/06/2020 01:42:39', '19/06/2020 01:41:06'),
(3, 2, 2, 'H76THUT86NII', 120, '80', '62', '7812.0', '5', '19/06/2020 01:44:02', '19/06/2020 01:41:06'),
(4, 6, 2, 'JJ98F98G8N', 150, '90', '75', '11812.5', '5', '19/06/2020 01:50:40', '19/06/2020 01:50:18'),
(5, 6, 2, 'HSF8HTID3R4', 20, '90', '75', '1575.0', '5', '19/06/2020 01:51:11', '19/06/2020 01:50:18');

-- --------------------------------------------------------

--
-- Table structure for table `sold_medicine_details`
--

CREATE TABLE `sold_medicine_details` (
  `Sell ID` int(50) NOT NULL,
  `Bill Number` int(50) NOT NULL,
  `Med_ID` bigint(150) NOT NULL,
  `Cust_ID` int(50) NOT NULL,
  `Qty` varchar(150) NOT NULL,
  `Applied_GST` varchar(150) NOT NULL,
  `Grand_Total` varchar(150) NOT NULL,
  `Purchase_date` varchar(240) NOT NULL,
  `Purchase_Time` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- Dumping data for table `sold_medicine_details`
--

INSERT INTO `sold_medicine_details` (`Sell ID`, `Bill Number`, `Med_ID`, `Cust_ID`, `Qty`, `Applied_GST`, `Grand_Total`, `Purchase_date`, `Purchase_Time`) VALUES
(1, 1, 2, 1, '20', '5', '2520.0', '17/06/2020', '05:24:04 PM'),
(2, 2, 1, 1, '5', '5', '472.5', '17/06/2020', '05:31:34 PM'),
(3, 3, 1, 1, '5', '5', '472.5', '17/06/2020', '05:32:26 PM'),
(4, 4, 4, 2, '12', '5', '693.0', '18/06/2020', '04:19:37 PM'),
(5, 4, 6, 2, '5', '6', '593.6', '18/06/2020', '04:19:54 PM'),
(6, 5, 1, 3, '12', '5', '598.5', '20/06/2020', '01:01:00 PM'),
(7, 5, 6, 3, '5', '5', '448.875', '20/06/2020', '01:01:14 PM'),
(8, 6, 1, 1, '2', '5', '99.75', '20/06/2020', '01:04:24 PM'),
(9, 6, 6, 1, '5', '5', '448.875', '20/06/2020', '01:04:33 PM'),
(10, 7, 1, 3, '3', '5', '149.625', '20/06/2020', '01:44:24 PM'),
(11, 7, 6, 3, '20', '5', '1795.5', '20/06/2020', '01:44:44 PM');

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `User ID` int(40) NOT NULL,
  `Username` varchar(80) NOT NULL,
  `Name` varchar(80) NOT NULL,
  `Email` varchar(80) NOT NULL,
  `Company Name` varchar(90) NOT NULL,
  `Company Address` varchar(150) NOT NULL,
  `GST` varchar(200) NOT NULL,
  `FY_From` varchar(100) NOT NULL,
  `FY_To` varchar(100) NOT NULL,
  `Mobile Number` varchar(80) NOT NULL,
  `Pass` varchar(220) NOT NULL,
  `Salt` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`User ID`, `Username`, `Name`, `Email`, `Company Name`, `Company Address`, `GST`, `FY_From`, `FY_To`, `Mobile Number`, `Pass`, `Salt`) VALUES
(1, 'avi@1', 'Avinash Singh', 'yashshettigar047@gmail.com', 'Singh Pharmacy', 'sdf htdh rsdg rdfhg dgfhd bgfdxvhfbfdvhb dfg 5e4 5453', 'H7IYSIDHI7DYNF', '17/06/2020 16:24:56', '17/06/2021 16:24:56', '7848273983', '0224da9bde14186bb2af2e30171ed684e075b2f2991a07414cd443e7266dd8747c959ead584761b266ddc236600b164bfd3d4cea0c254b1845f6d2ba0e1b9c30', '-1111000010110000100111100001010100101110101110000010000110011001110111111110010111011010000000000011100100000001100011101010110');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`Customer ID`);

--
-- Indexes for table `dealers`
--
ALTER TABLE `dealers`
  ADD PRIMARY KEY (`Dealer ID`);

--
-- Indexes for table `medicines`
--
ALTER TABLE `medicines`
  ADD PRIMARY KEY (`Medicine ID`);

--
-- Indexes for table `purchased_medicine_details`
--
ALTER TABLE `purchased_medicine_details`
  ADD PRIMARY KEY (`Purchase ID`),
  ADD KEY `fk_dealer_id` (`Dealer_ID`),
  ADD KEY `fk_med_id` (`Med_ID`);

--
-- Indexes for table `purchase_medicine_history_details`
--
ALTER TABLE `purchase_medicine_history_details`
  ADD PRIMARY KEY (`Purchase_history_ID`),
  ADD KEY `fk_to_medicines` (`Med_ID`),
  ADD KEY `fk_to_dealers` (`Dealer_ID`);

--
-- Indexes for table `sold_medicine_details`
--
ALTER TABLE `sold_medicine_details`
  ADD PRIMARY KEY (`Sell ID`),
  ADD KEY `fk_sell_med_id` (`Med_ID`),
  ADD KEY `fk_sell_c_id` (`Cust_ID`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`User ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `Customer ID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `dealers`
--
ALTER TABLE `dealers`
  MODIFY `Dealer ID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `medicines`
--
ALTER TABLE `medicines`
  MODIFY `Medicine ID` bigint(150) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `purchased_medicine_details`
--
ALTER TABLE `purchased_medicine_details`
  MODIFY `Purchase ID` bigint(150) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `purchase_medicine_history_details`
--
ALTER TABLE `purchase_medicine_history_details`
  MODIFY `Purchase_history_ID` bigint(80) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sold_medicine_details`
--
ALTER TABLE `sold_medicine_details`
  MODIFY `Sell ID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
  MODIFY `User ID` int(40) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `purchased_medicine_details`
--
ALTER TABLE `purchased_medicine_details`
  ADD CONSTRAINT `fk_dealer_id` FOREIGN KEY (`Dealer_ID`) REFERENCES `dealers` (`Dealer ID`),
  ADD CONSTRAINT `fk_med_id` FOREIGN KEY (`Med_ID`) REFERENCES `medicines` (`Medicine ID`);

--
-- Constraints for table `purchase_medicine_history_details`
--
ALTER TABLE `purchase_medicine_history_details`
  ADD CONSTRAINT `fk_to_dealers` FOREIGN KEY (`Dealer_ID`) REFERENCES `dealers` (`Dealer ID`),
  ADD CONSTRAINT `fk_to_medicines` FOREIGN KEY (`Med_ID`) REFERENCES `medicines` (`Medicine ID`);

--
-- Constraints for table `sold_medicine_details`
--
ALTER TABLE `sold_medicine_details`
  ADD CONSTRAINT `fk_sell_c_id` FOREIGN KEY (`Cust_ID`) REFERENCES `customers` (`Customer ID`),
  ADD CONSTRAINT `fk_sell_med_id` FOREIGN KEY (`Med_ID`) REFERENCES `medicines` (`Medicine ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
