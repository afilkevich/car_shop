package com.shop.model;

import java.util.Objects;

/**
 * Created by master on 21.4.17.
 */
public class Config {
    private Integer id;
    private String type;
    private String descripction;

    public Config(Integer id, String type, String descripction) {
        this.id = id;
        this.type = type;
        this.descripction = descripction;
    }

    public Config() {
    }

    public Config(String type, String descripction) {
        this.type = type;
        this.descripction = descripction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescripction() {
        return descripction;
    }

    public void setDescripction(String descripction) {
        this.descripction = descripction;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", descripction='" + descripction + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Config config = (Config) o;
        return Objects.equals(id, config.id) &&
                Objects.equals(type, config.type) &&
                Objects.equals(descripction, config.descripction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, descripction);
    }
}
