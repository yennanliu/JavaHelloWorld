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

# get all employees
curl -v localhost:8080/employees | json_pp

# get employee with id = 1 
curl -v localhost:8080/employees/1 | json_pp

# add new employee
curl -v -X POST localhost:8080/employees -H 'Content-Type:application/json' -d '{"name": "Samwise Gamgee", "role": "gardener"}'
```

### Progress
- 20201120
	- https://spring.io/guides/tutorials/rest/
	- `EmployeeNotFoundException.java`
	- next:
		- `EmployeeNotFoundAdvice.java`
- 20201123
	- new app : `/payrollREST`
	- next:
		- https://spring.io/guides/tutorials/rest/
		- EmployeeController (Injecting EmployeeModelAssembler into the controller)
- 20201129
	- next:
		- app : ``/payrollREST``
		- https://spring.io/guides/tutorials/rest/
		- That employee resource has now been updated and the location URI sent back. Finally, update the DELETE operation suitably:
		- `Handling DELETE requests`
- 20201201
	- next:
		- app : ``/payrollREST``
		- https://spring.io/guides/tutorials/rest/
		- Spring Data JPA’s JpaRepository base interface
		- ```java
		interface OrderRepository extends JpaRepository<Order, Long> {}
		```
		- inks/src/main/java/payroll/OrderController.java
-20201206
	- next:
		- app : ``/payrollREST``
		- https://spring.io/guides/tutorials/rest/
		- links/src/main/java/payroll/OrderModelAssembler.java

## SpringRESTService
- https://spring.io/guides/tutorials/rest/