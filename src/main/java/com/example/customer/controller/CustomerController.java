package com.example.customer.controller;

import java.util.List;

import com.example.customer.Repository.CustomerRepository;
import com.example.customer.entity.CustomerService;
import com.example.customer.entity.CustomerServicePojo;
import com.example.customer.entity.OrderPojo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class CustomerController {


    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customer/{id}")
    public CustomerServicePojo getACustomer(@PathVariable Long id)
    {
       CustomerService customerservice = customerRepository.findById(id).get();
       CustomerServicePojo customerServicePojo = new CustomerServicePojo();
       BeanUtils.copyProperties(customerservice, customerServicePojo);
       WebClient webClient = WebClient.create();
       List<OrderPojo> allOrds = webClient
       .get()
       .uri("http://localhost:8082/api/order/cus/"+id)
       .retrieve()
       .bodyToMono(List.class)
       .block();


    //    RestClient restClient = RestClient.create();
    //    List<OrderPojo> allOrds = restClient
    //    .get()
    //    .uri("http://localhost:8082/api/order/cus/"+id)
    //    .retrieve()
    //    .body(List.class);
       customerServicePojo.setAllOrders(allOrds);
        return customerServicePojo;
    }

    @PostMapping("/customer")
    public CustomerService createCustomer(@RequestBody CustomerService customerController)
    {
        return customerRepository.save(customerController);
    }

    @DeleteMapping("/customer/{cid}")
    public void deleteCustomer(@PathVariable long id)
    {
        customerRepository.deleteById(id);
        return;
    }
    
}
