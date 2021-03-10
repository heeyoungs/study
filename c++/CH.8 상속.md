# CH.8 상속

---



## 8.1 상속의 개념

상속의 장점!

- 간결한 클래스 작성
- 클래스 간의 계층적 분류및 관리의 용이함
- 클래스 재사용과 확장을 통한 소프트웨어의 생산성 향상



## 8.2 클래스 상속과 객체

상속 선언

``` c++
class Student : public Person{
    ...
}

class StudentWorker : public Student{
    ...
}
```

=> 상속의 횟수에는 제한이 없다.!



상속예시 

``` c++
#include <iostream>
#include <string>
using namespace std;

class Point{ // 기본 클래스
    int x,y;
public:
    void set(int x,int y){this->x=x;this->y=y;}
    void showPoint(){
        cout<<"("<<x<<","<<y<<")"<<endl;
    }
};

class ColorPoint : public Point{ // 파생 클래스
    string color;
public:
    void setColor(string color){this->color=color;}
    void showColorPoint(){
        cout<<color<<":";
        showPoint(); // 파생클래스의 멤버는 기본클래스의 멤버에 접근할 수 있다.
    };
};

int main(){
    Point p;
    ColorPoint cp;
    //p.showColorPoint() => 기본클래스로 만들어진 객체는 파생클래스 멤버에 접근 불가능
    cp.set(3,4);
    cp.setColor("Red");
    cp.showColorPoint();
}
```



## 8.3 상속과 객체 포인터

- 업 캐스팅 : 기본 클래스의 포인터로 파생 클래스의 객체를 가르키는 것!!

  ``` c++
  // *기본 = &파생
  ColorPoint cp;
  ColorPoint *pDer = &cp;
  Point* pBase = pDer; // 업 캐스팅
  
  //pBase는 Point 클래스의 멤버에만 접근 가능!!
  ```

- 다운 캐스팅 : 파생클래스의 포인터로 기본 클래스의 포인터가 가리키는 객체를 가르키는 것

  ``` c++
  // *파생 = (파생*)&기본
  ColorPoint cp;
  ColorPoint *pDer;
  Point *pBase = &cp;
  
  pDer=(ColorPoint *)pBase; // 다운 캐스팅 (강제 타입 변환이 필요)
  
  //pDer은 Point 클래스, ColorPoint 클래스 멤버에 모두 접근 가능!!
  ```

- 잘못된 다운 캐스팅 사례

  ``` c++
  ColorPoint *pDer;
  Point *pBase, po;
  pBase = &po;
  pDer = (ColorPoint*)pBase;
  
  pDer->set(3,4); // 정상 실행
  pDer->setColor("Red"); // setColor는 ColorPoint의 멤버라 오류가 발생은 안한다.
  // 하지만 없는 함수를 호출해 실행 오류가 발생 => 실행시 비정상 종료
  ```

  

## 8.4 protected 접근 지정

접근 지정자

- public : 외부로부터 접근을 허용
- private : 외부로부터 접근을 차단
- protected : 외부로부터 접근 차단, 파생 클래스 접근 허용 (상속)



## 8.5 상속과 생성자, 소멸자

 특징

- 파생 클래스의 객체가 생성되면 파생클래스의 생성자와 기본 클래스의 생성자 모두 실행된다.

- 파생 클래스의 생성자보다 기본 클래스의 생성자가 먼저 생성된다.

  - ```c++
    class A{
    public:
        A(){cout<<"생성자 A"<<endl;}
        ~A(){cout<<"소멸자 A"<<endl;}
    };
    
    class B:public A{
    public:
        B(){cout<<"생성자 B"<<endl;}
        ~B(){cout<<"소멸자 B"<<endl;}
    };
    
    class C:public B{
    public:
        C(){cout<<"생성자 C"<<endl;}
        ~C(){cout<<"소멸자 C"<<endl;}
    };
    
    int main(){
        C c;
    }
    
    //실행결과
    생성자 A
    생성자 B
    생성자 C
    소멸자 C
    소멸자 B
    소멸자 A
    ```

- 소멸자는 실행순서와 반대로 실행된다.

- 파생 클래스의 생성자는 생성자와 함께 실행할 기본 클래스의 생성자를 지정해야 한다.

  - 명시적으로 지정하지 않으면 기본 생성자가 실행됨.

- 생성자를 명시적으로 선택하는 방법

  - ``` c++
    B(int x):A(x+3){
        cout<<"매개변수 생성자 B"<<x<<endl;
    }
     //묵시적 삽입
    B()/*:A()*/{
        cout<<"생성자 B"<<endl;
    }
    ```

예제

```C++
#include <iostream>
#include <string>
using namespace std;

class TV {
	int size;
public:
	TV() { size = 20; }
	TV(int size) { this->size = size; }
	int getSize() { return size; }
};

class WideTV :public TV { // TV 를 상속받음
	bool videoIn;
public:
	WideTV(int size, bool videoIn) :TV(size) {
		this->videoIn = videoIn;
	}
	bool getVideoIn() { return videoIn; }
};

class SmartTV :public WideTV { // WideTV를 상속받음
	string ipAddr;
public:
	SmartTV(string ipAddr, int size) :WideTV(size, true) {
		this->ipAddr = ipAddr;
	}
	string getIpAddr() { return ipAddr; }
};

int main() {
	SmartTV htv("192.0.0.1", 32); //SmartTV 객체 하나 생성=> TV WideTV SmartTV 생성자 생성
	cout << "size=" << htv.getSize() << endl; //TV의 멤버 함수에 접근
	cout << "videoIn=" << boolalpha << htv.getVideoIn() << endl; // WideTV의 멤버 함수에 접근
	cout << "IP=" << htv.getIpAddr() << endl; // SmartTv의 멤버 함수에 접근
}
```



## 8.6 상속의 종류 : public,protected,private 상속

- public 상속 : 기본 클래스의 private,protected, public 모두 그대로
- protected 상속 : private,protected는 그대로, public은 protected 로 변경
- private 상속 : private은 그대로, protected,public이 private으로 변경

``` c++
#include <iostream>
using namespace std;

class Base {
	int a;
protected:
	void setA(int a) { this->a = a; }
public:
	void showA() { cout << a; }
};

class Derived :private Base {
	int b;
protected:
	void setB(int b) { this->b = b; }
public:
	void showB() {
		setA(5); // 성공 => setA(int a)가 Base의 protected 멤버
		showA(); // 성공 => showA()가 Base의 public 멤버
		cout << b;
	}
};

class GrandDerived :private Derived {
	int c;
protected:
	void setAB(int x) {
		setA(x);  // 오류 => Derived가 Base를 private으로 받아서 setA가 private
		showA();  // 오류 => Derived가 Base를 private으로 받아서 setA가 private
		setB(x);
	}
};
```



## 8.7 다중 상속

하나의 클래스가 여러 클래스를 동시에 상속 받는 것!

예시

``` c++
class MP3{
public:
    void play();
    void stop();
};

class MobilePhone{
public:
    bool sendCall();
    bool receiveCall();
    bool sendSMS();
    bool receiveSMS();
};

class MusicPhone:public MP3,public MobilePhone{ // 다중 상속
public:
    void dial(){
        play(); // MP3 멤버
        sendCall(); // MobilePhone 멤버
    }
}

int main(){
    MusicPhone hanPhone;
    hanPhone.play(); // MP3 멤버 호출
    hanPhone.sendSMS(); // MobilePhone 멤버 호출
}
```





## 8.8 가상 상속

=> 다중 상속의 치명적인 문제점!! 

``` c++
class Base{
public:
    int mode;
};

class In : public Base{
public:
    int readPos;
};

class Out : public Base{
public:
    int writePos;
};

class InOut : public In, public Out{
public:
    bool safe;
};

int main(){
    InOut a; // 생성자가 Base->In->Base->Out->InOut 이 생성
    
    a.readPos = 10;// ok
    a.writePos = 20;// ok
    a.safe = true;// ok
    a.mode = 5; // 어느 Base생성자의 mode인지 모름 => 오류 발생
}
```



해결 방법 : 파생 클래스를 선언할 때 기본 클래스 앞에 virtual 키워드를 사용하면 된다.

```c++
class Base{
public:
    int mode;
};

class In : virtual public Base{
public:
    int readPos;
};

class Out : virtual public Base{
public:
    int writePos;
};

class InOut : public In, public Out{
public:
    bool safe;
};

int main(){
    InOut a; // 생성자가 Base->In->Out->InOut 이 생성
    
    a.readPos = 10;// ok
    a.writePos = 20;// ok
    a.safe = true;// ok
    a.mode = 5; // ok
}
// virtual은 객체가 생성될 때 기본 클래스의 멤버 공간을 오직 한번만 할당하고 이미 할당되어 있다면 그 공간을 "공유"한다. => 모호성 해결!!
```



##### 410p 8.7Sol

```c++
#include <iostream>
using namespace std;

class BaseMemory {
	char* mem;
protected:
	BaseMemory(int size) { mem = new char[size]; }
	~BaseMemory() { delete[]mem; }
	void setData(int index, char data) { mem[index] = data; }
	char getData(int index) { return mem[index]; }
};

class ROM :public BaseMemory {
private:
	int length;
public:
	ROM(int size,char memory[],int len) : BaseMemory(size){
		length = len;
		for (int i = 0; i < len; i++)
			setData(i, memory[i]);
	}
	char read(int index) { return getData(index); }
};

class RAM :public BaseMemory {
public:
	RAM(int size):BaseMemory(size){}
	void write(int index, int data) { setData(index, data); }
	char read(int index) { return getData(index); }
};

int main() {
	char x[5] = { 'h','e','l','l','o' };
	ROM biosROM(1024 * 10, x, 5);
	RAM mainMemory(1024 * 1024);

	for (int i = 0; i < 5; i++)mainMemory.write(i, biosROM.read(i));
	for (int i = 0; i < 5; i++)cout << mainMemory.read(i);
}
```

