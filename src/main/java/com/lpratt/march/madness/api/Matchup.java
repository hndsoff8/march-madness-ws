package com.lpratt.march.madness.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "matchup")
public class Matchup implements Serializable {

    private long id;
    private short round;
    private Team teamOne;
    private Team teamTwo;
    private Team winner;

    public Matchup() {

    }

    public Matchup(long id, short round, Team one, Team two, Team winner) {
        this.id = id;
        this.round = round;
        this.teamOne = one;
        this.teamTwo = two;
        this.winner = winner;
    }

    public Matchup(long id, short round, Team one, Team two) {
        this(id, round, one, two, null);
    }
    
    public Matchup(long id, short round){
        this(id, round, null, null);
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty
    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    @JsonProperty
    public short getRound(){
        return round;
    }
    
    @JsonProperty
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_one")
    public Team getTeamOne(){
        return teamOne;
    }
    
    @JsonProperty
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_two")
    public Team getTeamTwo(){
        return teamTwo;
    }
    
    @JsonProperty
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public Team getWinner(){
        return winner;
    }

    public void setRound(short round) {
        this.round = round;
    }

    public void setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
    }

    public void setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
}
