package com.cmc.training.microservices.currencyconvertservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cmc.training.microservices.currencyconvertservice.domain.LimitsInfo;

//@FeignClient(name="limits-service")
public interface CurrencyLimitsProxy {
	@GetMapping(path="/limits")
	public LimitsInfo getLimitsInfo();
}
