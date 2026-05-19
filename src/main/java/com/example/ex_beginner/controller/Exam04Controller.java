package com.example.ex_beginner.controller;

import com.example.ex_beginner.domain.User;
import com.example.ex_beginner.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

    @GetMapping("")
    public String index(UserForm userForm) {
        return "exam04";
    }

    @PostMapping("/result")
    public String result(@Validated UserForm userForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "exam04";
        }

        User user = User.builder()
                .name(userForm.getName())
                .age(userForm.getAge())
                .comment(userForm.getComment())
                .build();
        model.addAttribute("user", user);

        return "exam04-result";
    }
}
