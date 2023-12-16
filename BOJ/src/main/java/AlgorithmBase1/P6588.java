package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P6588 {
    private static int[] isPrime = new int[1000000];
    private static List<Integer> oddPrimeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        getPrime();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n;

            while(0 != (n = Integer.parseInt(br.readLine()))) {
                goldbach(n, sb);
            }

            System.out.println(sb);
        }
    }

    private static void getPrime() {
        isPrime[1] = 1;

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i] == 0) {
                if(i%2 != 0) oddPrimeList.add(i);
                int n = i * 2;

                while (n < isPrime.length) {
                    isPrime[n] = 1;
                    n += i;
                }
            }
        }
    }

    private static String goldbach(int n, StringBuilder sb) {
        for(int i = 0; i< oddPrimeList.size(); i++) {
            int a = oddPrimeList.get(i);
            int b = n - a;

            if(a > n/2) break;
            if(isPrime[b] == 0) {
                sb.append(n).append(" = ").append(a).append(" + ").append(b).append("\n");
                break;
            }
        }

        return "Goldbach's conjecture is wrong.\n";
    }
}