package com.lpratt.march.madness;

import com.lpratt.march.madness.api.Matchup;
import com.lpratt.march.madness.api.Team;
import com.lpratt.march.madness.db.MatchupDao;
import com.lpratt.march.madness.db.TeamDao;
import com.lpratt.march.madness.health.DbConnectionHealthCheck;
import com.lpratt.march.madness.resources.MatchupResource;
import com.lpratt.march.madness.resources.TeamResource;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MarchMadnessWsApplication extends Application<MarchMadnessWsConfiguration> {

    private final HibernateBundle<MarchMadnessWsConfiguration> hibernate = new HibernateBundle<MarchMadnessWsConfiguration>(Team.class, Matchup.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(MarchMadnessWsConfiguration t) {
            return t.getDataSourceFactory();
        }
    };
    private final MigrationsBundle<MarchMadnessWsConfiguration> migrationsBundle = new MigrationsBundle<MarchMadnessWsConfiguration>() {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(MarchMadnessWsConfiguration t) {
            return t.getDataSourceFactory();
        }
    };

    public static void main(final String[] args) throws Exception {
        new MarchMadnessWsApplication().run(args);
    }

    @Override
    public String getName() {
        return "march-madness-ws";
    }

    @Override
    public void initialize(final Bootstrap<MarchMadnessWsConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
        bootstrap.addBundle(migrationsBundle);
    }

    @Override
    public void run(final MarchMadnessWsConfiguration configuration, final Environment environment) {
        registerMatchupResource(environment);
        registerTeamResource(environment);
        registerHealthChecks(environment);
    }

    private void registerHealthChecks(final Environment environment) {
        final DbConnectionHealthCheck dbCheck = new DbConnectionHealthCheck();
        environment.healthChecks().register("database", dbCheck);
    }

    private void registerTeamResource(final Environment environment) {
        final TeamDao teamDao = new TeamDao(hibernate.getSessionFactory());
        final TeamResource teamResource = new TeamResource(teamDao);
        environment.jersey().register(teamResource);
    }

    private void registerMatchupResource(final Environment environment) {
        final MatchupDao matchupDao = new MatchupDao(hibernate.getSessionFactory());
        final MatchupResource matchupResource = new MatchupResource(matchupDao);
        environment.jersey().register(matchupResource);
    }

}
