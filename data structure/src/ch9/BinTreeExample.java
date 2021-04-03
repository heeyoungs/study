package ch9;

public class BinTreeExample {
    public static void main(String[] args) {
        BinTreeNode aNode, bNode, cNode, dNode, eNode, fNode, gNode;

        BinTree pBinTree = new BinTree('A');
        if (pBinTree != null) {
            aNode = pBinTree.getpRootNode();
            bNode = pBinTree.addLeftChildNodeBT(aNode, 'B');
            cNode = pBinTree.addRightChildNodeBT(aNode, 'C');
            if (bNode != null) {
                dNode = pBinTree.addLeftChildNodeBT(bNode, 'D');
                eNode = pBinTree.addRightChildNodeBT(bNode, 'E');
            }
            if (cNode != null) {
                fNode = pBinTree.addLeftChildNodeBT(cNode, 'F');
                gNode = pBinTree.addRightChildNodeBT(cNode, 'G');
            }
        }
        System.out.print("전위 순회: ");
        pBinTree.pTRBT(pBinTree);
        System.out.print("중위 순회: ");
        pBinTree.iTRBT(pBinTree);
        System.out.print("후위 순회: ");
        pBinTree.pTRBT_(pBinTree);
        System.out.print("레벨 순회: ");
        pBinTree.levelOrderTraversalBT();

        pBinTree.deleteBinTree();
    }
}