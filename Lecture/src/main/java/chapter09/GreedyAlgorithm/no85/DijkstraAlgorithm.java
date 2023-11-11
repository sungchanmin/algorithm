package chapter09.GreedyAlgorithm.no85;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraAlgorithm {
    private static List<List<Edge>> graph = new ArrayList<>();
    private static int[] dis;
    private static int n, m;

    private static class Edge implements Comparable<Edge> {
        int vet;
        int cost;

        public Edge(int vet, int cost) {
            this.vet = vet;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if (o.cost == this.cost) return o.vet - this.vet;
            return this.cost - o.cost;
        }
    }

    private static void solution() {
        for(int i=1; i<=n; i++) dis[i] = -1;
        dis[1] = 0;

        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.add(new Edge(1, 0));

        while(!pQ.isEmpty()) {
            Edge now = pQ.poll();

//            if(now.cost > dis[now.vet]) continue;

            for(Edge e : graph.get(now.vet)) {
                if(dis[e.vet] == -1 || dis[e.vet] > e.cost + now.cost) {
                    pQ.add(new Edge(e.vet, e.cost + now.cost));
                    dis[e.vet] = e.cost + now.cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dis = new int[n+1];

        for(int i=0; i<n+1; i++) graph.add(new ArrayList<>());

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge(b, c));
        }

        solution();

        for(int i=2; i<=n; i++) {
            if(dis[i] == -1) System.out.println(i + " : impossible");
            else System.out.println(i + " : " + dis[i]);
        }
    }
}
