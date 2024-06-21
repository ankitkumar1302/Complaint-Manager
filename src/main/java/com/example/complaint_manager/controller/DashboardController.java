package com.example.complaint_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("userId", "defaultUserId"); // Adding a default userId to avoid Thymeleaf errors
        return "dashboard";
    }
}
/*
    TODO: Create the conditions in the login after validation got access to the dashboard.
    TODO: Create particular tables for that.
    TODO: Email Validation
    TODO: Make the user ID Primary Key

 */