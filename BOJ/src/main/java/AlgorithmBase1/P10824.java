package AlgorithmBase1;

import java.io.IOException;
import java.util.Scanner;

public class P10824 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");

        long AB = Long.parseLong(strArr[0] + strArr[1]);
        long CD = Long.parseLong(strArr[2] + strArr[3]);

        System.out.println(AB + CD);

    }
}
