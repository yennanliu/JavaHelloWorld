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
# hit the API endpoint
curl -v localhost:8080/employees
```

### Progress
- 20201120
	- https://spring.io/guides/tutorials/rest/
	- `EmployeeNotFoundException.java`
	- next:
		- `EmployeeNotFoundAdvice.java`

## SpringRESTService
- https://spring.io/guides/tutorials/rest/