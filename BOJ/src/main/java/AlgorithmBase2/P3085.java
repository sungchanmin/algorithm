package AlgorithmBase2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3085 {
	// BOJ 3085 사탕 게임
	private static int answer = 1;
	private static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		// 모든 사탕에 대해 움직이는 경우를 확인한다. (브루트포스)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solution(i, j);
			}
		}

		System.out.println(answer);
	}

	private static void solution(int i, int j) {
		// 해당 사탕을 움직이지 않는 경우와
		// 상, 하, 좌, 우의 사탕과 교환하는 경우를 모두 확인한다.
		check(i, j, i, j);
		check(i, j, i - 1, j);
		check(i, j, i + 1, j);
		check(i, j, i, j - 1);
		check(i, j, i, j + 1);
	}

	private static void check(int i, int j, int x, int y) {
		// 교환 대상이 보드의 범위를 벗어나는 경우는 제외한다.
		if (x < 0 || y < 0 || x >= arr.length || y >= arr.length)
			return;

		// 사탕 교환
		swap(i, j, x, y);
		
		int cnt = 1;

		// 보드의 가로열을 탐색하며 인접한 사탕의 최대 갯수를 카운트한다.
		for (int n = 1; n < arr.length; n++) {
			if(arr[x][n-1] == arr[x][n]) {
				cnt++;
				answer = Math.max(answer, cnt);
			} else cnt = 1;
		}

		cnt = 1;
		
		// 보드의 세로열을 탐색하며 인접한 사탕의 최대 갯수를 카운트한다.
		for (int n = 1; n < arr.length; n++) {
			if(arr[n-1][y] == arr[n][y]) {
				cnt++;
				answer = Math.max(answer, cnt);
			} else cnt = 1;
		}
		
		// 교환한 사탕 원위치
		swap(i, j, x, y);
	}

	private static void swap(int i, int j, int x, int y) {
		char tmp = arr[i][j];
		arr[i][j] = arr[x][y];
		arr[x][y] = tmp;
	}
}
