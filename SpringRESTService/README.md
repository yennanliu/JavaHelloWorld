## SpringRESTService

### Quick start
1. Create a "web" project via https://start.spring.io/
2. put the generated under /SpringRESTService
3. open the project (*/SpringRESTService/SpringWeb*) with Intellj
4. Run the project via Intellj or CLI : `./mvnw spring-boot:run`

### Build the project
```bash
mvn clean package
```
### Run
```bash
java -jar target/SpringREST-0.0.1-SNAPSHOT.jar
```
```bash
# try the API 
curl -v localhost:8080/employees
# try the API : what if query a not existing employee
curl -v localhost:8080/employees/99
# add a new employee via http POST
curl -X POST localhost:8080/employees -H 'Content-type:application/json' -d '{"name": "Samwise Gamgee", "role": "gardener"}'
```

### Progress
- 20201120
	- https://spring.io/guides/tutorials/rest/
	- `EmployeeNotFoundException.java`
	- next:
		- `EmployeeNotFoundAdvice.java`

## SpringRESTService
- https://spring.io/guides/tutorials/rest/