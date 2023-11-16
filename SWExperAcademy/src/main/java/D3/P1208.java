package D3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1208 {
    // 1208. Flatten
    private static final int SIZE = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            PriorityQueue<Integer> ascQ = new PriorityQueue();
            PriorityQueue<Integer> descQ = new PriorityQueue(Collections.reverseOrder());
            int n = sc.nextInt();

            for(int i=0; i<SIZE; i++) {
                int num = sc.nextInt();
                ascQ.add(num);
                descQ.add(num);
            }

            System.out.println("#" + test_case + " " + solution(n, ascQ, descQ));
        }
    }

    private static int solution(int n, PriorityQueue<Integer> ascQ, PriorityQueue<Integer> descQ) {
        for(int i=0; i<n; i++) {
            int max = descQ.poll();
            int min = ascQ.poll();

            if(max - min <= 1) return 1;

            descQ.add(max - 1);
            ascQ.add(min + 1);
        }

        return descQ.poll() - ascQ.poll();
    }
}
