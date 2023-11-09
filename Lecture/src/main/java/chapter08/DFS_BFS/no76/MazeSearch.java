package chapter08.DFS_BFS.no76;

import java.util.Scanner;

public class MazeSearch {
    private static final int SIZE = 7;
    private static int[][] maze = new int[SIZE][SIZE];
    private static int DFS(int x, int y) {
        if(x == SIZE-1 && y == SIZE-1) return 1;
        int moveUp=0, moveDown=0, moveRight=0, moveLeft=0;

        if(x+1 < SIZE && maze[x+1][y] == 0) {
            maze[x+1][y] = 1;
            moveDown = DFS(x+1, y);
            maze[x+1][y] = 0;
        }
        if(y-1 >=0 && maze[x][y-1] == 0) {
            maze[x][y-1] = 1;
            moveRight = DFS(x, y-1);
            maze[x][y-1] = 0;
        }
        if(x-1 >= 0 && maze[x-1][y] == 0) {
            maze[x-1][y] = 1;
            moveUp = DFS(x-1, y);
            maze[x-1][y] = 0;
        }
        if(y+1 < SIZE && maze[x][y+1] == 0) {
            maze[x][y+1] = 1;
            moveLeft = DFS(x, y+1);
            maze[x][y+1] = 0;
        }

        return moveUp + moveDown + moveRight + moveLeft;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze.length; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        maze[0][0] = 1;
        System.out.println(DFS(0, 0));
    }
}
