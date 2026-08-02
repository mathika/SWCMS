package com.socialwelfare.service;


public interface AdminService {


    Object getAllComplaints();


    Object assignDepartment(
            Long complaintId,
            Long departmentId);



    Object getDashboard();

}