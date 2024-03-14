package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P7576 {
    // BOJ 7576 토마토
    private static int N;
    private static int M;
    private static int answer = 0;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int[][] arr;
    private static Queue<Position> Q = new LinkedList<>();

    private static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");

        N = Integer.parseInt(strArr[1]);
        M = Integer.parseInt(strArr[0]);
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            strArr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
                if (arr[i][j] == 1) Q.add(new Position(i, j));
            }
        }

        BFS();
        check();
        System.out.println(answer);
    }

    private static void BFS() {
        while (!Q.isEmpty()) {
            answer++;
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Position p = Q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        Q.add(new Position(nx, ny));
                    }
                }
            }
        }
    }

    private static void check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    answer = -1;
                    return;
                }
            }
        }
        answer--;
    }
}
