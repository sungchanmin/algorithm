package chpater08.DFS_BFS.no73;

import java.util.Scanner;

public class NumberOfCominations {
    private static int C[][];

    private static int DFS(int n, int r) {
        if(n == r) return 1;
        if(r == 1) return n;
        if(C[n][r] == 0) C[n][r] = DFS(n-1, r-1) + DFS(n-1 , r);
        return C[n][r];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        C = new int[n+1][r+1];

        System.out.println(DFS(n , r));

    }
}
