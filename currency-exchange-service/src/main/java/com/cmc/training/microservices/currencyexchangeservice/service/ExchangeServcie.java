package com.cmc.training.microservices.currencyexchangeservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cmc.training.microservices.currencyexchangeservice.domain.ExchangeValue;
import com.cmc.training.microservices.currencyexchangeservice.repository.ExchangeValueRepository;

@Component
public class ExchangeServcie {
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	public Optional<ExchangeValue> getExchangeValueByFromAndTo(String from, String to)
	{
		return exchangeValueRepository.findByFromAndTo(from, to);
	}
}
