package com.maradinho.customer.service;

import com.maradinho.customer.model.bo.Customer;
import com.maradinho.customer.model.dao.CustomerRepository;
import com.maradinho.customer.model.dto.CustomerRequest;
import com.maradinho.customer.model.dto.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository repository;
    private final RestTemplate fraudRestTemplate;

    public void addCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .email(customerRequest.email())
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .build();

        repository.saveAndFlush(customer);

        // Checks if it's fraudster
        log.info("Calling Fraud service.");
        FraudCheckResponse fraudResponse = fraudRestTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class, customer.getId()
        );
        log.info("Call service response=[{}]", fraudResponse);

        if (fraudResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }
    }
}
