package chapter07.RecursiveTreeGraph.no57;

import java.util.Scanner;

public class Fibonacci2 {
    private static int[] fibo;
    private static int DFS(int n) {
        if(fibo[n] != 0) return fibo[n];
        if(n <= 2) return 1;
        else return fibo[n] = DFS(n - 1) + DFS(n - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n+1];
        fibo[0] = 1;
        fibo[1] = 1;
        DFS(n);
        for(int i=1; i<=n; i++) System.out.print(fibo[i] + " ");
    }
}
