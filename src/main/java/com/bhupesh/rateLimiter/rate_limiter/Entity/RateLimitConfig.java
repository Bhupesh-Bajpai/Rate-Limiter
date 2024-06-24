package com.bhupesh.rateLimiter.rate_limiter.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RateLimitConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String apiEndPoint;
	private int maxTokens;
	private int refillIntervals;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getApiEndPoint() {
		return apiEndPoint;
	}
	public void setApiEndPoint(String apiEndPoint) {
		this.apiEndPoint = apiEndPoint;
	}
	public int getMaxTokens() {
		return maxTokens;
	}
	public void setMaxTokens(int maxTokens) {
		this.maxTokens = maxTokens;
	}
	public int getRefillIntervals() {
		return refillIntervals;
	}
	public void setRefillIntervals(int refillIntervals) {
		this.refillIntervals = refillIntervals;
	}
	
	
}
