package com.example.ex_beginner.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CalcForm {
    private String num1;
    private String num2;

    public int getAddResult() {
        return Integer.parseInt(num1) + Integer.parseInt(num2);
    }
}
