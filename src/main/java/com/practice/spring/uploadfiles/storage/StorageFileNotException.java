package com.practice.spring.uploadfiles.storage;

public class StorageFileNotException extends StorageException{

    public StorageFileNotException(String message){
        super(message);
    }

    public StorageFileNotException(String message, Throwable cause){
        super(message, cause);
    }
}
