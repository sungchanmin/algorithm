package D2;

import java.util.Scanner;

public class P1926 {
    // 1926. 간단한 369게임
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            if(is369(i)) System.out.print(" ");
            else System.out.print(i + " ");
        }
    }

    private static boolean is369 (int n) {
        boolean find = false;
        String str = String.valueOf(n);
        for(char c : str.toCharArray()) {
            if(c == '3' || c == '6' || c == '9') {
                System.out.print("-");
                find = true;
            }
        }
        return find;
    }
}
