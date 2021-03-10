# CH.11 C++ 입출력 시스템

---



## 11.1 C++ 입출력 기초

### 스트림이란?

- 프로그램과 장치를 연결하며 바이트 단위로 입출력
- C++ 표준 입력 스트림 객체는 cin
- C++ 표준 출력 스트림 객체는 cout
- cerr, clog
  - 둘다 오류 출력 스트림 객체
  - cerr : 버퍼를 거치지 않고 스크린에 오류 메시지 출력
  - clog : 버퍼를 거치고 스크린에 오류 메시지 출력

| 클래스                            | 설명                                                         |
| --------------------------------- | ------------------------------------------------------------ |
| ios                               | 모든 입출력 스트림 클래스들의 기본 클래스, 스트림 입출력에 필요한 공통 함수와 상수, 멤버 변수 선언 |
| istream<br/>ostream<br/>iostream  | istream은 문자 단위 입력 스트림, ostream은 문자 단위 출력 스트림, iostream은 문자 단위로 입출력을 동시에  할 수 있는 스트림 클래스 |
| ifstream<br/>ofstream<br/>fstream | 파일에서 읽고 쓰는 기능을 가진 파일 입출력 스트림 클래스, 파일에서 읽을 때는 ifstream 클래스를, 파일에 쓸 때는 ofstream 클래스를, 읽고 쓰기를 동시에 할 때는 fstream 클래스를 이용 |



## 11.2 ostream의 멤버 함수를 이용한 문자 출력

---

ofstream 클래스의 주요 멤버 함수

```c++
ostream& put(char ch)
    ch의 문자를 스트림에 출력
ostream& write(char *str,int n)
    str배열에 있는 n개의 문자를 스트림에 출력
ostream& flush()
    현재 스트림 버퍼에 있는 내용 강제 출력
```



- put() : 문자 단위로 출력시킨다.

``` c++
cout.put('A');
cout.put(33); // ASCII 코드를 직접 넣을 수 잇음
cout.put('C').put('+').put('+'); // C++ 출력,연결 가능
```

- write() : char 배열에 들어있는 문자들을 출력시킨다.

``` c++
char str[] = "I love programming";
cout.write(str,6); // I love 출력
```

- flush() : 출력 버퍼에 있는 문자들을 모두 강제로 출력시킨다.

``` c++
cout.put('A');
cout.flush(); // A 출력
```



## 11.3 istream의 멤버 함수를 이용한 문자 입력

---

### 문자 읽기

``` c++
int get() 
    입력 스트림에서 문자를 읽어 리턴, 오류나 eof를 만나면 -1
istream& get(char ch)
    입력 스트림에서 문자를 읽어 ch에 저장, 오류나 eof만나면 오류 플래그
```

- int get()

  ```c++
  int ch;
  while(ch=cin.get()!=EOF){ // 문자 읽기
      cout.put(ch);
      if(ch=='\n') // enter키 입력시 읽기 종료
          break;
  }
  ```

- istream& get(char& ch)

  ```c++
  char ch;
  while(true){
      cin.get(ch); // 키를 ch에 읽어옴
      if(cin.eof())
          break; 
      cout.put(ch); // 읽은 문자 출력
      if(ch=='\n')
          break;
  }
  ```

예시)

```c++
#include <iostream>
using namespace std;

void get1() {
	cout << "cin.get()로 Enter키까지 입력받고 출력합니다>>";
	int ch;
	while ((ch = cin.get()) != EOF) {
		cout.put(ch);
		if (ch == '\n')
			break;
	}
}

void get2() {
	cout<< "cin.get(char&)로 Enter키까지 입력받고 출력합니다>>";
	char ch;
	while (true) {
		cin.get(ch);
		if (cin.eof())
			break;
		cout.put(ch);
		if (ch == '\n')
			break;
	}
}

int main() {
	get1();
	get2();
}
```



### 문자열 입력

``` c++
istream& get(char *s,int n)
    입력 스트림으로부터 n-1개의 문자를 읽어 배열 s에 저장하고 마지막에 '\0' 문자를 삽입
    입력 도중 '\n'을 만나면 '\0'을 삽입하고 리턴
```

- 입력 도중 '\n'을 만났을 때

  - '\n'이 입력 스트림 버퍼에 남아있는다.
  - 다시 읽는다.
  - '\n'부터 읽기 시작한다.
  - 무한 루프에 빠진다.

  해결 방법

  ``` c++
  cin.get();
  cin.ignore(1); // cin 버퍼에서 문자 1개 삭제
  ```

- 입력 도중 EOF나 오류가 발생할 때

  - 읽기를 중단하고 '\0'을 배열에 삽입하여 종료한다.

예시)

```c++
#include <iostream>
#include <cstring>
using namespace std;

int main() {
	char cmd[80];
	cout << "cin.get(char*,int)로 문자열을 읽습니다."<<endl;
	while (true) {
		cout << "종료 = exit>> ";
		cin.get(cmd, 80);
		if (!strcmp(cmd, "exit")) {
			break;
		}
		else
			cin.ignore(1);
	}
}
```



### 한 줄 읽기

``` c++
istream& get(char* s,int n,char delim='\n')
    입력 스트림으로부터 최대 n-1개의 문자를 읽어 배열 s에 저장하고 마지막에 '\0'문자를 삽입, 입력 도중 delim에 지정된 문자를 만나면 지금까지 읽은 문자	  를 배열 s에 저장하고 리턴
istream& getline(char *s,int n,char delim='\n')
    get()과 동일,하지만 delim에 저장된 문자를 스트림에서 제거
```

- getline()

  ``` c++
  char line[80];
  cin.getline(line,80); // '\n'을 만날 때까지 최대 79개의 문자를 읽어 line에 삽입하고
  					  // 끝에 '\0'를 추가한다. '\n'을 line에 넣지 않고
  					  // 스트림 버퍼에서 제거한다.
  ```

- get()은 getline()과 달리 스트림 버퍼에서 delim문자를 제거하지 않아 무한루프에 빠질 수 있다. 위와 동일



예시)

```c++
#include <iostream>
#include <cstring>
using namespace std;

int main() {
	char line[80];
	cout << "cin.getline() 함수로 라인을 읽습니다." << endl;
	cout << "exit을 입력하면 종료합니다," << endl;
	int no = 1;
	while (true) {
		cout << "라인" << no++ << ">> ";
		cin.getline(line, 80);
		if (!strcmp(line, "exit")) {
			break;
		}
		cout << "echo-->> ";
		cout << line << endl;
	}
}
```



### 입력 스트림의 문자 건너 띄기

``` c++
istream& ignore(int n=1,int delim=EOF)
    입력 스트림에서 n개 문자 제거, 도중에 delim문자를 만나면 delim문자를 제거하고 리턴
```

예시)

``` c++
cin.ignore(10); // 입력 스트림에서 10개의 문자 제거
cin.ignore(10,'\n') // 입력 스트림에서 10개의 문자 제거, '\n'을 만나면 '\n'까지 지우고 거기서 종료
```



### 읽은 문자 개수 알아내기

``` c++
int gcount() 
    최근에 입력 스트림에서 읽은 바이트 수 리턴. <enter>키도 개수에 포함
```

예시)

```c++
char line[80];
cin.getline(line,80); // hello<enter>
int n=cin.gcount(); // '\n'포함 6리턴

char line[80];
cin.get(line,80); // hello<enter>
int n=cin.gcount(); // '\n'을 버퍼에 남겨두고 5리턴
```



## 11.4 포맷 입출력

---

### 포맷 플래그

- 포맷 플래그는 모든 입출력 스트림에서 공통적으로 사용
- ios 클래스에 정수형 상수로 정의되어 있다.
- cin, cout은 입출력 시 포맷 변수에 세팅된 플래그 값을 반영하여 포맷 입출력을 수행한다

ios클래스에 정의된 포맷 플래그

| 플래그          | 값     | 의미                                                         |
| --------------- | ------ | ------------------------------------------------------------ |
| ios::skipws     | 0x0001 | 입력시 공백 문자(스페이스, 탭, 개형문자)를 무시              |
| ios::unitbuf    | 0x0002 | 출력 스트림에 들어오는 데이터를 버퍼링하지 않고 바로 출력    |
| ios::uppercase  | 0x0004 | 16진수의 A~F, 지수 표현의 E를 대문자로 출력                  |
| ios::showbase   | 0x0008 | 16진수이면 0x를,8진수이면 0을 숫자 앞에 붙여 출력            |
| ios::showpoint  | 0x0010 | 실수 값에 대해, 정수 부분과 더불어 소수점 이하의 끝자리들을 0으로 출력 |
| ios::showpos    | 0x0020 | 양수에 대해 + 기호로 출력                                    |
| ios::left       | 0x0040 | 필드를 왼쪽 맞춤 형식으로 출력                               |
| ios::right      | 0x0080 | 필드를 오른쪽 맞춤 형식으로 출력                             |
| ios::internal   | 0x0100 | 부호는 왼쪽 맞춤으로 숫자는 오른쪽맞춤으로 출력              |
| ios::dec        | 0x0200 | 10진수로 출력, 디폴트 설정                                   |
| ios::oct        | 0x0400 | 8진수로 출력                                                 |
| ios::hex        | 0x0800 | 16진수로 출력                                                |
| ios::scientific | 0x1000 | 실수에 대해 과학 산술용 규칙에 따라 출력                     |
| ios::fixed      | 0x2000 | 실수에 대해 소수점 형태로 출력                               |
| ios::boolalpha  | 0x4000 | 설정되면, 논리값 true를 "true"로 , false를 "false"로 출력하고 설정되지 않으면, 정수1과 0으로 출력 |

``` c++
long setf(long flags)
    flags를 스트림의 포맷 플래그로 설정하고 이전 플래그를 리턴한다.
long unsetf(long flags)
    flags에 설정된 비트 값에 따라 스트림의 포맷 플래그를 해제하고 이전 플래그를 리턴할다.
```

예시)

``` c++
#include <iostream>
using namespace std;

int main() {
    cout << 30 << endl; //30출력

    cout.unsetf(ios::dec); // 10진수 해제
    cout.setf(ios::hex); // 16진수 설정
    cout << 30 << endl; // 1e 출력

    cout.setf(ios::showbase); // 16진수에 0x접두어 붙이도록 설정 
    cout << 30 << endl; // 0x1e 출력

    cout.setf(ios::uppercase); // 16진수를 대문자로 출력
    cout << 30 << endl; // 0X1E

    cout.setf(ios::dec | ios::showpoint); //10진수 표현과 동시에 실수에 소수점이하 나머지는 0으로 출력

    cout << 23.5 << endl; // 23.5000 출력

    cout.setf(ios::scientific); // 실수를 과학산술용 표현으로 출력
    cout << 23.5 << endl; // 2.350000E+001 출력

    cout.setf(ios::showpoint); // 양수인 경우 + 부호도 함께 출력
    cout << 23.5 << endl; // +2.350000E+001 출력
}
```



### 포맷 함수 활용

#### 필드의 최소 넓이 설정 width()

``` c++
int width(int minWidth)
    출력되는 필드의 최소 너비를 minWidth로 설정하고 이전에 설정된 너비 값을 리턴
```

예시)

```c++
//- 는 빈칸을 표시함
cout.width(10);
cout << "Hello"<<endl; // -----Hello
cout.width(5);
cout<< 12 <<endl; // ---12

-- 주의 사항 --
    
cout <<"%";
cout.width(10); // 다음 출력되는 korea에만 10칸으로 지정
cout << "korea/" << "Seoul/" << "city/"<<endl; // %----korea/Seoul/city/
```



#### 필드의 빈 공간 채우기 fill()

``` c++
char fill(char cFill)
    필드의 빈칸을 cFill 문자로 채우도록 지정하고 이전 문자 값 리턴
```

예시)

```c++
cout.fill('^');
cout.width(10);
cout << "Hello" << endl; // ^^^^^Hello, 디폴트가 오른쪽 정렬이기 때문에 빈칸은 필드 왼쪽에 생긴다
```



#### 유효 숫자 자리수 지정 precision()

``` c++
int precision(int np)
    출력되는 수의 유효 숫자 자리수를 np개로 설정, 정수 부분과 소수점 이하의 수의 자리를 모두 포함하고 소수점(.)은 제외
```

예시)

``` c++
cout.precision(5);
cout << 11/3; // 3.6667
```



``` c++
#include <iostream>
using namespace std;

void showWidth() {
	cout.width(10);
	cout << "Hello" << endl;
	cout.width(5);
	cout << 12 << endl;

	cout << '%';
	cout.width(10);
	cout << "korea/" << "Seoul/" << "city/" << endl;
}

int main() {
	showWidth();
	cout << endl;

	cout.fill('^');
	showWidth();
	cout << endl;

	cout.precision(5);
	cout << 11. / 3. << endl;
}
```



### 조작자

조작자란? 

- ANSI/IOS 표준 C++헤더 파일에 정의된 특별한 원형을 가진 함수
- 매개 변수 없는 조작자와, 매개 변수를 하나 가진 조작자로 나뉜다.
- 항상 << , >> 연산자와 함께 사용된다.



#### 매개 변수 없는 조작자

``` c++
#include <isotream> // 헤더 파일을 include 해야한다.
```

``` c++
cout << hex << showbase << 30 << endl; // 0x1e
cout << dex << showpos << 100 << endl; // +100
```

=> 짧은 코드 하나에 3개의 조작자를 활용한다. // endl도 조작자의 하나이다.

매개 변수 없는 조작자

| 조작자      | I/O  | 용도                                                         |
| ----------- | ---- | ------------------------------------------------------------ |
| endl        | O    | 스트림 버퍼를 모두 출력하고 다음줄로 넘어감                  |
| oct         | O    | 정수 필드를 8진수 기반으로 출력                              |
| dec         | O    | 정수 필드를 10진수 기반으로 출력                             |
| hex         | O    | 정수 필드를 16진수 기반으로 출력                             |
| left        | O    | 왼쪽 맞춤으로 출력                                           |
| right       | O    | 오른쪽 맞춤으로 출력                                         |
| fixed       | O    | 실수 필드를 고정 소수점 방식으로 출력                        |
| scientific  | O    | 실수 필드를 과학 산술용 방식으로 출력                        |
| flush       | O    | 스트림 버퍼를 강제 출력                                      |
| showbase    | O    | 16진수의 경우0x로, 8진수의 경우로 0을 앞에 붙여서 출력       |
| noshowbase  | O    | showbase지정 취소                                            |
| showpoint   | O    | 실수 값에 대해, 정수 부분과 소수점 이하의 끝자리 이후 남은 공간을 0으로 출력 |
| noshowpoint | O    | showpoint지정 취소                                           |
| showpos     | O    | 양수인 경우 + 를 앞에 붙혀서 출력                            |
| skipws      | I    | 입력 스트림에서 공백 문자를 읽지 않고 건너 뜀                |
| noskipws    | I    | skipws지정 취소                                              |
| boolalpha   | O    | 불린 값이 출력 될 때 true는 "true", false는 "false"로 출력   |

예시)

```c++
#include <iostream>
using namespace std;

int main() {
	cout << hex << showbase << 30 << endl; // 0x1e
	cout << dec << showpos << 100 << endl; // +100
	cout << true << ' ' << false << endl; // +1 +0
	cout << boolalpha << true << ' ' << false << endl; // true false
}
```



#### 매개 변수를 가지는 조작자

``` c++
#include <iomanip> // iomanip을 include해야한다.
```

``` c++
cout << setw(10) << setfill('^') << "Hello" << endl; // ^^^^^Hello
```

매개 변수를 가지는 조작자

| 조작자                   | I/O  | 용도                                                         |
| ------------------------ | ---- | ------------------------------------------------------------ |
| resetioflags(long flags) | I/O  | flags에 지정된 플래그들 해제                                 |
| setbase(int base)        | O    | base를 출력할 수의 진수로 지정                               |
| setfill(char cFill)      | I    | 필드를 출력하고 남은 공간에 cFill 문자로 채움                |
| setioflags(long flags)   | I/O  | flags를 스트림 입출력 플래그로 지정                          |
| setprecision(int np)     | O    | 출력되는 수의 유효 숫자 자리수를 np개로 설정, 소수점. 은 별도로 카운트 |
| setw(int minWidth)       | O    | 필드의 최소 너비를 minWidth로 지정                           |

예시)

```c++
#include <iostream>
#include <iomanip>
using namespace std;

int main() {
	cout << showbase;

	cout << setw(8) << "Number";
	cout << setw(10) << "Octal";
	cout << setw(10) << "Hexa"<<endl;

	for (int i = 0; i < 50; i += 5) {
		cout << setw(8) << setfill('.') << dec << i; // 10진수
		cout << setw(10) << setfill(' ') << oct << i; // 8진수
		cout << setw(10) << setfill(' ') << hex << i << endl; // 16진수
	}
}
```



조작자의 특징

- 조작자는 사용하기 쉽고 코드를 간결하게 만들어줌
- =>> setf(),width()등의 포맷 함수보다 조작자를 사용하자
- 조작로로 설정한 포맷은 한 번의 입출력에만 적용
- =>> 입출력마다 포맷을 지정해야 함

- 대부분의 조작자는 내부에서 sef()함수를 호출한다.



## 11.5 삽입 연산자(<<)와 추출 연산자(>>)

---

#### 삽입 연산자란?

- 데이터를 출력하는 << , cout
- 삽입자라고도 부름

#### 삽입 연산자의 실행 과정

1. ```c++
   cout <<'a'<<123;
   ```

2. ``` c++
   cout . << ('a') //로 변형하여 컴파일, 먼저 a부터
   ```

3. ```c++
   ostream& operator << (char c){
       ...현재 스트림 버퍼에 c('a')를 삽입한다.
       ...버퍼가 차면 장치에 출력한다.
       return *this;
   }
   ```

4. ``` c++
   ostream& operator << (int n){
       ...현재 스트림 버퍼에 n(123)을 삽입한다.
       ...버퍼가 차면 장치에 출력한다.
       return *this;
   }
   ```

=> "<< 연산자가 cout의 참조를 리턴함으로써, 반복되는 <<연산자에 의해 출력되는 데이터들이 cout의 버퍼를 통하여 화면에 출력된다!!!"

#### 사용자 삽입 연산자 << 만들기

사용자 삽입 연산자 함수의 원형

```c++
ostream& operator << (ostream& outs, UserClass obj);
ostream& operator << (ostream& outs, UserClass& obj);
```

만약

```c++
class Point{
    int x,y;
public:
    Point(int x=0,int y=0){this->x=x;this->y=y;}
};

Point p(3,4);
cout << p; // 사용자는 << 연산자의 중복이 필요하다
//            << (cout,p); 로 변형되기 때문이다.
//            이를 위해 외부 함수를 작성한다.

ostream& operator << (ostream& stream, Point a){
    stream << "(" << a.x<<","<<a.y<<")";
    return stream;
}
//주의 사항!
1.외부 함수로만 작성되어야 한다.
2.프렌드로 선언되어야 한다.
```



예시)

```c++
#include <iostream>
#include <string>
using namespace std;

class Book {
	string title;
	string press;
	string author;
public:
	Book(string title = "", string press = "", string author = "") {
		this->title = title;
		this->press = press;
		this->author = author;
	}
	friend ostream& operator << (ostream& stream, Book b);
};

ostream& operator << (ostream& stream, Book b) {
	stream << b.title << "," << b.press << "," << b.author;
	return stream;
}

int main() {
	Book book("소유냐 존재냐", "한국 출판사", "에이히프롬");
	cout << book;
}
```





#### 추출 연산자란?

- cin과 함께 사용되는 >>
- 원래 오른쪽 시프트 연산자이나, istream클래스에서 중복 작성함

#### 사용자 추출 연산자 >> 만들기

사용자 정의 추출 연산자 함수의 원형

```c++
istream& operator >> (istream& ins, UserClass& obj);
```

만약

``` c++
class Point{
    int x,y;
public:
    Point(int x=0,int y=0){this->x=x;this->y=y;}
};

Point p;
cin >> p; // 컴파일 에러가 발생함 왜냐?
//           >>(cin,p)로 변형하여 컴파일하기 때문이다.
//           이를 위해 외부 함수를 작성한다.

istream& operator >> (istream& ins, Point &a){
    cout << "x 좌표 >>";
    ins >> a.x;
    cout << "y 좌표 >>";
    ins >> a.y;
    return ins;
}
// 주의사항!!
1. 두 번째 매개변수를 참조 타입으로 선언하자.
2. Point클래스에 friend로 선언하자.
```



예시)

``` c++
#include <iostream>
using namespace std;

class Point {
    int x, y;
public:
    Point(int x = 0, int y = 0) { this->x = x; this->y = y; }
    friend istream& operator >> (istream& ins, Point& a);
    friend ostream& operator << (ostream& stream, Point a);
};

istream& operator >> (istream& ins, Point& a) {
    cout << "x 좌표 >>";
    ins >> a.x;
    cout << "y 좌표 >>";
    ins >> a.y;
    return ins;
}

ostream& operator << (ostream& stream, Point a) {
    stream << "(" << a.x << "," << a.y << ")";
    return stream;
}

int main() {
    Point p;
    cin >> p;
    cout << p;
}
```



## 11.6 사용자 조작자 만들기

---

#### 조작자의 실행 과정 ex) endl

- ``` c++
  cout << endl;
  ```

- ```c++
  cout. << (endl);
  ```

- ```c++
  class ostream : virtual public ios{
  public:
      ostream& operator << (ostream& (* _f)(ostream&));
      ...
  };
  ```

- ``` c++
  ostream& ostream::operator << (ostream& (*_f)(ostream&)){
      (*_f)(*this); // *this는 cout, (*_f)는 endl()함수의 호출문
      return *this; // cout의 참조 리턴
  }
  ```

- ``` c++
  ostream& endl(ostream& outs){
      outs.puts('\n'); // 개행 문자 삽입
      outs.flush(); // 버퍼 강제 출력
      return outs; // 출력 스트림의 참조 리턴
  }
  ```



#### 새로운 조작자 만들기

``` c++
istream& manipulatorFunction(istream& ins)
    입력 스트림에 사용되는 조작자 원형
ostream& mainpulatorFunction(ostream& outs)
    출력 스트림에 사용되는 조작자 원형
```

- 조작자들은 모두 >> 나 << 연산자에 의해 동일한 형식으로 호출되기 때문에, 다른 형식으로 조작자 함수를 만들 수 없다.

- fivestar 조작자를 만드는 예시

  - ``` c++
    ostream& fivestar(ostream& outs){
        outs<<"*****"; // 스트림에 * 5개출력
        return outs; // 스트림 리턴
    }
    cout << fivestar << "C++" << endl; // *****C++이 출력됨
    ```



조작자 사용 예시)

```c++
#include <iostream>
using namespace std;

ostream& fivestar(ostream& outs) {
	return outs << "*****";
}

ostream& rightarrow(ostream& outs) {
	return outs << "---->";
}

ostream& beep(ostream& outs) {
	return outs << "\a";
}

int main() {
	cout << "벨이 울립니다." << beep << endl; // 벨이 울립니다.(소리)
	cout << "C" << rightarrow << "C++" << rightarrow << "java" << endl; // C---->C++---->java
	cout << "Visual" << fivestar << "C++" << endl; // Visual*****C++
}
```

