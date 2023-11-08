package chpater08.DFS_BFS.no77;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathInMaze {
    private static final int SIZE = 7;
    private static int[][] maze = new int[SIZE][SIZE];
    private static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean moveDown() {
            if(x+1 < SIZE && maze[x+1][y] == 0) {
                maze[x+1][y] = 1;
                return true;
            }
            return false;
        }
        public boolean moveUp() {
            if(x-1 >= 0 && maze[x-1][y] == 0) {
                maze[x-1][y-1] = 1;
                return true;
            }
            return false;
        }
        public boolean moveRight() {
            if(y+1 < SIZE && maze[x][y+1] == 0) {
                maze[x][y+1] = 1;
                return true;
            }
            return false;
        }
        public boolean moveLeft() {
            if(y-1 >= 0 && maze[x][y-1] == 0) {
                maze[x][y-1] = 1;
                return true;
            }
            return false;
        }
    }
    private static int BFS(int x, int y) {
        int answer = 0;
        Queue<Position> Q = new LinkedList<>();
        Q.add(new Position(0, 0));
        maze[0][0] = 1;

        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Position p = Q.poll();
                if(p.x==SIZE-1 && p.y==SIZE-1) return answer;
                if(p.moveDown()) Q.add(new Position(p.x+1, p.y));
                if(p.moveRight()) Q.add(new Position(p.x, p.y+1));
                if(p.moveUp()) Q.add(new Position(p.x-1, p.y));
                if(p.moveLeft()) Q.add(new Position(p.x, p.y-1));
            }
            answer++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze.length; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        System.out.println(BFS(0, 0));
    }
}
