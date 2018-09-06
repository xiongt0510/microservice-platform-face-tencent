package com.anjuxing.platform.face.tencent.config;

import com.anjuxing.platform.face.tencent.properties.TencentProperties;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import com.qcloud.image.ImageClient;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author xiongt
 * @Description 对象存储客户端配置，把相关对象交给spring管理
 */
@Configuration
public class TencentClientConfig {

    @Autowired
    private TencentProperties tencent;

    @Bean
    public COSCredentials cosCredentials(){
        return new BasicCOSCredentials(tencent.getClient().getSecretId(),tencent.getClient().getSecretKey());
    }

    @Bean
    public Region region(){
        return new Region(tencent.getClient().getRegion());
    }

    @Bean
    @Autowired
    public ClientConfig clientConfig(Region region){
        return  new ClientConfig(region);
    }

    @Bean
    @Autowired
    public COSClient cosClient(COSCredentials cosCredentials,ClientConfig clientConfig){
        return  new COSClient(cosCredentials,clientConfig);
    }

    @Bean
    public ImageClient imageClient(){
        return  new ImageClient(tencent.getClient().getAppId(),
                tencent.getClient().getSecretId(),
                tencent.getClient().getSecretKey());
    }










}
