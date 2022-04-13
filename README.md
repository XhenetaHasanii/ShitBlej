# ShitBlej

This is a sample Spring Boot application that uses the Controller-Service-Repository pattern. I have made it to practice my basic Spring Boot understanding.

The available entities are: Category, Advertisement and User.

The supported HTTP Operations are GET and POST.

This table shows the endpoint calls that can be made to the application and the values of the HTTP Responses:

| Endpoint      | HTTP Operation | Returns       |
| :---          |     :----:     |          ---: |
| /api/users        | POST          | Returns the created user   |
| /api/{id}     | GET           | Returns the user with the specified id      |
| /api/advertisement | POST | Returns the created advertisement |
| /api/advertisement/{id} | GET | Returns the advertisement with the specified id |
| /api/category/ | POST | Returns the created category|
| /api/category/{id} | GET | Returns the category with the specified id |
