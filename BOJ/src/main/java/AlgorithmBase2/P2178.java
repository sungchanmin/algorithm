package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P2178 {
    // BOJ 2178 미로 탐색
    private static int N;
    private static int M;
    private static int answer = 0;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int[][] arr;

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

        N = Integer.parseInt(strArr[0]);
        M = Integer.parseInt(strArr[1]);
        arr = new int[N][M];

        for (int i = 0; i < N; i++)
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        BFS();
        System.out.println(answer);
    }

    private static void BFS() {
        Queue<Position> Q = new LinkedList<>();
        Q.add(new Position(0, 0));
        arr[0][0] = 0;

        while (!Q.isEmpty()) {
            answer++;
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Position p = Q.poll();
                if (p.x == N - 1 && p.y == M - 1) return;

                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1) {
                        arr[nx][ny] = 0;
                        Q.add(new Position(nx, ny));
                    }
                }
            }
        }
    }
}
