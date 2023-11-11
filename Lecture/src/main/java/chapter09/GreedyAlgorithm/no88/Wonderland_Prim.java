package chapter09.GreedyAlgorithm.no88;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Wonderland_Prim {
    private static List<List<Edge>> graph = new ArrayList<>();
    private static int[] ch;

    private static class Edge implements Comparable<Edge> {
        int vet, cost;

        public Edge(int vet, int cost) {
            this.vet = vet;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    private static int solution() {
        int answer = 0;

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(1, 0));

        while(!pQ.isEmpty()) {
            Edge now = pQ.poll();

            if(ch[now.vet] == 0) {
                ch[now.vet] = 1;
                answer += now.cost;

                for(Edge e : graph.get(now.vet)) {
                    pQ.add(e);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ch = new int[n+1];

        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        System.out.println(solution());
    }
}
