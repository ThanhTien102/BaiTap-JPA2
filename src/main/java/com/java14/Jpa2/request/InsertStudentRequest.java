package com.java14.Jpa2.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertStudentRequest {
    private int id;
    private String name;
    private String email;
}
