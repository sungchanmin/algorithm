package chapter09.GreedyAlgorithm.no86;

import java.util.*;

public class IsFriends {
    private static List<List<Integer>> relation = new ArrayList<>();
    private static int[] ch;
    private static int n, m;

    private static String solution(int a, int b) {
        Queue<Integer> Q = new LinkedList();
        Q.add(a);

        while(!Q.isEmpty()) {
            int man = Q.poll();
            ch[man] = 1;

            for(int x : relation.get(man)) {
                if(x == b) return "YES";
                if(ch[x] == 0) Q.add(x);
            }
        }

        return "NO";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n+1];

        for(int i=0; i<=n; i++) relation.add(new ArrayList<>());

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            relation.get(a).add(b);
            relation.get(b).add(a);
        }

        System.out.println(solution(sc.nextInt(), sc.nextInt()));
    }
}
