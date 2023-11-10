package chapter09.GreedyAlgorithm.no83;

import java.util.Arrays;
import java.util.Scanner;

public class Wedding2 {
    private static int solution(int[] start, int[] end) {
        int[] arr = new int[72];

        for(int i=0; i<start.length; i++) {
            for(int j=start[i]; j<end[i]; j++) {
                arr[j]++;
            }
        }

        return Arrays.stream(arr).max().getAsInt();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i=0; i<n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }

        System.out.println(solution(start, end));
    }
}
