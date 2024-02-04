package com.week2;

import java.math.BigDecimal;

/**
 * getDeliveryCharge 메소드 구현 시 사용하는 공통 로직을 모아둔 Util 클래스
 */
public final class CalcUtil {

    /**
     * 인스턴스 생성 방지
     */
    private CalcUtil() {
    }

    /**
     * 무게에 따라 배송비를 return하는 메소드
     */
    public static BigDecimal getDeliveryFeeByWeight(Double weight) {
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
