package com.week4;

import java.util.Scanner;
import java.util.Stack;

public class BracketMatching {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("확인하고자 하는 괄호 문자열을 입력해주세요.");
        String input = scanner.nextLine();

        System.out.println("괄호 검사 결과");
        System.out.println(checkBracket(input));
    }

    private static boolean checkBracket(String brackets) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(') {   // 여는 괄호의 경우는 stack에 push
                stack.push(bracket);
            }
            else if (bracket == ')') {  // 닫는 괄호의 경우 두 가지로 나뉜다.
                if (stack.isEmpty()) {  // 이미 stack이 비어있으면 닫는 괄호와 매칭되는 여는 괄호가 없으므로 false
                    return false;
                }

                stack.pop();    // 매칭되는 여는 괄호가 있으면 pop
            }
        }

        return stack.isEmpty(); // 순회 후, 남는 여는 괄호가 있으면 false, 없으면 true 이다.
    }
}
