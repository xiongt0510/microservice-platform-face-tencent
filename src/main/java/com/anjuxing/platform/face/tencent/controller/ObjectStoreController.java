package com.anjuxing.platform.face.tencent.controller;

import com.anjuxing.platform.face.tencent.model.ObjectStoreResult;
import com.anjuxing.platform.face.tencent.service.ObjectStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author xiongt
 * @Description
 */
@RestController
@RequestMapping("/object")
public class ObjectStoreController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectStoreService objectStoreService;


    @PostMapping("/store")
    public ObjectStoreResult storeResult(@RequestParam("file") File file,@RequestParam("key") String key){

        if (Objects.isNull(file)){
            logger.debug("param file is null.");
            throw  new NullPointerException("param file is null.");
        }

        if (StringUtils.isEmpty(key)){
            key  = LocalDateTime.now().getSecond()+file.getName();
        }


      return   objectStoreService.putObject(file,key);
    }
}
