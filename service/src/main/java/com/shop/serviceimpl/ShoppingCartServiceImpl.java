package com.shop.serviceimpl;

import com.shop.dao.ShoppingCartDTOMapper;
import com.shop.dao.ShoppingCartMapper;
import com.shop.model.ShoppingCart;
import com.shop.model.ShoppingCartDTO;
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
    ShoppingCartDTOMapper shoppingCartDTOMapper;

    @Autowired
    CarService carService;

    @Autowired
    DiscountService discountService;

    public void setShoppingCartDTOMapper(ShoppingCartDTOMapper shoppingCartDTOMapper) {
        this.shoppingCartDTOMapper = shoppingCartDTOMapper;
    }

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
    public List<ShoppingCartDTO> findAll() {
        LOGGER.debug("ShoppingCartServiceImpl:findAll");
        return shoppingCartDTOMapper.findAll();
    }

    @Override
    public ShoppingCartDTO findById(Integer id) {
        LOGGER.debug("ShoppingCartServiceImpl:findById");
        Assert.notNull(id);

        ShoppingCartDTO shoppingCart=shoppingCartDTOMapper.findById(id);
        return shoppingCart;
    }

    @Override
    public Integer insert(ShoppingCartDTO cartDTO) {
        LOGGER.debug("ShoppingCartServiceImpl:insert");
        Assert.notNull(cartDTO);
        Assert.isNull(cartDTO.getId());
        ShoppingCart cart= convertToAddShoppingCart(cartDTO);
         calculatePrice(cart);
         shoppingCartMapper.insert(cart);
        List<ShoppingCartDTO>list=shoppingCartDTOMapper.findAll();
        return list.get(list.size()-1).getId();
    }

    @Override
    public Integer update(ShoppingCartDTO cartDTO) {
        LOGGER.debug("ShoppingCartServiceImpl:update");
        Assert.notNull(cartDTO);
        Assert.notNull(cartDTO.getId());
        ShoppingCart cart=convertToUpShoppingCart(cartDTO);
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
        cart.setPrice(null);
        cart.setIdDiscount(null);
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

    @Override
    public ShoppingCart convertToAddShoppingCart(ShoppingCartDTO cartDTO) {
        ShoppingCart cart=new ShoppingCart();
        cart.setId(cartDTO.getId());
        Assert.notNull(cartDTO.getIdCar());
        cart.setIdCar(cartDTO.getIdCar());
        Assert.notNull(cartDTO.getAmountCar());
        cart.setAmountCar(cartDTO.getAmountCar());
        return cart;
    }

    @Override
    public ShoppingCart convertToUpShoppingCart(ShoppingCartDTO cartDTO) {
        ShoppingCart cart=new ShoppingCart();
        cart.setId(cartDTO.getId());
        Assert.notNull(cartDTO.getIdCar());
        cart.setIdCar(cartDTO.getIdCar());
        Assert.notNull(cartDTO.getAmountCar());
        cart.setAmountCar(cartDTO.getAmountCar());

        cart.setIdDiscount(null);

        cart.setPrice(null);
        return cart;
    }
}
