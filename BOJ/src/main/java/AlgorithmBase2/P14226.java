package AlgorithmBase2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14226 {
    // BOJ 14226 이모티콘
    private static int N;
    private static boolean[][] check = new boolean[2000][2000];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        System.out.println(BFS());
    }

    private static int BFS() {
        int time = 0;
        Queue<Emoticon> Q = new LinkedList<>();

        check[1][0] = true;
        Q.add(new Emoticon(1, 0));

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Emoticon e = Q.poll();

                if (e.screen == N) return time;

                if (e.screen < N) {
                    if (e.board == 0) Q.add(new Emoticon(e.screen, 1));
                    else {
                        if (e.screen + e.board < 2000 && !check[e.screen + e.board][e.board]) {
                            check[e.screen + e.board][e.board] = true;
                            Q.add(new Emoticon(e.screen + e.board, e.board));
                        }
                        Q.add(new Emoticon(e.screen, e.screen));

                    }
                }
                if(e.screen -1 >= 0) {
                    Q.add(new Emoticon(e.screen - 1, e.board));
                }
            }

            time++;
        }

        return time;
    }

    private static class Emoticon {
        int screen;
        int board;

        public Emoticon(int screen, int board) {
            this.screen = screen;
            this.board = board;
        }
    }
}
