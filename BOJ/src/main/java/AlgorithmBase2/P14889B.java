package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P14889B {
    // BOJ 14889 스타트와 링크(bitmask)
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

        solution();
        System.out.println(answer);
    }

    /**
     * bitmask : 양팀을 나누는 모든 경우의 수를 확인한다.
     */
    private static void solution() {
        for (int bit = 0; bit < 1 << N; bit++) {
            int cntA = 0;
            int cntB = 0;

            for (int i = 0; i < N; i++) {
                if ((bit & (1 << i)) != 0) {
                    team[i] = true;
                    cntA++;
                } else {
                    team[i] = false;
                    cntB++;
                }

                if(cntA > N/2 || cntB > N/2) break;
            }

            if(cntA == cntB) answer = Math.min(answer, getAbilDif());
        }
    }

    /**
     * 양 팀의 능력치를 계산 후 그 차이를 반환한다.
     *
     * @return 능력치 차이
     */
    private static int getAbilDif() {
        int aTeamAbil = 0;
        int bTeamAbil = 0;

        for (int i = 0; i < N; i++) {
            if (team[i]) {
                for (int j = 0; j < N; j++) if (team[j]) aTeamAbil += ability[i][j];
            } else {
                for (int j = 0; j < N; j++) if (!team[j]) bTeamAbil += ability[i][j];
            }
        }

        return Math.abs(aTeamAbil - bTeamAbil);
    }
}
