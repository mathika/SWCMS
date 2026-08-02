package com.socialwelfare.controller;


import com.socialwelfare.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/department")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;



    @GetMapping("/{departmentId}/complaints")
    public ResponseEntity<?> getAssignedComplaints(
            @PathVariable Long departmentId){

        return ResponseEntity.ok(
                departmentService
                .getAssignedComplaints(departmentId)
        );
    }



    @PutMapping("/complaint/{id}/status")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long id,
            @RequestParam String status){

        return ResponseEntity.ok(
                departmentService
                .updateStatus(id,status)
        );
    }

}