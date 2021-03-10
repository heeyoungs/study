# CH.2 C++프로그래밍의 기본

---



## 2.1 C++ 프로그램의 기본 요소와 화면 출력

가장 기본적인 C++ 프로그램의 형태는

``` C++
/*
주석입니다
*/
#include <iostream> // cout과 <<연산자가 포함되어 있다

int main(){
    std::cout << "Hello\n"; //Hello 출력
    std::cout << "예제입니다.!";
    return 0; // 이 프로그램이 종료됨
}
```



### 주석문

- 실행에 영향을 미치지 않으며 특이사항을 적을 수 있는 메모 공간

- 여러 줄 주석문은 /* ~~ */ 을 이용한다
- 한 줄 짜리 주석문은 // 을 이용한다



### main() 함수

- 실행의 시작점 

- C++ 프로그램 하나에 반드사 하나의 main() 이 존재

- main() 종료시 프로그램이 종료

- main() 의 리턴값은 ANSI C++ 에서 "int" 로 정의함
- return 값은 아무 의미가 없고 C++에선 생략해도 괜찮다



### #include \<iostream>

- 전처리기에 대한 지시문
- 파일을 컴파일 하기 전에 iostream 헤더 파일을 삽입함
- 클래스와 객체가 선언되어 있으므로 C++ 언어에선 필수



### 화면 출력

- cout 객체
  - 스크린 장치와 연결된 출력 개체다
  - 출력한 데이터를 화면에 출력 해 준다
- << 연산자
  - 삽입 연산자
  - 왼쪽 스트림 객체에 삽입한다.
  - 본래의 << 연산자는 정수의 왼쪽 shift연산자 이나 iostream에서 재정의 된다

- 여러 개의 << 연산자로 한 문장에 여러 데이터 출력

  - ``` c++
    std::cout << "안" << "녕";
    ```

  - 이런 식으로 왼쪽에서 오른쪽 순서대로 여러 개의 데이터를 출력시킬 수 있다

  - 문자열뿐 아니라 bool, char, short, int등 기본 타입 데이터도 출력 가능



### 화면에서 다음 줄로 넘어가기

- ''\n"은 다음 코드를 다음 줄로 넘겨준다
- endl 도 비슷한 기능을 사용한다 (조작자)



## 2.2 namespace와 std::



### namespace

- 이름 공간으로 이름 충돌을 막아줌

- 이름 공간안에 선언된 이름들은 별개의 이름으로 취급

- 이름 공간의 생성방법

  - ``` c++
    namespace 이름 공간{
        이름 공간::이름    // ::는 범위 지정 연산자
    }
    ```



### std::란?

- ANSI C++에서 정한 표준 이름 공간
- 표준 라이브러리에서 선언된 이름을 사용할 때 std::를 접두어로 사용해야 됨



### std::의 생략과 using 지시어

- using 지시어를 사용해 이름 공간 접두어를 생략시켜줌

  - ``` c++
    using std::cout; // cout에 대해 std 생략
    ...
    cout << "HI" << std::endl; 
    ```

- std 이름 공간에 선언된 모든 이름에 대해 std::를 생략하려면

  - ``` c++
    using namespace std; // std이름 공간의 모든 이름에 대해 std생략
    ...
    cout << "hi" << endl;
    ```



## 2.3 키 입력 받기



### cin과 >> 연산자를 이용한 키 입력

- cin과 >>는 iostream의 헤더파일 안에 선언되어 있음
- 모든 int, char 등의 기본 타입에 대해 >>연산자로 데이터 입력 가능
- cin은 키보드와 C++ 응용프로그램을 연결하는 입력 스트림 개체
  - enter 키를 기준으로 입력값을 변수에 저장함
- \>> 연산자는 스트림 추출 연산자
  - 원래는 오른쪽 shift연산자 이지만 iostream에 재정의 됨



### 실행문 중간에 변수 선언

- 프로그램 어디서나 변수 선언 가능
- 변수 사용은 변수 선언라인 아래부터
- 장점
  - 변수를 선언하려 시작부로 옮기는 번거로움 x
  - 이름이 비슷한 변수들로 인한 오류 감소
- 단점
  - 변수들을 한 눈에 알아보기 힘듬



## 2.4 키보드로 문자열 입력



### C++ 문자열 

- C-스트링 : C언어에서 문자열을 표현하는 방식

  - '\\0' 또는 NULL 로 끝나는 배열

  - c언어와의 호환성때문에 사용가능

  - ``` c++
    char name[6]={'H','e','l','l','o','\0'};
    char name[6]="Hello"
    ```

  - ""문자열의 마지막에 \0이 추가되어야 해서 문자열보다 배열의 크기가 최소 1더 커야됨"

  - c언어의 string.h 사용 가능 => c++의 cstring 을 사용 하자 



- string 클래스 : 문자열을 객채로 다루는 방식***

  - 문자열의 크기에 제약이 없다!

  - C보다 문자열을 다루는 방식이 쉽다

  - ``` c++
    #include <iostream>
    #include <string> // string 사용 헤더파일
    using namespace std;
    
    int main(){
        string name;
        cin >> name;
        cout<< "나의 이름은" << name << "이다";
    }
    ```

 

### cin으로 문자열 받을 때 허점

공백 문자를 만나면 공백을 기준으로 하나의 문자열로 취급한다!!

> cin.getline()을 이용해 문자열을 입력받자
>
> 형식!
>
> ```c++
> cin.getline(char buf[],int size,char delimitchar)
> - buf : 키보드로부터 읽은 문자열을 저장할 배열
> - size : buf[] 배열의 크기
> - delimitchar : 문자열 입력 끝을 지정하는 구분 문자
> // delimitchar의 기본 값은 '\n' 이므로 생략가능
> ```
>
> 예제
>
> ``` c++
> char address[100];
> cin.getline(address,100,'\n'); // enter 까지 100-1 개의 문자 입력 받는다
> ```



### string으로 공백의 문자열 받기

> getline()을 사용하자
>
> 형식!
>
> ``` c++
> getline(cin,string buf[],char delimintchar)
> - cin : 키보드로부터 입력 받겠다
> - buf[] : 문자열을 저장할 string
> - delimitchar : 문자열 입력 끝을 지정하는 구분 문자
> // 마찬가지로 default 값이 '\n'
> ```
>
> 예제
>
> ``` c++
> string name;
> getline(cin,name,'\n')
> ```



## 91p 14.Sol

```c++
#include <iostream>
#include <cstring>
using namespace std;

int main() {
	cout << "영문 텍스트를 입력하세요. 히스토그램을 그립니다.\n텍스트의 끝은 ; 입니다. 10000개까지 가능합니다." << endl;
	char sentence[10001];
	cin.getline(sentence, 10001, ';');
	int alpnum = 0; // 알파벳 개수
	for (int i = 0; i < strlen(sentence); i++)
	{
		if ((sentence[i] >= 'a' && sentence[i] <= 'z') || (sentence[i] <= 'Z' && sentence[i] >= 'A'))
		{
			alpnum += 1; // 알파벳 개수를 센다
			if (sentence[i] <= 'Z' && sentence[i] >= 'A')
			{
				sentence[i] = char(sentence[i] - 'A' + 'a');
			}
		}
	}
	cout << "총 알파벳 수 " << alpnum << '\n' <<endl;

	char alp[26] = {}; // a~z
	int num[26] = {};
	for (int i = 0; i < 26; i++)
	{
		alp[i] = 'a' + i;
		for (int j = 0;j<strlen(sentence); j++)
		{
			if (sentence[j]==alp[i])
			{
				num[i] += 1;
			}
		}
	}
	for (int i = 0; i < 26; i++)
	{
		cout << alp[i] << " (" << num[i] << ")" << "  : ";
		for (int j = 0; j < num[i]; j++)
		{
			cout << "*";
		}
		cout << endl;
	}
}
```

