package com.reactive.example.repository;

import com.reactive.example.model.Transaction;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TransactionRepository extends ReactiveCassandraRepository<Transaction, String> {
    Mono<Transaction> findByName(String name);
}
