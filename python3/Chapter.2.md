# Chapter.2



## 2-1 자료형과 문자열

자료란? 프로그램이 처리할 수 있는 모든 것

자료형의 종류

- 문자열(string) : 메일 제목, 메세지 내용 등..ex)"안녕하세요", "Hello World"
- 숫자(int,float) : 물건의 가격, 학생의 성적 등..ex)52, 273, 103.27

- bool : 친구의 로그인 상태 등..ex) True, False

자료를 확인 하는 법

``` python
print(type("안녕하세요"))
>>>
<class 'str'>
print(type(273))
>>>
<class 'int'>
```



파이썬에선 큰 따옴표와 작은 따옴표가 같은 결과를 출력한다 ex)

``` python
print('안녕하세요')
print("안녕하세요")
>>>
안녕하세요
안녕하세요
```

##### SyntaxError

``` python
print(""안녕하세요"라고 말했습니다")
>>>
SyntaxError
```

구문 오류 발생 =>> 자료와 자료를 나란히 나열할 수 없다

#### 해결방법

- 작은 따옴표,큰 따옴표로 문자열을 만든다.
- \\' : 작은 따옴표 

- \\" : 큰 따옴표

이 외의 이스케이프 문자

- \\n : 줄바꿈
- \\t : 탭
- \\\ : 역슬래쉬(\\)

문자열을 줄바꿈 없이 출력할 때

``` python
print("""\
안녕
하세
요로로로로롱\
""") ##역슬래쉬를 사용 안하면 첫 줄과 마지막 줄에서 줄바꿈이 일어난다##
```



### 문자열 연산자

> 문자열 연결 연산자 (+) : "문자열"+"문자열"

``` python
print("안녕하세용"+"Hello")
>>>
안녕하세용Hello
```

##### 타입 오류 실수

``` python
print("안녕하세요"+1)
>>>
TypeError
```

문자열은 문자열끼리만 더할 수 있다!!



> 문자열 반복 연산자 (*) : "문자열" * 숫자

``` python
print("안녕" * 3)
>>>
안녕안녕안녕
```



> 문자열 선택 연산자(인덱싱) : []

``` python
print("안녕하세요"[0])
print("안녕하세요"[3])
>>>
안
세
```

대괄호의 숫자를 음수로 입력하면

``` python
print("안녕하세요"[-1])
print("안녕하세요"[-3])
>>>
요
하
```



> 문자열 범위 연산자(슬라이싱) : [:]

``` python
print("안녕하세요"[1:4])
print("안녕하세요"[:3])
print("안녕하세요"[2:])
>>>
녕하세요
안녕하
하세요
```

##### 문장열 범위 연산자는 앞의 숫자는 포함 뒤의 숫자는 미포함 한다!!

##### IndexError

``` python
print("안녕하세요"[10])
>>>
Index Error
```

리스트/문자열의 수를 넘는 요소/글자를 선택할 때 발생



> 문자열의 길이 구하기 : len()

``` python
print(len("안녕하세요"))
>>>
5
```

\>> 이렇게 함수를 여러번 중첩시키면 괄호 안쪽부터 실행 됩니다.







## 2 -2 숫자 



- 정수형 (int) : 소수점이 없는 숫자 ex) 243

- 실수형 (float) : 소수점이 있는 숫자 ex) 76.234

- ##### ^부동 소수점 : 52.32 = 0.5232 * 10^2 처럼 소수점을 바꿔도 같은 숫자

``` python
print(type(23))
print(type(234.32))
>>>
<class 'int'>
<class 'float'>
```

#### 숫자 연산자

- 덧셈 연산자: +
- 뺼셈 연산자: -
- 곱셈 연산자: *
- 나눗셈 연산자: /
- 정수 나누기 연산자 : //
- 나머지 연산자 : %
- 제곱 연산자 : **

``` python
print(1+2)
print(4-2)
print(3*7)
print(11/2)
print(11//3)
print(9%7)
print(4**2)
>>>
3 # +
2 # -
21 # *
5.5 # /
3 # //
2 # %
16 # **
```

##### 연산자의 우선순위는 일반 사칙연산과 똑같이 적용된다.

##### TypeError

``` python
string = "하이"
number = 23
string + number ## 서로 다른 자료를 연산해서 발생함
```





## 2-3 변수와 입력



변수란? 값을 저장할 때 사용하는 식별자

``` python
pi = 3.14
print(pi)
>>>
3.14 ## 여기서 pi가 변수이다
```

##### 파이썬에선 다른 언어처럼 변수를 선언할 때 변수형을 선언해 주지 않아도 된다!!



### 복합 대입 연산자

- +=(문자열에서도 사용 가능)
- -=
- *=(문자열에서도 사용 가능)
- /=
- %=
- **=

``` python
A+=B # A=A+B
A-=B # A=A-B
A*=B # A=A*B
A/=B # A=A/B
A%=B # A=A%B
A**=B # A=A**B
```



### 사용자 입력 input()

``` python
userinput = input()
print(userinput)
>>>
>안녕하세요
안녕하세요 ## 함수의 결과 값을 리턴 값이라고 함
```

##### input 함수의 입력 값은 무조건 문자열 자료형이다!!!!



### 숫자를 문자, 문자를 숫자로 바꾸기

- int() : int 형으로 변경
- float() : float 형으로 변경
- str() : 숫자를 문자열로 변경

``` python
A = "32"
B = "21.43"
C = 23
print(int(A))
print(int(B))
print(str(C))
>>>
32
21.43
"23"
```

입력값을 정수로, 실수로 받는법

``` python
userinputA = int(input())
userinputB = float(input())
```



##### ValueError

- 숫자가 아닌 것을 숫자로 변환 할 때
- 소수점이 있는 숫자를 int함수로 변환 할때

``` python
int("안녕")
float("메롱")
int("62.43")
>>>
ValueError
```



## 2-4 숫자와 문자열의 다양한 기능



### 문자열의 format() 함수

format() 함수란 ? 문자열이 가지고 있는 함수입니다. 중괄호{}를 포함한 문자열 뒤에 마침표(.) 를 찍고 format() 함수를 사용하는데, 중괄화의 개수와 format 함수 괄호안 매개변수의 개수는 반드시 같아야합니다.

``` python
"{}".format(23) # type=string
"{}는 {}살입니다".format("희영이",23)
```

##### IndexError 

- {} 보다 매개변수가 많으면 정상 실행
- 매개변수보다 {} 가 많으면 IndexError 발생

``` python
print("{} {}".format(1,2,3,4))
>>>
1 2

print("{} {} {}".format(1,2))
>>
IndexError
```



### format() 함수의 다양한 기능

#### 정수

- {:d} ## 정수
- {:10d} ## 5칸 미루기
- {:05d} ## 빈칸을 0으로 채우면 5칸 미루기
- {:+d} ## 기호와 함께 출력
- {: d} ## 기호부분 공백
- {:+5d} ## 기호를 뒤로밀며 5칸 미루기
- {:=+5d} ## 기호를 앞으로 두고 5칸 미루기
- {:+05d} ## 기호를 앞에 두고 0채우기

#### 실수

정수와 동일하나

- {:.3f} ## 소수점 3자리까지만 출력
- {:g} ## 소수점 생략하기

#### 진수

- {:b} ## 2진수로 변환

- {:o} ##  8진수로 변환
- {:x} ## 16진수로 변환

### 대소문자 바꾸기 

- upper() : 알파벳을 대문자로
- low() : 알파벳을 소문자로

``` python
string = HellO
print(string.upper())
print(string.lower())
>>>
HELLO
hello
```

#### 이 외의 여러가지 함수

- strip() : 문자열 양옆의 공백 제거하기
- find() : 문자열 찾기(왼쪽 선)
- rfind() : 문자열 찾기 (오른쪽 선)
- in : 문자열 안에 어떤 문자열 있는지 확인
- split() : 특정한 문자를 기준으로 자름

``` python
#strip
A="""
     안녕
    하세요
"""
print(A.strip())
>>>
안녕
하세요

#find,rfind
A="안녕얄루안녕헬로"
print(A.find(안녕))
print(A.rfind(안녕))
>>>
0
4

#in
print("안녕" in  "안녕하세요")
>>>
True

#split
a = "10 20 30 40 50"
print(a.split(" "))
>>>
['10','20','30','40','50']
```

### split() 을 통해 여러개 입력받기

``` python
userinput = input("공백을 두고 여러개 입력하세요>").split()
## 10 20 30 안녕
print(userinput)
>>>
['10','20','30','안녕']
```

