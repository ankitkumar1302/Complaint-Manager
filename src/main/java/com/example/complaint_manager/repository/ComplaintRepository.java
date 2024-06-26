package com.example.complaint_manager.repository;


import com.example.complaint_manager.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByStatus(String status);
//    List<Complaint> findByUserId(String userId);
}