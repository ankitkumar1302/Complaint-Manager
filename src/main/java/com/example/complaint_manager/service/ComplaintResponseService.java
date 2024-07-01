package com.example.complaint_manager.service;

import com.example.complaint_manager.model.ComplaintResponse;
import com.example.complaint_manager.repository.ComplaintResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintResponseService {
    @Autowired
    private ComplaintResponseRepository complaintResponseRepository;

    public List<ComplaintResponse> getResponsesByComplaintId(int complaintId) {
        return complaintResponseRepository.findByComplaintId(complaintId);
    }

    public ComplaintResponse saveResponse(ComplaintResponse response) {
        return complaintResponseRepository.save(response);
    }
}