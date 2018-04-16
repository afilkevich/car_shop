//package com.shop.rest;
//
//import com.shop.model.Discount;
//import com.shop.service.DiscountService;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * Created by master on 4.5.17.
// */
//@CrossOrigin
//@RestController
//@RequestMapping
//public class DiscountRestController {
//    private static final Logger LOGGER= LogManager.getLogger();
//
//    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
//    @ExceptionHandler({IllegalArgumentException.class})
//    public String incorrestDataError() {
//        return "{  \"response\" : \"Incorrect Data Error\' }";
//    }
//
//    @Autowired
//    DiscountService discountService;
//
//    // curl -v localhost:8088/discounts
//    @ResponseBody
//    @RequestMapping(value="/discounts",method = RequestMethod.GET)
//    public List<Discount> findAllDiscount(){
//        LOGGER.debug("DiscountRestController:findAllDiscount");
//        return discountService.findAll();
//    }
//
//    // curl -v localhost:8088/discount/value/15
//    @ResponseBody
//    @RequestMapping(value = "discount/value/{value}",method = RequestMethod.GET)
//    public Discount findDiscountByValue(@PathVariable(value = "value")Integer value){
//        LOGGER.debug("ModelRestController: findModelByName");
//        return discountService.findByValue(value);
//    }
//
//    // curl -v localhost:8088/discount/1
//    @ResponseBody
//    @RequestMapping(value = "discount/{id}",method = RequestMethod.GET)
//    public Discount findDiscountById(@PathVariable(value = "id")Integer id){
//        LOGGER.debug("DiscountRestController: findDiscountById");
//        return discountService.findById(id);
//    }
//
//    // curl -H "Content-Type: application/json" -X POST -d '{"valueDiscount":"17"}' -v localhost:8088/discount
//    @ResponseBody
//    @ResponseStatus(value = HttpStatus.CREATED)
//    @RequestMapping(value="discount",method = RequestMethod.POST)
//    public Integer addDiscount(@RequestBody Discount discount){
//        LOGGER.debug("DiscountRestController:addDiscount",discount);
//        return discountService.insert(discount);
//    }
//
//    // curl -H "Content-Type: application/json" -X PUT -d '{"id":"1","valueDiscount":"5"}' -v localhost:8088/discount
//    @ResponseBody
//    @ResponseStatus(value = HttpStatus.ACCEPTED)
//    @RequestMapping(value = "discount", method = RequestMethod.PUT)
//    public Integer updateDiscount(@RequestBody Discount discount){
//        LOGGER.debug("DiscountRestController:updateDiscount",discount);
//        return discountService.update(discount);
//    }
//}
