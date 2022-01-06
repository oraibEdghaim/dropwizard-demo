package com.dropwizard.demo.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class ApplicationConfiguration extends Configuration {

    @JsonProperty("db")
    DBConfiguration dbConfiguration;

    public DBConfiguration getDbConfiguration() {
        return dbConfiguration;
    }
}
