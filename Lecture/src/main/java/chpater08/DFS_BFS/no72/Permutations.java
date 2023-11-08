package chpater08.DFS_BFS.no72;

import java.util.Scanner;

public class Permutations {
    private static int[] ch;
    private static void DFS(int m, int[]arr, String s) {
        for(int i=0; i< arr.length; i++) {
            if(ch[i] == 0) {
                String str = s;
                str += arr[i] + " ";

                if (m == 1) System.out.println(str);
                else {
                    ch[i] = 1;
                    DFS(m-1, arr, str);
                    ch[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        ch = new int[n];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        DFS(m, arr, "");
    }
}
