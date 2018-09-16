package com.belajar.spring.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Document(indexName = "customers", type = "customers",shards = 1)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(length = 10, unique = true, nullable = false)
    private String code;

    @Column(length = 30, nullable = false)
    private String name;

    @Column
    private String address;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private BigDecimal creditLimit;
}
