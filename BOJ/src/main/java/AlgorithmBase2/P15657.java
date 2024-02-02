package AlgorithmBase2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15657 {
		//BOJ 15657 N과 M (8)
		private static int N, M;
		private static int[] arr;
		private static StringBuilder sb = new StringBuilder();

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] strArr = br.readLine().split(" ");

			N = Integer.parseInt(strArr[0]);
			M = Integer.parseInt(strArr[1]);
			
			arr = new int[N + 1];
			strArr = br.readLine().split(" ");
			
			for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(strArr[i - 1]);
			Arrays.sort(arr);
			
			solution(1, M, "");
			System.out.println(sb);
		}

		private static void solution(int n, int len, String str) {
			if (len == 0) {
				sb.append(str).append("\n");
				return;
			}

			for (int i = n; i <= N; i++) {
					solution(i, len - 1, str + arr[i] + " ");
			}
		}
}
