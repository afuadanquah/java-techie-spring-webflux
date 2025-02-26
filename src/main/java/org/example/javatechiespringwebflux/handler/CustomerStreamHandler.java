package org.example.javatechiespringwebflux.handler;

import org.example.javatechiespringwebflux.dao.CustomerDao;
import org.example.javatechiespringwebflux.dto.Customer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

@Service
public class CustomerStreamHandler {

    private CustomerDao customerDao;

    public CustomerStreamHandler(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    //Asynchronous and Non-blocking stream of data
    public Mono<ServerResponse> getCustmersStream(ServerRequest serverRequest) {
        Flux<Customer> allFlux = customerDao.getAllFlux();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM) //Without this line, the stream will not work
                .body(allFlux, Customer.class);
    }
}
