# CH.5 함수와 참조, 복사 생성자

---



## 5.1 함수의 인자 전달 방식 리뷰

C/C++언어를 포함하여 프로그램의 인자 전달 방식은

- 값에 의한 호출 (call by value)

  ``` c++
  void swap(int a,int b)
  {
      int tmp;
      tmp=a;
      a=b;
      b=tmp;
  }
  
  int main()
  {
      int m=2,n=9;
      swap(m,n);
      cout << m<<','<<n<<endl;
  }
  >>> 2 9 // 값이 변하지 않음
  ```
  
  - 실인자의 값을 손상시킬 수 없다
  
- 주소에 의한 호출 (call by address)

  ``` c++
  #include <iostream>
  using namespace std;
  
  void swap(int *a,int *b)
  {
      int tmp;
      tmp=a;
      a=b;
      b=tmp;
  }
  
  int main()
  {
      int m=2,n=9;
      swap(&m,&n); // 주소값을 넘김
      cout << m<<','<<n<<endl;
  }
  >>> 9 2 // 값이 바뀜
  ```

  - 실인자의 주소를 넘겨줘 의도적으로 값을 변경할 때



## 5.2 함수 호출시 객체 전달

 값에 의한 호출로 객체를 생성시에 **생성자는 실행되지 않고 소멸자만 실행** 되는 문제가 발생 할 수 있다.

``` c++
#include <iostream>
using namespace std;

class Circle {
private:
    int radius;
public:
    Circle();
    Circle(int r);
    ~Circle();
    double getArea() { return 3.14 * radius * radius; }
    int getRadius() { return radius; }
    void setRadius(int radius) { this->radius = radius; }
};

Circle::Circle() {
    radius = 1;
    cout << "생성자" << radius << endl;
}
Circle::Circle(int radius) {
    this->radius = radius;
    cout << "생성자" << radius << endl;
}
Circle::~Circle() {
    cout << "소멸자" << radius << endl;
}
void increase(Circle c) { // 객체 c생성자 생성 x
    int r = c.getRadius();
    c.setRadius(r + 1);
} // 객체 c소멸자 실행 

int main() {
    Circle waffle(30);
    increase(waffle);
    cout << waffle.getRadius() << endl;
}
>>>
생성자30
소멸자31 // 생성자 실행 x
30
소멸자30
```





##### 왜 생성자가 실행되지 않도록 컴파일 되는가?????

=> 만약 increase 함수의 매개 변수에 waffle이 전달되고 생성자가 실행되면 객체 c의 값이 반지름 1로 초기화되어 , **전달 받은 원본의 상태**를 잃어 버리게 된다. // 하지만 소멸자는 실행돼서 c가 사라진다. 

이 문제의 해결은 **복사 생성자** 5.5에서 다룬다.





 주소에 의한 호출로 함수를 작성하면!?

``` c++
#include <iostream>
using namespace std;

class Circle {
private:
    int radius;
public:
    Circle();
    Circle(int r);
    ~Circle();
    double getArea() { return 3.14 * radius * radius; }
    int getRadius() { return radius; }
    void setRadius(int radius) { this->radius = radius; }
};

Circle::Circle() {
    radius = 1;
    cout << "생성자" << radius << endl;
}
Circle::Circle(int radius) {
    this->radius = radius;
    cout << "생성자" << radius << endl;
}
Circle::~Circle() {
    cout << "소멸자" << radius << endl;
}
void increase(Circle *c) { 
    int r = c->getRadius();
    c->setRadius(r + 1);
} 

int main() {
    Circle waffle(30);
    increase(&waffle); 
    cout << waffle.getRadius() << endl;
}
>>>
생성자30
31
소멸자31
```



## 5.3 객체 지환 및 객체 리턴



### 객체 치환

``` c++
Circle c1(5);
Circle c2(30);
c1 = c2; // c1의 반지름이 30이 된다. 같은 클래스 타입에서만 가능
```



### 객체 리턴

``` C++
#include <iostream>
using namespace std;

class Circle{
private:
    int radius;
public:
    Circle(){radius=1;}
    Circle(int radius){this->radius = radius;}
    void setRadius(int radius){this->radius = radius;}
    double getArea(){return 3.14*radius*radius;}
};

Circle getCircle(){
    Circle tmp(30);
    return tmp; // 객체 리턴
} 

int main(){
    Circle c; 
    cout<< c.getArea()<<endl;
    
    c=getCircle(); // tmp객체가 c에 복사되고 c의 radius는 30이 된다.
    cout<<c.getArea()<<endl;
}
```



## 5.4 참조와 함수

### 참조 변수&(reference variable) : 선언된 변수에 대한 별명



참조 변수를 선언하는 법

``` c++
int n=2;
int &refn = n; //변수 n을 refn이라고도 부르겠다!!

Circle circle;
Cricle &refn = circle; // 객체 circle을 refn이라고도 부르겠다!!
```



참조 변수 사용

- ``` c++
  refn = 3; 
  n = 5; // n=5, refn=5
  refn++; // n=6, refn=6 
  ```

  - 값이 같이 변한다.

- ``` c++
  refc->setRadius(30);
  ```

  - 포인터가 아니라 이런 식으로 선언할 수 없다.

- ``` c++
  int *p = &refn;
  *p = 20;  ==>> n,refn,*p 세 값 모두 20
  ```

  - 참조 변수에 대한 포인터를 만들 수 있다.

- ``` c++
  int n=2;
  int &refn;
  ```

  - 초기화가 없으면 오류 발생

- ```C++
  int &n[10];
  ```

  - 참조 변수의 배열을 만들 수 없다.

- ```c++
  int &r = refn;
  ```

  - 참조 변수에 대한 참조 선언이 가능하다.

### 참조에 의한 호출, call by reference

``` c++
#include <iostream>
using namespace std;

void swap(int &a,int &b)
{
    int tmp;
    tmp=a;
    a=b;
    b=tmp;
}

int main()
{
    int m=2,n=9;
    swap(m,n);
    cout << m<<','<<n<<endl;
}
```

=>실인자와 공간을 공유하여 값을 공유한다.



참조에 의한 호출의 장점.

- 참조 매개 변수로 이루어진 모든 연산은 원본 객체에 대한 연산이 된다.
- 참조 매개 변수는 이름만 생성되므로 , 생성자와 소멸자는 아예 실행되지 않는다.
- 작성하기 쉽고 가독성이 높아진다.



Circle을 사용한 예제

``` c++
#include <iostream>
using namespace std;

class Circle{
private:
    int radius;
public:
    Circle();
    Circle(int r);
    ~Circle();
    double getArea(){return 3.14*radius*radius;}
    int getRadius(){return radius;}
    void setRadius(int radius){this->radius=radius;}
};

Circle::Circle(){
    radius=1;
    cout<<"생성자 실행 radius = "<<radius<<endl;
}

Circle::Circle(int radius){
    this->radius=radius;
    cout<<"생성자 실행 radius = "<<radius<<endl;
}

Circle::~Circle(){
    cout<<"소멸자 실행 radius = "<<radius<<endl;
}
void increase(Circle &c){ // 참조 매게 변수!
    int r = c.getRadius();
    c.setRadius(r+1);
}

int main(){
    Circle waffle(30);
    increase(waffle);
    cout<<waffle.getRadius()<<endl;
}
>>>
생성자 실행 radius = 30
31
소멸자 실행 radius = 31
```



### 참조 리턴

c++ 언어에선 함수가 참조를 리턴할 수 있다.!!



``` c++
#include<iostream>
using namespace std;

char &find(char s[],int index){
    return s[index]; // 참조 리턴
}

int main(){
    char name[]="Mike";
    cout << name << endl;
    
    find(name,0) = 'S';
    cout<<name<<endl;
    
    char &ref = find(name,2);
    ref = 't';
    cout<< name<<endl;
}
>>>
Mike
Sike
Site
```





## 5.5 복사 생성자

### 얕은 복사란?

=>  참조만 복사한다  //  복사값 안에 포인터 변수가 존재시 에러가 발생함!!

``` c++
int main()
{
    int *a = new int(3);
    int *b = new int(5);
    a=b;
    delete a; // 첫번째 문제 a가 두 번 delete
    delete b; // 두번째 문제 b는 delete되지 않음
}  => runtime error 발생
```



### 깊은 복사란?

=> 값을 복사한다

``` c++
int main()
{
    int *a = new int(3);
    int *b = new int(5);
    *a=*b;
    delete a;
    delete b;
} // 정상 실행
```



### 복사 생성자란?

``` c++
class Circle{
    Circle(Cirlce &c);
};

Circle src(30);
Circle dset(src);
```

- 복사 생성자의 매개 변수는 하나(자기 클래스에 대한 참조)
- 클래스 내에서 한 개만 선언
- default 복사 생성자는 얉은 복사의 오류가 생김



```c++
#include <iostream>
#include <cstring>
using namespace std;

class Person {
    char* name;
    int id;
public:
    Person(const int id, const char* name) {
        this->id = id;
        int len = strlen(name);
        this->name = new char[len + 1];
        strcpy(this->name, name);
    }
    Person(Person& person) {
        this->id = person.id;
        int len = strlen(person.name);
        this->name = new char[len + 1];
        strcpy(this->name, person.name);
        cout << "복사 생성자 실행" << endl;
    };
    ~Person() { delete[] name; }
    void changeName(const char* name) {
        if (strlen(name) > strlen(this->name))
            return;
        strcpy(this->name, name);
    }
    void show() { cout << id << ',' << name << endl; }
};

int main() {
    Person father(1, "Kitae");
    Person daughter(father);

    cout << "daughter 객체 생성 직후" << endl;
    father.show();
    daughter.show();

    daughter.changeName("Grace");
    cout << "daughter 이름 Grace변경 직후" << endl;
    father.show();
    daughter.show();
}
>>>
복사 생성자 실행
daughter 객체 생성 직후
1,Kitae
1,Kitae
daughter 이름 Grace변경 직후
1,Kitae
1,Grace
```





### 묵시적 복사 생성자

개발자도 모르게 복사 생성자가 생성되는 경우!!

- 객체로 초기화하여 객체가 생성될 때

  - ``` c++
    Person son = father;
    Person son(father);
    // son = father과 다른 것이다.!!!
    ```

- '값에 의한 호출'로 객체가 전달될 때

  - ``` c++
    void f(Person person){
        ...
    }
    Person father(1,"Kitae");
    f(father);
    ```

- 함수가 객체를 리턴할 때

  - ``` c++
    Person g(){
        Person mother(2,"Jane");
        return mother; // 복사본을 생성하여 리턴, 복사 생성자 호출
    }
    g();
    ```








##### 268p 5.8 Sol

``` c++
#include <iostream>
#include <string>
using namespace std;

class Book {
private:
	string title;
	int price;
public:
	Book(string title, int price) 
	{
		this->price = price;
		this->title = title;
	};
	void set(const char* title, int price) 
	{
		this->price = price;
		this->title = title;
	};
	void show() { cout << title << ',' << price << "원" << endl; }
};

int main() {
	Book cpp("명품 C++", 10000);
	Book java = cpp;
	java.set("명품자바", 12000);
	cpp.show();
	java.show();
}
```

