package com.kush.common;

public interface HasVersion {

    Long getVersion();

    default void setVersion(Long version) {
    }

}
