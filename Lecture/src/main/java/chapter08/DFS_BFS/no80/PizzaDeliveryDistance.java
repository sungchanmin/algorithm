package chapter08.DFS_BFS.no80;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaDeliveryDistance {
    private static int size, maxPizza;
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
        if (pizzaCombi.size() > maxPizza) return;
        if (L == pizzas.size()) {
            if (pizzaCombi.size() == maxPizza) pizzaList.add(new ArrayList<>(pizzaCombi));
            return;
        }

        DFS(L + 1, new ArrayList<>(pizzaCombi));
        pizzaCombi.add(pizzas.get(L));
        DFS(L + 1, new ArrayList<>(pizzaCombi));
    }

    private static int solution() {
        int answer = Integer.MAX_VALUE;
        // 1. 전체 피자집에서 maxPizza 개수 만큼의 피자집을 선택하는 경우의 수(DFS)
        DFS(0, new ArrayList<>());

        // 2. 각 집과 선택된 피자집과의 거리 합 구하기
        for (List<Point> list : pizzaList) {
            int sum = 0;
            for (Point house : houses) {
                int distance = Integer.MAX_VALUE;
                for (Point pizza : list) {
                    distance = Math.min(distance, Math.abs(house.x - pizza.x) + Math.abs(house.y - pizza.y));
                }
                sum += distance;
            }
            answer = Math.min(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        maxPizza = sc.nextInt();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int type = sc.nextInt();
                if (type == 1) houses.add(new Point(i, j));
                else if (type == 2) pizzas.add(new Point(i, j));
            }
        }

        System.out.println(solution());
    }
}
