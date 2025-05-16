package LLD.RateLimiting;

import java.util.concurrent.locks.ReentrantLock;

public class RateLimiting {
    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(5, 2); // 5 tokens max, 2 tokens/sec

        for (int i = 0; i < 10; i++) {
            boolean allowed = limiter.allowRequest();
            System.out.println("Request " + i + " allowed: " + allowed);
            Thread.sleep(100); // simulate delay of 300 ms
        }
    }
}

class TokenBucketRateLimiter {
    private final int capacity;
    private final double refillRatePerSecond;
    private final ReentrantLock lock = new ReentrantLock();
    private long lastRefillTimestamp;
    private double tokens;

    TokenBucketRateLimiter(int capacity, double refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.tokens = capacity; // start full
        this.lastRefillTimestamp = System.nanoTime();
    }

    public boolean allowRequest() {
        lock.lock();
        try {
            refill();

            if ((int) tokens >= 1) {
                tokens -= 1;
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    private void refill() {
        long now = System.nanoTime();
        double secondsPassed = (now - lastRefillTimestamp) / 1_000_000_000.0;
        if (secondsPassed > 0) {
            lastRefillTimestamp = now;
            double tokensToAdd = secondsPassed * refillRatePerSecond;
            tokens = Math.min(capacity, tokens + tokensToAdd);

        }
    }

}
