package com.cmc.training.microservices.currencyconvertservice.resources;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.training.microservices.currencyconvertservice.domain.CurrencyConversionResult;
import com.cmc.training.microservices.currencyconvertservice.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CurrencyConversionService conversionService;

	@GetMapping(path="/currency-converter/{from}/{to}/{quantity}")
	public CurrencyConversionResult calculateCurrency(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		logger.info("Convert currency from {} to {}", from, to);
		return conversionService.calculateConversionFeign(from, to, quantity);
	}
}
