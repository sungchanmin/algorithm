package chapter02.Array.no19;

import java.util.Scanner;

public class CalculationScores {
    private static int solution(int n, String str) {
        int answer = 0, count = 0;
        String[] scores = str.split(" ");

        for(String s : scores) {
            if(s.equals("1")) {
                count++;
                answer += count;
            } else {
                count = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        System.out.println(solution(n, str));
    }
}
