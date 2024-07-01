package com.example.complaint_manager.repository;

import com.example.complaint_manager.model.ComplaintResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintResponseRepository extends JpaRepository<ComplaintResponse, Integer> {
    List<ComplaintResponse> findByComplaintId(int complaintId);
}
