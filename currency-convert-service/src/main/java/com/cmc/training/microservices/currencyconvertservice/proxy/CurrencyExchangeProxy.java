package com.cmc.training.microservices.currencyconvertservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cmc.training.microservices.currencyconvertservice.domain.CurrencyExchangeInfo;

//@FeignClient(name="currency-exchange-service", url="http://localhost:8000")
@FeignClient(name="api-gateway")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {
	@GetMapping(path="/currency-exchange-service/currency-exchange/{from}/{to}")
	public CurrencyExchangeInfo getExchangeInfo(
			@PathVariable(name="from") String from, 
			@PathVariable(name="to") String to);
}
