package chapter05.StackQueue.no38;

import java.util.*;

public class CraneDollPulling {
    private static int solution(List<Queue<Integer>> board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();

        for(int i : moves) {
            int doll = 0;

            if(!board.get(i-1).isEmpty()) {
                doll = board.get(i-1).poll();
            }

            if(doll != 0) {
                if(bucket.empty() || bucket.peek() != doll) bucket.push(doll);
                else {
                    bucket.pop();
                    answer += 2;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Queue<Integer>> board = new ArrayList<>();

        for(int i=0; i<n; i++) board.add(new LinkedList<>());

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int input = sc.nextInt();
                if(input !=0) {
                    board.get(j).add(input);
                }
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];

        for(int i=0; i<m; i++) moves[i] = sc.nextInt();

        System.out.println(solution(board, moves));
    }
}
