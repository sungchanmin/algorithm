package chapter06.SortingSearching.no45;

import java.util.Scanner;

public class BubbleSort {
    private static int[] solution(int[] arr) {
        int tmp;

        for(int i=0; i<arr.length-1; i++) {
            for(int j=0; j<arr.length-1; j++) {
                if(arr[j] > arr[j+1]) {
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        arr = solution(arr);

        for(int i : arr) System.out.print(i + " ");
    }
}
