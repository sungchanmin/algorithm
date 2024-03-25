package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P2146 {
    // BOJ 2146 다리 만들기
    private static int N;
    private static int answer = Integer.MAX_VALUE;
    private static boolean[][] visitLand;
    private static boolean[][] visitSea;
    private static boolean[][] sameLand;

    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visitLand = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && !visitLand[i][j]) {
                    answer = Math.min(answer, solution(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    /**
     * 현재 땅과 연결된 모든 육지(섬 영역)를 찾고(BFS), 다른 섬과의 최소 거리를 반환한다.
     * @return 현재 섬과 다른 섬 사이의 최소 거리
     */
    private static int solution(int x, int y) {
        sameLand = new boolean[N][N];
        sameLand[x][y] = true;
        visitLand[x][y] = true;

        Queue<Position> Q = new LinkedList<>();
        Q.add(new Position(x, y, 0));

        // 섬 영역 찾기
        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Position p = Q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visitLand[nx][ny]) {
                        if (map[nx][ny] == 1) {
                            visitLand[nx][ny] = true;
                            sameLand[nx][ny] = true;
                            Q.add(new Position(nx, ny, 0));
                        }
                    }
                }
            }
        }

        int dis = Integer.MAX_VALUE;

        // 섬과 다른 섬 사이의 최소 거리 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sameLand[i][j]) dis = Math.min(dis, findDis(i, j));
            }
        }

        return dis;
    }

    /**
     * 현재 섬과 다른 섬사이의 최소 거리를 찾는다(BFS).
     * @return 최소 거리
     */
    private static int findDis(int x, int y) {
        visitSea = new boolean[N][N];

        Queue<Position> Q = new LinkedList<>();
        Q.add(new Position(x, y, 0));

        int dis = Integer.MAX_VALUE;

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                Position p = Q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    // 다음 좌표가 현재 섬과 같은 땅이 아니면서, 바다인 경우 거리를 1 추가하고 Q에 넣는다.
                    // 다음 좌표가 현재 섬과 같은 땅이 아니면서, 육지인 경우 최소 거리를 갱신한다.
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (!sameLand[nx][ny]) {
                            if (map[nx][ny] == 0 && !visitSea[nx][ny]) {
                                visitSea[nx][ny] = true;
                                Q.add(new Position(nx, ny, p.dis + 1));
                            } else if (map[nx][ny] == 1) {
                                dis = Math.min(dis, p.dis);
                            }
                        }
                    }
                }
            }
        }

        return dis;
    }

    private static class Position {
        int x;
        int y;
        int dis;

        public Position(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
