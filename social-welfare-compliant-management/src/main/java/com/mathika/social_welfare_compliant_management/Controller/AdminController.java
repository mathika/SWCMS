package com.socialwelfare.controller;


import com.socialwelfare.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private AdminService adminService;



    @GetMapping("/complaints")
    public ResponseEntity<?> getAllComplaints(){

        return ResponseEntity.ok(
                adminService.getAllComplaints()
        );
    }



    @PutMapping("/complaint/{complaintId}/assign/{departmentId}")
    public ResponseEntity<?> assignDepartment(
            @PathVariable Long complaintId,
            @PathVariable Long departmentId){


        return ResponseEntity.ok(
                adminService.assignDepartment(
                        complaintId,
                        departmentId
                )
        );
    }



    @GetMapping("/dashboard")
    public ResponseEntity<?> dashboard(){

        return ResponseEntity.ok(
                adminService.getDashboard()
        );
    }

}