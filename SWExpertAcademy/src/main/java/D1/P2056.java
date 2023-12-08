package D1;

import java.util.Scanner;

public class P2056 {
    // 2056. 연원일 달력
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=1; i<=n; i++) {
            String str = sc.nextLine();

            int m = Integer.parseInt(str.substring(4,6));
            int d = Integer.parseInt(str.substring(6,8));

            if(calender(m, d)) {
                System.out.println("#" + i + " " + str.substring(0, 4) + "/" + str.substring(4,6)  + "/" + str.substring(6,8));
            } else System.out.println("#" + i + " -1");
        }
    }

    private static boolean calender(int m, int d) {
        if(1 <= m && m <= 12 && 1 <= d) {
            if(m == 2) return d <= 28;
            else if(m == 4 || m == 6 || m == 9 || m == 11) return d <= 30;
            else return d <= 31;
        }

        return false;
    }
}
