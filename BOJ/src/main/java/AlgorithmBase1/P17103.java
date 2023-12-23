package AlgorithmBase1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P17103 {
    private static int[] isPrime = new int[1000000];
    private static List<Integer> prime = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        getPrime();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) sb.append(solution(sc.nextInt())).append("\n");
        System.out.println(sb);
    }

    private static void getPrime() {
        isPrime[0] = isPrime[1] = 1;

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i] == 0) {
                prime.add(i);
                int num = i * 2;

                while (num < isPrime.length) {
                    isPrime[num] = 1;
                    num += i;
                }
            }
        }
    }

    private static int solution(int n) {
        int cnt = 0;

        for (int i : prime) {
            if (i >= n) break;
            if (isPrime[n - i] == 0) {
                if (i == n - i) cnt += 2;
                else cnt++;
            }
        }

        return cnt / 2;
    }
}