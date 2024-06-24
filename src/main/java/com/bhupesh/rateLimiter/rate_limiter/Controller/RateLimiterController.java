package com.bhupesh.rateLimiter.rate_limiter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bhupesh.rateLimiter.rate_limiter.Service.RateLimiterService;

@RestController
public class RateLimiterController {

	@Autowired
	private RateLimiterService rateLimiterService;
	
	@GetMapping("/check/{apiEndPoint}")
	public String chceckRateLimit(@PathVariable String apiEndPoint) {
		boolean allowed = rateLimiterService.isRequestAllowed(apiEndPoint);
        return allowed ? "Request allowed" : "Request denied - Rate limit exceeded";
	}
	
}
