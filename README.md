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

## Models

### Player
```javascript
{ 
  "id": "1"                     //[Long: autogenerated]
  "firstName": "John"           //[String: size -> 2 to 60 letters]
  "lastName": "Smith"           //[String: size -> 2 to 60 letters]
}
```

### Match
```javascript
{ 
  "id": "1"                     //[Long: autogenerated]
  "startDate": "John"           //[java.sql.Timestamp: start date must be before end date]
  "endDate": "Smith"            //[java.sql.Timestamp: end date must be after start date]
  "playerID": "1"               //[Long: existing player id]
}
```

### ChatMessage
```javascript
{ 
  "message": "Some message"     //[String: size -> 3 to 100 letters]
}
```

### ErrorMessage
```javascript
{ 
  "httpCode": "404"             //[String: one of http codes]
  "message": "Not found"        //[String]
}
