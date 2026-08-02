package com.socialwelfare.service;


import com.socialwelfare.dto.ComplaintRequest;


public interface CitizenService {


    Object createComplaint(
        ComplaintRequest request);


    Object getCitizenComplaints(
        Long userId);


    Object getComplaintById(
        Long id);

}