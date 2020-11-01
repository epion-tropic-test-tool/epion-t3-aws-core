package com.epion_t3.aws.core.holder;

import com.epion_t3.aws.core.configuration.AwsCredentialsProviderConfiguration;
import com.epion_t3.aws.core.util.AwsCredentialsProviderUtils;
import com.epion_t3.core.exception.SystemException;
import org.apache.commons.lang3.StringUtils;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class AwsCredentialsProviderHolder {

    /**
     * シングルトンインスタンス.
     */
    private static final AwsCredentialsProviderHolder instance = new AwsCredentialsProviderHolder();

    /**
     * AwsCredentialsProviderの保持マップ.
     */
    private static final Map<String, AwsCredentialsProvider> providerMap = new ConcurrentHashMap<>();

    /**
     * インスタンスを取得します.
     *
     * @return {@link AwsCredentialsProviderHolder}
     */
    public static AwsCredentialsProviderHolder getInstance() {
        return instance;
    }

    /**
     * 資格プロバイダーを取得します.
     *
     * @param configuration 参照名
     * @return {@AwsCredentialsProvider} 資格プロバイダー
     */
    public AwsCredentialsProvider getCredentialsProvider(AwsCredentialsProviderConfiguration configuration) {

        if (providerMap.containsKey(configuration.getId())) {
            return providerMap.get(configuration.getId());
        } else {
            AwsCredentialsProvider provider = AwsCredentialsProviderUtils.getInstance().resolveCredentialsProvider(configuration);
            providerMap.put(configuration.getId(), provider);
            return provider;
        }

    }

}
