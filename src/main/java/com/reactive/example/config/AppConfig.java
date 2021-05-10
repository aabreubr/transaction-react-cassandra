package com.reactive.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;

import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.List;

@Configuration
public class AppConfig {

    /*@Value("${spring.data.cassandra.keyspace-name}")
    private String keyspace;

    @Value("${spring.data.cassandra.contact-points}")
    private String contactpoint;

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Bean
    public CqlSessionFactoryBean session() {
        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        List<InetSocketAddress> contacPoints = Collections.singletonList(new InetSocketAddress(contactpoint, port));
        session.setSessionBuilderConfigurer(config -> {
            return config
                    .addContactPoints(contacPoints)
                    .withKeyspace(keyspace)
                    .withLocalDatacenter("datacenter1");
        });
        session.setKeyspaceName(keyspace);
        return session;
    }*/

}
