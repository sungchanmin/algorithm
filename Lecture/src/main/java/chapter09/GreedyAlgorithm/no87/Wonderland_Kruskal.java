package chapter09.GreedyAlgorithm.no87;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Wonderland_Kruskal {
    // 1. 1번에서 시작해서 가장 비용이 적은 정점으로 이동
    // 2. 나머지 경로는 삭제, 방문한 정점 체크
    // 3. 이동한 정점에서 비용이 가장 적은 정점으로 이동
    // 4. 2~3번 반복
    // 5. 방문한 적 없는 정점의 연결 추가
    private static List<List<Edge>> graph = new ArrayList<>();
    private static int[] ch;
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
            if(this.cost == o.cost) return this.vet - o.vet;
            return this.cost - o.cost;
        }
    }

    private static int solution() {
        int answer = 0;
        int max = 0;


        PriorityQueue<Edge> pQ = new PriorityQueue<>();
//        pQ.add(new Edge(1, 0));
//
//        while(!pQ.isEmpty()) {
//            Edge now = pQ.poll();
//            Edge min = null;
//            for(Edge e : graph.get(now.vet)) {
//                if(ch[e.vet] == 0) {
//                    if(min == null) min = e;
//                    else min = min.cost > e.cost ? e : min;
//                }
//            }
//
//            if(min != null) {
//                ch[min.vet] = 1;
//                pQ.add(min);
//                max = Math.max(max, min.cost);
//                answer += min.cost;
//
//                System.out.println(now.vet + "\t->\t" + min.vet + "\t\tcost : " + min.cost + ", sum : " + answer);
//            }
//        }

        for(int i=1; i<=n; i++) {
            int cnt = 0;
            if (ch[i] == 0) {
                ch[i] = 1;
                pQ.add(new Edge(i, 0));

                while(!pQ.isEmpty()) {
                    Edge now = pQ.poll();
                    Edge min = null;

                    for(Edge e : graph.get(now.vet)) {
                        if(min == null) min = e;
                        else min = min.cost > e.cost ? e : min;
                    }

                    if(min != null) {
                        if(ch[min.vet] == 0) {
                            ch[min.vet] = 1;
                            pQ.add(min);
                            answer += min.cost;
                            cnt++;
                        } else if(cnt == 0) answer += min.cost;

                        System.out.println(now.vet + "\t->\t" + min.vet + "\t\tcost : " + min.cost + ", sum : " + answer);
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n+1];

        for(int i=0; i<n+1; i++) graph.add(new ArrayList<>());

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
