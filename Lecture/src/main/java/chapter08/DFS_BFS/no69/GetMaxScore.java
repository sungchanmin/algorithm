package chapter08.DFS_BFS.no69;

import java.util.*;

public class GetMaxScore {
    private static int m, maxScore = 0;
    private static int[] ch;
    private static class P {
        int score;
        int time;

        public P(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
    private static void DFS(int n,  List<P> list) {
        if(n >= list.size()) return;
        int sum = 0;
        int time = 0;

        for(int i=0; i<list.size(); i++) {
            if(ch[i] == 0) {
                P p = list.get(i);
                if(time + p.time > m) break;
                time+= p.time;
                sum+= p.score;
            }
        }

        maxScore = Math.max(maxScore, sum);

        ch[n] = 1;
        DFS(n+1, list);
        ch[n] = 0;
        DFS(n+1, list);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        List<P> list = new ArrayList<>();
        ch = new int[n];

        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new P(a, b));
        }
        DFS(0, list);
        System.out.println(maxScore);
    }
}
