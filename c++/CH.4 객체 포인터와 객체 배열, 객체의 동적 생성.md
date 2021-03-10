# CH.4 객체 포인터와 객체 배열, 객체의 동적 생성

---



## 4.1 객체 포인터

``` c++
Circle donut;
double d = donut.getArea();

Circle *p; // 객체에 대한 포인터 선언
p=&donut; // 포인터에 객체의 주소를 저장
d = p->getArea(); // 멤버 함수의 호출
```



객체 포인터로 멤버를 접근할 때는

- d = p->getArea();
- d = (*p).getArea(); 

두 가지 방법이 있다.



## 4.2 객체 배열

예시)

``` c++
#include<iostream>
using namespace std;

class Circle{
private:
    int radius;
public:
    Circle(){radius = 1;}
    Circle(int r){radius = r;}
    void setRadius(int r){radius = r;}
    double getArea(){
        return 3.14*radius*radius;
    }
};

int main(){
    Circle circleArray[3]; // 객체의 배열 선언!!
    
    
    circleArray[0].setRadius(10); // 각 배열의 원소에 접근해서 초기화
    circleArray[1].setRadius(20);
    circleArray[2].setRadius(30);
    
    for (int i=0;i<3;i++) // 배열로 객체의 맴버에 접근
        cout << "Circle "<< i << "의 면적은 "<<circleArray[i].getArea()<<endl;
    
    Circle *p;
    p = circleArray;
    for(int i=0;i<3;i++){ // 포인터로 객체 배열에 접근
        cout << "Circle"<<i<<"의 면적은 "<<p->getArea()<<endl;
        p++;
    }

}
```

- 객체 배열 선언문은 **반드시 기본 생성자를 호출한다** 

  - 매개 변수를 가진 객체 배열 생성시 기본 생성자를 생성해 놓지 않으면 에러가 발생!!

- 함수가 종료되면 함수 내의 원소 객체마다 소멸자가 호출! => 높은 인덱스 순으로 소멸!!

- 객체 배열은 생성자를 사용해서 초기화 할 수 있다

  - ``` c++
    Circle circleArray[3] = {Circle(10),Circle(20),Circle()};
    ```

- 다차원 배열도 c언어 처럼 사용 할 수 있다.



## 4.3 동적 메모리 할당 및 반환

동적 메모리란? 프로그램 실행 중에 필요한 만큼 메모리를 할당 받고 필요 없을 때 반환하는 것



- c++언어에선 이런 식이다.

``` c++
int *p = new int; // 공간 할당 (heap)이라는 시스템 공간에서 빌려옴
char *t = new char;
double *q = new double[10]; // 배열의 동적 할당
circle *k = new circle; // 클래스의 동적 할당

delete p; // 반납
delete t;
delete[] q; // 배열을 반납할 때는 delete앞에 []를 붙여야 한다.
delete k;
```

- 만약 heap의 공간이 부족하면 new 는 null을 리턴함

``` c++
int *p = new int;
if(p==0){ 
    cout<< "메모리 할당 실패";
    return 0;
}
```

- 초기값 설정

``` c++
int *p = new int(20);
char *t = new char('a'); // 방법 1

int *p = new int;
*p = 20;
char *t = new char;
*t = 'a'; // 방법 2

배열을 초기화 할 때
int *p =  new int [10](10); // 처럼 초기화 불가능
```

- delete 사용의 오류

  - 동적 할당 받지 않은 값을 delete 하려 할 때

    - ``` c++
      int n;
      int *p = &n;
      delete p;
      ```

  - 이미 delete한 메모리를 다시 delete하려 할 때

    - ``` c++
      int *p =new int;
      delete p;
      delete p;
      ```

동적 할당의 예시

``` c++
#include <iostream>
using namespace std;

int main(){
    cout<<"입력할 정수의 개수는?";
    int n;
    cin >> n;
    
    if(n<=0)return 0;
    int *p = new int [n];
    if(!p){
        cout << "메모리 할당 실패.";
        return 0;
    } // 메모리 할당 실패시!
    
    for (int i=0;i<n;i++){
        cout<<i+1<<"번째 정수: ";
        cin>>p[i];
    } // 동적 할당 받은 메모리에 정수 입력
    
    double sum = 0;
    for(int i=0;i<n;i++)
        sum+=p[i];
    cout<<"평균 = "<<sum/n<<endl;
    delete[] p; // 메모리 반납
}
```



## 4.4 객체와 객체 배열의 동적 생성 및 반환

객체 배열을 동적으로 생성하는 구문은 

``` c++
클래스이름 *포인터변수 = new 클래스이름[배열크기];
delete[] 포인터변수;
```

위에서 한 내용이고

이를 이용해서 예시를 만들면

4장 실습문제 9번sol,

``` c++
#include<iostream>
#include<string>
#include <cstring>
using namespace std;

class Circle {
private:
	int radius;
	string name;
public:
	void setCircle(string name, int radius)
	{
		this->name = name;
		this->radius = radius;
	};
	double getArea()
	{
		return 3.14 * radius * radius;
	};
	string getName()
	{
		return name;
	};
};
class CircleManager {
private:
	Circle* p;
	int size;
public:
	CircleManager(int size) 
	{
		int si;
		string name;
		this->size = size;
		p = new Circle[size];
		for (int i = 0; i < size; i++) {
			cout << "원 " << i + 1 << "의 이름과 반지름 >> ";
			getline(cin, name, ' ');
			cin >> si;
			p[i].setCircle(name, si);
		}
	};
	~CircleManager() { delete[] p; };
	void searchByName() {
		string name;
		cout << "검색하고자 하는 원의 이름 >> ";
		cin >> name;
		for (int i = 0; i < size; i++) 
		{
			if ( p[i].getName() == name )
			{
				cout <<"면적은 : "<< p[i].getArea() << endl;
			}
		}
	};
	void searchByArea() {
		int si;
		cout << "최소 면적을 정수로 입력하세요 >> ";
		cin >> si;
		cout << si << "보다 큰 원을 검색합니다.";
		for (int i = 0; i < size; i++)
		{
			if (size < p[i].getArea())
			{
				cout << p[i].getName() << "의 면적은 " << p[i].getArea() << ",";
			}
		}
	};
};

int main()
{
	int num;
	cout << "원의 개수 >> ";
	cin >> num;
	CircleManager *one = new CircleManager(num);
	one->searchByName();
	one->searchByArea();
	delete one;
}
```



## 4.5 this 포인터

this 포인터란? 객체 자신에 대한 포인터로서 클래스의 멤버 함수 내에서만 사용되는 포인터이다.

this포인터는 객체 멤버함수가 호출될 때 컴파일러에 의해 보이지않게 호출된다.

``` c++
class Circle{
    int radius;
public:
    Circle(){this->radius=1;}
    Circle(int radius){this->radius=radius;}
    void setRadius(int radius) {this->radius=radius;}
    ...
}
```

###  this가 필요한 경우

- 첫째, 멤버 변수의 이름과 동일한 이름으로 매개 변수 이름을 짓고자 하는 경우

  - ``` c++
    Circle(int radius){
        this->radius = radius;
    }
    ```

- 둘째, 객체의 멤버 함수에서 객체 자신의 주소를 리턴할 때

  - ``` c++
    class Sample{
    public:
        Sample* f(){
            ...
            return this; // 현재의 주소값 리턴
        }
    };
    ```



### this의 제약조건

- 첫째, 클래스의 멤버 함수에서만 사용할 수 있다.
- 둘째, 정적 멤버 함수(static member function)은 this를 사용할 수 없다





## 4.5 string 클래스를 이용한 문자열 사용

### string 객체 또한 동적 생성이 가능하다

- ``` c++
  string *p = new string("C++"); // 동적 생성
  cout<<*p; // C++
  p->append("Great!!"); // 문자열 추가
  cout<<*p; // C++ Great!!
  delete p; // 반환
  ```



### 문자열을 다루는 연산자와 함수들

- 문자열 치환 a=b
- 문자열 비교 compare()
- 문자열 연결 append() // 문자열이 들어간다
- 문자열 삽입 insert()  //  인덱스값과 문자열이 들어간다
- 문자열 대체 replace() // 인덱스값과 그 뒤 몇개의 문자열을 대체할지의 값 문자열이 들어간다
- 문자열 길이 length() 
- 문자열 삭제 erase() // 인덱스값과 그 뒤 몇 개의 문자를 삭제할지 값이 들어간다
- 문자열 초기화 clear()
- 문자열에서 일부분 발췌 substr() // 인덱스값과 그 뒤 몇 개의 문자를 얻을지 값이 들어간다
- 문자열 검색 find() // 문자열이 들어가고 인덱스 값을 반환한다, 없을시 -1 을 반환한다
- 문자 얻기 at() // 인덱스가 들어간다

### 문자열 바꾸기

- stoi((string))숫자) 는 문자열 숫자를 숫자로 바꿔준다
- toupper() 은 소문자를 대문자로
- tolower() 은 대문자를 소문자로 // 둘다 비파괴적이라 값 자체엔 영향 x
- isdigit() 숫자인가?
- isalpha() 문자인가?



## 211p 4.11 Sol

``` c++
#include <iostream>
#include <string>
#include <ctime>
#include <cstdlib>
using namespace std;

class Player {
	string name[2];
	int i;
public:
	Player() { i = 0; }
	void setName(string namae) { name[i] = namae; i++; }
	string getName() {
		i++;
		if (i >= 2) {
			i = 0;
			return name[i];
		}
		else
			return name[i];
	}
};

class GamblingGame {
	int num[3];
public:
	GamblingGame() { srand((unsigned)time(0)); }
	void Game();
};
void GamblingGame::Game() {
	cout << "***** 갬블링 게임을 시작합니다. *****" << endl;
	Player p; string name;
	cout << "첫번째 선수 이름>>";
	getline(cin, name);
	p.setName(name);
	cout << "두번째 선수 이름>>";
	getline(cin, name);
	p.setName(name);

	string named;
	while (1) {
		named = p.getName();
		cout << named << ":<Enter>";
		getline(cin, name);
		for (int i = 0; i < 3; i++)
			num[i] = rand() % 3;
		cout << "\t\t" << num[0] << "\t" << num[1] << "\t" << num[2] << "\t";
		if (num[0] == num[1] && num[1] == num[2]) {
			cout << named << "님 승리!!" << endl;
			break;
		}
		else
			cout << "아쉽군요!" << endl;
	}
}

int main() {
	GamblingGame g;
	g.Game();
}
```

