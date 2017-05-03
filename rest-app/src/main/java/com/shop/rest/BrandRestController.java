package com.shop.rest;

import com.shop.model.Brand;
import com.shop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by master on 3.5.17.
 */
@CrossOrigin
@RestController
@RequestMapping(value="/brand")
public class BrandRestController {

    @Autowired
    BrandService brandService;

    // curl -v localhost:8088/brand
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Brand> getAllBrand(){
        return brandService.findAll();
    }

}
