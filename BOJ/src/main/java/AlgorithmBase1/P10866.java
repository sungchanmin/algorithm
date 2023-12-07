package AlgorithmBase1;

import java.io.*;
import java.util.LinkedList;

public class P10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque DQ = new Deque();


        for(int i=0; i<n; i++) {
            String[] strArr = br.readLine().split(" ");

            switch (strArr[0]) {
                case "push_front":
                    DQ.push_front(Integer.parseInt(strArr[1]));
                    break;
                case "push_back":
                    DQ.push_back(Integer.parseInt(strArr[1]));
                    break;
                case "pop_front":
                    bw.write(DQ.pop_front() + "\n");
                    break;
                case "pop_back":
                    bw.write(DQ.pop_back() + "\n");
                    break;
                case "size":
                    bw.write(DQ.size() + "\n");
                    break;
                case "empty":
                    bw.write(DQ.empty() + "\n");
                    break;
                case "front":
                    bw.write(DQ.front() + "\n");
                    break;
                case "back":
                    bw.write(DQ.back() + "\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static class Deque {
        LinkedList<Integer> list;

        public Deque() {
            list = new LinkedList<>();
        }
        public void push_front(int n) {
            list.addFirst(n);
        }
        public void push_back(int n) {
            list.addLast(n);
        }
        public int pop_front() {
            if(list.isEmpty()) return -1;
            int i = list.getFirst();
            list.removeFirst();
            return i;
        }
        public int pop_back() {
            if(list.isEmpty()) return -1;
            int i = list.getLast();
            list.removeLast();
            return i;
        }
        public int size() {
            return list.size();
        }
        public int empty() {
            return list.isEmpty() ? 1 : 0;
        }
        public int front() {
            if(list.isEmpty()) return -1;
            return list.getFirst();
        }
        public int back() {
            if(list.isEmpty()) return -1;
            return list.getLast();
        }
    }
}