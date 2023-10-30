package chapter04.HashMapTreeSet.no32;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    private static boolean solution(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : str1.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        for(char c : str2.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) <= 0) return false;
            else map.merge(c, -1, Integer::sum);
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(solution(str1, str2) ? "YES" : "NO");
    }
}
