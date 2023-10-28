package chapter02.Array.no24;

import java.util.Scanner;

public class Mentoring {
    private static int solution(int n, int m, String[][] strArr) {
        int answer = 0;
        int[][] gradeArr = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                gradeArr[i][Integer.parseInt(strArr[i][j]) - 1] = j + 1;
            }
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                answer += isCanBeMento(i, j, gradeArr) ? 1 : 0;
            }
        }

        return answer;
    }

    private static boolean isCanBeMento(int a, int b, int[][] gradeArr) {
        for(int i=0; i<gradeArr.length; i++) {
            if(gradeArr[i][a] <= gradeArr[i][b]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        String[][] strArr = new String[m][];

        for(int i=0; i<m; i++) {
            strArr[i] = sc.nextLine().split(" ");
            }

        System.out.println(solution(n, m, strArr));
    }
}
