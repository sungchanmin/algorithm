package chapter07.RecursiveTreeGraph.no58;

public class BinaryTreeCircuit {
    public static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    public static void preorderTraversal(Node node) {
        if(node == null) return;
        System.out.print(node.data + " ");
        preorderTraversal(node.lt);
        preorderTraversal(node.rt);
    }

    public static void inorderTraversal(Node node) {
        if(node == null) return;
        inorderTraversal(node.lt);
        System.out.print(node.data + " ");
        inorderTraversal(node.rt);
    }

    public static void postorderTraversal(Node node) {
        if(node == null) return;
        postorderTraversal(node.lt);
        postorderTraversal(node.rt);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        System.out.print("전위 순회 출력 : ");
        preorderTraversal(root);

        System.out.print("\n중위 순회 출력 : ");
        inorderTraversal(root);

        System.out.print("\n후위 순회 출력 : ");
        postorderTraversal(root);
    }
}
