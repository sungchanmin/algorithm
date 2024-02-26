package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11723 {
    // BOJ 11723 집합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int bitset = 0;
        int num;

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    bitset = bitset | (1 << num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    bitset = bitset & ~(1 << num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if ((bitset & (1 << num)) != 0) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    bitset = bitset ^ (1 << num);
                    break;
                case "all":
                    bitset = ~0;
                    break;
                case "empty":
                    bitset = 0;
                    break;

            }
        }

        System.out.println(sb);
    }
}