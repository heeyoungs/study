package ch11.linkedgraph;

import ch3.singlelinkedlist.PositionException;

public class DirectLinkedGraph {
    private int nodeCount;
    private LinkedList[] ppAdjEdge;
    DirectLinkedGraph(int nodeCount){
        if (nodeCount<0) {
            System.out.println("0보다 작은 인덱스");
            return;
        }
        this.nodeCount = nodeCount;
        this.ppAdjEdge = new LinkedList[nodeCount];
        for (int i=0;i<nodeCount;i++) {
            ppAdjEdge[i] =new LinkedList();
        }
        if (ppAdjEdge == null) {
            System.out.println("오류");
            return;
        }
    }
    int addEdgeDLG(int fromNode, int toNode){
        if(checkVertexValid(fromNode) && checkVertexValid(toNode)){
            try {
                ppAdjEdge[fromNode].addNode(0, toNode);
            }catch (PositionException e){
                e.printStackTrace();
                return -1;
            }
            return 1;
        }
        return -1;
    }
    int removeEdgeDLG(int fromNode, int toNode){
        if (checkVertexValid(fromNode)&&checkVertexValid(toNode)){
            LinkedList list = ppAdjEdge[fromNode];
            int count = list.getLinkedListLength();
            for (int i=0;i<=count;i++){
                if(list.getNodeData(i) == toNode){
                    try {
                        list.removeNodeByIndex(i);
                    }catch (PositionException e){
                        e.printStackTrace();
                        return -1;
                    }
                    return 1;
                }
            }
        }
        return -1;
    }
    int getEdgeDLG(int fromNode, int toNode){ // 이부분 수정
        if(checkVertexValid(fromNode)&&checkVertexValid(toNode)){
            LinkedList list = ppAdjEdge[fromNode];
            int count = list.getLinkedListLength();
            for(int i = 0;i < count; i++){
                if(list.getNodeData(i) == toNode){
                    return 1;
                }
            }
        }
        return -1;
    }
    boolean checkVertexValid(int node){
        if (node >= 0 && node < nodeCount){
            return true;
        }
        return false;
    }
    void displayGraphDLG(DirectLinkedGraph graph){
        for (int i=0; i<nodeCount; i++){
            for(int j=0; j<nodeCount; j++){
                if(graph.getEdgeDLG(i,j) == 1){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    void deleteGraphDLG(){
        nodeCount = 0;
        ppAdjEdge = null;
    }
}
