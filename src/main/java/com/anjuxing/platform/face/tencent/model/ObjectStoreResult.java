package com.anjuxing.platform.face.tencent.model;

import java.io.Serializable;

/**
 * @author xiongt
 * @Description
 */
public class ObjectStoreResult implements Serializable {

    //对象存储到腾讯云之后的url
    private String url;

    //对象在存储桶中的唯一标识
    private String key;

    //存储桶
    private String bucketName;

    //
    private String eTag;

    public ObjectStoreResult(){}

    private ObjectStoreResult(ResponseBuilder builder){
        this.url = builder.url;
        this.key = builder.key;
        this.bucketName = builder.bucketName;
        this.eTag = builder.eTag;
    }

    public static class ResponseBuilder{

        //对象存储到腾讯云之后的url
        private String url;

        //对象在存储桶中的唯一标识
        private String key;

        //存储桶
        private String bucketName;

        //
        private String eTag;

        public ResponseBuilder setUrl(String url) {
            this.url = url;
            return this;
        }

        public ResponseBuilder setKey(String key) {
            this.key = key;
            return this;
        }

        public ResponseBuilder setBucketName(String bucketName) {
            this.bucketName = bucketName;
            return this;
        }

        public ResponseBuilder seteTag(String eTag) {
            this.eTag = eTag;
            return this;
        }

        public ObjectStoreResult build(){
            return  new ObjectStoreResult(this);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String geteTag() {
        return eTag;
    }

    public void seteTag(String eTag) {
        this.eTag = eTag;
    }

    @Override
    public String toString() {
        return "IacsCOSResponse{" +
                "url='" + url + '\'' +
                ", key='" + key + '\'' +
                ", bucketName='" + bucketName + '\'' +
                ", eTag='" + eTag + '\'' +
                '}';
    }
}
