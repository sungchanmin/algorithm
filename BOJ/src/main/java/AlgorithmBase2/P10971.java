package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10971 {
    // BOJ 10971 외판원 순회 2
    private static int N;
    private static int answer = Integer.MAX_VALUE;
    private static int[][] arr;
    private static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new int[N];
        arr = new int[N][];

        for (int i = 0; i < N; i++) arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        solution(0, 0, 0);
        System.out.println(answer);
    }

    /**
     * 도시를 순회할 수 있는 모든 경우의 수를 재귀적으로 탐색한다.
     * @param cnt 현재까지 방문한 도시의 갯수
     * @param cost 현재까지의 방문 비용
     * @param city 현재 방문중인 도시
     *
     ** 도시의 방문 상태 구분 **
     * visit[index] = -1 : 시작 도시
     * visit[index] = 0 : 방문 전
     * visit[index] = 1 : 방문 완료
     */
    private static void solution(int cnt, int cost, int city) {
        // 아무 도시도 방문하지 않은 경우 : 시작 도시 선정
        if (cnt == 0) {
            for (int i = 0; i < N; i++) {
                visit[i] = -1;
                solution(1, 0, i);
                visit[i] = 0;
            }
            return;
        }
        // 모든 도시를 순회한 경우 : 비용 산정
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                // 방문 상태가 '-1'(시작 도시)인 출발 도시 탐색
                if (visit[i] == -1) {
                    // 마지막 도시에서 출발 도시로 가는 경로가 존재하지 않는 경우 제외
                    if(arr[city][i] == 0) return;
                    cost += arr[city][i];
                    break;
                }
            }
            answer = Math.min(answer, cost);
            return;
        }
        // 도시를 순회 중인 경우 : 다음 방문 도시 선정
        for(int i=0; i<N; i++) {
            // 아직 방문하지 않은 도시 중 경로가 존재하는 도시 선정(비용이 0이 아닌 도시)
            if(visit[i] == 0 && arr[city][i] != 0) {
                visit[i] = 1;
                solution(cnt + 1, cost + arr[city][i], i);
                visit[i] = 0;
            }
        }
    }
}
