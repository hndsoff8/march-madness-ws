package com.lpratt.march.madness;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import javax.validation.Valid;
import javax.validation.constraints.*;

public class MarchMadnessWsConfiguration extends Configuration {
    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();
    
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory(){
        return database;
    }
    
    @JsonProperty("database")
    public void setDatabase(DataSourceFactory database){
        this.database = database;
    }
}
