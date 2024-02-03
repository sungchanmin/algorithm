import java.io.*;
import java.util.*;

public class Main {
	// BOJ 10972 다음 순열
	static int n;
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력을 받는다.
		// n과 nums[] 는 static으로 선언
		n = Integer.parseInt(st.nextToken());
		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// 다음 순열이 있는지 확인하고 있으면 출력한다.
		// 없으면 -1을 출력한다.
		if (hasNextPerm()) {
			StringBuilder sb = new StringBuilder();
			for (int i : nums) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
		br.close();
	}

	/**
	 * 가장 큰 수다 => 모든 수가 내림차순이다.
	 * 다음 순열이 있다 => 지금 이 수보다 더 큰 수가 있다. => 내림차순이 아니다.
	 */
	private static boolean hasNextPerm() {
		// 1. 순열을 뒤에서부터 찾으면서 오름차순이 되는 지점을 찾는다.
		// nums[i -1] < nums[i] 인 지점
		// 만약 오름차순이 되는 지점이 없다면 가장 큰 수이므로 false를 리턴한다.
		int i = nums.length - 1;
		// 다른 풀이에서는 nums[i - 1] >= nums[i] 라고 해두었지만 여기에서는 숫자가 모두 다 다르기에 등호는 뺐다.
		while (i > 0 && nums[i - 1] > nums[i]) i--;
		// 다른 풀이에서는 i <= 0 으로 되어있지만 나는 0보다 작아질 수는 없다고 생각해서 이렇게 표현해봤다.
		if (i == 0) return false;

		// 2. nums[i - 1]과 맞바꾸면 그 다음 수로 커질 수 있는 idx를 찾는다.
		// i까지는 모두 내림차순이었을 테니 다시 뒤에서부터 찾으면서
		// nums[i - 1]보다는 큰 idx j를 찾는다.
		int j = nums.length - 1;
		while (nums[i - 1] > nums[j]) j--;

		// 3. i와 j를 swap 한다.
		swap(i - 1, j);

		// 4. i-1 부터 있는 순열이 모두 내림차순 일테니 이를 오름차순으로 뒤집는다.
		j = nums.length - 1;
		while (i < j) {
			swap(i, j);
			i++; j--;
		}
		return true;
	}

	private static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}