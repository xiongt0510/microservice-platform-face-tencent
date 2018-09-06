package com.anjuxing.platform.face.tencent.model;

/**
 * @author xiongt
 * @Description
 */
public class FaceVerifyResult {

    //匹配的相似度
    private float confidence;

    //是否是同一个人
    private boolean isMatch;


    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    public boolean isMatch() {
        return isMatch;
    }

    public void setMatch(boolean match) {
        isMatch = match;
    }


    @Override
    public String toString() {
        return "FaceManagerController{" +
                "confidence=" + confidence +
                ", isMatch=" + isMatch +
                '}';
    }
}
