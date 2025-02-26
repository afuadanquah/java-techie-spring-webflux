package org.example.javatechiespringwebflux.handler;

import org.example.javatechiespringwebflux.dao.CustomerDao;
import org.example.javatechiespringwebflux.dto.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    private CustomerDao customerDao;

    public CustomerHandler(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Mono<ServerResponse> loadCustomers(ServerRequest serverRequest) {
        Flux<Customer> allFluxCustmerList = customerDao.getAllFluxCustmerList();
        return ServerResponse.ok().body(allFluxCustmerList, Customer.class);
    }

    public Mono<ServerResponse> findCustomer(ServerRequest serverRequest) {
        int customerId = Integer.valueOf(serverRequest.pathVariable("id"));
        Mono<Customer> customer = customerDao.getAllFluxCustmerList()
                .filter(cust -> cust.getId() == customerId)
                .next();
        return ServerResponse.ok().body(customer, Customer.class);
    }

    //Handler to save a single customer using POST method
    public Mono<ServerResponse> saveCustomer(ServerRequest serverRequest) {
    Mono<Customer> customerMono = serverRequest.bodyToMono(Customer.class);
    Mono<String> saveResponse = customerMono.map(resp -> "Customer Name: " + resp.getId() + ", Customer Name: " + resp.getName());
        return ServerResponse.ok().body(saveResponse, String.class);
    }
}
