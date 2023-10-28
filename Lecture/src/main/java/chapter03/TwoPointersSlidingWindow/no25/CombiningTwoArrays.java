package chapter03.TwoPointersSlidingWindow.no25;

import java.util.Scanner;

public class CombiningTwoArrays {
    private static String solution(int n, int m, String[] arr1, String[] arr2) {
        String answer = "";
        int a = 0, b = 0;

        for(int i=0; i<n+m; i++) {
            // a, b가 배열 index 내에 속하는지 먼저 판별해야
            // Out of bounds Exception을 방지할 수 있다.
            if((b >= m) || (a < n && Integer.parseInt(arr1[a]) < Integer.parseInt(arr2[b]))) {
                answer += arr1[a] + " ";
                a++;
            } else {
                answer += arr2[b] + " ";
                b++;
            }
        }

        return answer;
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
