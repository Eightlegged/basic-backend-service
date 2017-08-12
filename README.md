# Basic Back-End Service

Smart Meeting Assistant 어플리케이션의 Spring Boot 기반 Basic Back-End 서비스
* User Service
* Meeting Service

### 사용 프레임워크(런타임 및 버전 상세 필요)
* Spring-Boot 1.5.6
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

# API
## Sign up
### URI
HTTP|URI
---|---
POST|/user/add/

### Parameter
Parameter|Parameter명|Data Type
---|---|---
id|User ID|Long
email|User E-mail|String
userName|User Name|String
password|User Password|String

### Response
Case|Return
---|---
성공|{"result": "Success"}
실패|{"result": "Failure-Exist Email"}

## Log in
### URI
HTTP|URI
---|---
POST|/user/login/

### Parameter
Parameter|Parameter명|Data Type
---|---|---
email|User E-mail|String
password|User Password|String

### Response
Case|Return
---|---
성공|{"result": "Success"}
실패|{"result": "Failure-Unknown Email"}

## Add Meeting
### URI
HTTP|URI
---|---
POST|/meeting/add/

### Parameter
Parameter|Parameter명|Data Type
---|---|---
title|Meeting Title|String
comment|Meeting Subtitle(or Comment)|String
content|Meeting Content|String
date|Meeting Date|date(YYYY-MM-DD)
startTime|Start Time|Time(HH:MM)
status|Meeting Status|Status(WAIT or COMPLETE)
partName|Part Name|Partname(Architecture, Engineering, RnD or QA)
userList|User List|ArrayList<User>

ex)  
{  
	"title":"weekly1",  
	"comment":"weekly",  
	"content":"test123",  
	"date":"20170831",  
	"startTime":"10:00",  
	"status":"WAIT",  
	"partName":"Architecture",  
	"userList": 
	[  
		{  
			"userName": "Saeyoung"  
		},  
		{  
			"userName": "Faeyoung"  
		}  
	]  
}  
### Response
Case|Return
---|---
성공|{"result": "SUCCESS","MEETING_ID": "5"}


