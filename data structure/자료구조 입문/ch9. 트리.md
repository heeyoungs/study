# ch9. 트리

---



## 트리란?

---

트리(tree) : 나무 -> 자료구조에서의 트리는 나무 구조라고 한다.

- 다음 노드는 여러 개 연결 될 수 있지만, 이전 노드는 오직 한 개이다.
- 계층 관계를 부모-자식 구조라고 한다. 
- 비선형 구조 이다.

-> 계층 구조를 가지는 노드와 간선의 집합



용어 정리 ->

### 노드의 종류

| 구분             | 용어      | 내용                                                  |
| ---------------- | --------- | ----------------------------------------------------- |
| 트리에서의 위치  | 루트 노드 | 트리의 첫 번째 노드                                   |
| -                | 단말 노드 | 자식 노드가 없는 노드                                 |
| -                | 내부 노드 | 자식 노드가 있는 노드                                 |
| 노드 사이의 관계 | 부모 노드 | 부모 노드와 자식 노드는 ->                            |
| -                | 자식 노드 | 간선으로 연결되어 있음                                |
| -                | 선조 노드 | 루트 노드부터 부모 노드까지의 경로상에 있는 모든 노드 |
| -                | 후손 노드 | 특정 노드의 아래에 있는 모든 노드                     |
| -                | 형제 노드 | 같은 부모 노드의 자식 노드                            |

![다운로드 (15)](C:\Users\user\Downloads\다운로드 (15).png)

트리에서의 위치

- 루트 노드 : A

- 단말 노드 : E J K L H I

- 내부 노드 : B C D F G



F노드를 기준으로 노드 사이의 관계

- 부모 노드 : B
- 자식 노드 : J K
- 선조 노드 : B A
- 후손 노드 : J K
- 형제 노드 : E



### 노드의 속성

| 용어 | 내용                                                         |
| ---- | ------------------------------------------------------------ |
| 레벨 | 루트 노드부터의 거리                                         |
| 높이 | 루트 노드부터 가장 먼 거리에 있는 자식 노드의 높이에 1을 더한 값 |
| 차수 | 한 노드가 가지는 자식 노드의 개수                            |

![다운로드 (15)](C:\Users\user\Downloads\다운로드 (15).png)

D노드를 기준으로 한 위치

- 레벨 : A노드부터 D까지의 거리 1 

  => 루트 노드를 0,1 무엇으로 두느냐에 따라 다름 ( 0이면 레벨1, 1이면 레벨 2)

- 높이 : L부터 D까지의 거리인 2 + 1 -> 3 

- 차수 : G,H,I -> 3



### etc

- 서브 트리 : 트리에 속한 노드들의 부분 집합
- 포리스트 : 숲 구조, 트리의 집합 -> 여러 개의 트리를 모으면 하나의 포리스트가 만들어짐



## 이진 트리

---

이진 트리란? 모든 트리의 노드의 차수가 2 이하인 트리! ( 하나의 노드가 최대 2개의 자식 노드 )



![다운로드 (16)](C:\Users\user\Downloads\다운로드 (16).png)

특성

- 이진 트리의 모든 서브트리는 이진 트리이다.
- 트리에서 노드의 개수가 n개일 경우 간선의 개수는 n-1개이다.



### 이진 트리의 종류

포화 이진 트리

![다운로드 (17)](C:\Users\user\Downloads\다운로드 (17).png)

- 모든 레벨의 노드가 꽉 차있는 이진 트리(모든 노드의 차수가 2)
- 높이가 h인 경우 이진 트리의 노드의 개수는 2^h -1 개



완전 이진 트리

![images (1)](C:\Users\user\Downloads\images (1).png)

- 높이가 h인 경우 레벨1부터 h-1까지는 포화 이진 트리, 마지막 레벨 h에선 왼쪽부터 오른쪽으로 노드가 채워져 있는 이진 트리



편향 이진 트리

![다운로드 (18)](C:\Users\user\Downloads\다운로드 (18).png)

- 최소 개수의 노드를 가지면서 왼쪽또는 오른쪽으로만 편향되게 서브트리를 가지는 이진 트리
- 노드의 개수는 레벨과 동일



## 이진 트리의 추상 자료형

---

| 이름                    | -               | Input                      | Output                      | 설명                                                    |
| ----------------------- | --------------- | -------------------------- | --------------------------- | ------------------------------------------------------- |
| 이진 트리 생성          | makeBinTree()   | 자료 data                  | 이진 트리 bt                | 자료 data를 갖는 루트 노드로 구성된 이진 트리 bt를 생성 |
| 루트 노드 반환          | getRootNode()   | 이진 트리 bt               | 루트 노드 rn                | 이진 트리 bt의 루트 노드 반환                           |
| 왼쪽 자식 노드 추가     | addLeftChild()  | 부모 노드 pt<br>자료 data  | 생성된 왼쪽 자식 노드 ln    | 부모 노드 pt의 왼쪽 자식 노드 추가                      |
| 오른쪽 자식 노드 추가   | addRightChild() | 부모 노드 pt<br/>자료 data | 생성 된 오른쪽 자식 노드 rn | 부모 노드 pt의 오른쪽 자식 노드 n추가                   |
| 왼쪽 자식 노드 반환     | getLeftChild()  | 부모 노드 pt               | 왼쪽 자식 노드 ln           | 부모 노드 pt의 왼쪽 자식 노드 반환                      |
| 오른쪽 자식 노드 반환   | getRightChild() | 부모 노드 pt               | 오른쪽 자식 노드 rn         | 부모 노드 pt의 오른쪽 자식 노드 반환                    |
| 이진 트리 노드의 데이터 | getData()       | 이진 트리 bt               | 자료 data                   | 이진 트리 bt의 루트 노드 데이터를 반환                  |
| 이진 트리 삭제          | deleteBinTree() | 이진 트리 bt               | N / A                       | 이진 트리를 제거(메모리 해제)                           |



## 배열로 구현한 이진 트리

---

![다운로드 (19)](C:\Users\user\Downloads\다운로드 (19).png)

특징

- 인덱스 0의 자리는 비운다.
- 부모 노드의 인덱스를 n이라 하면 자식 노드가 저장되는 인덱스는 2*n, 2*n+1의 자리이다.
- 중간에 노드가 없는 경우, 특히 편향 이지 트리의 성향을 띌 경우 배열에 빈 공간이 많아져 메모리 낭비가 심하다.

=> ch10 히프에서 구현



## 포인터로 구현한 이진 트리

---

-> 연결 이진 트리



### 연결 이진 트리의 구조

이진 트리의 노드

``` java
public class BinTreeNode {
    private char data;
    private BinTreeNode pLeftChild;
    private BinTreeNode pRightChild;
    public void setData(char data){
        this.data = data;
    }
    public char getData(){
        return data;
    }
    public void setpLeftChild(BinTreeNode link){
        this.pLeftChild = link;
    }
    public void setpRightChild(BinTreeNode link){
        this.pRightChild = link;
    }
    public BinTreeNode getpLeftChild(){
        return pLeftChild;
    }
    public BinTreeNode getpRightChild(){
        return pRightChild;
    }
}
```

- data : 노드가 저장하는 자료
- pLeftChild : 왼쪽 자식 노드
- pRightChild : 오른쪽 자식 노드



이진 트리의 구조

```java
public class BinTree {
    private BinTreeNode pRootNode;
}
```

- pRootNode : 루트 노드를 가리키는 변수



### 연결 이진 트리의 생성

이진 트리의 생성 (생성자)

```java
public BinTree(char data){
    BinTreeNode newNode = makeNewNodeBT(data);
    pRootNode = newNode;
}
```

- 매개값 하나를 받아 그 값을 루트 노드로 설정하고 이진 트리를 생성하는 생성자이다.



이진 트리 노드의 생성

```java
public BinTreeNode makeNewNodeBT(char data){
    BinTreeNode newNode = new BinTreeNode();
    newNode.setData(data);
    newNode.setpLeftChild(null);
    newNode.setpRightChild(null);
    return newNode;
}
```

- 매개값 하나를 받아 Node를 생성한다.
- 그리고 그 노드의 값, 왼쪽 자식, 오른쪽 자식을 초기화 시킨다.
- 그 노드를 반환한다.



### 연결 이진 트리의 자식 노드 추가

오른쪽 자식 노드의 추가

```java
public BinTreeNode addRightChildNodeBT(BinTreeNode pParentNode, char data){
    BinTreeNode newNode = null;
    if(pParentNode == null){
        return null;
    }
    if(pParentNode.getpRightChild() == null){
        newNode = makeNewNodeBT(data);
        pParentNode.setpRightChild(newNode);
    }
    else{
        System.out.println("이미 노드가 존재합니다");
    }
    return newNode;
}
```



왼쪽 자식 노드의 추가

```java
public BinTreeNode addLeftChildNodeBT(BinTreeNode pParentNode, char data){
    BinTreeNode newNode = null;
    if(pParentNode == null){
        return null;
    }
    if(pParentNode.getpLeftChild() == null){
        newNode = makeNewNodeBT(data);
        pParentNode.setpLeftChild(newNode);
    }
    else{
        System.out.println("이미 노드가 존재합니다");
    }
    return newNode;
}
```

=> 둘의 작동 방식은 동일

- 매개값으로 받은 부모 노드가 null인지 확인
- 만약 추가하려는 쪽의 자리에 노드가 존재하는 지 검사
  - 그 자리에 노드가 없으면 그 자리에 새로운 노드를 추가
  - 있으면 "이미 노드가 존재합니다."를 출력
- 추가한 노드를 값으로 반환해준다.



### 연결 이진 트리의 그 외 연산들

루트 노드 구하기

```java
public BinTreeNode getpRootNode(){
    return pRootNode;
}
```

- 루트 노드를 반환해준다.



이진 트리 초기화

```java
public void deleteBinTree(){
    pRootNode = null;
}
```

- 이진 트리의 모드는 노드는 루트 노드로 부터 이어졌기 때문에 루트 노드를 null로 초기화해준다.

  => 쓰레기 수집기가 이진 트리를 초기화 시켜준다.



## 이진 트리의 순회

---

순회란? 트리의 모든 노드를 한 번씩 방문하는 것



이진 트리에서 노드의 방문을 

- V : 현재 노드의 방문
- L : 왼쪽 서브트리로 이동
- R : 오른쪽 서브트리로 이동



| 종류      | 방문 순서 | 설명                                                         |
| --------- | --------- | ------------------------------------------------------------ |
| 전위 순회 | V-L-R     | 현재 노드 방문-> 왼쪽 서브트리로 이동-> 오른쪽 서브트리로 이동 |
| 중위 순회 | L-V-R     | 왼쪽 서브트리로 이동 -> 현재 노드 방문 -> 오른쪽 서브트리로 이동 |
| 후위 순회 | L-R-V     | 왼쪽 서브트리로 이동 -> 오른쪽 서브트리로 이동 -> 현재 노드 방문 |
| 레벨 순회 | 레벨      | 낮은 레벨의 노드(루트 노드)부터 같은 높은 레벨의 노드를 레벨 순서대로 방문 |

![다운로드 (20)](C:\Users\user\Downloads\다운로드 (20).png)

### 전위 순회

전위 순회란?

1. 현재 노드를 방문하고
2. 왼쪽 서브트리로 이동
3. 오른쪽 서브트리로 이동

=> 33, 22, 3, 26, 44, 77, 55





### 중위 순회

중위 순회란?

1. 왼쪽 서브트리로 이동
2. 현재 노드를 방문하고
3. 오른쪽 서브트리로 이동

=> 3, 22, 33, 26, 44, 55, 77



### 후위 순회

후위 순회란?

1. 왼쪽 서브트리로 이동
2. 오른쪽 서브트리로 이동
3. 현재 노드를 방문

=> 3, 26, 22, 55, 77, 44, 33



### 레벨 순회

레벨 순회란?

1. 레벨 1인 루트 노드를 방문
2. 레벨 2의 노드중 가장 왼쪽부터 방문
3. 레벨 3의 노드중 가장 왼쪽부터 방문 ...

=> 33, 22, 44, 3, 26, 77, 55



### 순회의 구현 (재귀)

#### 재귀 전위 순회

순회하면서 출력 처리부분

``` java
private void pTRBTN(BinTreeNode temp) {
    if (temp != null) {
        System.out.print(temp.getData());
        pTRBTN(temp.getpLeftChild());
        pTRBTN(temp.getpRightChild());
    }
}
```

- 현재 노드를 처리 (재귀)
- 왼쪽 노드를 방문 (재귀)
- 오른쪽 노드를 방문



시작 노드를 매개값으로 주는 부분

```java
public void pTRBT(BinTree binTree) {
    if (binTree != null) {
        pTRBTN(binTree.pRootNode);
        System.out.println();
    }
}
```

- 루트 노드를 매개값으로 줌



#### 재귀 중위 순회

순회하면서 출력 처리부분

```java
private void iTRBTN(BinTreeNode temp) {
    if (temp != null) {
        iTRBTN(temp.getpLeftChild());
        System.out.print(temp.getData());
        iTRBTN(temp.getpRightChild());
    }
}
```

- 왼쪽 노드를 방문 (재귀)
- 현재 노드를 처리 (재귀)
- 오른쪽 노드를 방문



시작 노드를 매개값으로 주는 부분

```java
public void iTRBT(BinTree binTree) {
    if (binTree != null) {
        iTRBTN(binTree.pRootNode);
        System.out.println();
    }
}
```

- 루트 노드를 매개값으로 줌



#### 재귀 후위 순회

순회하면서 출력 처리부분

```java
private void pTRBTN_(BinTreeNode temp) {
    if (temp != null) {
        pTRBTN_(temp.getpLeftChild());
        pTRBTN_(temp.getpRightChild());
        System.out.print(temp.getData());
    }
}
```

- 왼쪽 노드를 방문 (재귀)
- 오른쪽 노드를 방문 (재귀)
- 현재 노드를 처리



시작 노드를 매개값으로 주는 부분

```java
public void pTRBT_(BinTree binTree) {
    if (binTree != null) {
        pTRBTN_(binTree.pRootNode);
        System.out.println();
    }
}
```

- 루트 노드를 매개값으로 줌



#### 재귀 레벨 순회

재귀 레벨 순회는 큐를 사용해서 구현해야한다.



노드를 큐에 인큐처리하는 부분

```java
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
```

- 왼쪽 자식 노드를 인큐
- 오른쪽 자식 노드를 인큐

=> 재귀 처리



디큐하면서 출력하는 부분

```java
public void levelOrderTraversalBT() {
    LinkedQueueNode linkedQueueNode = null;
    LinkedQueue queue = new LinkedQueue();
    if (queue == null) { // 큐가 잘 생성됐는지 확인
        return;
    }

    BinTreeNode pCurrentNode = pRootNode;
    if (pCurrentNode == null) { // 루트 노드가 null이 아닌지 확인
        return;
    }

    queue.enqueueLQ(pCurrentNode); // 루트 노드를 인큐한다.
    lOTBTN(pCurrentNode, queue); // 레벨 2부터의 인큐 재귀처리

    while (true) { // 디큐부분
        if (queue.isLinkedQueueEmpty() == 1) { // 큐가 비어있을 때까지
            break;
        } else {
            linkedQueueNode = queue.dequeueLQ(); // 디큐
            if (linkedQueueNode != null) { // 디큐한 값이 null이 아니면
                pCurrentNode = linkedQueueNode.getData();
                System.out.print(pCurrentNode.getData()); // 출력
            }
        }
    }
    queue.deleteLQ(); // 큐 초기화
}
```

- 레벨 1노드(루트 노드) 부터 마지막 레벨까지 재귀 순회하면서 인큐한다.
- FIFO의 특성으로 인큐한 순서대로 값이 출력된다.



```java
public class BinTreeNode {
    private char data;
    private BinTreeNode pLeftChild;
    private BinTreeNode pRightChild;

    public void setData(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    public void setpLeftChild(BinTreeNode link) {
        this.pLeftChild = link;
    }

    public void setpRightChild(BinTreeNode link) {
        this.pRightChild = link;
    }

    public BinTreeNode getpLeftChild() {
        return pLeftChild;
    }

    public BinTreeNode getpRightChild() {
        return pRightChild;
    }
}
```

```java
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

        while (true) { // 디큐부분
            if (queue.isLinkedQueueEmpty() == 1) {
                break;
            } else {
                BinTreeNode tt = queue.dequeueLQ();
                System.out.print(tt.getData());
                if (tt.getpLeftChild() != null) {
                    queue.enqueueLQ(tt.getpLeftChild());
                }
                if (tt.getpRightChild() != null) {
                    queue.enqueueLQ(tt.getpRightChild());
                }
            }
        }
        queue.deleteLQ();
    } // 레벨
}
```

```java
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
```

