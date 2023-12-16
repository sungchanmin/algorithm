import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc =  new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] prime = new int[1001];
        String[] arr = sc.nextLine().split(" ");

        getPrime(prime);
        System.out.println(countPrime(arr, prime));
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

    private static int countPrime(String[] arr, int[] prime) {
        int cnt = 0;

        for(String s : arr) {
            if(prime[Integer.parseInt(s)] == 0) cnt++;
        }

        return cnt;
    }
}