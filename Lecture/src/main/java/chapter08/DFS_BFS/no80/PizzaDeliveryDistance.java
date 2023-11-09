package chapter08.DFS_BFS.no80;

import java.util.*;
import java.util.stream.Collectors;

public class PizzaDeliveryDistance {
    private static int size, maxPizza;
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    private static List<Point> pizzas = new ArrayList<>();
    private static List<Point> houses = new ArrayList<>();
    private static List<List<Point>> pizzaList = new ArrayList<>();
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static void DFS(int L, List<Point> pizzaCombi) {
        if(pizzaCombi.size() > maxPizza) return;
        if(L == pizzas.size()) {
            if(pizzaCombi.size() == maxPizza) pizzaList.add(new ArrayList<>(pizzaCombi));
            return;
        }

        for(int i=L; i<pizzas.size(); i++) {
            pizzaCombi.add(pizzas.get(i));
            DFS(i+1, new ArrayList<>(pizzaCombi));
            pizzaCombi.remove(pizzaCombi.size()-1);
            DFS(i+1, new ArrayList<>(pizzaCombi));

        }
    }
    private static int solution() {
        int answer = 0;
        // 1. 전체 피자집에서 maxPizza 개수 만큼의 피자집을 선택하는 경우의 수(DFS)
        DFS(0, new ArrayList<>());

        for(List<Point> l : pizzaList) {
            for(Point p : l) {
                System.out.print("(" + p.x + "," + p.y + "), ");
            }
            System.out.println();
        }
        // 2. 각 집과 선택된 피자집과의 거리 합 구하기
        System.out.println(pizzaList.size());

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        maxPizza = sc.nextInt();
        map = new int[size][size];

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) houses.add(new Point(i, j));
                else if(map[i][j] == 2) pizzas.add(new Point(i, j));
            }
        }

        System.out.println(solution());
    }
}
