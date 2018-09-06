package com.anjuxing.platform.face.tencent.util;

import com.alibaba.fastjson.JSONObject;
import com.anjuxing.platform.face.tencent.model.FaceVerifyResult;

/**
 * @author xiongt
 * @Description
 */
public class JsonUtil {

    private JsonUtil(){}

    private static final String KEY_DATA = "data";

    private static final  String CONFIDENCE = "confidence";

    private static final String ISMATCH = "ismatch";

    /**
     * 解析人脸验证后的json数据
     *  /**
     * {
     "data":{
     "session_id":"session_id",
     "confidence":90.0,
     "ismatch":true
     },
     "code":0,
     "message":"OK"
     }
     * @param json
     * @return
     */
    public static FaceVerifyResult pasreFaceVerify(String json) throws Exception{

        //解析json数据
        JSONObject jsonObject = JSONObject.parseObject(json);

        //获取data里的内容
        JSONObject data = (JSONObject) jsonObject.get(KEY_DATA);

        FaceVerifyResult verifyResult = new FaceVerifyResult();

        verifyResult.setConfidence(data.getFloat(CONFIDENCE));

        verifyResult.setMatch(data.getBoolean(ISMATCH));

        return verifyResult;

    }







}
