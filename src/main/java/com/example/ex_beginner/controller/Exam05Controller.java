package com.example.ex_beginner.controller;

import com.example.ex_beginner.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
    @Autowired
    private MemberRepository repository;

    @GetMapping("")
    public String index() {
        return "exam05";
    }

    @PostMapping("/result")
    public String result(String name, Model model) {
        model.addAttribute("members", repository.findByName(name));

        return "exam05-result";
    }
}
