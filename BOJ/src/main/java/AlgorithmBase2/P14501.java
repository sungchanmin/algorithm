package AlgorithmBase2;

import java.util.Scanner;

public class P14501 {
    // BOJ 14501 퇴사
    private static int N;
    private static int answer = 0;
    private static int[] day;
    private static int[] profit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        day = new int[N];
        profit = new int[N];

        for(int i=0; i<N; i++) {
            day[i] = sc.nextInt();
            profit[i] = sc.nextInt();
        }

        solution(N, 0, 0);

        System.out.println(answer);
    }

    /**
     * 일정표의 N 번째에 날에 일하는 경우와 일하지 않는 모든 경우의 수를 탐색한다.
     * @param days 남은 일수
     * @param term 걸리는 시간
     * @param sum 수익 합계
     */
    private static void solution(int days, int term, int sum) {
        term--;

        if(days == 0) {
            answer = Math.max(answer, sum);
            return;
        }
        
        // 현재 상담이 가능한 경우
        if(term <= 0 && day[N - days] <= days) {
            solution(days - 1, day[N - days], sum + profit[N - days]);
        }
        
        // 현재 상담이 불가능하거나, 가능하지만 하지 않는 경우
        solution(days - 1, term, sum);
    }
}
