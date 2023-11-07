package chpater08.DFS_BFS.no70;

import java.util.Scanner;

public class RedundantPermutations {
    private static String DFS(int n, int m, String s) {
        for(int i=1; i<=n; i++) {
            String str = s;
            str += i + " ";
            if(m == 1) System.out.println(str);
            else DFS(n, m-1, str);
        }
        return "";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        DFS(n, m, "");
    }
}
