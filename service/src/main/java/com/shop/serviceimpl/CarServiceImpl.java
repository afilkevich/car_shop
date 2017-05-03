package com.shop.serviceimpl;

import com.shop.dao.CarMapper;
import com.shop.model.Car;
import com.shop.service.BrandService;
import com.shop.service.CarService;
import com.shop.service.ConfigService;
import com.shop.service.ModelService;
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
public class CarServiceImpl implements CarService {

    private static final Logger LOGGER= LogManager.getLogger();

     @Autowired
    CarMapper carMapper;

    @Autowired
    BrandService brandService;

    @Autowired
    ModelService modelService;

    @Autowired
    ConfigService configService;

    public void setConfigService(ConfigService configService) {
        this.configService = configService;
    }

    public void setCarMapper(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Override
    public List<Car> findAll() {
        LOGGER.debug("CarServiceImpl:findAll()");
        return carMapper.findAll();
    }

    @Override
    public List<Car> findByIdBrand(Integer idBrand) {
        LOGGER.debug("CarServiceImpl: findIdBrand()");
        Assert.notNull(idBrand);
        Assert.notNull(brandService.findById(idBrand));
        return carMapper.findByIdBrand(idBrand);
    }

    @Override
    public List<Car> findByIdModel(Integer idModel) {
        LOGGER.debug("CarServiceImpl:findIdModel");
        Assert.notNull(idModel);
        Assert.notNull(modelService.findById(idModel));
        return carMapper.findByIdModel(idModel);
    }

    @Override
    public Car findById(Integer id) {
        LOGGER.debug("CarServiceImpl:findById");
        Assert.notNull(id);
        Assert.isTrue(id>0);
        Car car=carMapper.findById(id);
        Assert.notNull(car);
        return car;
    }

    @Override
    public void insert(Car car) {
        LOGGER.debug("CarServiceImpl:insert");
        Assert.notNull(car);
        Assert.isNull(car.getId());
        Assert.notNull(brandService.findById(car.getIdBrand()));
        Assert.notNull(modelService.findById(car.getIdModel()));
        Assert.notNull(configService.findById(car.getIdConfig()));
        Assert.notNull(car.getDateBuilder());
        Assert.notNull(car.getPrice());
        Assert.isTrue(car.getPrice()!=0);
        carMapper.insert(car);
    }

    @Override
    public void update(Car car) {
        LOGGER.debug("CarServiceImpl: update");
        Assert.notNull(car);
        Assert.notNull(car.getId());
        Assert.notNull(carMapper.findById(car.getId()));
        Assert.notNull(brandService.findById(car.getIdBrand()));
        Assert.notNull(modelService.findById(car.getIdModel()));
        Assert.notNull(configService.findById(car.getIdConfig()));
        Assert.notNull(car.getDateBuilder());
        Assert.notNull(car.getPrice());
        Assert.isTrue(car.getPrice()!=0);
        carMapper.update(car);
    }

    @Override
    public void delete(Integer id) {
        LOGGER.debug("CarServiceImpl :delete");
        Assert.notNull(id);
        Assert.notNull(carMapper.findById(id));
        carMapper.delete(id);

    }
}
