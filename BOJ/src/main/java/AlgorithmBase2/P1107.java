package AlgorithmBase2;

import java.util.Arrays;
import java.util.Scanner;

public class P1107 {
    // BOJ 1107 리모컨
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ch = sc.nextInt();
        int n = sc.nextInt();

        boolean num[] = new boolean[10];
        Arrays.fill(num, true);

        for(int i=0; i<n; i++) num[sc.nextInt()] = false;

        // 주어진 숫자로 갈 수 있는 채널 목록
        boolean[] arr = new boolean[1_000_001];
        Arrays.fill(arr, true);

        for(int i=0; i<=1_000_000; i++) {
            boolean flag = true;
            String str = String.valueOf(i);

            for(int j=0; j<10; j++) {
                if(!num[j] && str.contains(String.valueOf(j))) {
                    flag = false;
                    break;
                }
            }

            arr[i] = flag;
        }

        // 가장 근접한 채널 찾기
        int nearCh = Integer.MAX_VALUE;

        for(int i=0; i<=1_000_000; i++) {
            if(arr[i] && i<= ch) nearCh = i;
            else if(arr[i]) {
                nearCh = Math.abs(ch - nearCh) <= Math.abs(ch - i)? nearCh : i;
                break;
            }
        }

        int move = String.valueOf(nearCh).length();
        move += Math.abs(ch - nearCh);

        System.out.println(Math.min(Math.abs(100 - ch), Math.abs(move)));
    }
}
