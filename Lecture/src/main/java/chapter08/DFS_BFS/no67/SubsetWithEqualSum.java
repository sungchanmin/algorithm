package chapter08.DFS_BFS.no67;

import java.util.Scanner;

public class SubsetWithEqualSum {
    private static int[] use;
    private static int DFS(int[] arr, int i) {
        if(i >= arr.length) return 0;
        int sum1 = 0;
        int sum2 = 0;

        if(i > 0) {
            for (int k = 0; k < arr.length; k++) {
                if (use[k] == 0) sum1 += arr[k];
                if (use[k] == 1) sum2 += arr[k];
            }
        }
        if(sum1 == sum2 && i > 0) return 1;

        use[i] = 1;
        int a = DFS(arr, i+1);
        use[i] = 0;
        int b = DFS(arr, i+1);

        return a + b;
    }
    private static String solution(int[] arr) {
        if(DFS(arr, 0) > 0) return "YES";
        return "NO";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        use = new int[n];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        System.out.println(solution(arr));
    }
}
