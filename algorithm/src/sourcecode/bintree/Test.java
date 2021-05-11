package sourcecode.bintree;

public class Test {
    public static void main(String[] args) {
        BinTree tree = new BinTree(123);
        BinTreeNode root = tree.getpRootNode();

        tree.insertNodeBT(root, tree.makeNewNodeBT(22));
        tree.insertNodeBT(root, tree.makeNewNodeBT(9918));
        tree.insertNodeBT(root, tree.makeNewNodeBT(424));
        tree.insertNodeBT(root, tree.makeNewNodeBT(17));
        tree.insertNodeBT(root, tree.makeNewNodeBT(3));

        tree.insertNodeBT(root, tree.makeNewNodeBT(98));
        tree.insertNodeBT(root, tree.makeNewNodeBT(34));
        tree.insertNodeBT(root, tree.makeNewNodeBT(760));
        tree.insertNodeBT(root, tree.makeNewNodeBT(317));
        tree.insertNodeBT(root, tree.makeNewNodeBT(1));

        tree.inOrderBT(root);
        System.out.println();

        System.out.println("Removing 98...");
        tree.removeNodeBT(root,null,98);

        tree.inOrderBT(root);
        System.out.println();

        System.out.println("Inserting 111...");
        tree.insertNodeBT(root,tree.makeNewNodeBT(111));

        tree.inOrderBT(root);
        System.out.println();

        tree.deleteBinTree();
    }
}
