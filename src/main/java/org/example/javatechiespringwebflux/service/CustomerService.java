package org.example.javatechiespringwebflux.service;

import org.example.javatechiespringwebflux.dao.CustomerDao;
import org.example.javatechiespringwebflux.dto.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers(){

        Long startTime = System.currentTimeMillis();
        List<Customer> customers = customerDao.getAll();
        Long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime) + "ms");
        return customers;
    }
}
