package com.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by master on 21.4.17.
 */
public class Car {
private Integer id;
    private Integer idBrand;
    private Integer idModel;
    private Integer idConfig;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateBuilder;
    private Integer price;

    public Car(Integer id, Integer idBrand, Integer idModel, Integer idConfig, LocalDate dateBuilder, Integer price) {
        this.id = id;
        this.idBrand = idBrand;
        this.idModel = idModel;
        this.idConfig = idConfig;
        this.dateBuilder =dateBuilder;
        this.price = price;
    }

    public Car(Integer idBrand, Integer idModel, Integer idConfig,LocalDate dateBuilder, Integer price) {
        this.idBrand = idBrand;
        this.idModel = idModel;
        this.idConfig = idConfig;
        this.dateBuilder = dateBuilder;
        this.price = price;
    }

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Integer idBrand) {
        this.idBrand = idBrand;
    }

    public Integer getIdModel() {
        return idModel;
    }

    public void setIdModel(Integer idModel) {
        this.idModel = idModel;
    }

    public Integer getIdConfig() {
        return idConfig;
    }

    public void setIdConfig(Integer idConfig) {
        this.idConfig = idConfig;
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
        return "Car{" +
                "id=" + id +
                ", idBrand=" + idBrand +
                ", idModel=" + idModel +
                ", idConfig=" + idConfig +
                ", dateBuilder=" + dateBuilder +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(idBrand, car.idBrand) &&
                Objects.equals(idModel, car.idModel) &&
                Objects.equals(idConfig, car.idConfig) &&
                Objects.equals(dateBuilder, car.dateBuilder) &&
                Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idBrand, idModel, idConfig, dateBuilder, price);
    }
}
