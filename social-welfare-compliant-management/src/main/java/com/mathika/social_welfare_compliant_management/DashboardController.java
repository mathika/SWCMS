package com.mathika.social_welfare_compliant_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mathika.social_welfare_compliant_management.entity.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {

            return "redirect:/login";
        }

        model.addAttribute("user", user);

        return "dashboard";
    }

}