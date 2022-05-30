Laboratorul 11
-

Compulsory
-
- [X] Create a Spring Boot project containing the REST services for comunicating with the database.
- [X] Create a REST controller containing methods for:
  - [X] obtaining the list of the persons, via a HTTP GET request.
  - [X] adding a new person, via a HTTP POST request.
  - [X] modifying the name of a person, via a HTTP PUT request.
  - [X] deleting a person, via a HTTP DELETE request.
- [X] Test your services using:
  - [X] the browser
  - [X] Postman

Homework
-
- [X] Create REST services for inserting and reading relationships.
- [X] Create a service for determining the first k most popular persons in the network.
- [X] Create a simple client application that invokes the services above, using the support offered by Spring Boot.
- [X] Document your services using Swagger or a similar tool.
- [ ] (+1p) Secure your services using the HTTPS protocol and JSON Web Tokens

Bonus
-
- [ ] Write a service that determines in linear time all persons who are so important to the social network such that, if one of them were eliminated, the network would become disconnected.
- [ ] Create a simple desktop application that sends multiple concurrent invocations to the service above, in order to determine how many API requests per minute your service can handle.
- [ ] You may also monitor other performance metrics, using your own implementation or Spring support.
