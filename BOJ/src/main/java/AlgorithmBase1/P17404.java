package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17404 {
    static final int INF = 987654321;

    public static int solution(int n, int[][] rgbs) {
        //최대 비용으로 초기화
        int answer = INF;
        //비용을 저장할 dp, i번째 집을 r/g/b로 칠할 경우, 최소 비용을 저장
        int[][] dp = new int[n][3];

        //i : 처음 색을 지정
        for(int i=0;i<3;i++) {
            //처음 i번째 색을 선택하기 위해, i번째 색 이외 INF로 초기화
            for(int j=0;j<3;j++) {
                dp[0][j]=i==j?rgbs[0][i]:INF;
            }
            //집 탐색
            for(int j=1;j<n;j++) {
                //이전 집과 다른 색을 칠하는 경우 중 최소값을 저장
                for(int k=0;k<3;k++) {
                    dp[j][k]=INF;
                    for(int l=0;l<3;l++) {
                        if(k==l) continue;
                        dp[j][k]=Math.min(dp[j][k], dp[j-1][l]+rgbs[j][k]);
                    }
                }
            }
            //처음과 마지막집의 색이 다르면 최소값을 answer로 가져오기
            for(int j=0;j<3;j++) {
                if(i==j) continue;
                answer=Math.min(answer, dp[n-1][j]);
            }
        }
        //출력
        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //집의 개수
        StringTokenizer st;
        int[][] rgbs = new int[n][3]; //각 색을 칠하는 비용
        //비용 입력
        for(int i=0;i<n;i++) {
            st=new StringTokenizer(br.readLine());
            rgbs[i][0]=Integer.parseInt(st.nextToken());
            rgbs[i][1]=Integer.parseInt(st.nextToken());
            rgbs[i][2]=Integer.parseInt(st.nextToken());
        }
        //최소 비용 출력
        System.out.println(solution(n, rgbs));

        br.close();
    }
}
