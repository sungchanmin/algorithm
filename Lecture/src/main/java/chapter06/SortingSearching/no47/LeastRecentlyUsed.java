package chapter06.SortingSearching.no47;

import java.util.*;

public class LeastRecentlyUsed {
    private static List<Integer> solution(int n, int[] arr) {
        Queue<Integer> cache = new LinkedList<>();

        for(int i : arr) {
            int l = cache.size();

            for(int j=0; j<l; j++) {
                int work = cache.poll();
                if (work != i) cache.add(work);
            }

            if(cache.size() >= n) cache.remove();
            cache.add(i);
        }

        List<Integer> answer = new ArrayList<>(cache);
        Collections.reverse(answer);
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];

        for(int i=0; i<m; i++) arr[i] = sc.nextInt();

        List<Integer> cache = solution(n, arr);

        for(Integer i : cache) System.out.print(i + " ");
    }
}
