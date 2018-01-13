package com.lpratt.march.madness.db;

import com.lpratt.march.madness.api.Team;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class TeamDao extends AbstractDAO<Team> {

    public TeamDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Team findById(Long id){
        return get(id);
    }

    public long create(Team team){
        return persist(team).getId();
    }
}
