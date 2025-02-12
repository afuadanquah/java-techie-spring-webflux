package org.example.javatechiespringwebflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class JavaTechieSpringWebfluxApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testMonoComplete(){

        Mono<String> mono = Mono.just("Hello").log();
        mono.subscribe(System.out::println);
    }

    @Test
    public void testMonoError(){

        Mono<?> mono = Mono.just("Hello")
                .then(Mono.error(new RuntimeException("Error Message")))
                .log();
        mono.subscribe(System.out::println, System.err::println);
    }

    @Test
    public void testFluxComplete(){
        Flux<String> flux = Flux.just("Hello", "Afua", "How", "Are", "You")
                .concatWithValues("?")
                .log();
        flux.subscribe(System.out::println);
    }

    @Test
    public void testFluxError(){
        Flux<String> flux = Flux.just("Hello", "Afua", "How", "Are", "You")
                .concatWith(Flux.error(new RuntimeException("Flux Error Message")))
                .log();

        flux.subscribe(System.out::println, System.err::println);

    }

}
