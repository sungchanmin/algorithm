package D3;

import java.util.Scanner;

public class P1216 {
    // 1216. 회문2
    private static final int SIZE = 100;
    private static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(sc.nextLine());
            arr = new char[SIZE][SIZE];

            for(int i=0; i<SIZE; i++) {
                arr[i] = sc.nextLine().toCharArray();
            }

            System.out.println("#" + test_case + " " + solution());
        }
    }

    private static int solution() {
        int answer = 0;
        int i = 1;

        while(i <= SIZE / 2) {
            if(find(i)) answer = i;
            i++;
        }

        return answer;
    }

    private static boolean find(int n) {
        for(int i=0; i<SIZE; i++) {
            for(int j=0; j<=SIZE-n; j++) {
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                for(int k=0; k<n; k++) {
                    sb1.append(arr[i][j+k]);
                    sb2.append(arr[j+k][i]);
                }
                if(sb1.toString().equals(sb1.reverse().toString()) ||
                        sb2.toString().equals(sb2.reverse().toString())) return true;
            }
        }

        return false;
    }
}