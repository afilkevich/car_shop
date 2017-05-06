package com.shop.model;

import java.util.Objects;

/**
 * Created by master on 5.5.17.
 */
public class ShoppingCartDTO {
    Integer id;
    Integer idCar;
    Integer valueDiscount;
    Integer amountCar;
    Integer price;

    public ShoppingCartDTO(Integer id, Integer idCar, Integer valueDiscount, Integer amountCar, Integer price) {
        this.id = id;
        this.idCar = idCar;
        this.valueDiscount = valueDiscount;
        this.amountCar = amountCar;
        this.price = price;
    }

    public ShoppingCartDTO(Integer idCar, Integer amountCar) {
        this.idCar = idCar;
        this.amountCar = amountCar;
    }

    public ShoppingCartDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public Integer getValueDiscount() {
        return valueDiscount;
    }

    public void setValueDiscount(Integer valueDiscount) {
        this.valueDiscount = valueDiscount;
    }

    public Integer getAmountCar() {
        return amountCar;
    }

    public void setAmountCar(Integer amountCar) {
        this.amountCar = amountCar;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShoppingCartDTO{" +
                "id=" + id +
                ", idCar=" + idCar +
                ", valueDiscount=" + valueDiscount +
                ", amountCar=" + amountCar +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartDTO that = (ShoppingCartDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(idCar, that.idCar) &&
                Objects.equals(valueDiscount, that.valueDiscount) &&
                Objects.equals(amountCar, that.amountCar) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCar, valueDiscount, amountCar, price);
    }
}
