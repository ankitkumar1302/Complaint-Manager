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
    TODO: Email Validation
    TODO: Have to remove teh User ID form the Submit Complaint & from database.
    TODO: Complaint History how to get search for that.
    TODO: Create a link where user click on that and get the image of the complaint.

 */