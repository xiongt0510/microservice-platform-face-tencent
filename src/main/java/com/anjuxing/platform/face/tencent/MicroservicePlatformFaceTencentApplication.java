package com.anjuxing.platform.face.tencent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xiongt
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class MicroservicePlatformFaceTencentApplication {

    public static void  main(String [] args){
        SpringApplication.run(MicroservicePlatformFaceTencentApplication.class,args);
    }
}
