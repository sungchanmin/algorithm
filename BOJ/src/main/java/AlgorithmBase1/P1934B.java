package AlgorithmBase1;

import java.io.*;

public class P1934B {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String[] strArr = br.readLine().split(" ");
                bw.write(solution(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1])));
                bw.write("\n");
            }

            bw.flush();
        }
    }

    private static String solution(int a, int b) {
        return String.valueOf(a * b / gcd(a, b));
    }

    private static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}