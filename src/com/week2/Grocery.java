package com.week2;

public class Grocery extends Product{
    public Grocery(String name, int price, double weight) throws IllegalArgumentException {
        super(name, price, weight);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("==========================\n");
        sb.append("Grocery\n");
        sb.append(super.toString());
        sb.append("==========================");
        return sb.toString();
    }
}
