package ch9;

public class BinTree {
    private BinTreeNode pRootNode;

    public BinTree(char data) {
        BinTreeNode newNode = makeNewNodeBT(data);
        pRootNode = newNode;
    }

    public BinTreeNode makeNewNodeBT(char data) {
        BinTreeNode newNode = new BinTreeNode();
        newNode.setData(data);
        newNode.setpLeftChild(null);
        newNode.setpRightChild(null);
        return newNode;
    }

    public BinTreeNode addLeftChildNodeBT(BinTreeNode pParentNode, char data) {
        BinTreeNode newNode = null;
        if (pParentNode == null) {
            return null;
        }
        if (pParentNode.getpLeftChild() == null) {
            newNode = makeNewNodeBT(data);
            pParentNode.setpLeftChild(newNode);
        } else {
            System.out.println("이미 노드가 존재합니다");
        }
        return newNode;
    }

    public BinTreeNode addRightChildNodeBT(BinTreeNode pParentNode, char data) {
        BinTreeNode newNode = null;
        if (pParentNode == null) {
            return null;
        }
        if (pParentNode.getpRightChild() == null) {
            newNode = makeNewNodeBT(data);
            pParentNode.setpRightChild(newNode);
        } else {
            System.out.println("이미 노드가 존재합니다");
        }
        return newNode;
    }

    public BinTreeNode getpRootNode() {
        return pRootNode;
    }

    public void deleteBinTree() {
        pRootNode = null;
    }


    public void pTRBT(BinTree binTree) {
        if (binTree != null) {
            pTRBTN(binTree.pRootNode);
            System.out.println();
        }
    } // 전위

    private void pTRBTN(BinTreeNode temp) {
        if (temp != null) {
            System.out.print(temp.getData());
            pTRBTN(temp.getpLeftChild());
            pTRBTN(temp.getpRightChild());
        }
    }

    public void iTRBT(BinTree binTree) {
        if (binTree != null) {
            iTRBTN(binTree.pRootNode);
            System.out.println();
        }
    } // 중위

    private void iTRBTN(BinTreeNode temp) {
        if (temp != null) {
            iTRBTN(temp.getpLeftChild());
            System.out.print(temp.getData());
            iTRBTN(temp.getpRightChild());
        }
    }

    public void pTRBT_(BinTree binTree) {
        if (binTree != null) {
            pTRBTN_(binTree.pRootNode);
            System.out.println();
        }
    } // 후위

    private void pTRBTN_(BinTreeNode temp) {
        if (temp != null) {
            pTRBTN_(temp.getpLeftChild());
            pTRBTN_(temp.getpRightChild());
            System.out.print(temp.getData());
        }
    }

    public void levelOrderTraversalBT() {
        LinkedQueueNode linkedQueueNode = null;
        LinkedQueue queue = new LinkedQueue();
        if (queue == null) {
            return;
        }

        BinTreeNode pCurrentNode = pRootNode;
        if (pCurrentNode == null) {
            return;
        }

        queue.enqueueLQ(pCurrentNode); // 인큐부분
        lOTBTN(pCurrentNode, queue);

        while (true) { // 디큐부분
            if (queue.isLinkedQueueEmpty() == 1) {
                break;
            } else {
                linkedQueueNode = queue.dequeueLQ();
                if (linkedQueueNode != null) {
                    pCurrentNode = linkedQueueNode.getData();
                    System.out.print(pCurrentNode.getData());
                }
            }
        }
        queue.deleteLQ();
    } // 레벨

    private void lOTBTN(BinTreeNode binTreeNode, LinkedQueue queue) {
        if (binTreeNode != null) {
            if (binTreeNode.getpLeftChild() != null) {
                queue.enqueueLQ(binTreeNode.getpLeftChild());
            }
            if (binTreeNode.getpRightChild() != null) {
                queue.enqueueLQ(binTreeNode.getpRightChild());
            }
            lOTBTN(binTreeNode.getpLeftChild(), queue);
            lOTBTN(binTreeNode.getpRightChild(), queue);
        }
    }
}
