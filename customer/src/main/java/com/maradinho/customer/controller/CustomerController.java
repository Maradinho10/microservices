package com.maradinho.customer.controller;

import com.maradinho.customer.model.dto.CustomerRequest;
import com.maradinho.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    public void addCustomer(@RequestBody CustomerRequest customerRequest) {
        log.info("New customer request: {}", customerRequest);
        service.addCustomer(customerRequest);
    }
}
