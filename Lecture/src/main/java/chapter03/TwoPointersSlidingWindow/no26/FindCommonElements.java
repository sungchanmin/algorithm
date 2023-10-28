package chapter03.TwoPointersSlidingWindow.no26;

import java.util.Arrays;
import java.util.Scanner;

public class FindCommonElements {
    private static String solution(int n, int m, int[] arr1, int[] arr2) {
        String answer = "";
        int a = 0, b = 0;

        Arrays.sort((arr1));
        Arrays.sort((arr2));

        while(a < arr1.length && b < arr2.length) {
            if(arr1[a] == arr2[b]) {
                answer += arr1[a] + " ";
                a++;
                b++;
            } else if(arr1[a] > arr2[b]) {
                b++;
            } else a++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];

        for(int i=0; i<n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];

        for(int i=0; i<m; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println(solution(n, m, arr1, arr2));
    }
}
