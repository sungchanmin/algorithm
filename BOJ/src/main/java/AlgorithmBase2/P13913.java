package AlgorithmBase2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13913 {
    // BOJ 13913 숨바꼭질4
    private static int N;
    private static int K;
    private static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        solution();
    }

    private static void solution() {
        if (N > K) {
            StringBuilder sb = new StringBuilder();
            for (int i = N; i >= K; i--) sb.append(i).append(" ");
            System.out.println(N - K);
            System.out.println(sb);
        } else {
            Position p = BFS();
            System.out.println(p.t);
            System.out.println(p.way);
        }
    }

    private static Position BFS() {
        Queue<Position> Q = new LinkedList<>();

        visit[N] = true;
        Q.add(new Position(N, 0, Integer.toString(N)));

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Position p = Q.poll();
                if (p.p == K) return p;

                if (p.p - 1 >= 0 && !visit[p.p - 1]) {
                    visit[p.p - 1] = true;
                    Q.add(new Position(p.p - 1, p.t + 1, p.way + " " + (p.p - 1)));
                }
                if (p.p + 1 <= 100000 && !visit[p.p + 1]) {
                    visit[p.p + 1] = true;
                    Q.add(new Position(p.p + 1, p.t + 1, p.way + " " + (p.p + 1)));
                }
                if (p.p * 2 <= 100000 && !visit[p.p * 2]) {
                    visit[p.p * 2] = true;
                    Q.add(new Position(p.p * 2, p.t + 1, p.way + " " + (p.p * 2)));
                }
            }
        }

        return null;
    }

    private static class Position {
        int p;
        int t;
        String way;

        public Position(int p, int t, String way) {
            this.p = p;
            this.t = t;
            this.way = way;
        }
    }
}
