package D2;

import java.util.Scanner;

public class P1859 {
    // 1859. 백만 장자 프로젝트
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];

            for(int j=0; j<m; j++) arr[j] = sc.nextInt();

            System.out.println("#" + i + " " + solution(arr));
        }
    }

    private static long solution(int[] arr) {
        long answer = 0;
        int max = 0;

        for(int i=arr.length-1; i>=0; i--) {
            max = Math.max(max, arr[i]);
            answer += max - arr[i];
        }

        return answer;
    }
}
