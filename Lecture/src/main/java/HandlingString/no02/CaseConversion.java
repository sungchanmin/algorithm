package HandlingString.no02;

import java.util.Scanner;

public class CaseConversion {
    public static void solution2 (String str) {
        String answer = "";
        for(char c : str.toCharArray()) {
            answer += c >= 97 && c <=122 ? (char)(c - 32) : (char)(c + 32);
        }

        System.out.println(answer);
    }
    public static void solution (String str) {
        String answer = "";

        for(char c : str.toCharArray()) {
            answer += Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
        }

        System.out.println(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        solution(str);
        solution2(str);
    }
}
