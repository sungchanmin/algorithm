package chapter08.DFS_BFS.no75;

import java.util.Scanner;

public class FindCombinations {
    private static int n, m;
    private static void DFS(int i, int j, String str) {
        if(i == m) {
            System.out.println(str);
            return;
        }

        for(int k=j; k<=n; k++) {
            String marbles = str;
            marbles += k + " ";
            DFS(i+1, k+1 , marbles);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        DFS(0 , 1, "");
    }
}