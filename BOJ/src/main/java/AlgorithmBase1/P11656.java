package AlgorithmBase1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class P11656 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String str = sc.nextLine();
        String[] strArr = new String[str.length()];

        for(int i=0; i<str.length(); i++) strArr[i] = str.substring(i);
        Arrays.sort(strArr);
        for(String s : strArr) sb.append(s).append("\n");
        System.out.println(sb);
    }
}
