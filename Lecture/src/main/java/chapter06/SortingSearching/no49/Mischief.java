package chapter06.SortingSearching.no49;

import java.util.Arrays;
import java.util.Scanner;

public class Mischief {
//    private static String solution(int[] arr) {
//        int c = 0, p = 0;
//
//        for(int i=arr.length-1; i>1; i--) {
//            if(arr[i] < arr[i - 1]) {
//                p = i + 1;
//                break;
//            }
//        }
//
//        for(int i=0; i<p; i++ ) {
//            if(arr[i] > arr[p-1]) {
//                c = i + 1;
//                break;
//            }
//        }
//
//        return c + " " + p;
//    }

    private static String solution(int[] arr) {
        String answer = "";
        int[] compare = arr.clone();
        Arrays.sort(compare);

        for(int i=0; i<arr.length; i++) {
            if(arr[i] != compare[i]) answer += i + 1 + " ";
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(solution(arr));
    }
}
