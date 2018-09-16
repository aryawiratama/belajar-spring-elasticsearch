package com.belajar.spring.elasticsearch.repository.elastic;

import com.belajar.spring.elasticsearch.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CustomerElasticRepository extends ElasticsearchRepository<Customer, String> {

    List<Customer> findAllByNameContains(String name);
}
