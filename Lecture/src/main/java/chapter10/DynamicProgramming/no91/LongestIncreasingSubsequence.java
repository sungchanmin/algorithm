package chapter10.DynamicProgramming.no91;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    private static int solution(int[] arr) {
       int[] dy = new int[arr.length];
       dy[0] = 1;

       for(int i=1; i<arr.length; i++) {
           int cnt = 1;
           for(int j=0; j<i; j++) {
               if(arr[i] > arr[j]) cnt = Math.max(cnt, dy[j] + 1);
           }
           dy[i] = cnt;
       }

       return Arrays.stream(dy).max().getAsInt();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        System.out.println(solution(arr));
    }
}
