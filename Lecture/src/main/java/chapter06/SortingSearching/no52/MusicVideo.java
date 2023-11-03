package chapter06.SortingSearching.no52;

import java.util.Scanner;

public class MusicVideo {
    private static int solution(int m, int[] arr) {
        int size = 0;

        for(int i : arr) size = Math.max(size, i);

        while (true) {
            int sum = 0;
            int cnt = m;

            for(int i=0; i<arr.length; i++) {
                sum += arr[i];

                if(sum > size) {
                    i--;
                    sum = 0;
                    cnt--;
                    if(cnt < 0) break;
                }
            }

            if(cnt < 0) size ++;
            else if(cnt == 0 && sum > 0) {
                size++;
            } else break;
        }

        return size;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        System.out.println(solution(m, arr));
    }
}
