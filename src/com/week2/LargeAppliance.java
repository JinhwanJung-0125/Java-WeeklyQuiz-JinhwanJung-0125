package com.week2;

import java.math.BigDecimal;

public class LargeAppliance extends Product implements DeliveryChargeCalculator{
    public LargeAppliance(String name, int price, double weight) throws IllegalArgumentException {
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
        sb.append("Large Appliance\n");
        sb.append(super.toString());
        sb.append("==========================");
        return sb.toString();
    }
}
