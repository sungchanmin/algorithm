package AlgorithmBase1;

import java.io.IOException;
import java.util.Scanner;

public class P1929 {
    public static void main(String[] args) throws IOException {
        Scanner sc =  new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] prime = new int[b + 1];

        getPrime(prime);
        countPrime(a, b, prime);
    }

    private static void getPrime(int[] arr) {
        arr[1] = 1;

        for(int i=2; i<arr.length; i++) {
            if(arr[i] == 0) {
                int n = i * 2;

                while(n < arr.length) {
                    arr[n] = 1;
                    n += i;
                }
            }
        }
    }

    private static void countPrime(int a, int b, int[] prime) {
        StringBuilder sb = new StringBuilder();

        for(int i=a; i<=b; i++) {
            if(prime[i] == 0) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}