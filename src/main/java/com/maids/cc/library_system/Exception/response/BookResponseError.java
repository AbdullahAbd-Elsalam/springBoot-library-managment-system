package com.maids.cc.library_system.Exception.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookResponseError {

    // this is the response error type
    private int code;
    private String messege;
    private long timeStamp;
}
