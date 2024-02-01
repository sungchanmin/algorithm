package AlgorithmBase2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15650 {
	// BOJ 15650 N과 M (2)
	private static int N, M;
	private static boolean[] ch;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		
		N = Integer.parseInt(strArr[0]);
		M = Integer.parseInt(strArr[1]);
		ch = new boolean[N + 1];
		
		solution(1, M, "");
		System.out.println(sb);
	}
	
	private static void solution(int n, int len, String str) {
		if(len == 0) {
			sb.append(str).append("\n");
			return;
		}
		
		for(int i=n; i<=N; i++) {
			if(ch[i] == false) {
				ch[i] = true;
				solution(i+1, len-1, str + i + " ");
				ch[i] = false;
			}
		}
	}
}
