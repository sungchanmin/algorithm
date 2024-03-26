package AlgorithmBase2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1697 {
    // BOJ 1697 숨바꼭질
    private static int N;
    private static int K;
    private static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        System.out.println(BFS());
        // x + 1, x - 1, 2 * x
    }

    private static int BFS() {
        int time = 0;
        Queue<Integer> Q = new LinkedList<>();

        visit[N] = true;
        Q.add(N);

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                int p = Q.poll();
                if (p == K) return time;

                if (p - 1 >= 0 && !visit[p - 1]) {
                    visit[p - 1] = true;
                    Q.add(p - 1);
                }
                if (p + 1 <= 100000 && !visit[p + 1]) {
                    visit[p + 1] = true;
                    Q.add(p + 1);
                }
                if (p * 2 <= 100000 && !visit[p * 2]) {
                    visit[p * 2] = true;
                    Q.add(p * 2);
                }
            }

            time++;
        }

        return time;
    }
}
