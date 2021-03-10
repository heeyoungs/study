# Chapter.5

---



## 5-1 함수 만들기

### 함수의 기본 형태

``` python
def 함수이름():
    문장
```

예시)

``` python
def print_3_times():
    print("안녕")
    print("안녕")
    print("안녕")
print_3_times()
##
안녕
안녕
안녕
```



### 함수에 매개변수 넣기

``` python
def 함수이름(매개변수, 매개변수, ...):
    문장
```

예시)

``` python
def print_n_times(value, n):
    for i in range(n):
        print(value)
        
print_n_times("안녕하세요",5)
##
안녕하세요
안녕하세요
안녕하세요
안녕하세요
안녕하세요
```



#### TypeError

- 지정한 매개 변수의 개수보다 넣은 매개 변수의 개수가 적을 때 발생.
- 지정한 매개 변수의 개수보다 넣은 매개 변수의 개수가 많을 때도 발생.
  - 함수를 호출 할 때에는 선언할 때와 같은 개수의 매개 변수를 입력하자.



### 가변 매개변수

``` python
def 함수이름(매개변수, 매개변수, *가변 매개변수):
    문장
```

- 가변 매개변수 뒤에는 일반 매개변수가 올 수 없습니다.
- 가변 매개변수는 하나만 사용할 수 있습니다.

예시)

``` python
def print_n_times(n, *values):
    for i in range(n):
        for value in values:
            print(value)
        print()
        
print_n_times(3, "안녕하세요" ,"즐거운","파이썬 프로그래밍")        
##
안녕하세요
즐거운
파이썬 프로그래밍

안녕하세요
즐거운
파이썬 프로그래밍

안녕하세요
즐거운
파이썬 프로그래밍
```



### 기본 매개변수

``` python
print(value, ..., sep=' ', end='\n', file=sys.stdout, flush=False)
```

- 매개변수를 입력하지 않았을 경우 매개변수에 들어가는 기본값
- 기본 매개변수 뒤에는 일반 매개변수가 올 수 없습니다.

예시)

``` python
def print_n_times(value, n=2): # n에 기본값인 2가 들어감
    for i in range(n):
        print(value)
        
print_n_times("안녕하세요")
##
안녕하세요
안녕하세요
```



### 키워드 매개변수

#### 기본 매개변수가 가변 매개변수보다 앞에 올 때

- 기본 매개 변수의 의미가 사라진다.
- TypeError발생 => 의미가 없다!!

``` python
def print_n_times(n=2, *values):
    for i in range(n):
        for value in values:
            print(value)
        print()
        
print_n_times("안녕하세요", "즐거운", "파이썬 프로그래밍")
##
Traceback (most recent call last):
  File "C:/Users/user/Desktop/study/python3/python_project/merge/myWeb/dd.py", line 8, in <module>
    print_n_times("안녕하세요", "즐거운", "파이썬 프로그래밍")
  File "C:/Users/user/Desktop/study/python3/python_project/merge/myWeb/dd.py", line 2, in print_n_times
    for i in range(n):
TypeError: 'str' object cannot be interpreted as an integer
```



#### 가변 매개변수가 기본 매개변수보다 앞에 올 때

- 가변 매개변수가 우선이 된다

``` python
def print_n_times(*values, n=2):
    for i in range(n):
        for value in values:
            print(value)
        print()
        
print_n_times("안녕하세요", "즐거운", "파이썬 프로그래밍",3)
##
안녕하세요
즐거운
파이썬 프로그래밍
3

안녕하세요
즐거운
파이썬 프로그래밍
3
```



==> 가변>기본>일반



#### 키워드 매개변수

- 매개변수 이름을 지정해서 입력하는 매개변수

``` python
def print_n_times(*values, n=2):
    for i in range(n):
        for value in values:
            print(value)
        print()
        
print_n_times("안녕하세요", "즐거운", "파이썬 프로그래밍",n=3)
##
안녕하세요
즐거운
파이썬 프로그래밍

안녕하세요
즐거운
파이썬 프로그래밍

안녕하세요
즐거운
파이썬 프로그래밍
```



#### 기본 매개변수 중에서 필요한 값만 입력하기

``` python
def test(a, b=10, c=100):
    print(a+b+c)
    
test(10,20,30) ## 기본형태 1

test(a=10,b=100,c=200) ## 모든 매개변수를 해도 가능 2

test(c=10,a=100,b=200) ## 마구잡이로 해도 가능 3 

test(10,c=200) ## 일부만 지정해도 가능 4

##
60
310
310
220
```

1. 첫 번째 매개변수 a는 일반 매개변수이므로 해당위치에 반드시 입력해야 한다.
2. 일반 매개변수이지만 키워드 매개변수처럼 사용할 수도 있다.
3. 키워드를 지정해서 매개변수를 입력하는 경우에는 매개변수 순서를 원하는대로 입력할수있다.
4. 키워드 매개변수를 사용하면 필요한 매개변수에만 값을 전달할 수 있습니다.
5. 일반 매개변수는 필수로 입력해야한다.



### 리턴

- return : 함수를 실행했던 위치로 돌아가라는 뜻. => 함수의 종료
- 리턴 값 : 함수의 결과 값

#### 자료 없이 리턴하기

```python
def return_test():
    print("A위치입니다.")
    return ## 조기 리턴 -> 흐름 중간에 리턴 키워드를 사용
	print("B위치입니다.")
    
return_test()
##
A위치입니다.
```

#### 자료와 함께 리턴하기

``` python
def return_test():
    return 100

value = return_test()
print(value)
##
100
```

#### 아무것도 리턴하지 않기

``` python
def return_test():
    return

value = return_test()
print(value)
##
None -> 없다 라는 의미
```

#### 

### 기본적인 함수의 활용

형태

``` python
def 함수(매개변수):
    변수 = 초깃값
    # 여러가지처리
    # 여러가지 처리
    return 변수
```

- 초깃값을 설정할 때는 연산을 해도 아무런 변화를 주지 않는 것을 사용

예시) 정수를 더하는 함수

``` python
def sum_all(start=0,end=100,step=1):
    output=0
    for i in range(start,end + 1,step):
        output += i
    return output

print("A.", sum_all(0, 100, 10))
print("B.", sum_all(end=100))
print("C.", sum_all(end=100, step=2))
##
A. 550
B. 5050
C. 2550
```



## 5-2 함수의 활용

### 재귀함수

- 함수 내부에서 자기 자신을 호출

예) 팩토리얼 구하기 by 반복문

``` python
def factorial(n):
    output = 1
    for i in range(1, n+1):
        output *= i
        
    return output

print("1!:", factorial(1))
print("2!:", factorial(2))
print("3!:", factorial(3))
print("4!:", factorial(4))
print("5!:", factorial(5))
##
1!: 1
2!: 2
3!: 6
4!: 24
5!: 120
```

예) 재귀함수로 팩토리얼 구하기

```python
def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)
    
print("1!:", factorial(1))
print("2!:", factorial(2))
print("3!:", factorial(3))
print("4!:", factorial(4))
print("5!:", factorial(5))
##
1!: 1
2!: 2
3!: 6
4!: 24
5!: 120
```



파이썬은 함수 내부에서 함수 외부에 있는 변수를 참조하지 못한다.

-> global을 선언해줘야 한다.

``` python
global 변수이름
```

예시)

``` python
counter = 0

def fibonacci(n):
    counter += 1
    
    if n == 1:
        return 1
    if n == 2:
        return 1
    else:
        return fibonacci(n-1) + fibonacci(n-2)
    
print(fibonacci(10))
##
Traceback (most recent call last):
  File "C:/Users/user/Desktop/study/python3/python_project/merge/myWeb/dd.py", line 15, in <module>
    print(fibonacci(10))
  File "C:/Users/user/Desktop/study/python3/python_project/merge/myWeb/dd.py", line 5, in fibonacci
    counter += 1
UnboundLocalError: local variable 'counter' referenced before assignment
```

-> 함수 외부의 counter을 참조하려다 UnboundLocalError 발생



### 메모화

- 딕셔너리를 사용해서 한 번 계산한 값을 저장한다.( 메모 )

- 코드의 속도를 빠르게 만들어준다.

피보나치 수열의 메모화 예시)

``` python
dictionary = {
    1: 1,
    2: 2
}

def fibonacci(n):
    if n in dictionary:
        return dictionary[n]
    else: 
        output = fibonacci(n-1) + fibonacci(n-2)
        dictionary[n] = output
        return output
    
print("fibonacci(10):",fibonacci(10))
print("fibonacci(20):",fibonacci(20))
print("fibonacci(30):",fibonacci(30))
print("fibonacci(40):",fibonacci(40))
print("fibonacci(50):",fibonacci(50))
##
fibonacci(10): 89
fibonacci(20): 10946
fibonacci(30): 1346269
fibonacci(40): 165580141
fibonacci(50): 20365011074
```



## 5-3 함수 고급

### 튜플

- 리스트와 비슷한 자료형
- `한번 결정된 요소를 바꿀 수 없다`
  - 요소 변경시 TypeError 발생

``` python
(데이터, 데이터, 데이터, ...)
```

튜플의 선언

``` python
>>> tuple_test = (10,20,30)

>>> tuple_test[0]
10
>>> tuple_test[1]
20
>>> tuple_test[2]
30
```

선언시 주의할 점

``` python
(273) => 273이라는 숫자를 괄호로 감싼 것
(273,) => 273요소를 하나만 가진 튜플
```



튜플 예시

- 괄호를 생략해도 튜플로 인식할 수 있는 경우는 괄호를 생략할 수 있다.

``` 
tuple_test = 10, 20, 30, 40
print(" # 괄호가 없는 튜플")
print("tuple_test:", tuple_test)
print("type(tuple_test:)",type(tuple_test))
print()

a,b,c = 10,20,30
print(" # 괄호가 없는 튜플 할당")
print("a:",a)
print("b:",b)
print("c:",c)
##
 # 괄호가 없는 튜플
tuple_test: (10, 20, 30, 40)
type(tuple_test:) <class 'tuple'>

 # 괄호가 없는 튜플 할당
a: 10
b: 20
c: 30
```

- 간단한 변수 교환 튜플

``` python
a,b = 10,20

print("# 교환 전 값")
print("a:",a)
print("b:",b)
print()

a, b = b, a

print("# 교환 후 값")
print("a:",a)
print("b:",b)
print()
##
# 교환 전 값
a: 10
b: 20

# 교환 후 값
a: 20
b: 10
```

- 함수값 리턴에 사용되는 튜플

``` python
def test():
    return (10,20)

a,b = test()

print("a:",a)
print("b:",b)
##
a: 10
b: 20
```



### 람다

- 함수의 매개 변수로 함수 전달하기

``` python
def call_10_times(func):
    for i in range(10):
        func()
        
def print_hello():
    print("안녕하세요")
    
call_10_times(print_hello)
##
안녕하세요
안녕하세요
안녕하세요
안녕하세요
안녕하세요
안녕하세요
안녕하세요
안녕하세요
안녕하세요
안녕하세요
```

- map(): 함수 리스트의 요소를 함수에 넣고 리턴된 값으로 새로운 리스트를 구성해주는 함수

``` python
map(함수, 리스트)
```

- filter()함수: 리스트의 요소를 함수에 넣고 리턴된 값이 True인 것으로 새로운 리스트를 구성해주는 함수

``` python
filter(함수, 리스트)
```

- map함수 filter함수 사용

``` python
def power(item):
    return item * item
def under_3(item):
    return item < 3

list_input_a = [1,2,3,4,5]

output_a = map(power, list_input_a)
print("# map() 함수의 실행 결과")
print("map(power, list_input_a):",output_a)
print("map(power, list_input_a):",list(output_a))
print()

output_b = filter(under_3, list_input_a)
print("# filter() 함수의 실행 결과")
print("filter(power, list_input_a):",output_b)
print("filter(power, list_input_a):",list(output_b))
##
# map() 함수의 실행 결과
map(power, list_input_a): <map object at 0x0000025F75069FC8>
map(power, list_input_a): [1, 4, 9, 16, 25]

# filter() 함수의 실행 결과
filter(power, list_input_a): <filter object at 0x0000025F750699C8>
filter(power, list_input_a): [1, 2]
```

=> 여기서 map object, filter object 가 제너레이터이다.



- 위의 방식으로 함수 구문을 작성하는 것이 공간 낭비라고 생각해서 만들어진 것이 `람다` 이다.

- lamba : 간단한 함수를 쉽게 선언하는 방법

``` python
lambda 매개변수 : 리턴값
```

``` python
power = lambda x : x * x
under_3 = lambda x: x < 3

list_input_a = [1,2,3,4,5]

output_a = map(power, list_input_a)
print("# map() 함수의 실행 결과")
print("map(power, list_input_a):",output_a)
print("map(power, list_input_a):",list(output_a))
print()

output_b = filter(under_3, list_input_a)
print("# filter() 함수의 실행 결과")
print("filter(power, list_input_a):",output_b)
print("filter(power, list_input_a):",list(output_b))
##
# map() 함수의 실행 결과
map(power, list_input_a): <map object at 0x0000020C5B619E48>
map(power, list_input_a): [1, 4, 9, 16, 25]

# filter() 함수의 실행 결과
filter(power, list_input_a): <filter object at 0x0000020C5B61E888>
filter(power, list_input_a): [1, 2]
```

=> 매개변수에 곧 바로 넣을 수 있다

``` python
list_input_a = [1,2,3,4,5]

output_a = map(lambda x : x * x, list_input_a)
print("# map() 함수의 실행 결과")
print("map(power, list_input_a):",output_a)
print("map(power, list_input_a):",list(output_a))
print()

output_b = filter(lambda x: x < 3, list_input_a)
print("# filter() 함수의 실행 결과")
print("filter(power, list_input_a):",output_b)
print("filter(power, list_input_a):",list(output_b))
##
# map() 함수의 실행 결과
map(power, list_input_a): <map object at 0x000001EF4FCE9DC8>
map(power, list_input_a): [1, 4, 9, 16, 25]

# filter() 함수의 실행 결과
filter(power, list_input_a): <filter object at 0x000001EF4FCE9E48>
filter(power, list_input_a): [1, 2]
```



### 파일 처리

#### 파일 열고 닫기

``` python
파일 객체 = open(문자열: 파일 경로, 문자열: 읽기 모드)
```

| 모드 | 설명                         |
| ---- | ---------------------------- |
| w    | write모드 (새로 쓰기 모드)   |
| a    | append모드(뒤에 이어서 쓰기) |
| r    | read모드(읽기 모드)          |

``` python
파일 객체,closed()
```

- 파일 열고 닫기

``` python
file = open("basic.txt","w")

file.write("Hello Python Programming...!")

file.close()
##
basic.txt 파일이 생성되고
Hello Python Programming...! 가 작성된다.
```



#### with 키워드

``` python
with open(문자열: 파일 경로, 문자열 모드) as 파일 객체:
    문장
```

- with 구문이 끝나면 자동으로 파일이 닫힘!

``` python
with open("basic.txt","w") as file:
    file.write("Hello Python Programming...!")
```



#### 텍스트 일기

``` python
파일 객체.read()
```

- 파일 내부에 있는 데이터를 모드 읽어 출력

``` python
with open("basic.txt","r") as file: ## 읽기 모드
    content = file.read()
    
print(content)
##
Hello Python Programming...!
```



#### 한 줄씩 읽기

- 반복문을 사용

``` python
for 한 줄을 나타내는 문자열 in 파일 객체:
    처리
```

``` python
with open("info.txt","r") as file:
    for line in file :
        (name, weight, height) = line.strip().split(", ")
        
        ## 데이터가 문제있는지 계산한다.
        if(not name) or (not weight) or (not height):
        	continue
            
        bmi = int(weight) / (int(height) * int(height))
        result = ""
        if 25 <= bmi:
            result = "과체중"
        elif 18.5 <= bmi:
            result = "정상체중"
        else:
            result = "저체중"
            
            
        print('\n'.join([
            "이름: {}",
            "몸무게: {}",
            "키: {}",
            "BMI: {}",
            "결과: {}"
        ]).format(name,weight,height,bmi,result))
        print()
```



### 제너레이터

- 제너레이터는 이터레이터를 직접 만들 때 사용
- 함수 내부에 yield키워드를 사용하면 제너레이터 함수가 됨
- 호출해도 함수 내부의 코드가 실행 x
- 제너레이터는 제너레이터를 리턴
- next() 함수를 사용해 코드를 실행

- yield 키워드를 만나지 못하고 함수가 끝나면 StopIteration이라는 예외가 발생

``` python
def test():
    print("A 지점 통과")
    yield 1
    print("B 지점 통과")
    yield 2
    print("C 지점 통과")


output = test()

print("D 지점 통과")
a = next(output)
print(a)

print("E 지점 통과")
b = next(output)
print(b)

print("F 지점 통과")
c = next(output)
print(c)
##
D 지점 통과
A 지점 통과
1
E 지점 통과
B 지점 통과
2
F 지점 통과
C 지점 통과
Traceback (most recent call last):
  File "C:/Users/user/Desktop/study/python3/python_project/merge/myWeb/dd.py", line 20, in <module>
    c = next(output)
StopIteration
```

