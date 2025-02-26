package org.example.javatechiespringwebflux.dao;

import org.example.javatechiespringwebflux.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
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

    public Flux<Customer> getAllFlux() {

        return Flux.range(1, 10)
//                .doOnNext(i -> sleepExecution())
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("process count: " + i))
                .map(i -> new Customer(i, "customer" + i));
    }

    public Flux<Customer> getAllFluxCustmerList() {

        return Flux.range(1, 10)
                .doOnNext(i -> System.out.println("process count: " + i))
                .map(i -> new Customer(i, "customer" + i));
    }


}
