package AlgorithmBase1;

import java.io.*;

public class P10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue Q = new Queue(n);


        for(int i=0; i<n; i++) {
            String[] strArr = br.readLine().split(" ");

            switch (strArr[0]) {
                case "push" :
                    Q.push(Integer.parseInt(strArr[1]));
                    break;
                case "pop" :
                    bw.write(Q.pop() + "\n");
                    break;
                case "size" :
                    bw.write(Q.size + "\n");
                    break;
                case "empty" :
                    bw.write(Q.empty() + "\n");
                    break;
                case "front" :
                    bw.write(Q.front() + "\n");
                    break;
                case "back" :
                    bw.write(Q.back() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static class Queue {
        int[] arr;
        int front, back, size;

        public Queue(int max) {
            arr = new int[max];
            front = 0;
            back = 0;
            size = 0;
        }

        public void push(int x) {
            arr[back] = x;
            back++;
            size++;
        }

        public int pop() {
            if(size <= 0) return -1;
            front++;
            size--;
            return arr[front-1];
        }

        public int size() {
            return size;
        }

        public int empty() {
            return size == 0 ? 1 : 0;
        }

        public int front() {
            if (size == 0) return -1;
            return arr[front];
        }

        public int back() {
            if (size == 0) return -1;
            return arr[back-1];
        }
    }
}