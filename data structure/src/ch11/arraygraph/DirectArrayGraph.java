package ch11.arraygraph;

public class DirectArrayGraph {
    private int nodeCount;
    private int[][] ppEdge;
    public DirectArrayGraph(int nodeCount){
        this.nodeCount = nodeCount;
        this.ppEdge = new int[nodeCount][nodeCount];
    }
    public int addEdgeDAG(int fromNode,int toNode){
        if (checkVertexValid(fromNode) && checkVertexValid(toNode)){
            ppEdge[fromNode][toNode] = 1;
            return 1;
        }
        return -1;
    }
    public int removeEdgeDAG(int fromNode,int toNode){
        if (checkVertexValid(fromNode) && checkVertexValid(toNode)){
            ppEdge[fromNode][toNode] = 0;
            return 1;
        }
        return -1;
    }
    public int getEdgeDAG(int fromNode,int toNode){
        if(checkVertexValid(fromNode) && checkVertexValid(toNode)){
            return ppEdge[fromNode][toNode];
        }
        return -1;
    }
    private boolean checkVertexValid(int node){
        if (node < nodeCount && node >= 0) {
            return true;
        }
        return false;
    }
    public void displayGraphDAG(){
        for(int i=0;i<nodeCount;i++){
            for(int j=0;j<nodeCount;j++){
                System.out.print(ppEdge[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void deleteGraphDAG(){
        nodeCount = 0;
        ppEdge = null;
    }
}
