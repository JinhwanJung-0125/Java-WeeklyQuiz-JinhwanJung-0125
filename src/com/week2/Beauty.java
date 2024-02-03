package com.week2;

import java.math.BigDecimal;

public class Beauty extends Product implements DeliveryChargeCalculator {

    public Beauty(String name, int price, double weight) throws IllegalArgumentException {
        super(name, price, weight);
    }

    @Override
    public BigDecimal getDeliveryCharge(Double weight, BigDecimal price) {
        BigDecimal deliveryFee = CalcUtil.getDeliveryFeeByWeight(weight);
        return CalcUtil.calcDeliveryFeeByPrice(deliveryFee, price);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("==========================\n");
        sb.append("Beauty\n");
        sb.append(super.toString());
        sb.append("==========================");
        return sb.toString();
    }
}
