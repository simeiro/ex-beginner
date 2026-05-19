package com.example.ex_beginner.controller;

import com.example.ex_beginner.form.CalcForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {

    @GetMapping("")
    public String index(CalcForm calcForm) {
        return "exam02";
    }

    @PostMapping("/result")
    public String result(CalcForm calcForm, HttpSession session) {
        session.setAttribute("calcForm", calcForm);
        session.setAttribute("addResult", calcForm.getAddResult());
        return "exam02-result";
    }

    @GetMapping("/result2")
    public String result2() {
        return "exam02-result2";
    }
}
