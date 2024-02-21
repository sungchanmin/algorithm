package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2528 {
    // BOJ 2528 부등호
    private static int N;
    private static long MAX = Long.MIN_VALUE;
    private static long MIN = Long.MAX_VALUE;
    private static int[] nums;
    private static char[] signs;
    private static boolean[] used = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        signs = br.readLine().replaceAll(" ", "").toCharArray();

        solution(0);

        // 정규식 표현(앞자리가 0인 경우 0을 채워서 출력)
        System.out.printf("%0" + (N + 1) + "d%n", MAX);
        System.out.printf("%0" + (N + 1) + "d%n", MIN);
    }

    /**
     * 주어진 부등호와 앞 자리수의 값을 비교하여,
     * 현재 자릿수에 올 수 있는 모든 값을 탐색한다.
     * @param n 현재 자릿수의 index(0부터 시작)
     */
    private static void solution(int n) {
        if (n == N + 1) {
            long result = toNumber(nums);
            MAX = Math.max(MAX, result);
            MIN = Math.min(MIN, result);
            return;
        }

        // 현재 자릿수가 가장 높은 자리인 경우 0~9의 모든 경우 탐색
        if (n == 0) {
            for (int i = 0; i < 10; i++) {
                nums[0] = i;
                used[i] = true;
                solution(n + 1);
                used[i] = false;
            }
        } else {
            for (int i = 0; i < 10; i++) {
                // 이전에 사용된 적 없으면서, 앞 자리와 비교하여 부등호를 만족하는 모든 경우 탐색
                if (!used[i]) {
                    if (signs[n - 1] == '<' && nums[n - 1] < i) {
                        nums[n] = i;
                        used[i] = true;
                        solution(n + 1);
                        used[i] = false;
                    } else if (signs[n - 1] == '>' && nums[n - 1] > i) {
                        nums[n] = i;
                        used[i] = true;
                        solution(n + 1);
                        used[i] = false;
                    }
                }
            }
        }
    }

    /**
     * 입력 받은 배열을 숫자로 변환한다.
     * @param arr 숫자 배열
     * @return 변환된 정수
     */
    private static long toNumber(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) sb.append(i);
        return Long.parseLong(sb.toString());
    }
}