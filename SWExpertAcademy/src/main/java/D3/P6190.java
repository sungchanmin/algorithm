package D3;

import java.util.Scanner;

public class P6190 {
    // 6190. 정곤이의 단조 증가하는 수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i=0; i<n; i++) arr[i] = sc.nextInt();

            System.out.println("#" + test_case + " " + solution(arr));
        }
    }

    private static int solution(int[] arr) {
        int answer = -1;

        for(int i=arr.length-1; i>0; i--) {
            for(int j=i-1; j>=0; j--) {
                int n = arr[i] * arr[j];
                if (n > answer && isDanjo(n)) answer = n;
            }
        }

        return answer;
    }

    private static boolean isDanjo(int n) {
        if(n < 10) return true;
        String nums = Integer.toString(n);

        for(int i=0; i<nums.length() - 1; i++) {
            if(nums.charAt(i) > nums.charAt(i+1)) return false;
        }

        return true;
    }
}