package ch11.internalarraygraph;

public class ArrayGraphExample {
    public static void main(String[] args) { // 1 -> 인접 행렬, 2 -> 인접 리스트
        int nodeCount = 6;
        ArrayGraph arrayGraph = new ArrayGraph(1, nodeCount);
        if (arrayGraph != null) {
            arrayGraph.addEdgeAG(0, 1);
            arrayGraph.addEdgeAG(1, 2);
            arrayGraph.addEdgeAG(2, 0);
            arrayGraph.addEdgeAG(2, 3);
            arrayGraph.addEdgeAG(3, 2);
            arrayGraph.addEdgeAG(3, 4);
            arrayGraph.addEdgeAG(4, 5);
            arrayGraph.addEdgeAG(5, 3);

            System.out.println("무방향 그래프 -> 인접 행렬");
            arrayGraph.displayGraphDAG(arrayGraph);

            arrayGraph.deleteGraphDAG();
        }
        System.out.println();

        arrayGraph = new ArrayGraph(2, nodeCount);
        if (arrayGraph != null) {
            arrayGraph.addEdgeAG(0, 1);
            arrayGraph.addEdgeAG(1, 2);
            arrayGraph.addEdgeAG(2, 0);
            arrayGraph.addEdgeAG(2, 3);
            arrayGraph.addEdgeAG(3, 2);
            arrayGraph.addEdgeAG(3, 4);
            arrayGraph.addEdgeAG(4, 5);
            arrayGraph.addEdgeAG(5, 3);

            System.out.println("무방향 그래프 -> 인접 리스트");
            arrayGraph.displayGraphDAG(arrayGraph);

            arrayGraph.deleteGraphDAG();
        }
        System.out.println();

        nodeCount = 4;
        arrayGraph = new ArrayGraph(2, nodeCount);
        int[] pVisit = new int[nodeCount];
        if ( arrayGraph != null && pVisit != null ) {
            arrayGraph.addEdgeAG(0, 1);
            arrayGraph.addEdgeAG(0, 2);
            arrayGraph.addEdgeAG(1, 3);
            System.out.println("깊이우선");
            arrayGraph.displayGraphDAG(arrayGraph);
            arrayGraph.traversalDFS(0, pVisit);
            arrayGraph.deleteGraphDAG();
        }
        System.out.println();

        nodeCount = 4;
        arrayGraph = new ArrayGraph(2, nodeCount);
        if ( arrayGraph != null ) {
            arrayGraph.addEdgeAG(0, 1);
            arrayGraph.addEdgeAG(0, 2);
            arrayGraph.addEdgeAG(1, 3);
            System.out.println("넓이우선");
            arrayGraph.displayGraphDAG(arrayGraph);
            arrayGraph.traversalBFS(0);
            arrayGraph.deleteGraphDAG();
        }
    }
}
