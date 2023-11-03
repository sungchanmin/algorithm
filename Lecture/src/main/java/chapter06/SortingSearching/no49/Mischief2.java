package chapter06.SortingSearching.no49;

import java.util.Arrays;
import java.util.Scanner;

public class Mischief2 {
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
