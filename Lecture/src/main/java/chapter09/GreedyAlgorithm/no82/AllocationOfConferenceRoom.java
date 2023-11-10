package chapter09.GreedyAlgorithm.no82;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AllocationOfConferenceRoom {
    private static class Time implements Comparable<Time> {
        int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.end == o.end) return Integer.compare(this.start, o.start);
            return Integer.compare(this.end, o.end);
        }
    }

    private static int solution(List<Time> list) {
        int answer = 0;
        Collections.sort(list);

        int endTime = 0;
        for (Time t : list) {
            if (t.start >= endTime) {
                endTime = t.end;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new Time(start, end));
        }

        System.out.println(solution(list));
    }
}

