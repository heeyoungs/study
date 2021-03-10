# CH.7 프렌즈와 연산자 중복

---



## 7.1 C++ 프렌즈의 개념



| 항목 | 세상의 친구                                                 | 프렌드 함수                                                  |
| ---- | ----------------------------------------------------------- | ------------------------------------------------------------ |
| 존재 | 가족이 아님, 외부인                                         | 클래스 외부겡 작성된 함수, 멤버가 아님                       |
| 자격 | 가족의 구성원으로 인정받음. 가족의 모든 살림살이에 접근허용 | 클래스의 멤버 자격 부여. 클래스의 모든 멤버에 대해 접근 가능 |
| 선언 | 친구라고 소개                                               | 클래스 내에 friend키워드로 선언                              |
| 개수 | 친구의 명수에 제한 없음                                     | 프렌드 함수 개수에 제한이 없음                               |





### 프렌즈 함수는 왜 필요할까?

프로그램을 작성하다보면 클래스의 멤버함수로는 적합하지 않지만, 클래스의 멤버에 접근해야 하는 경우가 있다.!!!



### 프렌즈 함수를 선언하는 경우

- 클래스 외부에 작성된 함수를 프렌드로 선언

  - ``` c++
    #include <iostream>
    using namespace std;
    
    class Rect;
    bool equals(Rect r, Rect s);
    
    class Rect{
        int width,height;
    public:
        Rect(int width,int height){this->width = width; this->height = height;}
        friend bool equals (Rect r,Rect s); // equal함수를 프렌드로 선언
    };
    
    bool equals(Rect r,Rect s){ // equal함수는 private속성을 가진 매개변수에 접근할수 있다!!!!
        if(r.width == s.width && r.height == s.height)
            return true;
        else return false;
    }
    
    int main(){
        Rect a(3,4), b(4,5);
        if(equals(a,b)) cout<<"equal"<<endl;
        else cout << "not equal"<< endl;
    }
    ```

    

- 다른 클래스의 멤버 함수를 프렌드로 선언

  - ```c++
    #include <iostream>
    using namespace std;
    
    class Rect;
    
    class RectManager {
    public:
        bool equals(Rect r, Rect s);
    };
    
    class Rect {
        int width, height;
    public:
        Rect(int width, int height) { this->width = width; this->height = height; }
        friend bool RectManager::equals(Rect r, Rect s); // RectManager클래스의 equals함수를 프렌드로 선언
    };
    
    bool RectManager::equals(Rect r, Rect s) { 
        if (r.width == s.width && r.height == s.height)
            return true;
        else return false;
    }
    
    int main() {
        Rect a(3, 4), b(3, 4);
        RectManager Man;
    
        if (Man.equals(a, b)) cout << "equal" << endl;
        else cout << "not equal" << endl;
    }
    ```

  

- 다른 클래스의 모든 멤버 함수를 프렌드로 선언

  - ```c++
    #include <iostream>
    using namespace std;
    
    class Rect;
    
    class RectManager {
    public:
        bool equals(Rect r, Rect s);
        void copy(Rect& dest, Rect& src);
    };
    
    class Rect {
        int width, height;
    public:
        Rect(int width, int height) { this->width = width; this->height = height; }
        friend RectManager; // RectManager 클래스를 프렌드로 선언
    };
    
    bool RectManager::equals(Rect r, Rect s) { 
        if (r.width == s.width && r.height == s.height)
            return true;
        else return false;
    }
    
    void RectManager::copy(Rect& dest, Rect& src) {
        dest.width = src.width;
        dest.height = src.height;
    }
    
    int main() {
        Rect a(3, 4), b(3, 4);
        RectManager Man;
    
        Man.copy(a, b);
        if (Man.equals(a, b)) cout << "equal" << endl;
        else cout << "not equal" << endl;
    }
    ```

    



## 7.2 연산자 중복



### 연산자 중복이란?

함수에서 같은 이름의 함수를 여러개 만드는 것이 함수의 중복이라면, 

피연산자에 따라 서로 다른 연산을 하도록 동일한 연산자를 중복하여 작성하는 것이 **연산자 중복**이다.



### 연산자 중복의 특징!

- c++ 언어에 본래 있는 연산자만 중복 가능하다.
- 연산자 중복은 피연산자의 타입이 다른 연산을 새로 정의하는 것이다.
- 연산자 중복은 함수를 통해 이루어진다.
- 연산자 중복은 반드시 클래스와 관계를 가진다.
- 연산자 중복으로 피연산자의 개수를 바꿀 수 없다.
- 연산자 중복으로 연산의 우선순위를 바꿀수없다.
- 모든 연산자가 중복이 가능한 것은 아니다.



## 7.3 이항 연산자 중복

피연산자가 2개인 연산자



- c = a + b

``` c++
Power operator+(Power op2)
{
    Power tmp;
    tmp.kick = this->kick+op2.kick;
    tmp.punch = this->punch+op2.punch;
    return tmp;
}  // this는 a op2는 b 두개를 더해서 tmp에 담아 리턴한 값이c이다.
```



- a == b

``` c++
bool operator==(Power op2){
    if(this->kick==op2.kick && this->punch==op2.punch)
        return true;
    eles return false;
}
```



- a+=b

``` c++
Power operator+=(Power op2){
    kick = kick + op2.kick; // a에 b를 더함
    punch = punch + op2.punch; 
    return *this; // 갱신된 a값을 리턴함
}
```





## 7.4 단항 연산자 중복

피연산자가 하나인 연산자



- 전위++ 

``` c++
Power operator++(){
    kick++;
    punch++;
    return *this;
}
```



- !

``` c++
bool operator!(){
    if(kick==0 && punch==0)
        return true;
    else return false;
}
```



- 후위++

``` c++
Power operator++(int x){
    Power tmp = *this; // 증가이전의 객체 저장
    kick++;
    punch++;
    return tmp; // 현재 객체의 값들을 증가 시켜놓고 증가이전의 값 리턴
}
```





## 7.5 프렌드를 이용한 연산자 중복

2 + a 와 같이 2가 객체가 아닌경우 프렌드 함수를 선언해 외부함수로 구현할 수 밖에 없다!!



#### 변수 + 객체 연산자를 프렌드 함수로 구현

``` c++
Class Power{
    ...
public:
    friend Power operator+(int op1,Power op2);
}

Power operator+(int op1,Power op2){
    Power tmp;
    tmp.kick = op1 + op2.kick;
    tmp.punch = op1 + op2.punch;
    return tmp;
}
```





#### 이항 연산자를 프렌드 함수로 구현

``` c++
Power operator+(Power op1,Power op2)
{
    Power tmp;
    tmp.kick = op1.kick+op2.kick;
    tmp.punch = op1.punch+op2.punch;
    return tmp;
}
```





#### 단항 연산자를 프렌드 함수로 구현

- 전위 ++

``` c++
Power operator++(Power& op){
    op.kick++;
    op.punch++;
    return op;
}
```

- 후위 ++

``` c++
Power operator++(Power& op,int x){
    Power tmp = op;
    op.kick++;
    op.punch++;
    return tmp;
}
```









##### 360p 7.8Sol

``` c++
#include <iostream>
using namespace std;

class Circle {
	int radius;
public:
	Circle(int radius = 0) {this->radius = radius;	}
	void show() { cout << "radius = " << radius << " 인 원" << endl; }
	friend Circle operator+(int x, Circle rhs);
};

Circle operator+(int x, Circle rhs) {
	Circle tmp;
	tmp.radius = x + rhs.radius;
	return tmp;
}

int main() {
	Circle a(5), b(4);
	b = 1 + a;
	a.show();
	b.show();
}
```





##### 360p 7.9Sol

``` c++
#include <iostream>
using namespace std;

class Statics {
private:
	int *p;
	int count;
public:
	Statics() { p = new int[7]; count = 0; }
	~Statics() { delete[] p; }
	bool operator!() 
	{
		if (*p == NULL)
			return true;
		else false;
	}
	Statics& operator<<(int rhs)
	{

		p[count] = rhs;
		count++;
		return *this;
	} 
	void operator~() {
		for (int j = 0; j < 7; j++)
		{
			cout << p[j] << ' ';
		}
		cout << endl;
	} 
	void operator>>(int &rhs)
	{
		int avg = 0;
		for (int i = 0; i < 7; i++)
		{
			avg = avg+p[i];
		}
		rhs = avg / 7;
	} 
};


int main() {
	Statics stat;
	if (!stat) cout << "현재 통계 데이터가 없습니다." << endl;

	int x[5];
	cout << "5 개의 정수를 입력하라>>";
	for (int i = 0; i < 5; i++) cin >> x[i];

	for (int i = 0; i < 5; i++) stat << x[i];
	stat << 100 << 200;
	~stat;

	int avg;
	stat >> avg;
	cout << "avg=" << avg << endl;
}
```



##### 361p 7.10Sol

``` c++
#include <iostream>
using namespace std;

class Stack {
private:
	int p[10];
	int count;
public:
	Stack() {	count = -1;	}
	Stack& operator<<(int rhs) {
		count++;
		p[count] = rhs;
		return *this;
	}
	bool operator!() {
		if (count == -1)
			return true;
		else return false;
	}
	Stack operator>>(int &rhs) {
		rhs = p[count];
		count--;
		return *this;
	}
};

int main() {
	Stack stack;
	stack << 3 << 5 << 10;
	while (true) {
		if (!stack) break;
		int x;
		stack >> x;
		cout << x << ' ';
	}
	cout << endl;
}
```

