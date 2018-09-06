package com.anjuxing.platform.face.tencent.controller;

import com.anjuxing.platform.face.tencent.model.FaceVerifyResult;
import com.anjuxing.platform.face.tencent.properties.TencentProperties;
import com.anjuxing.platform.face.tencent.service.FaceManagerService;
import com.anjuxing.platform.face.tencent.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiongt
 * @Description
 */
@RestController
@RequestMapping("/face")
public class FaceManagerController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FaceManagerService faceManagerService;

    @Autowired
    private TencentProperties tencent;

    @GetMapping("/verify")
   public FaceVerifyResult faceVerifyResult(
           @RequestParam("url") String url,
           @RequestParam("personId") String personId) throws Exception {

        //url 不为空，优先使用url
        if (StringUtils.isEmpty(url)){
            logger.debug("param url is null");
            throw new NullPointerException("param url is null");
        }

        if (StringUtils.isEmpty(personId)){
            logger.debug("param personId is null");
            throw new NullPointerException("param personId is null");
        }

        String data = faceManagerService.faceVerifyUrl(
                tencent.getClient().getBucketName(),personId,url);

        return JsonUtil.pasreFaceVerify(data);

   }
}
