package com.shop.rest;

import com.shop.model.Car;
import com.shop.model.CarDTO;
import com.shop.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by master on 4.5.17.
 */
@CrossOrigin
@RestController
@RequestMapping
public class CarRestController {
    private static final Logger LOGGER= LogManager.getLogger();

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler({IllegalArgumentException.class})
    public String incorrestDataError() {
        return "{  \"response\" : \"Incorrect Data Error\' }";
    }

    @Autowired
    CarService carService;

    // curl -v localhost:8088/cars
    @ResponseBody
    @RequestMapping(value="/cars",method = RequestMethod.GET)
    public List<CarDTO> findAllCar(){
        LOGGER.debug("CarRestController:findAllCar");
        return carService.findAll();
    }

    // curl -v localhost:8088/car/brand/Toyota
    @ResponseBody
    @RequestMapping(value = "car/brand/{name}",method = RequestMethod.GET)
    public List<CarDTO> findCarByBrand(@PathVariable(value = "name")String name){
        LOGGER.debug("CarRestController: findCarByBrand");
        return carService.findByBrand(name);
    }
    // curl -v localhost:8088/car/model/Sedan
    @ResponseBody
    @RequestMapping(value = "car/model/{name}",method = RequestMethod.GET)
    public List<CarDTO> findCarByModel(@PathVariable(value = "name")String name){
        LOGGER.debug("CarRestController: findCarByModel");
        return carService.findByModel(name);
    }

    // curl -v localhost:8088/car/brand/Toyota/model/Sedan
    @ResponseBody
    @RequestMapping(value = "car/brand/{brand}/model/{model}",method = RequestMethod.GET)
    public List<CarDTO> findCarByBrandAndModel(@PathVariable(value = "brand" )String brand ,
                                               @PathVariable(value = "model")String model){
        LOGGER.debug("CarRestController: findCarByModel");
        return carService.findByBrandAndModel(brand,model);
    }

    // curl -v localhost:8088/car/2
    @ResponseBody
    @RequestMapping(value = "car/{id}",method = RequestMethod.GET)
    public CarDTO findCarById(@PathVariable(value = "id")Integer id){
        LOGGER.debug("CarRestController: findCarById");
        return carService.findById(id);
    }

    // curl -H "Content-Type: application/json" -X POST -d '{"idBrand":"2", "idModel":"1", "idConfig":"3", "dateBuilder":"2008-11-10", "price":"16000"}' -v localhost:8088/car
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value="car",method = RequestMethod.POST)
    public Integer addCar(@RequestBody CarDTO carDTO){
        LOGGER.debug("CarRestController:addCar",carDTO);
        return carService.insert(carDTO);
    }

    // curl -H "Content-Type: application/json" -X PUT -d '{"id":"2", "idBrand":"1", "idModel":"1", "idConfig":"1", "dateBuilder":"2008-11-10", "price":"16000"}' -v localhost:8088/car
    @ResponseBody
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @RequestMapping(value="car",method = RequestMethod.PUT)
    public Integer updateCar(@RequestBody CarDTO carDTO){
        LOGGER.debug("CarRestController:updateCar",carDTO);
        return carService.update(carDTO);
    }

    //curl -X DELETE -v localhost:8088/car/2
    @RequestMapping(value = "car/{id}",method = RequestMethod.DELETE)
    public Integer deleteCar(@PathVariable(value = "id") Integer id){
        LOGGER.debug("CarRestController:deleteCar",id);
        return carService.delete(id);
    }


}
