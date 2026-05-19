package com.example.ex_beginner.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserForm {
    @NotBlank(message = "名前を入力してください")
    private String name;
    @NotNull(message = "数値を入力してください")
    private Integer age;
    @NotBlank(message = "コメントを入力してください")
    private String comment;
}
