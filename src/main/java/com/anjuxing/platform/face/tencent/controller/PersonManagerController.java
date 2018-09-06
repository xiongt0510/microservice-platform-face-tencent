package com.anjuxing.platform.face.tencent.controller;

import com.anjuxing.platform.face.tencent.model.Data;
import com.anjuxing.platform.face.tencent.model.Person;
import com.anjuxing.platform.face.tencent.model.PersonResult;
import com.anjuxing.platform.face.tencent.properties.TencentProperties;
import com.anjuxing.platform.face.tencent.service.PersonManagerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Objects;

/**
 * @author xiongt
 * @Description
 */
@RestController
@RequestMapping("/person")
public class PersonManagerController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonManagerService personManagerService;

    @Autowired
    private TencentProperties tencent;

    @Autowired
    private ObjectMapper mapper;



    @PostMapping("/create/url")
    public PersonResult createPersonUrl(@RequestBody Person person) throws IOException {

        if (Objects.isNull(person)){
            logger.debug("param person object is null");
            throw new NullPointerException("param person object is null");
        }

        if (StringUtils.isEmpty(person.getUrl())){
            logger.debug("param person object url is empty");
            throw new IllegalArgumentException("param person object url is empty");
        }

        //设置存储桶
        person.setBucketName(tencent.getClient().getBucketName());

        String data =  personManagerService.createPersonUrl(person);

        return mapper.readValue(data,PersonResult.class);

    }

    @PostMapping("/create/content")
    public PersonResult createPersonContent(@RequestBody Person person) throws IOException {

        if (Objects.isNull(person)){
            logger.debug("param person object is null");
            throw new NullPointerException("param person object is null");
        }

        if (StringUtils.isEmpty(person.getImageContents())){
            logger.debug("param person object's property imageContents is empty");
            throw new IllegalArgumentException("param person object's property imageContents is empty");
        }

        //设置存储桶
        person.setBucketName(tencent.getClient().getBucketName());

        String data =  personManagerService.createPersonContent(person);

        return mapper.readValue(data,PersonResult.class);

    }

    @PostMapping("/create/file")
    public PersonResult createPersonFile(@RequestBody Person person) throws IOException {

        if (Objects.isNull(person)){
            logger.debug("param person object is null");
            throw new NullPointerException("param person object is null");
        }

        if (StringUtils.isEmpty(person.getFile())){
            logger.debug("param person object's property file is empty");
            throw new IllegalArgumentException("param person object's property file is empty");
        }

        //设置存储桶
        person.setBucketName(tencent.getClient().getBucketName());

        String datas =  personManagerService.createPersonFile(person);

        Data data = mapper.readValue(datas,Data.class);

        PersonResult personResult = mapper.convertValue(data.getData(),PersonResult.class);

        personResult.setMessage(data.getMessage());

        return personResult;
    }

    @DeleteMapping
    public String deletePerson(@RequestParam("personId") String personId){

        if (StringUtils.isEmpty(personId)){
            logger.debug("request param personId is empty");
            throw new NullPointerException("request param personId is empty");
        }

        return personManagerService.deletePerson(
                tencent.getClient().getBucketName(),personId);
    }


}
