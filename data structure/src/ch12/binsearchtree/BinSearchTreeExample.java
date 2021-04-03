package ch12.binsearchtree;

public class BinSearchTreeExample {
    public static void main(String[] args){
        BinSearchTree tree = null;
        BinSearchTreeNode node = null;
        int key = 0;

        tree = new BinSearchTree();
        if ( tree != null ){
            tree.insertDataBST(70, 'A');
            tree.insertDataBST(40, 'B');
            tree.insertDataBST(90, 'C');
            tree.insertDataBST(20, 'D');
            tree.insertDataBST(60, 'E');
            tree.insertDataBST(80, 'F');
            tree.insertDataBST(100, 'G');
            tree.insertDataBST(10, 'H');
            tree.insertDataBST(30, 'I');
            tree.insertDataBST(50, 'J');
            tree.displayBinSearchTree(tree.getRootNode(), 0, '-');

            key = 30;
            node = tree.searchBST(key);
            if ( node != null) {
                System.out.println("검색: 키-" + key + ",자료-" + node.getValue() + "발견하였습니다.");
            } else {
                System.out.println("검색: 키-" + key + ",발견하지 못하였습니다.");
            }

            key = 70;
            System.out.println("자료 제거: 키-" + key);
            tree.deleteDataBST(key);

            tree.displayBinSearchTree(tree.getRootNode(), 0, '-');

            key = 35;
            node = tree.searchBST(key);
            if ( node != null) {
                System.out.println("검색: 키-" + key + ",자료-" + node.getValue() + "발견하였습니다.");
            } else {
                System.out.println("검색: 키-" + key + ",발견하지 못하였습니다.");
            }

            tree.deleteBinSearchTree();
        }
    }
}
