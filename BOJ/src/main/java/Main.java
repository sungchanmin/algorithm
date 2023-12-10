import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            Map<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();

            String[] strArr = br.readLine().split(" ");

            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(strArr[i]);
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            for(int i=0; i<n; i++) {
                while(!stack.isEmpty()) {
                    if(map.get(arr[stack.peek()]) < map.get(arr[i]) && arr[stack.peek()] != arr[i]) {
                        arr[stack.pop()] = arr[i];
                    } else break;
                }
                stack.push(i);
            }

            while(!stack.isEmpty()) {
                arr[stack.pop()] = -1;
            }

            for(int i : arr) bw.write(i + " ");

            bw.flush();
        }
    }
}