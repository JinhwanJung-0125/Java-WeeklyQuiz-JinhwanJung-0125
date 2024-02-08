package com.week3;

public class Contact {

    protected String name;
    protected String phoneNumber;

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

    private boolean checkArgEmpty(String arg) {
        return arg.isEmpty();
    }
}
