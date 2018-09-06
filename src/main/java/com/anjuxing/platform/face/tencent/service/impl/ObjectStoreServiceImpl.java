package com.anjuxing.platform.face.tencent.service.impl;



import com.anjuxing.platform.face.tencent.model.ObjectStoreResult;
import com.anjuxing.platform.face.tencent.properties.ObjectStoreProperties;
import com.anjuxing.platform.face.tencent.properties.TencentProperties;
import com.anjuxing.platform.face.tencent.service.ObjectStoreService;
import com.anjuxing.platform.face.tencent.model.ObjectStoreExpirationType;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.Objects;

/**
 * @author xiongt
 * @Description 腾讯云对象存储接口实现
 */
@Service
public class ObjectStoreServiceImpl implements ObjectStoreService {

    private Logger logger = LoggerFactory.getLogger(ObjectStoreServiceImpl.class);

    @Autowired
    private COSClient cosClient;

    @Autowired
    private TencentProperties tencent;


    /**
     * 对象存储，添加对象到腾讯云
     * @param
     * @return
     *
     */
    @Override
    public ObjectStoreResult putObject(File file ,String key) {

        if(Objects.isNull(file)){
            logger.debug("call putObject() param file is null");
            throw  new NullPointerException("call putObject() param file is null");
        }

        //把 file 文件上传到腾讯云数据存储 bucket中
        PutObjectResult putObjectResult = cosClient.putObject(
                tencent.getClient().getBucketName(),
                key,
                file);

        logger.info("call putObject() response object (PutObjectResult) :" + putObjectResult);


        //生成url地址
        URL url = cosClient.generatePresignedUrl(
                tencent.getClient().getBucketName(),
                key,
                calculateExpirationDate(tencent.getStore()));

        logger.info("call generatePresignedUrl() get object (URL):"+ url);

        //从返回的数据填充到 response对象中
        ObjectStoreResult cosResult = new ObjectStoreResult.ResponseBuilder()
                                    .setBucketName(tencent.getClient().getBucketName())
                                    .seteTag(putObjectResult.getETag())
                                    .setKey(key)
                                    .setUrl(url.toString())
                                    .build();

        logger.info("ObjectStoreResult message :" +cosResult);

        return cosResult;
    }


    /**
     * 从腾讯云中删除对象存储
     * @param
     */
    @Override
    public void deleteObject(String key) {
        cosClient.deleteObject(tencent.getClient().getBucketName(), key);
    }

    /**
     * 计算过期日期
     * @param store
     * @return
     */
    private Date calculateExpirationDate(ObjectStoreProperties store){

        if (Objects.isNull(store)){
            throw new NullPointerException("calculateExpirationDate ObjectStoreConfig param is null");
        }
        Date defaultDate = new Date();
        Date calculateDate = defaultDate;
       for (ObjectStoreExpirationType type :  ObjectStoreExpirationType.values()){
           if (type.toString().equalsIgnoreCase(store.getExpirationType())){
               calculateDate = type.calculateExpirationDate(defaultDate,store);
               break;
           }
       }
       logger.info("calculate Expiration Date is" + calculateDate);
       return  calculateDate;
    }
}
