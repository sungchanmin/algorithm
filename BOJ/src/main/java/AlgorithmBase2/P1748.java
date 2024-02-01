package AlgorithmBase2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1748 {
	// BOJ 1748 수 이어 쓰기 1
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int mod = 10;
		int len = 1;
		int cnt = 0;

		for(int num=1; num<=N; num++) {
			// 자릿수가 바뀌지는 경우를 체크
			if(num % mod == 0) {
				len++;
				mod *= 10;
			}
			cnt += len;
		}
		
		System.out.println(cnt);
	}
}
