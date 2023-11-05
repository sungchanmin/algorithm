package chapter07.RecursiveTreeGraph.no60;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelTraversal {
    private static class Node {
        int data;
        Node rt;
        Node lt;

        public Node(int data) {
            this.data = data;
            rt = lt = null;
        }
    }

    private static void BFS(Node node) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(node);

        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i=0; i<len; i++) {
                Node n = Q.poll();
                System.out.print(n.data + " ");

                if(n.lt != null) Q.add(n.lt);
                if(n.lt != null) Q.add(n.rt);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        BFS(root);
    }
}
