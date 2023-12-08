package D3;

import java.util.Scanner;

public class P1289 {
    // 1289. 원재의 메모리 복구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] strArr = sc.nextLine().split("");
            System.out.println("#" + test_case + " " + solution(strArr));
        }
    }

    private static int solution(String[] strArr) {
        int answer = 0;
        if(strArr[0].equals("1")) answer++;

        for(int i=1; i<strArr.length; i++) {
            if(!strArr[i].equals(strArr[i - 1])) answer++;
        }

        return answer;
    }
}