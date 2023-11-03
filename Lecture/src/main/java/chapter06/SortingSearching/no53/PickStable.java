package chapter06.SortingSearching.no53;

import java.util.Arrays;
import java.util.Scanner;

public class PickStable {
    private static boolean stableCheck(int[] arr, int distance, int m) {
        int p = arr[0];
        m--;

        for(int i=1; i<arr.length; i++) {
            if(arr[i] - p >= distance) {
                m--;
                p = arr[i];
            }
            if(m == 0) return true;
        }
        return false;
    }
    private static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 1;
        int rt = arr[n-1];

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(stableCheck(arr, mid, m)) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr);

        System.out.println(solution(n, m, arr));
    }
}
