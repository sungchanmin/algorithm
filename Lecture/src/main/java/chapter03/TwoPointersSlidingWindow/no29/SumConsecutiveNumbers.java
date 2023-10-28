package chapter03.TwoPointersSlidingWindow.no29;

import java.util.Scanner;

public class SumConsecutiveNumbers {
    private static int solution(int n) {
        int answer = 0, sum = 0, r = 1, l = 1;

        while(r < n) {
            if(sum == n) {
                answer++;
                sum += r++;
            } else if(sum < n) {
                sum += r++;
            }
            else {
                sum -= l++;
            }
        }

        return answer;
    }

    private static int solution2(int n) {
        int answer = 0;

        for(int i=2; i<n/2 - 1; i++) {
            int sum = (i * (i + 1) / 2);
            if(sum > n) break;
            if((n - sum) % i == 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
