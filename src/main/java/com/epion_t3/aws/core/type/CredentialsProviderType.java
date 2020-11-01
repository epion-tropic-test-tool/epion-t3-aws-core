package com.epion_t3.aws.core.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CredentialsProviderType {

    SYSTEM_PROPERTY("SYSTEM_PROPERTY"),
    ENVIRONMENT_VARIABLE("ENVIRONMENT_VARIABLE");


    private String name;


}
