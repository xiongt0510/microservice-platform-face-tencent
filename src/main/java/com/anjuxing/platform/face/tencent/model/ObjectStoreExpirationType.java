package com.anjuxing.platform.face.tencent.model;


import com.anjuxing.platform.face.tencent.properties.ObjectStoreProperties;
import com.anjuxing.platform.face.tencent.util.DateUtil;

import java.util.Date;

/**
 * 对象存储过期类型
 */
public enum ObjectStoreExpirationType {
    HOUR{
        @Override
        public Date calculateExpirationDate(Date baseDate , ObjectStoreProperties store) {
            return DateUtil.calculateDateByHours(baseDate ,store.getExpirationHours());
        }
    },
    DAY{
        @Override
        public Date calculateExpirationDate(Date baseDate , ObjectStoreProperties store) {
            return DateUtil.calculateDateByDays(baseDate,store.getExpirationDays());
        }
    },
    MONTH{
        @Override
        public Date calculateExpirationDate(Date baseDate , ObjectStoreProperties store) {
            return DateUtil.calculateDateByMonths(baseDate,store.getExpirationMonths());
        }
    };

    public abstract Date calculateExpirationDate(Date baseDate , ObjectStoreProperties store);

}
