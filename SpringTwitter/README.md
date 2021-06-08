# SpringTwitter

### Endpoints 
- http://localhost:8080/
- http://localhost:8080/twitter
- http://localhost:8080/api/v1/?search=jpop
- http://localhost:8080/api/v2/?search=jpop

- http://localhost:8080/api/v1/<search_word>
- http://localhost:8080/api/v1/users

- http://localhost:8080/test1
- http://localhost:8080/test2
- http://localhost:8080/test3


### API examples
```bash
# V1
http://localhost:8080/api/v1/?search=jpop

# V2
http://localhost:8080/api/v2/?search=jpop
```

```bash
# dev examples
curl -X GET http://localhost:8080/api/users

curl -X POST http://localhost:8080/api/users -F 'email=test@gmail.com' -F 'bisthDate=2021-01-01'

curl -d "email=test@gmail.com&bisthDate=2021-01-01" -X POST http://localhost:8080/api/users

```

### Ref
- Project Example code
	- https://github.com/Mastering-Spring-MVC-4/mastering-spring-mvc4
- Curl perform HTTP calls
	- https://www.educative.io/edpresso/how-to-perform-a-post-request-using-curl