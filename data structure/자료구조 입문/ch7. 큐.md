# ch7. 큐

---



## 큐란?

---

큐(Queue) : 자료를 차례대로 저장하는 선형 자료구조

- 자료를 맨 뒤에 추가함
- 맨 앞의 자료를 제거해서 반복함

- FIFO : First In First Out (선입선출)

![다운로드 (14)](C:\Users\user\Downloads\다운로드 (14).png)

## 큐의 사용 시나리오

---

큐의 첫 번째 자료가 들어있는 자리를 : front

큐의 마지막 자료가 들어있는 자리를 : rear 



### 인큐 연산

- rear자리에 자료를 추가한다.
- 배열 큐의 경우 : 저장할 수 있는 자료의 개수가 정해져 있기 때문에 최대 자료의 개수를 넘어가면 오버플로우 발생



### 디큐 연산

- front자리의 자료를 제거하고 그 값을 반환한다.
- 자료가 한 개도 저장되어있지 않은데 디큐연산을 실행할 경우 언더플로우가 발생



### 피크 연산

- front자리의 자료를 반환한다.
- 자료가 한 개도 저장되어있지 않은데 디큐연산을 실행할 경우 언더플로우가 발생



## 큐의 추상 자료형

---

큐의 추상 자료형 표

| 이름                     | -             | 입력        | 출력             | 설명                                                         |
| ------------------------ | ------------- | ----------- | ---------------- | ------------------------------------------------------------ |
| 큐 생성                  | createQueue() | 큐의 크기 n | 큐 q             | 빈 큐 q를 생성                                               |
| 큐 삭제                  | deleteQueue() | 큐 q        | N / A            | 큐의 메모리를 해제                                           |
| 자료 추가 가능 여부 판단 | isFull()      | 큐 q        | True / False     | 큐에 인큐를 수행할 수 있는지를 반환,(배열 큐인 경우에만 의미 있음) |
| 빈 큐인지 판단           | isEmpty()     | 큐 q        | True / False     | 빈 큐인지를 반환                                             |
| 인큐                     | enqueue()     | 큐 q        | 성공 / 실패 여부 | 큐의 맨 뒤에 새로운 자료를 추가                              |
| 디큐                     | dequeue()     | 자료 data   | 자료             | 큐의 맨 앞에 있는 자료를 제거한 뒤 이를 반환                 |
| 피크                     | peek()        | 큐 q        | 자료             | 큐의 맨 앞에 있는 자료를 반환(큐에서 제거하지는 않음)        |



## 배열로 구현한 선형 큐

---

- 배열 선형 큐라고 함
- 인큐와 디큐를 반복하면 앞 부분부터 빈 곳이 생김 -> 최대 자료의 저장 개수보다 적은 자료의 개수 저장가능



노드의 구조

```java
public class ArrayQueueNode {
    private char data;
    public void setData(char data){
        this.data=data;
    }
    public char getData(){
        return data;
    }
}
```



큐의 구조

```java
public class ArrayQueue {
    private int currentCount;
    private int maxCount;
    private int front;
    private int rear;
    private ArrayQueueNode[] element = null;
}
```



큐의 생성

```java
public ArrayQueue(int count) throws IndexException{
    if(count<0){
        throw new IndexException("0보다 작은 숫자가 입력됨");
    }
    this.maxCount = count;
    this.currentCount = 0;
    this.front = -1;
    this.rear = -1;
    this.element = new ArrayQueueNode[count];
}
```

- 예외 처리
- 최대 노드의 개수, 현재 노드의 개수, 맨 앞, 맨 뒤 초기화, 배열 할당



큐가 비어 있는가?

```java
public int isArrayQueueEmpty(){
    if(currentCount == 0){
        return 1;
    }
    return -1;
}
```



큐가 꽉차 있는가?

```java
public int isArrayQueueFull(){
    if(rear == maxCount-1 ||  currentCount == maxCount){
        return 1;
    }
    else{
        return -1;
    }
}
```



인큐 연산

```java
public int enqueueAQ(char data){
    if(isArrayQueueFull() == 1){ // 배열이 꽉차 있다!
        return -1;
    }
    rear++;
    element[rear] = new ArrayQueueNode();
    element[rear].setData(data);
    currentCount++;
    return 1;
}
```

- rear 값을 하나 추가한다.
- rear 값에 데이터를 저장한다.
- currentCount를 하나 추가한다. -> 성공 반환 1



디큐 연산

```java
public ArrayQueueNode dequeueAQ(){
    ArrayQueueNode data = null;
    if(isArrayQueueEmpty() == 1){
        return null;
    }
    if(front != -1){
        element[front] = null;
    }
    front++;
    data = element[front];
    currentCount--;
    return data;
}
```

- front 값을 하나 추가한다.
- data라는 큐노드에 front값 저장한다.
- currentCount를 하나 감소시킨다. -> 값을 반환한다.



피크 연산

```java
public ArrayQueueNode peekAQ(){
    if(isArrayQueueEmpty() == 1){
        return null;
    }
    return element[front+1];
}
```

- front+1 의 값을 반환한다.



큐 초기화

```java
public void deleteAQ(){
    for(int i=0;i<maxCount;i++){
        element[i] = null;
    }
    front = -1;
    rear = -1;
    currentCount = 0;
}
```

- 변수들을 초기화 해준다.



큐 값 순회

```java
public void disPlayAQ(){
    if(currentCount==0){
        System.out.println("큐가 비어있습니다.");
        return;
    }
    System.out.println("큐의 크기: " + maxCount + ", 현재 노드 개수: " + currentCount);
    for(int i = front+1;i<=rear;i++){
        System.out.println(i + "-" + element[i].getData());
    }
}
```

- front부터 rear까지의 값을 하나씩 순회하면서 출력한다.



선형 큐 예시)

```java
public class ArrayQueueNode {
    private char data;
    public void setData(char data){
        this.data=data;
    }
    public char getData(){
        return data;
    }
}
```

```java
import ch5.arraystack.IndexException;

public class ArrayQueue {
    private int currentCount;
    private int maxCount;
    private int front;
    private int rear;
    private ArrayQueueNode[] element = null;
    public ArrayQueue(int count) throws IndexException{
        if(count<0){
            throw new IndexException("0보다 작은 숫자가 입력됨");
        }
        this.maxCount = count;
        this.currentCount = 0;
        this.front = -1;
        this.rear = -1;
        this.element = new ArrayQueueNode[count];
    }
    public int enqueueAQ(char data){
        if(isArrayQueueFull() == 1){ // 배열이 꽉차 있다!
            return -1;
        }
        rear++;
        element[rear] = new ArrayQueueNode();
        element[rear].setData(data);
        currentCount++;
        return 1;
    }
    public ArrayQueueNode dequeueAQ(){
        ArrayQueueNode data = null;
        if(isArrayQueueEmpty() == 1){
            return null;
        }
        front++;
        data = element[front];
        currentCount--;
        return data;
    }
    public ArrayQueueNode peekAQ(){
        if(isArrayQueueEmpty() == 1){
            return null;
        }
        return element[front+1];
    }
    public int isArrayQueueEmpty(){
        if(currentCount == 0){
            return 1;
        }
        return -1;
    }
    public int isArrayQueueFull(){
        if(rear == maxCount-1 ||  currentCount == maxCount){
            return 1;
        }
        else{
            return -1;
        }
    }
    public void deleteAQ(){
        for(int i=0;i<maxCount;i++){
            element[i] = null;
        }
        front = -1;
        rear = -1;
        currentCount = 0;
    }
    public void disPlayAQ(){
        if(currentCount==0){
            System.out.println("큐가 비어있습니다.");
            return;
        }
        System.out.println("큐의 크기: " + maxCount + ", 현재 노드 개수: " + currentCount);
        for(int i = front+1;i<=rear;i++){
            System.out.println(i + "-" + element[i].getData());
        }
    }
}
```

```java
import ch5.arraystack.IndexException;

public class ArrayQueueExample {
    public static void main(String[] args) {
        ArrayQueue queue = null;
        ArrayQueueNode node = null;
        try {
            queue = new ArrayQueue(4);
        } catch (IndexException e) {
            e.printStackTrace();
            return;
        }
        queue.enqueueAQ('A');
        queue.enqueueAQ('B');
        queue.enqueueAQ('C');
        queue.enqueueAQ('D');
        queue.disPlayAQ();

        node = queue.dequeueAQ();
        System.out.println("Dequeue Value-" + node.getData());
        queue.disPlayAQ();

        node = queue.peekAQ();
        System.out.println("Peek Value-" + node.getData());
        queue.disPlayAQ();

        queue.enqueueAQ('E'); // 인큐 연산의 실패
        queue.disPlayAQ();

        queue.deleteAQ();
        queue.disPlayAQ();
    }
}
```



## 배열로 구현한 원형 큐

---

- 배열 원형 큐라고 함
- 선형 큐의 단점을 해결 ( 인큐와 디큐의 반복시 비는 공간을 채워주는 큐 )
- 배열 선형 큐와 노드, 큐의 구조는 동일하다.!

```java
rear = (rear + 1) % maxCount // rear의 값을 하나 증가시키고 큐의 최대 크기로 나눈다.
```



인큐 연산

```java
public int enqueueAQ(char data){
    if(isArrayQueueFull() == 1){ // 배열이 꽉차 있다!
        return -1;
    }
    rear = (rear+1) % maxCount;
    element[rear] = new ArrayCircleQueueNode();
    element[rear].setData(data);
    currentCount++;
    return 1;
}
```

- rear의 값을 하나 증가시키고 큐의 최대 크기로 나눈다. -> rear값이 앞으로 돌아간다.



디큐 연산

```java
public ArrayCircleQueueNode dequeueAQ(){
    ArrayCircleQueueNode data = null;
    if(isArrayQueueEmpty() == 1){
        return null;
    }
    if(front != -1){
        element[front] = null;
    }
    front=(front+1)%maxCount;
    data = element[front];
    currentCount--;
    return data;
}
```

- front의 값을 하나 증가시키고 큐의 최대 크기로 나눈다. -> front값이 앞으로 돌아간다.
  

큐 값 순회

```java
public void disPlayAQ(){
    if(currentCount==0){
        System.out.println("큐가 비어있습니다.");
        return;
    }
    System.out.println("큐의 크기: " + maxCount + ", 현재 노드 개수: " + currentCount);
    for(int i = front+1;i<=front+currentCount;i++){
        int position = i % maxCount;
        System.out.println(position + "-" + element[position].getData());
    }
}
```

- 배열 원형 큐의 경우 rear가 front의 앞에 있는 경우가 생긴다.
- front부터 front+현재 노드의 개수 만큼 반복하는데
  - i를 배열의 최대 크기로 나눠주면 맨 앞에서부터 하나 씩 출력된다.



원형 큐 예시)

```java
public class ArrayCircleQueueNode {
    public ArrayCircleQueueNode(){}
    private char data;
    public void setData(char data){
        this.data=data;
    }
    public char getData(){
        return data;
    }
}
```

```java
import ch5.arraystack.IndexException;

public class ArrayCircleQueue {
    private int currentCount;
    private int maxCount;
    private int front;
    private int rear;
    private ArrayCircleQueueNode[] element = null;
    public ArrayCircleQueue(int count) throws IndexException {
        if(count<0){
            throw new IndexException("0보다 작은 숫자가 입력됨");
        }
        this.maxCount = count;
        this.currentCount = 0;
        this.front = -1;
        this.rear = -1;
        this.element = new ArrayCircleQueueNode[count];
    }
    public int enqueueAQ(char data){
        if(isArrayQueueFull() == 1){ // 배열이 꽉차 있다!
            return -1;
        }
        rear = (rear+1) % maxCount;
        element[rear] = new ArrayCircleQueueNode();
        element[rear].setData(data);
        currentCount++;
        return 1;
    }
    public ArrayCircleQueueNode dequeueAQ(){
        ArrayCircleQueueNode data = null;
        if(isArrayQueueEmpty() == 1){
            return null;
        }
        if(front != -1){
            element[front] = null;
        }
        front=(front+1)%maxCount;
        data = element[front];
        currentCount--;
        return data;
    }
    public ArrayCircleQueueNode peekAQ(){
        if(isArrayQueueEmpty() == 1){
            return null;
        }
        return element[front+1];
    }
    public int isArrayQueueEmpty(){
        if(currentCount == 0){
            return 1;
        }
        return -1;
    }
    public int isArrayQueueFull(){
        if(currentCount == maxCount){
            return 1;
        }
        else{
            return -1;
        }
    }
    public void deleteAQ(){
        for(int i=0;i<maxCount;i++){
            element[i] = null;
        }
        front = -1;
        rear = -1;
        currentCount = 0;
    }
    public void disPlayAQ(){
        if(currentCount==0){
            System.out.println("큐가 비어있습니다.");
            return;
        }
        System.out.println("큐의 크기: " + maxCount + ", 현재 노드 개수: " + currentCount);
        for(int i = front+1;i<=front+currentCount;i++){
            int position = i % maxCount;
            System.out.println(position + "-" + element[position].getData());
        }
    }
}
```

```java
import ch5.arraystack.IndexException;

public class ArrayCircleQueueExample {
    public static void main(String[] args) {
        ArrayCircleQueue queue = null;
        ArrayCircleQueueNode node = null;
        try {
            queue = new ArrayCircleQueue(4);
        } catch (IndexException e) {
            e.printStackTrace();
            return;
        }
        queue.enqueueAQ('A');
        queue.enqueueAQ('B');
        queue.enqueueAQ('C');
        queue.enqueueAQ('D');
        queue.disPlayAQ();

        node = queue.dequeueAQ();
        System.out.println("Dequeue Value-" + node.getData());
        queue.disPlayAQ();

        node = queue.peekAQ();
        System.out.println("Peek Value-" + node.getData());
        queue.disPlayAQ();

        queue.enqueueAQ('E'); // 인큐 연산의 실패
        queue.disPlayAQ();

        queue.deleteAQ();
        queue.disPlayAQ();
    }
}
```



## 포인터로 구현한 큐

---

- 연결 큐라고 함
- 연결 큐를 연결 리스트로 구현한 것이다.
- isFull()로 큐가  꽉찼는지 검사할 필요가 없다 -> maxCount가 필요 없다.



노드의 구조

```java
public class LinkedQueueNode {
    private char data;
    private LinkedQueueNode link;
    public LinkedQueueNode(char data){
        this.data = data;
    }
    public char getData(){
        return data;
    }
    public void setLink(LinkedQueueNode link){
        this.link = link;
    }
    public LinkedQueueNode getLink(){
        return link;
    }
}
```



큐의 생성

```java
public LinkedQueue(){
    currentCount = 0;
    front = null;
    rear = null;
}
```



큐가 비어있는가?

```java
public int isLinkedQueueEmpty(){
    if(currentCount == 0){
        return 1;
    }
    else{
        return -1;
    }
}
```



인큐 연산

```java
public int enqueueLQ(char data){
    LinkedQueueNode newNode = new LinkedQueueNode(data);
    if(currentCount == 0){
        rear = newNode;
        front = newNode;
    }
    else{
        rear.setLink(newNode);
        rear = newNode;
    }
    currentCount++;
    return 1;
}
```

- 비어있을 경우 newNode를 rear, front로 설정
- 비어있지 않은 경우 마지막 노드의 다음 노드를 newNode로 
- newNode를 마지막 노드로
- currentCount를 하나 증가시킨다.



디큐 연산

```java
public LinkedQueueNode dequeueLQ(){
    LinkedQueueNode tempNode = null;
    if(isLinkedQueueEmpty() == 1){
        return null;
    }
    if(currentCount == 1){ // 남은 노드가 한 개 일때
        tempNode = front;
        front = null;
        rear = null;
    }
    else{ // 두 개 이상일 때
        tempNode = front;
        front = front.getLink();
    }
    currentCount--;
    return tempNode;
}
```

- 노드가 한개일 때 하나 남은 노드를 tempNode에 반환하고 초기화
- 두개 이상일 때 front노드를 tempNode로 저장하고 front노드를 front노드의 다음노드로 초기화
- currentCount를 하나 감소시키고 tempNode를 반환



피크 연산

```java
public LinkedQueueNode peekLQ(){
    if(isLinkedQueueEmpty() == 1){
        return null;
    }
    return front;
}
```

- front노드를 반환



큐를 순회

```java
public void disPlayLQ(){
    LinkedQueueNode tempNode = front;
    int i = 0;
    System.out.println("현재 노드 개수: " + currentCount);
    while(tempNode != null){
        System.out.println(i + "-" + tempNode.getData());
        i++;
        tempNode = tempNode.getLink();
    }
}
```

- front노드부터 뒤로 가면서 출력



큐 초기화

```java
public void deleteLQ(){
    front = null;
    rear = null;
    currentCount = 0;
}
```



연결 큐 예시)

```java
public class LinkedQueueNode {
    private char data;
    private LinkedQueueNode link;
    public LinkedQueueNode(char data){
        this.data = data;
    }
    public char getData(){
        return data;
    }
    public void setLink(LinkedQueueNode link){
        this.link = link;
    }
    public LinkedQueueNode getLink(){
        return link;
    }
}
```

```java
public class LinkedQueue {
    private int currentCount;
    private LinkedQueueNode front;
    private LinkedQueueNode rear;
    public LinkedQueue(){
        currentCount = 0;
        front = null;
        rear = null;
    }
    public int enqueueLQ(char data){
        LinkedQueueNode newNode = new LinkedQueueNode(data);
        if(currentCount == 0){
             rear = newNode;
             front = newNode;
        }
        else{
            rear.setLink(newNode);
            rear = newNode;
        }
        currentCount++;
        return 1;
    }
    public LinkedQueueNode dequeueLQ(){
        LinkedQueueNode tempNode = null;
        if(isLinkedQueueEmpty() == 1){
            return null;
        }
        if(currentCount == 1){ // 남은 노드가 한 개 일때
            tempNode = front;
            front = null;
            rear = null;
        }
        else{ // 두 개 이상일 때
            tempNode = front;
            front = front.getLink();
        }
        currentCount--;
        return tempNode;
    }
    public LinkedQueueNode peekLQ(){
        if(isLinkedQueueEmpty() == 1){
            return null;
        }
        return front;
    }
    public int isLinkedQueueEmpty(){
        if(currentCount == 0){
            return 1;
        }
        else{
            return -1;
        }
    }
    public void deleteLQ(){
        front = null;
        rear = null;
        currentCount = 0;
    }
    public void disPlayLQ(){
        LinkedQueueNode tempNode = front;
        int i = 0;
        System.out.println("현재 노드 개수: " + currentCount);
        while(tempNode != null){
            System.out.println(i + "-" + tempNode.getData());
            i++;
            tempNode = tempNode.getLink();
        }
    }
}
```

```java
public class LinkedQueueExample {
    public static void main(String[] args){
        LinkedQueue queue = new LinkedQueue();
        LinkedQueueNode node = null;

        queue.enqueueLQ('A');
        queue.enqueueLQ('B');
        queue.enqueueLQ('C');
        queue.enqueueLQ('D');
        queue.disPlayLQ();

        node = queue.dequeueLQ();
        System.out.println("Dequeue Value-" + node.getData());
        queue.disPlayLQ();

        node = queue.peekLQ();
        System.out.println("Peek Value-" + node.getData());
        queue.disPlayLQ();

        queue.enqueueLQ('E');
        queue.disPlayLQ();

        queue.deleteLQ();
        queue.disPlayLQ();
    }
}
```

