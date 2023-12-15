package AlgorithmBase1;

import java.util.Scanner;

public class P2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        for(int i = Math.min(A, B); i>0; i--) {
            if(A % i == 0 && B % i == 0) {
                System.out.println(i);
                break;
            }
        }

        int max = Math.max(A, B);
        int i = max;

        while(!(i % A == 0) || !(i % B == 0)) {
            i += max;
        }

        System.out.println(i);
    }
}