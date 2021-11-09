# 디자인 패턴 프로젝트



## 도커 기반 데이터베이스 설정

> Windows 기준

명령 프롬프트를 실행하고, 아래 명령어를 실행합니다.

```
$ docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=1q2w3e4r -d postgres
```

* 데이터베이스 정보
  * hostname : localhost
  * username : postgres
  * password : 123
  * database : postgres