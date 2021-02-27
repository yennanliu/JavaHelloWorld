//package com.yen.payrollREST;
//
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import javax.swing.text.html.parser.Entity;
//import java.util.stream.Collectors;
//
//public class OrderController {
//    private final OrderRepository orderRepository;
//    private final OrderModelAssembler assembler;
//
//    OrderController(OrderController orderController, OrderModelAssembler assembler){
//        this.orderRepository = orderController;
//        this.assembler = assembler;
//    }
//
//    @GetMapping("/orders")
//    CollectionModel<EntityModel<Order>> all(){
//        List<EntityModel<Order>> orders =
//                orderRepository.findAll().stream()
//                .map(assembler::toModel)
//                .collect(Collectors.toList());
//
//        return CollectionModel.of(orders,
//                linkTo(methodOn(OrderController.class).all()).withSelfRel());
//    }
//
//    @GetMapping("/orders/{id}")
//    EntityModel<Order> one(@PathVariable Long id){
//
//        Order order = orderRepository.findById(id)
//                .orElseThrow( () -> new OrderNotFoundException(id));
//
//        return assembler.toModel(order);
//    }
//
//    @PostMapping("/orders")
//    ResponseEntity<EntityModel<Order>> newOrder(@RequestBody Order order)
//    {
//        order.setStatus(Status.IN_PROGRESS);
//        Order newOrder = orderRepository.save(order);
//
//        return ResponseEntity //
//                .created(linkTo(methodOn(OrderController.class).one(newOrder.getId())).toUri()) //
//                .body(assembler.toModel(newOrder));
//    }
//}
