package D3;

import java.util.Scanner;

public class P1206 {
    // 1206. View
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i=0; i<n; i++) arr[i] = sc.nextInt();
            System.out.println("#" + test_case + " " + solution(n, arr));
        }
    }

    private static int solution(int n, int[] arr) {
        int answer = 0;

        for(int i=2; i<n-2; i++) {
            if(arr[i] > arr[i-1] && arr[i] > arr[i-2] && arr[i] > arr[i+1] && arr[i] > arr[i+2]) {
                answer += arr[i] - Math.max(Math.max(arr[i-1], arr[i-2]), Math.max(arr[i+1], arr[i+2]));
            }
        }

        return answer;
    }
}