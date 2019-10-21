package com.cmc.training.microservices.currencyexchangeservice.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ExchangeValue {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="from_currency")
	private String from;
	@Column(name="to_currency")
	private String to;
	private BigDecimal rate;
	
	@Transient
	private int port;
	
	public ExchangeValue() {
		super();
	}
	public ExchangeValue(Integer id, String from, String to, BigDecimal rate) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.rate = rate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
