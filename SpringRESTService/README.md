## SpringRESTService
- We tried to build the [payroll](https://github.com/yennanliu/JavaHelloWorld/tree/main/SpringRESTService/src/main/java/com/yen/payroll) as service V1, however it's not "RESTful enough" (meaning : lack some necessary feature as a RESTful service), so now we have the [payrollREST](https://github.com/yennanliu/JavaHelloWorld/tree/main/SpringRESTService/src/main/java/com/yen/payrollREST) as our service V2 as a RESTful one.

### Quick start
1. Create a "web" project via https://start.spring.io/
2. put the generated under /SpringRESTService
3. open the project (*/SpringRESTService/SpringWeb*) with Intellj
4. Run the project via Intellj or CLI : `./mvnw spring-boot:run`

### Build the project
```bash
mvn clean package
```
### Run : payroll
```bash
java -jar target/SpringREST-0.0.1-SNAPSHOT.jar
```
```bash
# 1) try the API : get the list of employees
curl -v localhost:8080/employees

# 2) query a not existing employee
curl -v localhost:8080/employees/99

# 3) add a new employee via http POST
curl -X POST localhost:8080/employees -H 'Content-type:application/json' -d '{"name": "Samwise Gamgee", "role": "gardener"}'

# 4) update the existing employee
curl -X PUT localhost:8080/employees/3 -H 'Content-type:application/json' -d '{"name": "Samwise Gamgee", "role": "ring bearer"}'

# 5) delete an existing employee
curl -X DELETE localhost:8080/employees/3
curl localhost:8080/employees/3

```

### Run : payrollREST
```bash
# The indicated part pipes the output to json_pp and asks it to make your JSON pretty. (Or use whatever tool you like!)
#                                  v------------------v
curl -v localhost:8080/employees/1 | json_pp
```

### Progress
- 20201120
	- https://spring.io/guides/tutorials/rest/
	- `EmployeeNotFoundException.java`
	- next:
		- `EmployeeNotFoundAdvice.java`

## SpringRESTService
- https://spring.io/guides/tutorials/rest/