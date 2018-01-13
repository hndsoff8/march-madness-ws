package com.lpratt.march.madness.health;

import com.codahale.metrics.health.HealthCheck;

public class DbConnectionHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }

}
