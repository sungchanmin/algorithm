package chapter09.GreedyAlgorithm.no87;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Wonderland_Kruskal {
    private static List<Edge> list = new ArrayList<>();
    private static int[] arr;

    private static class Edge implements Comparable<Edge> {
        int vet1, vet2, cost;

        public Edge(int vet1, int vet2, int cost) {
            this.vet1 = vet1;
            this.vet2 = vet2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    private static int find(int a) {
        if(arr[a] == a) return a;
        return arr[a] = find(arr[a]);
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if(fa != fb) arr[fa] = fb;
    }

    private static int solution() {
        int answer = 0;

        Collections.sort(list);

        for(Edge e : list) {
            if(find(e.vet1) != find(e.vet2)) {
                union(e.vet1, e.vet2);
                answer += e.cost;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n+1];

        for(int i=0; i<=n; i++) arr[i] = i;

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list.add(new Edge(a, b, c));
        }

        System.out.println(solution());
    }
}
