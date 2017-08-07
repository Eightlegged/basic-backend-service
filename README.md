# Basic Back-End Service

Smart Meeting Assistant 어플리케이션의 Spring Boot 기반 Basic Back-End 서비스
* User Service
* Meeting Service

### 사용 프레임워크(런타임 및 버전 상세 필요)
* Spring-Boot 1.5.7
* Maven 4.0.0

### 프로젝트 구조
Spring Boot 기반의 프로젝트를 jar 파일로 패키징하여 PaaS상에 배포

### 사용 방법
해당 jar 파일이 있는 곳에서 
java -jar 파일명.jar
> 회원가입
>> localhost:8080/user/add\
>> JSON 포멧으로 POST\
>> {"id":"1", 	"email":"heehouse1@gmail.com", "userName":"Saeyoung","password":"test123" } \
> 로그인
>> localhost:8080/user/login\
>> JSON 포멧으로 POST

### 기능 (추 후 추가 가능)
> 회원서비스
>> 회원가입\
>> 로그인\
> 회의서비스
>> 회의생성\
>> 회의삭제\
>> 회의시작\
>> 회의종료

## API
### URI
HTTP|URI
---|---
POST|/user/add/{id}
POST|/user/login/{id}
