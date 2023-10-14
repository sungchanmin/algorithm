package HandlingString.no05;

import java.util.Scanner;

public class FlippingCertainCharacters {
    public static String solution(char[] arr) {
        String answer = "";
        for(int i=0; i<arr.length; i++) {
            char c = arr[i];
            if(Character.isAlphabetic(c)) {
                answer += arr[arr.length - i - 1];
            } else {
                answer += c;
            }
        }

        return answer;
    }

    public static String solution2(char[] arr) {
        int lt = 0, rt = arr.length - 1;
        while(lt < rt) {
            if(!Character.isAlphabetic(arr[lt])) lt++;
            else if(!Character.isAlphabetic(arr[rt])) rt--;
            else {
                char temp = arr[rt];
                arr[rt] = arr[lt];
                arr[lt] = temp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        System.out.println(solution(str));
        System.out.println(solution2(str));
    }
}
