package com.week3;

import java.util.Scanner;

public class Menu {

    private final AddressBook addressBook = new AddressBook();
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    void printMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append("===========================\n");
        sb.append("1. 비즈니스 연락처 추가\n");
        sb.append("2. 개인 연락처 추가\n");
        sb.append("3. 연락처 출력\n");
        sb.append("4. 연락처 검색\n");
        sb.append("5. 연락처 삭제\n");
        sb.append("6. 종료\n");
        sb.append("===========================\n");
        sb.append("메뉴를 선택해주세요: ");

        System.out.print(sb);
    }

    void executeNumberOneMenu() {
        System.out.print("이름을 입력하세요: ");
        String name = inputCommend();

        System.out.print("전화번호를 입력하세요: ");
        String phoneNumber = inputCommend();

        System.out.print("회사명을 입력하세요: ");
        String company = inputCommend();

        try {
            addressBook.addBusinessContact(name, phoneNumber, company);
        } catch (IllegalArgumentException e) {
            System.out.println("이름, 전화번호, 회사명을 반드시 입력해주세요.");
        }
    }

    void executeNumberTwoMenu() {
        System.out.print("이름을 입력하세요: ");
        String name = inputCommend();

        System.out.print("전화번호를 입력하세요: ");
        String phoneNumber = inputCommend();

        System.out.print("관계를 입력하세요: ");
        String relationship = inputCommend();

        try {
            addressBook.addPersonalContact(name, phoneNumber, relationship);
        } catch (IllegalArgumentException e) {
            System.out.println("이름, 전화번호, 관계를 반드시 입력해주세요.");
        }
    }

    void executeNumberThreeMenu() {
        addressBook.displayContacts();
    }

    void executeNumberFourMenu() {
        System.out.print("검색할 이름을 입력하세요: ");
        String name = inputCommend();

        addressBook.searchContact(name);
    }

    void executeNumberFiveMenu() {
        System.out.print("삭제할 연락처의 이름을 입력하세요: ");
        String name = inputCommend();

        addressBook.deleteContact(name);
    }

    /**
     * 사용자의 입력 값을 콘솔을 통해 받는 메소드. <br>
     * 사용자로부터 빈값이 아닌 값을 입력 받을 때까지 반복한다.
     */
    private String inputCommend() {
        String input = "";
        while (input.isEmpty() || input.equals(" ")) {
            input = scanner.nextLine();
        }

        return input;
    }
}
