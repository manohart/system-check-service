-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: db_sys_check
-- Source Schemata: db_report
-- Created: Tue Nov 03 10:15:54 2015
-- Workbench Version: 6.3.4
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema db_sys_check
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `db_sys_check` ;
CREATE SCHEMA IF NOT EXISTS `db_sys_check` ;

-- ----------------------------------------------------------------------------
-- Table db_sys_check.tbl_db_check
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_check`.`tbl_db_check` (
  `report_id` INT(11) NOT NULL COMMENT '',
  `check_id` INT(11) NOT NULL COMMENT '',
  `sequence` INT(11) NOT NULL DEFAULT '-1' COMMENT '',
  `header` VARCHAR(200) NOT NULL COMMENT '',
  `query_id` INT(11) NOT NULL COMMENT '',
  `query_input_id` INT(11) NULL DEFAULT NULL COMMENT '',
  `data_expectation` VARCHAR(15) NOT NULL DEFAULT 'NON_EMPTY' COMMENT '',
  `processor_id` INT(11) NULL DEFAULT NULL COMMENT '',
  `processor_input_id` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `exceptions_only` CHAR(1) NOT NULL DEFAULT 'N' COMMENT '',
  `is_active` CHAR(1) NOT NULL DEFAULT 'Y' COMMENT '',
  PRIMARY KEY (`report_id`, `check_id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_sys_check.tbl_db_query
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_check`.`tbl_db_query` (
  `id` INT(11) NOT NULL COMMENT '',
  `name` VARCHAR(100) NOT NULL COMMENT '',
  `schema` VARCHAR(100) NOT NULL DEFAULT 'Generic' COMMENT '',
  `description` VARCHAR(150) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_sys_check.tbl_db_query_input
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_check`.`tbl_db_query_input` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `type` VARCHAR(10) NOT NULL DEFAULT 'STRING' COMMENT '',
  `value` VARCHAR(200) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_sys_check.tbl_email_config
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_check`.`tbl_email_config` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `category` VARCHAR(45) NOT NULL COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `from_addr` VARCHAR(100) NOT NULL COMMENT '',
  `to_addr` VARCHAR(200) NOT NULL COMMENT '',
  `cc_addr` VARCHAR(100) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_sys_check.tbl_file_check_group
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_check`.`tbl_file_check_group` (
  `report_id` INT(11) NOT NULL COMMENT '',
  `section_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `section_name` VARCHAR(100) NULL DEFAULT NULL COMMENT '',
  `suquence` INT(11) NOT NULL DEFAULT '0' COMMENT '',
  `root` VARCHAR(250) NULL DEFAULT NULL COMMENT '',
  `days_old` INT(11) NULL DEFAULT NULL COMMENT '',
  `append_type` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `append_seperator` VARCHAR(5) NULL DEFAULT '_' COMMENT '',
  `extension` VARCHAR(10) NULL DEFAULT NULL COMMENT '',
  `min_size` INT(11) NULL DEFAULT '-1' COMMENT '',
  `comment` VARCHAR(150) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`section_id`)  COMMENT '',
  UNIQUE INDEX `report_id_UNIQUE` (`report_id` ASC)  COMMENT '',
  UNIQUE INDEX `section_id_UNIQUE` (`section_id` ASC)  COMMENT '',
  UNIQUE INDEX `suquence_UNIQUE` (`suquence` ASC)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_sys_check.tbl_file_check_item
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_check`.`tbl_file_check_item` (
  `group_id` INT(11) NOT NULL COMMENT '',
  `item_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `file_name` VARCHAR(100) NOT NULL COMMENT '',
  PRIMARY KEY (`item_id`)  COMMENT '',
  UNIQUE INDEX `section_id_UNIQUE` (`group_id` ASC)  COMMENT '',
  UNIQUE INDEX `item_id_UNIQUE` (`item_id` ASC)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_sys_check.tbl_report
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_check`.`tbl_report` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `code` VARCHAR(45) NOT NULL COMMENT '',
  `type` VARCHAR(10) NOT NULL DEFAULT 'HTML' COMMENT '',
  `name` VARCHAR(60) NOT NULL COMMENT '',
  `description` VARCHAR(100) NULL DEFAULT NULL COMMENT '',
  `category` VARCHAR(45) NOT NULL COMMENT '',
  `sub_category` VARCHAR(45) NOT NULL COMMENT '',
  `is_active` CHAR(1) NOT NULL DEFAULT 'Y' COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8
COMMENT = 'Report configuration main configuration';

-- ----------------------------------------------------------------------------
-- Table db_sys_check.tbl_report_distribution
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_check`.`tbl_report_distribution` (
  `report_id` INT(11) NOT NULL COMMENT '',
  `email_config_id` INT(11) NOT NULL COMMENT '',
  `is_active` CHAR(1) NOT NULL DEFAULT 'Y' COMMENT '',
  `skip_empty` CHAR(1) NOT NULL DEFAULT 'N' COMMENT '',
  PRIMARY KEY (`report_id`, `email_config_id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_sys_check.tbl_report_folder
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_check`.`tbl_report_folder` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `category` VARCHAR(45) NOT NULL COMMENT '',
  `sub_category` VARCHAR(45) NOT NULL COMMENT '',
  `folder` VARCHAR(200) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_sys_check.tbl_report_history
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_check`.`tbl_report_history` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `report_id` INT(11) NOT NULL COMMENT '',
  `status` VARCHAR(45) NOT NULL COMMENT '',
  `start_tm` DATETIME NOT NULL COMMENT '',
  `end_tm` DATETIME NULL DEFAULT NULL COMMENT '',
  `user_id` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table db_sys_check.tbl_report_template
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_sys_check`.`tbl_report_template` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(100) NOT NULL COMMENT '',
  `description` VARCHAR(100) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '		';
SET FOREIGN_KEY_CHECKS = 1;
