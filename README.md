 It's simple Restfull application CarShop on Java.

Use: MySql,Spring,mybatis, maven,jetty

Start REST: cd rest-app mvn jetty:run

Start WEB app: cd js-client firefox  car.html

BrandRestController:

curl -v localhost:8088/brands

curl -v localhost:8088/brand/name/Toyota

curl -v localhost:8088/brand/1

curl -H "Content-Type: application/json" -X POST -d '{"name":"BMW"}' -v localhost:8088/brand

curl -H "Content-Type: application/json" -X PUT -d '{"id":"2","name":"BMW"}' -v localhost:8088/brand

ModelRestController:

curl -v localhost:8088/models

curl -v localhost:8088/model/name/Sedan

curl -v localhost:8088/model/1

curl -H "Content-Type: application/json" -X POST -d '{"name":"jeep"}' -v localhost:8088/model

curl -H "Content-Type: application/json" -X PUT -d '{"id":"2","name":"cross"}' -v localhost:8088/model

ConfigRestController:

curl -v localhost:8088/configs

curl -v localhost:8088/config/type/Standart

curl -v localhost:8088/config/1

curl -H "Content-Type: application/json" -X POST -d '{"type":"upgrade", "description":"pro"}' -v localhost:8088/config

curl -H "Content-Type: application/json" -X PUT -d '{"id":"2","type":"stan","description":"vent"}' -v localhost:8088/config

DiscountRestController:

curl -v localhost:8088/discounts

curl -v localhost:8088/discount/value/15

curl -v localhost:8088/discount/1

curl -H "Content-Type: application/json" -X POST -d '{"valueDiscount":"17"}' -v localhost:8088/discount

curl -H "Content-Type: application/json" -X PUT -d '{"id":"1","valueDiscount":"5"}' -v localhost:8088/discount

CarRestController:

curl -v localhost:8088/cars

curl -v localhost:8088/car/brand/Toyota

curl -v localhost:8088/car/model/Sedan

curl -v localhost:8088/car/brand/Toyota/model/Sedan

curl -v localhost:8088/car/2

curl -H "Content-Type: application/json" -X POST -d '{"brandName":"Audi", "modelName":"Sedan", "configName":"Lux", "configDescription":"climat-control","dateBuilder":"2008-11-10", "price":"96000"}' -v localhost:8088/car

curl -H "Content-Type: application/json" -X PUT -d '{"id":"2", "brandName":"Audi", "modelName":"Sedan", "configName":"Lux", "configDescription":"climat-control", "dateBuilder":"2008-11-10", "price":"16000"}' -v localhost:8088/car

curl -X DELETE -v localhost:8088/car/2

ShoppingCartRestController:

curl -v localhost:8088/carts

curl -v localhost:8088/cart/1

curl -H "Content-Type: application/json" -X POST -d '{"idCar":"2", "amountCar":"10"}' -v localhost:8088/car

curl -H "Content-Type: application/json" -X PUT -d '{"id":"1", "idCar":"1", "idDiscount":"1", "amountCar":"10", "price":"16000"}' -v localhost:8088/cart

curl -X DELETE -v localhost:8088/cart/1

