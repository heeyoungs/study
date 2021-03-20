# ch5. 스택

---

스택이란? 물건을 쌓다.

- LIFO : last in first out (후입선출)
- 가장 나중에 들어온 자료가 가장 먼저 나온다.



![다운로드 (11)](C:\Users\user\Downloads\다운로드 (11).png)



## 스택이란?

---

스택의 특징!

- 스택은 선형 자료 구조이다. =>  앞뒤 관계가 (1:1)이다.
- 자료의 추가와 제거가 한쪽 끝에서만 이루어진다.(top)



## 스택의 사용 시나리오

---

![다운로드 (12)](C:\Users\user\Downloads\다운로드 (12).png)



푸시 연산

- push

- 자료의 추가
- 새로운 자료는 항상 기존 자료의 위쪽에만 저장 가능
- 자료의 저장 개수가 스택의 크기를 초과하면 overflow 발생



팝 연산

- pop

- 자료의 제거
- 맨 위의 자료를 제거하고 그 값을 반환
- 자료가 없는데 자료를  반환하려 하면 underflow 발생



피크 연산

- peek

- 자료의 값만 반환
- 맨 위의 자료에 접근



=> 저장순서가 a,b,c 이면 반환은 c,b,a 순서이다.



## 스택의 추상 자료형

---



스택의 추상 자료형 (배열 리스트로 구현시)

| 이름                        |               | 입력          | 출력           | 설명                                                         |
| --------------------------- | ------------- | ------------- | -------------- | ------------------------------------------------------------ |
| 스택 생성                   | createStack() | 스택의 크기 n | 스택 stack     | 빈 스택stack을 생성                                          |
| 스택 삭제                   | deleteStack() | 스택 stack    | N / A          | 스택의 메모리를 해제                                         |
| 자료 추가<br>가능 여부 판다 | isFull()      | 스택 stack    | True/False     | 스택에 푸시를 수행할 수 있는지를 반환, <br>배열 스택인 경우에만 의미있음 |
| 빈 스택인지<br>여부 판단    | isEmpty()     | 스택 stack    | True/False     | 빈 스택인지를 반환                                           |
| 푸시                        | push()        | 스택 stack    | 성송/실패 여부 | 스택의 맨 위에 자료를 추가                                   |
| 팝                          | pop()         | 자료 data     | 자료           | 스택의 맨 위에 있는 자료를 제거한 뒤에 이를 반환             |
| 피크                        | peek()        | 스택 stack    | 자료           | 스택의 맨 위에 있는 자료를 반환(스택에서 제거하지는 않음)    |

=> isFull()은 배열 리스트로 구현한 스택에서만 의미 있음



## 배열로 구현한 스택

---



### 노드의 구조



```java
public class ArrayStackNode {
    ArrayStackNode(){}
    private char data;
    void setData(char data){ this.data = data; }
    char getData(){return data;}
}
```

=> 노드는 배열 리스트의 노드와 똑같다.



### 배열 스택의 구조



```java
public class ArrayStack{
    private int currentCount;
    private int maxCount;
    private ArrayStackNode[] element = null;
}
```

- 현재 자료의 개수 currentCount
- 최대 자료의 개수 maxCount
- 자료를 저장할 노드 배열 element

=> 배열 리스트와 동일하다.



### 스택의 생성



```java
ArrayStack(int count) throws IndexException{ // 배열 스택 생성자
    if(count < 0 ){
        throw new IndexException("0보다 작은 숫자가 입력됨");
    }
    this.currentCount = 0;
    this.maxCount = count;
    this.element = new ArrayStackNode[count];
    for (int i = 0; i < count; i++) {
        element[i] = new ArrayStackNode();
    }
}
```

=> 생성자에 0보다 작은 값이 들어오면 예외 처리

1. currrentCount 를 0으로 초기화
2. maxCount를 count로 초기화
3. count개 만큼의 ArrayStackNode배열을 생성



### 푸시 연산



```java
int pushArrayStack(char data){
    if(currentCount == maxCount){ // 유효성 점검, 배열이 꽉찼는지
        return -1;
    }
    element[currentCount].setData(data);
    currentCount++;
    return 1;
}
```

1. 현재 스택이 꽉찼는지 검사한다.
2. 마지막 자리에 자료를 추가한다.
3. currentCount를 하나 증가시킨다.



### 팝과 피크 연산



```java
char popArrayStack(){
    ArrayStackNode temp = null;
    char data;
    if(isArrayStackEmpty() == 1){ // 유효성 검사,배열이 비었는지
        return 'n';
    }
    temp = element[currentCount-1];
    data = temp.getData();
    currentCount--;
    element[currentCount].setData('0');
    return data;
}
```

1. 배열이 비었는지 검사한다.
2. 맨 위 노드값을 저장한다.
3. 맨 위 노드값을 초기화한다.
4. currentCount를 하나 감소시킨다.
5. 저장된 값을 리턴한다.



```java
char peekArrayStack(){
    ArrayStackNode temp = null;
    if(isArrayStackEmpty() == 1) { // 유효성 검사,배열이 비었는지
        return 'n';
    }
    temp = element[currentCount-1];
    return temp.getData();
}
```

1. 배열이 비었는지 검사한다.
2. 맨 위 노드의 값을 리턴한다.



### 그 외 연산



스택을 초기화한다.

```java
void deleteArrayStack(){
    if(isArrayStackEmpty() == 1) return;
    while(true) {
        currentCount--;
        element[currentCount].setData('0');
        if(currentCount == 0){ break; }
    }
}
```



스택이 비었는지 검사한다.

```java
int isArrayStackEmpty(){
    if(currentCount == 0){ return 1; }
    return -1;
}
```



스택에 저장된 자료를 모두 출력한다.

```java
 void disPlayArrayStack(){
     System.out.println("스택 크기: " + maxCount + ", 현재 노드 개수: " + currentCount);
     for(int i = maxCount-1;i >= currentCount ;i--){
         System.out.println(i + "-" + "Empty");
     }
     for(int i = currentCount-1;i>=0;i--){
         System.out.println(i + "-" + element[i].getData());
     }
 }
```



### 배열 스택



```java
public class IndexException extends Exception{
    IndexException(String message){ super(message); }
}
```

```java
public class ArrayStack{
    private int currentCount;
    private int maxCount;
    private ArrayStackNode[] element = null;
    ArrayStack(int count) throws IndexException{ // 배열 스택 생성자
        if(count < 0 ){
            throw new IndexException("0보다 작은 숫자가 입력됨");
        }
        this.currentCount = 0;
        this.maxCount = count;
        this.element = new ArrayStackNode[count];
        for (int i = 0; i < count; i++) {
            element[i] = new ArrayStackNode();
        }
    } // 5장 5번 문제
    int pushArrayStack(char data){
        if(currentCount == maxCount){ // 유효성 점검, 배열이 꽉찼는지
            return -1;
        }
        element[currentCount].setData(data);
        currentCount++;
        return 1;
    }
    char peekArrayStack(){
        ArrayStackNode temp = null;
        if(isArrayStackEmpty() == 1) { // 유효성 검사,배열이 비었는지
            return 'n';
        }
        temp = element[currentCount-1];
        return temp.getData();
    }
    char popArrayStack(){
        ArrayStackNode temp = null;
        char data;
        if(isArrayStackEmpty() == 1){ // 유효성 검사,배열이 비었는지
            return 'n';
        }
        temp = element[currentCount-1];
        data = temp.getData();
        currentCount--;
        element[currentCount].setData('0');
        return data;
    }
    void deleteArrayStack(){
        if(isArrayStackEmpty() == 1) return;
        while(true) {
            currentCount--;
            element[currentCount].setData('0');
            if(currentCount == 0){ break; }
        }
    }
    int isArrayStackEmpty(){
        if(currentCount == 0){ return 1; }
        return -1;
    }
    void disPlayArrayStack(){
        System.out.println("스택 크기: " + maxCount + ", 현재 노드 개수: " + currentCount);
        for(int i = maxCount-1;i >= currentCount ;i--){
            System.out.println(i + "-" + "Empty");
        }
        for(int i = currentCount-1;i>=0;i--){
            System.out.println(i + "-" + element[i].getData());
        }
    }
}
```

```java
public class ArrayStackNode {
    ArrayStackNode(){}
    private char data;
    void setData(char data){ this.data = data; }
    char getData(){return data;}
}
```

````java
public class ArrayStackExample {
    public static void main(String[] args){
        ArrayStack stack = null;
        try {
            stack = new ArrayStack(6);
        }catch (IndexException e){
            e.printStackTrace();
            return;
        }
        stack.pushArrayStack('A');
        stack.pushArrayStack('B');
        stack.pushArrayStack('C');
        stack.pushArrayStack('D');
        stack.disPlayArrayStack();
        System.out.println();

        System.out.println("Pop 값-" + stack.popArrayStack());
        stack.disPlayArrayStack();
        System.out.println();

        System.out.println("Peek 값-" + stack.peekArrayStack());
        stack.disPlayArrayStack();
        System.out.println();

        stack.deleteArrayStack();
        stack.disPlayArrayStack();
    }
}
````



## 포인터로 구현한 연결 스택

---

- 새로운 자료를 추가할때마다 동적으로 메모리를 할당하기 때문에 효율적으로 메모리를 사용할 수 있다.



### 노드의 구조



```java
public class LinkedStackNode {
    LinkedStackNode(char data){
        this.data = data;
    }
    private char data;
    private LinkedStackNode link;
    char getData(){ return data; }
    void setLink(LinkedStackNode link){this.link = link;}
    LinkedStackNode getLink(){ return link; }
}
```

=> 노드는 연결 리스트의 노드와 동일한 구조이다.



### 연결 스택의 구조



```java
public class LinkedStack {
    private int currentCount;
    private LinkedStackNode top;
}
```

1. 현재 자료의 개수를 저장하는 currentCount
2. 연결 리스트의 마지막 노드를 가리키는 top



탑 노드에 접근하는 시간 복잡도.

| 연결 스택으로 구현한 경우 | 연결 리스트로 구현한 경우 |
| ------------------------- | ------------------------- |
| O(1)                      | O(n)                      |

- 연결 스택으로 구현하면 자료의 추가와 제거가 top에서만 일어난다.

  => 마지막 노드까지 갈 필요가없다

- 연결 리스트로 구현하면 head에서 마지막 노드까지 찾아가서 추가, 제거해야한다.

  => 불필요한 시간 낭비가 있다.



### 연결 스택의 추상 자료형



| 이름                         | -             | 입력       | 출력         | 설명                                                         |
| ---------------------------- | ------------- | ---------- | ------------ | ------------------------------------------------------------ |
| 스택 생성                    | createStack() | -          | 스택 stack   | 빈 스택 stack을 생성                                         |
| 자료 추가 가능 여부 판단 (X) | isFull()      | 스택 stack | True / False | 스택에 푸시를 수핼할 수 있는지를 반환, 배열 스택일 때만 의미 있음. |

- 연결 리스트로 구현하면 스택의 크기를 지정해줄 필요가 없다.

  => 따라서 isFull()이라는 함수가 필요없다.



### 스택의 생성



```java
LinkedStack(){
    this.currentCount = 0;
    this.top = null;
}
```

1. currentCount를 0으로 초기화한다.
2. top을 null로 초기화한다.



### 푸시 연산



```java
int pushLinkedStack(char data){
    LinkedStackNode newStack = new LinkedStackNode(data);
    if(isLinkedStackEmpty() == 1){ // 처음일 경우
        this.top = newStack;
        newStack.setLink(null);
    }
    else{
        newStack.setLink(top);
        this.top = newStack;
    }
    currentCount++;
    return 1;
}
```

1. 스택에 자료가 없을 경우
   1. 새 노드를 top으로 설정
   2. top노드의 link를 null로 가리킴.
2. 스택에 자료가 한개 이상 있을 경우
   1. newNode가 top을 가리키게한다.
   2. newNode를 top노드로 바꿔준다.
3. currentCount를 하나 증가시킨다.



### 팝과 피크 연산



```java
LinkedStackNode popLinkedStack() {
    LinkedStackNode data = null;
    if (isLinkedStackEmpty() == 1) {
        return null;
    }
    data = top;
    top = top.getLink();
    currentCount--;
    return data;
}
LinkedStackNode peekLinkedStack(){
    LinkedStackNode data = null;
    if (isLinkedStackEmpty() == 1) {
        return null;
    }
    return top;
}
```

1. 노드가 비었는지 검사한다.
2. top노드를 data에 저장한다.
3. top노드를 top노드의 바로 밑 노드로 지정해준다.
4. currentCount를 하나 감소시킨다.
5. data를 반환한다.



```java
LinkedStackNode peekLinkedStack(){
    LinkedStackNode data = null;
    if (isLinkedStackEmpty() == 1) {
        return null;
    }
    return top;
}
```

1. 노드가 비었는지 검사한다.
2. 탑 노드를 반환한다.



### 그 외 연산



스택을 초기화한다.

```java
void deleteLinkedStack(){
    if(isLinkedStackEmpty() == 1){
        return;
    }
    top.setLink(null);
    currentCount=0;
}
```



노드가 비었는지 검사한다.

```java
int isLinkedStackEmpty(){
    if(currentCount == 0){ return 1;}
    return -1;
}
```



스택에 저장된 자료를 모두 출력한다.

```java
void disPlayLinkedStack(){
    LinkedStackNode temp = top;
    if(isLinkedStackEmpty() == 1){
        System.out.println("스택이 비어 있습니다.");
        return;
    }
    System.out.println("현재 노드 개수: " + currentCount);
    int Count = currentCount;
    while(temp != null){
        System.out.println( (Count-1) + "-" +  temp.getData() );
        temp = temp.getLink();
        Count--;
    }
}
```





### 포인터 스택



```java
public class LinkedStack {
    private int currentCount;
    private LinkedStackNode top;
    LinkedStack(){
        this.currentCount = 0;
        this.top = null;
    }
    int pushLinkedStack(char data){
        LinkedStackNode newStack = new LinkedStackNode(data);
        if(isLinkedStackEmpty() == 1){ // 처음일 경우
            this.top = newStack;
            newStack.setLink(null);
        }
        else{
            newStack.setLink(top);
            this.top = newStack;
        }
        currentCount++;
        return 1;
    }
    LinkedStackNode popLinkedStack() {
        LinkedStackNode data = null;
        if (isLinkedStackEmpty() == 1) {
            return null;
        }
        data = top;
        top = top.getLink();
        currentCount--;
        return data;
    }
    LinkedStackNode peekLinkedStack(){
        LinkedStackNode data = null;
        if (isLinkedStackEmpty() == 1) {
            return null;
        }
        return top;
    }
    int isLinkedStackEmpty(){
        if(currentCount == 0){ return 1;}
        return -1;
    }
    void deleteLinkedStack(){
        if(isLinkedStackEmpty() == 1){
            return;
        }
        top.setLink(null);
        currentCount=0;
    }
    void disPlayLinkedStack(){
        LinkedStackNode temp = top;
        if(isLinkedStackEmpty() == 1){
            System.out.println("스택이 비어 있습니다.");
            return;
        }
        System.out.println("현재 노드 개수: " + currentCount);
        int Count = currentCount;
        while(temp != null){
            System.out.println( (Count-1) + "-" +  temp.getData() );
            temp = temp.getLink();
            Count--;
        }
    }
}
```

```java
public class LinkedStackNode {
    LinkedStackNode(char data){
        this.data = data;
    }
    private char data;
    private LinkedStackNode link;
    char getData(){ return data; }
    void setLink(LinkedStackNode link){this.link = link;}
    LinkedStackNode getLink(){ return link; }
}
```

```java
public class LinkedStackExample {
    public static void main(String[] args){
        LinkedStack stack = new LinkedStack();
        stack.pushLinkedStack('A');
        stack.pushLinkedStack('B');
        stack.pushLinkedStack('C');
        stack.pushLinkedStack('D');
        stack.disPlayLinkedStack();
        System.out.println();

        System.out.println("Pop-" + stack.popLinkedStack().getData());
        stack.disPlayLinkedStack();
        System.out.println();

        System.out.println("Peek-" + stack.peekLinkedStack().getData());
        stack.disPlayLinkedStack();
        System.out.println();

        stack.deleteLinkedStack();
        stack.disPlayLinkedStack();
    }
}
```



