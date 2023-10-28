package chapter03.TwoPointersSlidingWindow.no26;

import java.util.Arrays;
import java.util.Scanner;

public class FindCommonElements {
    private static String solution(int n, int m, String[] arr1, String[] arr2) {
        int[] intArr1 = Arrays.stream(arr1).mapToInt(Integer::parseInt).toArray();
        int[] intArr2 = Arrays.stream(arr2).mapToInt(Integer::parseInt).toArray();

        Arrays.sort((intArr1));
        Arrays.sort((intArr2));

        return commonElements(intArr1, intArr2);
    }

    private static String commonElements(int[] arr1, int[] arr2) {
        String result = "";
        int a = 0, b = 0;

        while(a < arr1.length && b < arr2.length) {
            if(arr1[a] == arr2[b]) {
                result += arr1[a] + " ";
                a++;
                b++;
            } else if(arr1[a] > arr2[b]) {
                b++;
            } else a++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] arr1 = sc.nextLine().split(" ");
        int m = Integer.parseInt(sc.nextLine());
        String[] arr2 = sc.nextLine().split(" ");

        System.out.println(solution(n, m, arr1, arr2));
    }
}
