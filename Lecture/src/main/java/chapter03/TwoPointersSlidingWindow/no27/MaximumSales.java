package chapter03.TwoPointersSlidingWindow.no27;

import java.util.Scanner;

public class MaximumSales {
    private static int solution(int n, int m, String[] strArr) {
        int answer = 0, sum = 0;

        for(int i=0; i<m; i++) {
            sum += Integer.parseInt(strArr[i]);
        }

        answer = sum;

        for(int i=m; i< n; i++) {
            sum -= Integer.parseInt(strArr[i - m]);
            sum += Integer.parseInt(strArr[i]);
            answer = Math.max(sum, answer);
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
