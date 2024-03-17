import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // BOJ 16929 Two Dots
    private static int N;
    private static int M;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static char[][] arr;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = br.readLine().split(" ");
        N = Integer.parseInt(strArr[0]);
        M = Integer.parseInt(strArr[1]);
        arr = new char[N][M];

        for (int i = 0; i < N; i++) arr[i] = br.readLine().toCharArray();

        System.out.println(solution() ? "Yes" : "No");
    }

    private static boolean solution() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visit[i][j] && BFS(i, j)) return true;
            }
        }

        return false;
    }

    private static boolean BFS(int i, int j) {

    }

    private static class Postion {
        int x;
        int y;

        public Postion(int x, int y) {

        }
    }
}