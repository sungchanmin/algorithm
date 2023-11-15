import java.util.Scanner;

public class Solution {
    // 1974. 스도쿠 검증
    private static final int SIZE = 9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            System.out.println("#" + test_case);
            solution(sc.nextInt());
        }
    }

    private static void solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;

        System.out.println(1);

        for(int i=1; i<n; i++) {
            System.out.print(1 + " ");
            for(int j=i-1; j>0; j--) {
                arr[j] = arr[j] + arr[j-1];
                System.out.print(arr[j] + " ");
            }
            arr[i] = 1;
            System.out.println(1);
        }
    }
}