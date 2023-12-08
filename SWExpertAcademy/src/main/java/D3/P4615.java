package D3;

import java.util.Scanner;

public class P4615 {
    // 4615. 재미있는 오셀로 게임
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] board = new int[N][N];
            initializeBoard(board, N);

            for (int i = 0; i < M; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                int color = sc.nextInt();
                placeStone(board, x, y, color);
            }

            int[] result = countStones(board, N);
            System.out.println("#" + test_case + " " + result[0] + " " + result[1]);
        }
    }

    private static void initializeBoard(int[][] board, int N) {
        int mid = N / 2;
        board[mid - 1][mid - 1] = 2;
        board[mid - 1][mid] = 1;
        board[mid][mid - 1] = 1;
        board[mid][mid] = 2;
    }

    private static void placeStone(int[][] board, int x, int y, int color) {
        int size = board.length;
        board[x][y] = color;

        int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};

        for (int dir = 0; dir < 8; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            while (nx >= 0 && ny >= 0 && nx < size && ny < size && board[nx][ny] != 0) {
                if (board[nx][ny] == color) {
                    int flipX = x + dx[dir];
                    int flipY = y + dy[dir];

                    while (flipX != nx || flipY != ny) {
                        board[flipX][flipY] = color;
                        flipX += dx[dir];
                        flipY += dy[dir];
                    }
                    break;
                }

                nx += dx[dir];
                ny += dy[dir];
            }
        }
    }

    private static int[] countStones(int[][] board, int N) {
        int blackCount = 0;
        int whiteCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    blackCount++;
                } else if (board[i][j] == 2) {
                    whiteCount++;
                }
            }
        }

        return new int[]{blackCount, whiteCount};
    }
}