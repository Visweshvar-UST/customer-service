package com.example.customer.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerServicePojo {

    private long cusId;

    private String custName;

    private List<OrderPojo> allOrders;
}