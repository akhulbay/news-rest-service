# news-rest-service

***News REST Service*** is a service for stroring, processing and displaying news.

My REST services utilize JWT (JSON Web Tokens) for security purposes. JWT is a technology that provides authentication and authorization mechanisms for API endpoints. By using JWT, my services can ensure secure communication and access control.

After registration or authorization, the user receives a token, using which he can access the application
______

## Description of endpoints 

### Authorization (click to see description):

<details>
 <summary><code>POST</code> <code>(does authorization by email and password)</code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | request body |  required | object (JSON)   | request body consist of email (string) and password (string)  |


##### Example cURL

> ```javascript
> curl -X 'POST' \
>  'http://localhost:8080/api/v1/auth/authenticate' \
>  -H 'accept: */*' \
>  -H 'Content-Type: application/json' \
>  -d '{
>  "email": "test@gmail.com",
>  "password": "1234"
> }'
> ```

</details>

<details>
 <summary><code>POST</code> <code>(registers the user in the system)</code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | request body |  required | object (JSON)   | request body consist of firstname (string), lastname (string), email (string) and password (string)  |


##### Example cURL

> ```javascript
> curl -X 'POST' \
>  'http://localhost:8080/api/v1/auth/register' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA' \
>  -H 'Content-Type: application/json' \
>  -d '{
>  "firstname": "string",
>  "lastname": "string",
>  "email": "string",
>  "password": "string"
> }'
> ```

</details>


### News:

<details>
 <summary><code>GET</code> <code><b>/{id}</b></code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | id      |  required | integer   | The existing id in database  |


##### Example cURL

> ```javascript
> curl -X 'GET' \
>  'http://localhost:8080/api/v1/news/1' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA'
> ```

</details>

<details>
 <summary><code>PUT</code> <code><b>/{id}</b></code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | id      |  required | integer   | The existing id in database  |
> | news      |  required | object (JSON)   | news consist of title, content, publish date, source id and topic id.  |


##### Example cURL

> ```javascript
> curl -X 'PUT' \
>  'http://localhost:8080/api/v1/news/2?title=string&content=string&publishDate=2023-05-16&sourceId=1&topicId=1' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA'
> ```

</details>

<details>
 <summary><code>DELETE</code> <code><b>/{id}</b></code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | id      |  required | integer   | The existing id in database  |


##### Example cURL

> ```javascript
> curl -X 'DELETE' \
>  'http://localhost:8080/api/v1/news/2' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA'
> ```

</details>

<details>
 <summary><code>GET</code> <code>(uses dynamical filter and pagination)</code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | filter      |  required | object (JSON)   | filter consist of source id (int) and topic id (int). Both of them can be null because it's a dynamic filter.  |
> | pageable      |  required | object (JSON)   | pageable consist of page (int), size (int) and sort (string). User have to define page and size, while sort can be null.   |


##### Example cURL

> ```javascript
> curl -X 'GET' \
>  'http://localhost:8080/api/v1/news?sourceId=&topicId=&page=0&size=1&sort=' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA'
> ```

</details>

<details>
 <summary><code>POST</code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | news      |  required | object (JSON)   | news consist of title (string), content (string), publish date (string), source id (int) and topic id (int).  |


##### Example cURL

> ```javascript
> curl -X 'POST' \
>  'http://localhost:8080/api/v1/news?title=string&content=string&publishDate=2023-05-16&sourceId=1&topicId=1' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA' \
>  -d ''
> ```

</details>

### News Source:

<details>
 <summary><code>GET</code> <code><b>/{id}</b></code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | id      |  required | integer   | The existing id in database  |


##### Example cURL

> ```javascript
> curl -X 'GET' \
>  'http://localhost:8080/api/v1/news-source/1?name=string' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA'
> ```

</details>

<details>
 <summary><code>PUT</code> <code><b>/{id}</b></code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | id      |  required | integer   | The existing id in database  |
> | name      |  required | string   | N/A  |


##### Example cURL

> ```javascript
> curl -X 'PUT' \
>  'http://localhost:8080/api/v1/news-source/1?name=string' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA'
> ```

</details>

<details>
 <summary><code>DELETE</code> <code><b>/{id}</b></code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | id      |  required | integer   | The existing id in database  |


##### Example cURL

> ```javascript
> curl -X 'DELETE' \
>  'http://localhost:8080/api/v1/news-source/1' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA'
> ```

</details>

<details>
 <summary><code>GET</code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|


##### Example cURL

> ```javascript
> curl -X 'GET' \
>  'http://localhost:8080/api/v1/news-source/' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA'
> ```

</details>

<details>
 <summary><code>POST</code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|



##### Example cURL

> ```javascript
> curl -X 'POST' \
>  'http://localhost:8080/api/v1/news-source?name=string' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA' \
>  -d ''
> ```

</details>

### News Topic:

<details>
 <summary><code>GET</code> <code><b>/{id}</b></code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | id      |  required | integer   | The existing id in database  |


##### Example cURL

> ```javascript
> curl -X 'GET' \
>  'http://localhost:8080/api/v1/news-topic/1?name=string' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA'
> ```

</details>

<details>
 <summary><code>PUT</code> <code><b>/{id}</b></code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | id      |  required | integer   | The existing id in database  |
> | name      |  required | string   | N/A  |


##### Example cURL

> ```javascript
> curl -X 'PUT' \
>  'http://localhost:8080/api/v1/news-topic/1?name=string' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA'
> ```

</details>

<details>
 <summary><code>DELETE</code> <code><b>/{id}</b></code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|
> | id      |  required | integer   | The existing id in database  |


##### Example cURL

> ```javascript
> curl -X 'DELETE' \
>  'http://localhost:8080/api/v1/news-topic/1' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA'
> ```

</details>

<details>
 <summary><code>GET</code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|


##### Example cURL

> ```javascript
> curl -X 'GET' \
>  'http://localhost:8080/api/v1/news-topic/' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA'
> ```

</details>

<details>
 <summary><code>POST</code></summary>

##### Parameters

> | name      |  type     | data type               | description                                                           |
> |-----------|-----------|-------------------------|-----------------------------------------------------------------------|



##### Example cURL

> ```javascript
> curl -X 'POST' \
>  'http://localhost:8080/api/v1/news-topic?name=string' \
>  -H 'accept: */*' \
>  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImlhdCI6MTY4NDI0NjUwOCwiZXhwIjoxNjg0MzMyOTA4fQ.aOZUN2t4JhpldKyl1-UDKbuO9vMTK3pyZMGKn_-E1kA' \
>  -d ''
> ```

</details>


______

## Architecture
The application was designed according to the MVC pattern.

#### Model:

To create a database, I used ***PostgreSQL DBMS***. To interact with it, the capabilities of ***Hibernate ORM*** were used.

The application has 3 main tables. News, News source and News Topic. News is linked to News source and News topic via foreign key.
Also, there is a User table for storing user data during registration.

![database-diagram](https://github.com/akhulbay/news-rest-service/assets/117244670/c3c7305f-7112-44fc-934b-aa3a5b1f59af)



To implement the Repository level, a ready-made implementation of the ***JpaRepository*** interface was used. And its functionality satisfied most of the requests. But to implement dynamic filters and pagination for news, I also used the ***JpaSpecificationExecutor*** interface and the ***Criteria API***.

#### Controller:

At the controller level GET, PUT, POST, DELETE requests were implemented for News, News source, News topic.

______

## Testing
To test this REST service, I used ***Swagger***, which automatically generates an html page with all requests.
![swagger-ui](https://github.com/akhulbay/news-rest-service/assets/117244670/3764a6c5-d625-4194-b202-df68d29e4fc6)

_______

## Notes 

For the news controller, it was necessary to create several GET requests with source_id and topic_id and there should be pagination. I combined all these queries into one by making a dynamic filter and adding pagination.

_______

## Statistical Task

Every day at midnight, the system will make a statistical report. It is the amount of news for each source. If this is the first launch, the system will create the file itself, and if the file already exists, it will simply add records with the time indication there.
