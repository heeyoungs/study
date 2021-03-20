# ch6. 스택의 적용

---



## 역순인 문자열 만들기

---

'ABC' 의 문자열을

'CBA'로 출력시켜보자.



reverseString() 메소드

```java
static char[] reverseString(char[] abcd){
    if(abcd == null){
        System.out.println("비어있음!");
        return null;
    }
    LinkedStack stack = new LinkedStack();
    int Count = abcd.length;
    char answer[] = new char[Count];
    for(int i=0;i<Count;i++){ // 스택에 푸쉬
        stack.pushLinkedStack(abcd[i]);
    }
    for(int i=0;i<Count;i++){ // 스택에서 팝
        answer[i] = stack.popLinkedStack().getData();
    }
    stack.deleteLinkedStack();
    return answer;
}
```

1. reverseString의 메소드로 char형 문자열을 받는다.
2. 문자열이 비어있으면 리턴
3. 연결 스택을 하나 생성한다.
4. 스택에 입력받은 문자열을 앞에서 부터 하나씩 push한다.
5. char형 배열을 하나 만들어서 연결스택에 저장된 문자를 하나씩 pop하고 저장한다.
6. 그 문자열을 리턴한다.



## 수식에서 괄호 검사하기

---

입력받은 수식의 괄호 쌍이 맞는지 검사하자.



조건

1. 여는 괄호와 닫는 괄호가 서로 쌍을 이루어야한다.
2. 여럿이 중첩되었을 경우, 맨 안쪽의 괄호부터 차례대로 닫혀야한다.

=>

연결 스택의 구성

1. 여는 괄호를 만나면 push
2. 닫는 괄호를 만나면 pop해서 괄호를 조사한다.
   1. 여는 괄호가 부족하면 팝할때 부족 현상이 발생
   2. 닫는 괄호가 부족하면 스택에 괄호가 남는 현상 발생
   3. 여는 괄호와 닫는 괄호 쌍이 맞지 않으면 오류 발생



checkBracketMatching() 메소드

```java
static int checkBracketMatching(char[] check){
    if(check == null){ // 비어있을경우
        return -1;
    }

    LinkedStack stack = new LinkedStack();
    int Count = 0;
    int length = check.length;
    for(int i=0;i<length;i++){
        if(check[i] == '(' || check[i] == '{' || check[i] == '['){
            stack.pushLinkedStack(check[i]);
            Count++;
        }

        if(check[i] == ')' || check[i] == '}' || check[i] == ']'){
            Count--;
            // 여는 괄호 부족
            if(Count < 0){
                return 1;
            }
            char checkAnswer = stack.popLinkedStack().getData();
            // 괄호쌍 검사
            if(check[i] == ')'){
                if(checkAnswer != '(') {
                    return 2;
                }
            }
            else if(check[i] == '}'){
                if(checkAnswer != '{') {
                    return 2;
                }
            }
            else if(check[i] == ']'){
                if(checkAnswer != '['){
                    return 2;
                }
            }
            // 여기 까지~
        }
    }
    // 닫는 괄호 부족
    if(Count > 0){
        return 3;
    }

    // success
    return 0;

}
```

1. char형 배열을 매개변수로 받는다.
2. 비어있으면 바로 리턴한다.
3. 연결 스택을 생성한다.
4. 매개변수로 받은 char형배열의 길이만큼 반복문을 반복하면서 검사한다.
   1. 여는 괄호를 만나면 count를 한 개씩 추가.
   2. 닫는 괄호를 만나면 count를 한개씩 감소 ->  count가 음수면 return 1
   3. 괄호쌍 검사 -> 틀리면 return 2
5. 반복문이 종료됐는데 연결스택에 자료가 남아있으면 return 3
6. 성공시 return 1



## 후위 표기법으로 수식 계산하기

---

후위 표기법으로 표현된 수식을 스택을 이용해서 계산해 보자.



중위 표기법이란? A * B

후위 표기법이란? A B *

=> 연결 스택으로 후위 표기법을 계산하기 위한 알고리즘

1. 피연산자를 만나면 스택에 저장한다.
2. 연산자를 만나면 스택에 저장된 자료 두개를 pop 해서 계산한다.
3. 다시 push한다.
4. 수식을 모두 읽을 때까지 진행한다.



피연산자들과 연산자들의 종류를 저장하는 열거형을 Predence로 정의한다.

```java
enum PrecedenceType{ multiply, divide, plus, minus, operand }
```



토큰의 타입과 값을 ExprToken에 저장한다.

```java
public class ExprTokenType {
    private double value;
    private PrecedenceType type;
    void setValue(double value){
        this.value = value;
    }
    double getValue(){
        return value;
    }
    void setType(PrecedenceType type){
        this.type = type;
    }
    PrecedenceType getType(){
        return type;
    }
}
```



연결 스택의 노드

```java
public class LinkedStackNode {
    LinkedStackNode(ExprTokenType data){
        this.data = data;
    }
    private ExprTokenType data;
    private LinkedStackNode link;
    ExprTokenType getData(){
        return data;
    }
    void setLink(LinkedStackNode link){this.link = link;}
    LinkedStackNode getLink(){ return link; }
}
```



연결 스택의 구조

```java
public class LinkedStack {
    private int currentCount;
    private LinkedStackNode top;
}
```



연결 스택의 함수들

```java
public class LinkedStack {
    private int currentCount;
    private LinkedStackNode top;
    LinkedStack(){
        this.currentCount = 0;
        this.top = null;
    }
    int pushLinkedStack(ExprTokenType data){
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
            return data;
        }
        data = top;
        top = top.getLink();
        currentCount--;
        return data;
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
}
```



calcExpr() 메소드

```java
static void calcExpr(ExprTokenType[] pExprTokens, int tokenCount){
    if(pExprTokens == null){
        return;
    }
    LinkedStackNode ANode = null,BNode = null;
    PrecedenceType tokenType;
    LinkedStack stack = new LinkedStack();
    for(int i=0;i<tokenCount;i++){
        tokenType = pExprTokens[i].getType();

        if(tokenType == PrecedenceType.operand){
            stack.pushLinkedStack(pExprTokens[i]);
        }
        else{
            BNode = stack.popLinkedStack();
            if(BNode != null){
                ANode = stack.popLinkedStack();
                if(ANode != null){
                    double op1 = ANode.getData().getValue();
                    double op2 = BNode.getData().getValue();

                    ExprTokenType newToken = new ExprTokenType();
                    newToken.setType(PrecedenceType.operand);
                    switch (tokenType){
                        case plus:
                            newToken.setValue(op1 + op2);
                            break;
                        case minus:
                            newToken.setValue(op1 - op2);
                            break;
                        case multiply:
                            newToken.setValue(op1 * op2);
                            break;
                        case divide:
                            newToken.setValue(op1 / op2);
                            break;
                    }
                    stack.pushLinkedStack(newToken);
                }
            }
        }
    }

    ANode = stack.popLinkedStack();
    if(ANode != null){
        System.out.println("수식 계산 결과는 " + ANode.getData().getValue() + "입니다.");
    }
    else{
        System.out.println("오류, 수식에 오류가 있습니다.");
    }
    stack.deleteLinkedStack();
}
```

1. 매개값으로 받은 토큰의 배열이 비어있는지 검사한다.
2. 연결 스택을 생성한다.
3. 토큰의 개수만큼 반복문을 반복한다.
   1. 토큰의 타입이 피연산자이면 연결 스택에 push
   2. 토큰의 타입이 연산자이면
      1. BNode에 피연산자 한개 pop
      2. ANode에 피연산자 한개 pop
      3. 둘을 연산해서 newToken에 저장
      4. newToken의 값을 스택에 push한다.
4. 스택에 저장된 자료를 pop해서 ANode에 저장한다.
5. 그 값을 출력한다.
6. 만약 오류가 있으면 else문을 출력한다.
7. stack을 초기화한다.



## 중위 표기 수식을 후위 표기 수식으로 변환하기

---

중위 표기로 된 수식을 후위 표기 수식으로 변환해보자.



규칙

1. 피연산자를 만나면 바로 출력한다.

2. 연산자를 만나면 스택에 push한다.
3. 기존 스택에 있는 연산자보다 우선순위가 높거나 같은 연산자는 pop한다.
   1. 스택 내부에서의 우선 순위     ')'    >     '*,/'     >    '+,-'    >    '('
   2. 스택 외부에서의 우선 순위     ')('   >     '*,/'     >     '+,-'

4. 닫는 괄호 연산자를 만나면 스택에서 여는 괄호 연산자를 만날 때까지 스택에 저장된 연산자를 모두 팝하고 출력한다.



연산자 내부의 우선 순위를 반환해주는 함수

```java
static int intStackPrecedence(PrecedenceType oper){
    switch (oper){
        case lparen:
            return 0;
        case rparen:
            return 4;
        case multiply:
        case divide:
            return 2;
        case plus:
        case minus:
            return 1;
    }
    return -1;
}
```



연산자 외부의 우선 순위를 반환해주는 함수

```java
static int outStackPrecedence(PrecedenceType oper){
    switch (oper){
        case lparen:
            return 5;
        case rparen:
            return 4;
        case multiply:
        case divide:
            return 2;
        case plus:
        case minus:
            return 1;
    }
    return -1;
}
```



연산자(토큰)을 출력해주는 함수

```java
static void printToken(ExprToken element){
    switch (element.getType()){
        case lparen:
            System.out.print("( ");
            break;
        case rparen:
            System.out.print(") ");
            break;
        case plus:
            System.out.print("+ ");
            break;
        case minus:
            System.out.print("- ");
            break;
        case multiply:
            System.out.print("* ");
            break;
        case divide:
            System.out.print("/ ");
            break;
        case operand:
            System.out.print(element.getValue() + " ");
            break;
    }
}
```



convertInfixToPostfix() 메소드

```java
static void convertInfixToPostfix(ExprToken[] pExprTokens ,int tokenCount){
    LinkedStack stack = new LinkedStack();
    LinkedStackNode ANode = null;
    PrecedenceType tokenType, inStackTokenType;

    for(int i=0;i<tokenCount;i++){
        tokenType = pExprTokens[i].getType();
        switch (tokenType){
            case operand:
                System.out.print(pExprTokens[i].getValue() + " ");
                break;
            case rparen:
                ANode = stack.popLinkedStack();
                while((ANode != null) && (ANode.getData().getType() != PrecedenceType.lparen)){
                    printToken(ANode.getData());
                    ANode = stack.popLinkedStack();
                }
                if(ANode != null){
                    ANode = null;
                }
                break;
            default:
                while(stack.isLinkedStackEmpty() == -1){
                    inStackTokenType = stack.peekLinkedStack().getData().getType();
                    if(outStackPrecedence(tokenType) <= intStackPrecedence(inStackTokenType)){
                        ANode = stack.popLinkedStack();
                        if(ANode != null){
                            printToken(ANode.getData());
                        }
                    }
                    else{
                        break;
                    }
                }
                stack.pushLinkedStack(pExprTokens[i]);
                break;
        }
    }
    while(stack.isLinkedStackEmpty() == -1){
        ANode = stack.popLinkedStack();
        if(ANode != null){
            printToken(ANode.getData());
        }
    }
    stack.deleteLinkedStack();
}
```

1. 연결 스택을 생성한다.
2. 토큰의 개수만큼 반복문을 반복한다.
3. 토큰의 타입을 tokenType에 저장한다.
   1. 타입이 피연산자이면 출력한다.
   2. 타입이 닫는 괄호이면 여는 괄호를 만날때까지 whie문을 통해 스택 내 연산자를 모두 출력한다.
   3. 타입이 연산자이면 스택내에 저장된 연산자 중에 현재 연산자보다 우선 순위가 높거나 같은 연산자를 출력하고 스택에 push한다.
4. 스택에 남은 연산자를 모두 pop하여 출력한다.