package AlgorithmBase2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P6064 {
	// BOJ 6064 카잉 달력
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int P = Integer.parseInt(br.readLine());

		for (int i = 0; i < P; i++) {
			String[] strArr = br.readLine().split(" ");

			int N = Integer.parseInt(strArr[0]);
			int M = Integer.parseInt(strArr[1]);
			int x = Integer.parseInt(strArr[2]);
			int y = Integer.parseInt(strArr[3]);

			sb.append(solution(N, M, x, y)).append("\n");
		}

		System.out.println(sb);
	}

	private static int solution(int N, int M, int x, int y) {
		// 달력의 마지막 해는 N과 M의 최소공배수
		int lcm = lcm(N, M);


		// x가 될 수 있는 모든 해를 찾는다.(마지막 해 이전의 범위)
		for (int i = x; i <= lcm; i += N) {
			// i - y : 찾은 해에서 y만큼 빼준 해는 y가 0이되는 해이다.
			// 즉, M으로 나누어 떨어지는 해를 의미한다.
			if ((i - y) % M == 0) return i;
		}

		return -1;
	}

	private static int gcd(int a, int b) {
		int r;

		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}

		return a;
	}
	

	private static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}
