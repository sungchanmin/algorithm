package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] strArr = br.readLine().split(" ");

        int a = Integer.parseInt(strArr[0]);
        int b = Integer.parseInt(strArr[1]);
        int c = Integer.parseInt(strArr[2]);


        for(int i=1; i<n; i++) {
            int minA = Math.min(b, c);
            int minB = Math.min(a, c);
            int minC = Math.min(a, b);

            strArr = br.readLine().split(" ");

            a = Integer.parseInt(strArr[0]) + minA;
            b = Integer.parseInt(strArr[1]) + minB;
            c = Integer.parseInt(strArr[2]) + minC;
        }

        System.out.println(Math.min(a, Math.min(b, c)));
    }
}
