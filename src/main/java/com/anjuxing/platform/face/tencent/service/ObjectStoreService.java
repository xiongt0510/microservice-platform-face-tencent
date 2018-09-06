package com.anjuxing.platform.face.tencent.service;


import com.anjuxing.platform.face.tencent.model.ObjectStoreResult;

import java.io.File;

/**
 * @author xiongt
 * @Description 腾讯云对象存储接口
 */
public interface ObjectStoreService {

    /**
     * 存储对象
     * @param file 上传的文件
     * @param key  对象存储桶中的唯一标识
     * @return
     */
     ObjectStoreResult putObject(File file ,String key);

    /**
     * 删除 COS 中的文件
     * @param key  对象存储桶中的唯一标识
     */
     void  deleteObject(String key);



}
