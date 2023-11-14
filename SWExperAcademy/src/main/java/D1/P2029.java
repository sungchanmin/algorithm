package D1;

import java.util.Scanner;

public class P2029 {
    // 2029. 몫과 나머지 출력하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println("#" + (i + 1) + " " + a/b + " " + a%b);
        }
    }
}
