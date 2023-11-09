package chapter09.GreedyAlgorithm.no81;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WrestlingPlayer {
    public static class Man implements Comparable<Man> {
        int h, w;

        public Man(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Man o) {
            if(h == o.h) return w - o.w;
            else return h - o.h;
        }
    }
    private static int solution(List<Man> list) {
        Collections.sort(list, Collections.reverseOrder());
        int answer = list.size();
        int heavy = 0;

        for(Man m : list) {
            if(heavy == 0) heavy = m.w;
            else {
                if(m.w < heavy) answer--;
                heavy = Math.max(heavy, m.w);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Man> list = new ArrayList<>();
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Man(h, w));
        }

        System.out.println(solution(list));
    }
}
