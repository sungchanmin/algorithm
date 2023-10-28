package chapter03.TwoPointersSlidingWindow.no30;

import java.util.Scanner;

public class MaxLenghContinousSubsequence {
    private static int solution(int n, int m, String[] strArr) {
        int answer = 0, l = 0, r = 0, zero = 0, len = 0;

        while(r < n && l < n) {
            if(zero <= m) {
                answer = Math.max(answer, len);
                if(strArr[r].equals("0")) zero++;
                len++;
                r++;
            } else {
                if(strArr[l].equals("0")) zero--;
                len--;
                l++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);
        strArr = sc.nextLine().split(" ");

        System.out.println(solution(n, m, strArr));
    }
}
