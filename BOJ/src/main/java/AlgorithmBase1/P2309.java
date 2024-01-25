package AlgorithmBase1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2309 {
	// BOJ 2309 일곱 난쟁이
	static int[] arr = new int[9];
	static int[] ch = new int[9];
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
		DFS(0, 0, 0);

	}

	private static void DFS(int n, int sum, int cnt) {
		if (sum == 100 && cnt == 7) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++)
				if (ch[i] == 1)
					sb.append(arr[i]).append("\n");

			System.out.println(sb);
			flag = true;
		}
		if (n >= arr.length || cnt > 7 || flag)
			return;
		ch[n] = 1;
		DFS(n + 1, sum + arr[n], cnt+1);
		ch[n] = 0;
		DFS(n + 1, sum, cnt);
	}
}
