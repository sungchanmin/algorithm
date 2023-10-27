package chapter02.Array.no23;

import java.util.Scanner;

public class ProvisionalClassPresident {
    private static int solution(int n, String[][] strArr) {
        int answer = 1, max = 0;
        int [] dupClassSum = new int[n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                dupClassSum[i] += dupClassCheck(strArr[i], strArr[j]);
            }

            if(max < dupClassSum[i]) {
                answer = i + 1;
                max = dupClassSum[i];
            }
        }


        return answer;
    }

    private static int dupClassCheck(String[] str1, String[] str2) {
        for(int i=0; i<5; i++) {
           if(str1[i].equals(str2[i])) return 1;
        }

        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] strArr = new String[n][];

        for(int i=0; i<n; i++) {
            strArr[i] = sc.nextLine().split(" ");
        }
        System.out.println(solution(n ,strArr));
    }

}
