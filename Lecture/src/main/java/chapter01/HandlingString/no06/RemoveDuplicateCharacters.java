package chapter01.HandlingString.no06;

import java.util.Scanner;

public class RemoveDuplicateCharacters {
    public static String solution(String str) {
        String answer = "";
        char[] chars = str.toCharArray();

        for(int i=0; i<chars.length-1; i++) {
            if (Character.isLowerCase(chars[i])) {
                for (int j = i + 1; j < chars.length; j++) {
                    if(chars[i] == chars[j]) {
                        chars[j] = Character.toUpperCase(chars[j]);
                    }
                }
            }
        }

        for(char c : chars) {
            if(Character.isLowerCase(c)) {
                answer += c;
            }
        }

        return  answer;
    }

    public static String solution2(String str) {
        String answer = "";
        char[] chars = str.toCharArray();
        for(int i=0; i<chars.length; i++) {
            if(i == str.indexOf(chars[i])) answer += chars[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
        System.out.println(solution2(str));
    }
}