package com.example.robconfigtest;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Controller
public class HealthCheck implements HealthIndicator {

    @RequestMapping("/make-unhealthy")
    public ResponseEntity<String> mu() {
        healthVal = 1;
        return ResponseEntity.ok("Made Unhealthy");
    }

    @RequestMapping("/make-healthy")
    public ResponseEntity<String> he() {
        healthVal = 0;
        return ResponseEntity.ok("Made Healthy");
    }


    private static int healthVal = 0;

    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down()
                    .withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    public int check() {
        return healthVal;
    }
}