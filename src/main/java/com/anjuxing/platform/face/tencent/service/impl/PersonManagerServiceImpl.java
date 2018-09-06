package com.anjuxing.platform.face.tencent.service.impl;



import com.anjuxing.platform.face.tencent.model.Person;
import com.anjuxing.platform.face.tencent.service.PersonManagerService;
import com.qcloud.image.ImageClient;
import com.qcloud.image.request.FaceDelPersonRequest;
import com.qcloud.image.request.FaceNewPersonRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author xiongt
 * @Description 腾讯云个体信息 管理接口
 */
@Service
public class PersonManagerServiceImpl implements PersonManagerService {

    //日志
    private Logger logger = LoggerFactory.getLogger(PersonManagerServiceImpl.class);

    @Autowired
    private ImageClient imageClient;

    @Override
    public String createPersonFile(Person person ) {

        if (Objects.isNull(person)){
            logger.debug("call createPersonFile ,person is null");
            throw new NullPointerException("person is null");
        }


        logger.info("call createPersonFile ,param:" + person );

        //1.创建请求对象
        FaceNewPersonRequest personNewReq = new FaceNewPersonRequest(
                person.getBucketName(),
                person.getPersonId(),
                person.getGroupIds(),
                person.getFile(),
                person.getPersonName(),
                person.getTag());

        return uploadPerson(personNewReq);
    }

    @Override
    public String createPersonContent(Person person ) {

        if (Objects.isNull(person)){
            logger.debug("call createPersonContent ,person is null");
            throw new NullPointerException("person is null");
        }

        logger.info("call createPersonContent ,param:" + person );

        //1.创建请求对象
        FaceNewPersonRequest personNewReq = new FaceNewPersonRequest(
                person.getBucketName(),
                person.getPersonId(),
                person.getGroupIds(),
                person.getImageContents(),
                person.getPersonName(),
                person.getTag());

        return uploadPerson(personNewReq);
    }

    @Override
    public String createPersonUrl(Person person) {

        if (Objects.isNull(person)){
            logger.debug("call createPersonUrl ,person is null");
            throw new NullPointerException("person is null");
        }
        logger.info("call createPersonUrl ,param:" + person );

        //1.创建请求对象
        FaceNewPersonRequest personNewReq = new FaceNewPersonRequest(
                person.getBucketName(),
                person.getPersonId(),
                person.getGroupIds(),
                 person.getUrl(),
                person.getPersonName(),
                person.getTag());

        return uploadPerson(personNewReq);
    }





    private String uploadPerson(FaceNewPersonRequest personNewReq){

        String ret = imageClient.faceNewPerson(personNewReq);

        logger.info("call uploadPerson() to get response message:" + ret);

        return ret;
    }


    @Override
    public String deletePerson(String bucketName, String personId) {

        //1.创建请求对象
        FaceDelPersonRequest delPersonReq = new FaceDelPersonRequest(
                   bucketName,
                    personId);

        String ret = imageClient.faceDelPerson(delPersonReq);

        logger.info("call faceDelPerson() to get response message:" + ret);

        return ret;
    }
}
