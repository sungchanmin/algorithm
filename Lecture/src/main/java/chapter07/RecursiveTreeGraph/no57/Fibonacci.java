package chapter07.RecursiveTreeGraph.no57;

import java.util.Scanner;

public class Fibonacci {
    private static int DFS(int n) {
        if(n <= 2) return 1;
        else return DFS(n - 1) + DFS(n - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<n; i++) System.out.print(DFS(i) + " ");
    }
}
