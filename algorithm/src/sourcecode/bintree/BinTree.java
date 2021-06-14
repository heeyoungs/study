package sourcecode.bintree;

public class BinTree {
    private BinTreeNode pRootNode;

    // 생성자
    public BinTree(int data) {
        BinTreeNode newNode = makeNewNodeBT(data);
        pRootNode = newNode;
    }

    // 노드 생성하기
    public BinTreeNode makeNewNodeBT(int data) {
        BinTreeNode newNode = new BinTreeNode();
        newNode.setData(data); // data 값을 초기화
        newNode.setpLeftChild(null); // 왼쪽 자식 x
        newNode.setpRightChild(null); // 오른쪽 자식 x
        return newNode;
    }

    // 노드 검색
    public BinTreeNode searchNodeBT(BinTreeNode node, int data) {
        if (node == null) { // 값이 없으면 null을 반환
            return null;
        }

        if (data < node.getData()) { // 현재 보는 값보다 찾는 값이 작을 때
            return searchNodeBT(node.getpLeftChild(), data); // 왼쪽 자식으로 내려감
        } else if (data > node.getData()) { // 현재 보는 값보다 찾는 값이 클 때
            return searchNodeBT(node.getpRightChild(), data); // 오른쪽 자식으로 내려감
        } else {
            return node; // 동일한 값을 찾으면 값을 반환
        }
    }

    // 제일 작은 노드 검색
    public BinTreeNode searchMinNodeBT(BinTreeNode node) {
        if (node == null) { // 값이 없으면 null
            return null;
        }

        if (node.getpLeftChild() == null) { //더 이상 왼쪽 자식이 없으면 그 값을 반환
            return node;
        } else {
            return searchMinNodeBT(node.getpLeftChild()); // 재귀, 왼쪽으로 쭉 내려감
        }
    }

    // 노드 삽입
    public void insertNodeBT(BinTreeNode node, BinTreeNode child) {
        if (node.getData() < child.getData()) { // 자식 값(매개 값으로 들어온 값)이 현재 값(루트)보다 클때
            if (node.getpRightChild() == null) { // 오른쪽 자식이 없으면
                node.setpRightChild(child); // 오른쪽 자식으로 설정
            } else { // 오른쪽 자식이 있으면
                insertNodeBT(node.getpRightChild(), child); // 오른쪽 자식으로 내려감
            }
        } else if (node.getData() > child.getData()) { // 자식 값(매개 값으로 들어온 값)이 현재 값(루트)보다 작을 때
            if (node.getpLeftChild() == null) { // 왼쪽 자식이 없으면
                node.setpLeftChild(child); // 왼쪽 자식으로 설정
            } else { // 왼쪽 자식이 있으면
                insertNodeBT(node.getpLeftChild(), child); // 왼쪽 자식으로 내려감
            }
        }
    }
    
    // 노드 제거
    public BinTreeNode removeNodeBT(BinTreeNode node, BinTreeNode parent, int data) {
        BinTreeNode remove = null;
        if (node == null) { // 값이 없으면 null
            return null;
        }
        if (node.getData() > data) { // 현재 보는 값보다 찾는 값이 작을 때
            remove = removeNodeBT(node.getpLeftChild(), node, data); // 왼쪽으로 이동
        } else if (node.getData() < data) { // 현재 보는 값보다 찾는 값이 클 때
            remove = removeNodeBT(node.getpRightChild(), node, data); // 오른쪽으로 이동
        } else { // 지우려는 값을 찾았을 때
            remove = node;
            // 지우려는 값의 자식이 없을 경우
            if (node.getpLeftChild() == null && node.getpRightChild() == null) {
                if (parent.getpLeftChild() == node) { // 지우려는 값이 그 부모의 왼쪽이였을 경우
                    parent.setpLeftChild(null); // 왼쪽을 지움
                } else { // 오른쪽이였을 경우
                    parent.setpRightChild(null); // 오른쪽을 지움
                }
            } else {
                // 자식이 양쪽
                if (node.getpLeftChild() != null && node.getpRightChild() != null) {
                    BinTreeNode MinNode = searchMinNodeBT(node.getpRightChild()); // 현재 보는 값의 오른쪽 서브트리의 가장 작은 값을 찾음
                    removeNodeBT(node, null, MinNode.getData()); // 오른쪽 서브트리의 가장 작은에서의 제거연산 제귀
                    node.setData(MinNode.getData()); // 그 값을 현재 보는 값으로 바꿔줌
                }
                // 자식이 한쪽
                else {
                    BinTreeNode temp = null;
                    if (node.getpLeftChild() != null) { // 오른쪽 자식이 비어있다면
                        temp = node.getpLeftChild(); // temp에 그 왼쪽 자식을 저장함
                    } else { // 오른쪽 자식이 비어있다면
                        temp = node.getpRightChild(); // temp에 그 오른쪽 자식을 저장함
                    }

                    if (parent.getpLeftChild() == node) {  // 왼쪽 노드 였을 경우
                        parent.setpLeftChild(temp); // 현재 노드의 부모의 왼쪽 자식에 temp를 이어줌
                    } else { // 오른쪽 노드 였을 경우
                        parent.setpRightChild(temp); // 현재 노드의 부모의 오른쪽 자식에 temp를 이어줌
                    } // node는 사라짐
                }
            }
        }
        return remove;
    }

    // 노드 초기화
    public void deleteBinTree() {
        pRootNode = null;
    }

    // 부모 노드
    public BinTreeNode getpRootNode() {
        return pRootNode;
    }

    // 중위 순회
    public void inOrderBT(BinTreeNode temp) {
        if (temp != null) {
            inOrderBT(temp.getpLeftChild());
            System.out.print(temp.getData() + " ");
            inOrderBT(temp.getpRightChild());
        }
    }
}