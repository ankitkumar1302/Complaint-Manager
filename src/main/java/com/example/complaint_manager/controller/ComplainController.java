package com.example.complaint_manager.controller;

import com.example.complaint_manager.model.Complaint;
import com.example.complaint_manager.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Controller
public class ComplainController {

    @Autowired
    private ComplaintService complaintService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("/submitComplaint")
    public String submitComplaint(@RequestParam("type") String type,
                                  @RequestParam("description") String description,
                                  @RequestParam("image") MultipartFile image,
                                  @RequestParam("userId") String userId,
                                  Model model) {
        Complaint complaint = new Complaint();
        complaint.setType(type);
        complaint.setDescription(description);
        complaint.setStatus("open");
        complaint.setUserId(userId);

        if (!image.isEmpty()) {
            try {
                // Ensure the directory exists
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                String imagePath = uploadPath.resolve(Objects.requireNonNull(image.getOriginalFilename())).toString();
                File file = new File(imagePath);
                image.transferTo(file);

                // Save the relative path to the database
                complaint.setImageUrl(image.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "Failed to upload image!");
                return "dashboard";
            }
        }

        complaintService.saveComplaint(complaint);
        model.addAttribute("message", "Complaint submitted successfully!");
        return "redirect:/dashboard"; // Redirect to avoid form resubmission
    }


    @GetMapping("/viewComplaints")
    public String viewComplaints(Model model) {
        List<Complaint> openComplaints = complaintService.getOpenComplaints();
        model.addAttribute("complaints", openComplaints);
        return "viewComplaints";
    }

    @GetMapping("/complaintHistory")
    public String complaintHistory(@RequestParam("userId") String userId, Model model) {
        List<Complaint> complaints = complaintService.getComplaintHistory(userId);
        model.addAttribute("complaints", complaints);
        return "complaintHistory";
    }
}
