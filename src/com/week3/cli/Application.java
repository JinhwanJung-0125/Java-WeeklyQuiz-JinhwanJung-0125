package com.week3.cli;

import java.util.Scanner;

public final class Application {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Menu menu = new Menu(scanner);

    private Application() {
    }

    public static void run() {
        boolean flag = true; // while loop 제어 flag

        while (flag) {
            menu.printMenu();

            switch (scanner.next()) {
                case "1":
                    menu.addBusinessContactMenu();
                    break;
                case "2":
                    menu.addPersonalContactMenu();
                    break;
                case "3":
                    menu.displayContactsMenu();
                    break;
                case "4":
                    menu.searchContactMenu();
                    break;
                case "5":
                    menu.deleteContactMenu();
                    break;
                case "6":
                    System.out.println("프로그램을 종료합니다.");
                    flag = false;
                    break;
                default:
                    System.out.println("올바른 번호를 선택해주세요. (1 ~ 6)");
            }
        }

        scanner.close();
    }
}
