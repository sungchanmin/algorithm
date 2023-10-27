package chapter02.Array.no18;

import java.util.Scanner;

public class FlippedPrimeNumber {
    private static int[] primes(int n) {
        int[] numbers = new int[n + 1];

        for(int i=0; i<numbers.length; i++) {
            numbers[i] = i;
        }

        for(int i=2; i<numbers.length; i++) {
            if(numbers[i] != 0) {
                for(int j=i*2; j<numbers.length; j+=i) {
                    numbers[j] = 0;
                }
            }
        }

        return numbers;
    }

    private static String solution(int n, String str) {
        int[] primes = primes(100000);
        String answer = "";
        String[] nums = str.split(" ");

        for(String s : nums) {
            int num = Integer.parseInt(new StringBuilder(s).reverse().toString());

            if (primes[num] != 0 && num != 1) {
                if (!answer.equals("")) answer += " " + num;
                else answer += num;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        System.out.println(solution(n, str));
    }
}
