package D2;

import java.util.Scanner;

public class P2007 {
    // 2007. 패턴 마디의 길이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.println("#" + test_case + " " + solution(sc.nextLine()));
        }
    }

    private static int solution(String str) {
        String word = "";
        for(int i=1; i<10; i++) {
            word = str.substring(0, i);
            if(wordCheck(str, word)) break;
        }

        return word.length();
    }

    private static boolean wordCheck(String str, String word) {
        int len = str.length() - (str.length() % word.length()) - word.length();

        for(int i=word.length(); i<len; i+=word.length()) {
            if(!word.equals(str.substring(i, i + word.length()))) return false;
        }
        return true;
    }
}