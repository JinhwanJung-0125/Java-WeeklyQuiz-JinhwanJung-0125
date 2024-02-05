package com.week2.dailyquiz0205;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Product implements Promotion {

    private String name;
    private BigDecimal price;
    private Double weight;

    public Product(String name, int price, double weight) {
        this.name = returnName(name);
        this.price = convertPriceBigDecimal(price);
        this.weight = returnWeight(weight);
    }

    public void setName(String name) {
        this.name = returnName(name);
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

    /**
     * 상품의 할인 금액을 return하는 메소드 <br>
     * 각 품목 별 할인금액은 식료품은 2,000원, 화장품은 3,000원, 대형 가전은 0원이다.
     */
    @Override
    public BigDecimal getDiscountAmount() {
        if (this instanceof Grocery) {
            return BigDecimal.valueOf(2000);
        }
        else if (this instanceof Beauty) {
            return BigDecimal.valueOf(10000);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String price = decimalFormat.format(this.price);
        return String.format("Name: %s\nPrice: %s 원\nWeight: %d KG\n", this.name, price,
            this.weight.longValue());
    }

    /**
     * 이름 칸이 비어있는지 확인하는 메소드
     */
    private String returnName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name is not entered!");
        }
        return name;
    }

    /**
     * 가격이 0 이상인지 확인 후 BigDecimal로 변환하는 메소드
     */
    private BigDecimal convertPriceBigDecimal(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("price must bigger than zero!");
        }
        return BigDecimal.valueOf(price);
    }

    /**
     * 무게가 0 이상인지 확인하는 메소드
     */
    private Double returnWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("weight must bigger than zero!");
        }
        return weight;
    }
}
