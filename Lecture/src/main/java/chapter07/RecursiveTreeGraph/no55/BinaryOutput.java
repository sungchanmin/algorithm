package chapter07.RecursiveTreeGraph.no55;

import java.util.Scanner;

public class BinaryOutput {
    private static void DFS(int n) {
        if(n == 0) return;

        DFS(n/2);
        if(n % 2 == 1) System.out.print(1);
        else System.out.print(0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DFS(sc.nextInt());
    }
}
