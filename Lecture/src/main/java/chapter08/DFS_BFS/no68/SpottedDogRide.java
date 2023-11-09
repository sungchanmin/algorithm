package chapter08.DFS_BFS.no68;

import java.util.Scanner;

public class SpottedDogRide {
    private static int m, w = 0;
    private static int[] ch;
    private static void DFS(int n, int[] arr) {
        if(n >= arr.length) return;
        int sum = 0;

        for(int i=0; i<arr.length; i++) {
            if(ch[i] == 0) {
                if(sum + arr[i] > m) break;
                sum+= arr[i];
            }
        }

        w = Math.max(w, sum);

        ch[n] = 1;
        DFS(n+1, arr);
        ch[n] = 0;
        DFS(n+1, arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        ch = new int[n];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        DFS(0, arr);
        System.out.println(w);
    }
}
