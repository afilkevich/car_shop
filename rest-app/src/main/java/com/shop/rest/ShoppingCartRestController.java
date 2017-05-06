package com.shop.rest;

import com.shop.model.ShoppingCart;
import com.shop.model.ShoppingCartDTO;
import com.shop.service.ShoppingCartService;
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
public class ShoppingCartRestController {
    private static final Logger LOGGER= LogManager.getLogger();

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler({IllegalArgumentException.class})
    public String incorrestDataError() {
        return "{  \"response\" : \"Incorrect Data Error\' }";
    }

    @Autowired
    ShoppingCartService cartService;

    // curl -v localhost:8088/carts
    @ResponseBody
    @RequestMapping(value="/carts",method = RequestMethod.GET)
    public List<ShoppingCartDTO> findAllShoppingCart(){
        LOGGER.debug("ShoppingCartRestController:findAllCart");
        return cartService.findAll();
    }

    // curl -v localhost:8088/cart/1
    @ResponseBody
    @RequestMapping(value = "cart/{id}",method = RequestMethod.GET)
    public ShoppingCartDTO findShoppingCarById(@PathVariable(value = "id")Integer id){
        LOGGER.debug("ShoppingCartRestController: findShoppingCartById");
        return cartService.findById(id);
    }

    // curl -H "Content-Type: application/json" -X POST -d '{"idCar":"2", "amountCar":"3"}' -v localhost:8088/cart
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value="cart",method = RequestMethod.POST)
    public Integer addShoppingCart(@RequestBody ShoppingCartDTO cart){
        LOGGER.debug("ShoppingCartRestController:addCart",cart);
        return cartService.insert(cart);
    }

    // curl -H "Content-Type: application/json" -X PUT -d '{"id":"1", "idCar":"1", "idDiscount":"1", "amountCar":"10", "price":"16000"}' -v localhost:8088/cart
    @ResponseBody
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @RequestMapping(value="cart",method = RequestMethod.PUT)
    public Integer updateShoppingCart(@RequestBody ShoppingCartDTO cart) {
        LOGGER.debug("ShoppingCartRestController:updateCart", cart);
        return cartService.update(cart);
    }

    //curl -X DELETE -v localhost:8088/cart/1
    @RequestMapping(value = "cart/{id}",method = RequestMethod.DELETE)
    public Integer deleteShoppingCart(@PathVariable(value = "id") Integer id){
        LOGGER.debug("ShoppingCartRestController:deleteCart",id);
        return cartService.delete(id);
    }
}


