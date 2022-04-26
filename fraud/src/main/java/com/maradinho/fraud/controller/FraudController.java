package com.maradinho.fraud.controller;

import com.maradinho.fraud.dto.FraudCheckResponse;
import com.maradinho.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
        boolean isFraudulent = fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulent);
    }
}
