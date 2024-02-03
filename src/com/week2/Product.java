package com.week2;

import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal price;
    private Double weight;

    public Product(String name, int price, double weight) {
        this.name = name;
        this.price = convertPriceBigDecimal(price);
        this.weight = returnWeight(weight);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = convertPriceBigDecimal(price);
    }

    public void setWeight(double weight) {
        this.weight = returnWeight(weight);
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public Double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nPrice: %d\nWeight: %d\n", this.name, this.price.intValue(), this.weight.longValue());
    }

    private BigDecimal convertPriceBigDecimal(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("price must bigger than zero!");
        }
        return new BigDecimal(price);
    }

    private Double returnWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("weight must bigger than zero!");
        }
        return weight;
    }
}
