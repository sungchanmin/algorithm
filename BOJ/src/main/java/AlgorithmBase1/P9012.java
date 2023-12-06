package AlgorithmBase1;

import java.util.Scanner;

public class P9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for(int i=0; i<n; i++) {
            char[] arr = sc.nextLine().toCharArray();
            System.out.println(solution(arr));
        }
    }

    private static String solution(char[] arr) {
        int cnt = 0;

        for(char c : arr) {
            if(c == '(') cnt++;
            else if(cnt != 0) cnt--;
            else return "NO";
        }

        return cnt == 0 ? "YES" : "NO";
    }
}
