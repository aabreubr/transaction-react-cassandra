package com.reactive.example.client;

import com.reactive.example.model.Transaction;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ClientTransactionTest {

    private WebClient client = WebClient.create("http://localhost:8080");

    private Mono<Transaction> result = client.get()
            .uri("/transactions/status/{id}", "12313")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Transaction.class);

    public String getResult() {
        return ">> result = " + result.flatMap(res -> Mono.just(res.getStatus())).block();
    }

    public static void main(String[] args) {
        ClientTransactionTest test = new ClientTransactionTest();
        System.out.println("test.getResult() = " + test.getResult());
    }
}
