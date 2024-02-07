package AlgorithmBase2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9095 {
	// BOJ 9095 1, 2, 3 더하기
	private static final int SIZE = 11;
	private static int[] dp = new int[SIZE + 1];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		solution();
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void solution() {
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i=4; i<=SIZE; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}
	}
}
