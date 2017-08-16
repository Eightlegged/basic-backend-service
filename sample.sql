CREATE DATABASE `base_info` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `user_info` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(255) NOT NULL,
  `part` varchar(255) DEFAULT NULL,
  `user_pw` varchar(255) DEFAULT NULL,
  `user_auth` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_1d7p0xy0h7loanh4paykfxtna` (`user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `meeting_serv` (
  `meeting_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mt_comment` varchar(255) DEFAULT NULL,
  `mt_content` varchar(255) DEFAULT NULL,
  `mt_date` date NOT NULL,
  `mt_fn_time` time DEFAULT NULL,
  `part` varchar(255) DEFAULT NULL,
  `mt_st_time` time NOT NULL,
  `mt_status` varchar(255) NOT NULL,
  `mt_name` varchar(255) NOT NULL,
  PRIMARY KEY (`meeting_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `user_mt_connect` (
  `user_id` bigint(20) NOT NULL,
  `meeting_id` bigint(20) NOT NULL,
  KEY `FK3k5r4e90m3e0u6uxmtfvel3w5` (`meeting_id`),
  KEY `FK5q473qsmd78i32ve9c7839cpx` (`user_id`),
  CONSTRAINT `FK3k5r4e90m3e0u6uxmtfvel3w5` FOREIGN KEY (`meeting_id`) REFERENCES `meeting_serv` (`meeting_id`),
  CONSTRAINT `FK5q473qsmd78i32ve9c7839cpx` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `meeting_checklist` (
  `meeting_meeting_id` bigint(20) NOT NULL,
  `checklist` varchar(255) DEFAULT NULL,
  KEY `FKbecyby7w5870yugo9nd9xtbjm` (`meeting_meeting_id`),
  CONSTRAINT `FKbecyby7w5870yugo9nd9xtbjm` FOREIGN KEY (`meeting_meeting_id`) REFERENCES `meeting_serv` (`meeting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


