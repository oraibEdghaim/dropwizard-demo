package com.dropwizard.demo.domain;

import lombok.Data;

import javax.annotation.Nullable;

@Data
public class Brand {
    @Nullable
    private  Long id;
    @Nullable
    private  String name;

}