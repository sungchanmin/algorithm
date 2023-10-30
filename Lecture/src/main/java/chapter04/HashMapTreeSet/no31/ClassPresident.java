package chapter04.HashMapTreeSet.no31;

import java.util.HashMap;
import java.util.Scanner;

public class ClassPresident {
    private static String solution(int n, String str) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++ ) {
            int x = 0;
            String s = String.valueOf(str.charAt(i));
            if(map.containsKey(s)) x = map.get(s);
            map.put(s, ++x);
        }

        for(String key : map.keySet()) {
            if(map.get(key) > max) {
                answer = key;
                max = map.get(key);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        System.out.println(solution(n, str));
    }
}
