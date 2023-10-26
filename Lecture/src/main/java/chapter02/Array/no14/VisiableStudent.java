package chapter02.Array.no14;

import java.util.Scanner;

public class VisiableStudent {
    private static int solution(int n, String str) {
        int answer = 1, tall;
        String[] students = str.split(" ");
        tall = Integer.parseInt(students[0]);

        for(int i=0; i<n; i++) {
            if(Integer.parseInt(students[i]) > tall) {
                tall = Integer.parseInt(students[i]);
                answer += 1;
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
