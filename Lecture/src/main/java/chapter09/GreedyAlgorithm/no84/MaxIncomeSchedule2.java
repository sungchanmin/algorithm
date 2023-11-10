package chapter09.GreedyAlgorithm.no84;

import java.util.*;

public class MaxIncomeSchedule2 {
    private static class Lecture implements Comparable<Lecture> {
        int pay, day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.day - this.day;
        }
    }

    private static int solution(List<Lecture> list, int max) {
        int pay = 0;
        Collections.sort(list);
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for (int i=max; i>0; i--) {
            for (; j<list.size(); j++) {
                Lecture l = list.get(j);
                if(l.day != i) break;
                pQ.add(l.pay);
            }
            if(!pQ.isEmpty()) pay += pQ.poll();
        }

        return pay;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        List<Lecture> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pay = sc.nextInt();
            int day = sc.nextInt();
            max = Math.max(max, day);
            list.add(new Lecture(pay, day));
        }

        System.out.println(solution(list, max));
    }
}
