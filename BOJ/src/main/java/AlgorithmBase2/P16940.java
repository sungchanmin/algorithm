package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16940 {
    // BOJ 16940 BFS 스페셜 저지
    private static int N;
    private static int[] arr;
    private static List<List<Integer>> edges = new ArrayList<>();
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) edges.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            String[] strArr = br.readLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            edges.get(a).add(b);
            edges.get(b).add(a);
        }

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(BFS());
    }

    private static int BFS() {
        int index = 0;
        Queue<Integer> Q = new LinkedList<>();

        // 시작 노드가 1이 아닌 경우 종료
        if(arr[index] != 1) return 0;
        visit[arr[index]] = true;
        Q.add(arr[index]);
        index++;

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                int v = Q.poll();
                int cnt = 0;
                
                // 현재 노드에서 갈 수 있는 정점을 방문하고, 카운트
                for (int nv : edges.get(v)) {
                    if(!visit[nv]) {
                        visit[nv] = true;
                        cnt++;
                    }
                }
                
                // 주어진 BFS 방문 순서대로 실제로 방문 할 수 있는지 체크
                for(int j = index; j < index + cnt; j++) {
                    if(!visit[arr[j]]) return 0;
                    Q.add(arr[j]);
                }

                index += cnt;
            }
        }

        return 1;
    }
}