package AlgorithmBase2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15656 {
		//BOJ 15656 N과 M (7)
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
			
			solution(M, "");
			System.out.println(sb);
		}

		private static void solution( int len, String str) {
			if (len == 0) {
				sb.append(str).append("\n");
				return;
			}

			for (int i = 1; i <= N; i++) {
					solution(len - 1, str + arr[i] + " ");
			}
		}
}