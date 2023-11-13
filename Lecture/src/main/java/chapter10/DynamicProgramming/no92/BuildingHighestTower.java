package chapter10.DynamicProgramming.no92;

import java.util.*;

public class BuildingHighestTower {
    private static class Brick implements Comparable<Brick> {
        int a, h, w;

        public Brick(int a, int h, int w) {
            this.a = a;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return o.a - this.a;
        }
    }

    private static int solution(List<Brick> list) {
        Collections.sort(list);
        int[] dy = new int[list.size()];
        dy[0] = list.get(0).h;

        for(int i=1; i<list.size(); i++) {
            int height = list.get(i).h;

            for(int j=0; j<i; j++) {
                if(list.get(j).w > list.get(i).w) {
                    height = Math.max(height, dy[j] + list.get(i).h);
                }
            }
            dy[i] = height;
        }

        return Arrays.stream(dy).max().getAsInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Brick> list = new ArrayList<>();

        for(int i=0; i<n; i++) list.add(new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt()));

        System.out.println(solution(list));
    }
}
