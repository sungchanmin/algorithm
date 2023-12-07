package AlgorithmBase1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> Q = new LinkedList<>();

        for(int i=1; i<=n; i++) Q.add(i);

        sb.append("<");

        while(!Q.isEmpty()) {
            for(int i=0; i<k-1; i++) Q.add(Q.poll());
            sb.append(Q.poll() + ", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(">");
        System.out.println(sb);
    }
}