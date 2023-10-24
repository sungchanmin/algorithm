package chapter01.HandlingString.no12;

import java.util.Scanner;

public class Code {
    private static String solution(int l, int n, String str) {
        String answer = "";

        for(int i=0; i<n; i++) {
            int k = 0;
            String code = str.substring(i*l, (i+1)*l);

            for(int j=0; j<code.length(); j++) {
                if(code.charAt(j) == '#') {
                    if(j == code.length() - 1) k+= 1;
                    else k += Math.pow(2, (code.length() - j - 1));
                }
            }
            answer += (char)k;
        }

        return answer;
    }

    private static String solution2(int l, int n, String str) {
        String answer = "";

        for(int i=0; i<n; i++) {
            String code = str.substring(0, l).replace('#', '1').replace('*', '0');
            answer += (char)Integer.parseInt(code, 2);
            str = str.substring(l);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = 7;
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(l, n, str));
    }
}
