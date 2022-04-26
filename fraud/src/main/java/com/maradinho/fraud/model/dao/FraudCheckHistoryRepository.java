package com.maradinho.fraud.model.dao;

import com.maradinho.fraud.model.bo.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
