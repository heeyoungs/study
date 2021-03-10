# CH.6 함수 중복과 static 멤버

---



## 6.1 함수 중복

c++에선 같은 이름의 함수를 여러 개 많들 수 있다.

### 중복 함수의 조건!

- 중복된 함수들의 이름이 동일하여야 한다.
- 중복된 함수들은 매개변수 타입이나 매개 변수의 개수가 달라야 한다.
- 함수 중복에 리턴 타입은 고려되지 않는다.

성공 예시

``` c++
int sum(int a,int b,int c)
{
    return a+b+c;
}
double sum(double a,double b)
{
    return a+b;
}
int sum(int a,int b)
{
    return a+b;
}
```

실패 예시

``` c++
int sum(int a,int b)
{
    return a+b;
}
double sum(int a,int b) // 매개 변수의 개수나 타입이 같다.
{
    return (double)a+b;  // 리턴 타입은 고려되지 않는다.
}
```



=> 우리는 이미 생성자 함수를 **중복**하여 작성하고 있다.!!

=> 소멸자는 중복이 당연히 불가능하다.



함수 중복의 예시!!

```c++
#include <iostream>
using namespace std;

int sum(int a,int b){
    int s = 0;
    for(int i=a;i<=b;i++ )
        s+=i;
    return s;
}

int sum(int a){
    int s=0;
    for(int i=0;i<=a;i++)
        s+=i;
    return s;
}

int main(){
    cout<<sum(3,5)<<endl;
    cout<<sum(3)<<endl;
    cout<<sum(100)<<endl;
}
>>>
    12
    6
    5050
```



## 6.2 디폴트 매개 변수



디폴트 매개 변수는  '매개 변수 = 디폴트 값'의 형태로 선언된다.

```c++
void msg(int id,string text = "Hello"); // Hello가 text의 디폴트 값
```



디폴트 매개 변수는 끝 쪽에 몰려 선언되어야 한다.

```c++
void calc (int a,int b=5,int c, int d=0); // 오류
void calc (int a,int b=5,int c=7, int d=0); // 정상 실행
```



디폴트 매개 변수는 생성자 함수에도 사용가능 하다.

```c++
Circle(int a,int b=7,int c=100){};
```



디폴트 매게 변수를 이용하여 중복 함수를 간소화 할 수있다.

``` c++
#include <iostream>
using namespace std;

void fillLine(int n=25,char c='*'){
    for(int i=0;i<n;i++)
        cout<<c;
    cout<<endl;
}

int main(){
    fillLine();
    fillLine(10,'%');
}
```



## 6.3 함수 중복의 모호성



### 함수 중복의 모호성 3가지

- 형 변환으로 인한 모호성

  - 컴파일러의 자동 형 변환 // char > int > long > float > double

  - ``` c++
    double square(double a);
    square(3); // 성공
    
    int square(int 7);
    square(3.7); // 오류
    
    ```

- 참조 매개 변수로 인한 모호성

  - ``` c++
    int add(int a, int b);
    int add(int a, int &b);
    s(10,20); // 오류 발생 
    ```

    

- 디폴트 매개 변수로 인한 모호성

  - ``` c++
    void msg(int id);
    void msg(int id,string s="");
    msg(6); // 두 함수 중 어느 함수를 호출할지 몰라 오류 발생
    ```



## 6.4 static 멤버

 ### static 이란?

변수와 함수에 "생명 주기"와 "사용 범위"를 지정하는 방식

- 생명 주기 : 프로그램이 시작할 때 생성되고 프로그램이 종료할 때 소멸
- 사용 범위 : 변수나 함수가 선언된 범위 내에서 사용. 전역 혹은 지역으로 나뉨



static 멤버의 선언

``` c++
class Person{
public:
    double money:
    void addMoney(int money){
        this->money += money;
    }
    
    static int sharedMoney;
    static void addShared(int n){
        sharedMoney +=n;
    }
};

int Person::sharedMoney = 10;  // static 변수의 공간 할당은 전역에서!!
```





### non static 멤버와 static 멤버의 비교

|    항목     | non-static 멤버                                              | static 멤버                                                  |
| :---------: | :----------------------------------------------------------- | :----------------------------------------------------------- |
|  선언 사례  | class Sample{<br/>    int n;<br/>    void f();<br/>};        | class Sample{<br/>    static int n;<br/>    static void f();<br/>}; |
|  공간 특성  | 멤버는 객체마다 별도 생성                                    | 멤버는 클래스 당 하나 생성                                   |
| 시간적 특성 | 객체와 생명을 같이함<br>객체 생성 시에 멤버 생성<br>객체 소멸시 함께 소멸<br>객체 생성 후 객체 사용 가능 | 프로그램과 생명을 같이함<br>프로그램 시작시 멤버 생성<br>객체가 생기기 전에 이미 존재<br>객체가 사라져도 여전히 존재<br>프로그램에 종료될 때 함께 소멸 |
| 공유의 특성 | 공유되지 않음                                                | 동일한 클랫의 모든 객체들에게 공유됨                         |



### 사용 방법

``` c++
클래스명::static 멤버; // 범위 지정 연산자를 사용한다

ex)
Person::sharedMoney =200;
Person::sharedMoney(200);
```



### static의 활용

- 전역 변수나 전역 함수를 클래스에 캡슐화
  - c++의 특징은 캡슐화인데 전역 변수, 전역 함수를 사용하면 호환성이 안맞는다.
  - static멤버로 캡슐화를 시킬 수 있다.
- 객체 사이에 공유 변수를 만들고자 할 때
- static 멤버 함수는 static 멤버들에만 접근 가능<=> non static멤버 함수는 static멤버 접근에 제약 x

- static 멤버 함수는 this를 사용 할 수 없다
  - 객체가 생기기 전부터 호출 가능하므로 this포인터 사용을 제약한다.







##### 308p 6.7Sol

```c++
#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

class Random {
public:
	static void seed() { srand((unsigned)time(0)); }
	static int nextInt(int min = 0, int max = 32767) {
		int n = min + (rand() % (max - min + 1));
		return n;
	}
	static char nextAlphabet();
	static double nextDouble();
};
char Random::nextAlphabet() {
	int n = rand() % 2;
	if (n == 0) {
		n = 65 + rand() % 26;
		return n;
	}
	else {
		n = 97 + rand() % 26;
		return n;
	}
}
double Random::nextDouble() {
	double n = rand() / (double)(RAND_MAX + 1);

	return n;
}

int main() {
	Random::seed();
	int i;

	cout << "1에서 100까지 랜덤한 정수 10개를 출력합니다" << endl;
	for (i = 0; i < 10; i++) cout << Random::nextInt(1, 100) << ' ';

	cout << endl << "알파벳을 랜덤하게 10개를 출력합니다" << endl;
	for (i = 0; i < 10; i++) cout << Random::nextAlphabet() << ' ';

	cout << endl << "랜덤한 실수를 10개를 출력합니다" << endl;
	for (i = 0; i < 5; i++) cout << Random::nextDouble() << ' ';
	cout << endl;
	for (i = 0; i < 5; i++) cout << Random::nextDouble() << ' ';
	cout << endl;

}
```

