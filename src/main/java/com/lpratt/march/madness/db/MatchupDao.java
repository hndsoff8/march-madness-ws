package com.lpratt.march.madness.db;

import com.lpratt.march.madness.api.Matchup;
import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class MatchupDao extends AbstractDAO<Matchup> {

    public MatchupDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    public Matchup findById(Long id){
        return get(id);
    }

    public long create(Matchup matchup){
        return persist(matchup).getId();
    }
    
    public List<Matchup> findByRound(short round) {
        return list(criteria().add(Restrictions.eq("round", round)));
    }
}
