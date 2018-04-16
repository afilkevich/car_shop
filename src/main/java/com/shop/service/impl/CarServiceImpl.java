//package com.shop.service.impl;
//
//import com.shop.dao.CarDTOMapper;
//import com.shop.dao.CarMapper;
//import com.shop.model.Car;
//import com.shop.model.CarDTO;
//import com.shop.service.BrandService;
//import com.shop.service.CarService;
//import com.shop.service.ConfigService;
//import com.shop.service.ModelService;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.Assert;
//
//import java.util.List;
//
///**
// * Created by master on 3.5.17.
// */
//@Service
//@Transactional
//public class CarServiceImpl implements CarService {
//
//    private static final Logger LOGGER= LogManager.getLogger();
//
//     @Autowired
//    CarMapper carMapper;
//
//    @Autowired
//    CarDTOMapper carDTOMapper;
//
//    @Autowired
//    BrandService brandService;
//
//    @Autowired
//    ModelService modelService;
//
//    @Autowired
//    ConfigService configService;
//
//    public void setConfigService(ConfigService configService) {
//        this.configService = configService;
//    }
//
//    public void setCarMapper(CarMapper carMapper) {
//        this.carMapper = carMapper;
//    }
//
//    public void setBrandService(BrandService brandService) {
//        this.brandService = brandService;
//    }
//
//    public void setModelService(ModelService modelService) {
//        this.modelService = modelService;
//    }
//
//    @Override
//    public List<CarDTO> findAll() {
//        LOGGER.debug("CarServiceImpl:findAll()");
//        return carDTOMapper.findAll();
//    }
//
//    @Override
//    public List<CarDTO> findByBrand(String brand) {
//        LOGGER.debug("CarServiceImpl: findIdBrand()");
//        Assert.notNull(brand);
//
//        return carDTOMapper.findByBrand(brand);
//    }
//
//    @Override
//    public List<CarDTO> findByModel(String model) {
//        LOGGER.debug("CarServiceImpl:findIdModel");
//        Assert.notNull(model);
//        return carDTOMapper.findByModel(model);
//    }
//
//    @Override
//    public List<CarDTO> findByBrandAndModel(String brand, String model) {
//        LOGGER.debug("CarServiceImpl: findByBrandAndModel");
//        return carDTOMapper.findByBrandAndModel(brand,model);
//
//    }
//
//    @Override
//    public CarDTO findById(Integer id) {
//        LOGGER.debug("CarServiceImpl:findById");
//        Assert.notNull(id);
//        Assert.isTrue(id>0);
//        CarDTO car=carDTOMapper.findById(id);
//
//        return car;
//    }
//
//    @Override
//    public Integer insert(CarDTO cart) {
//        LOGGER.debug("CarServiceImpl:insert");
//        Assert.notNull(cart);
//        Assert.isNull(cart.getId());
//        carMapper.insert(convertToCar(cart));
//        List<Car>list=carMapper.findAll();
//        return list.get(list.size()-1).getId();
//    }
//
//    @Override
//    public Integer update(CarDTO cart) {
//        LOGGER.debug("CarServiceImpl: update");
//        Assert.notNull(cart);
//       Assert.notNull(cart.getId());
//        carMapper.update(convertToCar(cart));
//        return cart.getId();
//    }
//
//    @Override
//    public Integer delete(Integer id) {
//        LOGGER.debug("CarServiceImpl :delete");
//        Assert.notNull(id);
//        Assert.notNull(carMapper.findById(id));
//        carMapper.delete(id);
//        return id;
//
//    }
//
//    @Override
//    public Car convertToCar(CarDTO carDTO) {
//        LOGGER.debug("CarServiceImpl:convertToCar()");
//        Car car=new Car();
//        Assert.notNull(carDTO);
//        car.setId(carDTO.getId());
//        Assert.notNull(brandService.findByName(carDTO.getBrandName()));
//        car.setIdBrand(brandService.findByName(carDTO.getBrandName()).getId());
//        Assert.notNull(modelService.findByName(carDTO.getModelName()));
//        car.setIdModel(modelService.findByName(carDTO.getModelName()).getId());
//        Assert.notNull(configService.findByType(carDTO.getConfigName()));
//        car.setIdConfig(configService.findByType(carDTO.getConfigName()).getId());
//        car.setDateBuilder(carDTO.getDateBuilder());
//        car.setPrice(carDTO.getPrice());
//        return car;
//    }
//}
