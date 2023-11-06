package chapter07.RecursiveTreeGraph.no63;

public class GraphsAndAdjacencyMatrix {
    public static void undirectionalGraph() {
        int[][] graph = new int[6][6];

        graph[1][2] = graph[2][1] = 1;
        graph[1][3] = graph[3][1] = 1;
        graph[2][4] = graph[4][2] = 1;
        graph[2][5] = graph[5][2] = 1;
        graph[3][4] = graph[4][3] = 1;
    }

    public static void directionalGraph() {
        int[][] graph = new int[6][6];

        graph[1][2] = 1;
        graph[1][3] = 1;
        graph[2][5] = 1;
        graph[3][4] = 1;
        graph[4][2] = 1;
    }

    public static void weightedOrientationGraph() {
        int[][] graph = new int[6][6];

        graph[1][2] = 2;
        graph[1][3] = 4;
        graph[2][5] = 5;
        graph[3][4] = 5;
        graph[4][2] = 2;
    }

    public static void main(String[] args) {
        undirectionalGraph();
        directionalGraph();
        weightedOrientationGraph();
    }
}
