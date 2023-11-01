package chapter06.SortingSearching.no44;

import java.util.Scanner;

public class SelectionSort {
    private static int[] solution(int[] arr) {
        int tmp, index;

        for(int i=0; i<arr.length-1; i++) {
            index = i;

            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] > arr[j]) index = j;
            }

            tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
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
