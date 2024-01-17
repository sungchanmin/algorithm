import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        String[] strArr = br.readLine().split(" ");

        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(strArr[i]);

        Arrays.fill(dp, 1);

        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(arr[j] > arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
