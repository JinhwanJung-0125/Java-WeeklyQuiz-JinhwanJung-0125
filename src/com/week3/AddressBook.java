package com.week3;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addBusinessContact(String name, String phoneNumber, String company) {
        this.contacts.add(new BusinessContact(name, phoneNumber, company));
    }

    public void addPersonalContact(String name, String phoneNumber, String relationship) {
        this.contacts.add(new PersonalContact(name, phoneNumber, relationship));
    }

    public void deleteContact(String name) {
        Contact targetContact = searchContactByName(name);

        if (targetContact == null) {
            System.out.println("연락처를 찾을 수 없습니다.");
            return;
        }
        this.contacts.remove(targetContact);

        System.out.printf("%s 연락처가 삭제되었습니다.%n", name);
    }

    public void displayContacts() {
        if (this.contacts.isEmpty()) {
            System.out.println("연락처가 비어있습니다.");
            return;
        }

        for (Contact contact : this.contacts) {
            System.out.println(contact);
        }
    }

    public void searchContact(String name) {
        Contact contact = searchContactByName(name);

        if (contact == null) {
            System.out.println("연락처를 찾을 수 없습니다.");
            return;
        }
        System.out.println(contact);
    }

    private Contact searchContactByName(String name) {
        for (Contact contact : this.contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }

        return null;
    }
}
