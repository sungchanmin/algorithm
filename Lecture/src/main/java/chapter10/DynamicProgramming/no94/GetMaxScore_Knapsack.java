package chapter10.DynamicProgramming.no94;

import java.util.*;

public class GetMaxScore_Knapsack {
    private static class Problem {
        int s, t;

        public Problem(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
    private static int solution(int n, int limit, List<Problem> list) {
        int[] dy = new int[limit + 1];

        for(int i=list.get(0).t; i<=limit; i++) {
            dy[i] = list.get(0).s;
        }

        for(int i=1; i<n; i++) {
            Problem p = list.get(i);

            for(int j=limit; j>=p.t; j--) {
                if(dy[j] < dy[j - p.t] + p.s) {
                    dy[j] = dy[j - p.t] + p.s;
                }
            }
        }

        return Arrays.stream(dy).max().getAsInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int limit = sc.nextInt();
        List<Problem> list = new ArrayList<>();

        for(int i=0; i<n; i++) list.add(new Problem(sc.nextInt(), sc.nextInt()));

        System.out.println(solution(n, limit, list));
    }
}