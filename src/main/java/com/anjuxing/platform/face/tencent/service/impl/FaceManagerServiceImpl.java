package com.anjuxing.platform.face.tencent.service.impl;


import com.anjuxing.platform.face.tencent.service.FaceManagerService;
import com.qcloud.image.ImageClient;
import com.qcloud.image.request.FaceVerifyRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author xiongt
 * @Description 腾讯云人脸验证接口
 */
@Service
public class FaceManagerServiceImpl implements FaceManagerService {

    private Logger logger = LoggerFactory.getLogger(FaceManagerServiceImpl.class);

    @Autowired
    private ImageClient imageClient;

    @Override
    public String faceVerifyUrl(String bucketName ,String personId, String url) {

        //创建人脸验证请求对象
        FaceVerifyRequest faceVerifyReq = new FaceVerifyRequest(
                bucketName,
                personId,
               url);
        logger.info("request object FaceVerifyRequest : " + faceVerifyReq);

        //调用接口返回数据
        String ret = imageClient.faceVerify(faceVerifyReq);

        logger.info("response json message :" + ret);

        return ret;
    }

    @Override
    public String faceVerifyContent(String bucketName ,String personId, byte[] contents) {

        throw  new UnsupportedOperationException("un supported this operation");

    }
}
