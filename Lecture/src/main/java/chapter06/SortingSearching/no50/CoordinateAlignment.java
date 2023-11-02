package chapter06.SortingSearching.no50;

import java.util.Arrays;
import java.util.Scanner;

public class CoordinateAlignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int multi = 100000;

        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr[i] = x*multi + y;
        }

        Arrays.sort(arr);

        for(int i=0; i<n; i++) {
            System.out.println(arr[i]/multi + " " + arr[i]%multi);
        }
    }
}
