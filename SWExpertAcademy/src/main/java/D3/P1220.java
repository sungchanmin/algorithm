package D3;

import java.util.Scanner;
import java.util.Stack;

public class P1220 {
            // 1220. Magnetic
            // 1 = N, 2 = S, 위 = N, 아래 = S
            private static final int SIZE = 100;
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

                for (int test_case = 1; test_case <= 10; test_case++) {
                    int n = sc.nextInt();
                    int[][] arr = new int[SIZE][SIZE];

                    for(int i=0; i<SIZE; i++) {
                        for(int j=0; j<SIZE; j++) arr[i][j] = sc.nextInt();
                    }

                    System.out.println("#" + test_case + " " + solution(arr));
                }
            }

            private static int solution(int[][] arr) {
                int answer = 0;

                for(int i=0; i<SIZE; i++) {
                    Stack<Integer> stack = new Stack<>();
                    boolean stuck = false;
                    boolean gap = false;

                    for(int j=0; j<SIZE; j++) {
                        int m = arr[j][i];

                        if(m == 1) {
                            if(gap) {
                                stack.clear();
                                stuck = false;
                            }
                            stack.push(m);
                        }
                        else if(m == 2 && !stack.isEmpty() && !stuck) {
                            stuck = true;
                            answer++;
                        } else gap = true;
                    }
                }

                return answer;
            }
}