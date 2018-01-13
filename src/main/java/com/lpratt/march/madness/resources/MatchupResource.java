package com.lpratt.march.madness.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableMap;
import com.lpratt.march.madness.api.Matchup;
import com.lpratt.march.madness.db.MatchupDao;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/matchup")
@Produces(MediaType.APPLICATION_JSON)
public class MatchupResource {
    private final MatchupDao dao;
    
    public MatchupResource(MatchupDao dao){
        this.dao = dao;
    }
    
    @GET
    @Path("/{id}")
    @Timed
    @UnitOfWork
    public Matchup getMatchup(@PathParam("id") LongParam id){
        return dao.findById(id.get());
    }
    
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    public Response createMatchup(Matchup matchup){
        long id = dao.create(matchup);
        return Response.status(Response.Status.CREATED).entity(ImmutableMap.of("id", id)).build();
    }
}
