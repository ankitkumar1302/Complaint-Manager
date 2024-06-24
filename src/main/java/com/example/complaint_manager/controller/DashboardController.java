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
    TODO: Handle the registration page.
    TODO: Email Validation
    TODO: Create the conditions in the login after validation got access to the dashboard.
    TODO: Create the conditions in the login page field emails ends with @iocl.in (Give condition at last)
    TODO: Complaint History how to get search for that.
    TODO: Have to create a new page for the complaint history.(What wil be the component or thing that help for search it.)
    TODO: Have to create logout button. with functionality.

 */