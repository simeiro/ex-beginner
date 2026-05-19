package com.example.ex_beginner.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class User {
    private String name;
    private Integer age;
    private String comment;
}
