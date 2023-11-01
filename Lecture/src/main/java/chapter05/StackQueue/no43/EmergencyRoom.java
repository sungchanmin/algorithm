package chapter05.StackQueue.no43;

import java.util.*;

public class EmergencyRoom {

    private static class Patient {
        private int index;
        private int warn;

        public Patient(int index, Integer warn) {
            this.index = index;
            this.warn = warn;
        }

        public int getIndex() {
            return this.index;
        }

        public int getWarn() {
            return  this.warn;
        }
    }

    private static int solution(int m, ArrayList<Integer> list) {
        int answer = 1;
        Queue<Patient> Q = new LinkedList<>();

        for(int i=0; i<list.size(); i++) {
            Q.add(new Patient(i, list.get(i)));
        }

        Collections.sort(list);
        Collections.reverse(list);

        while(!list.isEmpty()) {
            Patient p = Q.poll();
            if(p.getWarn() >= list.get(0)) {
                if(p.getIndex() == m) return answer;
                else list.remove(0);
                answer++;
            } else {
                Q.add(p);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            list.add(sc.nextInt());
        }

        System.out.println(solution(m, list));

    }
}
