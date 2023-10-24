package chapter01.HandlingString.no10;

import java.util.Scanner;

public class ShortestCharacterDistance {
    private static int[] solution(String str, char c) {
        char[] chars = str.toCharArray();
        int[] answer = new int[str.length()];

        for(int i=0; i<chars.length; i++) {
            int d = Integer.MAX_VALUE;

            for(int j=0; j<chars.length; j++) {
                if(chars[i] == c) {
                    d = 0;
                    break;
                }
                else if(chars[j] == c ) {
                    if(i>j && i - j < d) d = i - j;
                    else if(i<j && j - i < d) d = j - i;
                }
            }

            answer[i] = d;
        }

        return answer;
    }

    private static int[] solution2(String str, char c) {
        int[] answer = new int[str.length()];
        int p = 1000;
        int len = str.length();

        for(int i=0; i<len; i++) {
            if(str.charAt(i) == c) {
                p = 0;
            } else {
                p++;
            }
            answer[i] = p;
        }

        p = 1000;

        for(int i=0; i<len; i++) {
            if(str.charAt(len - i -1) == c) {
                p = 0;
            } else {
                p++;
            }
            answer[len - i -1] = Math.min(answer[len - i -1 ], p);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");

        int[] answer = solution2(strs[0], strs[1].charAt(0));

        for(int i=0; i<answer.length - 1; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.print(answer[answer.length - 1]);
    }
}
