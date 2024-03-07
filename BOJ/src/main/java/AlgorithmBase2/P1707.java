package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1707 {
    // BOJ 1707 이분 그래프
    private static int K;
    private static int V;
    private static int E;
    private static boolean isBipartiteGraph;
    private static boolean[] visit;
    private static int[] colors;
    private static List<List<Integer>> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            String[] strArr = br.readLine().split(" ");
            V = Integer.parseInt(strArr[0]);
            E = Integer.parseInt(strArr[1]);
            isBipartiteGraph = true;
            colors = new int[V + 1];
            visit = new boolean[V + 1];
            edges = new ArrayList<>();

            for (int j = 0; j <= V; j++) edges.add(new ArrayList<>());

            for (int j = 0; j < E; j++) {
                strArr = br.readLine().split(" ");
                int u = Integer.parseInt(strArr[0]);
                int v = Integer.parseInt(strArr[1]);

                edges.get(u).add(v);
                edges.get(v).add(u);
            }

            for (int v = 1; v <= V; v++) if (!visit[v] && isBipartiteGraph) DFS(v, 1);

            sb.append(isBipartiteGraph ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

    /**
     * 노드를 순회하며, 현재 노드와 인접한 노드의 색이 다른지 판별한다.
     * @param v 현재 노드
     * @param color 현재 노드의 색
     */
    private static void DFS(int v, int color) {
        visit[v] = true;
        colors[v] = color;

        for (int nv : edges.get(v)) {
            if (visit[nv]) {
                if (colors[nv] == color) isBipartiteGraph = false;
            } else if (isBipartiteGraph) {
                DFS(nv, color * -1);
            }
        }
    }
}