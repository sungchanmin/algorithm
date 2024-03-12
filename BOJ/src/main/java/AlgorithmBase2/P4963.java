package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P4963 {
    // BOJ 4963 섬의 개수
    private static int w;
    private static int h;
    private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] strArr = br.readLine().split(" ");
        h = Integer.parseInt(strArr[0]);
        w = Integer.parseInt(strArr[1]);

        while (w != 0 && h != 0) {
            arr = new int[w][h];

            for (int i = 0; i < w; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            sb.append(solution()).append("\n");

            strArr = br.readLine().split(" ");
            h = Integer.parseInt(strArr[0]);
            w = Integer.parseInt(strArr[1]);
        }

        System.out.println(sb);
    }

    private static int solution() {
        int cnt = 0;

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (arr[i][j] == 1) {
                    cnt++;
                    DFS(i, j);
                }
            }
        }

        return cnt;
    }

    private static void DFS(int x, int y) {
        arr[x][y] = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < w && ny >= 0 && ny < h && arr[nx][ny] == 1) DFS(nx, ny);
        }
    }
}