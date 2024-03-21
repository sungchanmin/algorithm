package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P16964 {
    // BOJ 16964 DFS 스페셜 저지
    private static int N;
    private static int index = 0;
    private static int[] arr;
    private static boolean[] visit;
    private static List<List<Integer>> edges = new ArrayList<>();

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

        DFS(1);
        System.out.println(arr[0] == 1 && isVisitAll() ? 1 : 0);
    }

    private static void DFS(int v) {
        index++;
        visit[v] = true;

        HashSet<Integer> edgeSet = getEdges(v);

        while (true) {
            if (index < N && !visit[arr[index]] && edgeSet.contains(arr[index])) DFS(arr[index]);
            else return;
        }
    }

    private static HashSet<Integer> getEdges(int v) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.addAll(edges.get(v));
        return hashSet;
    }

    private static boolean isVisitAll() {
        for (int i = 1; i <= N; i++) if (!visit[i]) return false;
        return true;
    }
}
