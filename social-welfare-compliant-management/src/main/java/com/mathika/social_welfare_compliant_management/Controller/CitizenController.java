package com.socialwelfare.controller;


import com.socialwelfare.dto.ComplaintRequest;
import com.socialwelfare.service.CitizenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/citizen")
public class CitizenController {



    @Autowired
    private CitizenService citizenService;



    // Citizen creates a new complaint

    @PostMapping("/complaint")
    public ResponseEntity<?> createComplaint(
            @RequestBody ComplaintRequest request) {


        return ResponseEntity.ok(
                citizenService.createComplaint(request)
        );

    }



    // Citizen views all his complaints

    @GetMapping("/{userId}/complaints")
    public ResponseEntity<?> getMyComplaints(
            @PathVariable Long userId) {


        return ResponseEntity.ok(
                citizenService.getCitizenComplaints(userId)
        );

    }



    // Citizen tracks a particular complaint

    @GetMapping("/complaint/{complaintId}")
    public ResponseEntity<?> getComplaintStatus(
            @PathVariable Long complaintId) {


        return ResponseEntity.ok(
                citizenService.getComplaintById(complaintId)
        );

    }



    // Citizen updates complaint details

    @PutMapping("/complaint/{id}")
    public ResponseEntity<?> updateComplaint(
            @PathVariable Long id,
            @RequestBody ComplaintRequest request) {


        return ResponseEntity.ok(
                citizenService.updateComplaint(id, request)
        );

    }



    // Citizen deletes complaint

    @DeleteMapping("/complaint/{id}")
    public ResponseEntity<?> deleteComplaint(
            @PathVariable Long id) {


        return ResponseEntity.ok(
                citizenService.deleteComplaint(id)
        );

    }


}