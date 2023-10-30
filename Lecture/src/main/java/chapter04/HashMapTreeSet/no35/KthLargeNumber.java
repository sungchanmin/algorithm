package chapter04.HashMapTreeSet.no35;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class KthLargeNumber {
    private static int solution(int n, int m, Integer[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> dupCheck = new HashMap<>();

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(!dupCheck.containsKey(sum)) {
                        dupCheck.put(sum, sum);
                        list.add(sum);
                    }
                }
            }
        }

        Collections.sort(list);
        Collections.reverse(list);

        if(list.size() < m) return -1;
        return list.get(m - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Integer[] arr = new Integer[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }
}
