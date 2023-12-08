package D3;

import java.util.Scanner;

public class P1213 {
    // 1213. String
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(sc.nextLine());
            String word = sc.nextLine();
            String str = sc.nextLine();

            System.out.println("#" + test_case + " " + solution(word, str));
        }
    }
    private static int solution(String word, String str) {
        int answer = 0;
        for(int i=0; i<str.length() - word.length() + 1; i++) {
            if(word.equals(str.substring(i, i + word.length()))) answer++;
        }
        return answer;
    }

}