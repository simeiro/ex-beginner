package com.example.ex_beginner.controller;

import com.example.ex_beginner.form.ProductsForm;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {

    @Autowired
    private ServletContext application;

    @GetMapping("")
    public String index(ProductsForm productsForm) {
        return "exam03";
    }

    @PostMapping("/result")
    public String result(ProductsForm productsForm) {
        int sum = productsForm.getProducts().stream()
                .mapToInt(Integer::intValue)
                .sum();
        int taxSum = (int) (sum + sum * 0.1);

        String formattedSum = String.format("%,d", sum);
        String formattedTaxSum = String.format("%,d", taxSum);

        application.setAttribute("sum", formattedSum);
        application.setAttribute("taxSum", formattedTaxSum);

        return "exam03-result";
    }
}
