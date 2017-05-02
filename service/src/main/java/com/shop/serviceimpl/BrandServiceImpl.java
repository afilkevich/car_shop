package com.shop.serviceimpl;

import com.shop.dao.BrandMapper;
import com.shop.model.Brand;
import com.shop.service.BrandService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by master on 1.5.17.
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    private static final Logger LOGGER= LogManager.getLogger();

    @Autowired
    private BrandMapper brandMapper;

    public void setBrandMapper(BrandMapper brandMapper) {
        this.brandMapper = brandMapper;
    }

    @Override
    public List<Brand> findAll() {
        LOGGER.debug("BrandService:findAll()");
        return brandMapper.findAll();
    }

    @Override
    public Brand findByName(String name)  {
        LOGGER.debug("BrandService: findByName()",name);
        Assert.hasText(name);
        Brand brand=brandMapper.findByName(name);
        if (brand==null){
            throw new IllegalArgumentException();
        }
        return brand;
    }



    @Override
    public Brand findById(Integer id) {
        LOGGER.debug("BrandService: findById()",id);
        Assert.notNull(id);
        Assert.isTrue(id>0);
        Brand brand=brandMapper.findById(id);
       Assert.notNull(brand);
        return brand;
    }

    @Override
    public void insert(Brand brand) {
        LOGGER.debug("BrandServiceimpl:insert",brand);
        Assert.notNull(brand);
        Assert.hasText(brand.getName());
        brandMapper.insert(brand);
    }

    @Override
    public void update(Brand brand) {
        LOGGER.debug("BrandServiceImpl: update",brand);
        Assert.notNull(brand);
        Assert.notNull(brand.getId());
        Assert.hasText(brand.getName());
        Assert.notNull(brandMapper.findById(brand.getId()));
        brandMapper.update(brand);

    }
}
