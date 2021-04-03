package ch11.internalarraygraph;

import ch3.singlelinkedlist.PositionException;

public class ArrayGraph {
    private int graphType;
    private int nodeCount;
    private int ppEdge[][];
    private LinkedList[] ppAdjEdge;
    ArrayGraph(int graphType, int nodeCount){
        if (nodeCount<0) {
            System.out.println("0보다 작은 인덱스");
            return;
        }
        if(graphType != 1 && graphType != 2){
            System.out.println("그래프 타입 오류");
            return;
        }
        else if(graphType == 1) { // 인접 행렬
            this.graphType = graphType;
            this.nodeCount = nodeCount;
            this.ppEdge = new int[nodeCount][nodeCount];
        }
        else if(graphType == 2){ // 인접 리스트
            this.graphType = graphType;
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
    }
    int addEdgeAG(int fromNode,int toNode){
        if(addEdgeInternalAG(fromNode,toNode) == -1){
            return -1;
        }
        addEdgeInternalAG(fromNode, toNode);
        return addEdgeInternalAG(toNode,fromNode);
    }
    int addEdgeInternalAG(int fromNode,int toNode){
        switch (graphType){
            case 1:
                if (checkVertexValid(fromNode) && checkVertexValid(toNode)){
                    ppEdge[fromNode][toNode] = 1;
                    return 1;
                }
                return -1;
            case 2:
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
        return 0;
    }
    int removeEdgeAG(int fromNode,int toNode){
        if(removeEdgeAG(fromNode,toNode)==-1){
            return -1;
        }
        return removeEdgeAG(toNode,fromNode);
    }
    int removeInternalAg(int fromNode,int toNode){
        switch (graphType){
            case 1:
                if (checkVertexValid(fromNode) && checkVertexValid(toNode)){
                    ppEdge[fromNode][toNode] = 0;
                    return 1;
                }
                return -1;
            case 2:
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
        return 0;
    }
    boolean checkVertexValid(int node){
        if (node < nodeCount && node >= 0) {
            return true;
        }
        return false;
    }
    int getEdgeiAG(int fromNode, int toNode){
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
    void displayGraphDAG(ArrayGraph graph){
        switch (graphType){
            case 1:
                for(int i=0;i<nodeCount;i++) {
                    for (int j = 0; j < nodeCount; j++) {
                        System.out.print(ppEdge[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i=0; i<nodeCount; i++){
                    for(int j=0; j<nodeCount; j++){
                        if(graph.getEdgeiAG(i,j) == 1){
                            System.out.print("1 ");
                        }
                        else{
                            System.out.print("0 ");
                        }
                    }
                    System.out.println();
                }
                break;
        }
    }
    void deleteGraphDAG(){
        switch (graphType){
            case 1:
                nodeCount = 0;
                ppEdge = null;
                break;
            case 2:
                nodeCount = 0;
                ppAdjEdge = null;
                break;
        }
    }
    void traversalDFS(int startNode, int[] pVisit){
        int i = 0;
        pVisit[startNode] = 1;
        System.out.println("노드-" + startNode + " 방문");
        for ( i=0; i<nodeCount; i++) {
            if ( startNode != i ) {
                if ( -1 != getEdgeiAG(startNode, i)) {
                    if ( 0 == pVisit[i] ) {
                        traversalDFS(i, pVisit);
                    }
                }
            }
        }
    }
    void traversalBFS(int startNode){
        int i = 0;
        int node = 0;
        LinkedQueue queue = new LinkedQueue();
        LinkedQueueNode queueNode = null;
        int[] pVisit = new int[nodeCount];
        if ( queue == null || pVisit == null ) {
            return;
        }
        pVisit[startNode] = 1;
        queue.enqueueLQ(startNode);
        while ( queue.isLinkedQueueEmpty() == -1 ) {
            queueNode = queue.dequeueLQ();
            if ( queueNode != null ) {
                node = queueNode.getData();
                System.out.println("노드-" + node + " 방문");
                for ( i=0; i<nodeCount; i++) {
                    if ( node != i ) {
                        if ( getEdgeiAG(node, i) == 1 ) {
                            if ( pVisit[i] == 0 ) {
                                pVisit[i] = 1;
                                queue.enqueueLQ(i);
                            }
                        }
                    }
                }
                queueNode = null;
            }
        }
        queue.deleteLQ();
    }
}
