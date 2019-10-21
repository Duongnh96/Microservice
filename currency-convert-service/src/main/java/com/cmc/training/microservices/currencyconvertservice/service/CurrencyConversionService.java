package com.cmc.training.microservices.currencyconvertservice.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cmc.training.microservices.currencyconvertservice.domain.CurrencyConversionResult;
import com.cmc.training.microservices.currencyconvertservice.domain.CurrencyExchangeInfo;
import com.cmc.training.microservices.currencyconvertservice.proxy.CurrencyExchangeProxy;

@Component
public class CurrencyConversionService {
	
	@Autowired
	private CurrencyExchangeProxy exchangeProxy;
	
//	@Autowired
//	private CurrencyLimitsProxy limitsProxy;

	public CurrencyConversionResult calculateConversion(String from,
			String to, BigDecimal quantity) {
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyExchangeInfo> exchangeInfoResponse =
				restTemplate.getForEntity("http://localhost:8000/currency-exchange/{from}/{to}", 
						CurrencyExchangeInfo.class, uriVariables);
		
		CurrencyExchangeInfo exchangeInfo = exchangeInfoResponse.getBody();
		
		CurrencyConversionResult result = new CurrencyConversionResult();
		result.setFrom(exchangeInfo.getFrom());
		result.setTo(exchangeInfo.getTo());
		result.setRate(exchangeInfo.getRate());
		result.setQuantity(quantity);
		result.setValue(quantity.multiply(exchangeInfo.getRate()));
		
		result.setExchangeServer(exchangeInfo.getPort());
		
		return result;
	}
	
	public CurrencyConversionResult calculateConversionFeign(String from,
			String to, BigDecimal quantity) {	
		
//		LimitsInfo limitsInfo = limitsProxy.getLimitsInfo();
//		
//		if (quantity.intValue() < limitsInfo.getMinimum() ||
//				quantity.intValue() > limitsInfo.getMaximum())
//		{
//			throw new InvalidQuantityException("Invalid quantity!");
//		}
		
		CurrencyExchangeInfo exchangeInfo = exchangeProxy.getExchangeInfo(from, to);
		
		CurrencyConversionResult result = new CurrencyConversionResult();
		result.setFrom(exchangeInfo.getFrom());
		result.setTo(exchangeInfo.getTo());
		result.setRate(exchangeInfo.getRate());
		result.setQuantity(quantity);
		result.setValue(quantity.multiply(exchangeInfo.getRate()));
		
		
		
		result.setExchangeServer(exchangeInfo.getPort());
		
		return result;
	}	
}
