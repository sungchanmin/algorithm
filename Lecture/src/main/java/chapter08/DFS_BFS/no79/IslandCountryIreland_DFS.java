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
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<size && ny>=0 && ny<size && world[nx][ny]==1)
                DFS(nx, ny);
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
