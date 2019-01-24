package com.funcars.api.util;

import com.funcars.api.entity.Client;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

public class RestPreconditions {
    public static <T> T checkFound(T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }

    public static <T> T checkNotNull(T resource) {
        if (resource == null) {
            throw new NullPointerException();
        }
        return resource;
    }
}
