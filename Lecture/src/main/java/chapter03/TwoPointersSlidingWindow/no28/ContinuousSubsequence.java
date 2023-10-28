package chapter03.TwoPointersSlidingWindow.no28;

import java.util.Scanner;

public class ContinuousSubsequence {
    private static int solution(int n, int m, String[] strArr) {
        int answer = 0, sum = 0, r = 0, l = 0;

        while(r < n && l < n) {
            if(sum > m) sum -= Integer.parseInt(strArr[l++]);
            else sum += Integer.parseInt(strArr[r++]);
            if(sum == m) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);
        strArr = sc.nextLine().split(" ");

        System.out.println(solution(n, m, strArr));
    }
}
