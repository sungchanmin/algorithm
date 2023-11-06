package chapter07.RecursiveTreeGraph.no66;

import java.util.*;

public class GraphShortestPath {
    private static int[] solution(List<ArrayList<Integer>> graph) {
        int[] answer = new int[graph.size()];
        int[] ch = new int[graph.size()];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);

        int level = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i=0; i<len; i++) {
                int v = Q.poll();
                if(ch[v] == 0) {
                    answer[v] = level;
                    ch[v] = 1;
                    for(int nv : graph.get(v)) Q.add(nv);
                }
            }
            level++;
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        int[] answer = solution(graph);

        for(int i=2; i<answer.length; i++) System.out.println(i + ":" + answer[i]);
    }
}
