package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16929 {
    // BOJ 16929 Two Dots
    private static int N;
    private static int M;
    private static boolean find;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static char[][] arr;
    private static boolean[][] visit;
    private static Postion start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = br.readLine().split(" ");
        N = Integer.parseInt(strArr[0]);
        M = Integer.parseInt(strArr[1]);
        arr = new char[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) arr[i] = br.readLine().toCharArray();

        System.out.println(solution() ? "Yes" : "No");
    }

    private static boolean solution() {
        find = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j]) {
                    start = new Postion(i, j, arr[i][j]);
                    DFS(0, 0, i, j, 0);
                    if(find) return true;
                }
            }
        }

        return false;
    }

    private static void DFS(int bx, int by, int x, int y, int len) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == arr[start.x][start.y]) {
                if (len >= 3 && (nx != bx || ny != by) && visit[nx][ny]) {
                    find = true;
                    return;
                }
                else if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    DFS(x, y, nx, ny, len + 1);
                }
            }
        }
    }

    private static class Postion {
        int x;
        int y;
        char color;

        public Postion(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}