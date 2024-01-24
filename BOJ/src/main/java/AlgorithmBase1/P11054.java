package AlgorithmBase1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11054 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = toArr(br.readLine(), N);
		int[] dpInc = new int[N];
		int[] dpDec = new int[N];

		Arrays.fill(dpInc, 1);
		Arrays.fill(dpDec, 1);

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					dpInc[i] = Math.max(dpInc[i], dpInc[j] + 1);
				if (arr[N - 1 - i] > arr[N - 1 - j])
					dpDec[N - 1 - i] = Math.max(dpDec[N - 1 - i], dpDec[N - 1 - j] + 1);
			}
		}

		int answer = 0;

		for (int i = 0; i < N; i++)
			answer = Math.max(answer, dpInc[i] + dpDec[i] - 1);

		System.out.println(answer);

	}

	private static int[] toArr(String str, int N) {
		int[] arr = new int[N];
		String[] strArr = str.split(" ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(strArr[i]);

		return arr;
	}
}
