
CREATE DATABASE shop DEFAULT CHARACTER SET utf8;
USE shop;

CREATE TABLE IF NOT EXISTS brand (
  id INT NOT NULL AUTO_INCREMENT,
  name_brand VARCHAR(45) NOT NULL UNIQUE ,
  PRIMARY KEY (id))
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS model (
  id INT NOT NULL AUTO_INCREMENT,
  name_model VARCHAR(45) NOT NULL UNIQUE ,
  PRIMARY KEY (id))
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS config (
  id INT NOT NULL AUTO_INCREMENT,
  name_config VARCHAR(45) NOT NULL UNIQUE ,
  description_config VARCHAR(100)
  PRIMARY KEY (id))
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS discount (
  id INT NOT NULL AUTO_INCREMENT,
  value_discount INT NOT NULL UNIQUE ,
  PRIMARY KEY (id))
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS car (
id INT NOT NULL AUTO_INCREMENT,
id_brand INT NOT NULL,
id_model INT NOT NULL,
id_config INT NOT NULL,
date_build DATE NOT NULL,
price INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(id_brand) REFERENCES brand(id),
FOREIGN KEY (id_model) REFERENCES model(id),
FOREIGN KEY(id_config) REFERENCES config(id))
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS shopping_cart (
id INT NOT NULL AUTO_INCREMENT,
id_car INT NOT NULL,
id_discount INT NOT NULL,
amount_car INT NOT NULL,
price INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(id_car) REFERENCES car(id),
FOREIGN KEY (id_discount) REFERENCES discount(id))
DEFAULT CHARACTER SET = utf8;



