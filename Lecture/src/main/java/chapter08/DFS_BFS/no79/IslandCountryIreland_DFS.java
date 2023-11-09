package chapter08.DFS_BFS.no79;

import java.util.Scanner;

public class IslandCountryIreland_DFS {
    private static int size;
    private static int[][] world;
    private static int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
    private static int[] dy = {0, 1, 0, -1, -1, -1, 1, 1};
    private static void DFS(int x, int y) {
        world[x][y] = 0;

        for(int i=0; i<dx.length; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx>=0 && mx<size && my>=0 && my<size && world[mx][my]==1)
                DFS(mx, my);
        }
    }
    private static int solution() {
        int answer = 0;

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(world[i][j] == 1) {
                    DFS(i, j);
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
