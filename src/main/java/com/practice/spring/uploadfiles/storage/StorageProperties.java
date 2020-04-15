package com.practice.spring.uploadfiles.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

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
