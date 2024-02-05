package com.week2.dailyquiz0205;

public class LargeAppliance extends Product {
    public LargeAppliance(String name, int price, double weight) throws IllegalArgumentException {
        super(name, price, weight);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("--------------------------\n");
        sb.append("Type: Large Appliance\n");
        sb.append(super.toString());
        sb.append("--------------------------\n");
        return sb.toString();
    }
}
