package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P14889 {
    // BOJ 14889 스타트와 링크
    private static int N;
    private static int answer = Integer.MAX_VALUE;
    private static int[][] ability;
    private static boolean[] team;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        team = new boolean[N];

        for (int i = 0; i < N; i++)
            ability[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        solution(N, 0, 0);
        System.out.println(answer);
    }

    /**
     * N 번째 사람이 A팀 또는 B팀에 속하는 모든 경우의 팀 조합을 확인한다.
     * @param n 아직 어느팀에도 선발되지 않은 인원(남은 인원)
     * @param aTeamCnt A팀에 선발된 인원 수
     * @param bTeamCnt B팀에 선발된 인원 수
     */
    private static void solution(int n, int aTeamCnt, int bTeamCnt) {
        if (n == 0 && aTeamCnt == bTeamCnt) {
            answer = Math.min(answer, getAbilDif());
            return;
        }
		
        // 한 팀에 속한 인원이 전체 인원의 절반을 넘어가는 경우 배제
        if (aTeamCnt > N / 2 || bTeamCnt > N / 2) return;

        team[N - n] = true;
        solution(n - 1, aTeamCnt + 1, bTeamCnt);
        team[N - n] = false;
        solution(n - 1, aTeamCnt, bTeamCnt + 1);
    }

    /**
     * 양 팀의 능력치를 계산 후 그 차이를 반환한다.
     * @return 능력치 차이
     */
    private static int getAbilDif() {
        int aTeamAbil = 0;
        int bTeamAbil = 0;

        for (int i = 0; i < N; i++) {
			if(team[i]) {
                for(int j=0; j<N; j++) {
                    if(i!=j && team[j]) {
                        aTeamAbil += ability[i][j];
                    }
                }
            } else {
                for(int j=0; j<N; j++) {
                    if(i!=j && !team[j]) {
                        bTeamAbil += ability[i][j];
                    }
                }
            }
        }

        return Math.abs(aTeamAbil - bTeamAbil);
    }
}