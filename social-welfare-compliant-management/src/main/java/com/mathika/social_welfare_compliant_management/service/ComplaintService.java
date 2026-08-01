package com.mathika.social_welfare_compliant_management.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathika.social_welfare_compliant_management.entity.Complaint;
import com.mathika.social_welfare_compliant_management.entity.User;
import com.mathika.social_welfare_compliant_management.repository.ComplaintRepository;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public Complaint saveComplaint(Complaint complaint) {

        complaint.setStatus("Pending");

        complaint.setComplaintDate(LocalDate.now());

        return complaintRepository.save(complaint);
    }

    public List<Complaint> getUserComplaints(User user) {

        return complaintRepository.findByUser(user);
    }

    public List<Complaint> getAllComplaints() {

        return complaintRepository.findAll();
    }

    public Complaint updateStatus(Long id, String status) {

        Complaint complaint = complaintRepository.findById(id).orElse(null);

        if (complaint != null) {

            complaint.setStatus(status);

            return complaintRepository.save(complaint);
        }

        return null;
    }

    public void deleteComplaint(Long id) {

        complaintRepository.deleteById(id);
    }
}