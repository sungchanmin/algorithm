package chapter07.RecursiveTreeGraph.no55;

import java.util.Scanner;

public class BinaryOutput {
    private static void DFS(int n) {
        if(n == 0) return;

        DFS(n/2);
        System.out.print(n%2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DFS(sc.nextInt());
    }
}
