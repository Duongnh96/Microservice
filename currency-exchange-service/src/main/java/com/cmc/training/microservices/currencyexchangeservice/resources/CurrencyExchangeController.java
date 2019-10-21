package com.cmc.training.microservices.currencyexchangeservice.resources;

import java.math.BigDecimal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.training.microservices.currencyexchangeservice.domain.ExchangeValue;
import com.cmc.training.microservices.currencyexchangeservice.exception.ExchangeNotFoundException;
import com.cmc.training.microservices.currencyexchangeservice.service.ExchangeServcie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeServcie exchangeService;
	
	// GET - /currency-exchange/{from}/{to}
	@GetMapping(path="/currency-exchange/{from}/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, 
			@PathVariable String to) {
		Optional<ExchangeValue> exchangeValueOptional = 
				exchangeService.getExchangeValueByFromAndTo(from, to);
		
		if (!exchangeValueOptional.isPresent()) {
			throw new ExchangeNotFoundException("Exchange from " + from 
					+ " to " + to + " not exist!");
		}
		
		
		
		ExchangeValue exchangeValue = exchangeValueOptional.get();
		exchangeValue.setPort(
				Integer.parseInt(env.getProperty("local.server.port")));
		
		logger.info("Get exchange value from {} to {}", from, to);
		
		return exchangeValue;
	}
	
	// GET - /currency-exchange/{from}/{to}
	@GetMapping(path="/currency-exchange-fault/{from}/{to}")
	@HystrixCommand(fallbackMethod="getExchangeValueFallBack")
	public ExchangeValue getExchangeValueMightFail(@PathVariable String from, 
			@PathVariable String to) {

		throw new RuntimeException("Error in getting exchange value!");
	}
	
	public ExchangeValue getExchangeValueFallBack(String from, String to) {
		return new ExchangeValue(1, from, to, BigDecimal.ONE);
	}
}
