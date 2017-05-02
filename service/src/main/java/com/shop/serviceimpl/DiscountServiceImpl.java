package com.shop.serviceimpl;

import com.shop.dao.DiscountMapper;
import com.shop.model.Discount;
import com.shop.service.DiscountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by master on 2.5.17.
 */
@Service
@Transactional
public class DiscountServiceImpl implements DiscountService {

   private static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    DiscountMapper discountMapper;

    public void setDiscountMapper(DiscountMapper discountMapper) {
        this.discountMapper = discountMapper;
    }

    @Override
    public List<Discount> findAll() {
        LOGGER.debug("DiscountServiceImpl :findAll");
        return discountMapper.findAll();
    }

    @Override
    public Discount findByValue(Integer value) {
        LOGGER.debug("DiscountServiceImpl :findByValue", value);
        Assert.notNull(value);
        Assert.notNull(value!=0);
        Discount discount=discountMapper.findByValue(value);
        Assert.notNull(discount);
        return discount;
    }

    @Override
    public Discount findById(Integer id) {
        LOGGER.debug("DiscountserviceImpl : findById");
        Assert.notNull(id);
        Assert.isTrue(id>0);
        Discount discount=discountMapper.findById(id);
        Assert.notNull(discount);
        return discount;
    }

    @Override
    public void insert(Discount discount) {
        LOGGER.debug("DiscountServiceImpl : insert", discount);
        Assert.notNull(discount);
        Assert.isNull(discount.getId());
        Assert.notNull(discount.getValueDiscount());
        discountMapper.insert(discount);
    }

    @Override
    public void update(Discount discount) {
        LOGGER.debug("DiscountServiceImpl :update",discount);
        Assert.notNull(discount);
        Assert.notNull(discountMapper.findById(discount.getId()));
        Assert.notNull(discount.getValueDiscount());
        discountMapper.update(discount);

    }
}
