package com.ardian.blogs.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * ResponseWrapper
 */
@Setter
@Getter
public class ResponseWrapper<Any> {
    
    private boolean status = true;
    private int code = 200;
    private String message = "success";
    private Any data;
}