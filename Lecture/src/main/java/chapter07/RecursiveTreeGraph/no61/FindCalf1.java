package chapter07.RecursiveTreeGraph.no61;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindCalf1 {
    private static int solution(int n, int m) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(n);

        while(true) {
            int len = Q.size();

            for(int i=0; i<len; i++) {
                int x = Q.poll();
                if(x == m) return answer;

                if(x < m - 5) Q.add(x + 5);
                else if(x < m) {
                    Q.add(x + 5);
                    Q.add(x + 1);
                } else Q.add(x - 1);
            }
            answer++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(solution(n, m));
    }
}
