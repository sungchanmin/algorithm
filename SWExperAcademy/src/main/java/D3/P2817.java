package D3;

import java.util.Scanner;

public class P2817 {
    // 2817. 부분 수열의 합
    private static int n, m;
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new int[n];

            for(int i=0; i<n; i++) arr[i] = sc.nextInt();

            System.out.println("#" + test_case + " " + DFS(0, 0));
        }
    }

    private static int DFS(int i, int sum) {
        if(i == n) {
            if (sum == m) return 1;
            else return 0;
        }
        sum += arr[i];
        int a = DFS(i + 1, sum);

        sum -= arr[i];
        int b = DFS(i + 1, sum);

        return a + b;
    }
}
