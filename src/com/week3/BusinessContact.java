package com.week3;

public class BusinessContact extends Contact {

    private String company;

    public BusinessContact(String name, String phoneNumber, String company) {
        super(name, phoneNumber);

        if (super.checkArgEmpty(company)) {
            throw new IllegalArgumentException("인자로 받은 문자열이 비어있습니다!");
        }

        this.company = company;
    }

    @Override
    public String toString() {
        return String.format("이름: %s, 전화번호: %s, 회사명: %s", name, phoneNumber, company);
    }
}
