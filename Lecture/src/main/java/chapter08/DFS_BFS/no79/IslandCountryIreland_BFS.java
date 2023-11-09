package chapter08.DFS_BFS.no79;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IslandCountryIreland_BFS {
    private static int size;
    private static int[][] world;
    private static int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
    private static int[] dy = {0, 1, 0, -1, -1, -1, 1, 1};
    private static class Point {
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));

        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Point island = Q.poll();
                world[island.x][island.y] = 0;

                for(int j=0; j<dx.length; j++) {
                    int mx = island.x + dx[j];
                    int my = island.y + dy[j];
                    if(mx>=0 && mx<size && my>=0 && my<size && world[mx][my]==1)
                        Q.add(new Point(mx, my));
                }
            }
        }
    }
    private static int solution() {
        int answer = 0;

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(world[i][j] == 1) {
                    BFS(i, j);
                    answer++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        world = new int[size][size];

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) world[i][j] = sc.nextInt();
        }

        System.out.println(solution());

    }
}
