# javaScript

---

```
-- 느낌표 탭!
-- p 탭!
-- ctrl ?
-- 개발자 도구 f12
```



## 데이터 타입 : 문자열과 숫자

---

더하기 +

곱하기 *

나누기 /

pow (3,2)  = 3^2

round(10.6) = 11

ceil(10.2) = 11 

floor(10.6) = 10

sqrt(9) = 3

random = 0~1.0 사이 랜덤 숫자

.indexOf("x") = x가 몇번째 자리에 위치한것인가?

.length = 길이

.toUpperCase() = 소문자를 대문자로 치환

.trim() = 공백제거



## 변수와 대입 연산자

---

var

- 변수를 선언하겠다. (생략 가능)
- 정수도, 문자열도 선언가능하다

let

- 변수에 재할당 가능

const

- 변수 재선언, 변수에 재할당 불가능



## 웹 브라우저 제어

---

html 

- 한 번 정해지면 변하지 않는 정적인 언어



## CSS 기초

---

style="color:색" 

- 색 변환

background-color:색

- 배경 색 변환



<span style = "font-weight:색"\> 

- 단어 강조



.js{

​	font-weight:bold;

​	color:red;

}

<span class="js"\>

- js를 빨간색으로 강조 
- 클래스 선택자 , 여러가지를 선택할수 있음.



#first{

​	color:green

}

<span id="first" class="js"\>

- first를 초록색으로 강조
- 클래스 선택자에서, 예외 처리해주고 싶은걸 할수있음.
- 우선 순위가 높음



span{

​	color:blue;

}

<span\>

- 모든 span태그를 파랑색으로 강조



## 조건문

---



### 비교 연산자

=== 

- 문자의 타입까지 동일하면 true

\&lt;

- < 와 동일

\&gt;

- \> 와 동일



if문 예시

```javascript
<h2> IF-true</h2>
<script>
    document.write("1<br>");
    if (true){
        document.write("2<br>");
    }else{
        document.write("3<br>");
    }
    document.write("4<br>");
</script>

```



## 리펙토링

---

```javascript
<h1><a href="index.html">WEB</a></h1>
  <input id="night_day" type="button" value="night" onclick="
    var target = document.querySelector('body');
    if(this.value === 'night'){
      target.style.backgroundColor = 'black';
      target.style.color = 'white';
      this.value = 'day';
    } else {
      target.style.backgroundColor = 'white';
      target.style.color = 'black';
      this.value = 'night';
    }
  ">
```

- this태그로 자기 자신을 참조
- var target 변수로 중복을 제거



## 배열

---

```javascript
var a = ['asd','ascx'];
document.write(a[0]);
```

.length 배열 길이 추출

.push 배열에 값을 추가



## 반복문

---

while(조건)



-> 활용

```javascript
var i = 0;
while(i<a.length){
    document.write('<li>' + a[i] + '</li>');
    i = i + 1;
}
```



## 함수

---

```javascript
<h1><a href="index.html">WEB</a></h1>
  <input id="night_day" type="button" value="night" onclick="
    nightDayHandler(this);
  ">
  <input id="night_day" type="button" value="night" onclick="
    nightDayHandler(this);
  ">
  <ol>
    <li><a href="1.html">HTML</a></li>
    <li><a href="2.html">CSS</a></li>
    <li><a href="3.html">JavaScript</a></li>
  </ol>
  <h2>JavaScript</h2>
  <p>
```



## 객체

---

```javascript
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
  </head>
  <body>
    <h1>Object</h1>
    <h2>Create</h2>
    <script>
        // 객체
      var coworkers = {
        "programmer":"egoing",
        "designer":"leezche"
      };

      document.write("programmer : "+coworkers.programmer+"<br>");
      document.write("designer : "+coworkers.designer+"<br>");

      coworkers.bookkeeper = "duru";
      document.write("bookkeeper : "+coworkers.bookkeeper+"<br>");

      coworkers["data scientist"] = "taeho";
      document.write("data scientist : "+coworkers["data scientist"]+"<br>");
    </script>
  </body>
</html>
```



## API

---

- Application Programming Interface의 약자

- 프로그램이 동작하는 환경을 제어하기 위해서 그 환경에서 제공되는 조작장치

- 이 조작 장치는 프로그램이 언어를 통해서 조작할 수 있다.

- 프로그래머는 자신이 제어하고자 하는 환경(웹,node.js,google.apps Script) 을 그 환경에 제공하는 조작장치인 각가의 API를 통해서 소프트웨어를 제어한다.

- 우리가 제어하고자 하는 환경이 제공하는 API가 무엇이고, 어떤 특성이 있고, 어떻게 사용하는가를 알아야한다.

  



## UI

---

- User Interface의 약자
- 사용자를 대면하는 접점이 되는 지점
- 노트북에 있는 전원버튼, 핸드폰의 홈버튼 등..
- 사용자의 의중을 시스템에게 전달하고 시스템의 상태를 사용자에게 보여준다.



## 자바스크립트의 API

---

- 웹 브라우저, Node.js , Google Apps Script에는 각각의 API가 있다.
- 자바스크립트 API에는 날짜 알아내기, Math 라는 것을 통해서 수학적인 계산을 하는 API가 있다.
- 호스트 환경을 제어할 수 있도록 제공해주는 조작 장치가 호스트 환경 API이다.
- LiveScript = JavaScript
- ECMAscript가 자바스크립트에 새로운 기능을 추가하거나 없앤다. 자바 스크립트가 동작하는 환경을 만드는 브라우저 개발자들을 위한 문서를 찾아볼 수 있다.



## 자바 스크립트 API문서

---

- https://www.ecma-international.org/publications-and-standards/standards/ecma-262/ (표준문서)
- https://opentutorials.org/course/50/182 (생활코딩)
- https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference (MDN)
- https://docs.microsoft.com/ko-kr/previous-versions/visualstudio/visual-studio-2010/z688wt03(v=vs.100)?redirectedfrom=MSDN (MSDN)



## Node.js

---

```
Node.js는 확장성 있는 네트워크 애플리케이션(특히 서버 사이드) 개발에 사용되는 소프트웨어 플랫폼이다. 작성 언어로 자바스크립트를 활용하며 Non-blocking I/O와 단일 스레드 이벤트 루프를 통한 높은 처리 성능을 가지고 있다. 내장 HTTP 서버 라이브러리를 포함하고 있어 웹 서버에서 아파치 등의 별도의 소프트웨어 없이 동작하는 것이 가능하며 이를 통해 웹 서버의 동작에 있어 더 많은 통제를 가능케 한다. <위키백과>
```

특징

- 단일 쓰레드 기반 비동기방식
  - 하나의 쓰레드가 request를 받으면 모든 처리가 완료될때까지 기다리다가 처리결과가 완료되면 다시 응답을 보냄
  - 기존 업무 처리가 완료되기 전에 또다른 request가 있으면 새로운 쓰레드가 업무를 처리함
  - 동시 request가 많은 경우 많은 쓰레드가 필요하게 되어 서버 과부하



장점

- 자바스크립트를 동일하게 사용해서 서버단 로직을 처리할 수 있다.
- 개발이 빠르고 쉽다.
- Non-blocking I/O와 단일 스레드 이벤트 루프를 통한 높은 처리 성능
- 로컬에서 서버만 켜봐도 얼마나 가볍게 돌아가는지 알 수 있다.
- 이벤트 기반 비동기방식이라 서버 무리가 적다.
- npm(node package manger) 을 통한 다양한 모듈 제공



단점

- 이벤트 기반 비동기방식이라 서버단 로직이 복잡한 경우 콜백함수의 늪에 빠질 수 있다. 
- 코드를 순차적으로 실행하는 것이 아니라 비동기 방식으로 이벤트를 보내고, 응답이 오면 처리하는 방식이기 때문에 java 개발을 했던 방식으로 설계하고 프로그래밍하면 큰 문제가 발생한다.
- 단일 쓰레드이기 떄문에 하나의 작업 자체가 많이 걸리는 웹서비스는 어울리지 않다.
- 코드가 수행되어야 코드에 에러가 있는지 알 수 있고, 에러가 날 경우 프로세스가 내려가기 떄문에 테스크가 엄청 중요하다.

