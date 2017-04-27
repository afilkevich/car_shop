INSERT INTO `car_shop`.`brand`(`name_brand`)
VALUES
('Toyota'),
('Audi');

INSERT INTO `car_shop`.`configuration`(`type`,`description`)
VALUES
('Minimal','ventilation'),
('Standart','air-condition'),
('Lux','climat-control');

INSERT INTO `car_shop`.`model`(`name_model`)
VALUES
('Sedan'),
('Crossover');

INSERT INTO `car_shop`.`car`(`id_brand`,`id_model`,`id_configuration`,`date_builder`,`price`)
VALUES
(1,2,1,"2000-09-19",5000),
(1,1,1,"2001-11-10",6000);

INSERT INTO `car_shop`.`discount`(`value_discount`)
VALUES
(1),
(15);

INSERT INTO `car_shop`.`shopping_cart`(`id_car`,`id_discount`,`amount_car`,`price`)
VALUES
(1,1,2,9800);



