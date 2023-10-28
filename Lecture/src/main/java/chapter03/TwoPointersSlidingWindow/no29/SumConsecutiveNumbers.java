package chapter03.TwoPointersSlidingWindow.no29;

import java.util.Scanner;

public class SumConsecutiveNumbers {
    private static int solution(int n) {
        int answer = 0, sum, r = 1, l = 1;

        while(r < n) {
            sum = 0;

            for(int i=l; i<=r; i++) {
                sum += i;
            }

            if(sum == n) {
                answer++;
                r++;
            }
            else if(sum < n) {
                r++;
            } else l++;
        }

        return answer;
    }

    private static int solution2(int n) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
