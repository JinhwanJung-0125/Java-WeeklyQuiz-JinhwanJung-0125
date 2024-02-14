package com.week3.core;

public class BusinessContact extends Contact {

    private String company;

    public BusinessContact(String name, String phoneNumber, String company) {
        super(name, phoneNumber);

        if (super.checkArgEmpty(company)) {
            throw new IllegalArgumentException("인자로 받은 문자열이 비어있습니다!");
        }

        this.company = company;
    }

    public void setCompany(String company) {
        if(!super.checkArgEmpty(company)) {
            this.company = company;
        }
    }

    public String getCompany() {
        return this.company;
    }

    @Override
    public String toString() {
        return String.format("%s, 회사명: %s", super.toString(), company);
    }
}
