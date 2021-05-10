package com.reactive.example.repository;

import com.reactive.example.model.Transaction;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.data.cassandra.repository.support.ReactiveCassandraRepositoryFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Repository
public class CassandraRepositoryFactory extends ReactiveCassandraRepositoryFactory {

    public CassandraRepositoryFactory(ReactiveCassandraOperations cassandraOperations) {
        super(cassandraOperations);
    }

    public Mono<Transaction> findById(String id) {
        return super.getRepository(TransactionRepository.class).findByName(id);
    }

    public Mono<Transaction> findByIdAndStatus(String id, String status) {
        return super.getRepository(TransactionRepository.class).listByNameAndStatus(id, status)
                .repeatWhenEmpty(repeat -> repeat.zipWith(Flux.range(1, 5), (e, idx) -> idx)
                    .flatMap(time -> Mono.delay(Duration.ofSeconds(time))));
    }

    public Mono<Transaction> findByIdAndUuidAndStatus(String name, String uuid, String status) {
        return super.getRepository(TransactionRepository.class).listByNameAndUuidAndStatus(name, uuid, status)
                .repeatWhenEmpty(repeat -> repeat.zipWith(Flux.range(1, 5), (e, idx) -> idx)
                        .flatMap(time -> Mono.delay(Duration.ofSeconds(time))));
    }

}
