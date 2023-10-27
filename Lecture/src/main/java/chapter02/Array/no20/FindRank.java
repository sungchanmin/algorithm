package chapter02.Array.no20;

import java.util.Scanner;

public class FindRank {
    private static String solution(int n, String str) {
        String answer = "";
        String[] scores = str.split(" ");

        for(String s : scores) {
            int count = 1;

            for(String c : scores) {
                if(Integer.parseInt(s) < Integer.parseInt(c)) count++;
            }

            answer += count + " ";
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
