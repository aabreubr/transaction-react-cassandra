package com.reactive.example.repository;

import com.reactive.example.model.Transaction;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.data.cassandra.repository.support.ReactiveCassandraRepositoryFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CassandraRepositoryFactory extends ReactiveCassandraRepositoryFactory {

    public CassandraRepositoryFactory(ReactiveCassandraOperations cassandraOperations) {
        super(cassandraOperations);
    }

    public Mono<Transaction> findById(String id) {
        return super.getRepository(TransactionRepository.class).findByName(id);
    }

}
