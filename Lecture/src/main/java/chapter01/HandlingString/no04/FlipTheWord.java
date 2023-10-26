package chapter01.HandlingString.no04;

import java.util.Scanner;

public class FlipTheWord {
    public static String solution(String str) {
        char[] strArr = str.toCharArray();
        str = "";

        for(int j=1; j<strArr.length + 1; j++) {
            str += strArr[strArr.length - j];
        }

        return str;
    }

    public static String solution2(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for(int i=0; i<n; i++) {
            String str = sc.nextLine();
            System.out.println(solution(str));
            System.out.println(solution2(str));
        }
    }
}