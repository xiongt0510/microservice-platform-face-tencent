package com.anjuxing.platform.face.tencent.service;


/**
 * 人脸接口
 */
public interface FaceManagerService {



    String faceVerifyUrl(String bucketName,String personId ,String url);

    String faceVerifyContent(String bucketName ,String personId ,byte [] contents);
}
