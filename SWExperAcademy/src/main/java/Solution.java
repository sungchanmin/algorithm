import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        // 1204. 최빈수 구하기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++ ) {
            int[] arr = new int[101];
            int m = sc.nextInt();
            int index = 0;

            for(int j=0; j<1000; j++) arr[sc.nextInt()]++;

            for(int j=0; j<arr.length; j++) {
                if(arr[j] > arr[index]) index = j;
            }

            System.out.println("#" + m + " " + arr[index]);
         }
    }
}
