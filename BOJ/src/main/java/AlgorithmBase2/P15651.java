package AlgorithmBase2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15651 {
		//BOJ 15651 N과 M (3)
		private static int N, M;
		private static StringBuilder sb = new StringBuilder();

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] strArr = br.readLine().split(" ");

			N = Integer.parseInt(strArr[0]);
			M = Integer.parseInt(strArr[1]);

			solution(M, "");
			System.out.println(sb);
		}

		private static void solution(int len, String str) {
			if (len == 0) {
				sb.append(str).append("\n");
				return;
			}

			for (int i = 1; i <= N; i++) {
				solution(len - 1, str + i + " ");
			}
		}
}
