package com.shop.dao;

import com.shop.model.CarDTO;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Created by master on 5.5.17.
 */
public interface CarDTOMapper {
    List<CarDTO> findAll();
    List<CarDTO> findByBrand(String brand);
    List<CarDTO> findByModel(String model);
    List<CarDTO> findByBrandAndModel(@Param("brandName") String brand,@Param("modelName") String model);
    CarDTO findById(Integer id);
}
