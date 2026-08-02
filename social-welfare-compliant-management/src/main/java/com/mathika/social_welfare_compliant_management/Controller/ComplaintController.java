package com.socialwelfare.controller;


import com.socialwelfare.dto.ComplaintRequest;
import com.socialwelfare.service.CitizenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/complaints")
public class ComplaintController {


    @Autowired
    private CitizenService citizenService;



    @PostMapping
    public ResponseEntity<?> createComplaint(
            @RequestBody ComplaintRequest request){

        return ResponseEntity.ok(
                citizenService.createComplaint(request)
        );
    }



    @GetMapping("/my/{userId}")
    public ResponseEntity<?> getMyComplaints(
            @PathVariable Long userId){

        return ResponseEntity.ok(
                citizenService.getCitizenComplaints(userId)
        );
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getComplaint(
            @PathVariable Long id){

        return ResponseEntity.ok(
                citizenService.getComplaintById(id)
        );
    }


}