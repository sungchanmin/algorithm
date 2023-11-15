package D2;

import java.util.Base64;
import java.util.Scanner;

public class P1928_2 {
    // 1928. Base64 Decoder
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int test_case=1; test_case<=T; test_case++)
            System.out.println("#" + test_case + " " + new String(Base64.getDecoder().decode(sc.nextLine())));
    }
}