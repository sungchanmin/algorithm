package chapter07.RecursiveTreeGraph.no65;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RouteSearch2 {
    private static int nextVertex(int[] ch, List<ArrayList<Integer>> graph, int n) {
        int way = 0;
        if(n == graph.size() - 1) return 1;

        for(int i : graph.get(n)) {
            if(ch[i] == 0) {
                ch[i] = 1;
                way += nextVertex(ch, graph, i);
                ch[i] = 0;
            }
        }

        return way;
    }
    private static int solution(List<ArrayList<Integer>> graph) {
        int[] ch = new int[graph.size()];
        ch[1] = 1;
        return nextVertex(ch, graph, 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        System.out.println(solution(graph));
    }
}
