# ch8. 재귀호출 (JAVA)

---

재귀 호출(recursive) : 자기 자신을 다시 호출하는 것. ( 탐색 알고리즘의 기초)

-> 자기 자신을 호출하는 것만으로 탐색이 가능



분할 정복 : 복잡한 문제를 작고 단순한 문제로 나누어서 해결하려는 방법



## 재귀 호출이란?

---

### 재귀 호출의 2가지 조건

재귀 호출의 2가지 조건

- 호출될 때마다 문제의 범위가 줄어들어야 한다.
- 종료 조건이 있어야 한다.

=> 무한 루프에 빠지지 않게 하기 위해 지켜야 하는 원칙



재귀 함수의 가장 기본적인 예시.

``` java
public class Func{
    public static void main(String[] args){
        ...
        int result = my_func(10);
        ...
    }
    
    static int my_func(int input_value){
        int ret = 0;
        ...
        // 자기 자신을 호출하되 입력 파라미터를 1 감소하여 전달
       	ret = input1 + my_func(input_value - 1);
        ...
        return ret;
    }
}
```

=> 1. 자신이 호출될 때마다 문제의 범위를 줄어들게 하였다.

=> 2. 종료 조건이 없다. 



팩토리얼(n!) : 1x2x3x...(n-1)xn = n x (n-1)! 

-> 팩토리얼 계산에서 내부적으로 팩토리얼의 정의가 다시 사용되었다.



재귀 호출 방식으로 팩토리얼을 구현

``` java
public class Factorial{
    public static void main(String[] args){
        System.out.println(factorial(4));
    }
    
    static int factorial(int n){
        int ret = 0;
        if(n<=1){ // 종료 조건
            ret = 1;
        }
        else{
            ret = n * factorial(n-1); // 문제의 범위가 반복할때마다 감소
        }
        return ret;
    }
}
```



### 재귀 호출의 호출 과정

위 예제의 재귀 호출 과정을 살펴보면

![다운로드 (3)](C:\Users\user\Downloads\다운로드 (3).png)

-> 운영체제에서는 스택을 이용하여 재귀 호출을 실행한다.



운영 체제의 관점

- 운영체제에서는 하나의 함수가 호출되면 호출되는 함수별로 활성 레코드에 관련 정보를 저장.
  - 활성 레코드 : 함수를 호출할 때 함수에서 사용되는 모든 지역 변수와 전달된 인자등을 저장하는 공간
- 실행 도중에 다른 함수가 호출되면 해당 함수의 활성 레코드로 변경시킨다.( 문맥 변경 )
- 운영체제의 관점에서 보면 재귀 호출에 의해 같은 함수가 여러 번 호출된다 하더라도 이는 모두 별개의 함수로 처리됨.

=> 재귀 호출되는 함수별로 활성 레코드를 독립적으로 처리

- 그러면 재귀 함수의 마지막 실행이 일어나면
  - 운영체제는 시스템 스택에서 활성 레코드를 새로 팝하여 다음에 실행할 함수를 로딩
  - LIFO의 특성으로 호출된 역순으로 함수가 실행



재귀 호출의 단점

- 상대적으로 속도가 느리다
  - 재귀 호출을 사용하면 문맥 변경이 일어나고 처리하는 과정이 복잡해 많은 시간이 걸림.
- 함수 호출 횟수에 제한이 있다
  - 운영체제의 스택 크기에 제약이 있고, 이러한 함수의 호출 횟수가 운영체제의 시스템 스택이 지원하는 수준 이상으로 커지게 되면 프로그램이 강제 종료된다. (스택 오버플로우)



## 재귀 호출과 반복 호출

---

반복 호출 : for나 while문 등을 이용하여 반복적으로 명령을 실행하여 문제를 해결하는 방법.

| 구분 | 재귀 호출                                                    | 반복 호출                               |
| ---- | ------------------------------------------------------------ | --------------------------------------- |
| 장점 | 알고리즘이 간결하며 명확함                                   | 속도가 빠르고 시스템 메모리 사용이 작음 |
| 단점 | 시스템 스택을 사용하기 때문에 오래 걸리거나, 스택 메모리 문제가 발생할 수 있음 | 재귀 호출에 가독성이 떨어짐             |

재귀 호출과 반복 호출은 표현 능력이 같기 때문에 서로 대체 가능.

=> 컴퓨터의 성능이 좋아진 지금 협업을 할 때 코드의 가독성을 위해 재귀 호출을 사용함.



### 팩토리얼 함수

팩토리얼은 꼬리 재귀 호출 방식으로 구현되어 있어서 반복 호출 방식으로 변환하기 쉽다.

> 꼬리 재귀 호출 : 재귀 호출이 함수의 끝 부분에 단 한 번만 있는 경우



반복 호출 방식으로 팩토리얼을 구현

``` java
class Factorial{
    public static void main(String[] args){
        System.out.println(factorial_iter(5));
    }
    
    static int factorial_iter(int n){
        int ret = 1;
        int i = 1;
        
        for(i=n;i>1;i--){
            ret = ret * i;
        }
        
        return ret;
    }
}
```

=> 팩토리얼의 경우 재귀 호출이 함수의 끝 부분에서 단 한 번만 일어나기 때문에 반복 호출로 변경하기 쉽다.



### 피보나치 수열

피보나치 수열을 재귀 호출 방식으로 구현한 경우, 입력 파라미터의 크기에 따라 함수 호출 횟수가 기하급수적으로 증가함.



재귀 호출 방식으로 피보나치 수열 구현

``` java
public class Fibo{
    public static void main(String[] args){
        System.out.println(fib(5));
    }
    
    static int fib(int n){
        int ret = 0;
        if(n==0){
            ret = 0;
        }
        else if(n==1){
            ret = 1;
        }
        else{
            ret = fib(n-1) + fib(n-2);
        }
        return ret;
	}
}
```

![images](C:\Users\user\Downloads\images.png)

문제점

- 불필요한 중복 호출의 비중이 높아져 계산에 걸리는 시간이 급격히 증가한다.
- 피보나치 수열의 계산은 시간 복잡도가 O(2^n)이기 때문에 시간 복잡도가 지수적으로 증가한다.



반복 호출 방식으로  피보나치 수열 구현

``` java
public class Fibo {
    public static void main(String[] args){
        System.out.println(fib_iter(5));
    }

    static int fib_iter(int n){
        int ret = 0;
        if(n<2){
            ret = n;
        }
        else{
            int i = 0,temp = 0, current = 1, last =0;

            for(i=2;i<=n;i++){
                temp = current;
                current += last;
                last = temp;
            }
            ret = current;
        }
        return ret;
    }
}
```

-> 시간 복잡도가 O(n)으로 재귀 호출보다 성능이 훨씬 우수하다 / but 코드의 가독성이 떨어진다.



### 하노이 탑

하노이 탑 문제는 반복 호출 방법으로 문제를 해결하기 어렵고 재귀를 통해서만 문제를 쉽게 해결할 수 있는 예





![다운로드 (4)](C:\Users\user\Downloads\다운로드 (4).png)

하노의 탑 문제란?

1. 한번에 하나의 원판만 이동할 수 있다.
2. 맨 위에 있는 원판만 이동할 수 있다.
3. 크기가 작은 원판 위에 큰 원판이 있을 수 없다.(크기가 큰 원판 위에만 작은 원판을 놓을 수 있다.)
4. 중간 막대를 이용할 수 있으나 앞의 3가지 조건을 만족해야 한다.



하노이 탑의 함수에는 두번의 재귀와 한 번의 가장 큰 원반을 옮기는 가정이 필요하다 -> 3번의 과정으로 분해가 가능하다.

> 원판 1개를 기준으로

1. a에 있는 1번 원판을 c로 옮긴다.



> 원판 2개를 기준으로

1. a에 있는 1번 원판을 b로 옮긴다.
2. a에 있는 2번 원판을 c로 옮긴다.
3. b에 있는 1번 원판을 c로 옮긴다.



>  원판 3개를 기준으로

1. 3번 원판을 c로 옮기기 위해선 위의 두 원판을 b로 옮겨야 한다.
   1. a에 있는 1번 원판을 c로 옮긴다.
   2. a에 있는 2번 원판을 b로 옮긴다.
   3. c에 있는 1번 원판을 b로 옮긴다.
2. 3번 원판을 c로 옮긴다.
3. b의 남은 두 개의 원판을 c로 옮기기 위해 a를 경유한다.
   1. b에 있는 1번 원판을 a로 옮긴다.
   2. b에 있는 2번 원판을 c로 옮긴다.
   3. a에 있는 1번 원판을 c로 옮긴다.



=> 결국은 기둥의 알파벳만 바뀌고 각 과정이 반복이 일어난다.



``` java
public class Hanoi{
    public static void main(String[] args){
        char from = 'A';
        char temp = 'B';
        char to = 'C';

        hanoi_tower(4,from,temp,to);
    }

    static void hanoi_tower(int n, char from, char temp, char to){
        if(n==1){
            System.out.println("원판 1을 " + from + "에서 " + to + "로 옮겼습니다."); // 원판이 
        }
        else{
            hanoi_tower(n-1,from,to,temp); // n-1개의 원판을 from에서 temp로
            System.out.println("원판 " + n +"를 " + from + "에서 " + to + "로 옮겼습니다."); // n번째 원판을 from에서 to로
            hanoi_tower(n-1,temp,from,to); // n-1개의 원판을 temp에서 to로 
        }
    }
}
```



