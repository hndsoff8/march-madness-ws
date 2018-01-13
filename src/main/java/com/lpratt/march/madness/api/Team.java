package com.lpratt.march.madness.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team implements Serializable {
    private long id;
    private String name;
    private short seed;

    public Team() {

    }

    public Team(long id, String name, short seed) {
        this.id = id;
        this.name = name;
        this.seed = seed;
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
    public String getName(){
        return name;
    }
    
    @JsonProperty
    public short getSeed(){
        return seed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeed(short seed) {
        this.seed = seed;
    }
}
