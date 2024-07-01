package com.example.complaint_manager.controller;

import com.example.complaint_manager.model.ComplaintResponse;
import com.example.complaint_manager.service.ComplaintResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responses")
public class ComplaintResponseController {
    @Autowired
    private ComplaintResponseService complaintResponseService;

    @GetMapping("/{complaintId}")
    public List<ComplaintResponse> getResponses(@PathVariable int complaintId) {
        return complaintResponseService.getResponsesByComplaintId(complaintId);
    }

    @PostMapping
    public ComplaintResponse saveResponse(@RequestBody ComplaintResponse response) {
        return complaintResponseService.saveResponse(response);
    }
}
