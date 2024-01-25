import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// BOJ 2225 합분해
	private static final int MOD = 1_000_000_000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] dp = new int[K][N+1];
		
		// 정수 N을 1개의 정수로 표현하는 방식의 가짓수는 항상 1이다.(자기 자신을 다하는 경우)
		Arrays.fill(dp[0], 1);
		
		for(int i=1; i<K; i++) {
			// 정수 0을 K개의 정수로 표현하는 방식의 가짓수는 항상 1이다.(0을 K개 만큼 더하는 경우)
			dp[i][0] = 1;
			
			for(int j=1; j<=N; j++) {
				// 정수 N을 K개의 정수로 표현하는 방법은 2가지로 나눌 수 있다.
				// 1. 정수 N-1을 K개의 정수로 표현하는 방법에 1을 더하는 경우
				// 2. 정수 N을 K-1개의 정수로 표현하는 방법에 0을 더하는 경우
				dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD;
			}
		}
		
		System.out.println(dp[K-1][N]);
	}
}
