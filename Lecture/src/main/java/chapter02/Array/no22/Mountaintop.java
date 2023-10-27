package chapter02.Array.no22;

import java.util.Scanner;

public class Mountaintop {
    private static int solution(int n, String[][] strings) {
        int answer = 0;

        for(int i=1; i<n + 1; i++) {
            for(int j=1; j<n + 1; j++) {
                if(Integer.parseInt(strings[i][j]) > Integer.parseInt(strings[i - 1][j])
                    && Integer.parseInt(strings[i][j]) > Integer.parseInt(strings[i + 1][j])
                    && Integer.parseInt(strings[i][j]) > Integer.parseInt(strings[i][j - 1])
                    && Integer.parseInt(strings[i][j]) > Integer.parseInt(strings[i][j + 1]))
                    answer ++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] strings = new String[n + 2][n + 2];

        for(int i=0; i<n + 2; i++) {
            if(i == 0 || i == n + 1) {
                for(int j=0; j<n + 2; j++) {
                    strings[i][j] = "0";
                }
            } else {
                strings[i][0] = "0";
                System.arraycopy(sc.nextLine().split(" "), 0, strings[i], 1, n);
                strings[i][n + 1] = "0";
            }
        }

        System.out.println(solution(n, strings));
    }
}
