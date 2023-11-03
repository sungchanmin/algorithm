package chapter07.RecursiveTreeGraph.no54;

import java.util.Scanner;

public class Recursive {
    private static void DFS(int n) {
        if(n==0) return;
        else {
            System.out.print(n + " ");
            DFS(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DFS(sc.nextInt());
    }
}
