package com.week3.core;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    /**
     * 1번 메뉴 비즈니스 연락처 추가 메소드
     */
    public void addBusinessContact(String name, String phoneNumber, String company) {
        this.contacts.add(new BusinessContact(name, phoneNumber, company));
    }

    /**
     * 2번 메뉴 개인 연락처 추가 메소드
     */
    public void addPersonalContact(String name, String phoneNumber, String relationship) {
        this.contacts.add(new PersonalContact(name, phoneNumber, relationship));
    }

    /**
     * 3번 메뉴 연락처 출력 메소드 <br>
     * 연락처가 비어있을 경우 "연락처가 비어있습니다." 메시지 출력
     */
    public void displayContacts() {
        if (this.contacts.isEmpty()) {
            System.out.println("연락처가 비어있습니다.");
            return;
        }

        for (Contact contact : this.contacts) {
            System.out.println(contact);
        }
    }

    /**
     * 4번 메뉴 연락처 찾기 메소드 <br>
     * 연락처가 없을 경우 "연락처를 찾을 수 없습니다." 메시지 출력
     */
    public void searchContact(String name) {
        Contact contact = searchContactByName(name);

        if (contact == null) {
            System.out.println("연락처를 찾을 수 없습니다.");
            return;
        }
        System.out.println(contact);
    }

    /**
     * 5번 메뉴 연락처 삭제 메소드 <br>
     * 연락처가 없을 경우 "연락처를 찾을 수 없습니다." 메시지 출력
     */
    public void deleteContact(String name) {
        Contact targetContact = searchContactByName(name);

        if (targetContact == null) {
            System.out.println("연락처를 찾을 수 없습니다.");
            return;
        }
        this.contacts.remove(targetContact);

        System.out.printf("%s 연락처가 삭제되었습니다.%n", name);
    }

    /**
     * 주어진 이름과 일치하는 연락처를 return 한다. <br>
     * 만약 없을 경우, null을 return 한다.
     */
    private Contact searchContactByName(String name) {
        for (Contact contact : this.contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }

        return null;
    }
}
