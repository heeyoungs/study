# ch4. 연결 리스트의 확장

---

원형 연결 리스트란? 마지막 노드가 첫 번째 노드와 연결되어 원형을 이루는 구조 (단방향) 

=> 운영체제의 시간 할당 문제에 적합

![dasd](C:\Users\user\Downloads\dasd.png)



이중 연결 리스트란? 노드 사이의 연결이 "양방향"으로 이루어진 구조

=> 되돌리기 기능을 구현하는데 적합

![czcxzcx](C:\Users\user\Downloads\czcxzcx.png)

## 원형 연결 리스트

---

### 노드의 구조

``` java
public class CircleLinkedListNode {
    private int data;
    int getData(){
        return data;
    }
    CircleLinkedListNode link;
    CircleLinkedListNode(int data){
        this.data = data;
        this.link = null;
    }
}
```

=> 단순 연결 리스트와 동일!



### 원형 연결 리스트의 구조

``` java
public class CircleLinkedList {
    private int currentCount;
    private CircleLinkedListNode head;
}
```

=> 단순 연결 리스트와 동일!



### 원형 연결 리스트 생성과 값 가져오기

``` java
public calss CircleLinkedList(){
    CircleLinkedList(){
        this.head = null;
        this.currentCount = 0;
    }
}
```

=> 단순 연결 리스트와 동일!



값 가져오기 연산

``` java 
int getCircleLinkedListData(int index){
    CircleLinkedListNode tempNode = head;
    for(int i=0;i<index;i++){
        tempNode = tempNode.link;
    }
    return tempNode.getData();
}
```

=> 단순 연결 리스트와 동일!



### 새로운 자료의 추가

원형 연결 리스트에서 새로운 자료를 추가하는 연산 (오버로딩)

1) 노드를 원형 연결 리스트의 맨 마지막에 추가한다.

``` java
void addNode(int data){
    CircleLinkedListNode newNode = new CircleLinkedListNode(data);
    if(head == null){
        head = newNode;
        newNode.link = newNode;
    }
    else{
        CircleLinkedListNode tempNode = head;
        for(int i=0;i<currentCount-1;i++) {
            tempNode = tempNode.link;
        }
        tempNode.link = newNode;
        newNode.link = head;
    }
    currentCount++;
}
```

1. 새로운 노드를 생성한다. (추가하려는 자료를 멤버 변수로 가진다.)

   => 만약 노드가 한 개도 없을 경우 그 노드를 헤드로 지정하고 , 다음 노드가 자기 자신을 가르키게 한다.

2. tempNode를 만들어 헤드를 타고 맨 마지막 노드를 지정한다.

3. tempNode의 다음 노드를 newNode로 만들어 준다.

4. newNode의 다음 노드가 헤드를 가리키게 해준다.

5. currentCount를 한 개 증가시킨다.



2) 노드를 원형 연결 리스트의 원하는 위치에 삽입한다. 

``` java
void addNode(int index,int data)throws PositionException{
    CircleLinkedListNode newNode = new CircleLinkedListNode(data);
    CircleLinkedListNode tempNode = head;
    if(index<0||index>currentCount){
        throw new PositionException("인덱스 에러");
    }
    else if(head == null){
        head = newNode;
        newNode.link = newNode;
    }
    else if(index == 0){ // 처음에 삽입
        for(int i=0;i<currentCount-1;i++){
            tempNode = tempNode.link;
        }
        tempNode.link = newNode;
        newNode.link = head;
        head = newNode;
    }else{
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
3. 노드가 한 개도 없을 경우 newNode를 헤드로 지정하고 다음 노드가 자기 자신을 가리키게한다.
4. 첫 번째 자리에 노드를 추가하려는 경우
   1. tempNode가 마지막 노드를 가리키게한다.
   2. tempNode의 다음 노드가 newNode를 가리키게한다.
   3. newNode의 다음 노드가 head를 가리키게한다.
   4. newNode가 헤드가 된다.
5. 첫 번째 이후에 노드를 추가하려는 경우 (동일)
   1. tempNode가 head를 타고 추가하려는 위치의 바로 전 위치까지 이동한다.
   2. newNode의 다음 노드를 tempNode의 다음 노드를 가리키게 바꿔준다.
   3. tempNode가 newNode를 가리키게 바꿔준다.
6. currentCount를 한 개 증가시킨다.



### 기존 자료의 제거

원형 연결 리스트에서 기존의 노드를 제거하는 연산

1) 인덱스에 의한 제거

``` java
void removeNodeByIndex(int index)throws PositionException{
    CircleLinkedListNode tempNode = head;
    CircleLinkedListNode tempPreNode = null;
    if(index<0 || index > currentCount-1){
        throw new PositionException("인덱스 에러");
    }
    else if(index == 0){
        if(currentCount == 1){
            head = null;
            currentCount = 0;
            return;
        }
        tempNode = tempNode.link;
        this.head = tempNode;
        for(int i=0;i<currentCount-2;i++){
            tempNode =tempNode.link;
        }
        tempNode.link = head;
    }
    else{ // 중간이후
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

   1. 만약 현재 노드가 한 개인 경우 head는 null currentCount = 0으로 바꾸고 종료합니다.//

   2. tempNode를 다음 노드로 이동시킵니다.

   3. 그 노드가 head 가 됩니다.
   4. tempNode가 마지막 노드를 가리킬때까지 이동하고 그 노드의 다음 노드가 head를 가리키게 합니다. ( 순환 처리)

4. 첫 번째 이후에 위치한 노드를 지울 경우 (동일)

   1. tempNode를 지우려는 노드를 가리키게 한 칸씩 링크를 타고 가면서 tempPreNode가 tempNode의 이전 노드를 가리키게 합니다.
   2. tempPreNode의 다음 노드가 tempNode의 다음 노드를 가리키게 합니다.

5. currentCount 를 한 개 감소시킵니다.



2) 값에 의한 제거

``` java
void removeNodeByData(int data)throws DataException{
    CircleLinkedListNode tempNode = head;
    CircleLinkedListNode tempPreNode = null;
    int nodeCount;
    for(nodeCount=0;nodeCount<currentCount;nodeCount++){ 
        if(tempNode.getData() == data){
            break;
        }
        tempPreNode= tempNode;
        tempNode = tempNode.link;
    }
    if(nodeCount == currentCount){
        throw new DataException("잘못된 자료 값");
    }
    else if(tempNode == head){
        if(currentCount == 1){
            head = null;
            currentCount = 0;
            return;
        }
        tempNode = tempNode.link;
        this.head = tempNode;
        for(int i=0;i<currentCount-2;i++){ // 순환처리
            tempNode =tempNode.link;
        }
        tempNode.link = head;
    }
    else{ // 중간 이후노드일 경우
        tempPreNode.link = tempNode.link;
    }
    currentCount--;
}
```

1. tempNode가 head를 가리키고, tempPreNode는 null을 가리키게 합니다. nodeCount는 인덱스 값을 가리킵니다.

2. for문을 사용해 현재 노드의 개수만큼 뒤로 이동하면서 data와 일치하는 값을 가진 tempNode를 찾고 tempPreNode는 tempNode의 이전 노드를 가리키게 합니다.

3. nodeCount가 현재 노드 값만큼 증가했으면 예외를 발생시킵니다.

   => 값과 일치하는 데이터가 노드에 없다!

4. 처음에 위치한 노드를 지울 경우 (위와 동일)

   1. 만약 현재 노드가 한 개인 경우 head는 null currentCount = 0으로 바꾸고 종료합니다.//

   2. tempNode를 다음 노드로 이동시킵니다.

   3. 그 노드가 head 가 됩니다.
   4. tempNode가 마지막 노드를 가리킬때까지 이동하고 그 노드의 다음 노드가 head를 가리키게 합니다. ( 순환 처리)

5. 첫 번째 이후에 위치한 노드를 지울 경우

   1. tempPreNode가 tempNode의 다음 노드를 가리키게 합니다.

6. currentCount를 한 개 감소시킵니다.



### 기타 연산들

1) 원형 연결 리스트의 초기화

``` java
void clearCircleLinkedList(){
    head = null;
    currentCount = 0;
}
```

=> 단순 연결 리스트와 동일!



2) 원형 연결 리스트 자료 값 모두 출력

``` java
void disPlayCircleLinkedList(){
    CircleLinkedListNode tempNode = head;
    for(int i=0;i<currentCount;i++){
        System.out.println("인덱스 " + i + "의 값 : " + tempNode.getData());
        tempNode = tempNode.link;
    }
}
```

=> 단순 연결 리스트와 동일!



3) 원형 연결 리스트의 길이를 출력

``` java
int getCircleLinkedListSize(){
    return currentCount;
}
```



## 원형 연결 리스트 결과 값 (by java)

``` java
public class CircleLinkedListNode {
    private int data;
    int getData(){
        return data;
    }
    CircleLinkedListNode link;
    CircleLinkedListNode(int data){
        this.data = data;
        this.link = null;
    }
}

```

``` java
public class CircleLinkedList {
    private int currentCount;
    private CircleLinkedListNode head;

    CircleLinkedList(){
        this.head = null;
        this.currentCount = 0;
    }
    void addNode(int data){
        CircleLinkedListNode newNode = new CircleLinkedListNode(data);
        if(head == null){
            head = newNode;
            newNode.link = newNode;
        }
        else{
            CircleLinkedListNode tempNode = head;
            for(int i=0;i<currentCount-1;i++) {
                tempNode = tempNode.link;
            }
            tempNode.link = newNode;
            newNode.link = head;
        }
        currentCount++;
    }
    void addNode(int index,int data)throws PositionException{
        CircleLinkedListNode newNode = new CircleLinkedListNode(data);
        CircleLinkedListNode tempNode = head;
        if(index<0||index>currentCount){
            throw new PositionException("인덱스 에러");
        }
        else if(head == null){
            head = newNode;
            newNode.link = newNode;
        }
        else if(index == 0){ // 처음에 삽입
            for(int i=0;i<currentCount-1;i++){
                tempNode = tempNode.link;
            }
            tempNode.link = newNode;
            newNode.link = head;
            head = newNode;
        }else{
            for (int i = 0; i < index-1; i++) {
                tempNode = tempNode.link;
            }
            newNode.link = tempNode.link;
            tempNode.link = newNode;
        }
        currentCount++;
    }
    void removeNodeByIndex(int index)throws PositionException{
        CircleLinkedListNode tempNode = head;
        CircleLinkedListNode tempPreNode = null;
        if(index<0 || index > currentCount-1){
            throw new PositionException("인덱스 에러");
        }
        else if(index == 0){
            if(currentCount == 1){
                head = null;
                currentCount = 0;
                return;
            }
            tempNode = tempNode.link;
            this.head = tempNode;
            for(int i=0;i<currentCount-2;i++){
                tempNode =tempNode.link;
            }
            tempNode.link = head;
        }
        else{ // 중간이후
            for(int i=0;i<index;i++){
                tempPreNode= tempNode;
                tempNode=tempNode.link;
            }
            tempPreNode.link = tempNode.link;
        }
        currentCount--;
    }
    void removeNodeByData(int data)throws DataException{
        CircleLinkedListNode tempNode = head;
        CircleLinkedListNode tempPreNode = null;
        int nodeCount;
        for(nodeCount=0;nodeCount<currentCount;nodeCount++){ // 값이 같은 노드 찾기
            if(tempNode.getData() == data){
                break;
            }
            tempPreNode= tempNode;
            tempNode = tempNode.link;
        }
        if(nodeCount == currentCount){
            throw new DataException("잘못된 자료 값");
        }
        else if(tempNode == head){
            if(currentCount == 1){
                head = null;
                currentCount = 0;
                return;
            }
            tempNode = tempNode.link;
            this.head = tempNode;
            for(int i=0;i<currentCount-2;i++){ // 순환처리
                tempNode =tempNode.link;
            }
            tempNode.link = head;
        }
        else{ // 중간 이후노드일 경우
            tempPreNode.link = tempNode.link;
        }
        currentCount--;
    }
    int getCircleLinkedListData(int index){
        CircleLinkedListNode tempNode = head;
        for(int i=0;i<index;i++){
            tempNode = tempNode.link;
        }
        return tempNode.getData();
    }
    int getCircleLinkedListSize(){
        return currentCount;
    }
    void disPlayCircleLinkedList(){
        CircleLinkedListNode tempNode = head;
        for(int i=0;i<currentCount;i++){
            System.out.println("인덱스 " + i + "의 값 : " + tempNode.getData());
            tempNode = tempNode.link;
        }
    }
    void clearCircleLinkedList(){
        head = null;
        currentCount = 0;
    }
}
```

``` java
public class CircleLinkedListExample {
    public static void main(String[] args){
        CircleLinkedList pList = new CircleLinkedList();

        try {
            pList.addNode(0,10);
            pList.addNode( 20);
            pList.addNode(2,100);
            pList.addNode(3,500);
        }catch (PositionException e){
            e.printStackTrace();
            return;
        }

        pList.disPlayCircleLinkedList();

        try{
            pList.removeNodeByIndex(0);
        }catch (PositionException e){

        }

        System.out.println("원형 연결리스트 현재 자료의 개수: " + pList.getCircleLinkedListSize());

        try {
            pList.removeNodeByData(100);
        }catch (DataException e){
            e.printStackTrace();
            return;
        }

        pList.disPlayCircleLinkedList();
        int value = pList.getCircleLinkedListData(2);
        System.out.println("인덱스 0의 값 : " + value);
    }
}
```



## 이중 연결 리스트

---

- 이전 노드로의 접근이 용이하나

- 메모리 공간을 더 많이 차지한다.
- 구현이 좀 더 복잡해 진다.

### 노드의 구조

``` java
public class DoubleLinkedListNode {
    DoubleLinkedListNode Rlink,Llink;
    private int data;
    int getData(){
        return data;
    }
    DoubleLinkedListNode(int data){
        this.data = data;
        Rlink = Llink = null;
    }
}
```

=> 단순 연결 리스트의 노드에서 link가 Rlink, Llink로 링크가 하나 추가되었다!



### 이중 연결 리스트의 구조

``` java
public class DoubleLinkedList {
    private int currentCount;
    private DoubleLinkedListNode head;
}
```

=> 동일!



### 이중 연결 리스트 생성과 값 가져오기

``` java
public class DoubleLinkedList {
   DoubleLinkedList(){
        this.currentCount = 0;
        this.head = null;
   }
}
```

=> 동일!



값 가져오기

``` java
int getDoubleLinkedListData(int index){
    DoubleLinkedListNode tempNode = head;
    for(int i=0;i<index;i++){
        tempNode = tempNode.Rlink;
    }
    return tempNode.getData();
}
```

=> 동일!



### 새로운 자료의 추가

원형 연결 리스트에서 새로운 자료를 추가하는 연산 (오버로딩)

1) 노드를 원형 연결 리스트의 맨 마지막에 추가한다.

```java
void addNode(int data){
    DoubleLinkedListNode newNode = new DoubleLinkedListNode(data);
    DoubleLinkedListNode tempNode = head;
    if(head == null){
        head = newNode;
    }
    else{
        while(tempNode.Rlink != null){
            tempNode = tempNode.Rlink;
        }
        tempNode.Rlink = newNode;
        newNode.Llink = tempNode;
    }
    currentCount++;
}
```

1. 새로운 노드를 생성한다. (추가하려는 자료를 멤버 변수로 가진다.)

   => 만약 노드가 한 개도 없다면 그 노드가 헤드가 되고 종료된다.

2. tempNode를 만들어 헤드를 타고 맨 마지막 노드를 지정한다.

3. tempNode의 다음 노드를 newNode로 만들어 준다.

4. newNode의 이전 노드를 tempNode로 만들어 준다.

5. currentCount를 한 개 증가시킨다.



2) 노드를 원형 연결 리스트의 원하는 위치에 삽입한다. 

``` java
void addNode(int index,int data)throws PositionException {
    DoubleLinkedListNode newNode = new DoubleLinkedListNode(data);
    DoubleLinkedListNode tempNode = head;
    if(index <0 || index >currentCount){ 
        throw new PositionException("잘못된 인덱스 값");
    }
    else if(index == 0){ // 처음일 경우
        head = newNode;
        newNode.Rlink = tempNode;
        if(tempNode != null) {
            tempNode.Llink = newNode;
        }
    }
    else if(index > 0 && index < currentCount ){ //중간일 경우
        for (int i = 0; i < index-1; i++) {
            tempNode = tempNode.Rlink;
        }
        newNode.Rlink = tempNode.Rlink;
        tempNode.Rlink = newNode;
        newNode.Llink = tempNode;
        tempNode.Rlink.Llink = newNode;
    }
    else{ // 마지막일 경우
        while(tempNode.Rlink!=null){
            tempNode = tempNode.Rlink;
        }
        tempNode.Rlink = newNode;
        newNode.Llink = tempNode;
    }
    currentCount++;
}
```

1. 새로운 노드를 생성한다.(추가하려는 자료를 멤버 변수로 가진다.)
2. 예외 처리 : 음수 또는 연결리스트의 현재 노드의 개수보다 더 큰 인덱스값이 들어왔을 때 예외를 발생
3. 첫 번째 자리에 노드를 추가하려는 경우
   1. 헤드를 tempNode에서 newNode로 바꿔준다.
   2. newNode의 다음 노드를 tempNode로 바꿔준다.
   3. 만약 원래 있던 노드의 개수가 1개 이상이면 tempNode의 이전노드가 newNode를 가리키게 한다.
4. 중간에 노드를 추가하려는 경우
   1. tempNode가 head를 타고 추가하려는 위치의 바로 전 위치까지 이동한다.
   2. newNode의 다음 노드를 tempNode의 다음 노드를 가리키게 바꿔준다.
   3. tempNode의 다음 노드가 newNode를 가리키게 바꿔준다.
   4. newNode의 이전 노드가 tempNode를 가리키게 바꿔준다.
   5. tempNode의 다음 노드의 이전 노드가 newNode를 가리키게 바꿔준다.
5. 마지막에 노드를 추가하려는 경우
   1. tempNode가 헤드를 타고 마지막 노드까지간다.
   2. tempNode의 다음 노드가 newNode를 가리키게 바꿔준다.
   3. newNode의 이전 노드가 tempNode를 가리키게 바꿔준다.
6. currentCount를 한 개 증가시킨다.





### 기존 자료의 제거

이중 연결 리스트에서 기존의 노드를 제거하는 연산

1) 인덱스에 의한 제거

``` java
void removeNodeByIndex(int index) throws PositionException {
    DoubleLinkedListNode tempNode = head;
    if(index<0 || index > currentCount -1){
        throw new PositionException("인덱스 에러");
    }
    else if(index == 0){
        tempNode = tempNode.Rlink;
        head = tempNode;
        if(head != null){
            tempNode.Llink = null;
        }
    }
    else if(index > 0 && index < currentCount -1){
        for(int i=0;i<index;i++){
            tempNode = tempNode.Rlink;
        }
        tempNode.Llink.Rlink = tempNode.Rlink;
        tempNode.Rlink.Llink = tempNode.Llink;
    }
    else{
        while(tempNode.Rlink.Rlink!=null){
            tempNode = tempNode.Rlink;
        }
        tempNode.Rlink = null;
    }
    currentCount--;
}
```

1. tempNode가 head를 가리킵니다.
2. 예외 처리 : 음수 또는 연결리스트의 현재 노드의 개수보다 더 큰 인덱스값이 들어왔을 때 예외를 발생
3. 처음에 위치한 노드를 지울 경우
   1. tempNode를 다음 노드로 이동시킵니다.
   2. 그 노드가 head 가 됩니다.
   3. 만약 원래 존재하던 노드가 1개 이상일 경우 tempNode의 이전 노드가 null을 가리키게 바꿔줍니다.
4. 중간에 위치한 노드를 지울 경우
   1. tempNode가 head를 타고 지우려는 노드까지 갑니다.
   2. "tempNode의 이전 노드의 다음 노드"가 "tempNode의 다음 노드"를 가리키게 바꿔줍니다.
   3. "tempNode의 다음 노드의 이전 노드"가 "tempNode의 이전 노드"를 가리키게 바꿔줍니다.
5. 마지막에 위치한 노드를 지울 경우
   1. tempNode가 마지막 노드의 이전 노드까지 갑니다.
   2. tempNode의 다음 노드가 null을 가리키게 바꿔줍니다.
6. currentCount 를 한 개 감소시킵니다.



2) 값에 의한 제거

``` java
void removeNodeByData(int data)throws DataException{
    DoubleLinkedListNode tempNode = head;
    int nodeCount = 0;
    while(tempNode != null){
        if(tempNode.getData() == data){
            break;
        }
        tempNode = tempNode.Rlink;
        nodeCount++;
    }
    if(tempNode == null){
        throw new DataException("잘못된 자료 값");
    }
    else if(tempNode == head){ // 처음
        tempNode = tempNode.Rlink;
        head = tempNode;
        if(tempNode!=null){
            tempNode.Llink = null;
        }
    }
    else if(nodeCount > 0 && nodeCount < currentCount - 1){
        tempNode.Llink.Rlink = tempNode.Rlink;
        tempNode.Rlink.Llink = tempNode.Llink;
    }
    else{
        tempNode = head;
        while (tempNode.Rlink.Rlink!=null){
            tempNode = tempNode.Rlink;
        }
        tempNode.Rlink = null;
    }
    currentCount--;
}
```

1. tempNode가 head를 가리킵니다. nodeCount변수는 인덱스 값을 가르킵니다.
2. while문을 사용해 tempNode를 한 칸씩 뒤로 이동하면서 검사하고, data와 일치하는 값이 있으면 반복문을 종료시킵니다.
3. tempNode가 null을 가리키면( data와 일치하는 값이 노드에 없으면 ) 예외를 발생시킵니다.
4. 처음에 위치한 노드를 지울 경우 (위와 동일)
   1. tempNode를 다음 노드로 이동시킵니다.
   2. 그 노드가 head 가 됩니다. 
   3. 만약 원래 존재하던 노드가 1개 이상일 경우 tempNode의 이전 노드가 null을 가리키게 바꿔줍니다.
5. 중간에 위치한 노드를 지울 경우
   1. "tempNode의 이전 노드의 다음 노드"가 "tempNode의 다음 노드"를 가리키게 바꿔줍니다.
   2. "tempNode의 다음 노드의 이전 노드"가 "tempNode의 이전 노드"를 가리키게 바꿔줍니다.
6. 마지막에 위치한 노드를 지울 경우
   1. tempNode가 마지막 노드의 이전 노드까지 갑니다.
   2. tempNode의 다음 노드가 null을 가리키게 바꿔줍니다.
7. currentCount를 한 개 감소시킵니다.



### 기타 연산들

1) 이중 연결 리스트의 초기화

``` java
void clearDoubleLinkedList(){
    head = null;
    currentCount = 0;
}
```

=> 동일!



2) 이중 연결 리스트 자료 값 모두 출력

```java
void disPlayList(){
    DoubleLinkedListNode tempNode = head;
    System.out.println("disPlayList");
    for(int i=0;i<currentCount;i++){
        System.out.println("인덱스 " + i + "의 값 : " + tempNode.getData());
        tempNode = tempNode.Rlink;
    }
}
```

=> 동일!



3) 이중 연결 리스트의 길이를 출력

```java
int getDoubleLinkedListLength(){
    return currentCount;
}
```

=> 동일!



## 이중 연결 리스트 결과 값 (by java)

``` java
public class DoubleLinkedListNode {
    DoubleLinkedListNode Rlink,Llink;
    private int data;
    int getData(){
        return data;
    }
    DoubleLinkedListNode(int data){
        this.data = data;
        Rlink = Llink = null;
    }
}
```

```java
public class DoubleLinkedList {
    private int currentCount;
    private DoubleLinkedListNode head;

    DoubleLinkedList(){
        this.currentCount = 0;
        this.head = null;
    }

    void addNode(int data){
         DoubleLinkedListNode newNode = new DoubleLinkedListNode(data);
         DoubleLinkedListNode tempNode = head;
         if(head == null){
             head = newNode;
         }
         else{
             while(tempNode.Rlink != null){
                 tempNode = tempNode.Rlink;
             }
             tempNode.Rlink = newNode;
             newNode.Llink = tempNode;
         }
         currentCount++;
    }
    void addNode(int index,int data)throws PositionException {
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(data);
        DoubleLinkedListNode tempNode = head;
        if(index <0 || index >currentCount){ // 음수 또는 연결리스트보다 큰 인덱스 예외
            throw new PositionException("잘못된 인덱스 값");
        }
        else if(index == 0){ // 처음일 경우
            head = newNode;
            newNode.Rlink = tempNode;
            if(tempNode != null) {
                tempNode.Llink = newNode;
            }
        }
        else if(index > 0 && index < currentCount ){ //중간일 경우
            for (int i = 0; i < index-1; i++) {
                tempNode = tempNode.Rlink;
            }
            newNode.Rlink = tempNode.Rlink;
            tempNode.Rlink = newNode;
            newNode.Llink = tempNode;
            tempNode.Rlink.Llink = newNode;
        }
        else{ // 마지막일 경우
            while(tempNode.Rlink!=null){
                tempNode = tempNode.Rlink;
            }
            tempNode.Rlink = newNode;
            newNode.Llink = tempNode;
        }
        currentCount++;
    }
    void removeNodeByIndex(int index) throws PositionException {
        DoubleLinkedListNode tempNode = head;
        if(index<0 || index > currentCount -1){
            throw new PositionException("인덱스 에러");
        }
        else if(index == 0){
            tempNode = tempNode.Rlink;
            head = tempNode;
            if(head != null){
                tempNode.Llink = null;
            }
        }
        else if(index > 0 && index < currentCount -1){
            for(int i=0;i<index;i++){
                tempNode = tempNode.Rlink;
            }
            tempNode.Llink.Rlink = tempNode.Rlink;
            tempNode.Rlink.Llink = tempNode.Llink;
        }
        else{
            while(tempNode.Rlink.Rlink!=null){
                tempNode = tempNode.Rlink;
            }
            tempNode.Rlink = null;
        }
        currentCount--;
    }
    void removeNodeByData(int data)throws DataException{
        DoubleLinkedListNode tempNode = head;
        int nodeCount = 0;
        while(tempNode != null){
            if(tempNode.getData() == data){
                break;
            }
            tempNode = tempNode.Rlink;
            nodeCount++;
        }
        if(tempNode == null){
            throw new DataException("잘못된 자료 값");
        }
        else if(tempNode == head){ // 처음
            tempNode = tempNode.Rlink;
            head = tempNode;
            if(tempNode!=null){
                tempNode.Llink = null;
            }
        }
        else if(nodeCount > 0 && nodeCount < currentCount - 1){
            tempNode.Llink.Rlink = tempNode.Rlink;
            tempNode.Rlink.Llink = tempNode.Llink;
        }
        else{
            tempNode = head;
            while (tempNode.Rlink.Rlink!=null){
                tempNode = tempNode.Rlink;
            }
            tempNode.Rlink = null;
        }
        currentCount--;
    }
    void disPlayList(){
        DoubleLinkedListNode tempNode = head;
        System.out.println("disPlayList");
        for(int i=0;i<currentCount;i++){
            System.out.println("인덱스 " + i + "의 값 : " + tempNode.getData());
            tempNode = tempNode.Rlink;
        }
    }
    int getDoubleLinkedListData(int index){
        DoubleLinkedListNode tempNode = head;
        for(int i=0;i<index;i++){
            tempNode = tempNode.Rlink;
        }
        return tempNode.getData();
    }
    int getDoubleLinkedListLength(){
        return currentCount;
    }
    void clearDoubleLinkedList(){
        head = null;
        currentCount = 0;
    }
}
```

```java
public class DoubleLinkedListExample {
    public static void main(String[] args){
        DoubleLinkedList pList = new DoubleLinkedList();

        try {
            pList.addNode(0,10);
            pList.addNode( 1,20);
            pList.addNode(2,400);
            pList.addNode(30);
        }catch (PositionException e){
            e.printStackTrace();
            return;
        }

        pList.disPlayList();

        try{
            pList.removeNodeByIndex(2);
        }catch (PositionException e){
            e.printStackTrace();
            return;
        }

        System.out.println("이중 연결 리스트 현재 노드의 개수 : " + pList.getDoubleLinkedListLength());

        try{
            pList.removeNodeByData(30);
        }catch (DataException e){
            e.printStackTrace();
            return;
        }

        pList.disPlayList();
        System.out.println("인덱스 0의 값 : " + pList.getDoubleLinkedListData(0));
    }
}
```



## 연결 리스트의 응용 : 다항식

---

다항식의 정의 : 계수와 차수로 정의되는 항들의 집합

ex) 3x^5 + 8x + 1



### 다항식의 자료구조 정의

다항식은 항들의 집합이다. 그리고 하나의 항은 double형의 계수와 int형의 차수 속성을 가지게된다.

=> double형과 int형을 자료값으로 가진 연결 리스트를 만들면 다항식을 리스트로 만들 수 있다.



다항식의 항을 나타내는 구조체

``` java
public class DataBox {
    private int degree;
    private double coef;
    int getDegree(){
        return degree;
    }
    double getCoef(){
        return coef;
    }
    DataBox(int degree,double coef){
        this.degree = degree;
        this.coef = coef;
    }
}
```



다항식의 노드를 나타내는 구조체

``` java
public class LinkedListNode {
    LinkedListNode link;
    DataBox data;
    LinkedListNode(DataBox data){
        this.data = data;
        this.link = null;
    }
}
```



다항식을 나타내는 구조체

```java
public class LinkedList {
    private LinkedListNode head;
    private int currentCount;
}
```

=> 다항식을 구성하는 항들이 각각의 노드로 표현되어 있다!



### 다항식의 기본 연산

다항식을 만들기 위해선 기본적으로 단순 연결 리스트에서의

- createLinkedList
- removeNode
- addLNode
- getLinkedListData
- getLinkedListLength

등의 함수가 구현되어 있어야 한다.

``` java
// 연결 리스트를 생성하는 함수
LinkedList(){
    this.head = null;
    this.currentCount = 0;
}
// 노드 하나를 마지막에 추가하는 함수(항)
void addNode(DataBox data){
    LinkedListNode newNode = new LinkedListNode(data);
    LinkedListNode tempNode = head;
    if(head==null){
        head = newNode;
    }
    else{
        while(tempNode.link != null){
            tempNode=tempNode.link;
        }
        tempNode.link = newNode;
    }
    currentCount++;
}
// 노드 하나를 지우는 함수(인덱스)
void removeNode(int index)throws PositionException{
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
// 노드하나의 값을 출력하는 함수
DataBox getLinkedListData(int index)throws PositionException{
    LinkedListNode tempNode = head;
    if(index > currentCount-1){
        throw new PositionException("인덱스 에러");
    }
    for(int i=0;i<index;i++){
        tempNode = tempNode.link;
    }
    return tempNode.data;
}
// 다항식의 길이를 출력하는 함수
int getLinkedListLength(){
    return currentCount;
}
```

=> 단순 연결 리스트와 동일!



### 다항식의 항 추가 연산과 출력 연산

 차수와 계수를 입력받아 다항식의 마지막 위치에 추가해주는 함수.

``` java
void addNode(int degree,double coef){
    DataBox dataBox = new DataBox(degree,coef);
    addNode(dataBox);
}
```



현재 연결 리스트에 저장된 다항식을 출력하는 함수

``` java
void disPlayLinkedList(){
    LinkedListNode tempNode = head;
    int i = 0;
    if(head == null){
        System.out.println("자료가 없습니다.");
        return;
    }
    while(tempNode!=null){
        if(i>0){
            System.out.print(" + ");
        }
        if(tempNode.data.getDegree() == 0) {
            System.out.print(tempNode.data.getCoef());
        }else{
            System.out.print(tempNode.data.getCoef() + "x^" + tempNode.data.getDegree());
        }
        i++;
        tempNode = tempNode.link;

    }
    System.out.println();
}
```

=> 노드를 하나씩 순회하면서 3x^2 + 4x^1 + 7 같은 형식으로 항을 다항식을 출력시켜준다.



### 다항식 더하기 연산

두 개의 항을 더하는 연산을 한다.

조건 1)

- "높은 차수부터 낮은 차수 순"으로 항을 저장하고 있는 연결 리스트를 순회하면서 연산을 수행한다.

조건 2)

1. 다항식 AList에만 항이 있는 경우

   => AList에만 있는 항을 연결 리스트에 추가한다.

2. 다항식 AList와 다항식 BList에 모두 항이 있는 경우

   => AList와 BList의 항 두개를 더해서 연결 리스트에 추가한다.

3. 다항식 BList에만 항이 있는 경우

   => BList에만 있는 항을 연결 리스트에 추가한다.

4. (후처리) 한쪽 다항식에 더 이상 남은 항이 없는 경우

   => 항이 남은 다항식의 남은 항들을 연결 리스트에 추가한다.



``` java
LinkedList AddList(LinkedList pList){
    double coefSum = 0;
    
    // 반환할 새로운 리스트를 생성한다.
    LinkedList newList = new LinkedList();
    LinkedListNode ANode = head;
    LinkedListNode BNode = pList.head;
	// ANode와 BNode가 null을 가리킬때 까지!
    if(ANode != null && BNode != null) {
        while (ANode != null && BNode != null) {
            int degreeA = ANode.data.getDegree();
            int degreeB = BNode.data.getDegree();
            // 1) ANode의 차수가 더 큰 경우
            if (degreeA > degreeB) {
                coefSum = ANode.data.getCoef();
                newList.addNode(degreeA, coefSum);
                ANode = ANode.link;
            // 2) ANode와 BNode의 차수가 동일한 경우
            } else if (degreeA == degreeB) {
                coefSum = ANode.data.getCoef() + BNode.data.getCoef();
                if(coefSum == 0){
                    ANode = ANode.link;
                    BNode = BNode.link;
                    break;
                }
                newList.addNode(degreeA, coefSum);
                ANode = ANode.link;
                BNode = BNode.link;
            // 3) BNode의 차수가 더 큰 경우
            } else {
                coefSum = BNode.data.getCoef();
                newList.addNode(degreeB, coefSum);
                BNode = BNode.link;
            }
        }
        // 4) 후처리
        // 4-1) ANode에만 항이 남은 경우
        while (ANode != null) {
            coefSum = ANode.data.getCoef();
            newList.addNode(ANode.data.getDegree(), coefSum);
            ANode = ANode.link;
        }
        // 4-2) BNode에만 항이 남은 경우
        while (BNode != null) {
            coefSum = BNode.data.getCoef();
            newList.addNode(BNode.data.getDegree(), coefSum);
            BNode = BNode.link;
        }
    }
    else{
        System.out.println("오류");
    }
	
    // 그 리스트를 반환한다.
    return newList;
}
```

1) ANode의 차수가 더 큰 경우

1. ANode의 계수를 coefSum에 저장
2. newList에 coefSum과 A의 차수를 저장한 노드를 추가
3. ANode가 다음 노드로 이동



2) ANode와 BNode의 차수가 동일한 경우

 1. ANode의 계수와 BNode의 계수의 합을 coefSum에 저장

    => 만약 0이면 ANode와 BNode를 다음 노드로 보내고 종료

 2. newList에 coefSum과 A의 차수를 저장한 노드를 추가

 3. ANode와 BNode가 다음 노드로 이동



3) BNode의 차수가 더 큰 경우

1. BNode의 계수를 coefSum에 저장
2. newList에 coefSum과 B의 차수를 저장한 노드를 추가
3. BNode가 다음 노드로 이동



4) 후처리

 1. ANode에만 항이 남은 경우

    => ANode의 남은 항들을 newList에 추가

 2. BNode에만 항이 남은 경우

    => BNode의 남은 항들을 newList에 추가

    

### 다항식 빼기 연산

두 개의 항을 빼는 연산을 한다.

조건)

1. 다항식 AList에만 항이 있는 경우

   => AList에만 있는 항을 연결 리스트에 추가한다.

2. 다항식 AList와 다항식 BList에 모두 항이 있는 경우

   => AList에서 BList의 계수를 빼서 연결 리스트에 추가한다.

3. 다항식 BList에만 항이 있는 경우

   => BList에만 있는 항에서 계수에 -를 붙여 연결 리스트에 추가한다.

4. (후처리) 한쪽 다항식에 더 이상 남은 항이 없는 경우

   1. ANode가 항이 남은 경우

      => 그대로 추가한다.

   2. BNode가 항이 남은 경우

      => 계수에 -를 붙여 추가한다.



``` java
LinkedList SubList(LinkedList pList){
    LinkedList newList = new LinkedList();
    double coefSum = 0;
    LinkedListNode ANode = head;
    LinkedListNode BNode = pList.head;

    if(ANode != null && BNode != null) {
        while (ANode != null && BNode != null) {
            int degreeA = ANode.data.getDegree();
            int degreeB = BNode.data.getDegree();
            if (degreeA > degreeB) {
                coefSum = ANode.data.getCoef();
                newList.addNode(degreeA, coefSum);
                ANode = ANode.link;
            } else if (degreeA == degreeB) {
                coefSum = ANode.data.getCoef() - BNode.data.getCoef();
                if(coefSum == 0){
                    ANode = ANode.link;
                    BNode = BNode.link;
                    break;
                }
                newList.addNode(degreeA, coefSum);
                ANode = ANode.link;
                BNode = BNode.link;
            } else {
                coefSum = -BNode.data.getCoef();
                newList.addNode(degreeB, coefSum);
                BNode = BNode.link;
            }
        }
        while (ANode != null) {
            coefSum = ANode.data.getCoef();
            newList.addNode(ANode.data.getDegree(), coefSum);
            ANode = ANode.link;
        }
        while (BNode != null) {
            coefSum = -BNode.data.getCoef();
            newList.addNode(BNode.data.getDegree(), coefSum);
            BNode = BNode.link;
        }
    }
    else{
        System.out.println("오류");
    }

    return newList;
}
```

1) ANode의 차수가 더 큰 경우

 	1. ANode의 계수를 coefSum에 저장
 	2. newList에 coefSum과 A의 차수를 저장한 노드를 추가
 	3. ANode가 다음 노드로 이동



2) ANode와 BNode의 차수가 동일한 경우

 1. ANode의 계수와 BNode의 계수의 차를 coefSum에 저장

    => 만약 0이면 ANode와 BNode를 다음 노드로 보내고 종료

 2. newList에 coefSum과 A의 차수를 저장한 노드를 추가

 3. ANode와 BNode가 다음 노드로 이동



3) BNode의 차수가 더 큰 경우

 	1. BNode의 계수에 -를 붙여 coefSum에 저장
 	2. newList에 coefSum과 B의 차수를 저장한 노드를 추가
 	3. BNode가 다음 노드로 이동



4) 후처리

 1. ANode에만 항이 남은 경우

    => ANode의 남은 항들을 newList에 추가

 2. BNode에만 항이 남은 경우

    => BNode의 남은 항들을 계수에 -를 붙여 newList에 추가



## 다항식 결과 값 (by java)

``` java
public class DataBox {
    private int degree;
    private double coef;
    int getDegree(){
        return degree;
    }
    double getCoef(){
        return coef;
    }
    protected DataBox(int degree,double coef){
        this.degree = degree;
        this.coef = coef;
    }
}
```

``` java
public class LinkedListNode {
    protected LinkedListNode link;
    protected DataBox data;
    LinkedListNode(DataBox data){
        this.data = data;
        this.link = null;
    }
}
```

``` java
import ch3.singlelinkedlist.PositionException;

public class LinkedList {
    private LinkedListNode head;
    private int currentCount;
    LinkedList(){
        this.head = null;
        this.currentCount = 0;
    }
    void addNode(DataBox data){
        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode tempNode = head;
        if(head==null){
            head = newNode;
        }
        else{
            while(tempNode.link != null){
                tempNode=tempNode.link;
            }
            tempNode.link = newNode;
        }
        currentCount++;
    }
    void addNode(int degree,double coef){
        DataBox dataBox = new DataBox(degree,coef);
        addNode(dataBox);
    }
    void removeNode(int index)throws PositionException{
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
    DataBox getLinkedListData(int index)throws PositionException{
        LinkedListNode tempNode = head;
        if(index > currentCount-1){
            throw new PositionException("인덱스 에러");
        }
        for(int i=0;i<index;i++){
            tempNode = tempNode.link;
        }
        return tempNode.data;
    }
    int getLinkedListLength(){
        return currentCount;
    }
    void disPlayLinkedList(){
        LinkedListNode tempNode = head;
        int i = 0;
        if(head == null){
            System.out.println("자료가 없습니다.");
            return;
        }
        while(tempNode!=null){
            if(i>0){
                System.out.print(" + ");
            }
            if(tempNode.data.getDegree() == 0) {
                System.out.print(tempNode.data.getCoef());
            }else{
                System.out.print(tempNode.data.getCoef() + "x^" + tempNode.data.getDegree());
            }
            i++;
            tempNode = tempNode.link;

        }
        System.out.println();
    }
    LinkedList AddList(LinkedList pList){
        double coefSum = 0;
        LinkedList newList = new LinkedList();
        LinkedListNode ANode = head;
        LinkedListNode BNode = pList.head;

        if(ANode != null && BNode != null) {
            while (ANode != null && BNode != null) {
                int degreeA = ANode.data.getDegree();
                int degreeB = BNode.data.getDegree();
                if (degreeA > degreeB) {
                    coefSum = ANode.data.getCoef();
                    newList.addNode(degreeA, coefSum);
                    ANode = ANode.link;
                } else if (degreeA == degreeB) {
                    coefSum = ANode.data.getCoef() + BNode.data.getCoef();
                    if(coefSum == 0){
                        ANode = ANode.link;
                        BNode = BNode.link;
                        break;
                    }
                    newList.addNode(degreeA, coefSum);
                    ANode = ANode.link;
                    BNode = BNode.link;
                } else {
                    coefSum = BNode.data.getCoef();
                    newList.addNode(degreeB, coefSum);
                    BNode = BNode.link;
                }
            }
            while (ANode != null) {
                coefSum = ANode.data.getCoef();
                newList.addNode(ANode.data.getDegree(), coefSum);
                ANode = ANode.link;
            }
            while (BNode != null) {
                coefSum = BNode.data.getCoef();
                newList.addNode(BNode.data.getDegree(), coefSum);
                BNode = BNode.link;
            }
        }
        else{
            System.out.println("오류");
        }

        return newList;
    }
    LinkedList SubList(LinkedList pList){
        LinkedList newList = new LinkedList();
        double coefSum = 0;
        LinkedListNode ANode = head;
        LinkedListNode BNode = pList.head;

        if(ANode != null && BNode != null) {
            while (ANode != null && BNode != null) {
                int degreeA = ANode.data.getDegree();
                int degreeB = BNode.data.getDegree();
                if (degreeA > degreeB) {
                    coefSum = ANode.data.getCoef();
                    newList.addNode(degreeA, coefSum);
                    ANode = ANode.link;
                } else if (degreeA == degreeB) {
                    coefSum = ANode.data.getCoef() - BNode.data.getCoef();
                    if(coefSum == 0){
                        ANode = ANode.link;
                        BNode = BNode.link;
                        break;
                    }
                    newList.addNode(degreeA, coefSum);
                    ANode = ANode.link;
                    BNode = BNode.link;
                } else {
                    coefSum = -BNode.data.getCoef();
                    newList.addNode(degreeB, coefSum);
                    BNode = BNode.link;
                }
            }
            while (ANode != null) {
                coefSum = ANode.data.getCoef();
                newList.addNode(ANode.data.getDegree(), coefSum);
                ANode = ANode.link;
            }
            while (BNode != null) {
                coefSum = -BNode.data.getCoef();
                newList.addNode(BNode.data.getDegree(), coefSum);
                BNode = BNode.link;
            }
        }
        else{
            System.out.println("오류");
        }

        return newList;
    }
}
```

``` java
public class LinkedListExample {
    public static void main(String[] args){
        LinkedList AList = new LinkedList();
        AList.addNode(6,7);
        AList.addNode(new DataBox(5,3));
        AList.addNode(new DataBox(2,5));
        AList.disPlayLinkedList();

        LinkedList BList = new LinkedList();
        BList.addNode(5,1);
        BList.addNode(4,2);
        BList.addNode(2,-5);
        BList.addNode(0,4);
        BList.disPlayLinkedList();

        LinkedList A = new LinkedList();
        A = AList.AddList(BList);
        A.disPlayLinkedList();

        LinkedList B = new LinkedList();
        B = AList.SubList(BList);
        B.disPlayLinkedList();

    }
}
```



