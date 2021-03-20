

# ch2. 배열 리스트 (C)

---



## 리스트란?

---

리스트란? `순서`대로 자료를 저장하는 자료구조!

리스트는 '한 줄'로 저장한다. (선형 구조)

![다운로드 (5)](C:\Users\user\Downloads\다운로드 (5).png)

-> 시작점이나 끝점이 한 개가 아니라 두개면 비선형 구조겠죠?



## 리스트 사용 시나리오

---

리스트의 사용 시나리오는 크게 

1. 추가 : 새로운 자료를 추가해서 자료구조에 저장하는 것
2. 값 가져오기 : 저장된 자료구조에 접근해서 해당 값을 가져오는 것
3. 제거 : 사용이 끝난 자료를 자료구조에서 제거하는 것



10,20,30이라는 값을 입력하지만

저장 순서는 30->10->20 일 경우

### 새로운 자료 추가

1. 리스트를 만든다

|          |       |      |      |



2. 자료 10을 입력받아 리스트에 저장한다.

| 10   |      |      |      |

-> 이 상태에서 우리는 10의 앞이나 뒤에 자료를 저장할 수 있다.



3. 자료 20을 입력받아 리스트의 마지막 위치(10의 뒤)에 저장한다.

| 10   | 20   |       |       |



4. 자료 30을 입력받아 리스트의 첫 번째 위치(10의 앞)에 저장한다.

| 30   | 10   | 20   |      |



### 값 가져오기

1. 인덱스 정보가 1인 자료의 값을 가져온다.

| 30   | `<10>` | 20   |        |



### 기존 자료의 제거

1. 첫 번쨰 자료를 제거한 경우

| 30 (x) | 10   | 20    |        |

=>

| 10       | 20   |         |        |



2. 리스트를 자체를 삭제하는 것.

x



## 리스트의 추상 자료형

---

### 자료, 자료형

자료 : 프로그램에서 처리되는 대상으로 특정 값을 의미

자료형 : 자료와 이 자료를 처리하기 위한 명령 혹은 연산이 합쳐진 것

=> 자료형 = 자료 + 연산 (정수 자료형 : 1 + 2)



### 추상 자료형

추상 자료형 : 추상적으로 정의된 자료형

-> 추상이란? 세부적이고 복잡한 것을 생략하고 대표적인 것, 중요한 것만이라는 의미이다.



추상 자료형 자체는 실제로 실행되는 소스가 아니라 외부에서 호출하기 위한 인터페이스일 뿐, 

실제 자료구조가 실행되려면 이러한 인터페이스에 맞추서 실제 실행되는 소스를 구현해야 된다.

추상 자료형의 연산을 함수로 구현하는데 함수는 이름+입력+출력으로 이루어졌다.!



리스트의 추상 자료형

| 이름                          |                  | 입력                          | 출력           | 설명                                                 |
| ----------------------------- | ---------------- | ----------------------------- | -------------- | ---------------------------------------------------- |
| 리스트 생성                   | crreateList()    | -                             | 리스트         | 빈 리스트를 생성                                     |
| 자료 추가                     | addListData()    | 리스트<br>추가할 위치<br>자료 | 성공/실패 여부 | 자료를 리스트의 위치에 추가                          |
| 자료 반환                     | getListData()    | 리스트<br>자료 위치           | 자료           | 리스트의 위치에 있는 자료 값을 반환                  |
| 자료 개수 반환                | getListLength()  | 리스트                        | 자료의 개수    | 리스트의 자료 개수를 반환                            |
| 자료 제거                     | removeListData() | 리스트<br>자료 위치           | 성공/실패 여부 | 리스트의 위치에 있는 자료를 제거                     |
| 모든 자료 제거(리스트 초기화) | clearList()      | 리스트                        | N/A            | 리스트의 모든 자료를 제거                            |
| 리스트 삭제                   | deleteList()     | 리스트                        | N/A            | 리스트의 모든 자료를 삭ㅈ하고 리스트의 메모리를 해제 |



## 배열 리스트란?

---

배열 리스트란? ''물리적으로 연속해 있는'' 배열의 특성을 이용하여, ''논리적으로 연속해 있는''리스트를 구현한 것.



배열 리스트의 장점

- 리스트의 특정 위치에 잇는 자료에 바로 접근 할 수 있다는 점.

배열 리스트의 단점

- 배열에 최대로 저장할 수 있는 자료의 개수를 넘을 수 없다.



### 추상 자료형

=> c언어에서 배열 리스트의 추상 자료형은

createList()하나만 다르다

| 이름        |              | 입력            | 출력        | 설명                                         |
| ----------- | ------------ | --------------- | ----------- | -------------------------------------------- |
| 리스트 생성 | createList() | 최대 원소 개수n | 리스트 list | 최대 n개의 자료를 저장할 수 있는 list를 생성 |





---

<java>

자바에선 import java.util.ArrayList를 통해 배열 리스트를 만들고 사용할 수 있다.

| 이름           |                                            | 입력                              | 출력           | 설명                               |
| -------------- | ------------------------------------------ | --------------------------------- | -------------- | ---------------------------------- |
| 리스트 생성    | ArrayList<T> 리스트이름 = new ArrayList(); | -                                 | -              | 빈 리스트를 생성                   |
| 자료 추가      | add()                                      | 리스트이름<br>추가할 위치<br>자료 | 성공/실패 여부 | 자료를 리스트 위치에 추가          |
| 자료 반환      | get()                                      | 리스트이름<br>자료 위치           | 자료           | 리스트의 위치에 있는 자료값을 반환 |
| 자료 개수 반환 | size()                                     | 리스트이름                        | 자료의 개수    | 리스트의 자료 개수를 반환          |
| 자료 제거      | remove()                                   | 리스트이름<br>자료 위치           | 성공/실패 여부 | 리스트의 위치에 있는 자료를 제거   |
| 모든 자료 제거 | clear()                                    | 리스트이름                        | -              | 리스트의 모든 자료를 제거          |

---



### 노드의 구조

노드란? 배열 리스트에서 자료를 저장하는 단위

- struct 키워드를 이용하여 노드를 구조체로 선언
- 이후 노드에 실제 저장되는 자료를 내부 멤버 변수로 가짐.

=> 구조체로 감싸는 이유는 서로 다른 자료형의 원소를 동시에 저장할 수 있기 때문이다!

``` c
typedef struct ArrayListNodeType { // int형의 자료 하나를 저장하는 노드
	int data; 
}ArrayListNode;
```

typedef : 지룐 자료형에 새로운 이름을 부여! -> struct ArrayListNodeType을 ArrayListNode라고도 부르겠다!



### 배열 리스트의 구조

![img](C:\Users\user\Downloads\img.png)

``` c
typedef struct ArrayListType {
	int maxCount;
	int currentCount;
	ArrayListNode* pData;
}ArrayList;
```

```java
public class ArrayList {
    int currentCount;
    int maxCount;
    int[] element = null;
}
```



maxCount : 최대 몇 개의 자료를 저장할 수 있는지 알려준다.

currentCount : 현재 배열에 저장된 원소의 개수를 알려준다.

`pData` 

- 최대 원소 개수만큼 할당된 배열을 가리키는 포인터이다. 

- 실제 자료를 저장하는 멤버 변수이다.
- maxCount로 받은 크기만큼 pData가 가리키는 배열을 동적할당한다.



## 배열 리스트의 구현

---

### C로 구현

1. createList() : 배열 리스트 생성

``` c
ArrayList *createList(int count) { 
	ArrayList* pReturn = 0;
	if (count > 0) {
		pReturn = (ArrayList*)malloc(sizeof(ArrayList)); // 메모리 할당
		pReturn->maxCount = count; // 최대 설정
		pReturn->currentCount = 0; // 현재 설정
		pReturn->pData = 0;
	}
	else { 
		printf("배열 리스트 생성 실패~");
		pReturn->pData = 0;
	}
	pReturn->pData = (ArrayListNode*)malloc(sizeof(ArrayListNode) * count); // 실제 자료를 저장할 배열에 대한 메모리 할당
	memset(pReturn->pData, 0, sizeof(ArrayListNode)* count); // 0으로 초기화

	return pReturn;
}
```

``` java
ArrayList(int count) {
    this.currentCount = 0;
    this.maxCount = count;
    this.element = new int[count];
}
```



2. addListData() : 새로운 자료 추가

원소를 추가하려면 추가하려는 원소의 오른쪽 원소들을 오른쪽으로 옮겨줘야 한다.

``` c
int addListData(ArrayList* pList, int position, int data) {
	if (pList == 0) {
		printf("오류코드1");
		return 0;
	}
	if (position > pList->currentCount || position < 0) {
		printf("오류코드2");
		return 0;
	}
	int i = 0;
	for (i = pList->currentCount - 1; i >= position; i--) {
		pList->pData[i + 1] = pList->pData[i]; // 추가되는 위치와 그 오른쪽에 있는 기존 자료를 모두 오른쪽으로 한칸씩 이동
	}
	pList->pData[position].data = data; // 자료 추가
	pList->currentCount++; // 현재 개수 + 1
	return 0;
}
```

```java
public void addListData(int position,int value)throws PositionException{ // 추가
    // 예외
    if(position<0){
        throw new PositionException("0보다 작은 인덱스");
    }
    else if(position>currentCount) {
        throw new PositionException("현재 자료개수 보다 큰 인덱스");
    }
    //맨 마지막
    else if(position == currentCount) {
        element[currentCount] = value;
        currentCount++;
    }
    //처음 or중간에 삽입
    else if(position>=0 && position< currentCount){
        for(int i=currentCount;i>=position;i--){
            element[i+1] = element[i];
        }
        element[position] = value;
        currentCount++;
    }
}
```



3. removeList() : 기존 자료 제거

원소를 제거하면 제거되는 원소의 오른쪽 원소들을 왼쪽으로 옮겨줘야 한다.

``` c
int removeListData(ArrayList* pList, int position) {
	if (pList == 0) {
		printf("오류코드1");
		return 0;
	}
	if (position > pList->currentCount || position <= 0) {
		printf("오류코드2");
		return 0;
	}
	int i = 0;
	for (i = position; i < pList->currentCount - 1; i++) { 
		pList->pData[i] = pList->pData[i + 1]; // 제거되는 원소의 위치와 그 오른쪽으로 있는 원소를 왼쪽으로 이동
	}
	pList->currentCount--; // 현재 개수 - 1
	return 0;
}
```

```java
public void removeListData(int position)throws PositionException{ // 제거
    // 예외
    if(position<0){
        throw new PositionException("0보다 작은 인덱스");
    }
    // 값 제거
    else if(position >= 0 && position <= currentCount){
        for(int i=position;i<currentCount;i++){
            element[i] = element[i+1];
        }
        currentCount--;
    }
}
```



4. getListData() : 값 가져오기

가져오려는 위치에 저장된 값을 불러온다.

``` c
int getListData(ArrayList* pList, int position) {
	return pList->pData[position].data; 
}
```

```java
int getListData(ArrayList* pList, int position) {
	return pList->pData[position].data;
}
```



5. deleteList() : 배열 리스트 삭제

동적 할당을 해제해 준다.

``` c
void deleteList(ArrayList* pList) {
	if (pList->pData == 0) {
		printf("오류 코드1");
		return;
	}
	if (pList == 0) {
		printf("오류 코드2");
		return;
	}
	free(pList->pData);
	free(pList); // 할당해제
}
```

```java
public void clearList(){ // 리스트 초기화
    for(int i=0;i<currentCount;i++){
        element[i] = 0;
        currentCount--;
    }
}
```



6. getListLength() : 현재 자료의 개수 얻기

현재 자료의 개수를 반환해 준다.

``` c
int getListLength(ArrayList *pList) {
	return pList->currentCount;
}
```

```java
int getListLength(){ // 길이 가져오기
    return currentCount;
}
```



최종 구현

``` c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct ArrayListNodeType {
	int data;
}ArrayListNode;

typedef struct ArrayListType {
	int maxCount; // 배열의 크기를 저장
	int currentCount; // 현재 자료의 개수
	ArrayListNode* pData; // 실제 자료를 저장하는 멤버 변수
}ArrayList;

ArrayList* createList(int count);
int addListData(ArrayList* pList, int position, int data);
int removeListData(ArrayList* pList, int position);
int getListData(ArrayList* pList, int position);
void deleteList(ArrayList* pList);
int getListLength(ArrayList* pList);

int main() {
	ArrayList* pList = NULL;
	int value = 0;
	pList = createList(5);
	addListData(pList, 0, 10);
	addListData(pList, 1, 20);
	addListData(pList, 2, 30);

	value = getListData(pList, 1);
	printf("인덱스 1자리 값 : %d", value);

	removeListData(pList, 0);
	deleteList(pList);

	return 0;
}

// 배열 리스트 생성 함수 3번 문제
ArrayList *createList(int count) { 
	ArrayList* pReturn = 0;
	if (count > 0) {
		pReturn = (ArrayList*)malloc(sizeof(ArrayList)); 
		pReturn->maxCount = count; 
		pReturn->currentCount = 0; 
		pReturn->pData = 0;
	}
	else {
		printf("배열 리스트 생성 실패~");
		pReturn->pData = 0;
	}
	pReturn->pData = (ArrayListNode*)malloc(sizeof(ArrayListNode) * count);
	memset(pReturn->pData, 0, sizeof(ArrayListNode)* count);

	return pReturn;
}

// 새로운 자료 추가 함수 4번 문제
int addListData(ArrayList* pList, int position, int data) {
	if (pList == 0) {
		printf("오류코드1");
		return 0;
	}
	if (position > pList->currentCount && position < 0) {
		printf("오류코드2");
		return 0;
	}
	int i = 0;
	for (i = pList->currentCount - 1; i >= position; i--) {
		pList->pData[i + 1] = pList->pData[i]; 
	}
	pList->pData[position].data = data;
	pList->currentCount++; 
	return 0;
}

// 기존 자료 제거 함수 5번
int removeListData(ArrayList* pList, int position) {
	if (pList == 0) {
		printf("오류코드1");
		return 0;
	}
	if (position > pList->currentCount && position <= 0) {
		printf("오류코드2");
		return 0;
	}
	int i = 0;
	for (i = position; i < pList->currentCount - 1; i++) { 
		pList->pData[i] = pList->pData[i + 1]; 
	}
	pList->currentCount--; 
	return 0;
}

// 값 가져오기 함수
int getListData(ArrayList* pList, int position) {
	return pList->pData[position].data;
}

// 배열 리스트 삭제 함수 6번
void deleteList(ArrayList* pList) {
	if (pList->pData == 0) {
		printf("오류 코드1");
		return;
	}
	if (pList == 0) {
		printf("오류 코드2");
		return;
	}
	free(pList->pData);
	free(pList); 
}

// 자료의 개수 반환 함수 2번 문제
int getListLength(ArrayList *pList) {
	return pList->currentCount;
}
```



### java로 구현

``` java
public class PositionException extends Exception{
    public PositionException(){}
    public PositionException(String message){
        super(message);
    }
}
```

``` java
public class ArrayListExample {
    public static void main(String[] args){
        ArrayList pList = new ArrayList(5);

        try {
            pList.addListData(0, 10);
            pList.addListData(1, 20);
            pList.addListData(2, 30);
        }catch (PositionException e){
            e.printStackTrace();
        }


        int value = pList.getListData(1);
        System.out.println("1 위치의 값 : " + value);

        try {
            pList.removeListData(0);
        }catch (PositionException e){
            e.printStackTrace();
        }

        System.out.println("리스트의 길이 : " + pList.getListLength());
    }
}
```

```java
public class ArrayList {
    ArrayList(int count) {
        this.currentCount = 0;
        this.maxCount = count;
        this.element = new ArrayListNode[count];
        for(int i=0;i<count;i++){
            element[i] = new ArrayListNode();
        }
    }
    int currentCount;
    int maxCount;
    ArrayListNode[] element = null;
    public void addListData(int position,int value)throws PositionException{ // 추가
        if(position<0){
            throw new PositionException("0보다 작은 인덱스");
        }
        else if(position>currentCount) {
            throw new PositionException("현재 자료개수 보다 큰 인덱스");
        }
        else if(position>=0 && position< currentCount){
            for(int i=currentCount;i>=position;i--){
                element[i+1] = element[i];
            }
            element[position].data = value;
        }
        else{
            element[currentCount].data = value;

        }
        currentCount++;
    }
    public void removeListData(int position)throws PositionException{ // 제거
        if(position<0){
            throw new PositionException("0보다 작은 인덱스");
        }
        // 값 제거
        else{
            for(int i=position;i<currentCount;i++){
                element[i] = element[i+1];
            }
            currentCount--;
        }
    }
    int getListData(int position){ // 값 가져오기
        return element[position].data;
    }
    int getListLength(){ // 길이 가져오기
        return currentCount;
    }
    public void clearList(){ // 리스트 초기화
        for(int i=0;i<currentCount;i++){
            element[i].data = 0;
            currentCount--;
        }
    }
}
```

```java
public class ArrayListNode {
    ArrayListNode(){
        data = 0;
    }
    int data;
}
```

