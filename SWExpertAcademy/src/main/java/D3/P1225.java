package D3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1225 {
    // 1225. 암호생성기
    private static final int SIZE = 8;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            Queue<Integer> Q = new LinkedList<>();

            for(int i=0; i<SIZE; i++) Q.offer(sc.nextInt());

            System.out.print("#" + test_case + " ");
            solution(Q);
        }
    }

    private static void solution(Queue<Integer> Q) {
        boolean end = false;

        while(!end) {
            for(int i=1; i<=5; i++) {
                int n = Q.poll();
                n -= i;
                if(n <= 0) {
                    end = true;
                    break;
                }
                Q.offer(n);
            }
        }

        int len = Q.size();
        for(int i=0; i<len; i++) System.out.print(Q.poll() + " ");
        System.out.println(0);
    }
}