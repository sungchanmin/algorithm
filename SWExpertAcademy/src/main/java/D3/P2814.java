package D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2814 {
    // 2814. 최장 경로
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            graph = new ArrayList<>();
            visited = new boolean[n + 1];
            result = 0;

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            for (int i = 1; i <= n; i++) {
                dfs(i, 1);
            }

            System.out.println("#" + test_case + " " + result);
        }
    }

    private static void dfs(int node, int length) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, length + 1);
            }
        }

        visited[node] = false;
        result = Math.max(result, length);
    }
}