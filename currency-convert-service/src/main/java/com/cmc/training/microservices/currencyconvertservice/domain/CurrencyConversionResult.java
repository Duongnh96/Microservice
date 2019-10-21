package com.cmc.training.microservices.currencyconvertservice.domain;

import java.math.BigDecimal;

public class CurrencyConversionResult {
	private String from;
	private String to;
	private BigDecimal rate;
	private BigDecimal quantity;
	private BigDecimal value;
	
	private int exchangeServer;
	

	public CurrencyConversionResult() {
		super();
	}

	public CurrencyConversionResult(String from, String to, BigDecimal rate, BigDecimal quantity, BigDecimal value) {
		super();
		this.from = from;
		this.to = to;
		this.rate = rate;
		this.quantity = quantity;
		this.value = value;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public int getExchangeServer() {
		return exchangeServer;
	}

	public void setExchangeServer(int exchangeServer) {
		this.exchangeServer = exchangeServer;
	}
	
	
}
