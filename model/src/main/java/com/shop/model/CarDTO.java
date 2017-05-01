package com.shop.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by master on 29.4.17.
 */
public class CarDTO {
    private Integer id;
    private String brandName;
    private String modelName;
    private String configType;
    private String configDescription;
    private LocalDate dateBuilder;
    private Integer price;

    public CarDTO(Integer id, String brandName, String modelName,
                  String configType, String configDescription,
                  LocalDate dateBuilder, Integer price) {
        this.id = id;
        this.brandName = brandName;
        this.modelName = modelName;
        this.configType = configType;
        this.configDescription = configDescription;
        this.dateBuilder = dateBuilder;
        this.price = price;
    }

    public CarDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getConfigDescription() {
        return configDescription;
    }

    public void setConfigDescription(String configDescription) {
        this.configDescription = configDescription;
    }

    public LocalDate getDateBuilder() {
        return dateBuilder;
    }

    public void setDateBuilder(LocalDate dateBuilder) {
        this.dateBuilder = dateBuilder;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", configType='" + configType + '\'' +
                ", configDescription='" + configDescription + '\'' +
                ", dateBuilder=" + dateBuilder +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDTO carDTO = (CarDTO) o;
        return Objects.equals(id, carDTO.id) &&
                Objects.equals(brandName, carDTO.brandName) &&
                Objects.equals(modelName, carDTO.modelName) &&
                Objects.equals(configType, carDTO.configType) &&
                Objects.equals(configDescription, carDTO.configDescription) &&
                Objects.equals(dateBuilder, carDTO.dateBuilder) &&
                Objects.equals(price, carDTO.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brandName, modelName, configType, configDescription, dateBuilder, price);
    }
}
