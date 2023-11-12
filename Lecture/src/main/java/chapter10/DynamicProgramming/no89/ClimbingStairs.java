package chapter10.DynamicProgramming.no89;

import java.util.Scanner;

public class ClimbingStairs {
    private static int solution(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;

        for(int i=3; i<=n; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        return arr[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
