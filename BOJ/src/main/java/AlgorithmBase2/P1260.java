package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {
    // BOJ 1260 DFS와 BFS
    public static int N;
    public static int M;
    public static int V;
    public static int[][] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static Queue<Integer> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        DFS(V);
        Arrays.fill(visit, false);
        BFS(V);
        System.out.println(sb);
    }

    public static void DFS(int v) {
        visit[v] = true;
        sb.append(v).append(" ");

        for (int i = 1; i <= N; i++) {
            if (arr[v][i] == 1 && !visit[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int num) {
        Q.add(num);
        visit[num] = true;
        sb.append('\n').append(num).append(" ");

        while (!Q.isEmpty()) {
            int nv = Q.poll();

            for (int i = 1; i <= N; i++) {
                if (arr[nv][i] == 1 && !visit[i]) {
                    Q.add(i);
                    visit[i] = true;
                    sb.append(i).append(" ");
                }

            }
        }


    }
}