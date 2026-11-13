package com.java14.Jpa2.respond;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRespond {
    private int code=200;
    private String message;
    private Object data;
}
