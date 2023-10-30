package chapter04.HashMapTreeSet.no33;

import java.util.HashMap;
import java.util.Scanner;

public class TypeOfSales {
    private static String solution(int n, int m, int[] arr) {
        StringBuilder answer = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<m; i++) {
            map.merge(arr[i], 1, Integer :: sum);
        }

        answer.append(map.size()).append(" ");

        for(int i=m; i<n; i++) {
            map.merge(arr[i-m], -1, Integer :: sum);
            if(map.get(arr[i-m]) < 1) map.remove(arr[i-m]);

            map.merge(arr[i], 1, Integer :: sum);
            answer.append(map.size()).append(" ");
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }
}
