package AlgorithmBase1;

import java.util.Scanner;

public class P11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                n /= i;
                sb.append(i).append(" \n");
            }
        }

        if (n != 1) sb.append(n);

        System.out.println(sb);
    }
}
