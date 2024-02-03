package com.week2;

import java.math.BigDecimal;

public final class CalcUtil {

    private CalcUtil() {
    }

    public static BigDecimal getDeliveryFeeByWeight(Double weight) {
        if (weight < 3.0) {
            return BigDecimal.valueOf(1000);
        }
        else if (3.0 <= weight && weight < 10.0) {
            return BigDecimal.valueOf(5000);
        }
        return BigDecimal.valueOf(10000);
    }

    public static BigDecimal calcDeliveryFeeByPrice(BigDecimal deliveryFee, BigDecimal price) {
        int priceCompareTo30000 = price.compareTo(BigDecimal.valueOf(30000));
        int priceCompareTo100000 = price.compareTo(BigDecimal.valueOf(100000));

        if (priceCompareTo30000 < 0) {
            return deliveryFee;
        }
        else if (priceCompareTo100000 < 0) {
            return deliveryFee.subtract(BigDecimal.valueOf(1000));
        }
        return BigDecimal.valueOf(0);
    }
}
