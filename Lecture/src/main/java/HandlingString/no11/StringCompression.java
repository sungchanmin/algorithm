package HandlingString.no11;

import java.util.Scanner;

public class StringCompression {
    private static String solution(String str) {
        String answer = "";

        for(int i=0; i<str.length(); i++) {
            int cnt = 1;

            while(i<str.length() - 1) {
                if(str.charAt(i) == str.charAt(i+1)) {
                    i++;
                    cnt++;
                }
                else break;
            }

            answer += str.charAt(i);
            if(cnt != 1) answer += cnt;
        }

        return answer;
    }

    private static String solution2(String str) {
        String answer = "";
        str += " ";
        int cnt = 1;

        for(int i=0; i<str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) cnt++;
            else {
                answer += str.charAt(i);
                if(cnt > 1) {
                    answer += cnt;
                    cnt = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution2(sc.next()));
    }
}
