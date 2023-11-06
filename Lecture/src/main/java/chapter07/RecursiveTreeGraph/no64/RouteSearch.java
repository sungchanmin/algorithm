package chapter07.RecursiveTreeGraph.no64;

import java.util.Scanner;

public class RouteSearch {
    private static int nextVertex(int[] ch, int[][]graph, int n) {
        int way = 0;
        if(n == graph.length-1) return 1;

        for(int i=1; i<graph.length; i++ ) {
            if(graph[n][i] == 1 && ch[i] == 0) {
                ch[i] = 1;
                way += nextVertex(ch, graph, i);
                ch[i] = 0;
            }
        }

        return way;
    }
    private static int solution(int[][] graph) {
        int answer = 0;
        int[] ch = new int[graph.length];
        ch[1] = 1;

        answer+= nextVertex(ch, graph, 1);

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];

        for(int i=0; i<m; i++) {
            graph[sc.nextInt()][sc.nextInt()] = 1;
        }

        System.out.println(solution(graph));
    }
}
