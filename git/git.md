# Git/GitHub 세미나 (9/17,9/24)

#### git 이란? 

- git 은 버전 관리 시스템중 가장 유명한 프로그램
  - github,gitlab,bitbucket은 git의 데이터를 저장하는 서버

- 컴퓨터 파일의 변경사항을 추적하고 여러 명의 사용자들 간에 해당 파일들의 작업을 조율하기 위한 분산 버전 관리 시스템.
- github는 웹 상에 소스 코드를 올려 어려명이 공유 하는 장소
- 버전에 따라 코드를 수정할 필요성이 있고, 파일을 백업해서 관리하기 위해 필요함
  - 서버와 개인이 서로 파일을 가지고 문제가 생기면 서로 백업하는 형식

#### github 계정

---

username : heeyoungs

email : 20171693@edu.hanbat.ac.kr

password : lim9605!

---

#### gitignore

- 깃에 올라가면 안되는, 올라가지 않아도 되는 파일들을 설정 해줌
- windows,vscode,linux 등이 있음

#### git 의 파일 관리 방법

- Modified : 파일을 수정하고 아무것도 하지 않은 상태
- Staged : 수정한 파일을 Staging area에 올린 상태
- Commited : Staging area의 데이터가 로컬 데이터베이스에 저장된 상태

#### 초기 설정

- SSH = Secure Shell Protocol, 의 약자로 컴퓨터와 컴퓨터가 인터넷과 같은 Public Network를 통해 서로 통신을 할 때 보안적으로 안전하게 통신하기 위해 사용하는 프로토콜
  - 매번 로그인 하는 상황을 없애줌

- 인증키 생성방법

```bash
ssh -ed25519 -C "comment"
```

- -C 는 코멘트를 남기는 플래그

---



# git 명령어

#### help 

- ``` bash
  git help "명령어"
  ```

  명령어에 대한 정보를 인터넷에서 찾아줌

#### init

- ```bash
  git init
  ```

  새로운 local repsoitory 생성

#### stage

- ```bash
  git status
  ```

  스테이지에 올라간 파일들을 확인

- ``` bash
  git stage "파일 이름"
  ```

​       스테이지에 파일을 올리기

- ``` bash
  git add .
  ```

  스테이지에 파일을 모두 올리기

#### commit 

- ``` bash
  git commit -m "이름"
  ```

  스테이지에 등록된 파일들을 커밋한다

- ``` bash
  git log
  ```

  커밋된 파일들을 순서대로 나열 해 준다

- ``` bash
  git discard
  ```

  커밋되지 않은 파일들을 수정 전으로 되돌려 준다

#### back

- ``` bash
  git revert "6글자"
  ```

  새로운 버전을 생성하고 이전 버전을 유지하면서 되돌린다

- ``` bash
  git reset "6글자"
  ```

  이전 버전들을 모두 삭제하면서 되돌린다

#### branch

- ``` bash
  git branch "이름"
  ```

  브렌치 생성

- ``` bash
  git branch -a
  ```

  생성된 모든 브렌치 목록 보기

- ``` bash
  git branch -D "이름"
  ```

  브렌치 삭제

#### checkout

- ``` bash
  git checkout "이름"
  ```

  브렌치 이동

- ``` bash
  git checkout master
  ```

  메인 브렌치로 이동

- ``` bash
  git checkout -b "이름"
  ```

  브렌치 생성하고 그 브렌치로 이동

#### merge

- ``` bash
  git merge "변화를 가져올 브렌치"
  ```

  현재 브렌치와 변화를 가져올 브렌치를 병합

- ``` bash
  git reset -merge
  ```

  병합 취소

---



# Github 와 연동

원격 레파지토리 주소 : git@github.com:깃헙이름/파일이름.git

ex)) git@github.com:heeyoungs/StudyFile.git

#### push 

- ``` bash 
  git remote -v 
  ```

  원격 이름을 확인 

- ``` bash 
  git remote add "원격명" "주소"
  ```

  원격 저장소 추가

- ``` bash
  git remote rename "원격명" "새이름"
  ```

  원격 이름을 변경

- ``` bash
  git push "원격명" "브렌치이름"
  ```

  github에 파일을 올림

- ``` bash
  git push -d "원격명" "브렌치이름"
  ```

  원격 브렌치 삭제

#### pull

- ``` bash
  git clone "주소"
  ```

  원격 저장소의 파일을 컴퓨터에 다운받기

- ``` bash
  git fetch
  ```

  github 파일을 현 상태로 최신화

- ``` bash
  git pull "원격명" "브렌치이름"
  ```

  github 파일을 받아옴

