-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 02, 2014 at 06:25 PM
-- Server version: 5.5.39-MariaDB
-- PHP Version: 5.5.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cantus`
--

-- --------------------------------------------------------

--
-- Table structure for table `artists`
--

CREATE TABLE IF NOT EXISTS `artists` (
`aKey` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `GroupId` int(11) NOT NULL,
  `Instrament` varchar(20) NOT NULL,
  `Birth` date NOT NULL,
  `Death` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `artists_has_groups`
--

CREATE TABLE IF NOT EXISTS `artists_has_groups` (
  `artistKey` int(11) NOT NULL,
  `groupsKey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `artists_has_tracks`
--

CREATE TABLE IF NOT EXISTS `artists_has_tracks` (
  `artistKey` int(11) NOT NULL,
  `trackKey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `genres`
--

CREATE TABLE IF NOT EXISTS `genres` (
`gKey` int(11) NOT NULL,
  `trackID` int(11) NOT NULL,
  `GroupID` int(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `genres_has_tracks`
--

CREATE TABLE IF NOT EXISTS `genres_has_tracks` (
  `genreKey` int(11) NOT NULL,
  `trackKey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
`gKey` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Formed` date NOT NULL,
  `Disbanded` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `libraries`
--

CREATE TABLE IF NOT EXISTS `libraries` (
`LibraryID` int(11) NOT NULL,
  `LibraryNumber` int(11) NOT NULL,
  `TrackID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `performaces_has_tracks`
--

CREATE TABLE IF NOT EXISTS `performaces_has_tracks` (
  `performaceKey` int(11) NOT NULL,
  `trackKey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `performances`
--

CREATE TABLE IF NOT EXISTS `performances` (
`album_id` int(5) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `trackID` int(11) DEFAULT NULL,
  `year` year(4) DEFAULT NULL,
  `groupId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `performances`
--

INSERT INTO `performances` (`album_id`, `name`, `trackID`, `year`, `groupId`) VALUES
(1, 'Yellow Submarine', NULL, 2012, 0),
(2, 'Abbey Road', NULL, 2010, 0),
(3, 'Bonfire', NULL, 2015, 0);

-- --------------------------------------------------------

--
-- Table structure for table `performances_has_artists`
--

CREATE TABLE IF NOT EXISTS `performances_has_artists` (
  `performanceKey` int(11) NOT NULL,
  `artistKey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `performances_has_groups`
--

CREATE TABLE IF NOT EXISTS `performances_has_groups` (
  `performaceKey` int(11) NOT NULL,
  `groupKey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tracks`
--

CREATE TABLE IF NOT EXISTS `tracks` (
`TrackID` int(11) NOT NULL,
  `Title` varchar(20) NOT NULL,
  `year` date NOT NULL,
  `genre` varchar(20) NOT NULL,
  `Movement` int(11) NOT NULL,
  `length` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`) VALUES
(1, 'as', 'as');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artists`
--
ALTER TABLE `artists`
 ADD PRIMARY KEY (`aKey`);

--
-- Indexes for table `genres`
--
ALTER TABLE `genres`
 ADD PRIMARY KEY (`gKey`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
 ADD PRIMARY KEY (`gKey`);

--
-- Indexes for table `libraries`
--
ALTER TABLE `libraries`
 ADD PRIMARY KEY (`LibraryID`);

--
-- Indexes for table `performances`
--
ALTER TABLE `performances`
 ADD PRIMARY KEY (`album_id`);

--
-- Indexes for table `tracks`
--
ALTER TABLE `tracks`
 ADD PRIMARY KEY (`TrackID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`user_id`), ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artists`
--
ALTER TABLE `artists`
MODIFY `aKey` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `genres`
--
ALTER TABLE `genres`
MODIFY `gKey` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `groups`
--
ALTER TABLE `groups`
MODIFY `gKey` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `libraries`
--
ALTER TABLE `libraries`
MODIFY `LibraryID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `performances`
--
ALTER TABLE `performances`
MODIFY `album_id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tracks`
--
ALTER TABLE `tracks`
MODIFY `TrackID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
