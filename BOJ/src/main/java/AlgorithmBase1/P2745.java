package AlgorithmBase1;

import java.util.Scanner;

public class P2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");

        String str = strArr[0];
        int n = Integer.parseInt(strArr[1]);

        System.out.println(solution(str, n));
    }

    private static int solution(String str, int n) {
        int answer = 0;
        int place = 1;

        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) answer += place * (c - '0');
            else answer += place * (c - 'A' + 10);
            place *= n;
        }

        return answer;
    }
}
