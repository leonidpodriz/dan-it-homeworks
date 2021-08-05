package com.danit.springhomeworks;

import com.danit.springhomeworks.controller.CustomerController;
import com.danit.springhomeworks.entity.Account;
import com.danit.springhomeworks.entity.Currency;
import com.danit.springhomeworks.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class SpringHomeworksApplication {
    final CustomerController customerController;

    public static void main(String[] args) {
        SpringApplication.run(SpringHomeworksApplication.class, args);
    }


    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return customerController.getAll();
    }

    @PostMapping("/")
    public Customer createNewCustomer(@Valid @RequestBody Customer customer) {
        return customerController.create(customer);
    }

    @GetMapping("/{id}")
    public Optional<Customer> getOneCustomer(@PathVariable Long id) {
        return customerController.getById(id);
    }

    @DeleteMapping("/{id}")
    public Optional<Boolean> deleteOneCustomer(@PathVariable Long id) {
        return customerController.getById(id).map(customerController::delete);
    }

    @GetMapping("/{id}/accounts/")
    public Optional<List<Account>> getOneCustomerAccounts(@PathVariable Long id) {
        return customerController.getById(id).map(Customer::getAccounts);
    }

    @PostMapping("/{id}/accounts/")
    public Optional<Account> createOneCustomerAccounts(@RequestBody Currency currency, @PathVariable Long id) {
        return customerController.getById(id).map(customer -> customerController.createAccount(customer, currency));
    }

    @PatchMapping("/{id}/")
    public Customer createOneCustomerAccounts(@RequestBody Customer customer, @PathVariable Long id) {
        customer.setId(id);
        return customerController.update(customer);
    }
}
