# ChatGPT API used with Java & Spring encapsulated in docker

## How to get it running
* Clone this GIT project.
* Make sure it is a Maven project and Maven is executed to load dependencies.
* Create an Account at https://openai.com & log in
* Create API key at https://beta.openai.com/account/api-keys
* Store the key in application.properties file in cloned project.
* build the chatgpt docker image  :  docker build . -t chatgpt 
* build the docker container : docker-compose build
* start the docker container : docker-compose up -d 
* For chatting with ChatGPT: http://localhost:8080/

* Using interface :

  ![front end](https://user-images.githubusercontent.com/86418817/214862129-1367b425-f206-4feb-b440-265f707abad3.png)

* Response stored in a csv file in the docker volume /chatgpt/data/response.csv
  
  ![Response](https://user-images.githubusercontent.com/86418817/214863952-edd1c439-d5ff-4593-9f62-9ee79da472e9.png)

## Project structure

![image](https://user-images.githubusercontent.com/86418817/214864958-c568c831-6015-43a6-befe-fd6954c79b4d.png)

# ChatGptController

This is a Spring Boot application that allows users to communicate with OpenAI's GPT-3 API through a web interface. The application accepts user input through a form and sends the input to the GPT-3 API to generate a response. The response, along with the user's input, is then displayed on the web page. Additionally, the application also writes the user's input and the corresponding response to a CSV file. The CSV file is stored in a volume, which allows for the data to persist even if the container is deleted. This application uses the OpenAI API client library to communicate with the API and Jackson for JSON serialization and deserialization.

# ChatGptCSVWriter

a service class in a Spring Boot application that writes the responses from the OpenAI ChatGPT API to a CSV file. The class is annotated with @Service indicating it is a service class in the application. The write method takes in a ChatGPTResponse object as a parameter and uses a FileWriter to write the response to a CSV file located at /chatgpt/data/response.csv. The method writes the question and the answer in the following format:
{
 "question" : "question",
 "answer": "answer"
 }

# ChatGPTRequest

This class represents a ChatGPT request object, which contains a single field "question" that holds the question/prompt to be sent to the ChatGPT API. The class also includes getter and setter methods for the question field, as well as a constructor to create a ChatGPTRequest object with a specified question. This class can be used to easily create and manage ChatGPT requests in your application.

# ChatGPTResponse

This class defines a simple data structure to hold the information of a conversation between a user and the OpenAI ChatGPT API. It contains two fields, one for the question asked by the user and another for the answer provided by the API. The class also provides getters and setters for both fields to access the data.

# CompletionRequest

This is the CompletionRequest class, it's used to make a request to the OpenAI API to generate a response using GPT-3. It contains the fields "model", "prompt", "temperature" and "max_tokens", which are used as parameters in the API request. The defaultWith method is used to set default values for these fields when a new instance of the class is created, making it easier to create requests with commonly used values.

# CompletionResponse

The "CompletionResponse" class is a record that has two fields, "usage" and "choices", that are used to store information about the completion of a prompt using the OpenAI API. The class also has a method "firstAnswer()" which returns the first answer from the choices list if it's present, otherwise it returns an empty Optional. The "Usage" and "Choice" records are nested within the "CompletionResponse" record and store additional information about the completion response.

# OpenAiApiClient 

This is a Java component class for making API requests to the OpenAI platform. It utilizes the HttpClient library to make a post request to the desired OpenAI service endpoint, such as the GPT-3 API. The class uses the @Value annotation to inject the API key for the OpenAI platform from a properties file, and also uses an enumeration to select the appropriate service endpoint URI, This allows for easy addition of new OpenAI APIs in the future.

## More information
* OpenAI API documentation: https://beta.openai.com/docs/api-reference/completions/create
* Spring Boot documentation; https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
* Docker documentation: https://docs.docker.com/reference/
