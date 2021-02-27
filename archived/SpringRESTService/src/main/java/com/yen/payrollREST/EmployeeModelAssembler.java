package com.yen.payrollREST;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

    // All the code you saw earlier in the controller can be moved into this class. And by applying Spring Framework’s @Component, this component will be automatically created when the app starts.
    @Override
    // This simple interface has one method: toModel(). It is based on converting a non-model object (Employee) into a model-based object (EntityModel<Employee>).
    public EntityModel<Employee> toModel(Employee employee) {

        return EntityModel.of(employee, //
                linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    }
}