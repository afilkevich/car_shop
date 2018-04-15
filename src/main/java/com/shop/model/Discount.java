package com.shop.model;

import java.util.Objects;

/**
 * Created by master on 21.4.17.
 */
public class Discount {
    private Integer id;
    private Integer valueDiscount;

    public Discount(Integer id, Integer valueDiscount) {
        this.id = id;
        this.valueDiscount = valueDiscount;
    }

    public Discount() {
    }

    public Discount(Integer valueDiscount) {
        this.valueDiscount = valueDiscount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValueDiscount() {
        return valueDiscount;
    }

    public void setValueDiscount(Integer valueDiscount) {
        this.valueDiscount = valueDiscount;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", valueDiscount=" + valueDiscount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return Objects.equals(id, discount.id) &&
                Objects.equals(valueDiscount, discount.valueDiscount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valueDiscount);
    }
}
