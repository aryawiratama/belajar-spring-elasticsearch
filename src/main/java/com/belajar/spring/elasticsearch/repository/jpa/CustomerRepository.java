package com.belajar.spring.elasticsearch.repository.jpa;

import com.belajar.spring.elasticsearch.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {
}
