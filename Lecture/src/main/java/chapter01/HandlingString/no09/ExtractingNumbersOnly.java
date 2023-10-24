package chapter01.HandlingString.no09;

import java.util.Scanner;

public class ExtractingNumbersOnly {
    private static int solution(String str) {
        str = str.replaceAll("[^0-9]","");
        return Integer.parseInt(str);
    }

    private static int solution2(String str) {
        int answer = 0;

        for(char x : str.toCharArray()) {
            if(x >= 48 && x <= 57) answer = answer * 10 + (x-48);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.next()));
        System.out.println(solution2(sc.next()));
    }
}
