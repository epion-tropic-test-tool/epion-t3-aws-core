/* Copyright (c) 2017-2020 Nozomu Takashima. */
package com.epion_t3.aws.core.configuration;

import com.epion_t3.core.common.annotation.CustomConfigurationDefinition;
import com.epion_t3.core.common.bean.scenario.Configuration;
import lombok.Getter;
import lombok.Setter;

/**
 * AWSの資格情報の解決設定.
 */
@Getter
@Setter
@CustomConfigurationDefinition(id = "AwsCredentialsProviderConfiguration")
public class AwsCredentialsProviderConfiguration extends Configuration {

    /** SystemProperty - accessKeyId. */
    private String accessKeyId;

    /** SystemProperty - secretAccessKey . */
    private String secretAccessKey;

}
