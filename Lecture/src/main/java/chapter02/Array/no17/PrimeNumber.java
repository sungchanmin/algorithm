package chapter02.Array.no17;

import java.util.Scanner;

public class PrimeNumber {
    private static int solution(int n) {
        int answer = 0;
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

        for(int i : numbers) {
            if(i != 0) answer++;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
