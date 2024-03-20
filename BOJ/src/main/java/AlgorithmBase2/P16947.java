package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P16947 {
    // BOJ 16947 서울 지하철 2호선
    private static int N;
    private static int c = -1;
    private static int[] distance;
    private static boolean[] cycle;
    private static boolean[] visit;
    private static List<List<Integer>> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        distance = new int[N + 1];
        cycle = new boolean[N + 1];

        for (int i = 0; i <= N; i++) edges.add(new ArrayList<>());

        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            edges.get(a).add(b);
            edges.get(b).add(a);
        }
        // 순환선에 포함된 역을 하나 찾는다.
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) findCycle(i, c);
            if (c != -1) break;
        }
        // 찾은 순환선의 역을 기준으로 모든 역을 체크한다.
        visit = new boolean[N + 1];
        cycleCheck(c, c);
        // 순환선과 간선 역 사이의 거리를 구한다.
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            // 순환선에서 간선과 연결된 역
            if (cycle[i] && !visit[i] && edges.get(i).size() > 2) {
                BFS(i);
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(distance[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    /**
     * 순환선에 속하는 역을 찾는다.
     * @param v  현재 역의 번호
     * @param pv 이전 역의 번호
     * @return 순환선 여부
     */
    private static void findCycle(int v, int pv) {
        visit[v] = true;

        for (int nv : edges.get(v)) {
            // 인접한 역 중 이전 역이 아니면서 이미 방문한 경우
            if (visit[nv] && nv != pv && pv !=c) c = nv;
            else if (c == -1 && !visit[nv]) findCycle(nv, v);
        }
    }

    /**
     * 해당 역이 순환선에 속하는지 판별한다.
     * @param v  현재 역의 번호
     * @param pv 이전 역의 번호
     * @return 순환선 여부
     */
    private static boolean cycleCheck(int v, int pv) {
        visit[v] = true;
        boolean isCycle = false;

        for (int nv : edges.get(v)) {
            // 인접한 역 중 이전 역이 아니면서 이미 방문한 경우
            if (visit[nv] && nv != pv && pv != c) isCycle = true;
            if (!visit[nv]) isCycle |= cycleCheck(nv, v);
        }

        cycle[v] = isCycle;
        return isCycle;
    }

    /**
     * 간선을 탐색하며 거리를 구한다.
     * @param n 순환선 역의 번호
     */
    private static void BFS(int n) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(n);
        int len = 0;

        while (!Q.isEmpty()) {
            len++;
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                int v = Q.poll();

                for (int nv : edges.get(v)) {
                    if (!cycle[nv] && !visit[nv]) {
                        visit[nv] = true;
                        distance[nv] = len;
                        Q.add(nv);
                    }
                }
            }
        }
    }
}
