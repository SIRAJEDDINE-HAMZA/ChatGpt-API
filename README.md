# ChatGPT API used with Java & Spring encapsulated in docker

## How to get it running
* Clone this GIT project.
* Make sure it is a Maven project and Maven is executed to load dependencies.
* Create an Account at https://openai.com & log in
* Create API key at https://beta.openai.com/account/api-keys
* Store the key in application.properties file in cloned project.
* build docker image :  docker build . -t chatgpt 
* build docker container : docker-compose build
* run docker container : docker-compose up -d
* For chatting with ChatGPT: http://localhost:8080/
* Using interface : 
![front end](https://user-images.githubusercontent.com/86418817/214862129-1367b425-f206-4feb-b440-265f707abad3.png)

## More information
* OpenAI API documentation: https://beta.openai.com/docs/api-reference/completions/create
* Spring Boot documentation; https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
* Docker documentation: https://docs.docker.com/reference/
# ChatGpt-API

