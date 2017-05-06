SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema car_shop
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `car_shop` ;

-- -----------------------------------------------------
-- Schema car_shop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `car_shop` DEFAULT CHARACTER SET utf8 ;
USE `car_shop` ;

-- -----------------------------------------------------
-- Table `car_shop`.`configuration`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `car_shop`.`configuration` ;

CREATE TABLE IF NOT EXISTS `car_shop`.`configuration` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_configuration` VARCHAR(45) NOT NULL,
  `description_configuration` VARCHAR(75) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `car_shop`.`brand`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `car_shop`.`brand` ;

CREATE TABLE IF NOT EXISTS `car_shop`.`brand` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name_brand` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `car_shop`.`model`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `car_shop`.`model` ;

CREATE TABLE IF NOT EXISTS `car_shop`.`model` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name_model` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `car_shop`.`car`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `car_shop`.`car` ;

CREATE TABLE IF NOT EXISTS `car_shop`.`car` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_brand` INT NOT NULL,
  `id_model` INT NOT NULL,
  `id_configuration` INT NOT NULL,
  `date_builder` DATE NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_configuration_idx` (`id_configuration` ASC),
  INDEX `id_brand_idx` (`id_brand` ASC),
  INDEX `id_model_idx` (`id_model` ASC),
  CONSTRAINT `id_configuration`
    FOREIGN KEY (`id_configuration`)
    REFERENCES `car_shop`.`configuration` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_brand`
    FOREIGN KEY (`id_brand`)
    REFERENCES `car_shop`.`brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `id_model`
    FOREIGN KEY (`id_model`)
    REFERENCES `car_shop`.`model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `car_shop`.`discount`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `car_shop`.`discount` ;

CREATE TABLE IF NOT EXISTS `car_shop`.`discount` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `value_discount` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `car_shop`.`shopping cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `car_shop`.`shopping_cart` ;

CREATE TABLE IF NOT EXISTS `car_shop`.`shopping_cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_car` INT NOT NULL,
  `id_discount` INT NOT NULL,
  `amount_car` INT NOT NULL,
  `price_cart` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_car_idx` (`id_car` ASC),
  INDEX `id_count_idx` (`id_discount` ASC),
  CONSTRAINT `id_car`
    FOREIGN KEY (`id_car`)
    REFERENCES `car_shop`.`car` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_count`
    FOREIGN KEY (`id_discount`)
    REFERENCES `car_shop`.`discount` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;