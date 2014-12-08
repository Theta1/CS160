-- phpMyAdmin SQL Dump
-- version 4.2.13
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 08, 2014 at 11:04 PM
-- Server version: 5.5.39-MariaDB
-- PHP Version: 5.5.19

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
  `Instrument` varchar(20) DEFAULT NULL,
  `Birth` date DEFAULT NULL,
  `Death` date DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artists`
--

INSERT INTO `artists` (`aKey`, `Name`, `Instrument`, `Birth`, `Death`) VALUES
(1, 'Kris Myers', 'Vocalist', '0000-00-00', '0000-00-00'),
(2, 'Jake Cinninger', 'Guitar', '0000-00-00', '0000-00-00'),
(3, 'Andy Farag', 'Bass', '0000-00-00', '0000-00-00'),
(4, 'Ryan Stasik', 'Drums', '0000-00-00', '0000-00-00'),
(5, 'Joel Cummins', 'Guitar', '0000-00-00', '0000-00-00'),
(6, 'Brendan Bayliss', 'Vocalist', '0000-00-00', '0000-00-00'),
(7, 'Xavier de Rosnay', 'Synth', '0000-00-00', '0000-00-00'),
(8, 'Gaspard "Microloisir', 'Synth', '0000-00-00', '0000-00-00'),
(9, 'John Lennon', 'Vocalist', '0000-00-00', '0000-00-00'),
(10, 'Paul McCartney', 'Guitar', '0000-00-00', '0000-00-00'),
(11, 'George Harrison', 'Bass', '0000-00-00', '0000-00-00'),
(12, 'Ringo Starr', 'Drums', '0000-00-00', '0000-00-00'),
(13, 'Colin Hanton', 'Drums', '0000-00-00', '0000-00-00'),
(14, 'John Lowe', 'Pianist', '0000-00-00', '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `artists_has_groups`
--

CREATE TABLE IF NOT EXISTS `artists_has_groups` (
`keyIgnoreMe` int(11) NOT NULL,
  `artistKey` int(11) NOT NULL,
  `groupsKey` int(11) NOT NULL,
  `artistName` text,
  `groupName` text
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artists_has_groups`
--

INSERT INTO `artists_has_groups` (`keyIgnoreMe`, `artistKey`, `groupsKey`, `artistName`, `groupName`) VALUES
(1, 1, 1, 'Kris Myers ', 'Umphrey''s McGee'),
(2, 2, 1, 'Joel Cummins', 'Umphrey''s McGee'),
(3, 3, 1, 'Ryan Stasik', 'Umphrey''s McGee'),
(4, 4, 1, 'Andy Farag', 'Umphrey''s McGee'),
(5, 5, 1, 'Jake Cinninger', 'Umphrey''s McGee'),
(6, 6, 1, 'Kris Myers', 'Umphrey''s McGee'),
(7, 7, 2, 'Gaspard "Microloisir" Augé', 'Justice'),
(8, 8, 2, 'Xavier de Rosnay', 'Justice'),
(9, 9, 3, 'John Lennon', 'The Beatles'),
(10, 10, 3, 'Paul McCartney', 'The Beatles'),
(11, 11, 3, 'George Harrison', 'The Beatles'),
(12, 12, 3, 'Ringo Starr', 'The Beatles'),
(13, 9, 4, 'John Lennon\r\n', 'The Quarrymen'),
(14, 10, 4, 'Paul McCartney', 'The Quarrymen'),
(17, 13, 4, 'Colin Hanton', 'The Quarrymen'),
(18, 14, 4, 'John Lowe', 'The Quarrymen');

-- --------------------------------------------------------

--
-- Table structure for table `artists_has_tracks`
--

CREATE TABLE IF NOT EXISTS `artists_has_tracks` (
`keyIGNORE` int(11) NOT NULL,
  `artistKey` int(11) NOT NULL,
  `trackKey` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artists_has_tracks`
--

INSERT INTO `artists_has_tracks` (`keyIGNORE`, `artistKey`, `trackKey`) VALUES
(1, 9, 1),
(2, 9, 2),
(3, 9, 3),
(4, 10, 1),
(5, 10, 2),
(6, 10, 3),
(7, 11, 1),
(8, 11, 2),
(9, 11, 3),
(10, 12, 1),
(11, 12, 2),
(12, 12, 3),
(13, 1, 4),
(14, 1, 5),
(15, 2, 4),
(16, 2, 5),
(17, 3, 4),
(18, 3, 5),
(19, 4, 4),
(20, 4, 5),
(21, 5, 4),
(22, 5, 5),
(23, 6, 4),
(24, 6, 5),
(25, 7, 6),
(26, 8, 6),
(27, 7, 7),
(28, 8, 7),
(29, 7, 8),
(30, 8, 8),
(31, 7, 9),
(32, 8, 9),
(33, 9, 10),
(34, 9, 11),
(35, 11, 10),
(36, 11, 11),
(37, 10, 10),
(38, 10, 11),
(39, 13, 12),
(40, 14, 12);

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
`gKey` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Formed` date DEFAULT NULL,
  `Disbanded` date DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`gKey`, `Name`, `Formed`, `Disbanded`) VALUES
(1, 'Umphrey''s McGee', '1997-01-01', '0000-00-00'),
(2, 'Justice', '2003-01-01', '0000-00-00'),
(3, 'Beatles', '1960-01-01', '1970-01-01'),
(4, 'The Quarrymen', '1956-01-01', '0000-00-00'),
(6, 'AC/DC', '0000-00-00', '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `groups_has_tracks`
--

CREATE TABLE IF NOT EXISTS `groups_has_tracks` (
`keyIGNORE` int(11) NOT NULL,
  `groupID` int(11) NOT NULL,
  `trackID` int(11) NOT NULL,
  `groupName` text,
  `trackName` text
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups_has_tracks`
--

INSERT INTO `groups_has_tracks` (`keyIGNORE`, `groupID`, `trackID`, `groupName`, `trackName`) VALUES
(1, 3, 1, 'The Beatles', ''),
(2, 3, 2, 'The Beatles', ''),
(3, 3, 3, 'The Beatles', ''),
(4, 1, 4, '', ''),
(5, 1, 5, '', ''),
(6, 2, 6, '', ''),
(7, 2, 7, '', ''),
(8, 2, 8, '', ''),
(9, 2, 9, '', ''),
(10, 4, 10, '', ''),
(11, 4, 11, '', ''),
(12, 4, 12, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `performaces_has_tracks`
--

CREATE TABLE IF NOT EXISTS `performaces_has_tracks` (
`keyIGNORE` int(11) NOT NULL,
  `performaceKey` int(11) NOT NULL,
  `trackKey` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `performaces_has_tracks`
--

INSERT INTO `performaces_has_tracks` (`keyIGNORE`, `performaceKey`, `trackKey`) VALUES
(1, 1, 5),
(2, 6, 2),
(3, 7, 2),
(4, 8, 3),
(5, 9, 4),
(6, 10, 5),
(7, 11, 6),
(8, 11, 7),
(9, 11, 8),
(10, 12, 9);

-- --------------------------------------------------------

--
-- Table structure for table `performances`
--

CREATE TABLE IF NOT EXISTS `performances` (
`performanceID` int(5) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `year` year(4) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `performances`
--

INSERT INTO `performances` (`performanceID`, `name`, `year`) VALUES
(1, 'Yellow Submarine', 2012),
(2, 'Abbey Road', 2010),
(3, 'Bonfire', 2015),
(4, 'Live at the Murat', 2007),
(5, 'Let It Be', 1970),
(6, 'Hey Jude', 1970),
(7, 'Hey Jude (ReRelease)', 2007),
(8, 'Please Please Me', 1963),
(9, 'Mantis', 2009),
(10, 'The Bottom Half', 2007),
(11, '†', 2007),
(12, 'Access All Arenas', 2013);

-- --------------------------------------------------------

--
-- Table structure for table `performances_has_artists`
--

CREATE TABLE IF NOT EXISTS `performances_has_artists` (
`keyIGNORE` int(11) NOT NULL,
  `performanceKey` int(11) NOT NULL,
  `artistKey` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `performances_has_artists`
--

INSERT INTO `performances_has_artists` (`keyIGNORE`, `performanceKey`, `artistKey`) VALUES
(1, 1, 10),
(2, 2, 10),
(3, 3, 10),
(4, 1, 11),
(5, 2, 11),
(6, 3, 11),
(7, 1, 12),
(8, 2, 12),
(9, 3, 12),
(10, 9, 1),
(11, 9, 2),
(12, 9, 3),
(13, 9, 4),
(14, 9, 5),
(15, 9, 6),
(16, 10, 1),
(17, 10, 2),
(18, 10, 3),
(19, 10, 4),
(20, 10, 5),
(21, 10, 6),
(22, 11, 7),
(23, 11, 8),
(24, 12, 7),
(25, 12, 8);

-- --------------------------------------------------------

--
-- Table structure for table `performances_has_groups`
--

CREATE TABLE IF NOT EXISTS `performances_has_groups` (
`keyIGNORE` int(11) NOT NULL,
  `performaceKey` int(11) NOT NULL,
  `groupKey` int(11) NOT NULL,
  `performanceName` text,
  `groupName` text
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `performances_has_groups`
--

INSERT INTO `performances_has_groups` (`keyIGNORE`, `performaceKey`, `groupKey`, `performanceName`, `groupName`) VALUES
(1, 4, 1, 'Live at the Murat', 'Umphrey''s McGee'),
(2, 2, 3, 'Abbey Road', 'The Beatles'),
(3, 1, 3, '', 'The Beatles'),
(4, 3, 6, '', 'AC/DC'),
(5, 5, 3, '', 'The Beatles'),
(6, 6, 3, '', 'The Beatles'),
(7, 7, 3, '', 'The Beatles'),
(8, 8, 3, '', 'The Beatles'),
(9, 9, 1, '', 'Umphrey''s McGee'),
(10, 10, 1, '', 'Umphrey''s McGee'),
(11, 12, 2, '', 'Justice'),
(12, 11, 2, '', 'Justice');

-- --------------------------------------------------------

--
-- Table structure for table `tracks`
--

CREATE TABLE IF NOT EXISTS `tracks` (
`TrackID` int(11) NOT NULL,
  `Title` varchar(20) NOT NULL,
  `year` year(4) DEFAULT NULL,
  `genre` varchar(20) DEFAULT NULL,
  `Movement` int(11) DEFAULT NULL,
  `length` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tracks`
--

INSERT INTO `tracks` (`TrackID`, `Title`, `year`, `genre`, `Movement`, `length`) VALUES
(1, 'Let It Be', 1970, '', NULL, 243),
(2, 'Hey Jude', 0000, '', 0, 480),
(3, 'Love Me Do', 1963, '', 0, 143),
(4, 'Mantis', 2009, '', 0, 711),
(5, 'Higgins', 2006, '', 0, 253),
(6, 'D.A.N.C.E.', 2007, '', 0, 242),
(7, 'DVNO', 2007, '', 0, 236),
(8, 'On''n''On', 2012, '', 0, 238),
(9, 'New Lands', 2013, '', 0, 258),
(10, 'Worried Man Blues', 1956, '', 0, 0),
(11, 'Don''t Be Cruel', 1956, '', 0, 0),
(12, 'Come Go with Me', 2007, '', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`) VALUES
(1, 'as', 'as'),
(2, 'gentlemen', 'workhard'),
(3, 'root', 'root');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artists`
--
ALTER TABLE `artists`
 ADD PRIMARY KEY (`aKey`);

--
-- Indexes for table `artists_has_groups`
--
ALTER TABLE `artists_has_groups`
 ADD PRIMARY KEY (`keyIgnoreMe`);

--
-- Indexes for table `artists_has_tracks`
--
ALTER TABLE `artists_has_tracks`
 ADD PRIMARY KEY (`keyIGNORE`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
 ADD PRIMARY KEY (`gKey`);

--
-- Indexes for table `groups_has_tracks`
--
ALTER TABLE `groups_has_tracks`
 ADD PRIMARY KEY (`keyIGNORE`);

--
-- Indexes for table `performaces_has_tracks`
--
ALTER TABLE `performaces_has_tracks`
 ADD PRIMARY KEY (`keyIGNORE`);

--
-- Indexes for table `performances`
--
ALTER TABLE `performances`
 ADD PRIMARY KEY (`performanceID`);

--
-- Indexes for table `performances_has_artists`
--
ALTER TABLE `performances_has_artists`
 ADD PRIMARY KEY (`keyIGNORE`);

--
-- Indexes for table `performances_has_groups`
--
ALTER TABLE `performances_has_groups`
 ADD PRIMARY KEY (`keyIGNORE`);

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
MODIFY `aKey` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `artists_has_groups`
--
ALTER TABLE `artists_has_groups`
MODIFY `keyIgnoreMe` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `artists_has_tracks`
--
ALTER TABLE `artists_has_tracks`
MODIFY `keyIGNORE` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `groups`
--
ALTER TABLE `groups`
MODIFY `gKey` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `groups_has_tracks`
--
ALTER TABLE `groups_has_tracks`
MODIFY `keyIGNORE` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `performaces_has_tracks`
--
ALTER TABLE `performaces_has_tracks`
MODIFY `keyIGNORE` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `performances`
--
ALTER TABLE `performances`
MODIFY `performanceID` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `performances_has_artists`
--
ALTER TABLE `performances_has_artists`
MODIFY `keyIGNORE` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `performances_has_groups`
--
ALTER TABLE `performances_has_groups`
MODIFY `keyIGNORE` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `tracks`
--
ALTER TABLE `tracks`
MODIFY `TrackID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
