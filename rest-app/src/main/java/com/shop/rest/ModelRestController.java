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
}
