package AlgorithmBase2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14500 {
	// BOJ 14500 테트로미노
	private static int answer = 0;
	private static int[][] arr;
	private static boolean[][] ch;

	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strArr = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);

		arr = new int[N][M];
		ch = new boolean[N][M];

		// 종이(값) 입력
		for (int i = 0; i < N; i++) {
			strArr = br.readLine().split(" ");

			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(strArr[j]);
		}

		// 모든 값 순회 (브루트포스)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ch[i][j] = true;
				search(i, j, 1, arr[i][j]);
				ch[i][j] = false;
			}
		}

		System.out.println(answer);
	}

	private static void search(int x, int y, int n, int sum) {
		// 테트로 미노 완성 (값 반환)
		if (n >= 4) {
			answer = Math.max(answer, sum);
			return;
		}

		// 입력 받은 좌표 값을 기준으로 상, 하, 좌, 우 탐색
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && !ch[nx][ny]) {
				ch[nx][ny] = true;
				
				// '凸' 모양 탐색을 위해 현재 블록 위치에서 한번 더 탐색
				if (n == 2) search(x, y, n + 1, sum + arr[nx][ny]);
				
				search(nx, ny, n + 1, sum + arr[nx][ny]);

				ch[nx][ny] = false;
			}
		}
	}
}
