package com.belajar.spring.elasticsearch;

import com.belajar.spring.elasticsearch.model.Customer;
import com.belajar.spring.elasticsearch.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BelajarSpringElasticsearchApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BelajarSpringElasticsearchApplication.class, args);
		CustomerService service = (CustomerService) context.getBean("customerService");
		/*Customer customer = Customer.builder()
				.name("Joe Clerk")
				.address("dummy address")
				.code("dummy")
				.creditLimit(BigDecimal.valueOf(30))
				.dateOfBirth(new Date())
				.build();
		service.saveCustomer(customer);*/
		List<Customer> customers = service.findByName("joe");
		for(Customer customer : customers){
			System.out.println("Name -> " + customer.getName());
		}
	}
}
