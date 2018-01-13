package com.lpratt.march.madness;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class march-madness-wsApplication extends Application<march-madness-wsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new march-madness-wsApplication().run(args);
    }

    @Override
    public String getName() {
        return "march-madness-ws";
    }

    @Override
    public void initialize(final Bootstrap<march-madness-wsConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final march-madness-wsConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
