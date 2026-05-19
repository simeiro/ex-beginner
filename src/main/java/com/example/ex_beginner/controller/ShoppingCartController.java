package com.example.ex_beginner.controller;

import com.example.ex_beginner.domain.Item;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/exam06")
public class ShoppingCartController {
    @Autowired
    private ServletContext application;

    @GetMapping("")
    public String index(HttpSession session, Model model) {
        if (application.getAttribute("items") == null) {
            application.setAttribute("items", List.of(
                    Item.builder().name("手帳ノート").price(1000).build(),
                    Item.builder().name("文房具セット").price(1500).build(),
                    Item.builder().name("ファイル").price(2000).build()
            ));
        }

        List<Item> cartItems = (List<Item>) session.getAttribute("cart");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            session.setAttribute("cart", cartItems);
        }

        int sumPrice = cartItems.stream()
                .mapToInt(Item::getPrice)
                .sum();

        model.addAttribute("sumPrice", sumPrice);

        return "item-and-cart";
    }

    @PostMapping("/in-cart")
    public String inCart(int index, HttpSession session) {
        List<Item> items = (List<Item>) application.getAttribute("items");
        List<Item> cartItems = (List<Item>) session.getAttribute("cart");

        cartItems.add(items.get(index));
        session.setAttribute("cart", cartItems);

        return "redirect:/exam06";
    }

    @PostMapping("/delete")
    public String delete(int index, HttpSession session) {
        List<Item> cartItems = (List<Item>) session.getAttribute("cart");
        cartItems.remove(index);

        return "redirect:/exam06";
    }
}
