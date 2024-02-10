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

    @Override
    public String toString() {
        return String.format("이름: %s, 전화번호: %s, 관계: %s", name, phoneNumber, relationship);
    }
}
