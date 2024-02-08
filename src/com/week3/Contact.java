package com.week3;

public class Contact {

    protected String name;
    protected String phoneNumber;

    public void setName(String name) {
        if(!name.isEmpty()) {
            this.name = name;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if(!phoneNumber.isEmpty()) {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
