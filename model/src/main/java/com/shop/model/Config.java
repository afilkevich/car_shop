package com.shop.model;

import java.util.Objects;

/**
 * Created by master on 21.4.17.
 */
public class Config {
    private Integer id;
    private String type;
    private String description;

    public Config(Integer id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public Config() {
    }

    public Config(String type, String description) {
        this.type = type;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Config config = (Config) o;
        return Objects.equals(id, config.id) &&
                Objects.equals(type, config.type) &&
                Objects.equals(description, config.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, description);
    }
}
