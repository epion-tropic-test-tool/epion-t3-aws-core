/* Copyright (c) 2017-2021 Nozomu Takashima. */
package com.epion_t3.aws.core.util;

import com.epion_t3.aws.core.configuration.AwsCredentialsProviderConfiguration;
import org.apache.commons.lang3.StringUtils;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.auth.credentials.SystemPropertyCredentialsProvider;

/**
 * {@link AwsCredentialsProvider}系Util.
 */
public final class AwsCredentialsProviderUtils {

    /**
     * シングルトンインスタンス.
     */
    private static final AwsCredentialsProviderUtils instance = new AwsCredentialsProviderUtils();

    /**
     * シングルトンインスタンスを取得.
     *
     * @return
     */
    public static AwsCredentialsProviderUtils getInstance() {
        return instance;
    }

    /**
     * {@link AwsCredentialsProvider} を解決する.
     *
     * @param configuration
     * @return
     */
    public AwsCredentialsProvider resolveCredentialsProvider(final AwsCredentialsProviderConfiguration configuration) {
        if (StringUtils.isNotEmpty(configuration.getAccessKeyId())
                && StringUtils.isNotEmpty(configuration.getSecretAccessKey())) {
            AwsCredentials credentials = AwsBasicCredentials.create(configuration.getAccessKeyId(),
                    configuration.getSecretAccessKey());
            return StaticCredentialsProvider.create(credentials);
        } else {
            return DefaultCredentialsProvider.builder().build();
        }
    }

}
