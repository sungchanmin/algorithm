package chapter07.RecursiveTreeGraph.no59;

import java.util.Scanner;

public class FindSubsets {
    private static int[] ch;
    private static void DFS(int n) {
        if(n == ch.length) {
            String str = "";

            for(int i=0; i<ch.length; i++) {
                if(ch[i] == 1) str+=i;
            }

            if(!str.equals("")) System.out.println(str);

        } else {
            ch[n] = 1;
            DFS(n+1);
            ch[n] = 0;
            DFS(n+1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ch = new int[n + 1];
        DFS(1);
    }
}
