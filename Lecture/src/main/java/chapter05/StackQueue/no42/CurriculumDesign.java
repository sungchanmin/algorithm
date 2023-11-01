package chapter05.StackQueue.no42;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CurriculumDesign {
    private static String solution(String str1, String str2) {
        Queue<Character> Q = new LinkedList<>();

        for(char c : str1.toCharArray()) {
            Q.add(c);
        }

        for(char c : str2.toCharArray()) {
            if(Q.isEmpty()) return "YES";
            else if(Q.peek() == c ) Q.remove();
        }

        return "NO";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(solution(str1, str2));
    }
}
