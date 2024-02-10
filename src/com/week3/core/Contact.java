package com.week3.core;

public class Contact {

    protected String name;
    protected String phoneNumber;

    public Contact(String name, String phoneNumber) {
        if (checkArgEmpty(name) || checkArgEmpty(phoneNumber)) {
            throw new IllegalArgumentException("인자로 받은 문자열이 비어있습니다!");
        }

        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        if (!checkArgEmpty(name)) {
            this.name = name;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!checkArgEmpty(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    protected boolean checkArgEmpty(String arg) {
        return arg.isEmpty();
    }
}
