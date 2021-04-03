package ch11.linkedgraph;

public class  DirectLinkedGraphExample {
    public static void main(String[] args){
        int nodeCount = 6;
        DirectLinkedGraph directLinkedGraph = new DirectLinkedGraph(nodeCount);
        if(directLinkedGraph != null){
            directLinkedGraph.addEdgeDLG(0,1);
            directLinkedGraph.addEdgeDLG(1,2);
            directLinkedGraph.addEdgeDLG(2,0);
            directLinkedGraph.addEdgeDLG(2,3);
            directLinkedGraph.addEdgeDLG(3,2);
            directLinkedGraph.addEdgeDLG(3,4);
            directLinkedGraph.addEdgeDLG(4,5);
            directLinkedGraph.addEdgeDLG(5,3);

            System.out.println("G2: 방향 그래프");
            directLinkedGraph.displayGraphDLG(directLinkedGraph);

            directLinkedGraph.deleteGraphDLG();
        }
    }
}
