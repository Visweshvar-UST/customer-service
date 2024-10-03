package com.example.customer.Repository;

import com.example.customer.entity.CustomerService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerService,Long>{
    
}
