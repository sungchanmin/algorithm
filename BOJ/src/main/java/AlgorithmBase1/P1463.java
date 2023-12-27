package AlgorithmBase1;

import java.util.Scanner;

public class P1463 {
    private static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new Integer[n + 1];
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        if(n <= 1) return 0;

        if (dp[n] == null) {
            // 6으로 나눠지는 경우
            if (n % 6 == 0) {
                dp[n] = Math.min(solution(n / 3), Math.min(solution(n / 2), solution(n - 1))) + 1;
            }
            // 3으로만 나눠지는 경우
            else if (n % 3 == 0) {
                dp[n] = Math.min(solution(n / 3), solution(n - 1)) + 1;
            }
            // 2로만 나눠지는 경우
            else if (n % 2 == 0) {
                dp[n] = Math.min(solution(n / 2), solution(n - 1)) + 1;
            }
            // 그 외
            else {
                dp[n] = solution(n - 1) + 1;
            }
        }

        return dp[n];
    }
}
