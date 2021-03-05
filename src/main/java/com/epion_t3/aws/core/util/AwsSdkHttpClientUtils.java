/* Copyright (c) 2017-2021 Nozomu Takashima. */
package com.epion_t3.aws.core.util;

import com.epion_t3.aws.core.configuration.AwsSdkHttpClientConfiguration;
import org.apache.commons.lang3.StringUtils;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.http.apache.ProxyConfiguration;

import java.net.URI;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public final class AwsSdkHttpClientUtils {

    /**
     * シングルトンインスタンス.
     */
    private static final AwsSdkHttpClientUtils instance = new AwsSdkHttpClientUtils();

    /**
     * インスタンスを取得します.
     *
     * @return
     */
    public static AwsSdkHttpClientUtils getInstance() {
        return instance;
    }

    /**
     * {@link SdkHttpClient} を解決する.
     *
     * @param configuration HTTPクライアント設定
     * @return HTTPクライアント
     */
    public SdkHttpClient resolveSdkHttpClient(final AwsSdkHttpClientConfiguration configuration) {

        var builder = ApacheHttpClient.builder();

        if (configuration.getConnectTimeout() != null) {
            builder.connectionTimeout(Duration.of(configuration.getConnectTimeout(), ChronoUnit.MILLIS));
        }

        if (configuration.getSocketTimeout() != null) {
            builder.socketTimeout(Duration.of(configuration.getSocketTimeout(), ChronoUnit.MILLIS));
        }

        if (StringUtils.isNotEmpty(configuration.getProxyEndpoint())) {
            if (StringUtils.isNotEmpty(configuration.getUsername())
                    && StringUtils.isNotEmpty(configuration.getPassword())) {
                builder.proxyConfiguration(ProxyConfiguration.builder()
                        .endpoint(URI.create(configuration.getProxyEndpoint()))
                        .username(configuration.getUsername())
                        .password(configuration.getPassword())
                        .build());
            } else {
                builder.proxyConfiguration(
                        ProxyConfiguration.builder().endpoint(URI.create(configuration.getProxyEndpoint())).build());
            }
        }
        return builder.build();
    }

}
