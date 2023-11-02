package chapter06.SortingSearching.no51;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    private static int solution(int m, int[] arr) {
        Arrays.sort(arr);
        int a=0, b=arr.length;

        while(b - a > 1) {
            if(m >= arr[(a+b)/2]) a = (a+b)/2;
            else b = (a+b)/2;
        }

        return a + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        System.out.println(solution(m, arr));
    }
}
