package com.week2.dailyquiz0205;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class Cart {

    private List<Product> products;
    private final static BigDecimal LOWER_PRICE = BigDecimal.valueOf(30000);
    private final static BigDecimal UPPER_PRICE = BigDecimal.valueOf(100000);

    public Cart(Product[] products) {
        this.products = List.of(products);
    }

    /**
     * 총 배송비를 구하는 메소드
     */
    public int calculateDeliveryCharge() {
        BigDecimal totalPrice = getTotalPrice();
        Double totalWeight = getTotalWeight();
        BigDecimal deliveryFee = getDeliveryFeeByWeight(totalWeight);
        return calcDeliveryFeeByPrice(deliveryFee, totalPrice).intValue();
    }

    /**
     * 물건의 총 가격과 총 무게, 배송비를 포함한 영수증
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("===========================\n");
        for (Product product : this.products) {
            sb.append(product);
        }

        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        BigDecimal totalPrice = getTotalPrice();
        Double totalWeight = getTotalWeight();
        int deliveryFee = calculateDeliveryCharge();

        sb.append("\n----------RESULT----------\n");
        sb.append(String.format("Total Price: %s 원\n", decimalFormat.format(totalPrice)));
        sb.append(String.format("Total Weight: %s KG\n", totalWeight.toString()));
        sb.append(String.format("Delivery Fee: %s 원", decimalFormat.format(deliveryFee)));
        sb.append("\n--------------------------\n");

        sb.append("===========================");

        return sb.toString();
    }

    /**
     * 물건들의 총 가격을 계산하는 메소드
     */
    private BigDecimal getTotalPrice() {
        BigDecimal retVal = BigDecimal.ZERO;
        for (Product product : this.products) {
            BigDecimal productPrice = product.getPrice().subtract(product.getDiscountAmount());
            retVal = productPrice.add(retVal);
        }
        return retVal;
    }

    /**
     * 물건들의 총 무게를 계산하는 메소드
     */
    private Double getTotalWeight() {
        Double retVal = 0.0;
        for (Product product : this.products) {
            retVal += product.getWeight();
        }
        return retVal;
    }

    /**
     * 무게에 따라 배송비를 return하는 메소드<br> 3kg 미만은 배송비 1,000원<br> 3Kg 이상 10Kg 미만은 배송비 5,000원<br> 10Kg 이상은
     * 배송비 10,000원
     */
    private BigDecimal getDeliveryFeeByWeight(Double weight) {
        if (weight < 3.0) {
            return BigDecimal.valueOf(1000);
        }
        else if (3.0 <= weight && weight < 10.0) {
            return BigDecimal.valueOf(5000);
        }
        return BigDecimal.valueOf(10000);
    }

    /**
     * 가격에 따라 배송비를 최종적으로 결정한 뒤 return하는 메소드
     */
    private BigDecimal calcDeliveryFeeByPrice(BigDecimal deliveryFee, BigDecimal price) {
        if (price.compareTo(LOWER_PRICE) < 0) {
            return deliveryFee;
        }
        else if (price.compareTo(UPPER_PRICE) < 0) {
            return deliveryFee.subtract(BigDecimal.valueOf(1000));
        }
        return BigDecimal.ZERO;
    }
}
