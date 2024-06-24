package com.bhupesh.rateLimiter.rate_limiter.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhupesh.rateLimiter.rate_limiter.Entity.RateLimitConfig;
import com.bhupesh.rateLimiter.rate_limiter.Repository.RateLimitConfigRepo;

import java.util.HashMap;
import java.util.Map;

@Service
public class RateLimiterService {

    @Autowired
    private RateLimitConfigRepo rateLimitConfigRepository;

    private Map<String, TokenBucket> tokenBuckets = new HashMap<>();

    public RateLimiterService() {
        // Initialize the token buckets based on database entries
    }

    public boolean isRequestAllowed(String apiEndpoint) {
        TokenBucket bucket = tokenBuckets.get(apiEndpoint);
        if (bucket == null) {
            RateLimitConfig config = rateLimitConfigRepository.findByApiEndPoint(apiEndpoint)
                    .orElseThrow(() -> new IllegalArgumentException("No rate limit config found for " + apiEndpoint));
            bucket = new TokenBucket(config.getMaxTokens(), config.getRefillIntervals());
            tokenBuckets.put(apiEndpoint, bucket);
        }
        return bucket.allowRequest();
    }

    // Inner class representing TokenBucket
    private static class TokenBucket {
        private int tokens;
        private final int maxTokens;
        private final int refillInterval;
        private long lastRefillTime;

        public TokenBucket(int maxTokens, int refillInterval) {
            this.tokens = maxTokens;
            this.maxTokens = maxTokens;
            this.refillInterval = refillInterval;
            this.lastRefillTime = System.currentTimeMillis();
        }

        public synchronized boolean allowRequest() {
            refillTokens();
            if (tokens > 0) {
                tokens--;
                return true;
            } else {
                return false;
            }
        }

        private void refillTokens() {
            long now = System.currentTimeMillis();
            long refillTimeElapsed = now - lastRefillTime;
            if (refillTimeElapsed > refillInterval * 1000) {
                tokens = Math.min(maxTokens, tokens + (int) (refillTimeElapsed / (refillInterval * 1000)));
                lastRefillTime = now;
            }
        }
    }
}

