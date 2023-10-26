package chapter01.HandlingString.no03;

import java.util.Scanner;

public class WordInSentence {
    public static String solution(String str) {
        String answer = "";
        String[] words = str.split(" ");

        for(String s : words) {
            if(answer.length() < s.length()) answer = s;
        }

        return answer;
    }

    public static String soulution2(String str) {
        String answer = "";
        int pos;

        while((pos = str.indexOf(" ")) != -1) {
            String subStr = str.substring(0, pos);
            if(answer.length() < subStr.length()) {
                answer = subStr;
            }
            str = str.substring(pos + 1);
        }

        return str.length() > answer.length() ? str : answer;
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String str = sc.nextLine();
        System.out.println(solution(str));
        System.out.println(soulution2(str));
    }
}