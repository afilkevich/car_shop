package com.shop.rest;

import com.shop.model.Config;
import com.shop.service.ConfigService;
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
public class ConfigRestController {
    private static final Logger LOGGER= LogManager.getLogger();

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler({IllegalArgumentException.class})
    public String incorrestDataError() {
        return "{  \"response\" : \"Incorrect Data Error\' }";
    }

    @Autowired
    ConfigService configService;

    // curl -v localhost:8088/configs
    @ResponseBody
    @RequestMapping(value="/configs",method = RequestMethod.GET)
    public List<Config> findAllConfig(){
        LOGGER.debug("ConfigRestController:findAllConfig");
        return configService.findAll();
    }

    // curl -v localhost:8088/config/type/Standart
    @ResponseBody
    @RequestMapping(value = "config/type/{type}",method = RequestMethod.GET)
    public Config findConfigByType(@PathVariable(value = "type")String type){
        LOGGER.debug("ModelRestController: findModelByName");
        return configService.findByType(type);
    }

    // curl -v localhost:8088/config/1
    @ResponseBody
    @RequestMapping(value = "config/{id}",method = RequestMethod.GET)
    public Config findConfigById(@PathVariable(value = "id")Integer id){
        LOGGER.debug("ConfigRestController: findConfigById");
        return configService.findById(id);
    }

    // curl -H "Content-Type: application/json" -X POST -d '{"type":"apgred", "description":"pro"}' -v localhost:8088/config
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value="config",method = RequestMethod.POST)
    public Integer addConfig(@RequestBody Config config){
        LOGGER.debug("ConfigRestController:addConfig",config);
        return configService.insert(config);
    }

    // curl -H "Content-Type: application/json" -X PUT -d '{"id":"2","type":"stan","description":"vent"}' -v localhost:8088/config
    @ResponseBody
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @RequestMapping(value = "config", method = RequestMethod.PUT)
    public Integer updateConfig(@RequestBody Config config){
        LOGGER.debug("ConfigRestController:updateConfig",config);
        return configService.update(config);
    }
}
