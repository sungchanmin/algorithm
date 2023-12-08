package D3;

import java.util.Scanner;

public class P1217 {
    // 1217. 거듭 제곱
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println("#" + test_case + " " + solution(n, m));
        }
    }

    private static int solution(int n, int m) {
        if(m == 1) return n;
        return n * solution(n, m-1);
    }
}
