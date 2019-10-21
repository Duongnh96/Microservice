package com.cmc.training.microservices.limitsservice.domain;

public class LimitsConfig {
	private int minimum;
	private int maximum;
	
	public LimitsConfig() {
		super();
	}
	public LimitsConfig(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}
}
