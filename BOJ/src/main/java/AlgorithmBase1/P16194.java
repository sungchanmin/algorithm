package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] arr = toIntArray(str);
        System.out.println(solution(n, arr));

    }

    private static int[] toIntArray(String str) {
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);

        return arr;
    }

    private static int solution(int n, int[] arr) {
        int[] dy = new int[n + 1];

        for(int i = 0; i< arr.length; i++) {
            for(int j = i + 1; j < dy.length; j++) {
                if(dy[j] == 0) dy[j] = arr[i] * (j);
                else dy[j] = Math.min(dy[j - (i + 1)] + arr[i], dy[j]);
            }
        }
        return dy[n];
    }
}
