# Chapter.6

---



## 6-1 구문 오류와 예외

프로그램 오류의 종류

- 구문 오류(syntax error)
- 런타임 오류(runtime error)==예외(exception)



#### 구문 오류란?

프로그램이 "실행"되기도 전에 발생하는 오류.

괄호의 개수, 들여쓰기 문제 등으로 인해 발생함

``` python
print("# 프로그램 시작")
print("예외를 발생!)
--
SyntaxError: EOL while scanning string literal 
```



#### 예외란?

프로그램이 "실행 중"에 발생하는 오류.

```python
print("# 프로그램 시작")
list_a[1]
--
# 프로그램 시작
Traceback (most recent call last):
  File "C:/Users/user/PycharmProjects/pytpython!/main.py", line 2, in <module>
    list_a[1]
NameError: name 'list_a' is not defined
```



### 기본 예외 처리

그래서 이러한 예외를 해결하는 모든 것을 "예외 처리"라고 부른다.

- 조건문 if를 사용하는 방법
- try구문을 사용하는 방법



일단 예시로는

```python
number=int(input("정수만을 입력!!>"))

print("원의 반지름",number)
print("원의 넓이",number**2*3.14)
--
정수만을 입력!!>7
원의 반지름 7
원의 넓이 153.86
```



그런데 만약 정수를 입력하지 않게 되면?!?!?

``` python
number=int(input("정수만을 입력!!>"))

print("원의 반지름",number)
print("원의 넓이",number**2*3.14)
--
정수만을 입력!!>7m
Traceback (most recent call last):
  File "C:/Users/user/PycharmProjects/pytpython!/main.py", line 1, in <module>
    number=int(input("정수만을 입력!!>"))
ValueError: invalid literal for int() with base 10: '7m'
```

ValueError가 발생함!



#### 조건문으로 예외 처리

``` python
number=input("정수만을 입력!!>")

if number.isdigit():
    print("원의 반지름",int(number))
    print("원의 넓이",int(number)**2*3.14)
else:
    print("다른거 입력했지ㅡㅡ")
--
정수만을 입력!!>7c
다른거 입력했지ㅡㅡ
```



### try구문의 5개 형태

- try + except 구문 조합
- try + except + else 구문 조합
- try + except + finally 구문 조합
- try + except + else + finally 구문 조합
- try + finally 구문 조합

==>> try 구문은 혼자 사용할 수 없다!!!!!

다른 형태로 작성시 "구문오류(SyntaxError)"발생

#### try except 구문

``` python
try:
    number = int(input("정수만을 입력!!>"))
    print("원의 반지름",number)
    print("원의 넓이",number**2*3.14)
except:
    print("다른거 입력했지ㅡㅡ")

--
정수만을 입력!!>7c
다른거 입력했지ㅡㅡ   
```

##### try except구문에서 예외를 일단 강제종료 되는거부터 막자 할때 except 구문에 "pass"를 넣는다!!

// 만약 아직 구현되지 않은 부분에 대해 예외를 강제로 발생시켜 종료하고자 할 때에는 raise NotImplementedError 을 발생시킨다.



#### try except else 구문

예외가 발생할 수 있는 구문은 try에 나머지는 else 에 넣는다!

```python
try:
    number = int(input("정수만을 입력!!>"))
except:
    print("다른거 입력했지ㅡㅡ")
else:
    print("원의 반지름", number)
    print("원의 넓이", number ** 2 * 3.14)
--
1.
정수만을 입력!!>7
원의 반지름 7
원의 넓이 153.86

2.
정수만을 입력!!>7c
다른거 입력했지ㅡㅡ
```

##### try except else 구문은 파이썬과 루비에서만 사용 가능 => 굳이 없어도 프로그램 작성에 지장이 없다!!



#### finally 구문

예외가 발생하든 발생하지 않든 "무조건" 실행하는 구문

``` python
try:
    number = int(input("정수만을 입력!!>"))
except:
    print("다른거 입력했지ㅡㅡ")
else:
    print("원의 반지름", number)
    print("원의 넓이", number ** 2 * 3.14)
finally:
    print("프로그램 끝~")
--
1.
정수만을 입력!!>7
원의 반지름 7
원의 넓이 153.86
프로그램 끝~

2.
정수만을 입력!!>7c
다른거 입력했지ㅡㅡ
프로그램 끝~
```

finally 구문을 왜 사용해야 되는가??

->예시로 파일 처리를 들면



파일이 닫히지 않은 예시

```python
try:
    file = open("bais.txt","w")
    예외
    file.closed()
except Exception as e: ## 이 구문에 대해서는 후에 설명할게요~
    print(e)

print("file.close",file.closed) ## closed는 파일이 닫힌지 열렸는지를 확인시켜주는 속성
--
name '예외' is not defined
file.close False
```



파일을 닫는 방법 1.

```python
try:
    file = open("bais.txt","w")
    예외
except Exception as e:
    print(e)

file.close()
print("file.close",file.closed)
--
name '예외' is not defined
file.close True
```



파일을 닫는 방법 2.

```python
try:
    file = open("bais.txt","w")
    예외
except Exception as e:
    print(e)
finally:
    file.close()

print("file.close",file.closed)
--
name '예외' is not defined
file.close True
```

##### finally 구문은 사용하면 코드가 깔끔해 질때 사용하자!!





## 6-2 예외 고급

우리는 예외가 발생햇을때 예외의 정보를 얻고 싶을 때 "예외 객체"를 사용합니다.!!

형식은

```python
try:
    예외 발생 가능 구문
except 예외의 종류 as 예외 객체를 활용한 변수 이름:
	예외 발생시 실행 구문
```

##### 예외의 종류를 모를 때 Exception을 사용하자

```python
try:
    number = int(input("정수만을 입력!!>"))
    print("원의 반지름",number)
    print("원의 넓이",number**2*3.14)
except Exception as exception:
    print("type(exception)",type(exception))
    print("exception",exception)
--
정수만을 입력!!>7!
type(exception) <class 'ValueError'> ## value에러가 발생했다
exception invalid literal for int() with base 10: '7!' ## 7!이라 입력한거에서 발생했다
```



except구문은  elif문 과 비슷하게 예외를 구분할수 있습니다.

```python
list_number = [52,273,32,72,100]

try:
    number = int(input("정수>"))
    print("{}번째 요소는 {}".format(number,list_number[number]))
except ValueError:
    print("정수가 아니잖아")
except IndexError:
    print("4보다 크잖아")
--
1.
정수>2
2번째 요소는 32

2.
정수>7!
정수가 아니잖아

3.
정수>90
4보다 크잖아
```

##### except 구문의 마지막엔 else문과 비슷하게 Exception을 넣어서 프로그램이 죽지 않게 해주는게 좋다!

```python
list_number = [52,273,32,72,100]

try:
    number = int(input("정수>"))
    print("{}번째 요소는 {}".format(number,list_number[number]))
    예외
except ValueError:
    print("정수가 아니잖아")
except IndexError:
    print("4보다 크잖아")
except Exception:
    print("이건 무슨 에러야") ## value index에러가 아닌 에러가 발생하면 실행됨
--
정수>1
1번째 요소는 273
이건 무슨 에러야
```

==> 우리는 프로그램을 작성할 때 어떤 예외가 발생할 것인가를 잘 예측 하는것이 중요하다.!!

https://github.com/django/django/search?q=finally 이 사이트를 잘 활용해 보자~~