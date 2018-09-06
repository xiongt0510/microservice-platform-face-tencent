package com.anjuxing.platform.face.tencent.properties;


/**
 * @author xiongt
 * @Description
 */
public class ObjectStoreProperties {

//    @Value("${tencent.cloud.cos.expiration.days:30}")
    private int expirationDays = 30;

    private int expirationMonths = 1;

    private int expirationHours = 1;

    private String expirationType = "month";

    public int getExpirationDays() {
        return expirationDays;
    }

    public void setExpirationDays(int expirationDays) {
        this.expirationDays = expirationDays;
    }

    public int getExpirationMonths() {
        return expirationMonths;
    }

    public void setExpirationMonths(int expirationMonths) {
        this.expirationMonths = expirationMonths;
    }

    public int getExpirationHours() {
        return expirationHours;
    }

    public void setExpirationHours(int expirationHours) {
        this.expirationHours = expirationHours;
    }

    public String getExpirationType() {
        return expirationType;
    }

    public void setExpirationType(String expirationType) {
        this.expirationType = expirationType;
    }
}
