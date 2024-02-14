package com.week3.cli;

import com.week3.core.AddressBook;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {

    private final AddressBook addressBook = new AddressBook();
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * 메뉴 선택 UI 출력 메소드
     */
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

    /**
     * 1번 메뉴 비즈니스 연락처 추가 UI 출력 및 실행 메소드
     */
    void addBusinessContactMenu() {
        System.out.print("이름을 입력하세요: ");
        String name = inputCommend();

        System.out.print("전화번호를 입력하세요: ");
        String phoneNumber = inputPhoneNumber();

        System.out.print("회사명을 입력하세요: ");
        String company = inputCommend();

        try {
            addressBook.addBusinessContact(name, phoneNumber, company);
        } catch (IllegalArgumentException e) {
            System.out.println("이름, 전화번호, 회사명을 반드시 입력해주세요.");
        }
    }

    /**
     * 2번 메뉴 개인 연락처 추가 UI 출력 및 실행 메소드
     */
    void addPersonalContactMenu() {
        System.out.print("이름을 입력하세요: ");
        String name = inputCommend();

        System.out.print("전화번호를 입력하세요: ");
        String phoneNumber = inputPhoneNumber();

        System.out.print("관계를 입력하세요: ");
        String relationship = inputCommend();

        try {
            addressBook.addPersonalContact(name, phoneNumber, relationship);
        } catch (IllegalArgumentException e) {
            System.out.println("이름, 전화번호, 관계를 반드시 입력해주세요.");
        }
    }

    /**
     * 3번 메뉴 연락처 출력 메소드
     */
    void displayContactsMenu() {
        addressBook.displayContacts();
    }

    /**
     * 4번 메뉴 연락처 검색 UI 출력 및 실행 메소드
     */
    void searchContactMenu() {
        System.out.print("검색할 이름을 입력하세요: ");
        String name = inputCommend();

        addressBook.searchContact(name);
    }

    /**
     * 5번 메뉴 연락처 삭제 UI 출력 및 실행 메소드
     */
    void deleteContactMenu() {
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
        while (validateInput(input)) {
            input = scanner.nextLine();
        }

        return input;
    }

    /**
     * 입력받은 input이 빈값인지 확인하는 메소드
     */
    private boolean validateInput(String input) {
        return input.replaceAll(" ", "").isEmpty();
    }

    /**
     * 사용자가 입력한 전화번호 값을 콘솔을 통해 받는 메소드. <br>
     * 사용자로부터 올바른 전화번호를 입력 받을 때까지 반복한다.
     */
    private String inputPhoneNumber() {
        String phoneNumber;
        while (true) {
            phoneNumber = scanner.nextLine();

            if (validatePhoneNumber(phoneNumber)) {
                break;
            }
            System.out.println("올바른 전화번호 형식이 아닙니다. ([XX 혹은 XXX]-XXXX-XXXX)");
        }

        return phoneNumber;
    }

    /**
     * 입력받은 값이 올바른 전화번호 형식인지 확인하는 메소드
     */
    private boolean validatePhoneNumber(String phoneNumber) {
        return Pattern.matches("[0-9]{2,3}-[0-9]{4}-[0-9]{4}", phoneNumber);
    }
}
