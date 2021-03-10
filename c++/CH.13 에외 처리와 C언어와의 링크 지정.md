# CH.13 예외 처리와 C언어와의 링크 지정

---



## 13.1 실행 오류와 오류 처리

---

오류의 종류와 원인!

- 개발자의 논리가 잘못된 경우
- 예외에 대한 대책을 준비하지 않은 경우



예외에 대한 대처가 없는 프로그램 사례

``` c++
#include <iostream>
using namespace std;

int getExp(int base, int exp) {
	int value = 1;
	for (int n = 0; n < exp; n++)
		value = value * base;
	return value;
}

int main() {
	int v = getExp(2, 3);
	cout << "2의 3승은 " << v << endl;
	int e = getExp(2, -3);
	cout << "2의 -3승은 " << e << endl; // 결과값이 1이 나옴 => 음수에 대한대처를 안함!!
}
```



이를 해결하는 방법으로 여태까지 우리는

- 방법 1 : 조건문과 리턴 값을 이용하는 전형적인 오류 처리
- 방법 2 : 리턴 값과 참조 매개 변수를 이용한 오류 처리



방법 1 

``` c++
#include <iostream>
using namespace std;

int getExp(int base, int exp) {
	if (base <= 0 || exp <= 0) {
		return -1;
	}
	int value = 1;
	for (int n = 0; n < exp; n++)
		value = value * base;
	return value;
}

int main() {
	int v = 0;
	v=getExp(2, 3);
	if (v != -1) {
		cout << "2의 3승은 " << v << endl;
	}
	else {
		cout << "2의 3승은 계산 불가" << endl;
	}
	int e = 0;
	e = getExp(2, -3);
	if (e != -1) {
		cout << "2의 -3승은 " << e << endl;
	}
	else {
		cout << "2의 -3승은 계산 불가" << endl;
	}
}
```



방법 2

``` c++
#include <iostream>
using namespace std;

bool getExp(int base, int exp,int &ret) {
	if (base <= 0 || exp <= 0) {
		return false;
	}
	int value = 1;
	for (int n = 0; n < exp; n++)
		value = value * base;
	ret = value;
	return true;
}

int main() {
	int v = 0;
	if (getExp(2, 3, v)) {
		cout << "2의 3승은 " << v << endl;
	}
	else {
		cout << "2의 3승은 계산 불가" << endl;
	}
	int e = 0;
	if (getExp(2, -3, e)) {
		cout << "2의 -3승은 " << e << endl;
	}
	else {
		cout << "2의 -3승은 계산 불가" << endl;
	}
}
```





## 13.2 예외와 예외 처리

---

### 예외란? 프로그램의 오작동이나 결과에 영향을 미치는 예상치 못한 상황 발생



c++에서의 예외 처리 기본 형식, try-throw-catch

``` c++
try{ // 예외가 발생할 가능성이 있는 실행문
    ...
    예외 발생시{
        throw xxx; // 예외 발생을 알림, xxx는 예외값, 예외를 던진다!
    }
    예외 발생시{
        throw yyy; // 예외 발생을 알림
    }
}
catch(처리할 예외 파라미터){ // 예외를 처리할 블록
    예외 처리문
}
catch(처리할 예외 파라미터){
    예외 처리문
}
```



- int 타입의 예외를 던지는 throw와 catch() {} 블록

``` c++
try{
    throw 3;
    ...
}
catch (int x){
    
}
```

- double 타입의 예외를 던지는 throw와 catch() {} 블록

``` c++
try{
    throw 3.5;
    ...
}
catch(double b){
    cout << "실수 값"<< d<<"는 처리 불가능";
}
```

- 문자열 타입의 예외를 던지는 throw와 catch() {} 블록

``` c++
try{
    throw "음수 불가능";
    ...
}
catch(char *s){
    cout << s;
}
```



0이나 음수로 나누는 오류를 탐지하고 예외를 처리하는 코드

``` c++
#include <iostream>
using namespace std;

int main() {
	int n, sum, avg;
	while (true) {
		cout << "합을 입력>>";
		cin >> sum;
		cout << "인원 수 입력>>";
		cin >> n;
		try {
			if (n <= 0) // 오류 탐지 구문
				throw n; // 예외 발생시 catch구문으로 점프
			else
				avg = sum / n;
		}
		catch (int x) {
			cout << "예외 발생!" << x << "로 나눌 수 없음" << endl;
			avg = 0;
			cout << endl;
			continue;
		}
		cout << "평균 = " << avg << endl;
	}
}
```



## 13.3 예외 처리에 대한 자세한 설명

---

- 하나의 try{}블록에 여러 개의 catch(){}블록을 연결하여 사용할 수 있다.
- 호출한 함수가 예외를 던지는 경우도 있다.



문자열을 정수로 변환하기

``` c++
#include <iostream>
#include <cstring>
using namespace std;

int stringToint(const char x[]) {
	int sum = 0;
	int len = strlen(x);
	for (int i = 0; i < len; i++) {
		if (x[i] >= '0' && x[i] <= '9')
			sum = sum * 10 + x[i] - '0';
		else
			throw x;
	}
	return sum;
}

int main() {
	int n;
	try {
		n = stringToint("123");
		cout << "\"123\" 은 정수 " << n << "로 변환 됨" << endl;
		n = stringToint("1A3");
		cout << "\"1A3\" 은 정수 " << n << "로 변환 됨" << endl;
	}
	catch (const char* s) {
		cout << s << " 처리에서 예외 발생!" << endl;
		return 0;
	}
}
```



throw 문을 가지고 있는 함수는 함수 선언문에 예외 발생을 명시할 수 있다.

``` c++
double valueAt(double *p,int index)throw(int, char*){
    if(index<0)
        thrwo "index out of bounds exception";
    else if (p==0)
        thrwo 0;
    else return p[index];
}
```

- 프로그램의 작동을 명확히 한다.
- 예외와 관련된 프로그램의 가독성을 높인다.



### 중첩 try{} 블록

try{} 블록 내에 다른 try{}블록을 중첩 작성할 수 있다.

이때 안쪽 try{}문에 예외를 던질 catch(){}블록이 없으면 바깥쪽 catch(){}블록으로 예외가 전달된다.!



### throw 사용 시 주의사항

- throw문은 항상 try{}블록 안에서만 실행되어야 한다.

  - ``` c++
    throw 3; // 비정상 종료!
    ...
    try{
        ...
    }
    catch(int n){
        ...
    }
    ```

- 예외를 처리할 catch(){} 블록이 없으면 프로그램은 종료된다.

  - ``` c++
    try{
        throw "aa"; // char* 타입의 예외를 처리할  catch블록이 없어 종료
        ...
    }
    catch (double p){
        ...
    }
    ```

- catch(){} 블록 내에도 try{} catch(){}블록을 선언할 수 있다.

  - ``` c++
    try{
        throw 3;
        ...
    }
    catch (int x){
        try{
            throw "aa"; // 아래의 catch블록에서 처리된다.
            ...
        }
        catch (char *p){
            ...
        }
    }
    ```



## 13.4 예외 클래스 만들기

---

사례

``` c++
#include <iostream>
#include <string>
using namespace std;

class MyException {
	int lineNo;
	string func, msg;
public:
	MyException(int n, string f, string m) {
		lineNo = n;
		func = f;
		msg = m;
	}
	void print() {
		cout << func << " : " << lineNo << " , " << msg << endl;
	}
};

class DivideByZeroException : public MyException {
public:
	DivideByZeroException(int lineNo, string func, string msg)
		:MyException(lineNo, func, msg) {}
};

class InvalidInputException : public MyException {
public:
	InvalidInputException(int lineNo, string func, string msg)
		: MyException(lineNo, func, msg) {}
};

int main() {
	int x, y;
	try {
		cout << "나눈셈 함, 두개의 양의 정수 입력>>";
		cin >> x >> y;
		if (x < 0 || y < 0)
			throw InvalidInputException(37, "main()", "음수 입력 예외 발생");
		if (y == 0)
			throw DivideByZeroException(39, "main()", "0으로 나누는 예외 발생");
		cout << (double)x / (double)y;
 	}
	catch(DivideByZeroException &e){
		e.print();
	}
	catch (InvalidInputException& e) {
		e.print();
	}
}
```



## 13.5 C++ 코드와 C코드의 링킹

---

### C/C++ 컴파일러의 이름 규칙

- C 컴파일러의 이름 규칙

  - C컴파일러는 C소스 코드를 컴파일 하여 목적 코드를 만들 떄 함수 이름 앞에 밑줄표시문자(_)를 붙힌다.

  - ```c
    int f(int x,int y)
    int main()
        
    => // C컴파일러는 이 두함수가 사용되는 C소스 코드의 모든 곳에 다음과 ㄱㅌ이 이름을 변경하여 목적 파일에 저장한다.
        _f
        _main
        // 이러한 이름 규칙의 한계로 C에선 함수 중복이 불가능 하다.!!
    ```

- c++ 컴파일러 이름 규칙

  - C++ 컴파일러의 이름 규칙은 목적 코드를 만들 때 함수의 매개 변수 개수와 타입, 리턴 타입들을 참조하여 복잡한 기호를 포함해서 이름을 붙힘.

  - ``` c++
    int f(int x,int y)
    int f(int x)
    int f()
    int main()
        
    =>
        ?f@@YAHHH@Z
        ?f@@YAXH@Z
        ?f@@YAHXZ
        _main // 예외적으로 메인함수는 _main으로 이름을 붙힌다.
    ```



### C++ 프로그램에서 C함수 호출시 링크 오류가 발생하는 경우

- 이름 규칙이 서로 다르기 때문이다.

- C++ 컴파일러는 f함수를 ?f@@YAHXZ  / C 컴파일러는 f함수를 _f로 기록된다.

- 링커는 main.obj에서 ?f@@YAHXZ 이름의 함수를 f.obj에서 발견할 수 없기 때문에 오류가 발생한다.!!!



### 정상적인 링킹, extern "C"

C++ 컴파일러에게 main.cpp안에 등장하는 함수 f()가 c언어로 작성된 것임을 알려주 C언어의 이름 규칙으로 컴파일 하도록 지시하자

=> by "\extern "C"\\"

``` c++
extern "C" int f(int x,int y);

//만약 C언어로 작성된 함수가 여러개 있다면
extern "C"{
    int f(int x,int y);
    void g();
    char s(int []);
}

//C함수의 원형이 선언된 헤더 파일을 통째로 사용하려면
extern "C"{
    #include "mycfunction.h"
}
```



