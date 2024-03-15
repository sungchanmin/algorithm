package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P7562 {
    // BOJ 7562 나이트의 이동
    private static int N;
    private static int SIZE;
    private static int answer;
    private static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    private static boolean[][] visit;
    private static Position destination;
    private static Queue<Position> Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            answer = 0;
            Q = new LinkedList<>();

            SIZE = Integer.parseInt(br.readLine());
            visit = new boolean[SIZE][SIZE];

            String[] strArr = br.readLine().split(" ");
            destination = new Position(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]));

            strArr = br.readLine().split(" ");
            visit[Integer.parseInt(strArr[0])][Integer.parseInt(strArr[1])] = true;
            Q.add(new Position(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1])));

            BFS();
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS() {
        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Position p = Q.poll();
                if (p.x == destination.x && p.y == destination.y) return;

                for (int j = 0; j < 8; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        Q.add(new Position(nx, ny));
                    }
                }
            }

            answer++;
        }
    }

    private static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
