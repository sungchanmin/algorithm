package AlgorithmBase1;

import java.util.Scanner;

public class P11005 {
    private static int SIZE = 36;
    private static char[] notations = new char[SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        getNotation();
        System.out.println(solution(n, b));
    }

    private static void getNotation() {
        for (int i = 0; i < 10; i++) notations[i] = Character.forDigit(i, 10);
        for (int i = 10; i < SIZE; i++) notations[i] = (char) ('7' + i);
    }

    private static StringBuilder solution(int n, int b) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(notations[n % b]);
            n = n / b;
        }

        return sb.reverse();
    }
}