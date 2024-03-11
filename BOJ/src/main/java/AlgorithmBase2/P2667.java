package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P2667 {
    // BOJ 2667 단지번호붙이기
    private static int N;
    private static int cnt = 0;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int[][] arr;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++)
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    cnt++;
                    list.add(DFS(i, j));
                }
            }
        }

        Collections.sort(list);

        for(int i : list) sb.append(i).append("\n");

        System.out.println(cnt);
        System.out.println(sb);
    }

    private static int DFS(int x, int y) {
        int houseCnt = 1;
        arr[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 1) {
                houseCnt += DFS(nx, ny);
            }
        }

        return houseCnt;
    }
}