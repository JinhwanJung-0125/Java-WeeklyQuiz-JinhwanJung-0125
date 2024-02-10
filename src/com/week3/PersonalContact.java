package com.week3;

public class PersonalContact extends Contact {

    private String relationship;

    public PersonalContact(String name, String phoneNumber, String relationship) {
        super(name, phoneNumber);

        if (super.checkArgEmpty(relationship)) {
            throw new IllegalArgumentException("인자로 받은 문자열이 비어있습니다!");
        }

        this.relationship = relationship;
    }
}
