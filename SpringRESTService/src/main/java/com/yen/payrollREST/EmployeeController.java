package com.yen.payrollREST;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

// @RestController indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
@RestController
class EmployeeController {

    // An EmployeeRepository is injected by constructor into the controller.
    private final EmployeeRepository repository;

    private final EmployeeModelAssembler assembler;

    EmployeeController(EmployeeRepository repository, EmployeeModelAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;
    }

    // We have routes for ehateoasach operations (@GetMapping, @PostMapping, @PutMapping and @DeleteMapping, corresponding to HTTP GET, POST, PUT, and DELETE calls). (NOTE: It’s useful to read each method and understand what they do.)

    // EmployeeNotFoundException is an exception used to indicate when an employee is looked up but not found.

    // Aggregate root
    @GetMapping("/employees")
    // CollectionModel<> is another Spring HATEOAS container aimed at encapsulating collections. It, too, also lets you include links. Don’t let that first statement slip by. What does "encapsulating collections" mean? Collections of employees?
    // Not quite.
    // Since we’re talking REST, it should encapsulate collections of employee resources.
    // That’s why you fetch all the employees, but then transform them into a list of EntityModel<Employee> objects. (Thanks Java 8 Stream API!)
    //    CollectionModel<EntityModel<Employee>> all() {
    //
    //        List<EntityModel<Employee>> employees = repository.findAll().stream()
    //                .map(employee -> EntityModel.of(employee,
    //                        // ***
    //                        // What is the point of adding all these links? It makes it possible to evolve REST services over time. Existing links can be maintained while new links are added in the future. Newer clients may take advantage of the new links, while legacy clients can sustain themselves on the old links. This is especially helpful if services get relocated and moved around. As long as the link structure is maintained, clients can STILL find and interact with things.
    //                        // ***
    //                        linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
    //                        linkTo(methodOn(EmployeeController.class).all()).withRel("employees")))
    //                .collect(Collectors.toList());
    //
    //        return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());

    //Applying the same thing in the aggregate root controller method is more impressive:
    //Getting aggregate root resource using the assembler
    // The code is, again, almost the same (as above), however you get to replace all that EntityModel<Employee> creation logic with map(assembler::toModel). Thanks to Java 8 method references, it’s super easy to plug it in and simplify your controller.
    CollectionModel<EntityModel<Employee>> all() {

        List<EntityModel<Employee>> employees = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());
    return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }

    //    @PostMapping("/employees")
    //    Employee newEmployee(@RequestBody Employee newEmployee) {
    //        return repository.save(newEmployee);
    //    }

    @PostMapping("/employees")
    ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee) {

        EntityModel<Employee> entityModel = assembler.toModel(repository.save(newEmployee));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    // Single item
    @GetMapping("/employees/{id}")
    EntityModel<Employee> one(@PathVariable Long id) {

        Employee employee = repository.findById(id) //
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        // The return type of the method has changed from Employee to EntityModel<Employee>. EntityModel<T> is a generic container from Spring HATEOAS that includes not only the data but a collection of links.
        //        return EntityModel.of(employee,
        //                // linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel() asks that Spring HATEOAS build a link to the EmployeeController 's one() method, and flag it as a self link.
        //                linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
        //                // linkTo(methodOn(EmployeeController.class).all()).withRel("employees") asks Spring HATEOAS to build a link to the aggregate root, all(), and call it "employees".
        //                linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));

        // This code is almost the same (as above), except instead of creating the EntityModel<Employee> instance here, you delegate it to the assembler. Maybe that doesn’t look like much?
        return assembler.toModel(employee);
    }

    //    @PutMapping("/employees/{id}")
    //    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
    //
    //        return repository.findById(id)
    //                .map(employee -> {
    //                    employee.setName(newEmployee.getName());
    //                    employee.setRole(newEmployee.getRole());
    //                    return repository.save(employee);
    //                })
    //                .orElseGet(() -> {
    //                    newEmployee.setId(id);
    //                    return repository.save(newEmployee);
    //                });
    //    }

    // The Employee object built from the save() operation is then wrapped using the EmployeeModelAssembler into an EntityModel<Employee> object. Using the getRequiredLink() method, you can retrieve the Link created by the EmployeeModelAssembler with a SELF rel. This method returns a Link which must be turned into a URI with the toUri method.
    @PutMapping("/employees/{id}")
    ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        Employee updatedEmployee = repository.findById(id) //
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                }) //
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });

        EntityModel<Employee> entityModel = assembler.toModel(updatedEmployee);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}