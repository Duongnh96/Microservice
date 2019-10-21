package com.cmc.training.microservices.currencyexchangeservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmc.training.microservices.currencyexchangeservice.domain.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Integer> {
	public Optional<ExchangeValue> findByFromAndTo(String from, String to);
}
