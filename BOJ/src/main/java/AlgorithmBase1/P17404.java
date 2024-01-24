package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = Integer.MAX_VALUE;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		
		for (int i = 0; i < N; i++)
			arr[i] = toArr(br.readLine());
		
		// 처음 집을 빨강, 초록, 파랑 중 한 가지 색을 칠하는 경우로 나누어 모두 확인한다.
		for (int n = 0; n < 3; n++) {
			int[][] dp = new int[N][3];
			
			// 처음 경우의 수를 모두 한 가지(n번째)색으로 지정한다.
			dp[0][0] = arr[0][n];
			dp[0][1] = arr[0][n];
			dp[0][2] = arr[0][n];
			
			// 다음 집부터 앞 집과 색이 겹치지 않으면서, 최소값이 되는 경우를 선택한다.
			for (int i = 1; i < N; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
				
				// 단, 두 번째 집을 칠하는 경우에서 첫 번째 집에 지정한 색과 겹치는 경우의 수를 배제한다. (최대값 부여)
				if(i==1) dp[i][n] = Integer.MAX_VALUE;
			}
			
			// 마지막 집을 고르는 경우 중 최소 값을 찾는다.
			for (int i = 0; i < 3; i++) {
				// 단, 첫 번째 집에 지정한 색을 고른 경우를 배제한다. (조건문 : i != n)
				if (i != n) answer = Math.min(answer, dp[N - 1][i]);
			}
		}
	
		System.out.println(answer);

	}

	private static int[] toArr(String str) {
		String[] strArr = str.split(" ");
		int[] arr = new int[strArr.length];

		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(strArr[i]);

		return arr;
	}
}
