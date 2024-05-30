package com.evansdev.ecommerce.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest customerRequest
    ) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequest));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest customerRequest
    ) {
        customerService.updateCustomer(customerRequest);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/exits/{customer_id}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable("customer_id") String customer_id
    ) {
        return ResponseEntity.ok(customerService.existsById(customer_id));
    }

    @GetMapping("/{customer_id}")
    public ResponseEntity<CustomerResponse> findById(
            @PathVariable("customer_id") String customer_id
    ) {
        return ResponseEntity.ok(customerService.findById(customer_id));
    }

    @DeleteMapping("/{customer_id}")
    public ResponseEntity<Void> delete(
            @PathVariable("customer_id") String customer_id
    ) {
        customerService.deleteCustomer(customer_id);
        return ResponseEntity.noContent().build();
    }
}
