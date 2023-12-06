package AlgorithmBase1;

import java.util.Scanner;

public class P9093 {
    private static Scanner sc = new Scanner(System.in);
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int n = Integer.parseInt(sc.nextLine());

        for(int i=0; i<n; i++) {
            System.out.println(reverse(sc.nextLine()));
            sb.setLength(0);
        }
    }

    private static StringBuilder reverse(String str) {
        String[] strArr = str.split(" ");

        for(String s : strArr) {
            sb.append(new StringBuilder(s).reverse());
            sb.append(" ");
        }

        return sb;
    }
}
