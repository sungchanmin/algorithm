package HandlingString.no08;

import java.util.Scanner;

public class PalindromeString2 {
    private static String solution(String str) {
        String alphas = "";
        char[] chars = str.toCharArray();

        for(char c : chars) {
            if(Character.isAlphabetic(c)) alphas += c;
        }

        if(!alphas.equalsIgnoreCase(new StringBuilder(alphas).reverse().toString())) return "NO";

        return "YES";
    }
    private static String solution2(String str) {
        str = str.toUpperCase();
        str = str.replaceAll("[^A-Z]","");

        if(!str.equals(new StringBuilder(str).reverse().toString())) return "NO";

        return "YES";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextLine()));
        System.out.println(solution2(sc.nextLine()));
    }
}
