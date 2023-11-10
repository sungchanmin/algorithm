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
            if(this.pay == o.pay) return this.day - o.day;
            return o.pay - this.pay;
        }
    }
    private static int solution(List<Lecture> list) {
        int pay = 0;
        Map<Integer, Integer> schedule = new HashMap<>();
        Collections.sort(list);

        for(Lecture l : list) {
            for(int i=l.day; i>0; i--) {
                if(!schedule.containsKey(i)) {
                    schedule.put(i, i);
                    pay += l.pay;
                    break;
                }
            }
        }

        return pay;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Lecture> list = new ArrayList<>();

        for(int i=0; i<n; i++) list.add(new Lecture(sc.nextInt(), sc.nextInt()));

        System.out.println(solution(list));
    }
}
