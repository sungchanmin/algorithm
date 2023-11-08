package chpater08.DFS_BFS.no78;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {
    private static Queue<RipeTomato> Q = new LinkedList<>();
    private static class RipeTomato {
        int x, y;

        public RipeTomato(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void ripen(int[][] box) {
            if(x-1>=0 && box[x-1][y] == 0) {
                box[x-1][y] = 1;
                Q.add(new RipeTomato(x-1, y));
            }
            if(x+1<box.length && box[x+1][y] == 0) {
                box[x+1][y] = 1;
                Q.add(new RipeTomato(x+1, y));
            }
            if(y-1>=0 && box[x][y-1] == 0) {
                box[x][y-1] = 1;
                Q.add(new RipeTomato(x, y-1));
            }
            if(y+1<box[0].length && box[x][y+1] == 0) {
                box[x][y+1] = 1;
                Q.add(new RipeTomato(x, y+1));
            }
        }
    }
    private static int solution(int[][] box) {
        int answer = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Q.poll().ripen(box);
            }
            answer++;
        }

        for(int i=0; i<box.length; i++){
            for(int j=0; j<box[0].length; j++) {
                if(box[i][j] == 0) return -1;
            }
        }

        return answer - 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] box = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++)
            {
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1) Q.add(new RipeTomato(i, j));
            }
        }

        System.out.println(solution(box));
    }
}
