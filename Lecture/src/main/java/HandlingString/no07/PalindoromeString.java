package HandlingString.no07;

import java.util.Scanner;

public class PalindoromeString {
    private static String solution(String str) {
        str = str.toLowerCase();

        for(int i=0; i<str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length() -1 -i)) {
                return "NO";
            }
        }

        return "YES";
    }

    private static String solution2(String str) {
        if(!str.equalsIgnoreCase(new StringBuilder(str).reverse().toString())) return "NO";
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
        System.out.println(solution2(str));
    }
}
