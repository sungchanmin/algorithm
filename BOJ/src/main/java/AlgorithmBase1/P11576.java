package AlgorithmBase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] strArr = br.readLine().split(" ");
        int nA = Integer.parseInt(strArr[0]);
        int nB = Integer.parseInt(strArr[1]);
        int n = Integer.parseInt(br.readLine());
        strArr = br.readLine().split(" ");

        System.out.println(solution(nA, nB, n, strArr, sb));
    }

    private static StringBuilder solution(int nA, int nB, int n, String[] strArr, StringBuilder sb) {
        List<Integer> list = new ArrayList<>();
        int num = 0;
        int place = 1;

        for (int i = n - 1; i >= 0; i--) {
            num += place * Integer.parseInt(strArr[i]);
            place *= nA;
        }

        if(num == 0) {
            sb.append('0');
            return sb;
        }

        while(num != 0) {
            list.add(num % nB);
            num /= nB;
        }

        Collections.reverse(list);

        for(int i : list) sb.append(i).append(" ");

        return sb;
    }
}
