# It's simple Restfull application CarShop on Java.
#Use: MySql,Spring,mybatis, maven,jetty
Start REST: cd rest mvn jetty:run
BrandRestController:
curl -v localhost:8088/brands
curl -v localhost:8088/brand/name/Toyota
curl -v localhost:8088/brand/1
curl -H "Content-Type: application/json" -X POST -d '{"name":"BMW"}' -v localhost:8088/brand
curl -H "Content-Type: application/json" -X PUT -d '{"id":"2","name":"BMW"}' -v localhost:8088/brand
