package com.dropwizard.demo.configuration;

import com.fasterxml.jackson.annotation.*;
import io.dropwizard.Configuration;
import javax.validation.constraints.NotEmpty;


public class DBConfiguration  {

    @NotEmpty
    private  String driverClassName;
    @NotEmpty
    private  String dbUrl;
    @NotEmpty
    private  String dbUserName;
    @NotEmpty
    private  String dbPassword;

    @JsonProperty("driver.class.name")
    public String getDriverClassName() {
        return driverClassName;
    }
    @JsonProperty("url")
    public String getDbUrl() {
        return dbUrl;
    }
    @JsonProperty("username")
    public String getDbUserName() {
        return dbUserName;
    }
    @JsonProperty("password")
    public String getDbPassword() {
        return dbPassword;
    }
}