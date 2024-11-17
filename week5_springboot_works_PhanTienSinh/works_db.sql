INSERT INTO `skill` (`skill_description`, `skill_name`, `type`) VALUES
('Ability to manage teams and lead projects effectively', 'Project Management', 'SOFT_SKILL'),
('Proficient in developing and debugging Java applications', 'Java Programming', 'TECHNICAL_SKILL'),
('Basic understanding of both soft and technical skills', 'General IT Knowledge', 'UNSPECIFIC'),
('Ability to communicate effectively with clients and teams', 'Communication', 'SOFT_SKILL'),
('Proficient in building and managing cloud infrastructure', 'Cloud Computing', 'TECHNICAL_SKILL');

INSERT INTO `skill` (`skill_description`, `skill_name`, `type`) 
VALUES
('Knowledge of database systems like MySQL and PostgreSQL', 'Database Management', 'TECHNICAL_SKILL'),
('Understanding of machine learning algorithms', 'Machine Learning', 'TECHNICAL_SKILL'),
('Strong problem-solving and critical thinking skills', 'Problem Solving', 'SOFT_SKILL'),
('Experience in creating and managing RESTful APIs', 'API Development', 'TECHNICAL_SKILL'),
('Proficiency in front-end technologies like React.js', 'Frontend Development', 'TECHNICAL_SKILL'),
('Proficiency in server-side frameworks.', 'Backend Frameworks', 'TECHNICAL_SKILL'),
('Working with large-scale data systems.', 'Big Data Tools', 'TECHNICAL_SKILL'),
('Expertise in creating data visualizations with tools like Tableau', 'Data Visualization', 'TECHNICAL_SKILL'),
('Skill in analyzing and interpreting data to drive decisions', 'Data Analysis', 'TECHNICAL_SKILL'),
('Basic understanding of workplace ethics and collaboration', 'Workplace Ethics', 'UNSPECIFIC'),
('Managing social media campaigns.', 'Social Media Marketing', 'TECHNICAL_SKILL');


INSERT INTO `company` (`comp_id`, `about`, `email`, `comp_name`, `phone`, `web_url`, `address`) 
VALUES
(1, 'A leading tech company specializing in AI and cloud computing.', 'contact@techinnovators.com', 'Tech Innovators', '+1234567890', 'https://www.techinnovators.com', 550),
(2, 'An innovative digital marketing agency helping businesses grow online.', 'info@marketingpros.com', 'Marketing Pros', '+1234567891', 'https://www.marketingpros.com', 200),
(3, 'Experts in backend systems and API development.', 'support@backendgurus.com', 'Backend Gurus', '+1234567892', 'https://www.backendgurus.com', 100),
(4, 'A data analytics firm transforming data into actionable insights.', 'hello@dataanalysts.com', 'Data Analysts Inc.', '+1234567893', 'https://www.dataanalysts.com', 400);


INSERT INTO `job` (`job_id`, `job_desc`, `job_name`, `company`) 
VALUES
-- Jobs for Tech Innovators
(1, 'Develop and optimize AI models for large-scale applications.', 'AI Engineer', 1),
(2, 'Manage and deploy cloud infrastructure for enterprise solutions.', 'Cloud Engineer', 1),
(3, 'Collaborate on UI/UX design for innovative tech platforms.', 'Frontend Developer', 1),

-- Jobs for Marketing Pros
(4, 'Plan and execute SEO strategies for global clients.', 'SEO Specialist', 2),
(5, 'Design and manage social media marketing campaigns.', 'Social Media Manager', 2),
(6, 'Create engaging ad content for paid campaigns.', 'Ad Campaign Specialist', 2),

-- Jobs for Backend Gurus
(7, 'Build and maintain RESTful APIs for enterprise systems.', 'API Developer', 3),
(8, 'Optimize database performance for large-scale applications.', 'Database Administrator', 3),
(9, 'Architect and implement secure backend systems.', 'Backend Architect', 3),

-- Jobs for Data Analysts Inc.
(10, 'Analyze and visualize business data for better decision-making.', 'Business Analyst', 4),
(11, 'Build predictive models to forecast market trends.', 'Data Scientist', 4),
(12, 'Manage and clean large datasets for reporting.', 'Data Engineer', 4);


INSERT INTO `job_skill` (`more_infos`, `skill_level`, `job_id`, `skill_id`) 
VALUES
-- Skills for Project Management job (job_id = 1)
('Effectively manage projects and teams.', 3, 1, 1),
('Collaborate effectively with clients.', 4, 1, 4),

-- Skills for Java Developer job (job_id = 2)
('Strong proficiency in Java.', 5, 2, 2),
('Basic IT knowledge for debugging.', 1, 2, 3),

-- Skills for Cloud Engineer job (job_id = 3)
('Cloud infrastructure expertise.', 3, 3, 5),
('Database systems like MySQL and PostgreSQL.', 2, 3, 6),

-- Skills for AI Engineer job (job_id = 4)
('Machine learning algorithms.', 3, 4, 7),
('Problem-solving in critical situations.', 4, 4, 8),

-- Skills for API Developer job (job_id = 5)
('Create and manage RESTful APIs.', 3, 5, 9),
('Frontend knowledge with React.js.', 2, 5, 10),

-- Skills for Backend Developer job (job_id = 6)
('Proficiency in server-side frameworks.', 5, 6, 11),
('Handle large-scale systems.', 3, 6, 12),

-- Skills for Data Analyst job (job_id = 7)
('Data visualization expertise.', 4, 7, 13),
('Analyze and interpret data effectively.', 3, 7, 14),

-- Skills for Social Media Manager job (job_id = 8)
('Workplace ethics and collaboration.', 2, 8, 15),
('Manage social media campaigns.', 3, 8, 16);

INSERT INTO `job_skill` (`more_infos`, `skill_level`, `job_id`, `skill_id`) 
VALUES
-- Skills for Backend Architect (job_id = 9)
('Design secure backend systems.', 5, 9, 11),
('Proficiency in database management.', 3, 9, 6),
('Expertise in microservices architecture.', 4, 9, 14),

-- Skills for Business Analyst (job_id = 10)
('Proficiency in data visualization tools.', 3, 10, 13),
('Strong data analysis skills.', 4, 10, 14),
('Understanding of workplace ethics and collaboration.', 2, 10, 15),

-- Skills for Data Scientist (job_id = 11)
('Build accurate predictive models.', 5, 11, 7),
('Expertise in statistical modeling.', 4, 11, 9),
('Proficiency in R programming.', 3, 11, 14);
INSERT INTO `job_skill` (`more_infos`, `skill_level`, `job_id`, `skill_id`) 
VALUES
-- Skills for Data Engineer (job_id = 12)
('Efficiently manage large datasets.', 3, 12, 12);
INSERT INTO `job_skill` (`more_infos`, `skill_level`, `job_id`, `skill_id`) 
VALUES
('Develop and optimize data pipelines.', 5, 12, 12);
('Expertise in big data frameworks like Apache Spark.', 4, 12, 12);





-- --------------------------------------------------------
-- Host:                         127.0.0.1address
-- Server version:               11.3.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for works
CREATE DATABASE IF NOT EXISTS `works` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `works`;

-- Dumping structure for table works.address
CREATE TABLE IF NOT EXISTS `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `street` varchar(150) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `number` varchar(20) DEFAULT NULL,
  `zipcode` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


-- Dumping structure for table works.candidate
CREATE TABLE IF NOT EXISTS `candidate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dob` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qfut8ruekode092nlkipgl09g` (`email`),
  UNIQUE KEY `UK_9i5yt1gvm0chg5e10qkns7tll` (`phone`),
  UNIQUE KEY `UK_m8qhlm4wu215gr34dhxp0dour` (`address`),
  CONSTRAINT `FKa8gnyyhbb2qnhp94grci1n0o9` FOREIGN KEY (`address`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


-- Dumping structure for table works.candidate_skill
CREATE TABLE IF NOT EXISTS `candidate_skill` (
  `more_infos` varchar(1000) DEFAULT NULL,
  `skill_level` enum('ADVANCED','BEGINER','IMTERMEDIATE','MASTER','PROFESSIONAL') NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  `can_id` bigint(20) NOT NULL,
  PRIMARY KEY (`can_id`,`skill_id`),
  KEY `FKb7cxhiqhcah7c20a2cdlvr1f8` (`skill_id`),
  CONSTRAINT `FKb0m5tm3fi0upa3b3kjx3vrlxs` FOREIGN KEY (`can_id`) REFERENCES `candidate` (`id`),
  CONSTRAINT `FKb7cxhiqhcah7c20a2cdlvr1f8` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.candidate_skill: ~0 rows (approximately)

-- Dumping structure for table works.company
CREATE TABLE IF NOT EXISTS `company` (
  `comp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `about` varchar(2000) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `comp_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `web_url` varchar(255) DEFAULT NULL,
  `address` bigint(20) NOT NULL,
  PRIMARY KEY (`comp_id`),
  UNIQUE KEY `UK_rvp2hunsq4sgmpxe3a7i1ym3m` (`address`),
  CONSTRAINT `FKd5occp4cjwihejbxdbpvkp5tv` FOREIGN KEY (`address`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.company: ~0 rows (approximately)

-- Dumping structure for table works.experience
CREATE TABLE IF NOT EXISTS `experience` (
  `exp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company` varchar(120) NOT NULL,
  `from_date` date NOT NULL,
  `role` varchar(100) NOT NULL,
  `to_date` date NOT NULL,
  `work_desc` varchar(400) NOT NULL,
  `can_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`exp_id`),
  KEY `FK8d5oqe0wxh52v352i04qnuady` (`can_id`),
  CONSTRAINT `FK8d5oqe0wxh52v352i04qnuady` FOREIGN KEY (`can_id`) REFERENCES `candidate` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.experience: ~0 rows (approximately)

-- Dumping structure for table works.job
CREATE TABLE IF NOT EXISTS `job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_desc` varchar(2000) NOT NULL,
  `job_name` varchar(255) NOT NULL,
  `company` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `FKbaqlvluu78phmo9ld89um7wnm` (`company`),
  CONSTRAINT `FKbaqlvluu78phmo9ld89um7wnm` FOREIGN KEY (`company`) REFERENCES `company` (`comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.job: ~0 rows (approximately)

-- Dumping structure for table works.job_skill
CREATE TABLE IF NOT EXISTS `job_skill` (
  `more_infos` varchar(1000) DEFAULT NULL,
  `skill_level` enum('ADVANCED','BEGINER','IMTERMEDIATE','MASTER','PROFESSIONAL') NOT NULL,
  `job_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  PRIMARY KEY (`job_id`,`skill_id`),
  KEY `FKj33qbbf3vk1lvhqpcosnh54u1` (`skill_id`),
  CONSTRAINT `FK9ix4wg520ii2gu2felxdhdup6` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  CONSTRAINT `FKj33qbbf3vk1lvhqpcosnh54u1` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.job_skill: ~0 rows (approximately)

-- Dumping structure for table works.skill
CREATE TABLE IF NOT EXISTS `skill` (
  `skill_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `skill_description` varchar(255) DEFAULT NULL,
  `skill_name` varchar(255) DEFAULT NULL,
  `type` enum('SOFT_SKILL','TECHNICAL_SKILL','UNSPECIFIC') DEFAULT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping data for table works.skill: ~0 rows (approximately)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;


SELECT * FROM job WHERE job.company = 1