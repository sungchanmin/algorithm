package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9613 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String[] strArr = br.readLine().split(" ");
                int[] arr = toIntArr(strArr);

                sb.append(solution(arr)).append("\n");
            }

            System.out.println(sb);
        }
    }

    private static int[] toIntArr(String[] strArr) {
        int[] arr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);

        return arr;
    }

    private static long solution(int[] arr) {
        long sum = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum += gcd(arr[i], arr[j]);
            }
        }

        return sum;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
