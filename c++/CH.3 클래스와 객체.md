# CH.3 클래스와 객체

---



## 3.1 객체에 대한 이해

객체란? 실세계에 존재하거나 생각할 수 있는 것을 **객체**(object)라고 한다

- 객체는 캡슐화가 된다 
  - ex) 알약, 사람의 장기..
- 객체의 일부 요소는 공개된다
  - ex) Tv의 on/off 버튼, 사람의 눈, 코, 입..
- 멤버 함수와 멤버 변수로 구성된다
  - ex) Tv의 경우 on/off (상태) , 켜기/끄기 (행동) 으로 구분되듯이 C++에 적용된다
- C++에서의 클래스는 객체를 정의하는 틀,설계도
  -  멤버 변수, 멤버 함수를 선언하는 곳
  - ex) 클래스 = 붕어빵 틀/ 객체 = 붕어빵



## 3.2 클래스 만들기

class 키워드를 사용해서 클래스를 선언한다

``` C++
class Circle{  // 클래스 선언부
public:  // 접근 지정자
    int radius;  // 멤버 변수
    double getArea();  // 멤버 함수
}; // 마지막에 ';' 꼭 붙여야 된다 

double Circle::getArea(){  // 클래스 구현부
    return 3.14%radius*radius;
} 
```

선언부

- 멤버 변수는 클래스 선언부에서 초기화 할 수 없다.
- 멤버 함수는 원형 형태로 선언된다.
- 접근 지정자
  - protect, public, private 가 있다

구현부

- 클래스의 선언부에서 선언된 멤버 함수의 코드를 구현한다



## 3.3 객체 생성과 객체 활용

클래스 예시

``` c++
#include <iostream>
using namespace std;

class Circle{
public:
    int radius;
    float getArea();
};

float Circle::getArea(){
    return 3.14*radius*radius;
}

int main(){
    Circle donut; // Circle 객체 생성, 객체 이름 donut
    donut.radius = 10; // dount 객체의 멤버 변수 radius에 접근 (구조체와 같은 방식)
    cout<< donut.getArea()<<endl; // donut 객체의 멤버 함수 getArea 호출
}
>>>
314
```



## 3.4 생성자

- 특별한 멤버 함수 // 선언되지 않았을 경우자동 생성(defalut 생성자)
  - 생성자가 하나라도 선언되어있으면 기본생성자 생성X
- 멤버 변수의 값을 설정, 동적 할당 받기, 네트 워크 할당등의 특별한 목적을 위함
- 객체가 생성될 때 단 '한 번' 실행
- 클래스의 이름과 동일하게 작성
- return 타입을 선언하지 않는 함수이다
- 생성자는 중복이 가능하다
  - 이름이 모두 같으므로 매개 변수의 개수나 타입이 다르게 선언되어야 한다.



바로 위의 예제에서도 생성자함수

**Circle::Circle(){} 이라는 생성자 함수가 자동으로 생성됐었다.**



## 3.5 소멸자

- 객체가 소멸하는 시점에서 자동으로 생성되는 함수
- 동적할당 받은 메모리를 돌려주거나, 네트워크 해제등의 마무리를 위함
- 소멸자의 이름은 클래스 이름앞에 ~
- return 타입x
- 소멸자는 단 "한 개" 만 존재해야 하며 매개 변수를 갖지 않음
- 소멸자가 선언되지 않아있으면 default 소멸자가 자동 생성

생성자 소멸자 의 예시

``` c++
#include <iostream>
using namespace std;

class Circle {
public:
    int radius;
    float getArea();
    Circle();
    Circle(int r);
    ~Circle();
};

float Circle::getArea() {
    return 3.14 * radius * radius;
}

Circle::Circle() { // 생성자 매개변수 x
    radius = 1;
    cout << radius << "생성" << endl;
}

Circle::Circle(int r) { // 생성자 매개변수 o
    radius = r;
    cout << radius << "생성" << endl;
}

Circle::~Circle() {
    cout << radius << "소멸" << endl;
}

int main() {
    Circle donut; // 매개 변수 없는 생성자 호출
    cout << donut.getArea() << endl;

    Circle pizza(10); // 매개 변수 있는 생성자 호출 10이 r에 전달 됨
    cout << pizza.getArea() << endl;
}
>>>
1생성
3.14
10생성
314
10소멸  // 생성된 순서의 반대로 소멸된다
1소멸
```



## 3.6 접근 지정



- 접근 지정자
  - public : 외부로부터 접근을 허용
  - private : 외부로부터 접근을 차단
  - protected : 외부로부터 접근 차단, 자식 클래스 접근 허용 (상속)
- class의 default는 private
- struct의 default는 public 
- 멤버 변수는 외부에서 접근 못하게 private으로 설정하고 생성자에서 값을 전달하자
- 생성자는 public으로 선언하지 않으면 오류 발생



## 3.7 인라인 함수

 인라인 함수(inline)란? 짧은 코드로 구성된 함수에 대해 함수, 호출 오버헤드로 인한 프로그램 실행 속도

저하를 막기위해 C++에 도입된 방법이다.

- 장점 : 프로그램의 실행 속도를 향상 시킬수 있다.
- 단점 : 호출하는 곳이 여러 군데 있으면 그 만큼 함수 전체의 크기가 증가한다
- 인라인 함수는 강제 명령이 아니기 때문에 불필요한 경우 "무시" 될 수 있다.
- 클래스의 선언부에 구현된 멤버 함수들에 대해선 자동으로 인라인 처리가 된다

예시

```c++
#include <iostream>
using namespace std;

inline int odd(int x){
    return (x%2);
}

int main(){
    int sum = 0;
    for (int i=1;i<=10000;i++){
        if (odd(i))
            sum+=i;
    }
    cout << sum;
}
```

위 함수는

``` c++
#include <iostream>
using namespace std;

int main(){
    int sum = 0;
    for (int i=1;i<=10000;i++){
        if (i%2) // 함수를 그대로 삽입함
            sum+=i;
    }
    cout<<sum;
}
```

와 동일 하다



## 3.8 바람직한 C++ 프로그램 작성법

헤더 파일와 cpp파일을 분리하라!

- 클래스마다 선언부는 헤더 파일에, 구현부는 cpp 파일에 분리하여 작성한다

- main() 등 함수나 전역변수는 한개 이상의 cpp파일에 나누어 작성한다

- 헤더 파일을 중복 include할 때 생기는 문제점은

  - 조건 컴파일문으로 감싼다

  - ``` c++
    #ifndef Hello
    #define Hello
    ..
    ..
    #endif
    ```





## 148p 9.Sol

Box.h // 헤더 파일

```c++
#ifndef BOX_H
#define BOX_H
class Box {
private:
	int width, height;
	char fill;
public:
	Box(int w, int h) {
		setSize(w, h);
        fill = '*';
	}
	void setFill(char f) {
		fill = f;
	}
	void setSize(int w, int h)
	{
		width = w;
		height = h;
	}
	void draw();
};
#endif
```

Box.cpp // cpp 파일

``` C++
#include "Box.h"
#include <iostream>
using namespace std;
void Box::draw() {
	for (int n = 0; n < height; n++) {
		for (int m = 0; m < width; m++)
            cout << fill;
		cout << endl;
	}
}
```

main.cpp // cpp파일

``` c++
#include <iostream>
using namespace std;
#include "Box.h"
int main() {
	Box b(10, 2);
	b.draw();
	cout << endl;
	b.setSize(7, 4);
	b.setFill('^');
	b.draw();
}
```





## 149p 10.Sol

Ram.h // 헤더 파일

``` c++
#ifndef RAM_H
#define RAM_H
class Ram {
private:
	char mem[100 * 1024];
	int size;
public:
	Ram();
	~Ram();
	char read(int address);
	void write(int address, char value);
};
#endif
```

Ram.cpp // cpp 파일

``` c++
#include <iostream>
using namespace std;
#include "Ram.h"
Ram::Ram() {
	mem[100 * 1024] = { 0 };
	size = 100 * 1024;
}
Ram::~Ram() {
	cout << "메모리 제거됨" << endl;
}
char Ram::read(int address) {
	return mem[address];
}
void Ram::write(int address, char value) {
	mem[address] = value;
}
```

main.cpp // cpp 파일

``` c++
#include<iostream>
#include "Ram.h"
using namespace std;

int main() {
	Ram ram;
	ram.write(100, 20);
	ram.write(101, 30);
	char res = ram.read(100) + ram.read(101);
	ram.write(102, res);
	cout << "102 번지의 값 = " << (int)ram.read(102) << endl;
}
```

