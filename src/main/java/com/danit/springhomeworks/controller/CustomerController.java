package com.danit.springhomeworks.controller;

import com.danit.springhomeworks.dao.AccountDao;
import com.danit.springhomeworks.dao.CustomerDao;
import com.danit.springhomeworks.entity.Account;
import com.danit.springhomeworks.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final AccountDao accountDao;
    private final CustomerDao customerDao;

    private Customer getCustomer(Long id) {
        return customerDao.getOne(id).orElseThrow(this::notFound);
    }

    private void linkCustomerAndAccount(Customer customer, Account account) {
        account.setCustomer(customer);
        customer.getAccounts().add(account);
    }

    private ResponseStatusException notFound() {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    @PostMapping
    public Customer createNewCustomer(@Valid @RequestBody Customer customer) {
        return customerDao.save(customer);
    }

    @GetMapping("{id}")
    public Customer getOneCustomer(@PathVariable Long id) {
        return getCustomer(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOneCustomer(@PathVariable Long id) {
        boolean isSuccessful = customerDao.delete(customerDao.getOne(id).orElseThrow(this::notFound));
        return new ResponseEntity<>(isSuccessful ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);

    }

    @PostMapping("{id}/accounts")
    public Account createOneCustomerAccounts(@PathVariable Long id, @RequestBody Account account) {
        linkCustomerAndAccount(getCustomer(id), account);
        return accountDao.save(account);
    }
}
