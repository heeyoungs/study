package ch12.binsearchtree;

public class BinSearchTree {
    private BinSearchTreeNode rootNode;
    public BinSearchTreeNode getRootNode(){
        return rootNode;
    }

    public BinSearchTree() {
        rootNode = null;
    }

    public BinSearchTreeNode searchBST(int key) {
        BinSearchTreeNode tempNode = rootNode;
        while (tempNode != null) {
            if ( key == tempNode.getKey() ) {
                break;
            } else if ( key < tempNode.getKey() ) {
                tempNode = tempNode.getLeftchild();
            } else {
                tempNode = tempNode.getRightchild();
            }
        }
        return tempNode;
    }
    // 삽입
    public int insertDataBST(int key, char value) {
        BinSearchTreeNode parentNode = null;
        BinSearchTreeNode newNode = null;

        parentNode = getParentNode(rootNode, key);

        newNode = createBinSearchTreeNode(key, value);
        if (newNode == null) {
            return 0;
        }

        insertNewBinSearchTreeNode(parentNode, newNode);
        return 1;
    }
    public BinSearchTreeNode getParentNode(BinSearchTreeNode tempNode, int key) {
        int ret = 1;
        BinSearchTreeNode parentNode = null;

        while ( tempNode != null ) {
            if ( key == tempNode.getKey() ) {
                System.out.println("오류,중복된 키-" + key + ",getParentNode()");
                ret = 0;
                return null;
            } else if ( key < tempNode.getKey() ) {
                parentNode = tempNode;
                tempNode = tempNode.getLeftchild();
            } else {
                parentNode = tempNode;
                tempNode = tempNode.getRightchild();
            }
        }
        if ( ret == 1 ) {
            return parentNode;
        }
        return null;
    }
    public BinSearchTreeNode createBinSearchTreeNode ( int key, char value){
            BinSearchTreeNode newNode = new BinSearchTreeNode();
            newNode.setKey(key);
            newNode.setValue(value);
            newNode.setLeftchild(null);
            newNode.setRightchild(null);
            return newNode;
    }
    public void insertNewBinSearchTreeNode(BinSearchTreeNode parentNode, BinSearchTreeNode newNode) {
        if (parentNode == null) {
            rootNode = newNode;
        } else {
            if ( newNode.getKey() < parentNode.getKey() ) {
                parentNode.setLeftchild(newNode);
            } else {
                parentNode.setRightchild(newNode);
            }
        }
    }
    // 제거
    public int deleteDataBST(int key){
        BinSearchTreeNode node[] = new BinSearchTreeNode[2]; // 0 delNode, 1 parentNode
        node = searchWithParentNodeBST(key);
        if ( node[0] == null ){
            System.out.println("오류, 존재하지 않는 키-" + key);
            return -1;
        }
        if ( node[0].getLeftchild() == null && node[0].getRightchild() == null ) {
            deleteNodeNoChild(node[1], node[0]);
        }
        else if ( node[0].getLeftchild() != null && node[0].getRightchild() != null ) {
            deleteNodeTwoChild(node[1], node[0]);
        }
        else {
            deleteNodeOneChild(node[1], node[0]);
        }

        return 1;
    }
    public BinSearchTreeNode[] searchWithParentNodeBST(int key){
        BinSearchTreeNode returnNode[] = new BinSearchTreeNode[2]; // 0 delNode, 1 parentNode

        returnNode[0] = rootNode;
        while ( returnNode[0] != null ) {
            if ( key == returnNode[0].getKey() ) {
                break;
            }
            returnNode[1] = returnNode[0];

            if ( key < returnNode[1].getKey() ) {
                returnNode[0] = returnNode[0].getLeftchild();
            } else {
                returnNode[0] = returnNode[0].getRightchild();
            }
        }
        return returnNode;
    }
    public void deleteNodeNoChild(BinSearchTreeNode parentNode, BinSearchTreeNode delNode){
        if ( parentNode != null ){
            if ( parentNode.getLeftchild() == delNode ) {
                parentNode.setLeftchild(null);
            } else {
                parentNode.setRightchild(null);
            }
        } else {
            rootNode = null;
        }
    }
    public void deleteNodeOneChild(BinSearchTreeNode parentNode, BinSearchTreeNode delNode){
        BinSearchTreeNode childNode = null;

        if ( delNode.getLeftchild() != null ) {
            childNode = delNode.getLeftchild();
        } else {
            childNode = delNode.getRightchild();
        }

        if ( parentNode != null ) {
            if ( parentNode.getLeftchild() == delNode ) {
                parentNode.setLeftchild(childNode);
            } else {
                parentNode.setRightchild(childNode);
            }
        } else {
            rootNode = childNode;
        }

    }
    public void deleteNodeTwoChild(BinSearchTreeNode parentNode, BinSearchTreeNode delNode){
        BinSearchTreeNode predecessor = null; // 대체할 노드 바로 직전 노드, delNode 지울 노드, parentNode 지울 노드의 부모 노드
        BinSearchTreeNode successor = null; // 대체할 노드

        predecessor = delNode;
        successor = delNode.getLeftchild();
        while ( successor.getRightchild() != null ) {
            predecessor = successor;
            successor = successor.getRightchild();
        }

        predecessor.setRightchild(successor.getLeftchild());
        successor.setLeftchild(delNode.getLeftchild());
        successor.setRightchild(delNode.getRightchild());

        if ( parentNode != null ) {
            if ( parentNode.getLeftchild() == delNode ) {
                parentNode.setLeftchild(successor);
            } else {
                parentNode.setRightchild(successor);
            }
        } else {
            rootNode = successor;
        }
    }

    public void displayBinSearchTree(BinSearchTreeNode treeNode, int level, char type){
        if ( treeNode != null ) {
            for (int i = 0; i < level; i++) {
                System.out.print("     ");
            }
            System.out.println("-(" + type + ")-key-" + treeNode.getKey() + ",value-" + treeNode.getValue());

            displayBinSearchTree(treeNode.getLeftchild(), level + 1, 'L');
            displayBinSearchTree(treeNode.getRightchild(), level + 1 ,'R');
        }
    }
    public void deleteBinSearchTree(){
        rootNode = null;
    }
}
