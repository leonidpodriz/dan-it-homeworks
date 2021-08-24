package com.danit.springhomeworks.service;

import com.danit.springhomeworks.dao.AccountDao;
import com.danit.springhomeworks.dao.CustomerDao;
import com.danit.springhomeworks.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    final CustomerDao customerDao;
    final AccountDao accountDao;

    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerDao.getOne(id);
    }

    public boolean deleteCustomerById(Long id) {
        return customerDao.deleteById(id);
    }

    public Customer createNewCustomer(Customer customer) {
        customer.setId(null);
        return customerDao.save(customer);
    }

    public Customer updateExistsCustomer(Customer customer) {
        assert customer.getId().isPresent();

        return customerDao.save(customer);
    }
}
