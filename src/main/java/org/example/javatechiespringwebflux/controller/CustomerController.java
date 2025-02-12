package org.example.javatechiespringwebflux.controller;

import org.example.javatechiespringwebflux.dto.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.javatechiespringwebflux.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    private List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
