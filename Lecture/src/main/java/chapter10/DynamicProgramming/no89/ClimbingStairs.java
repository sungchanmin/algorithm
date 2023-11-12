package chapter10.DynamicProgramming.no89;

import java.util.Scanner;

public class ClimbingStairs {
    private static int solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for(int i=2; i<n; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        return arr[n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
