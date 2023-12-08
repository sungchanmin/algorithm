import java.util.Scanner;

        public class Solution {
            // 5215. 햄버거 다이어트
            private static int n, max;
            private static int[] happy, kcal;

            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int T = Integer.parseInt(sc.nextLine());

                for (int test_case = 1; test_case <= T; test_case++) {
                    n = sc.nextInt();
                    max = sc.nextInt();

                    happy = new int[n];
                    kcal = new int[n];

                    for(int i=0; i<n; i++) {
                        happy[i] = sc.nextInt();
                        kcal[i] = sc.nextInt();
                    }


                    System.out.println("#" + test_case + " " + DFS(0, 0, 0));
                }
            }

            private static int DFS(int i, int sumKcal, int sumHappy) {
                if(i >= n) return sumHappy;
                int a = 0, b = 0;

                sumKcal += kcal[i];
                sumHappy += happy[i];
                if(sumKcal <= max) {
                    a = DFS(i + 1, sumKcal, sumHappy);
                }

                sumKcal -= kcal[i];
                sumHappy -= happy[i];
                b = DFS(i + 1, sumKcal, sumHappy);

                return Math.max(sumHappy, Math.max(a, b));
            }
}
