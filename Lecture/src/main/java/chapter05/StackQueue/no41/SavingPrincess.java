package chapter05.StackQueue.no41;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavingPrincess {
    private static int solution(int n, int m) {
        Queue<Integer> Q = new LinkedList<>();

        for(int i=0; i<n; i++) Q.add(i);

        while(Q.size() != 1) {
            for(int i=0; i<m; i++) {
                if(i<m-1) {
                    Integer p = Q.poll();
                    Q.add(p);
                } else Q.remove();
            }
        }

        return Q.poll() + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(solution(n, m));
    }
}
