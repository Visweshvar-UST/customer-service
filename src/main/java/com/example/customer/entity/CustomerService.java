package com.example.customer.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="CustomersDetails")
public class CustomerService {

    @Column(name="customerId")
    @Id
    private long cusId;

    @Column(name="customerName")
    private String custName;


    
    // public CustomerService() {
    // }


    // public CustomerService(long cusId, long custName, long orderId) {
    //     this.cusId = cusId;
    //     this.custName = custName;
    //     this.orderId = orderId;
    // }


    // public long getCusId() {
    //     return cusId;
    // }


    // public void setCusId(long cusId) {
    //     this.cusId = cusId;
    // }


    // public long getCustName() {
    //     return custName;
    // }


    // public void setCustName(long custName) {
    //     this.custName = custName;
    // }


    // public long getOrderId() {
    //     return orderId;
    // }


    // public void setOrderId(long orderId) {
    //     this.orderId = orderId;
    // }

    

    


    
}
