# Chapter.7

---



## 7-1 표준 모듈

``` python
import 모듈 이름
```

-> 모듈 불러오기



from 구문

``` python
from 모듈 이름 import 가져오고 싶은 변수 또는 함수 # 기능,변수 뽑아오기
# from math import * -> math내부의 모든 것을 가져온다.
```

as 구문

``` python
import 모듈 as 사용하고 싶은 식별자 # 별명
```



### 사용자가 사용 할 수 있는 기본 모듈 

#### math 모듈

- sin(x) : 사인값을 구합니다.
- cos(x) : 코사인값을 구합니다.
- tan(x) : 탄젠트값을 구합니다.
- log(x[, base]) : 로그값을 구합니다.
- ceil(x) : 올림합니다.
- floor(x) : 내림합니다.



#### random 모듈

- random() : 0.0~1.0 사이의 float를 리턴
- uniform(min,max) : 지정한 범위 사이 float 리턴
- randrange(10) : 지정한 범위의 int 리턴
  - randrange(max) : 0~max
  - randrange(min, max) : min ~max
- choice(list) : 리스트 내부에 요소를 랜덤하게 선택
- shuffle(list) : 리스트의 요소들을 랜덤하게 섞음
- sample(list, k=<숫자>) : 리스트의 요소중에 k개를 뽑음



#### sys 모듈

- argv : 명령 매개변수 출력
- getwindowsversion() ,copyright, version : 컴퓨터 환경과 관련된 정보를 출력
- exit() : 프로그램을 강제로 종료



#### datetime 모듈

- year, month, day, hour, minute, second : 시각 출력
- strftime() : 시간을 형식에 맞춰 출력



#### time 모듈

- sleep() : 특정시간 동안 코드 정지

  

#### urilb 모듈

- urlopen("인터넷 주소") : 인터넷 주소 페이지를 읽는다.
  - read() -> 메인 페이지를 읽습니다.



## 7-2 외부 모듈

``` python
pip install 모듈 이름
```

-> 외부 모듈 다운로드 방법



### 외부 모듈의 종류

#### BeatifulSoup

-> 웹 페이지 분석 모듈

``` python
from urllib import request
from bs4 import BeatifulSoup

target = request.urlopen("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId= 108")

soup = BeautifulSoup(target, "html.parser")

for location in soup.select("location"):
    print("도시:",location.select_one("city").string)
    print("날씨:",location.select_one("wf").string)
    print("최저기온:",location.select_one("tmn").string)
    print("최고기온:",location.select_one("tmx").string)
    print()
```



#### Flask 모듈

``` python
from flask import Flask
from urllib import request
from bs4 import BeatifulSoup

app = Flask(__name__)
@app.route("/")

def hello():
    target = request.urlopen("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId= 108")
    
    soup = BeautifulSoup(target, "html.parser")
    
    output = ""
    forlocation in soup.select("location"):
        output += "<h3>{}</h3>".format(loaction.select_one("city").string)
        output += "날씨: {}<br/>".format(loaction.select_one("wf").string)
        output += "최저/최고 기온: {}/{}"\
        	.format(\
                   location.select_one("tmn").string,\
                   location.select_one("tmx").string\
            )
        output += "<hr/>"
    return output
```

=> flask 모듈과 beautifulsoup의 모듈을 합해서 웹서버를 만들어줌



### 라이브러리란?

- 개발자가 모듈의 기능을 호출하는 형태의 모듈

  => 예시 math함수

  

### 프레임워크란?

- 모듈이 개발자가 작성한 코드를 싱행하는 형태의 모듈 (제어 역전)

  => 예시 flask 모듈

  

### 데코레이터란?

- @로 시작하는 구문

- 꾸며 주는 것

``` python
def test(function):
    def wrapper():
        print("인사가 시작되었습니다.")
        function()
        print("인사가 종료되었습니다.")
    return wrapper

@test # @데코레이터를 붙여 함수를 만듬
def hello():
	print("hello")

hello()
#
인사가 시작되었습니다.
hello
인사가 종료되었습니다.
```