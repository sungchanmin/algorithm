package chapter02.Array.no15;

import java.util.Scanner;

public class RockScissorsPaper {
    private static void solution(int n, String str1, String str2) {
        String[] user1 = str1.split(" ");
        String[] user2 = str2.split(" ");


        for(int i=0; i<n; i++) {
            int result = Integer.parseInt(user1[i]) - Integer.parseInt(user2[i]);
            if(result == 0) System.out.println("D");
            else if(result == -1 || result == 2) System.out.println("B");
            else System.out.println("A");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        solution(n, str1, str2);
    }
}
