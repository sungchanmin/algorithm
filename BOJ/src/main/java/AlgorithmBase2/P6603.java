package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P6603 {
    // BOJ 6603 로또
    private static int N;
    private static int[] arr;
    private static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(tmp[0] == 0) return;

            N = tmp[0];
            arr = Arrays.copyOfRange(tmp, 1, tmp.length);
            used = new boolean[N];

            solution(6, 0);
            System.out.println();
        }
    }
    private static void solution(int len, int index) {
        if(len == 0) {
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<N; i++) {
                if(used[i]) sb.append(arr[i]).append(" ");
            }

            System.out.println(sb.toString().trim());
            return;
        }

        if (index >= N)
            return;

        // 현재 번호를 선택하는 경우
        used[index] = true;
        solution(len - 1, index + 1);
        // 현재 번호를 선택하지 않는 경우
        used[index] = false;
        solution(len, index + 1);
    }
}
