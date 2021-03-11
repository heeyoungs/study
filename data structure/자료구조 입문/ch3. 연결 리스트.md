# ch3. 연결 리스트 

---



## 연결 리스트

---

연결 리스트란? 포인터를 이용하여 자료를 한 줄로 저장하는 자료구조



### 노드의 구조

``` java
public class LinkedListNode {
    LinkedListNode(int data){
        this.data = data;
    }
    protected int data;
    protected LinkedListNode link;
}
```

연결 리스트의 노드의 멤버 변수는 "실제 저장하려는 자료 + 다음 자료의 링크 " 를 가지는 구조체이다.

data : 저장하려는 자료

link : 현재 노드와 다음 노드의 연결 정보 (맨 마지막 노드는 null을 가르킨다.)

![unit74-3](C:\Users\user\Downloads\unit74-3.png)



### 연결 리스트의 구조

``` java
public class LinkedList {
    private LinkedListNode head;
    private int currentCount;
}
```

연결 리스트의 멤버 변수는 " 헤더 노드 + 현재 노드의 개수를 저장하는 멤버 변수" 를 가지는 구조체이다.

head : 자료를 저장하는 노드가 아닌 "자료를 가리키는 노드" , 처음에는 null을 가리키고 노드가 추가되면 머리 노드를 가리킨다.

currentCount : 현재 노드의 개수를 저장하는 멤버 변수.

=> 연결 리스트에선 노드의 개수에 제한이 없다.



## 연결 리스트의 구현

---

### 리스트 생성

연결 리스트를 생성하는 생성자이다.

``` java
public class LinkedList(){
	LinkedList(){
        this.head = null;
        this.currentCount = 0;
    }
}
```

head = null : 헤드를 null로 초기화

currentCount : 현재 노드의 개수를 0으로 초기화



배열 리스트와 비교해서 다른 점

=> 연결 리스트는 새로운 노드를 생성해서 추가하기 때문에 크기를 입력받는 파라미터가 없다.



### 값 가져오기

연결 리스트에서 값을 가져오는 연산

``` java
int getNodeData(int index){ // 값 가져오기
    LinkedListNode tempNode = head;
    for(int i=0;i<index;i++){
        tempNode = tempNode.link;
    }
    return tempNode.data;
}
```

1. tempNode가 헤더 노드를 탄다.
2. 입력받은 인덱스만큼 링크를 타고 이동한다.
3. 도착한 노드의 data값을 반환한다.



### 새로운 자료의 추가

연결 리스트에서 새로운 자료를 추가하는 연산 (오버로딩)

1) 노드를 연결 리스트의 맨 마지막에 추가한다.

``` java
void addNode(int data){ // 꼬리에 추가, 기본
        LinkedListNode newNode = new LinkedListNode(data);
        if(head == null){
            this.head = newNode;
        }
        else{
            LinkedListNode tempNode = head;
            while(tempNode.link != null){
                tempNode = tempNode.link;
            }
            tempNode.link = newNode;
        }
        currentCount++;
}
```

1. 새로운 노드를 생성한다. (추가하려는 자료를 멤버 변수로 가진다.)

   => 만약 노드가 한 개도 없다면 그 노드가 헤드가 되고 종료된다.

2. tempNode를 만들어 헤드를 타고 맨 마지막 노드를 지정한다.

3. tempNode의 다음 노드를 newNode로 만들어 준다.

4. currentCount를 한 개 증가시킨다.



2) 노드를 연결 리스트의 원하는 위치에 삽입한다. 

``` java
void addNode(int index,int data)throws PositionException{ 
        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode tempNode = head;
        if(index <0 || index >currentCount){
            throw new PositionException("잘못된 인덱스 값");
        }
        else if(index == 0){ 
            this.head = newNode;
            newNode.link = tempNode;
        }
        else { 
            for (int i = 0; i < index-1; i++) {
                tempNode = tempNode.link;
            }
            newNode.link = tempNode.link;
            tempNode.link = newNode;
        }
        currentCount++;
}
```

1. 새로운 노드를 생성한다.(추가하려는 자료를 멤버 변수로 가진다.)
2. 예외 처리 : 음수 또는 연결리스트의 현재 노드의 개수보다 더 큰 인덱스값이 들어왔을 때 예외를 발생
3. 첫 번째 자리에 노드를 추가하려는 경우
   1. 헤드를 tempNode에서 newNode로 바꿔준다.
   2. newNode의 다음 노드를 tempNode로 바꿔준다.
4. 첫 번째 이후에 노드를 추가하려는 경우
   1. tempNode가 head를 타고 추가하려는 위치의 바로 전 위치까지 이동한다.
   2. newNode의 다음 노드를 tempNode의 다음 노드를 가리키게 바꿔준다.
   3. tempNode가 newNode를 가리키게 바꿔준다.
5. currentCount를 한 개 증가시킨다.



### 기존 자료의 제거

연결 리스트에서 기존의 노드를 제거하는 연산

- 제거 대상의 노드의 이전 노드를 찾고, 그 이전 노드의 다음 노드를 제거 대상의 다음 노드로 바꿔주는 연산

- 자바에는 c언어의 free, c++의 delete라는 기능이 없다.

1) 인덱스에 의한 제거

``` java
void removeNodeByIndex(int index)throws PositionException{
        LinkedListNode tempNode = head;
        LinkedListNode tempPreNode = null;
        if(index < 0 || index > currentCount-1) {
            throw new PositionException("잘못된 인덱스 값");
        }
        else if(index == 0){
            tempNode = tempNode.link;
            this.head = tempNode;
        }
        else{
            for(int i=0;i<index;i++){
                tempPreNode= tempNode;
                tempNode=tempNode.link;
            }
            tempPreNode.link = tempNode.link;
        }
        currentCount--;
}
```

1. tempNode가 head를 가리키고, tempPreNode는 null을 가리키게 합니다.
2. 예외 처리 : 음수 또는 연결리스트의 현재 노드의 개수보다 더 큰 인덱스값이 들어왔을 때 예외를 발생
3. 처음에 위치한 노드를 지울 경우
   1. tempNode를 다음 노드로 이동시킵니다.
   2. 그 노드가 head 가 됩니다.

4. 첫 번째 이후에 위치한 노드를 지울 경우
   1. tempNode를 지우려는 노드를 가리키게 한 칸씩 링크를 타고 가면서 tempPreNode가 tempNode의 이전 노드를 가리키게 합니다.
   2. tempPreNode의 다음 노드가 tempNode의 다음 노드를 가리키게 합니다.
5. currentCount 를 한 개 감소시킵니다.



2) 값에 의한 제거

``` java
void removeNodeByData(int data) throws DataException{
    LinkedListNode tempNode = head;
    LinkedListNode tempPreNode = null;
    while(tempNode != null){ 
        if(tempNode.data == data){
            break;
        }
        tempPreNode= tempNode;
        tempNode = tempNode.link;
    }
    if(tempNode == null){
        throw new DataException("잘못된 자료 값");
    }
    else if(tempNode == head){ 
        tempNode = tempNode.link;
        this.head = tempNode;
    }
    else { 
        tempPreNode.link = tempNode.link;
    }
    currentCount--;
}
```

1. tempNode가 head를 가리키고, tempPreNode는 null을 가리키게 합니다.
2. while문을 사용해 tempNode를 한 칸씩 뒤로 이동하면서 검사하고, tempPreNode는 tempNode의 이전 노드를 가리키게 합니다.
3. tempNode가 null을 가리키면( data와 일치하는 값이 노드에 없으면 ) 예외를 발생시킵니다.
4. 처음에 위치한 노드를 지울 경우 (위와 동일)
   1. tempNode를 다음 노드로 이동시킵니다.
   2. 그 노드가 head 가 됩니다. 
5. 첫 번째 이후에 위치한 노드를 지울 경우
   1. tempPreNode가 tempNode의 다음 노드를 가리키게 합니다.
6. currentCount를 한 개 감소시킵니다.



### 기타 연산들

1) 연결 리스트의 초기화

``` java
void clearLinkedList(){
    head = null;
    currentCount = 0;
}
```

1. head를 null로 바꾼다.
2. currentCount를 0으로 초기화한다.



2) 연결 리스트의 크기를 반환

``` java
int getLinkedListLength(){
    int count=0;
    LinkedListNode tempNode = head;
    while(tempNode != null){
        tempNode = tempNode.link;
        count++;
    }
    return count;
}

//

int getLinkedListLength(){
    return currentCount;
}
```

1. count를 0으로 두고 tempNode가 head를 가리킨다.
2. tempNode가 null를 가리킬때까지 tempNode를 다음 노드로 이동시킨다.
3. count를 하나씩 증가시킨다.
4. 그 값을 반환한다.

=> 동일

1. currentCount를 반환한다.



### 연결 리스트와 배열 리스트의 장단점 비교!!

| 구분        | 구현 방식 | 순차적 저장을 구현한 방식 | 자료 접근 속도 | 구현 복잡도 | 기타 제약 사항        |
| ----------- | --------- | ------------------------- | -------------- | ----------- | --------------------- |
| 배열 리스트 | 배열      | 물리적 저장 순서가 순차적 | 빠름 O(1)      | 낮음        | 최대 저장 개수가 필요 |
| 연결 리스트 | 포인터    | 논리적 저장 순서가 순차적 | 느림 O(n)      | 높음        | -                     |



배열 리스트의 장점 <연결 리스트의 단점>

1. 자료 접근 속도가 빠르다.(특정 위치에 바로 접근이 가능하기 때문이다.) 

   =>연결 리스트는 원하는 노드를 찾을 때까지 노드를 탐색해 탐색 속도가 느리다.

2. 구현이 쉽다. 

   => 연결 리스트는 각각의 노드를 동적으로 생성해야해서 구현이 어렵다.



연결 리스트의 장점 < 배열 리스트의 단점>

1. 자료를 추가할 때마다 동적으로 메모리를 생성하기 떄문에, 최대 자료 개수 지정이 필요가없다

   => 배열 리스트는 최대 저장 개수를 지정하기 때문에 불 필요한 메모리 낭비가 생긴다.



<공통점>

- 시간 복잡도

  - 배열 리스트는 중간에 자료를 추가하거나 삭제하면 자료의 오른쪽에 있는 모든 자료를 한 칸씩 옮겨야돼서 시간 복잡도가 O(n)

  - 연결 리스트는 자료를 추가하거나 삭제할 때 적절한 위치를 찾기위해 링크를 이동해야 해서 시간 복잡도가 O(n)

=> 자료의 크기가 크거나, 자료의 추가 삭제가 빈번하다면, 배열 리스트는 연산에 시간이 많이 들어 연결 리스트로 구현하는 것이 더 바람직하다.



## 연결 리스트 관련 함수들

---

- 순회 함수 : 연결 리스트의 연속된 자료에 접근하는 것.
- 연결 함수 : 서로 다른 연결 리스트를 연결하는 것.
- 역순 함수 : 연결 리스트를 역순으로 뒤집는 것.



### 연결 리스트의 순회

순회란? 내용을 차례대로 살펴본다는 뜻.

이러한 순회 연산을 통해 연결 리스트에 저장된 모든 내용을 출력하는 함수이다.



1) 시간 복잡도가 O(n^2)인 방식

``` java
void disPlayList(){
    LinkedListNode tempNode = head;
    System.out.println("disPlayList");
    for(int i=0;i<getLinkedListLength();i++){
        System.out.println("인덱스 " + i + "의 값 : " + getNodeData(i));
    }
    System.out.println("총 노드의 개수 : " + getLinkedListLength());
}
```

위 disPLayList() 함수는 각 노드에 접근 할 때마다 getNodeData()를 호출한다.

근데 getNodeData() 또한 자료의 값을 가져올 때 노드의 처음부터 시작해서 자료의 값을 반환한다.

=> 자료의 개수가 커질수록 불필요한 노드의 개수가 증가해서 시간 복잡도가 늘어난다. 



2) 시간 복잡도가 O(n)인 방식

``` java
void iterateLinkedList(){ // disPlayList 함수의 시간 복잡도 단축
    int count = 0;
    int value = 0;
    LinkedListNode tempNode = head;
    System.out.println("iterateList");

    while(tempNode != null){
        value = tempNode.data;
        System.out.println("인덱스 " + count + "의 값 : " + value);
        tempNode = tempNode.link;
        count++;
    }
    System.out.println("총 노드의 개수 : " + count);
}
```

위 iterateLinkedList() 함수는 순회하는 tempNode가 다음 노드로 넘어갈때 마다 그 위치에서의 data값을 직접 출력해 준다.



=> 같은 결과를 보여주는 함수이지만 시간 복잡도 차이가 나는 위 상황처럼 자료구조의 성능을 

개선하기 위해선 자료 구조 내부 구조를 정확하게 파악해야 한다.!!



### 연결 리스트의 연결

뒤 연결 리스트의 자료를 앞 번째 연결 리스트의 끝에 붙이는 연산 

``` java
void concatLinkedList(LinkedList backL){
    LinkedListNode firstListLastNode = head;

    if(this.head == null){ // 5번
        head = backL.head;
        return;
    }

    for(int i=0;i<currentCount-1;i++){
        firstListLastNode = firstListLastNode.link;
    }
    firstListLastNode.link = backL.head;
    currentCount = currentCount+ backL.currentCount;
    backL.clearLinkedList();
}
```

1. firstListLastNode가 앞 연결리스트의 head를 가리키게 한다.
2. 예외 : 만약 앞 연결리스트가 비어있다면 뒤 연결리스트의 head를 head로 바꾸고 반환한다.
3.  firstListLastNode가 앞 연결 리스트의 헤드를 타고 앞 연결리스트의 마지막 노드를 가리키게 한다.
4. firstListLastNode의 다음 노드가 뒤 연결 리스트의 헤드를 가리키게 한다.
5. 앞 연결 리스트와 뒤 연결 리스트의 노드의 개수를 더해서 저장한다.
6. 뒤 연결 리스트를 초기화한다.



### 연결 리스트의 역순

연결 리스트를 역순으로 뒤집어 주는 연산

``` java
void reverseLinkedList(){
    LinkedListNode p = head;
    LinkedListNode r,q = null;

    while(p !=null){
        r = q;
        q = p;
        p = p.link;
        q.link = r;
    }
    head = q;
}
}
```

1. p는 head를 r,q는 null을 가리키게 한다.
2. p가 null을 가리킬때 까지 아래 과정을 반복한다.
   1. q는 p의 이전 노드
   2. r는 q의 이전 노드
   3. p는 다음 노드로 이동
   4. q의 다음 노드를 r로 바꿔줌 

3. head를 q로 바꿔준다.



## Sol.2

``` java
public class LinkedListNode {
    LinkedListNode(double data){
        this.data = data;
    }
    double data;
    LinkedListNode link;
}
```

``` java
public class LinkedList {
    LinkedListNode head;
    int currentCouunt;
    LinkedList(){
        head = null;
        this.currentCouunt = 0;
    }
    void addNode(double data){ // 꼬리에 추가, 기본
        LinkedListNode newNode = new LinkedListNode(data);
        if(head == null){
            this.head = newNode;
        }
        else{
            LinkedListNode tempNode = head;
            while(tempNode.link != null){
                tempNode = tempNode.link;
            }
            tempNode.link = newNode;
        }
        currentCouunt++;
    }
    double getNodeData(int index){
        LinkedListNode tempNode = head;
        for(int i=0;i<index;i++){
            tempNode = tempNode.link;
        }
        return tempNode.data;
    }
    double sum(){
        double scoresum = 0;
        LinkedListNode tempNode = head;
        for(int i=0;i<currentCouunt;i++){
            scoresum += tempNode.data;
            tempNode = tempNode.link;
        }
        return scoresum;
    }
}
```

``` java
public class LinkedListExample {
    public static void main(String[] args){
        double input;
        int count = 1;
        Scanner scanner = new Scanner(System.in);
        LinkedList score = new LinkedList();
        while(true){
            System.out.print("> " + count + "번째 점수는(-1을 입력하면 끝납니다)? ");
            try {
                input = scanner.nextDouble();
                if (input == -1) { // 종료 구문
                    double sum = score.sum();
                    double avg = sum / (double) (count - 1);
                    System.out.println((count - 1) + "명의 평균: " + avg);
                    return;
                }
                score.addNode(input);
                count++;
            }catch (Exception e){
                System.out.println("1명 이상의 점수를 입력해야 합니다.");
                return;
            }
        }
    }
}
```



## 단순 연결 리스트 결과값 ( by java )

``` java
public class LinkedListExample {
    public static void main(String[] args){
        LinkedList pList = null;
        int value = 0;

        pList = new LinkedList();
        try {
            pList.addNode(0, 10);
            pList.addNode(20);
            pList.addNode(2, 30);
        }catch (PositionException e){ e.printStackTrace(); return;}

        value = pList.getNodeData(1);
        System.out.println("인덱스 1의 값_ : " + value);

        try { pList.removeNodeByIndex(2); }catch(PositionException e) {e.printStackTrace(); return;}
        pList.disPlayList();

        LinkedList kList = new LinkedList();
        kList.addNode(90);
        kList.addNode(100);
        pList.concatLinkedList(kList);
        try{ pList.removeNodeByData(100); }catch (DataException e){e.printStackTrace();return;}
        pList.iterateLinkedList();

        pList.reverseLinkedList();
        pList.iterateLinkedList();
    }
}
```

``` java
public class DataException extends Exception{
    public DataException(String message){super(message);}
}
```

``` java
public class PositionException extends Exception{
    public PositionException(String message){super(message);}
}
```

``` java
public class LinkedListNode {
    LinkedListNode(int data){
        this.data = data;
    }
    protected int data;
    protected LinkedListNode link;
}
```

``` java
public class LinkedList {
    private LinkedListNode head;
    private int currentCount; // 1-1 번
    LinkedList(){
        this.head = null;
        this.currentCount = 0;
    }
    void addNode(int data){ // 꼬리에 추가, 기본
        LinkedListNode newNode = new LinkedListNode(data);
        if(head == null){
            this.head = newNode;
        }
        else{
            LinkedListNode tempNode = head;
            while(tempNode.link != null){
                tempNode = tempNode.link;
            }
            tempNode.link = newNode;
        }
        currentCount++;
    }
    void addNode(int index,int data)throws PositionException{ // 인덱스에 의한 값 추가, 삽입
        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode tempNode = head;
        if(index <0 || index >currentCount){ // 음수 또는 연결리스트보다 큰 인덱스 예외
            throw new PositionException("잘못된 인덱스 값");
        }
        else if(index == 0){ // 처음일 경우
            this.head = newNode;
            newNode.link = tempNode;
        }
        else { // 중간, 마지막일 경우
            for (int i = 0; i < index-1; i++) {
                tempNode = tempNode.link;
            }
            newNode.link = tempNode.link;
            tempNode.link = newNode;
        }
        currentCount++;
    } // 4-1번
    void removeNodeByIndex(int index)throws PositionException{
        LinkedListNode tempNode = head;
        LinkedListNode tempPreNode = null;
        if(index < 0 || index > currentCount-1) {
            throw new PositionException("잘못된 인덱스 값");
        }
        else if(index == 0){ // 처음
            tempNode = tempNode.link;
            this.head = tempNode;
        }
        else{ // 중간,마지막
            for(int i=0;i<index;i++){
                tempPreNode= tempNode;
                tempNode=tempNode.link;
            }
            tempPreNode.link = tempNode.link;
        }
        currentCount--;
    } // 4-2번
    void removeNodeByData(int data) throws DataException{
        LinkedListNode tempNode = head;
        LinkedListNode tempPreNode = null;
        while(tempNode != null){ // 값이 같은 노드 찾기
            if(tempNode.data == data){
                break;
            }
            tempPreNode= tempNode;
            tempNode = tempNode.link;
        }
        if(tempNode == null){
            throw new DataException("잘못된 자료 값");
        }
        else if(tempNode == head){ // 첫번째 노드일 경우
            tempNode = tempNode.link;
            this.head = tempNode;
        }
        else { // 중간이후 노드일 경우
            tempPreNode.link = tempNode.link;
        }
        currentCount--;
    } // 4-3번
    int getNodeData(int index){ // 값 가져오기
        LinkedListNode tempNode = head;
        for(int i=0;i<index;i++){
            tempNode = tempNode.link;
        }
        return tempNode.data;
    }
    int getLinkedListLength(){ // 1-2번
        int count=0;
        LinkedListNode tempNode = head;
        while(tempNode != null){
            tempNode = tempNode.link;
            count++;
        }
        return count;
    }
    void clearLinkedList(){ // 초기화
        head = null;
        currentCount = 0;
    }
    void disPlayList(){
        LinkedListNode tempNode = head;
        System.out.println("disPlayList");
        for(int i=0;i<getLinkedListLength();i++){
            System.out.println("인덱스 " + i + "의 값 : " + getNodeData(i));
        }
        System.out.println("총 노드의 개수 : " + getLinkedListLength());
    }
    void iterateLinkedList(){ // disPlayList 함수의 시간 복잡도 단축
        int count = 0;
        int value = 0;
        LinkedListNode tempNode = head;
        System.out.println("iterateList");

        while(tempNode != null){
            value = tempNode.data;
            System.out.println("인덱스 " + count + "의 값 : " + value);
            tempNode = tempNode.link;
            count++;
        }
        System.out.println("총 노드의 개수 : " + count);
    }
    void concatLinkedList(LinkedList backL){
        LinkedListNode firstListLastNode = head;

        if(this.head == null){ // 5번
            head = backL.head;
            return;
        }

        for(int i=0;i<getLinkedListLength()-1;i++){
            firstListLastNode = firstListLastNode.link;
        }
        currentCount = currentCount+ backL.currentCount;
        firstListLastNode.link = backL.head;
        backL.clearLinkedList();
    }
    void reverseLinkedList(){
        LinkedListNode p = head;
        LinkedListNode r,q = null;

        while(p !=null){
            r = q;
            q = p;
            p = p.link;
            q.link = r;
        }
        head = q;
    }
}
```



