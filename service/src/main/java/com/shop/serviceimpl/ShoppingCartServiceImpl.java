package com.shop.serviceimpl;

import com.shop.dao.ShoppingCartMapper;
import com.shop.model.ShoppingCart;
import com.shop.service.CarService;
import com.shop.service.DiscountService;
import com.shop.service.ShoppingCartService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by master on 3.5.17.
 */
@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Autowired
    CarService carService;

    @Autowired
    DiscountService discountService;

    public void setShoppingCartMapper(ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartMapper = shoppingCartMapper;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Override
    public List<ShoppingCart> findAll() {
        LOGGER.debug("ShoppingCartServiceImpl:findAll");
        return shoppingCartMapper.findAll();
    }

    @Override
    public ShoppingCart findById(Integer id) {
        LOGGER.debug("ShoppingCartServiceImpl:findById");
        Assert.notNull(id);
        Assert.isTrue(id!=0);
        ShoppingCart shoppingCart=shoppingCartMapper.findById(id);
        Assert.notNull(shoppingCart);
        return shoppingCart;
    }

    @Override
    public Integer insert(ShoppingCart cart) {
        LOGGER.debug("ShoppingCartServiceImpl:insert");
        Assert.notNull(cart);
        Assert.isNull(cart.getId());
        Assert.notNull(cart.getIdCar());
        Assert.notNull(carService.findById(cart.getIdCar()));
        Assert.isNull(cart.getIdDiscount());
        Assert.notNull(cart.getAmountCar());
        Assert.isNull(cart.getPrice());
        calculatePrice(cart);
        shoppingCartMapper.insert(cart);
        List<ShoppingCart>list=shoppingCartMapper.findAll();
        return list.get(list.size()-1).getId();
    }

    @Override
    public Integer update(ShoppingCart cart) {
        LOGGER.debug("ShoppingCartServiceImpl:update");
        Assert.notNull(cart);
        Assert.notNull(cart.getId());
        Assert.notNull(cart.getIdDiscount());
        Assert.notNull(cart.getPrice());
        Assert.notNull(cart.getAmountCar());
        Assert.notNull(cart.getIdCar());
        calculatePrice(cart);
        shoppingCartMapper.update(cart);
        return cart.getId();
    }

    @Override
    public Integer delete(Integer id) {
        LOGGER.debug("ShoppingCartImpl test:delete");
        Assert.notNull(id);
        Assert.notNull(shoppingCartMapper.findById(id));
        shoppingCartMapper.delete(id);
        return id;
    }

    @Override
    public void calculatePrice(ShoppingCart cart) {
        LOGGER.debug("ShoppingCartServiceImpl : calculatePrice");
        Assert.notNull(cart);
        Assert.notNull(cart.getIdCar());
        Assert.notNull(cart.getAmountCar());
        if (cart.getAmountCar()>3){
            cart.setIdDiscount(2);
            int valueDiscount=discountService.findById(cart.getIdDiscount()).getValueDiscount();
            int priceCar=carService.findById(cart.getIdCar()).getPrice();
            int priceAllCar=priceCar*cart.getAmountCar();
            int discount=(priceAllCar/100)*valueDiscount;
            cart.setPrice(priceAllCar-discount);
        }
        else {
            cart.setIdDiscount(1);
            int valueDiscount=discountService.findById(cart.getIdDiscount()).getValueDiscount();
            int priceCar=carService.findById(cart.getIdCar()).getPrice();
            int priceAllCar=priceCar*cart.getAmountCar();
            int discount=(priceAllCar/100)*valueDiscount;
            cart.setPrice(priceAllCar-discount);

        }
    }
}
