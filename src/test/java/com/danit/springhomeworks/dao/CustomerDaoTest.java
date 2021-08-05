package com.danit.springhomeworks.dao;

import com.danit.springhomeworks.entity.Customer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoTest {

    @Test
    void testWholeCustomerDao() {
        CustomerDao customerDao = new CustomerDao();
        Customer customer1 = new Customer("no name", "noname@noname.noname", 30);
        Customer customer2 = new Customer("no name", "noname@noname.noname", 30);

        customerDao.saveAll(Arrays.asList(customer1, customer2));
        assertEquals(customer1, customerDao.getOne(1L));
        assertEquals(customer2, customerDao.getOne(2L));

        assertEquals(2, customerDao.findAll().size());

        assertTrue(customerDao.deleteById(1L));
        assertEquals(1, customerDao.findAll().size());

        customerDao.deleteAll(Collections.singletonList(customer2));
        assertEquals(0, customerDao.findAll().size());
    }

}