# CH.12 C++ 파일 입출력

---



## 12.1 텍스트 파일과 바이너리 파일

---

파일(file) : 저장 매체에 저장되는 정보 기록되는 정보에따라 텍스트 파일, 바이너리 파일로 나뉨

- 텍스트 파일 : 사람들이 사용하는 "글자혹은 문자"로만 구성된 문서 파일
  - 텍스트 파일에는 문자 코드가 아닌 어떤 값도 존재할 수 없다!
  - 각 글자마다 고유한 이진 코드가 주어진다 (ASCII 코드)
  - '\r' : 커서를 현재 줄의 맨 앞으로
  - '\n' : 커서를 현재있는 위치 에서 한 줄 밑으로
- 바이너리 파일 : 이미지, 오디오, 그래픽 같은 문자로 표현되지 않는 정보들
  - ex) jpeg, bmp, mp3, hwp, dox, ppt, obj, exe 등~
  - 문자로 해석할 수 없는 바이너리 값들이 존재
  - 한글 파일(hwp)는 글자에 색을 입히고, 크기나 서체를 지정하는등 바이너리 정보로 파일에 저장 -> 바이너리 파일



## 12.2 파일 입출력 개요

---

파일 입출력 스트림 사용을 위해선 아래 헤더파일과 코드가 필요하다!

```c++
#include <fstream>
using namespace std;
```

- ifstream :  객체를 통해 파일을 읽는다.

- ofstream : 객체를 통해 파일 쓰기를 진행한다.

- fstream :  하나의 파일에 읽기와 쓰기를 동시해 진행한다.



파일 입출력의 텍스트 I/O 와 바이너리 I/O

- 텍스트 I/O : 문자들만 기록하고, 파일에 있는 바이트를 문자로만 해석하는 입출력 방식
- 바이너리 I/O : 바이트 단위로 바이너리 데이터를 입출력하는 방식. "텍스트 파일과 바이너리 파일에 상관없음" 



## 12.3 <<와 >> 연산자를 이용한 간단한 텍스트 파일 입출력

---

파일 열기

``` c++
ofstream fout; // 파일 출력 스트림 객체 fout생성

fout.open("파일이름"); // 파일 열기

if(!fout){ // 파일 열기 성공 검사
    // 실패시 코드
} 

if(!fout.is_open()){ // 파일 열기 성공 검사
    // 실패시 코드
}

==>
    
ofstream fout("파일 이름"); // 파일 출력 스트림 생성과 동시에 파일 열기
```



파일 쓰기 (<<)

``` c++
int age = 21;
char singer[] = "kim";
char song[] = "yesterday";

fout << age <<'\n'; // 파일에 21과 \n 기록
fout << singer << endl; // 파일에 kim과 \n 기록
fout << song << endl; // 파일에 yesterday와 \n 기록
```



파일 읽기 (>>)

```c++
ifstream fin; // 파일 입력 스트림 객체 fin 생성

if(!fin){ // 파일 열기 실패시
    cout <<"파일 열기 실패!";
    return 0;
}

char name[10],dept[10];
int sid;

fin >> name; // 파일에서 문자열을 읽어 name에 저장
fin >> sid;
fin >> dept;
```





파일 닫기 

``` c++
fout.close(); // fout 파일을 닫는다
```



### ofstream을 통한 파일 쓰기의 예시

``` c++
#include <iostream>
#include <fstream>
using namespace std;

int main() {
	char name[10], dept[20];
	int sid;

	cout << "이름 : ";
	cin >> name;
	cout << "학번 : ";
	cin >> sid;
	cout << "학과 : ";
	cin >> dept;

	ofstream fout("C:\student.txt");
	if(!fout.is_open()){
		cout << "파일 열기 실패!";
		return 0;
	}

	fout << name << endl;
	fout << sid << endl;
	fout << dept << endl;

	fout.close();
}
```





### ifstream을 통한 파일 읽기의 예시

``` c++
#include <iostream>
#include <fstream>
using namespace std;

int main() {
	ifstream fin("c:\student.txt");
	if (!fin) {
		cout << "파일 열기 실패!";
		return 0;
	}
	char name[10], dept[10];
	int sid;

	fin >> name;
	fin >> sid;
	fin >> dept;

	cout<<"이름 : " << name << endl;
	cout <<"학번 : "<< sid << endl;
	cout <<"학과 : "<< dept << endl;

	fin.close();
}
```



## 12.4 파일 모드

---

###  파일모드란?

- 파일을 열 때 앞으로 어떤 파일 입출력을 수행할지 알리는 정보이다!
- 파일을 읽을 것인지 쓸것인지, 지우고 다시 쓸 것인지 등.
- 바이너리 I/O를 할 것인지 텍스트 I/O를 할 것인지.



| 파일 모드   | 의미                                                         |
| ----------- | ------------------------------------------------------------ |
| ios::in     | 읽기 위해 파일을 연다.                                       |
| ios::out    | 쓰기 위해 파일을 연다.                                       |
| ios::ate    | (at end) 쓰기 위해 파일을 연다. 열기 후 파일 포인터를 파일 끝에 둔다. 파일 포인터를 옮겨 파일 내의 임의의 위치에 쓸 수 있다. |
| ios::app    | 파일 쓰기 시에만 적용된다. 파일 쓰기 시마다, 자동으로 파일 포인터가 파일 끝으로 옮겨져서 항상 파일의 끝에 쓰기가 이루어진다. |
| ios::trunc  | 파일을 열 때, 파일이 존재하면 파일의 내용을 모두 지워 파일 크기가 0인 상태로 만든다. ios::out 모드를 지정하면 디폴트로 함께 지정된다. |
| ios::binary | 바이너리 I/O로 파일을 연다. 이 파일 모드가 지정되지 않으면 디폴트가 텍스트 I/O이다. |

=> 파일 포인터는 12.8 장에서 다룬다.



``` c++
ifstream fin;
fin.open("student.txt"); // 디폴트 파일 모드 (ios::in) 지정. 디폴트 텍스트 I/O
fin.open("student.txt",ios::in); // 위와 같다
---
ofstream fout;
fout.open("student.txt",ios::out | ios::app);
fout<<"tel:22121312312"; // 기존의 student.txt끝에 옆의 내용 추가로 저장
---
fstream fbinout;
fbinout.open("data.bin",ios::out | ios::binary);
char buf[128];
...
fbinout.write(buf,128); // buf에 있는 128바이트를 파일에 기록



==> 스트림 객체의 생성자를 이용한 파일 모드 지정
    ifstream fin.open("student.txt");
	ofstream fout.open("student.txt",ios::out | ios::app);
	fstream fbinout.open("data.bin",ios::out | ios::binary);
```



## 12.5 멤버 함수를 이용한 텍스트 I/O

---

get() : 파일에서 문자 한 개를 읽는다.

put() : 파일에서 문자 한 개를 파일에 기록한다.



### get()을 이용한 텍스트 파일 읽기

``` c++
#include <iostream>
#include <fstream>
using namespace std;

int main() {
	const char* file = "c:\\windows\\system.ini";
	ifstream fin(file);
	if (!fin) {
		cout << file << " 열기 오류" << endl;
		return 0;
	}
	int count = 0;
	int c;
	while ((c = fin.get()) != EOF) { // 
		cout << (char)c;
		count++;
	}

	cout << "읽은 바이트 수는 " << count << endl;
	fin.close();
}

/*
  get()은 한 바이트를 읽고 파일 포인터를 한 칸씩 전진시킨다.
=>파일의 끝에 다가간다.
=>eof()함수를 호출해 파일의 끝에 다다르면 -1을 리턴하고 종료한다. 
*/
```



### ios::app,put()을 이용해 파일 덧붙히기

```c++
#include <iostream>
#include <fstream>
using namespace std;

int main() {
	const char* firstfile = "c:\student.txt";
	const char* secondfile = "c:\\windows\\system.ini";
	fstream fout(firstfile,ios::out | ios::app);
	if (!fout) {
		cout << firstfile << " 열기 오류" << endl;
		return 0;
	}
	
	fstream fin(secondfile, ios::in);
	if (!fin) {
		cout << secondfile << " 열기 오류" << endl;
		return 0;
	}
	int c;
	while ((c = fin.get()) != EOF) {
		fout.put(c);
	}

	fout.close();
	fin.close();
}
```



### 텍스트 파일의 라인 단위 읽기

- 방법 1 : istream의 getline(char * line,int n) 함수 이용
- 방법 2 : getline(ifstream fin, string line) 함수 이용



#### 방법 1

```c++
char buf[81];
ifstream fin("c:\\windows\\system.ini");
while(true){
    fin.getline(buf.81); // 최대 80개의 문자로 구성 끝은 '\0'
    if(fin.eof())
        break; // 읽기 종료
}
```



코드 예시)

```c++
#include <iostream>
#include <fstream>
using namespace std;

int main() {
	ifstream fin("c:\\windows\\system.ini");
	if (!fin) {
		cout << "파일 열기 실패" << endl;
		return 0;
	}

	char buf[81];
	while (true) {
		fin.getline(buf, 81);
		if (fin.eof())
			break;
		cout << buf << endl;
	}

	fin.close();
}
```



#### 방법 2

``` c++
string line;
ifstream fin("c:\\windows\\system.ini");
while(true){
    getlien(fin,line); // 한 라인을 읽어 line에 저장
    if(fin.eof())
        break; // 읽기 종료
}
```



코드 예시)

```c++
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
using namespace std;

void fileRead(vector<string>& v, ifstream& fin) {
	string line;
	while (true) {
		getline(fin, line);
		if (fin.eof())
			break;
		v.push_back(line);
	}
}

void search(vector<string>& v, string word) {
	for (int i = 0; i < v.size(); i++) {
		int index = v[i].find(word);
		if (index != -1)
			cout << v[i] << endl;
	}
}

int main() {
	vector<string> wordVector;
	ifstream fin("words.txt");
	if (!fin) {
		cout << "words.txt 파일 열기 실패" << endl;
		return 0;
	}

	fileRead(wordVector, fin);
	fin.close();

	cout << "words.txt 파일을 읽었습니다." << endl;
	while (true) {
		cout << "검색할 단어를 입력하세요>>";
		string word;
		getline(cin, word);
		if (word == "exit")
			break;
		search(wordVector, word);
	}

	cout << "프로그램 종료" << endl;
}
```



## 12.6 바이너리 I/O

---

바이너리 I/O는 파일의 각 바이트를 바이너리 값 그대로 읽거나, 변수나 버퍼의 바이너리 값을 그대로 파일에 저장하는 "저수준 입출력 방식"이다.

``` c++
ifstream fin;
fin.open("desert.jpg",ios::in | ios::binary); // binary I/O로 파일 읽기 모드

ofstream fout("desert.jpg", ios::out | ios::binary); // binary I/O로 파일 쓰기 모드
fstream fsin("desert.jpg",ios::in | ios::binary); // binary I/O로 파일 읽기 모드
```



get(),put()을 이용해 텍스트 파일을 복사하는데 사용하는 것 처럼 짜도 정확하게 작동된다!!

``` c++
#include <iostream>
#include <fstream>
using namespace std;

int main() {
	const char* srcFile = "c:\\user\\public\\pictures\\sample picures\\desert.jpg";
	const char* destFile = "c:\\copydesert.jpg";

	ifstream fsrc(srcFile, ios::in | ios::binary);
	if (!fsrc) {
		cout << srcFile << " 열기 오류" << endl;
		return 0;
	}

	ofstream fdest(destFile, ios::out | ios::binary);
	if (!fdest) {
		cout << destFile << " 열기 오류" << endl;
		return 0;
	}

	int c;
	while ((c = fsrc.get()) != EOF) {
		fdest.put(c);
	}
	cout << "복사 완료!" << endl;
	fsrc.close();
	fdest.close();
}
```



##### get(), put()은 한 바이트 단위로 입출력을 수행 <=> read(),write()는 블록 단위로 입출력을 수행  (실행 속도가 빠르나 실제 읽은 바이트 수를 확인 해줘야됨)

``` c++
ifstream fin;
fin.open("desert.txt",ios::in | ios::binary);

char s[1024];
fin.read(s,1024); // 파일로 부터 1024바이트를 읽어 배열 s에 저장
int n = fin.gcount(); // 앞의 fin.read() 함수가 실제로 읽은 바이트 수를 n에 리턴
					  // 배열 s[]에는 n개의 바이트만이 유효!
```



### read()/write()로 이미지 파일 복사

``` c++
#include <iostream>
#include <fstream>
using namespace std;

int main() {
	const char* srcFile = "c:\\user\\public\\pictures\\sample picures\\desert.jpg";
	const char* destFile = "c:\\copydesert.jpg";
	
	ifstream fsrc(srcFile, ios::in | ios::binary);
	if (!fsrc) {
		cout << srcFile << "파일 열기 실패!";
		return 0;
	}

	ofstream fdest(destFile, ios::out | ios::binary);
	if (!fdest) {
		cout << destFile << "파일 열기 실패!";
		return 0;
	}

	char buf[1024];
	while (!fsrc.eof()) {
		fsrc.read(buf, 1024);
		int n = fsrc.gcount();
		fdest.write(buf, n);
	}

	cout << "복사 성공!" << endl;
	fsrc.close();
	fdest.close();
}
```



### 바이너리 I/O와 텍스트 I/O의 차이점

- 파일의 끝을 인식하는 방법에는 차이가 없다
- 텍스트 I/O와 바이너리 I/O는  '\n'을 읽고 쓸 때 서로 다르게 작동한다.
  - 텍스트 I/O는 '\r' ,'\n' 두 개가 기록
  - 바이너리 I/O에는 '\n'만 기록



## 12.7 스트림 상태 검사

스트림의 상태를 나타내는 각 비트

| 비트    | 설명                                                         |
| ------- | ------------------------------------------------------------ |
| eofbit  | 파일의 끝을 만났을 때 1로 세팅                               |
| failbit | 정수를 입력 받고자 하였으나 문자열이 입력되는 등 포맷 오류나 , 쓰기 금지된 곳에 쓰기를 시행하는 등 전반적인 I/O 실패 시에 1로 세팅 |
| badbit  | 스트림이나 데이터가 손상되는 수준의 진단되지 않는 문제가 발생한 경우나 유호하지 않는 입출력 명령이 주어졌을 때 1로 세팅 |



스트림의 상태를 검사하는 멤버 함수

| 멤버 함수 | 설명                                           |
| --------- | ---------------------------------------------- |
| eof()     | 파일의 끝을 만났을 떄 (eofbit = 1) true 리턴   |
| fail()    | failbit나 badbit가 1로 세팅되었을 때 true 리턴 |
| bad()     | badbit이 1로 세팅되었을 때 true 리턴           |
| good()    | 스트림이 정상적(모드 비트가 0)일 때 true 리턴  |
| clear()   | 스트림 상태 변수를 0으로 지움                  |



스트림 상태 검사 예시)

```C++
#include <iostream>
#include <fstream>
using namespace std;

void showStreamState(ios& stream) {
	cout << "eof() " << stream.eof() << endl;
	cout << "fail()" << stream.fail() << endl;
	cout << "bad()" << stream.bad() << endl;
	cout << "good()" << stream.good() << endl;
}

int main() {
	const char* noExistFile = "c:\noexist.txt";
	const char* existFile = "c:\student.txt";

	ifstream fin(noExistFile);
	if (!fin) {
		cout << noExistFile << " 열기 오류" << endl;
		showStreamState(fin);

		cout << existFile << " 파일 열기" << endl;
		fin.open(existFile);
		showStreamState(fin);
	}

	int c;
	while ((c = fin.get()) != EOF)
		cout.put((char)c);

	cout << endl;
	showStreamState(fin);

	fin.close();
}
```



## 12.8 임의 접근

---

c++ 라이브러리의 get(),put(),read(),write()는 디폴트가 "순차 접근"이다.

=> 처음부터 끝까지 순차적으로 읽거나 기록한다



##### 임의접근이란? 파일을 임의의 위치로 옮겨다니면서 읽거나 쓰는 것!

##### 파일 포인터란? 파일 내의 일고 쓸 바이트의 위치를 가리키 것!

- get pointer - 파일 내의 읽기 지점을 가리키는 파일 포인터 / ios::in
- put pointer - 파일 내의 쓰기 지점을 가리키는 파일 포인터 / ios::out
- ios::ate 모드로 파일을 열면 put pointer는 파일의 처음 위치를 가리키지만, 파일 쓰기를 하면 자동으로 맨 끝으로 put pointer를 옮겨서 쓰기를 수행함.



임의 접근 방법

| seekbase | 설명                                                       |
| -------- | ---------------------------------------------------------- |
| ios::beg | 파일의 처음 위치를 기준으로 파일 포인터를 움직인다.        |
| ios::cur | 현재 파일 포인터의 위치를 기준으로 파일 포인터를 움직인다. |
| ios::end | 파일의 끝(EOF) 위치를 기준으로 파일 포인터를 움직인다.     |



- 절대 위치로 파일 포인터를 옮기기

```c++
fin.seekg(5); // get pointer를 파일 인덱스 5위치로 옮긴다.
int n = fin.tellg(); // n은 5가 된다.
int c = fin.get(); // c=0x49
```

- 상대 위치로 파일 포인터 옮기기

```c++
fin.seekg(10,ios::beg);// 파일 시작점 기준으로 get pointer를 10칸 전진
fin.seekg(-1,ios::cur);// 현재 위치에서 get pointer를 한 바이트 후진
fin.seekg(0,ios::end);// 파일의 맨 끝으로 get pointer를 움직임
					  // 여기부터 읽을 데이터는 없다.
```

- 파일이 맨 마지막 문자를 읽는 경우

``` c++
fin.seekg(-1,ios::end); // get pointer를 파일의 마지막 문자 위치로 보낸다.
int c = fin.get(); // 파일의 마지막 문자 0x2B를 c에 읽어 온다.
					// get() 실행 후 get pointer는 EOF를 가리킴
```

- 10바이트를 간격으로 문자를 읽고자 하는 경우

``` c++
int c;
while((c=fin.get())!=EOF){ // 1 칸 전지
    fin.seekg(9,ios::cur); // 9칸 건너 뛰어 get pointer 전진
}
```

- 텍스트 파일을 거꾸로 화면에 출력하는 경우

``` c++
fin.seekg(0,ios::end);
int fileSize = fin.tellg();
for(int i=0;i<fileSize;i++){
    fin.seekg(fileSize-1-i,ios::beg);
    int c=fin.get();
    cout << (char)c;
}
```



파일 포인터를 이용해 파일의 크기를 알아내기 !

``` c++
#include <iostream>
#include <fstream>
using namespace std;

long getFileSize(ifstream& fin) {
	fin.seekg(0, ios::end);
	long length = fin.tellg();
	return length;
}

int main() {
	const char* file = "c:\\windows\\system.ini";

	ifstream fin(file);
	if (!fin) {
		cout << file << " 열기 오류" << endl;
		return 0;
	}

	cout << file << "의 크기는 " << getFileSize(fin);
	fin.close();
}
```

