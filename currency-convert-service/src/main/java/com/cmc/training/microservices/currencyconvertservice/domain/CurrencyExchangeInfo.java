package com.cmc.training.microservices.currencyconvertservice.domain;

import java.math.BigDecimal;

public class CurrencyExchangeInfo {
	private String from;
	private String to;
	private BigDecimal rate;
	
	private int port;

	
	public CurrencyExchangeInfo() {
		super();
	}

	public CurrencyExchangeInfo(String from, String to, BigDecimal rate, int port) {
		super();
		this.from = from;
		this.to = to;
		this.rate = rate;
		this.port = port;
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

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
}
