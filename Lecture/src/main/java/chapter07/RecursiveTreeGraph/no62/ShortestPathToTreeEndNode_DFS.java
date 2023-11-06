package chapter07.RecursiveTreeGraph.no62;

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

    private static int DFS(int level, Node node) {
        if(node.lt == null && node.rt == null) return level;
        return Math.min(DFS(level + 1, node.lt), DFS(level + 1, node.rt));
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(DFS(0, root));
    }

}
