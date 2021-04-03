package bintree;

public class BinTreeExample {
    public static void main(String[] args) {
        BinTreeNode[] node = new BinTreeNode[15 + 1];
        for (int i = 1; i <= 15; i++) {
            node[i] = new BinTreeNode();
            node[i].data = i;
            node[i].lLink = null;
            node[i].RLink = null;
        }

        for (int i = 2; i <= 15; i++) {
            if (i % 2 == 0) {
                node[i / 2].lLink = node[i];
            } else {
                node[i / 2].RLink = node[i];
            }
        }
        preorder(node[1]);
        System.out.println();
        inorder(node[1]);
        System.out.println();
        postorder(node[1]);
        System.out.println();
    }

    static void preorder(BinTreeNode node) { // 전위
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.lLink);
            preorder(node.RLink);
        }
    }

    static void inorder(BinTreeNode node) { // 중위
        if (node != null) {
            System.out.print(node.data + " ");
            inorder(node.lLink);
            inorder(node.RLink);
        }
    }

    static void postorder(BinTreeNode node) { // 후위
        if (node != null) {
            System.out.print(node.data + " ");
            postorder(node.lLink);
            postorder(node.RLink);
        }
    }
}
