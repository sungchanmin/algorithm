package chapter10.DynamicProgramming.no93;

import java.util.Scanner;

public class CoingExchange_Knapsack {
    private static int solution(int[] coins, int change) {
       int[] dy = new int[change + 1];

       for(int i=0; i<=change; i++) dy[i] = i;

       for(int i=1; i<coins.length; i++) {
           int coin = coins[i];

           for(int j=coin; j<=change; j++) {
               dy[j] = Math.min(dy[j], dy[j-coin] + 1);
           }
       }

       return dy[change];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];

        for(int i=0; i<n; i++) coins[i] = sc.nextInt();

        int change = sc.nextInt();
        System.out.println(solution(coins, change));
    }
}
