package com.bhupesh.rateLimiter.rate_limiter.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhupesh.rateLimiter.rate_limiter.Entity.RateLimitConfig;

public interface RateLimitConfigRepo extends JpaRepository<RateLimitConfig, Long> {

	Optional<RateLimitConfig> findByApiEndPoint(String apiEndPoint);
}
