/* Copyright (c) 2017-2021 Nozomu Takashima. */
package com.epion_t3.aws.core.configuration;

import com.epion_t3.core.common.annotation.CustomConfigurationDefinition;
import com.epion_t3.core.common.bean.scenario.Configuration;
import lombok.Getter;
import lombok.Setter;

/**
 * HTTPクライアント設定.
 */
@Getter
@Setter
@CustomConfigurationDefinition(id = "AwsSdkHttpClientConfiguration")
public class AwsSdkHttpClientConfiguration extends Configuration {

    /** 接続タイムアウト. */
    private Long connectTimeout;

    /** リードタイムアウト. */
    private Long socketTimeout;

    /** プロキシエンドポイント. */
    private String proxyEndpoint;

    /** ユーザー名. */
    private String username;

    /** パスワード. */
    private String password;

}
