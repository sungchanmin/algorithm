package AlgorithmBase2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10973 {
    // BOJ 10973 이전 순열
    private static int N;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution();
    }

    private static void solution() {
        int index = -1;

        // 뒤에서부터 오름차순 정렬이 아닌 index를 찾는다.
        for (int i = N - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {
            // 만약 모든 수가 오름차순 정렬이라면, 그 이전 순열이 존재하지 않는다.
            System.out.println(index);
        } else {
            int value = Integer.MIN_VALUE;
            int target = -1;

            // index 다음 위치의 오름차순으로 정렬된 수 중에서 arr[index] 다음으로 작은 수를 찾는다.
            for (int i = index + 1; i < N; i++) {
                if (arr[index] > arr[i] && value < arr[i]) {
                    target = i;
                    value = arr[i];
                }
            }

            // 해당 두 수를 교환한다.
            swap(index, target);
            // index 이후 수를 내림차순으로 정렬한다.
            order(index);

            for(int i : arr) sb.append(i).append(" ");
            System.out.println(sb.toString().trim());
        }
    }

    private static void swap(int index, int target) {
        int tmp = arr[index];
        arr[index] = arr[target];
        arr[target] = tmp;
    }

    private static void order(int index) {
        int[] subArr = Arrays.copyOfRange(arr, index + 1, N);
        Arrays.sort(subArr);
        for(int i = index + 1; i<N; i++) arr[i] = subArr[subArr.length - i + index];
    }
}
