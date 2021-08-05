# L2-J3
A Simple CRUD RestApi designed using Spring boot and SpringDataJPA, The end-points have also been secured Spring Security's basic authentication and role based authorization

**STEPS TO SETUP**

1. Download the project

2. Import the project to IDE

3. Create a MySql Database with any name 

4. open "/src/main/java/app.properties" and

   -> set spring.datasource.url=your database url
   
   -> set spring.datasource.username=your database username
   
   -> set spring.datasource.password=your database password

**URL Mapping**

GET -> /students -> Get all student's data

GET -> /students/{id} -> Get student data with specific id 

POST -> /students -> Add new student 

PUT -> /students -> Update student

DELETE ->/students/{id} -> Delete student data wirh specific id



**Three Users are Aautomatically created**

"user1" and "user2" can only make GET Request -> /students   AND   /students/{id}
password : abcd1234

"admin" can access all Requests
password : admin

