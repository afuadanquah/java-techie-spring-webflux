package org.example.javatechiespringwebflux.dao;

import org.example.javatechiespringwebflux.dto.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao implements Dao<Customer> {

    private static void sleepExecution(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    @Override
    public List<Customer> getAll() {
        return IntStream.rangeClosed(1, 10)
                .peek(i -> sleepExecution())
                .peek(i -> System.out.println("process count: " + i))
                .mapToObj(i -> new Customer(i, "customer" + i))
                .collect(Collectors.toList());
    }



}
