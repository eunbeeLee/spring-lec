package com.practice.spring.uploadfiles.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

// application.properties 에서 값을 가져올 수 있다.
@ConfigurationProperties("storage")
public class StorageProperties {

    private String location = "upload.dir";


    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
