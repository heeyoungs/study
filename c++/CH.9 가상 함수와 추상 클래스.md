# CH.9 가상 함수와 추상 클래스

---



## 9.1 상속 관계에서의 함수 중복

``` c++
#include <iostream>
using namespace std;

class Base{
public:
    void f(){cout<<"Base::f() called"<<endl;}
};

class Derived : public Base{
public:
    void f(){cout<<"Derived::f() called"<<endl;}
};

void main(){
    Derived d,*pDer;
    pDer = &d;
    pDer->f(); // Derived f() 호출
    
    Base* pBase;
    pBase = pDer; // 업 캐스팅!!
    pBase->f(); // 정적 바인딩 Base f() 호출
}

->
    Derived::f() called
    Base::f() called
```

### 정적 바인딩이란?

- 기본 클래스에 대한 포인터는 기본 클래스의 함수를 호출

- 파생 클래스에 대한 포인터는 파생 클래스의 함수를 호출 
- 이러한 관계는 컴파일시에 결정 ==> 정적 바인딩
- 범위 지정 연산자 :: 를 사용하면 다른 멤버에 접근 가능!



## 9.2 가상 함수와 오버라이딩

""overriding  : 우선하다""  // 함수의 다형성!!



가상함수란 virtaul 키워드로 선언된 멤버 함수이고

```c++
class Base{
public:
    virtual void f(); => 로 선언한다
} // 여기서 기본 클래스의 가상함수와 완전히 동일한 원형의 함수를 재정의 하는 것이 "오버 라이딩"
```

가상 함수를 위의 예제에 사용하면

``` c++
#include <iostream>
using namespace std;

class Base{
public:
    virtual void f(){cout<<"Base::f() called"<<endl;}
};

class Derived : public Base{
public:
    virtual void f(){cout<<"Derived::f() called"<<endl;}
};

void main(){
    Derived d,*pDer;
    pDer = &d;
    pDer->f(); // Derived f() 호출
    
    Base* pBase;
    pBase = pDer; // 업 캐스팅!!
    pBase->f(); // 동적 바인딩 Derived f() 호출
}

->
    Derived::f() called
    Derived::f() called // 결과값이 바뀜
```

### 오버 라이딩의 목적

- 하나의 인터페이스에 대해 서로 다른 모양의 구현!! (다형성)

``` c++
class Shape{
protected:
    virtual void draw(){}
};

class Cicle : public Shape{
protected:
    virtual void draw(){} //원
};
class Rect : public Shape{
protected:
    virtual void draw(){} //사각형
};
class Line : public Shape{
protected:
    virtual void draw(){} //  선
};

void paint(shape *p){
    p->draw();
}

paint(new Cirlce()); //원
paint(new Rect()); //사각형
paint(new Line()); //선
```



### 동적바인딩이란? 

- 오버라이딩된 함수가 무조건 호출
  - 객체 내에 오버라이딩 된 가상 함수를 동적으로 찾아 호출한다.
- 동적 바인딩이 발생하는 경우
  - 파생 클래스의 객체에 대해, 기본 클래스의 포인터로 가상 함수가 호출될 때 일어난다.



### 오버라이딩의 특징

- 오버라이딩은 이름과 매개변수 타입, 개수, 리턴타입이 같아야 일어난다
- virtual속성은 상속이 돼서 파생 클래스에서는 virtual을 생략해도 된다.
- 가상 함수의 접근 지정자도 자유롭게 정할 수 있다.

``` c++
#include <iostream>
using namespace std;

class Base{
public:
    virtual void f(){cout<<"Base::f() called"<<endl;}
};

class Derived : public Base{
public:
    void f(){cout<<"Derived::f() called"<<endl;}
};

class GrandDerived : public Derived{
public:
    void f(){cout<<"GrandDerived::f() called"<<endl;}
};

int main(){
    GrandDerived g;
    Base *bp;
    Derived *dp;
    GrandDerived *gp;
    
    bp = dp = gp = &g;
    
    bp->f();
    dp->f();
    gp->f();
}

->
    GrandDerived::f() called
    GrandDerived::f() called
    GrandDerived::f() called // 동적 바인딩에 의해 모두 GrandDerived 호출
```



### 소멸자는 가상 함수로 선언하자!!

=> 업캐스팅 동적할당 했을 때 ( Base *p= new Derived(); ) delete시 파생 클래스의 소멸자가 생성되지 않을 수도 있음.



### 오버로딩과 오버라이딩의 비교

| 비교요소            | 오버로딩                                                     | 오버라이딩                                                   |
| ------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 정의                | 매개 변수 타입이나 개수가 다르지만, 이름이 같은 함수들이 중복 작성되는 것 | 기본 클래스에 선언된 가상 함수를 파생 클래스에서 이름, 매개 변수 타입, 매개 변수 개수. 리턴 타입까지 완변한 원형으로 재작성하는 것 |
| 존재                | 외부 함수들 사이, 함 클래스의 멤버들 상속 관계               | 상속 관계, 가상 함수에서만 적용                              |
| 목적                | 이름이 같은 여러 개의 함수를 중복 장성하여 사용의 편의성 향상 | 기본 클래스에 구현된 가상 함수를 무시하고,파생 클래스에서 새로운 기능으로 재정의하고자 함 |
| 바인딩              | 정적 바인딩. 컴파일 시에 중복된 함수들의 호출 구분           | 동적 바인딩. 실행 시간에 오버라이딩된 함수를 찾아 실행       |
| 관련 객체 지향 특성 | 다형성                                                       | 다형성                                                       |



## 9.3 가상 함수와 오버라이딩의 활용 사례

``` c++
#include <iostream>
using namespace std;

int main(){
    Shape *pStart=NULL;
    Shape *pLast;
    
    pStart = new Circle();
    pLast = *pLast;
    
    pLast = pLast->add(new Rect());
    pLast = pLast->add(new Circle());
    pLast = pLast->add(new Line());
    pLast = pLast->add(new Rect());
    
    Shape*p =pStart;
    while(p!=NULL){
        p->paint();
        p=p->getNext();
    } // 단일 연결 리스트
    
    p=pStart;
    while(p!=NULL){
        Shape*q=p->getNext();
        delete p;
        p=q;
    } // 동적 할당 해제
}

->
    Circle
    Rectangle
    Circle
    Line
    Rectangle   
```



## 9.4 추상 클래스

``` c++
class Shape{ // 추상 클래스 (순수 가상 함수를 하나라도 가지면!)
public:
    virtual void draw()=0; // 순수 가상 함수
}
```

### 추상 클래스의 특징

- 추상 클래스는 실행 코드가 없는 순수 가상 함수를 가지고 있기 때문에 "불완전한 클래스"이다.

- 추상 클래스의 객체는 생성할수 없다!
- 상속을 위한 기본 클래스로 사용하기 위한 목적
- 추상 클래스를 이용하여 응용 프로그램의 설계와 구현을 분리하기 쉬워진다.(계층적 상속 관계)

- 추상 클래스를 상속받는 파생 클래스는 자동으로 추상 클래스가 된다.

  - ``` c++
    class Shape{
    public:
        void paint(){
            draw();
        }
        virtual void draw()=0;
    };
    
    class Circle : public Shape{
    public:
        string toString(){return "Circle 객체";}
    };
    
    int main(){
        Circle circle; // 오류!! 추상 클래스의 객체를 생성 불가
        Circle *p = new Circle(); // 동일 오류!!
    }
    ```

### 추상 클래스의 구현

파생 클래스가 온전한 클래스가 되려면 상속받은 클래스의 "모든 순수 함수를 오버라이딩 하여 구현"해야한다.

예시!!

``` c++
class Shape{ // 추상 클래스
public:
    void paint(){
        draw();
    }
    virtual void draw()=0; // 순수 가상 함수
};

class Circle : public Shape{
public:
    virtual void draw(){cout<<"Circle";} //  순수 가상 함수 구현부
    string toString(){return "Circle 객체";}
}
```







##### 456p Sol9.6

``` c++
#include <iostream>
using namespace std;

class AbstractStack {
public:
	virtual bool push(int n) = 0; 
	virtual bool pop(int& n) = 0; 
	virtual int size() = 0;
};

class IntStack :public AbstractStack {
	int* stack;
	int top;
	int max;
public:
	IntStack(int n) { stack = new int[n]; max = n; top = -1; }
	bool push(int n) {
		if (top == max)return false;
		else {
			top++;
			stack[top] = n;
			return true;
		}
	};
	bool pop(int& n) {
		if (top < 0)return false;
		else {
			n = stack[top];
			top--;
			return true;
		}
	};
	int size() { return top + 1; };
};

int main() {
	IntStack intstack(50);
	int re;
	intstack.push(10);
	intstack.push(20);
	intstack.push(30);
	intstack.push(40);
	cout << "현재 원소 개수 : " << intstack.size() << "개" << endl;
	intstack.pop(re);
	cout << "pop : " << re << endl;
	intstack.pop(re);
	cout << "pop : " << re << endl;
	intstack.pop(re);
	cout << "pop : " << re << endl;
	cout << "현재 원소 개수 : " << intstack.size() << "개" << endl;
}
```





##### 457p Sol9.8

```c++
#include <iostream>
#include <string>
using namespace std;

class Shape { 
protected:
	string name;
	int width, height;
public:
	Shape(string n = "", int w = 0, int h = 0) { name = n; width = w; height = h; }
	virtual double getArea() = 0; 
	string getName() { return name; }
};

class Oval :public Shape {
public:
	Oval(string name, int width, int height) :Shape(name, width, height) {};
	double getArea() { return width * height * 3.14; }; 
};

class Rect :public Shape {
public:
	Rect(string name, int width, int height) :Shape(name, width, height) {};
	double getArea() { return width * height; };
};

class Triangular :public Shape {
public:
	Triangular(string name, int width, int height) :Shape(name, width, height) {};
	double getArea() { return width * height / 2; };
};

int main() {
	Shape* p[3];
	p[0] = new Oval("빈대떡", 10, 20);
	p[1] = new Rect("찰떡", 30, 40);
	p[2] = new Triangular("토스트", 30, 40);
	for (int i = 0; i < 3; i++)
		cout << p[i]->getName() << " 넓이는 " << p[i]->getArea() << endl;

	for (int i = 0; i < 3; i++)delete p[i];
}
```

