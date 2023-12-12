package AlgorithmBase1;

import java.util.Scanner;

public class P10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = new int[26];

        for(char c : str.toCharArray()) arr[c - 97]++;
        for(int i : arr) System.out.print(i + " ");
    }
}