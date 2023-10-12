package 문제01.문자찾기;

import java.util.Scanner;

//public class FindingCharacters {
//    public static void main(String[] args) {
//        int answer = 0;
//        Scanner sc = new Scanner(System.in);
//
//        String str = sc.nextLine();
//        String target = (sc.nextLine()).toLowerCase();
//        String[] chars = str.split("");
//
//        for(String c : chars) {
//            if((c.toLowerCase()).equals(target)) answer++;
//        }
//
//        System.out.println(answer);
//    }
//}

public class FindingCharacters {
    public static int solution(String str, char c) {
        int ansewer = 0;
        str = str.toLowerCase();
        c = Character.toLowerCase(c);

        for(char x : str.toCharArray()) {
            if(x == c) ansewer++;
        }

        return ansewer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);

        System.out.println(solution(str, c));
    }
}