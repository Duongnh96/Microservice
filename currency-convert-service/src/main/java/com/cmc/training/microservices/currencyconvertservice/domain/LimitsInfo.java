package com.cmc.training.microservices.currencyconvertservice.domain;

public class LimitsInfo {
	private int minimum;
	private int maximum;
	
	public LimitsInfo() {
		super();
	}
	public LimitsInfo(int minimum, int maximum) {
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
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	
}
