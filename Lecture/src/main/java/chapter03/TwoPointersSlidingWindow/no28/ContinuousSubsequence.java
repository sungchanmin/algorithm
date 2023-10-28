package chapter03.TwoPointersSlidingWindow.no28;

import java.util.Scanner;

public class ContinuousSubsequence {
    private static int solution(int n, int m, String[] strArr) {
        int answer = 0, r = 0, l = 0;

        while(r < n) {
            int sum = 0;

            for(int i=l; i<=r; i++) {
                sum += Integer.parseInt(strArr[i]);
            }

            if(sum == m) {
                answer++;
                r++;
            }
            else if(sum < m) r++;
            else l++;
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
