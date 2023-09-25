# 프로젝트 정보

플레이 데이터 다섯 번째 미니 프로젝트

- **팀장**: 김준영
- **팀원**: 이승준, 이준희, 한신우
- **주제**: 물품 대여 사이트
- **컨셉**: 가치가 있는 물건들을 필요할 때만 서로 공유하는 서비스

## 프로젝트 기획

**경제적 이점** 

물건을 구매하지 않고 필요한 경우에만 대여하여 경제적 이점을 얻습니다. 

동시에 보유 중인 물건들이 방치되는 것이 아니라 활용되므로 자원의 낭비를 줄일 수 있습니다.

- 차용인: 시기나 개인 사정으로 현재 사용하지 못하는 제품 처리 곤란
- 대여인: 단기간 사용을 원해 구매를 원치 않지만, 필요함
    
    → 대여 서비스로 상부상조, 환경 보호
    

**환경 보호**

물건의 공유와 재사용은 자원 소모를 줄이고 지속 가능한 소비 문화를 유도합니다.

### 예상되는 문제 : 물품 훼손 , 절도, 대여기간 초과 등

→ 보증금 조정으로 일정 부분 보상 

## 개발 환경

- Front-End: Html + css, JavaScript, ,thymeleaf
- Back-End: Spring(boot), MariaDB, Java SE 11
- ORM: hibernate, spring data Jpa
- 빌드 도구: Maven
- 형상 관리: github/git
- OS: window
- IDE: IntelliJ
- etc: Lombok, Slf4j, notion

## 기술 스택

Spring Boot ,Maria DB, HTML, CSS, Javascript

## DB설계

<img width="562" alt="스크린샷 2023-09-25 111024" src="https://github.com/junheiLee/murang/assets/119035407/42abb375-b91f-400c-b8d0-67c54f83e5d6">

## API 설계

- **사용자 관련 API
    ◦ POST /users: 사용자 등록
    ◦ GET /users/{user_Id}: 특정 사용자 정보 조회
    ◦ PUT /users/{user_Id}: 특정 사용자 정보 수정
    ◦ DELETE /users/{user_Id}: 특정 사용자 정보 삭제**

- **물품 관련 API
    ◦ POST /articles: 물품 등록
    ◦ GET /articles: 모든 물품 목록 조회
    ◦ GET /articles/{article_Id}: 특정 물품 정보 조회
    ◦ PUT /articles/{article_Id}: 특정 물품 정보 수정
    ◦ DELETE /articles/{article_Id}: 특정 물품 삭제**

- **대여 관련 API
    ◦ POST /rental: 대여 신청
    ◦ GET /rental/{article_Id}: 대여 상태 확인**

## ****Architecture****

**클라이언트(Chrome)**

웹 브라우저를 통해 사용자들이 사이트에 접속하여 서비스를 이용합니다.

**서버(localhost)**

사용자들의 API 요청을 처리하고 데이터를 관리합니다.

**데이터베이스(MariaDB)**

사용자와 물건 정보, 거래 기록 등의 데이터를 안전하게 저장하여 필요한 경우에 사용됩니다.

## **어필하고 싶은 구현 내용**

**파일 저장 방식 최적화** 

파일 데이터를 직접 DB에 저장하지 않고 파일 경로만 DB에 저장함으로써 DB 용량을 절약하였습니다. 실제 파일은 서버의 static 폴더 안에 저장하여 관리가 용이하게 하였습니다.

**OneToMany 관계 업데이트 최적화** 

EntityManager 인터페이스와 영속성 컨텍스트를 활용하여 OneToMany 관계의 컬럼 리스트를 효율적으로 업데이트하였습니다.

**Dto와 Entity 간 통신 최적화**

Dto와 Entity 간의 데이터 전송을 쉽게 만들기 위해 생성자와 Factory 메서드를 사용하였습니다. 이렇게 하면 Controller와 View 사이에서 데이터 교환 작업이 단순화되며, 코드 재사용성과 유지보수성도 향상됩니다.

## 프로젝트 후 느낀 점

- 설계 과정에서 주제를 한 번 바꾸어 설계하는 데 시간이 많이 소요되었다.
- 외래키 사용이 얼마나 데이터베이스 용량을 줄일 수 있는지를 알게 되었다.
- 채팅 기능을 만들지 못하여 너무나도 아쉽다..
