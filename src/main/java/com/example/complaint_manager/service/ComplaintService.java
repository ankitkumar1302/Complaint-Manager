package com.example.complaint_manager.service;


import com.example.complaint_manager.model.Complaint;
import com.example.complaint_manager.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;

    public Complaint saveComplaint(Complaint complaint) {
        complaint.setRegistrationDateTime(LocalDateTime.now());
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getOpenComplaints() {
        return complaintRepository.findByStatus("Open");
    }

    public List<Complaint> getComplaintHistory() {
        return complaintRepository.findByStatus("Closed");
    }
}