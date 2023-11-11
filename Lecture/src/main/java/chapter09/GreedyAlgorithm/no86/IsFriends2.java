package chapter09.GreedyAlgorithm.no86;

import java.util.Scanner;

public class IsFriends2 {
    private static int[] relation;

    private static int find(int a) {
        if(relation[a] == a) return a;
        return relation[a] = find(relation[a]);
    }
    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if(fa != fb) relation[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        relation = new int[n+1];

        for(int i=1; i<=n; i++) relation[i] = i;

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            union(a, b);
        }

        if(find(sc.nextInt()) == find(sc.nextInt())) System.out.println("YES");
        else System.out.println("NO");
    }
}
