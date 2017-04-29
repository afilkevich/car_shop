package com.shop.model;

import java.util.Objects;

/**
 * Created by master on 21.4.17.
 */
public class ShoppingCart {

    private Integer id;
    private Integer idCar;
    private Integer idDiscount;
    private Integer amountCar;
    private Integer price;

    public ShoppingCart(Integer id, Integer idCar, Integer idDiscount, Integer amountCar, Integer price) {
        this.id = id;
        this.idCar = idCar;
        this.idDiscount = idDiscount;
        this.amountCar = amountCar;
        this.price = price;
    }

    public ShoppingCart(Integer idCar, Integer idDiscount, Integer amountCar, Integer price) {
        this.idCar = idCar;
        this.idDiscount = idDiscount;
        this.amountCar = amountCar;
        this.price = price;
    }

    public ShoppingCart(Integer idCar, Integer amountCar) {
        this.idCar = idCar;
        this.amountCar = amountCar;
    }

    public ShoppingCart() {
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

    public Integer getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(Integer idDiscount) {
        this.idDiscount = idDiscount;
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
        return "ShoppingCart{" +
                "id=" + id +
                ", idCar=" + idCar +
                ", idDiscount=" + idDiscount +
                ", amountCar=" + amountCar +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(idCar, that.idCar) &&
                Objects.equals(idDiscount, that.idDiscount) &&
                Objects.equals(amountCar, that.amountCar) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCar, idDiscount, amountCar, price);
    }
}
