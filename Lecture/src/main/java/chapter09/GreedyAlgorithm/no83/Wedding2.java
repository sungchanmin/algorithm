package chapter09.GreedyAlgorithm.no83;

import java.util.*;

public class Wedding2 {
    private static class Time implements Comparable<Time> {
        int time;
        String type;

        public Time(int time, String type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Time o) {
            if(this.time == o.time) return this.type.compareTo(o.type) * -1;
            return this.time - o.time;
        }
    }
    private static int solution(List<Time> list) {
        int answer = 0;
        int count = 0;
        Collections.sort(list);
        for(Time t : list) {
            if(t.type.equals("in")) count++;
            else count--;
            answer = Math.max(answer, count);
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            list.add(new Time(sc.nextInt(), "in"));
            list.add(new Time(sc.nextInt(), "out"));
        }

        System.out.println(solution(list));
    }
}
