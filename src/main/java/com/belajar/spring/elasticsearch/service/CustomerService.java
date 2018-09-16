package com.belajar.spring.elasticsearch.service;

import com.belajar.spring.elasticsearch.model.Customer;
import com.belajar.spring.elasticsearch.repository.elastic.CustomerElasticRepository;
import com.belajar.spring.elasticsearch.repository.jpa.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerElasticRepository customerElasticRepository;

    @Transactional
    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
        customerElasticRepository.save(customer);
    }

    public List<Customer> findByName(String name){
        return customerElasticRepository.findAllByNameContains(name);
    }
}
