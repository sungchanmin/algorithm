package chapter07.RecursiveTreeGraph.no62;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToTreeEndNode_DFS {
    private static class Node {
        int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }

    private static int BFS(Node node){
        int answer = 0;
        Queue<Node> Q = new LinkedList<>();
        Q.add(node);

        while(!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Node n = Q.poll();
                if(n.lt == null || n.rt == null) return answer;
                if(n.lt != null) Q.add(n.lt);
                if(n.rt != null) Q.add(n.rt);
            }
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(BFS(root));
    }

    public static class ShortestPathToTreeEndNode2 {
        public static void main(String[] args) {

        }
    }
}
