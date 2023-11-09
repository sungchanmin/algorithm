package chapter08.DFS_BFS.no74;

import java.util.Scanner;

public class GuessTheSequence {
    private static int n, m, C[][], nums[], coms[], answer[];

    private static int combination(int n, int r) {
        if(n == r || r == 0) return 1;
        if(r == 1) return n;
        if(C[n][r] == 0) C[n][r] = combination(n-1, r-1) + combination(n-1 , r);
        return C[n][r];
    }
    private static boolean DFS(int L) {
        if (L == n) {
            int sum = 0;
            for(int i=0; i<n; i++) sum += coms[i] * answer[i];
            if(sum == m) return true;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    answer[L] = i + 1;
                    nums[i] = 1;
                    if(DFS(L+1)) return true;
                    nums[i] = 0;
                }
            }
        }
        return false;
    }
    private static void solution() {
        nums = new int[n];
        coms = new int[n];
        answer = new int[n];

        for(int i=0; i<=n-1; i++) {
            coms[i] = combination(n-1, i);
        }
        DFS(0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        C = new int[n+1][n+1];
        solution();

        for(int i : answer) System.out.print(i + " ");
    }
}
