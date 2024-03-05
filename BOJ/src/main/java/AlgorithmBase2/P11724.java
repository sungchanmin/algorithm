package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11724 {
    // BOJ 11724 연결 요소의 개수
    private static int N;
    private static int M;
    private static int answer = 0;
    private static boolean[] visit;
    private static boolean[][] edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");

        N = Integer.parseInt(strArr[0]);
        M = Integer.parseInt(strArr[1]);
        visit = new boolean[N + 1];
        edge = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            strArr = br.readLine().split(" ");
            int v1 = Integer.parseInt(strArr[0]);
            int v2 = Integer.parseInt(strArr[1]);

            edge[v1][v2] = true;
            edge[v2][v1] = true;
        }

        for (int i = 1; i <= N; i++) if (DFS(i)) answer++;

        System.out.println(answer);
    }

    private static boolean DFS(int v) {
        if (!visit[v]) {
            visit[v] = true;
            for (int i = 1; i <= N; i++) if (!visit[i] && edge[v][i]) DFS(i);
            return true;
        }
        return false;
    }
}