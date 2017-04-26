INSERT INTO brand(name_brand)
VALUES
('Toyota'),
('Audi');

INSERT INTO model(name_model)
VALUES
('Sedan'),
('Crossover');

INSERT INTO config(name_config,description_config)
VALUES
('budget','spacious boot'),
('typical','air-conditioner'),
('improv','climate control');

INSERT INTO discount(value_discount)
VALUES
(0),
(15);

INSERT INTO car(id_brand,id_model,id_config,date_build,price)
VALUES
(0,1,2,'1999-09-10',8900),
(1,0,1,'2009-10-11',10200);

INSERT INTO shopping_cart(id_car,id_discount,amount_car,price)
VALUES
(1,0,1,10200);

