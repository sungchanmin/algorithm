package D3;

import java.util.Scanner;

public class P3282 {
    // 3282. 0/1 Knapsack
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int max = sc.nextInt();
            int[] weight = new int[n];
            int[] value = new int[n];

            for(int i=0; i<n; i++) {
                weight[i] = sc.nextInt();
                value[i] = sc.nextInt();
            }

            System.out.println("#" + test_case + " " + solution(n, max, weight, value));
        }
    }

    private static int solution(int len, int max, int[] weight, int[] value) {
        int[] bag = new int[max + 1];

        for(int i=0; i<len; i++) {
            for(int j=max; j>=weight[i]; j--) {
                bag[j] = Math.max(bag[j], bag[j-weight[i]] + value[i]);
            }
        }

        return bag[max];
    }
}