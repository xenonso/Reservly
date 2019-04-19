# Reservly
Reservly is a tool for reserving game match queue

## Backend technology stack
* Scala
* Play Framework 2
* Slick
* PostgreSQL
* Swagger
* Websockets (Akka actors)
* Asana (Workflow planning)

## Frontend
Frontend repository available [here](https://github.com/mtrybus2208/game-reservation-app) 

![preview](https://user-images.githubusercontent.com/31374669/56235258-5c7c1d00-6087-11e9-87c4-cb3659d61fdb.png)

## How to run
#### Database
* Install [PostgreSQL](https://www.postgresql.org/download/)
* Create database 
  - Port: default
  - Database name: reservly
  - User: postgres
  - Password: root
* Database config can be changed in application.conf file
  
#### IntelliJ
* Install JDK11 ([openJDK](https://adoptopenjdk.net))
* Install scala support for IntelliJ
* Import project to IntelliJ (as SBT project)
* In IntelliJ: Edit Configurations -> Add New Configuration -> Play
* Use default config (with http://localhost:9000)
* Run project with created config

## Swagger docs
* Swagger docs available at `localhost:9000/docs/`
* Secured endpoints requests need to contain `Auth-Id` header with existing user id

## Models

### Player
```javascript
{ 
  "id": "1s4F",                       //[String: without whitespaces]
  "displayName": "John Smith",        //[String: size -> 2 to 100 letters]
  "email": "some@email.com",          //[String: valid email]
  "photoUrl": "www.test.com/1"        //[String: size -> 2 to 300 letters]
}
```

### Match
```javascript
{ 
  "id": "1",                           //[Long: autogenerated]
  "startDate": "2019-01-23T06:00",     //[java.sql.Timestamp: start date must be before end date]
  "endDate": "2019-01-23T06:15",       //[java.sql.Timestamp: end date must be after start date]
  "matchStatus": "RESERVED",           //[MatchStatus -> RESERVED, ENDED]
  "playerID": "1"                      //[String: existing player id]
}
```

### ChatMessage
```javascript
{ 
  "playerId": "11",             //[String]
  "message": "Some message"     //[String: size -> 3 to 100 letters]
}
```

### ResponseMessage
```javascript
{ 
  "httpCode": "404",             //[String: one of http codes]
  "message": "Not found"         //[String]
}
