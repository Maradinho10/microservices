package com.maradinho.fraud.service;

import com.maradinho.fraud.model.bo.FraudCheckHistory;
import com.maradinho.fraud.model.dao.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository historyRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        historyRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build());
        return false;
    }
}
