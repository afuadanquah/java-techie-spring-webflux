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

}
