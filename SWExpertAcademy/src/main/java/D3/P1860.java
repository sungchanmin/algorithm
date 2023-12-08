package D3;

import java.util.Arrays;
import java.util.Scanner;

public class P1860 {
    // 1860. 진기의 최고급 붕어빵
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt(); // 인원
            int m = sc.nextInt(); // 시간
            int k = sc.nextInt(); // 개수
            int[] arr = new int[n];

            for(int i=0; i<n; i++) arr[i] = sc.nextInt();

            System.out.println("#" + test_case + " " + solution(n, m, k, arr));
        }
    }

    private static String solution(int n, int m, int k, int[] arr) {
        Arrays.sort(arr);
        int sold = 0;

        for(int i=0; i<n; i++) {
            if((arr[i] / m) * k - sold <= 0) return "Impossible";
            else {
                sold++;
                if((arr[i] / m) * k - sold >= n - i - 1) return "Possible";
            }
        }

        return "Possible";
    }
}
