package chapter07.RecursiveTreeGraph.no56;

import java.util.Scanner;

public class Factorial {
    private static int DFS(int n) {
        if(n == 1) return 1;
        return (n *= DFS(n-1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(DFS(sc.nextInt()));
    }
}
