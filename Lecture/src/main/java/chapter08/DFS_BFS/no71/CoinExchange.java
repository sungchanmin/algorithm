package chapter08.DFS_BFS.no71;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CoinExchange {
    private static int change;
    private static int BFS(int[] coins) {
        int answer = 0;
        int maxCoin = Arrays.stream(coins).max().getAsInt();
        Queue<Integer> Q = new LinkedList<>();
        Q.add(0);

        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                int sum = Q.poll();
                if(change - maxCoin > sum) {
                    Q.add(sum + maxCoin);
                } else {
                    for(int j=0; j<coins.length; j++) {
                        if(sum + coins[j] == change) return ++answer;
                        if(sum + coins[j] < change) Q.add(sum + coins[j]);
                    }
                }
            }
            answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];

        for(int i=0; i<n; i++) coins[i] = sc.nextInt();

        change = sc.nextInt();

        System.out.println(BFS(coins));
    }
}
