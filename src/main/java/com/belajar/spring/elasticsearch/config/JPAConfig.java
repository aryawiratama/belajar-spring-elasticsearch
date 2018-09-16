package com.belajar.spring.elasticsearch.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableJpaRepositories(basePackages = "com.belajar.spring.elasticsearch.repository.jpa")
@EnableElasticsearchRepositories(basePackages = "com.belajar.spring.elasticsearch.repository.elastic")
public class JPAConfig {

    @Value("${elasticsearch.home:/Users/aryawiratama/Project/elasticsearch-6.4.0}")
    private String elasticSearchHome;

    @Value("${elasticsearch.cluster.name:elasticsearch}")
    private String clusterName;

    @Bean
    public Client client(){
        TransportClient client = null;
        final Settings elasticSettings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("path.home", elasticSearchHome)
                .put("cluster.name", clusterName).build();
        client = new PreBuiltTransportClient(elasticSettings);
        try {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate(){
        return new ElasticsearchTemplate(client());
    }
}
