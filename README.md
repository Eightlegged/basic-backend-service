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
성공|{"result": "SUCCESS","MEETING_ID": "1"}
실패|{"result": "FAIL","reason": "EMAIL & Name Already Used"}

  
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
성공|{"result": "SUCCESS"}

  
## Add Meeting
### URI
HTTP|URI
---|---
POST|/meeting/add/

### Parameter
Parameter|Parameter명|Data Type
---|---|---
title|Meeting Title|String
comment|Meeting Object|String
content|Meeting Content|String
date|Meeting Date|date(YYYY-MM-DD)
startTime|Start Time|Time(HH:MM)
status|Meeting Status|Status(WAIT or COMPLETE)
partName|Part Name|Partname(Architecture, Engineering, RnD or QA)
userList|User List|ArrayList<User>

ex)  
{"title":"weekly1", "comment":"weekly","content":"test123","date":"20170831","startTime":"10:00",    
"status":"WAIT","partName":"Architecture","userList": [{"userName": "Saeyoung"},{"userName": "Faeyoung"}]}  

### Response
Case|Return
---|---
성공|{"result": "SUCCESS","MEETING_ID": "5"}

  
## Get Meeting List(Meeting Status:WAIT)
### URI
HTTP|URI
---|---
POST|/meeting/

### Response
Case|Return
---|---
성공|ArrayList<Meeting>

ex)
[
    {
        "id": 1,
        "title": "weekly1",
        "comment": "weekly",
        "content": "test123",
        "date": "1970-01-01",
        "startTime": "10:00:00",
        "endTime": null,
        "userList": [
            {
                "id": 1,
                "email": "heehouse1@gmail.com",
                "userName": "Saeyoung",
                "password": "test123",
                "role": "USER",
                "name": "Saeyoung"
            },
            {
                "id": 2,
                "email": "heehouse2@gmail.com",
                "userName": "Faeyoung",
                "password": "test123",
                "role": "USER",
                "name": "Faeyoung"
            }
        ],
        "status": "WAIT",
        "partName": "Architecture"
    }
}

  
## Get Meeting List(Meeting Status:COMPLETE)
### URI
HTTP|URI
---|---
POST|/meeting/end/

### Response
Case|Return
---|---
성공|ArrayList<Meeting>

  
## Start Meeting
### URI
HTTP|URI
---|---
POST/meeting/start/{id}

### Parameter(PathVariable)
Parameter|Parameter명|Data Type
---|---|---
id|Meeting id|Long

### Response
Case|Return
---|---
성공|{"result": "START", "MEETING_STATUS":"START"}

  
## End Meeting
### URI
HTTP|URI
---|---
POST/meeting/end/{id}

### Parameter(PathVariable)
Parameter|Parameter명|Data Type
---|---|---
id|Meeting id|Long

### Response
Case|Return
---|---
성공|{"result": "FINISHED", "MEETING_STATUS":"COMPLETE"}

  
## Delete Meeting
### URI
HTTP|URI
---|---
POST/meeting/delete/{id}

### Parameter(PathVariable)
Parameter|Parameter명|Data Type
---|---|---
id|Meeting id|Long

### Response
Case|Return
---|---
성공|{"result": "DELETED", "MEETING_STATUS":"DELETE"}

  
## Get Part Meeting List
### URI
HTTP|URI
---|---
POST|/meeting/{id}

### Parameter(PathVariable)
Parameter|Parameter명|Data Type
---|---|---
id|Part id(1: Architecture, 2: Engineering, 3: RnD, 4: QA)|Long

### Response
Case|Return
---|---
성공|ArrayList<Meeting>

