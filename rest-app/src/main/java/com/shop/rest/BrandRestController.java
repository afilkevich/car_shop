package com.shop.rest;

import com.shop.model.Brand;
import com.shop.service.BrandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by master on 3.5.17.
 */
@CrossOrigin
@RestController
@RequestMapping
public class BrandRestController {

    private static final Logger LOGGER= LogManager.getLogger();

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler({IllegalArgumentException.class})
    public String incorrestDataError() {
        return "{  \"response\" : \"Incorrect Data Error\' }";
    }

    @Autowired
    BrandService brandService;

    // curl -v localhost:8088/brands
    @ResponseBody
    @RequestMapping(value="/brands",method = RequestMethod.GET)
    public List<Brand> findAllBrand(){
        LOGGER.debug("BrandRestController:findAllBrand");
        return brandService.findAll();
    }

    // curl -v localhost:8088/brand/name/Toyota
    @ResponseBody
    @RequestMapping(value = "brand/name/{name}",method = RequestMethod.GET)
    public Brand findBrandByName(@PathVariable(value = "name")String name){
        LOGGER.debug("BrandRestController: findBrandByName");
        return brandService.findByName(name);
    }

    // curl -v localhost:8088/brand/1
    @ResponseBody
    @RequestMapping(value = "brand/{id}",method = RequestMethod.GET)
    public Brand findBrandById(@PathVariable(value = "id")Integer id){
        LOGGER.debug("BrandRestController: findBrandById");
        return brandService.findById(id);
    }


}
