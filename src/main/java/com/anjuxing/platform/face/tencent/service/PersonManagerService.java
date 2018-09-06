package com.anjuxing.platform.face.tencent.service;



import com.anjuxing.platform.face.tencent.model.Person;

import java.io.File;

/**
 * 个体信息管理接口
 */
public interface PersonManagerService {

    /**
     * 添加个体信息到腾讯云 根据file文件
     * @param person
     * @return
     */
     String createPersonFile(Person person);

    /**
     * 添加个体信息到腾讯云 根据二进制数组
     * @param person
     * @return
     */
     String createPersonContent(Person person);

    /**
     * 添加个体信息到腾讯云 根据
     * @param person
     * @return
     */
     String createPersonUrl(Person person);

    /**
     * 从腾讯云删除个体
     * @param
     * @return
     */
     String deletePerson(String bucketName ,String personId);





}
