# ShitBlej

This is a sample Spring Boot application that uses the Controller-Service-Repository pattern. I have made it to practice my basic Spring Boot understanding.

The available entities are: Category, Advertisement and User.

The supported HTTP Operations are GET and POST.

In order to make the endpoint calls you can use Postman : https://www.postman.com/downloads/

This table shows the endpoint calls that can be made to the application and the values of the HTTP Responses:

| Endpoint      | HTTP Operation | Returns       |
| :---          |     :----:     |          ---: |
| /api/users        | POST          | Returns the created user   |
| /api/{id}     | GET           | Returns the user with the specified id      |
| /api/advertisement | POST | Returns the created advertisement |
| /api/advertisement/{id} | GET | Returns the advertisement with the specified id |
| /api/categories | POST | Returns the created category|
| /api/categories/{id} | GET | Returns the category with the specified id |
