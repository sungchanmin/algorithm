package chapter06.SortingSearching.no53;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PickStable_wrongCode {
    public static class Stable {
        public boolean horse = false;
        public int x = 0;
        public int distance = 0;

        public Stable(int x) {
            this.x = x;
        }
    }
    private static int solution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        List<Stable> list = new ArrayList<>();

        for(int i : arr) list.add(new Stable(i));

        list.get(0).horse = true;
        list.get(list.size() - 1).horse = true;
        m = m - 2;

        if(m == 0) {
            return Math.abs(list.get(0).x - list.get(list.size() - 1).x);
        }

        while(m > 0)  {

            for(int i=1; i<list.size() - 1; i++) {
                Stable s = list.get(i);

                if(!s.horse) {
                    int next = 1;

                    while (true) {
                        Stable f = list.get(i + next);
                        if (f.horse) {
                            s.distance = Math.abs(s.x - f.x);
                            break;
                        } else next++;
                    }

                    next = 1;

                    while (true) {
                        Stable f = list.get(i - next);
                        if (f.horse) {
                            s.distance = Math.min(s.distance, Math.abs(s.x - f.x));
                            break;
                        } else next++;
                    }
                }
            }

            int maxDis = 0;
            int index = 0;

            for(int i=1; i<list.size() - 1; i++) {
                Stable s = list.get(i);

                if(!s.horse && s.distance > maxDis) {
                    index = i;
                    maxDis = s.distance;
                }
            }

            list.get(index).horse = true;
            m--;

            if(m == 0) return maxDis;
        }

        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        System.out.println(solution(n, m, arr));
    }
}
