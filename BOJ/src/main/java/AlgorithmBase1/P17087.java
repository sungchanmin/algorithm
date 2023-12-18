package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P17087 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] strArr = br.readLine().split(" ");
            String[] posArr = br.readLine().split(" ");
            System.out.println(solution(strArr, posArr));
        }
    }

    private static long solution(String[] strArr, String[] posArr) {
        long[] pos = strToLong(posArr);
        long[] dis = new long[posArr.length];

        pos[0] = Long.parseLong(strArr[1]);
        Arrays.sort(pos);

        for(int i=0; i<dis.length; i++) {
            dis[i] = pos[i + 1] - pos[i];
        }

        for(int i=1; i<dis.length; i++) {
            dis[i] = gcd(dis[i - 1], dis[i]);
        }

        return dis[dis.length - 1];
    }

    private static long[] strToLong(String[] strArr) {
        long[] arr = new long[strArr.length + 1];

        for(int i=0; i<strArr.length; i++) {
            arr[i+1] = Long.parseLong(strArr[i]);
        }

        return arr;
    }

    private static long gcd(long a, long b) {
        while(b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
