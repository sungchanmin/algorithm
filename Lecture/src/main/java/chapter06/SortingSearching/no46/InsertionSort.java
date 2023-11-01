package chapter06.SortingSearching.no46;

import java.util.Scanner;

public class InsertionSort {
    private static int[] solution(int[] arr) {
        int j;
        for(int i=1; i<arr.length; i++){
            int tmp = arr[i];

            for(j=i-1; j>=0; j--) {
                if(tmp<arr[j]) arr[j+1] = arr[j];
                else break;
            }

            arr[j + 1] = tmp;
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
