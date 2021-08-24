package com.danit.springhomeworks.controller;

import com.danit.springhomeworks.HomeworkExceptions;
import com.danit.springhomeworks.entity.Customer;
import com.danit.springhomeworks.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public Customer createNewCustomer(@Valid @RequestBody Customer customer) {
        return customerService.createNewCustomer(customer);
    }

    @GetMapping("{id}")
    public Customer getOneCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id).orElseThrow(HomeworkExceptions::notFound);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOneCustomer(@PathVariable Long id) {
        boolean wasObjectDeleted = customerService.deleteCustomerById(id);
        HttpStatus status = wasObjectDeleted ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(status);
    }

    @PatchMapping
    public Customer updateExistCustomer(@Valid @RequestBody Customer customer) {
        customer.getId().flatMap(customerService::getCustomerById).orElseThrow(HomeworkExceptions::notFound);
        return customerService.updateExistsCustomer(customer);
    }
}
