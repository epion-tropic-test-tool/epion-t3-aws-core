/* Copyright (c) 2017-2021 Nozomu Takashima. */
package com.epion_t3.aws.core.holder;

import com.epion_t3.aws.core.configuration.AwsSdkHttpClientConfiguration;
import com.epion_t3.aws.core.util.AwsSdkHttpClientUtils;
import software.amazon.awssdk.http.SdkHttpClient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Nozomu Takashima
 */
public final class AwsSdkHttpClientHolder {

    /**
     * シングルトンインスタンス.
     */
    private static final AwsSdkHttpClientHolder instance = new AwsSdkHttpClientHolder();

    /**
     * AwsCredentialsProviderの保持マップ.
     */
    private static final Map<String, SdkHttpClient> clientMap = new ConcurrentHashMap<>();

    /**
     * インスタンスを取得します.
     *
     * @return {@link AwsSdkHttpClientHolder}
     */
    public static AwsSdkHttpClientHolder getInstance() {
        return instance;
    }

    /**
     * 資格プロバイダーを取得します.
     *
     * @param configuration 参照名
     * @return {@SdkHttpClient} HTTPクライアント
     */
    public SdkHttpClient getSdkHttpClient(AwsSdkHttpClientConfiguration configuration) {

        if (clientMap.containsKey(configuration.getId())) {
            return clientMap.get(configuration.getId());
        } else {
            SdkHttpClient provider = AwsSdkHttpClientUtils.getInstance().resolveSdkHttpClient(configuration);
            clientMap.put(configuration.getId(), provider);
            return provider;
        }

    }

}
