package com.week2;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Beauty beauty = new Beauty("Cream", 2500, 1.0);
        Grocery grocery = new Grocery("Cabbage", 35000, 5.0);
        LargeAppliance largeAppliance = new LargeAppliance("Refrigerator", 5000000, 450.0);


        System.out.println(beauty);
        main.printDeliveryFee(beauty, beauty.getPrice(), beauty.getWeight());
        System.out.println();

        System.out.println(grocery);
        main.printDeliveryFee(grocery, grocery.getPrice(), grocery.getWeight());
        System.out.println();

        System.out.println(largeAppliance);
        main.printDeliveryFee(largeAppliance, largeAppliance.getPrice(), largeAppliance.getWeight());
    }

    /**
     * 물건의 가격과 무게를 토대로 배송비를 계산한 뒤, print하는 메소드
     */
    public void printDeliveryFee(DeliveryChargeCalculator product, BigDecimal price, Double weight) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String deliveryFee = decimalFormat.format(product.getDeliveryCharge(weight, price));
        System.out.println(String.format("Delivery Fee: %s 원", deliveryFee));
    }
}
