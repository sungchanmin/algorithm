package D3;

import java.util.Scanner;

public class P2805 {
    // 2805. 농작물 수확하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(sc.nextLine());
            int lt = n/2, rt = n/2;
            int sum = 0;

            for(int i=0; i<n; i++) {
                String[] strArr = sc.nextLine().split("");
                for(int j=0; j<n; j++) {
                    if(lt <= j && j <= rt) sum += Integer.parseInt(strArr[j]);
                }
                if(i < n/2) {
                    lt--;
                    rt++;
                } else {
                    lt++;
                    rt--;
                }
            }
            System.out.println("#" + test_case + " " + sum);
        }
    }
}
