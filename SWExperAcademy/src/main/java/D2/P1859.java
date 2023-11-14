package D2;

import java.util.Scanner;

public class P1859 {
    // 1859. 백만 장자 프로젝트
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            int m = sc.nextInt();
            int[] arr = new int[m];

            for(int j=0; j<m; j++) arr[j] = sc.nextInt();

            System.out.println("#" + i + " " + solution(arr));
        }
    }

    private static long solution(int[] arr) {
        long answer = 0;
        int max = 0;

        for(int i=arr.length-1; i>=0; i--) {
            max = Math.max(max, arr[i]);
            answer += max - arr[i];
        }

        return answer;
    }
}

/**
 *  10개중 7개 맞았다고 하시는 분들
 * 타입이 틀린겁니다.
 * 문제를 잘 읽어보세요
 * TC가 100만에 최대 매매가는 10000입니다.
 * 만약 마지막날 빼고 전부다 1원이라고 가정을 해보세요.
 * 계산기 두들겨 보면 99억 넘게 나옵니다...
 * int타입으로 표현 가능한 숫자는 21억 정도예요.
 * 그럼 표현할수 있는 범위를 벗어나서 오답처리가 되는겁니다.
 * long타입으로 바꾸세요.
 */