package com.week2;

public class Main {
    public static void main(String[] args) {
        Beauty beauty = new Beauty("Cream", 2500, 1.0);
        Grocery grocery = new Grocery("Cabbage", 25000, 5.0);
        LargeAppliance largeAppliance = new LargeAppliance("Refrigerator", 5000000, 450.0);


        System.out.println(beauty);
        System.out.println(grocery);
        System.out.println(largeAppliance);
    }
}
