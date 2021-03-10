# Chapter.4



## 4-1 리스트와 반복문

### 리스트란?

- 사전적 의미로는 '목록' , "파이썬에서 리스트의 의미는 여러가지 자료를 저장할 수 있는 자료"

- []안에 넣어서 쉼표로 구분하여 선언한다

- []안에 넣는 자료를 "요소(element)"라고 부른다
- 여러가지 자료형으로 구성될 수 있다

- 리스트가 들어간 자리의 위치는 0 부터 시작 (이 자릿값을 "인덱스(index)"라고 부른다) 
  - 음수를 넣어서 뒤에서부터 선택할 수 있다

``` python
list = ['안','녕','하','세','요']
print(list[1])
print(list[-3])
>>>
녕
하
```

- 리스트의 특정 요소는 변경할 수 있다
- 접근 연산자를 이중으로 사용할 수 있다

- 리스트 안에 리스트를 사용할 수 있다

``` python
list = [[1,2,3],["안",'녕'],32]
print(list[1][1])
>>>
녕
```



##### IndexError

``` python
list = [1,2,3]
print(list[4])
>>>
IndexError ## 요소가 존재하지 않는 위치의 요소에 접근하려해 발생
```



### 리스트 연산자: 연결(+), 반복(*), len() // 비파괴적 

``` python
listA = [1,2,3]
listB = [4,5,6]
print(listA+listB) ## +
print(listA*3) ## *
print(len(listB)) ## len
>>>
[1,2,3,4,5,6]
[1,2,3,1,2,3,1,2,3]
3
```

#### 중요~~!!

``` python
list_a = [1,2,3,4,5]
list_b = list_a
list_a[3] = 10
print(list_b)
>>>
[1,2,3,10,5]
```

list_b = list_a 로 값을 복사하면 list_a값이 바뀌면 list_b값이 바뀐다 // 포인터 개념

```python
list_a = [1,2,3,4,5]
list_c = list_a[:]
list_a[3] = 10
print(list_c)
>>>
[1,2,3,4,5]
```

list_c = list_a[:]로 값을 복사하면 list_c가 고유적으로 list_a값을 가지게 된거라 list_a 값이 바껴도 값이 바뀌지않음







### 리스트에 요소 추가하기: append, insert, extend // 파괴적

- append: 리스트 "뒤에" 요소를 추가한다 / append(요소)
- insert: 리스트 "중간에" 요소를 추가한다 / insert(위치,요소)
  - 위치가 한 칸씩 밀린다!
- extend: 리스트 "뒤에" 매개변수로 입력한 리스트를 추가한다 / extend([요소,요소,요소])

``` python
list=[1,2,3]
list.append(4)
list.insert(0,0)
list.extend([5,6,7])
list.append([8,9]) ## 잘 확인하기
print(list)
>>>
[0,1,2,3,4,5,6,7,[8,9]]
```



### 리스트에 요소 제거하기: del, pop, remove, clear // 파괴적

인덱스로 제거하기(위치를 기반으로)

- del:  특정 인덱스에 있는 요소를 제거 / del 리스트명[인덱스]
  - 범위를 지정해 리스트의 요소를 한꺼번에 제거할수 있음 ex) del 리스트명[3:6]

- pop: 특정 인덱스에 있는 요소 제거 / 리스트명.pop(인덱스)
  - 공백시 맨 마지막 인덱스를 제거 // 자동으로 -1 값이 들어감

``` python
list = [1,2,3,4,5]
del list[3] ## 4
list.pop() ## 5
print(list)
>>>
[1,2,3]
```



값으로 제거하기

- remove: 리스트 내부의 특정 값을 제거 / 리스트.remove(값)

``` python
list = [1,2,3,4]
list,remove(3)
print(list)
>>>
[1,2,4]
```



모두 제거하기

- clear: 리스트 내부의 요소를 모두 제거 / 리스트.clear()

``` python
list = [1,3,432,324]
list.clear()
print(list)
>>>
[]
```



### 리스트 내부에 있는지 확인하기: in/not in 연산자

특정 값이 리스트 내부에 있는지 확인시켜주는 연산자이다

``` python
list = [123,456,45,23]
print(273 in list)
print(123 in list)
print(45 not in list)
>>>
False
True
False
```



### for 반복문

for 반복자 in 반복할 수 있는 것:

​    코드

``` python
for i in range(100):
    print("HI")
>>>
HI
HI
..100번 출력
```

이 반복문을 리스트와 함께 사용하면

``` python
list = [12,34,545,65]
for element in list:
    print(elemet)
>>>
12
34
545
65
```



### 이터레이터 (eiterator)

여기서 반복할 수 있는 것을 "이터러블"이라고 하고

next() 함수를 사용해 꺼낼 수 있는 요소를 "이터레이터"라고 함

``` python
numbers = [1,2,3,4,5,6]
r_num = reversed(numbers)

print("reversed_numbers :",r_num)
print(next(r_num))
print(next(r_num))
print(next(r_num))
print(next(r_num))
print(next(r_num))
>>>
reversed_numbers : <list_reverseiterator object at 0x0000017160BB0548>
6
5
4
3
2
```

> 이터레이터는 반복문의 매개변수로 전달할 수 있으며, 현재 코드처럼 next() 함수로 내부의 요소를 하나하나 꺼낼 수 있다.
>
> > 메모리의 효율성을 위함



## 4-2 딕셔너리와 반복문



- 키를 기반으로 값을 저장함

- {}를 사용하여 선언하고 ,를 사용해서 연결한다
- 딕셔너리 안에 리스트를 저장하고 그 리스트를 출력할 수 있다

``` python
dict = {
    "이름":"희영",
    "전공":"정통",
    "특징":["바보","멍청이"]
}
print(dict["이름"])
print(dict["특징"])
print(dict["특징"][1])
>>>
희영
['바보','멍청이']
멍청이
```



##### NameError

``` python
dict = {
    이름:"희영",
    "전공":"정통",
    "특징":["바보","멍청이"]
}
print(dict["이름"])
>>>
NameError ##이름이 정의되어 있지 않음
```

##### keyError

``` python
dict = {
    "이름":"희영",
    "전공":"정통",
    "특징":["바보","멍청이"]
}
print(dict["돼지"])
>>>
KeyError ## 정의되지 않은 키에 접근
```

해결 방법 : get()

> 존재하지 않는 키에 접근하려하면 KeyError 대신 None을 반환한다

``` python
dict = {
    "이름":"희영",
    "전공":"정통",
    "특징":["바보","멍청이"]
}
value = dict.get("똥멍청이")
print(value)
if value == None:
    print("키가 없어")
>>>
None
키가 없어
```



### 딕셔너리에 값 추가하기 / 제거하기

- 추가 : 딕셔너리[새로운 키] = 새로운 값 

- 제거 : del 딕셔너리[키]

``` python
dict = {
    "이름":"희영",
    "전공":"정통",
    "특징":["바보","멍청이"]
}
dict["국준이도"]="바보해라" ## 키 추가
del dict["전공"] ## 키 제거
print(dict)
>>>
{'이름': '희영', '특징': ['바보', '멍청이'], '국준이도': '바보해라'}
```

 

### 딕셔너리 내부에 키가 있는지 확인하기

- in 키워드 // 리스트와 똑같이 작용함

```python
dict = {
    "이름":"희영",
    "전공":"정통",
    "특징":["바보","멍청이"]
}
key = "이름"
if key in dict:
    print("키가 이써")
else:
    print("존재하지 않는 키야")
>>>
키가 이써
```



### for 반복문: 딕셔너리와 함께 사용하기

for 키 변수 in 딕셔너리:

​    코드

``` python
dict = {
    "이름":"희영",
    "전공":"정통",
    "특징":["바보","멍청이"]
}
for key in dict:
    print(key, ":", dict[key] )
>>>
이름 : 희영
전공 : 정통
특징 : ['바보', '멍청이']
```



### type 함수

파이썬은 다음 방법으로 어떤 자료형인지 알 수 있다!

``` python
type("문자열") is str
type([]) is list
type({}) is dict
```



## 4-3 반복문과 while 반복문



### 범위 range()

- 매개변수 1개 (종료값)
  - range(5) // 0,1,2,3,4
- 매개변수 2개 (시작값,종료값)
  - range(2,5) // 2,3,4
- 매개변수 3개 range(시작값,종료값,증가값)
  - range(2,10,2) // 2,4,6,8

- 매개변수는 항상 "정수값"으로 입력되어야 한다

##### TypeError

``` python
n = 10
a = range(0,n/2)
print(list(a))
>>>
TypeError ## 나누기를 하면 실수값이 들어가게 된다
```

=>> 해결방법

``` python
n = 10
a = range(0,n//2)
print(list(a))
>>>
[0,1,2,3,4]
```



### for 반복문: 범위와 함께 사용하기

for 숫자변수 in 범위:

​    코드

``` python
for i in range(5):
    print(i)
>>>
0
1
2
3
4
```



### for 반복문:  리스트와 범위 조합하기

``` python
list = [1,2,3,4,5]

for i in range(len(list)):
    print("{}번째 반복: {}".format(i,list[i]))
>>>
0번째 반복: 1
1번째 반복: 2
2번째 반복: 3
3번째 반복: 4
4번째 반복: 5
```



### for 반복문:  반대로 반복하기

- range() 함수의 매개변수를 3개 사용해서 하는 방법

``` python
for i in range(4,-1,-1):
    print(i)
>>>
4
3
2
1
0
```



- reversed() 함수를 사용하는 방법

``` python
for i in reversed(range(5)):
    print(i)
>>>
4
3
2
1
0
```



### while 반복문

while 불 표현식: 

​    문장

``` python
while True:
    print(".")
>>>
........ ~~~ ##무한반복
```

### while 반복문: for반복문 처럼 사용하기

``` python
i=0
while i<5:
    print(i)
    i=i+1
>>>
0
1
2
3
4
```

> for 반복문은 while 반복문처럼 무한 반복을 구현할 수 없다!!



### while 반복문: 시간을 기반으로 반복하기

- 유닉스 타임 : 세계 표준시로 "1970년 1월 1일 0시 0분 0초"를 기준으로 몇 초가 지났는지 정수로 나타낸 것

``` python
import time
number = 0
target_tick = time.time() + 5
while time.time() < target_tick:
    number += 1
print("5초 동안 {}번 반복함".format(number))
>>>
5초 동안 19766364번 반복함
```



### while 반복문: break /continue

- break: 반복문을 벗어날 때 사용하는 키워드

``` python
i = 0
while True:
    print(i)
    i+=1
    if i > 5:
        break
>>>
0
1
2
3
4
5
```

- continue: 현재 반복을 생략하고 다음 반복으로 넘어갈 때 사용

``` python
i = 0
while True:
    i=i+1
    if i % 3 == 1:
        continue
    print(i)
>>>
2
3
5
6
8
9 ...
```



## 4-4 문자열, 리스트, 딕셔너리와 관련된 기본 함수



- 리스트에 적용할 수 있는 기본 함수 : min(),max(),sum()
- 리스트 뒤집기 : reversed()
- 현재 인덱스가 몇 번째인지 확인하기 : enumerate()
- 딕셔너리로 쉽게 반복문 작성하기 : item()
- 리스트 안에 for문 사용하기 : 리스트 내포



### 리스트에 적용할 수 있는 기본 함수: min(),max(),sum()

- min() : 리스트 내부에서 최솟값을 찾습니다
- max() : 리스트 내부에서 최댓값을 찾습니다
- sum() : 리스트 내부에서 값을 모두 더합니다

``` python
list = [100,30,50]
print(min(list))
print(max(list))
print(sum(list))
>>>
30
100
180
```



### reversed()함수로 리스트 뒤집기

``` python
list = [1,2,3,4,5]
temp = reversed(list)
for i in temp:
    print(i)
for i in temp:
    print(i)
>>>
5
4
3
2
1 ## 첫 번째 반복문만 실행이 된다
```

##### reversed() 함수의 결과는 "제너레이터"이기 때문에 함수 값의 결과를 여러번 사용하지 않음

따라서 값을 여러번 활용하기 위해선 함수를

``` python
list = [1,2,3,4,5]
for i in reversed(list):
    print(i)
for i in reversed(list):
    print(i)
```

이런 식으로 함수를 작성해야 한다

또는 "확장 슬라이싱" 이라고

``` python
list = [1,2,3,4,5]
print(list[::-1])
>>>
[5,4,3,2,1]
```

이런 방법도 있다



### enumerate() 함수와 반복문 조합하기

// 인덱스가 몇 번째인지 쉽게 확인 할 수 있음

``` python
list_A = ["A","B","C"]
print(enumerate(list_A)) ## enumerate 함수를 적용해 출력
print(list(enumerate(list_A))) ## 리스트로 강제 변환
>>>
<enumerate object at 0x000002C9312D3A48>
[(0, 'A'), (1, 'B'), (2, 'C')]

```



### 딕셔너리의 items() 함수와 반복문 조합하기

``` python
dict = {
    "A":"1",
    "B":"2",
    "C":"3"
}
print(dict.items())
## 반복문과 조합하면
for key,element in dict.items():
    print("key:{} = dict{}".format(key,element))
>>>
dict_items([('A', '1'), ('B', '2'), ('C', '3')])
key:A = dict1
key:B = dict2
key:C = dict3
```



### 리스트 내포

``` python
array = []
for i in range(0,10,2):
    array.append(i*i)
print(array)
>>>
[0, 4, 16, 36, 64]
```

는 리스트안에 for 문을 사용하는

``` python
array = [i*i for i in range(0,10,2)]
print(array)
>>>
[0, 4, 16, 36, 64]
```

와 같은 값을 가진다.

> 리스트 이름 = [표현식 for 반복자 in 반복할 수 있는 것]



여기에 조건문을 추가하면

> 리스트 이름 = [표현식 for 반복자 in 반복할 수 있는 것 if 조건문]

``` python
array = ['사과','수박','참외','메론','딸기']
output = [fruit for fruit in array if fruit != "딸기"]
print(output)
>>>
['사과', '수박', '참외', '메론']
```



### 구문 내부에 여러줄 문자열을 사용했을 때 문제점 해결하기

- 괄호로 문자열 연결하기

``` python
A = (
"요건"
"몰랐지"
"킼킼"
)
print(A)
>>> 요건몰랐지킼킼
```

- 문자열의 join()함수 사용하기

문자열.join("문자열"로 구성된 리스트)

``` python
list = ["안","녕","하","쇼"]
print(":".join(list))
>>>
안:녕:하:쇼
```

```python
number = int(input("숫자입력>"))
if number%2==0:
    print("""\
    입력한 정수는
    짝수\
    """)
else:
    print("""\
    입력한 정수는
    홀수\
    """)
>>>
숫자입력>3
    입력한 정수는
    홀수     
```

```python
list=[1,2,3]
a=reversed(list)
print(next(a))
print(next(a))
print(next(a))
print(next(a))
>>>
StopIteration
```

