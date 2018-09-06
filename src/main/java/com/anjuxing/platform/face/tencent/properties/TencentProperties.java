package com.anjuxing.platform.face.tencent.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xiongt
 * @Description
 */
@ConfigurationProperties(prefix = "tencent")
public class TencentProperties {

    private ClientProperties client  = new ClientProperties();

    private ObjectStoreProperties store = new ObjectStoreProperties();

    public ClientProperties getClient() {
        return client;
    }

    public void setClient(ClientProperties client) {
        this.client = client;
    }

    public ObjectStoreProperties getStore() {
        return store;
    }

    public void setStore(ObjectStoreProperties store) {
        this.store = store;
    }
}
