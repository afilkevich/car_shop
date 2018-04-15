package com.shop.rest;


import com.shop.model.Model;

import com.shop.service.ModelService;
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
public class ModelRestController {
    private static final Logger LOGGER= LogManager.getLogger();

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler({IllegalArgumentException.class})
    public String incorrestDataError() {
        return "{  \"response\" : \"Incorrect Data Error\' }";
    }

    @Autowired
    ModelService modelService;

    // curl -v localhost:8088/models
    @ResponseBody
    @RequestMapping(value="/models",method = RequestMethod.GET)
    public List<Model> findAllModel(){
        LOGGER.debug("ModelRestController:findAllModel");
        return modelService.findAll();
    }
    // curl -v localhost:8088/model/name/Sedan
    @ResponseBody
    @RequestMapping(value = "model/name/{name}",method = RequestMethod.GET)
    public Model findModelByName(@PathVariable(value = "name")String name){
        LOGGER.debug("ModelRestController: findModelByName");
        return modelService.findByName(name);
    }

    // curl -v localhost:8088/model/1
    @ResponseBody
    @RequestMapping(value = "model/{id}",method = RequestMethod.GET)
    public Model findModelById(@PathVariable(value = "id")Integer id){
        LOGGER.debug("ModelRestController: findModelById");
        return modelService.findById(id);
    }

    // curl -H "Content-Type: application/json" -X POST -d '{"name":"jeep"}' -v localhost:8088/model
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value="model",method = RequestMethod.POST)
    public Integer addModel(@RequestBody Model model){
        LOGGER.debug("ModelRestController:addModel",model);
        return modelService.insert(model);
    }

    // curl -H "Content-Type: application/json" -X PUT -d '{"id":"2","name":"cross"}' -v localhost:8088/model
    @ResponseBody
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @RequestMapping(value = "model", method = RequestMethod.PUT)
    public Integer updateModel(@RequestBody Model model){
        LOGGER.debug("ModelRestController:updateModel",model);
        return modelService.update(model);
    }
}
