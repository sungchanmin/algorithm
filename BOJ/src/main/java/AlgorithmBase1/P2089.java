package AlgorithmBase1;

import java.io.IOException;
import java.util.Scanner;

public class P2089 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        if(n == 0) System.out.println(0);
        else {
            while(n != 1) {
                sb.append(Math.abs(n % -2));
                n = (int)Math.ceil((double) n / (-2));
            }

            sb.append(n);

            System.out.println(sb.reverse());
        }
    }
}
