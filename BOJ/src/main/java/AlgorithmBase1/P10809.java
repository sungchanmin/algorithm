package AlgorithmBase1;

import java.util.Arrays;
import java.util.Scanner;

public class P10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for(int i=0; i<str.length(); i++) {
            int index = str.charAt(i) - 97;
            if(arr[index] == -1) arr[index] = i;
        }
        for(int i : arr) System.out.print(i + " ");
    }
}