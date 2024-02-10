package com.week3;

import java.util.Scanner;

public final class Application {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Menu menu = new Menu(scanner);

    private Application() {
    }

    public static void run() {
        boolean flag = true;

        while (flag) {
            menu.printMenu();

            switch (scanner.next()) {
                case "1":
                    menu.executeNumberOneMenu();
                    break;
                case "2":
                    menu.executeNumberTwoMenu();
                    break;
                case "3":
                    menu.executeNumberThreeMenu();
                    break;
                case "4":
                    menu.executeNumberFourMenu();
                    break;
                case "5":
                    menu.executeNumberFiveMenu();
                    break;
                case "6":
                    System.out.println("프로그램을 종료합니다.");
                    flag = false;
                    break;
                default:
                    System.out.println("올바른 번호를 선택해주세요. (1 ~ 5)");
            }
        }

        scanner.close();
    }
}
