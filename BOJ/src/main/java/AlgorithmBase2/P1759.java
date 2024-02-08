package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1759 {
    // BOJ 1759 암호 만들기
    private static int L;
    private static int C;
    private static char[] alphas;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        L = arr[0];
        C = arr[1];
        used = new boolean[C];
        alphas = br.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(alphas);


        solution(L, 0, 0, 0);
    }

    /**
     * 알파벳 조합 중 조건을 만족하는 모든 경우를 찾는다.
     *
     * @param len    현재 조합 길이
     * @param vowCnt 사용된 모음 알파벳 갯수
     * @param conCnt 사용된 자음 알파벳 갯수
     * @param index  현재 탐색 인덱스
     */
    private static void solution(int len, int vowCnt, int conCnt, int index) {
        if (len == 0 && vowCnt >= 1 && conCnt >= 2) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < C; i++) {
                if (used[i]) sb.append(alphas[i]);
            }

            System.out.println(sb);
            return;
        }

        if (index >= C) return;

        used[index] = true;
        if (isVowel(alphas[index])) {
            solution(len - 1, vowCnt + 1, conCnt, index + 1);
        } else {
            solution(len - 1, vowCnt, conCnt + 1, index + 1);
        }

        used[index] = false;
        solution(len, vowCnt, conCnt, index + 1);
    }

    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}
