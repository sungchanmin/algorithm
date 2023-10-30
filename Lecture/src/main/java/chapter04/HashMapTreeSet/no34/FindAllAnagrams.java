package chapter04.HashMapTreeSet.no34;

import java.util.HashMap;
import java.util.Scanner;

public class FindAllAnagrams {
    private static int solution(char[] str1, char[] str2) {
        int answer = 0;
        boolean anagram;
        HashMap<Character, Integer> map = new HashMap<>();

        for(char s : str2) map.merge(s, 1, Integer :: sum);

        for(int i=0; i<str1.length - str2.length + 1; i++) {
            HashMap<Character, Integer> compare = new HashMap<>(map);
            anagram = true;

            for(int j=0; j<str2.length; j++) {
                if (!compare.containsKey(str1[i + j]) || compare.get(str1[i + j]) <= 0) {
                    anagram = false;
                    break;
                }
                compare.merge(str1[i + j], -1, Integer :: sum);
            }

            if(anagram) answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr1 = sc.nextLine().toCharArray();
        char[] arr2 = sc.nextLine().toCharArray();
        System.out.println(solution(arr1, arr2));
    }
}
