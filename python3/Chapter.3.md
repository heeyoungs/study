# Chaper.3



## 3-1 불 자료형과 if 조건문

boolean 이란 True(1) 또는 False(0) 값만을 가질 수 있다



### 불 비교 연산자

- == ## 같다
- != ## 다르다
- \>= ## 크거나 같다
- \> ## 크다
- <= ## 작거나 같아
- \< ## 작다

``` python
print("가방"<"하마")
>>>
True ## 파이썬에서 한글은 가나다 순으로 작은 값을 갖는다
```



### 불 논리 연산자

- not ## 아니다
- and ## 그리고
- or ## 또는



### if 조건문

> 조건에 따라 코드를 실행하거나 실행하지 않게 하는 구문
>
> > 조건을 기반으로 실행의 흐름을 변경하는 것을 "조건 분기" 라고 함

``` python
A = 20
B = -21
if A>0:
    print("양수입니다")
if B<0:
    print("음수입니다")
>>>
양수입니다
음수입니다
```



### 날짜/시간 활용하기

``` python
import datemine ## 날짜/시간 관련 기능을 가져옵니다

now = datetime.datetime.now() ## 현재 날짜/시간을 구합니다

print(now.year, "년")
print(now.month, "월")
print(now.day, "일")
print(now.hour, "시")
print(now.minute, "분")
print(now.second, "초")
>>>
2020년
10월
2일
15시
48분
37초
```



## 3-2 if~else와 elif 구문



- else 조건문 // 조건문이 두 가지로만 구분될 때

``` python
if 조건:
    조건이 참일 때 실행 할 문장
else:
    조건이 거짓일 때 실행 할 문장
```

- elif 조건문 // 조건문이 두 가지만으로는 구분이 되지 않을 때

``` python
if 조건A:
    조건A가 참일 때 실행 할 문장
elif 조건B:
    조건B가 참일 때 실행 할 문장
else:
    모든 조건이 거짓일 때 실행 할 문장
```



##### 조건이 참이다 == True == 1

##### 조건이 거짓이다 == False == 0



#### pass

조건문 사이에는 어떤 내용이라도 작성해야 된다. 이 때 사용하는 구문이 pass 이다



##### IndentationError

``` python
if number > 0:
else: ## 조건문안에 아무 내용도 적혀있지 않아서 발생
```



##### raise NotimplementedError (강제 에러)

``` python
if number > 0:
    raise NotimplementedError
else:
    raise NotimplementedError
```

코드를 실행하면 정상적으로 진행되지만 구현되지 않은 부분에 들어가면 에러를 발생시킨다.

> 구현을 안했구나!! 를 인식 시켜주는데 도움을 줌