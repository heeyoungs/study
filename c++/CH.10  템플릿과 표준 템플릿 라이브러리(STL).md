# CH.10 템플릿과 표준 템플릿 라이브러리 (STL)

---



## 10.1 일반화와 템플릿

함수 중복의 약점

```c++
#include <iostream>
using namespace std;

void myswap(int &a, int &b) {
	int tmp;
	tmp = a;
	a = b;
	b = tmp;
}

void myswap(double& a, double& b) {
	double tmp;
	tmp = a;
	a = b;
	b = tmp;
}

int main() {
	int x = 3;
	int y = 5;
	myswap(x, y);
	cout << x << ',' << y << endl;

	
	double z = 0.3;
	double k = 0.5;
	myswap(z, k);
	cout << z << ',' << k << endl;
}
```

이렇게 매개 변수만 다른 함수들이 생길수가 있다.



##### => 템플릿 : 중복 함수들을 일반화 시킨 특별한 함수

위의 두개의 myswap 함수를 묶으면

``` c++
#include <iostream>
using namespace std;

template<class T>
void myswap(T &a, T &b) {
	T tmp;
	tmp = a;
	a = b;
	b = tmp;
}

int main() {
	int x = 3;
	int y = 5;
	myswap(x, y);
	cout << x << ',' << y << endl;

	
	double z = 0.3;
	double k = 0.5;
	myswap(z, k);
	cout << z << ',' << k << endl;
}
```



템플릿의 주의 사항 및 장단점

- 함수를 구체화시키는 과정에서의 매개변수의 타입이 동일해야 함
- 장점
  - 소프트웨어의 생산성 , 유연성 증가
- 단점
  - 포팅에 취약
  - 오류 메세지가 빈야해 디버깅이 어려움



## 10.2 다양한 제네릭 함수 만들기

템플릿 예시 (배열을 복사)

``` c++
#include <iostream>
using namespace std;

template <class T1,class T2>
void mcopy(T1 src[], T2 dest[], int n) {
	for (int i = 0; i < n; i++)
		dest[i] = (T2)src[i];
}

int main() {
	int x[] = { 1,2,3,4,5 };
	double d[5];
	char c[5] = { 'H','e','l','l',',o' },e[5];

	mcopy(x, d, 5);
	mcopy(c, e, 5);

	for (int i = 0; i < 5; i++) cout << d[i] << ' ';
	cout << endl;
	for (int i = 0; i < 5; i++)cout << e[i] << ' ';
	cout << endl;
}
```



템플릿 함수의 특징

- 중복 함수가 우선
- 디폴트 매게 변수 사용 가능!



## 10.3 제네릭 클래스 만들기

스택 예시

``` c++
#include <iostream>
using namespace std;
//제네릭 클래스 선언부
template<class T>
class MyStack {
	int tos;
	T data[100];
public:
	MyStack();
	void push(T element);
	T pop();
};
//제네릭 클래스 구현부
template<class T>
MyStack<T>::MyStack() {
	tos = -1;
}

template<class T>
void MyStack<T>::push(T element) {
	if (tos == 99){
		cout << "stack full";
		return;
	}
	tos++;
	data[tos] = element;
}

template<class T>
T MyStack<T>::pop() {
	T retData;
	if (tos == -1) {
		cout << "stack empty";
		return 0;
	}
	retData = data[tos--];
	return retData;
}

int main() {
	MyStack<int> iStack; // int 타입을 다루는 스택 객체 생성
	iStack.push(3);
	cout << iStack.pop() << endl;
 
	MyStack<double> dStack; // double 타입을 다루는 스택 객체 생성
	dStack.push(3.5);
	cout << dStack.pop() << endl;

	MyStack<char>* p = new MyStack<char>(); // char형 타입을 다루는 스택 객체 포인터 생성
	p->push('a');
	cout << p->pop() << endl;
	delete p;
}
```



## 10.4 C++ 표준 템플릿 라이브러리(STL)와 활용

##### STL이란?

- 템플릿으로 작성된 많은 제네릭 클래스와 함수 라이브러리

- STL에 포함된 제네릭 클래스와 함수들은 다음과 같이 "3종류"로 분리 됨 

  - 컨테이너(container) - 템플릿 클래스

    - 데이터를 저장하고 검색하기 위해 담아두는 자료 구조를 구현한 클래스

    - | 컨테이너 클래스 | 설명                                               | 헤더 파일 |
      | --------------- | -------------------------------------------------- | --------- |
      | vector          | 가변 크기의 배열을 일반화한 클래스                 | <vector>  |
      | deque           | 앞뒤 모두 입력 가능한 큐 클래스                    | <deque>   |
      | list            | 빠른 삽입/삭제 가능한 리스트 클래스                | <list>    |
      | set             | 정렬된 순서로 값을 저장하는 집합 클래스, 값은 유일 | <set>     |
      | map             | (key,value) 쌍으로 저장하는 맵 클래스              | <map>     |
      | stack           | 스택을 일반화한 클래스                             | <stack>   |
      | queue           | 큐를 일반화한 클래스                               | <queue>   |

  - 이터레이터(iterator) - 컨테이너 원소에 대한 포인터

    - 반복자/ 컨테이너 원소들을 하나씩 순회 접근하기 위해 만들어진 "컨테이너 원소에 대한 포인터"

    - | iterator의 종류        | iterator에 ++연산 후 방향 | read/write |
      | ---------------------- | ------------------------- | ---------- |
      | iterator               | 다음 원소로 전진          | read/write |
      | const_iterator         | 다음 원소로 전진          | read       |
      | reverse_iterator       | 지난 원소로 후진          | read/write |
      | const_reverse_iterator | 지난 원소로 후진          | read       |

  - 알고리즘(algorithm) - 템플릿 함수

    - 컨테이너의 원소에 대한 여러가지 기능을 구현한 템플릿 함수 

    - 컨테이너 클래스의 멤버 함수가 아니다

    - | copy  | merge     | random  | rotate |
      | ----- | --------- | ------- | ------ |
      | equal | min       | remove  | rotate |
      | find  | move      | replace | search |
      | max   | partition | reverse | swap   |



##### 컨테이너 

컨테이너의 활용(벡터)

| 멤버와 연산자 함수           | 설명                                                         |
| ---------------------------- | ------------------------------------------------------------ |
| push_back(element)           | 벡터의 마지막에 element 추가                                 |
| at(int index)                | index 위치의 원소에 대한 참조 리턴                           |
| begin()                      | 벡터의 첫 번째 원소에 대한 참조 리턴                         |
| end()                        | 벡터의 끝(마지막 원소 다음)을 가리키는 참조 리턴             |
| empty()                      | 벡터가 비어 있으면 true리턴                                  |
| erase(iterator it)           | 벡터에서 it가 가르키는 원소 삭제. 삭제 후 자동으로 벡터 조절 |
| insert(iterator it, element) | 벡터 내 it위치에 element 삽입                                |
| size()                       | 벡터에 들어 있는 원소의 개수 리턴                            |
| operator[]()                 | 지정된 원소에 대한 참조 리턴                                 |
| operator=()                  | 이 벡터를 다른 벡터에 치환(복사)                             |

코드 예시

``` c++
#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main() {
	vector<string> sv;
	string name;

	cout << "이름을 5개 입력하라" << endl;
	for (int i = 0; i < 5; i++) {
		cout << i + 1 << ">>";
		getline(cin, name);
		sv.push_back(name); // 이름을 벡터에 삽입
	}
	name = sv.at(0); // at 벡터의 첫번째 이름 추출
	for (int i = 1; i < sv.size(); i++) { // size = 벡터의 크기를 추출
		if (name < sv[i])
			name = sv[i];
	}
	cout << "사전에서 가장 뒤에 나오는 이름은 " << name << endl;
}
```



##### 이터레이터

``` c++
vector<int>::iterator it; // vector<int>의 이터레이터 변수 it 생성

vector<int> v;
it = v.begin(); // v의 첫 번째 원소에 대한 주소를 it에 저장

it++; // 벡터의 다음 원소를 가리킴

int n = *it;
*it = 5; // it이 가리키는 원소에 5를 쓴다.

it = v.end(); // 마지막 원소 "다음 위치"에 대한 포인터를 it에 저장한다

it = v.erase(it); // it이 가리키는 원소를 삭제한 후 다음 원소에 대한 포인터를 리턴

for(it = v.begin();it != v.end(); it++){ // 벡터의 모든 원소를 출력하는 함수 "잘 기억해두기"
    int n = *it;
    cout << n << endl;
}
```

코드 예시

```c++
#include <iostream>
#include <vector>
using namespace std;

int main() {
	vector <int> v;
	v.push_back(1);
	v.push_back(2);
	v.push_back(3);

	vector<int>::iterator it;

	for (it = v.begin(); it != v.end(); it++) {
		int n = *it;
		n = n * 2;
		*it = n;
	}
	for (it = v.begin(); it != v.end(); it++) {
		cout << *it << ' ';
	}
	cout << endl;
}
```



##### STL알고리즘

sort 함수 예시

```c++
#include <iostream>
#include <vector>
#include <algorithm> // 알고리즘 함수, **이터레이터**와 함께 작동

using namespace std;

int main() {
	vector<int> v;
	cout << "5개의 정수를 입력하세요>> ";
	for (int i = 0; i < 5; i++) {
		int n;
		cin >> n;
		v.push_back(n);
	}

	sort(v.begin(), v.end()); // sort()!!

	vector<int>::iterator it;

	for (it = v.begin(); it != v.end(); it++) {
		cout << *it << ' ';
	}
	cout << endl;
}
```



##### 506p 10-12Sol

```c++
#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>
#include <vector>
using namespace std;

class Word {
	string en;
	string ko;
public:
	Word() { en = ""; ko = ""; }
	Word(string en, string ko) {
		this->en = en; this->ko = ko;
	}
	void setEnKo(string en, string ko) { this->en = en; this->ko = ko; }
	string getEn() { return en; }
	string getKo() { return ko; }
};

int main() {

	vector<Word> v;
	Word w;
	v.push_back(Word("human", "인간"));
	v.push_back(Word("society", "사회"));
	v.push_back(Word("dall", "인형"));
	v.push_back(Word("emotion", "감정"));
	v.push_back(Word("painting", "그림"));
	v.push_back(Word("trade", "거래"));
	v.push_back(Word("animal", "동물"));
	v.push_back(Word("photo", "사진"));
	v.push_back(Word("bear", "곰"));

	srand((unsigned)time(0));
	int n1; string answer;
	string bogi[4]; for (int i = 0; i < 4; i++) bogi[i] = "";
	int number[4]; for (int i = 0; i < 4; i++) number[i] = 0;
	int i;
	bool exit = true, exit2 = true;
	int sel;
	string e, k;

	cout << "***** 영어 어휘 테스트를 시작합니다. *****" << endl;

	while (exit2) {
		exit = true;
		cout << "어휘 삽입: 1, 어휘 테스트 : 2, 프로그램 종료:그외키 >> ";
		cin >> sel;
		switch (sel) {
		case 1:
			cout << "영어 단어에 exit을 입력하면 입력 끝" << endl;
			//fflush(stdin);
			while (getchar() != '\n');
			while (1) {
				cout << "영어 >>";  getline(cin, e);
				if (e == "exit") break;
				cout << "한글 >>";  getline(cin, k);
				w.setEnKo(e, k);
				v.push_back(w);
			}
			break;
		case 2:
			cout << "영어 어휘 테스트를 시작합니다. 1~4 외 다른 입력시 종료합니다." << endl;
			while (exit) {
				n1 = rand() % v.size();
				bogi[0] = v.at(n1).getKo();
				answer = bogi[0];
				cout << v.at(n1).getEn() << "?" << endl;

				while (exit) {				// 중복되지 않는 보기 만들기
					for (i = 1; i < 4; i++) {
						n1 = rand() % v.size();
						bogi[i] = v.at(n1).getKo();
					}
					if (bogi[0] != bogi[1] && bogi[0] != bogi[2] && bogi[0] != bogi[3] &&
						bogi[1] != bogi[2] && bogi[1] != bogi[3] && bogi[2] != bogi[3])
						exit = false;
				}
				exit = true;

				number[0] = rand() % 4;
				while (exit) {					//보기 순서 섞기
					for (i = 1; i < 4; i++) {
						number[i] = rand() % 4;
					}
					if (number[0] != number[1] && number[0] != number[2] && number[0] != number[3] &&
						number[1] != number[2] && number[1] != number[3] && number[2] != number[3])
						exit = false;
				}
				exit = true;
				int result;

				for (i = 1; i < 5; i++)
					cout << "(" << i << ") " << bogi[number[i - 1]] << " ";
				cout << ":>";
				cin >> result;

				if (result != 1 && result != 2 && result != 3 && result != 4)	//순서 중요 먼저 1, 2, 3, 4 이외의 값인지 확인해야함
					exit = false;
				else if (answer == bogi[number[result - 1]])
					cout << "Excellent !!" << endl;
				else if (result == 1 || result == 2 || result == 3 || result == 4)
					cout << "No. !!" << endl;
			}
			break;
		default:
			exit2 = false;
			break;
		}
		cout << endl;
	}
}
```





##### 507p 10-13Sol

``` c++
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Circle {
	string name;
	int radius;
public:
	Circle(int radius, string name) {
		this->radius = radius;
		this->name = name;
	}
	double getArea() { return 3.14 * radius * radius; }
	string getName() { return name; }
};

int main() {
	int n;
	int radius;
	string name;
	vector<Circle*> v;
	vector<Circle*>::iterator it;

	while (1) {
		cout << "원을 삽입하고 삭제하는 프로그램입니다." << endl;
		cout << "삽입:1, 삭제:2, 모두보기:3, 종료:4 >> ";
		cin >> n;
		fflush(stdin);
		while (getchar() != '\n');
		switch (n) {
		case 1:
			cout << "생성하고자 하는 원의 반지름과 이름은 >> ";
			cin >> radius;
			cin >> name;
			v.push_back(new Circle(radius,name));
			break;
		case 2:
			cout <<  "삭제하고자 하는 원의 이름은 >> ";
			cin >> name;
			for (it = v.begin(); it != v.end(); it++) {
				Circle* c = *it;
				if (c->getName()==name) {
					it = v.erase(it);
					delete c;
					break;
				}
			}
			break;
		case 3:
			for (it = v.begin(); it != v.end(); it++) {
				Circle* c = *it;
				cout << c->getName() << endl;
			}
			break;
		case 4:
			return 0;
		}
	}
}
```

