package com.reactive.example.api;

import com.reactive.example.model.Transaction;
import com.reactive.example.repository.CassandraRepositoryFactory;
import com.reactive.example.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private CassandraRepositoryFactory transactionRepository;

    @GetMapping("/{id}")
    public Mono<Transaction> getTransactionById(@PathVariable String id) {
        return transactionRepository.findById(id);
    }

    @GetMapping("/status/{id}")
    public Mono<Transaction> getTransactionByIdAndStatus(@PathVariable String id) {
        return transactionRepository.findByIdAndStatus(id, "OK");
    }

}
