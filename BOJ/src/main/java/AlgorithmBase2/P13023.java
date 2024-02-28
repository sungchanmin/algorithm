package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P13023 {
    // BOJ 13023 ABCDE
    private static int N;
    private static int M;
    private static boolean find = false;
    private static boolean[] visit;
    private static List<List<Integer>> edge = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");

        N = Integer.parseInt(strArr[0]);
        M = Integer.parseInt(strArr[1]);
        visit = new boolean[N];

        for(int i=0; i<N; i++) edge.add(new ArrayList<>());

        int nodeA, nodeB;

        for (int i = 0; i < M; i++) {
            strArr = br.readLine().split(" ");
            nodeA = Integer.parseInt(strArr[0]);
            nodeB = Integer.parseInt(strArr[1]);

            edge.get(nodeA).add(nodeB);
            edge.get(nodeB).add(nodeA);
        }

        for (int i = 0; i < N; i++) {
            visit[i] = true;
            DFS(i, 0);
            visit[i] = false;
        }

        System.out.println(find ? "1" : "0");
    }

    private static void DFS(int current, int dept) {
        if (find) return;
        if (dept >= 4) {
            find = true;
            return;
        }

        for (int node : edge.get(current)) {
            if (!visit[node]) {
                visit[node] = true;
                DFS(node, dept + 1);
                visit[node] = false;
            }
        }
    }
}
