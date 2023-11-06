package chapter07.RecursiveTreeGraph.no61;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindCalf1_2 {
    private static int solution(int n, int m) {
        int answer = 0;
        int[] dis = { -1, 1, 5 };
        int ch[] = new int[10001];
        Queue<Integer> Q = new LinkedList<>();

        Q.add(n);
        ch[n] = 1;

        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i=0; i<len; i++) {
                int x = Q.poll();
                for(int d : dis) {
                    if(x + d == m) return answer + 1;
                    if(x + d > 0 && x + d < 10000 && ch[x + d] != 1) {
                        Q.offer(x + d);
                        ch[x + d] = 1;
                    }
                }
            }
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(solution(n, m));
    }
}
