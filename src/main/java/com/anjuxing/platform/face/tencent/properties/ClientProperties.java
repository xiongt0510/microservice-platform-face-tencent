package com.anjuxing.platform.face.tencent.properties;


/**
 * @author xiongt
 * @Description
 */
public class ClientProperties {

    //对应腾讯云账号信息AppId
    private String appId = "";

    //云 API 密钥的一部分，SecretId 用于标识 API 调用者身份
    private String secretId = "";

    //云 API 密钥的一部分，SecretKey 是用于加密签名字符串和服务器端验证签名字符串的密钥。
    private String secretKey = "";

    //表示 COS 的数据中心所在的地域
    private String region = "";

    //存储桶即 Bucket ，在 COS 中用于存储对象。一个存储桶中可以存储多个对象。
    private String bucketName = "";

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
