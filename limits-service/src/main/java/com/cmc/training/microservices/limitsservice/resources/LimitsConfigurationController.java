package com.cmc.training.microservices.limitsservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.training.microservices.limitsservice.LimitsServiceConfiguration;
import com.cmc.training.microservices.limitsservice.domain.LimitsConfig;


@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private LimitsServiceConfiguration config;
	// GET - /limits
	@GetMapping(path="/limits")
	public LimitsConfig getLimitsFromConfig() {
		return new LimitsConfig(config.getMinimum(), config.getMaximum());
	}
}
