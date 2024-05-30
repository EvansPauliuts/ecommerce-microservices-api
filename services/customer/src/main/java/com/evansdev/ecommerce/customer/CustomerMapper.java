package com.evansdev.ecommerce.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest customerRequest) {
        if (customerRequest == null) {
            return null;
        }

        return Customer.builder()
                .id(customerRequest.id())
                .firstname(customerRequest.firstName())
                .lastname(customerRequest.lastName())
                .email(customerRequest.email())
                .address(customerRequest.address())
                .build();
    }
}
