# DROPWIZARD TASK

## General Information
This project is created as coding exercise 

### GitHub Link:
https://github.com/oraibEdghaim/dropwizard-demo

## Language,main libraries  and technologies
This web application was created by intelliji using maven with these specifications.

 - dropwizard framework
 - hikariCp
 - DBUtils
 - MySql server

## How to install the project and deply it in localhost 

1- download the project

2- in your ID import the project as maven project

3- define JVM argument to define the app config file, for our project pass "server DBConfiguration.yml"

4- configure DB property file: 
   - path : /src/main/resources/DBConfiguration.yml
   - db should has at least one table called brand with two columns (id(pk) int , name varchar)

5- update maven project

6- Run the application

7- in your browser, hit "http://localhost:8080/{endpoint} " and to check the heathcheck hit http://localhost:8081/healthcheck

8- requests collection link : https://www.postman.com/collections/c8f3c5128560b1486887
