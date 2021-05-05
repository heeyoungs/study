package ch11.arraygraph;

public class DirectArrayGraphExample {
    public static void main(String[] args){
        int nodeCount = 6;
        DirectArrayGraph directArrayGraph = new DirectArrayGraph(nodeCount);
        if(directArrayGraph != null){
            directArrayGraph.addEdgeDAG(0,1);
            directArrayGraph.addEdgeDAG(1,2);
            directArrayGraph.addEdgeDAG(2,0);
            directArrayGraph.addEdgeDAG(2,3);
            directArrayGraph.addEdgeDAG(3,2);
            directArrayGraph.addEdgeDAG(3,4);
            directArrayGraph.addEdgeDAG(4,5);
            directArrayGraph.addEdgeDAG(5,3);

            System.out.println("G2: 방향 그래프");
            directArrayGraph.displayGraphDAG();

            directArrayGraph.deleteGraphDAG();
        }
    }
}
