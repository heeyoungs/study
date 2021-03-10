# Chapter.8

---



## 8-1 클래스의 기본

---

### 객체 지향 프로그래밍, 객체, 클래스

- 객체 지향 프로그래밍 : 객체를 우선으로 생각해서 프로그래밍 한다. 
- 객체 : 여러 가지 속성을 가지고 있는 대상.
- 클래스 : 객체와 관련된 코드를 분리할 수 있게 해주는 것!/ 객체를 조금 더 효율적으로 생성하기 위해서 만들어진 구문.



### 객체

ex) 딕셔너리로 객체 만들기

``` python
students = [
    {"name" :"임희영","korea":100,"math":100,"english":100,"science":100},
    {"name" :"이국준","korea":3,"math":17,"english":10,"science":10},
    {"name" :"김민기","korea":1,"math":1,"english":1,"science":3}
]
for student in students:
    score_sum=student["korea"]+student["math"]+student["english"]+student["science"]
    score_avg = score_sum/4

    print(student["name"],score_sum,score_avg)
#실행결과
임희영 400 100.0
이국준 40 10.0
김민기 6 1.5
```



### 클래스 선언하기

``` python
class 클래스 이름: ## 캐멀케이스 (대문자)로 선언
    클래스 내용
```

- 인스턴스란? 클래스를 기반으로 만들어진 객체

``` python
인스턴스 이름(변수 이름) = 클래스 이름()
```

클래스 선언 예시)

```python
#클래스를 선언합니다.
class Student:
    pass
#학생을 선언합니다.
student = Student()
#학생 리스트를 선언합니다.
student=[
    Student(),
    Student(),
    Student(),
    Student()
]
```



### 생성자

- 생성자란? 클래스 이름과 같은 함수, 객체가 생성될 때 처리할 내용

``` python
class 클래스 이름:
    def __init__(self, 추가적인 매개변수):
        pass
```

- 클래스 내부의 함수는 첫 번째로 반드시 self를 입력해야 합니다.! 
- self는 자기 자신을 나타내는 딕셔너리라고 생각하면 됩니다.
- self가 가지고 있는 속성과 기능에 접근할 때는 self.<식별자> 형태로 접근합니다.

``` python
class Student:
    def __init__(self,name,korea,math,english,science):
        self.name=name
        self.korea=korea
        self.math=math
        self.english=english
        self.science=science
# Student 인스턴스가 생성될 때 속성이 직접 추가됨.
students =[
    Student("임희영",100,100,100,100),
    Student("이국준",10,9,8,7),
    Student("김민기",3,3,3,3)
]
# students 인스턴스에 접근하는 방법
students[0].name
students[0].korea
students[0].math
students[0].english
students[0].science
```



### 소멸자

- 소멸자란? 인스턴스가 소멸될 때 호출되는 함수

``` python
class 클래스 이름:
    def __del__(self):
        pass
```

- 소멸자의 호출은 8-2에서 다룸

``` python
class Test:
    def __init__(self,name): # 생성자
        self.name=name
        print("{} - 생성".format(self.name))

    def __del__(self): # 소멸자
        print("{} - 소멸".format(self.name))

test=Test('희영')
```



### 메소드

- 메소드란? 클래스가 가지고 있는 함수 /멤버 함수, 인스턴스 함수라고도 불림

``` python
class 클래스 이름:
    def 메소드 이름(self, 추가적인 매개변수):
        pass
```

메소드 구현 예시!)

``` python
class Student:
    def __init__(self, name, korea, math, english, science):
        self.name = name
        self.korea = korea
        self.math = math
        self.english = english
        self.science = science

    def get_sum(self):
        return self.korea+self.math+self.english+self.science

    def get_avg(self):
        return self.get_sum()/4

    def to_string(self):
        return "{}\t{}\t{}".format(\
            self.name,\
            self.get_sum(),\
            self.get_avg())

students =[
    Student("임희영",100,100,100,100),
    Student("이국준",10,9,8,7),
    Student("김민기",3,3,3,3)
]

for i in students:
    print(i.to_string())

#실행 결과
임희영	400	100.0
이국준	34	8.5
김민기	12	3.0
```



## 8-2  클래스의 추가적인 구문

---



### 들어가기전에!

- 상속이란? 어떤 클래스를 기반으로 그 속성과 기능을 물려받아 새로운 클래스를 만드는 것
- isinstance() 함수? 상속의 관계에 따라 객체가 어떤 클래스를 기반으로 만들었지는 확인할 수 있게 해주는 함수



### 어떤 클래스의 인스턴스인지 확인하기

``` python
isinstance(인스턴스, 클래스)
```

isinstance(),type() 비교

``` python
class Human:
    def __init__(self):
        pass

class Student(Human):
    def __init__(self):
        pass

student = Student()

print("isinstance(studnet,Human):",isinstance(student,Student))
print("type(student)==Student:",type(student)==Student)
print("isinstance(studnet,Human):",isinstance(student,Human))
print("type(student)==Human:",type(student)==Human)

#실행결과
isinstance(studnet,Human): True
type(student)==Student: True
isinstance(studnet,Human): True
type(student)==Human: False
```

- 단순한 인스턴스 확인이면 type()함수로도 가능
- type()함수는 상속 관계까지 확인해주지는 않음



isinstance() 함수 활용 예시)

``` python
class Student:
    def study(self):
        print("공부하자")

class Teacher:
    def teach(self):
        print("가르치자")

classroom = [Student(),Teacher(),Student(),Teacher()]

for who in classroom:
    if isinstance(who,Student):
        who.study()
    else:
        who.teach()
#실행결과
공부하자
가르치자
공부하자
가르치자
```



### 특수한 이름의 메소드

- 파이썬이 클래스를 사용할 때 제공해주는 보조 기능
- 특수한 상황에 자동으로 호출됨

______str______()함수 예시

``` python
class Student:
    def __init__(self, name, korea, math, english, science):
        self.name = name
        self.korea = korea
        self.math = math
        self.english = english
        self.science = science

    def get_sum(self):
        return self.korea+self.math+self.english+self.science

    def get_avg(self):
        return self.get_sum()/4

    def __str__(self):
        return "{}\t{}\t{}".format(\
            self.name,\
            self.get_sum(),\
            self.get_avg())

students =[
    Student("임희영",100,100,100,100),
    Student("이국준",10,9,8,7),
    Student("김민기",3,3,3,3)
]

for i in students:
    print(str(i))
#실행결과
임희영	400	100.0
이국준	34	8.5
김민기	12	3.0
```



크기 비교 함수들의 이름!

| 이름 | 영어                  | 설명        |
| ---- | --------------------- | ----------- |
| eq   | equal                 | 같다        |
| ne   | not equal             | 다르다      |
| gt   | greater than          | 크다        |
| ge   | greater than or equal | 크거나 같다 |
| lt   | less than             | 작다        |
| le   | less than or eqaul    | 작거나 같다 |



크기 비교 함수들 사용 예시)

``` python
class Student:
    def __init__(self, name, korea, math, english, science):
        self.name = name
        self.korea = korea
        self.math = math
        self.english = english
        self.science = science

    def get_sum(self):
        return self.korea+self.math+self.english+self.science

    def get_avg(self):
        return self.get_sum()/4

    def __str__(self):
        return "{}\t{}\t{}".format(\
            self.name,\
            self.get_sum(),\
            self.get_avg())

    def __eq__(self, value):
        return self.get_sum()==value.get_sum()
    def __ne__(self,value):
        return self.get_sum()!=value.get_sum()
    def __gt__(self,value):
        return self.get_sum()>value.get_sum()
    def __ge__(self,value):
        return self.get_sum()>=value.get_sum()
    def __lt__(self,value):
        return self.get_sum()<value.get_sum()
    def __le__(self,value):
        return self.get_sum()<=value.get_sum()


students =[
    Student("임희영",100,100,100,100),
    Student("이국준",10,9,8,7),
    Student("김민기",3,3,3,3),
    Student("이국준 바보",99,99,99,99)
]

print("students[0] == students[3] = ",students[0] == students[3])
print("students[0] != students[3] = ",students[0] != students[3])
print("students[0] > students[3] = ",students[0] > students[3])
print("students[0] >= students[3] = ",students[0] >= students[3])
print("students[0] < students[3] = ",students[0] < students[3])
print("students[0] <= students[3] = ",students[0] <= students[3])

#실행결과
students[0] == students[3] =  False
students[0] != students[3] =  True
students[0] > students[3] =  True
students[0] >= students[3] =  True
students[0] < students[3] =  False
students[0] <= students[3] =  False
```



### 클래스 변수와 메소드



#### 클래스 변수

클래스 변수는 class구문 바로 아래의 단계에서 변수를 선언한 것



- 클래스 변수 만들기

```python
class 클래스 이름:
    클래스 변수 = 값
```

- 클래스 변수에 접근하기

``` python
클래스 이름.변수 이름
```

클래스 변수의 예시)

```python
class Student:
    count = 0 # 클래스 변수 선언
    def __init__(self, name, korea, math, english, science):
        self.name = name
        self.korea = korea
        self.math = math
        self.english = english
        self.science = science

        Student.count += 1
        print("{}번째 학생이 생성".format(Student.count))


students =[
    Student("임희영",100,100,100,100),
    Student("이국준",10,9,8,7),
    Student("김민기",3,3,3,3),
    Student("이국준 바보",99,99,99,99)
]

print("현재 생성된 학생수는 {}입니다.".format(Student.count))
#실행결과
1번째 학생이 생성
2번째 학생이 생성
3번째 학생이 생성
4번째 학생이 생성
현재 생성된 학생수는 4입니다.
```



#### 클래스 함수

클래스가 가진 함수./ 클래스가 가진 기능 정도로 해석



- 클래스 함수 만들기

``` python
class 클래스 이름:
    @classmethod # 데코레이터
    def 클래스 함수(cls, 매개변수): # 첫 번째 변수로 클래스 자체가 들어온다.
       	pass
```

- 클래스 함수 호출하기

```python
클래스 이름.함수 이름(매개 변수)
```



클래스 함수의 예시)

``` python
class Student:
    count = 0
    students=[]

    @classmethod
    def print(cls): # 학생의 목록을 모두 출력하는 함수
        print("---  학생 목록  ---")
        print("이름\t  총점\t 평균\t")
        for student in cls.students: # students배열의 하나씩 출력
            print(str(student))
        print("------------------")

    def __init__(self, name, korea, math, english, science):
        self.name = name
        self.korea = korea
        self.math = math
        self.english = english
        self.science = science
        Student.count += 1
        Student.students.append(self) # 객체가 생성되면 students배열에 추가

    def get_sum(self):
        return self.korea + self.math + self.english + self.science

    def get_avg(self):
        return self.get_sum() / 4

    def __str__(self):
        return "{}\t{}\t{}".format( \
            self.name, \
            self.get_sum(), \
            self.get_avg())

students =[
    Student("임희영",100,100,100,100),
    Student("이국준",10,9,8,7),
    Student("김민기",3,3,3,3),
    Student("이국준",99,99,99,99)
]

Student.print()
#실행결과
---    학생 목록    ---
이름	  총점	 평균	
임희영	400	100.0
이국준	34	8.5
김민기	12	3.0
이국준	396	99.0
----------------------
```



## 좀 더 알아보기!

---



### 1. 가비지 컬렉터

- 스왑이란? 메모리가 부족해지면 컴퓨터가 하드디스크를 메모리처럼 사용해 무언가를 올리기 시작하는 동작
- 가비지 컬렉터란? 메모리에 올라간 것이 더이상 사용될 가능성이 없을 때 쓰레기라고 판단하고 쓰레기 수집하는 것
  - "더 이상 사용할 가능성이 없는 데이터"란? 변수에 저장되지 않거나, 함수 등에서 나오면서 변수를 활용할 수 없게 되는 경우



=> 소멸자를 통해 언제 인스턴스가 소멸되는지에 대한 궁금증 해결

1.  변수에 저장하지 않은 경우

``` python
class Test:
    def __init__(self,name):
        self.name=name
        print("{} - 생성".format(self.name))
    def __del__(self):
        print("{} - 파괴".format(self.name))

Test("A")
Test('B')
Test("C")
#실행결과
A - 생성
A - 파괴
B - 생성
B - 파괴
C - 생성
C - 파괴
```

=> A가 생성되고 변수에 저장하지 않으면 필요없다는 인식하에 가비지 컬렉터가 지워 버린다.



2. 변수에 저장한 경우

``` python
class Test:
    def __init__(self,name):
        self.name=name
        print("{} - 생성".format(self.name))
    def __del__(self):
        print("{} - 파괴".format(self.name))

a=Test("A")
b=Test('B')
c=Test("C")
#실행결과
A - 생성
B - 생성
C - 생성
A - 파괴
B - 파괴
C - 파괴
```

=> A가 변수에 저장되었으니 나중에 활용된다는게 아닐까? 라는 의미로 프로그램이 종료될때까지 제거하지 않다고 종료시 지워 버린다.



### 2. 프라이빗 변수와 게터/세터

- 프라이빗 변수란? 클래스 내부의 변수를 외부에서 사용하는 것을 막고 싶을 때 사용, 변수 이름을 "__<변수 이름>" 형태로 선언



원의 넓이를 구하는 클래스로 예시를 들어보면!)

``` python
import math
class Circle:
    def __init__(self,radius):
        self.__radius=radius ## 반지름 변수를 프라이빗 변수로 선언
    def get_circumference(self):
        return 2*math.pi*self.__radius
    def get_area(self):
        return math.pi*(self.__radius**2)

circle = Circle(10)
print("원의 둘레:", circle.get_circumference())
print("원의 넓이:",circle.get_area())
print(circle.__radius) # 원의 반지름에 접근-> 에러발생

#실행결과
원의 둘레: 62.83185307179586
원의 넓이: 314.1592653589793
Traceback (most recent call last):
  File "C:/Users/user/PycharmProjects/pytpython!/main.py", line 14, in <module>
    print(circle.__radius)
AttributeError: 'Circle' object has no attribute '__radius'
```

=> 만약 원의 반지름을 변경하고 싶다면 어떻게 해야할까요?  => 반지름에 간접적으로 접근하는 방법을 찾아야 한다.



이때 사용되는 것이 "게터"와 "세터"이다.

- 게터란? 프라이빗 변수의 값을 추출
- 세터란? 프라이빗 변수의 값을 변경

``` python
import math
class Circle:
    def __init__(self,radius):
        self.__radius=radius
    def get_circumference(self):
        return 2*math.pi*self.__radius
    def get_area(self):
        return math.pi*(self.__radius**2)
    def get_radius(self): # 게터
        return self.__radius
    def set_radius(self,radius): # 세터
        self.__radius=radius

circle = Circle(10)
print("원의 둘레:", circle.get_circumference())
print("원의 넓이:",circle.get_area())
print("반지름에 접근",circle.get_radius())
print("반지름을 2로 변경")
circle.set_radius(2)
print("원의 둘레:", circle.get_circumference())
print("원의 넓이:",circle.get_area())

#실행결과
원의 둘레: 62.83185307179586
원의 넓이: 314.1592653589793
반지름에 접근 10
반지름을 2로 변경
원의 둘레: 12.566370614359172
원의 넓이: 12.566370614359172
```

=> 프로그램 작성시 게터와 세터 함수 사용 빈도가 많아져서 "@property,@<변수 이름>.setter" 라는 데코레이터를 사용



```python
import math
class Circle:
    def __init__(self,radius):
        self.__radius=radius
    def get_circumference(self):
        return 2*math.pi*self.__radius
    def get_area(self):
        return math.pi*(self.__radius**2)

    @property # 데코레이터
    def radius(self):
        return self.__radius
    @radius.setter

    def radius(self,radius):
        self.__radius=radius

circle = Circle(10)
print("원의 둘레:", circle.get_circumference())
print("원의 넓이:",circle.get_area())
print("반지름에 접근",circle.radius) # 바뀜
print("반지름을 2로 변경")
circle.radius=2 # 바뀜
print("원의 둘레:", circle.get_circumference())
print("원의 넓이:",circle.get_area())

#실행결과
원의 둘레: 62.83185307179586
원의 넓이: 314.1592653589793
반지름에 접근 10
반지름을 2로 변경
원의 둘레: 12.566370614359172
원의 넓이: 12.566370614359172
    => 실행결과는 동일하다.
```



### 3. 상속

- 상속이란? 다른 누군가가 만들어 놓은 기본 형태에 내가 원하는 것만 교체하는 것

- 다중 상속이란? 다른 누군가가 만들어 놓은 형태들을 조립해서 내가 원하는 것을 만드는 것

- 부모란? 기반이 되는 것

- 자식이란? 기반으로 생성한 것



상속 예시)

```python
class Parent:
    def __init__(self):
        self.value = "테스트"
        print("Parent 클래스의 __init()__ 메소드가 호출되었습니다.")
    def test(self):
        print("Parent 클래스의 test() 메소드입니다.")

class Child(Parent):
    def __init__(self):
        Parent.__init__(self)
        print("Child 클래스의 __init()__ 메소드가 호출되었습니다.")
        
# 자식 클래스의 인스턴스로 부모 클래스의 메소드에 접근!
child = Child()
child.test()
print(child.value) 

#실행결과
Parent 클래스의 __init()__ 메소드가 호출되었습니다.
Child 클래스의 __init()__ 메소드가 호출되었습니다.
Parent 클래스의 test() 메소드입니다.
테스트
```



사용자 예외 클래스를 상속을 통해 만들어 보자!

1. ``` python
   class CustomException(Exception): # Exception이라는 기존의 클래스를 상속 받는다.
       def __init__(self):
           Exception.__init__(self)
           
   raise CustomException
   
   #실행결과
   Traceback (most recent call last):
     File "C:/Users/user/PycharmProjects/pytpython!/main.py", line 6, in <module>
       raise CustomException
   __main__.CustomException
   ```



오버라이드(재정의) : 부모에 정의되어 있는 함수를 자식에서 다시 정의하는 것 / 우선하다.

2. ``` python
   class CustomException(Exception):
       def __init__(self):
           Exception.__init__(self)
           print("내가 만든 오류~")
       def __str__(self): # 부모 클래스에도 존재하는 함수이다.
           return "오류가 발생"
   
   raise CustomException
   
   #실행결과
   Traceback (most recent call last):
     File "C:/Users/user/PycharmProjects/pytpython!/main.py", line 8, in <module>
       raise CustomException
   __main__.CustomException: 오류가 발생
   내가 만든 오류~
   ```



자식 클래스에 부모에는 없는 새로운 함수를 정의하자.

3. ``` python
   class CustomException(Exception):
       def __init__(self,message,value):
           Exception.__init__(self)
           self.message=message
           self.value=value
   
       def __str__(self):
           return self.message
   
       def print(self):
           print("## 오류 정보 ##")
           print("메세지 : ",self.message )
           print("값 : ",self.value)
   
   try:
       raise CustomException("딱히 이유 없음",272121212)
   except CustomException as e:
       e.print()
   
   #실행결과
   ## 오류 정보 ##
   메세지 :  딱히 이유 없음
   값 :  272121212
   ```

