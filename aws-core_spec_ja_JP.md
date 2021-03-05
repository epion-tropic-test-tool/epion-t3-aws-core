# AWS Core カスタム機能ドキュメント

このドキュメントは、AWS Core のカスタム機能が提供する、
Flow、コマンド、設定定義についての説明及び出力するメッセージの定義について説明する。

- Contents
  - [Information](#Information)
  - [Description](#Description)
  - [Flow List](#Flow-List)
  - [Command List](#Command-List)
  - [Configuration List](#Configuration-List)
  - [Message List](#Message-List)

## Information

本カスタム機能の基本情報は以下の通り。

AWS系機能をコア部の機能を提供します。

- Name : `aws-core`
- Custom Package : `com.epion_t3.aws.core`

## Description
AWS系機能をコア部の機能を提供します。

## Flow List

本カスタム機能が提供するFlowの一覧及び詳細。

|Name|Summary|
|:---|:---|


## Command List

本カスタム機能が提供するコマンドの一覧及び詳細。

|Name|Summary|Assert|Evidence|
|:---|:---|:---|:---|


## Configuration List

本カスタム機能が提供する設定定義の一覧及び詳細。

|Name|Summary|
|:---|:---|
|[AwsSdkHttpClientConfiguration](#AwsSdkHttpClientConfiguration)|AWSへの接続を行うHTTPクライアントの設定です。  |
|[AwsCredentialsProviderConfiguration](#AwsCredentialsProviderConfiguration)|AWSへの接続を行う資格情報の設定です。  |

------

### AwsSdkHttpClientConfiguration
AWSへの接続を行うHTTPクライアントの設定です。
#### Description
- AWSへの接続を行うHTTPクライアントの設定です。
- プロキシ環境下での実行の場合に、プロキシを設定します。

#### Structure
```yaml
commands : 
  configuration : 「AwsSdkHttpClientConfiguration」固定
  id : 設定のID
  summary : 設定の概要（任意）
  description : 設定の詳細（任意）
  proxyEndpoint : プロキシのエンドポイントを指定します。例）http://host:port
  username : プロキシに認証が存在する場合に、ユーザー名を指定します。
  username : プロキシに認証が存在する場合に、パスワードを指定します。
  connectTimeout : 接続タイムアウトをミリ秒（ms）で指定します。
  socketTimeout : 読み込みタイムアウトをミリ秒（ms）で指定します。

```

------

### AwsCredentialsProviderConfiguration
AWSへの接続を行う資格情報の設定です。
#### Description
- AWSへの接続を行う資格情報の設定です。
- アクセスキーIDとシークレットアクセスキーを省略した場合には、環境変数やインスタンス及びコンテナにアタッチされたロールでの解決を試みます。
- 詳細は、[AWSのJavaSDKのJavaDoc](https://sdk.amazonaws.com/java/api/latest/software/amazon/awssdk/auth/credentials/DefaultCredentialsProvider.html) を参照してください。
- 公開範囲の広いリポジトリで管理する場合は、資格のキーとなる情報を記載しないでください。

#### Structure
```yaml
commands : 
  configuration : 「AwsCredentialsProviderConfiguration」固定
  id : 設定のID
  summary : 設定の概要（任意）
  description : 設定の詳細（任意）
  accessKeyId : アクセスキーIDを指定します。
  secretAccessKey : シークレットアクセスキーを指定します。

```


## Message List

本カスタム機能が出力するメッセージの一覧及び内容。

|MessageID|MessageContents|
|:---|:---|
