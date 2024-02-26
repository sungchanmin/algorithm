package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1248 {
    // BOJ 1248 Guess
    private static int N;
    private static int[] answer;
    private static char[][] signs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        answer = new int[N];
        signs = new char[N][N];

        setSigns(br.readLine().toCharArray());

        solution(0);
        printAnswer();
    }

    /**
     * 입력 받은 부호를 2차원 배열에 저장한다.
     *
     * @param chars +, -, 0 등의 부호 배열
     */
    private static void setSigns(char[] chars) {
        int index = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // i > j인 경우 공백 처리
                if (i > j) signs[i][j] = ' ';
                else {
                    // 그 외의 경우 부호를 2차원 배열에 입력
                    signs[i][j] = chars[index];
                    index++;
                }
            }
        }
    }

    /**
     * 백트래킹을 통해 가능한 수열 조합을 찾는다.
     *
     * @param index 조합하는 수열의 현재 인덱스
     * @return 유효 여부
     */
    private static boolean solution(int index) {
        // 모든 위치에 대해 가능한 값이 정해진 경우 true 반환
        if (index == N) return true;

        // 해당 위치에 대해 가능한 모든 값을 시도
        for (int i = -10; i <= 10; i++) {
            answer[index] = i;
            // 현재 수열이 유효한지 검사하고, 다음 위치로 진행
            if (isValid(index) && solution(index + 1)) return true;
        }

        // 유효한 수열을 찾지 못한 경우 false 반환 (백트래킹)
        return false;
    }

    /**
     * 현재까지의 수열이 유효한지 검사한다.
     *
     * @param index 조합된 수열의 인덱스 범위
     * @return 유효 여부
     */
    private static boolean isValid(int index) {
        // 모든 위치에 대해 검사
        for (int i = 0; i <= index; i++) {
            int sum = 0;
            // 현재 위치부터 시작하여 합을 구하고, 부호 배열과 비교
            for (int j = i; j <= index; j++) {
                sum += answer[j];
                // 부호 배열과 합을 비교하여 유효하지 않으면 false 반환
                if ((sum > 0 && signs[i][j] != '+') ||
                        (sum < 0 && signs[i][j] != '-') ||
                        (sum == 0 && signs[i][j] != '0'))
                    return false;
            }
        }
        return true;
    }

    /**
     * 찾은 수열을 문자열로 변환하여 출력한다.
     */
    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int i : answer) sb.append(i).append(" ");
        System.out.println(sb.toString().trim());
    }
}
