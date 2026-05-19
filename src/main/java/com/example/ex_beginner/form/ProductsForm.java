package com.example.ex_beginner.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ProductsForm {
    private List<Integer> products;
}
