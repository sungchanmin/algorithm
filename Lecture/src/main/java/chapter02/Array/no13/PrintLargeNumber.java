package chapter02.Array.no13;

import java.util.Scanner;

public class PrintLargeNumber {
    private static String solution(int n, String str) {
        String answer = "";
        String[] numbers = str.split(" ");

        answer = numbers[0];

        for(int i=1; i<n; i++) {
            if(Integer.parseInt(numbers[i]) > Integer.parseInt(numbers[i-1])) {
                answer += " " + numbers[i];
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
