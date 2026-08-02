package com.socialwelfare.service;


import com.socialwelfare.dto.LoginRequest;
import com.socialwelfare.dto.RegisterRequest;


public interface AuthService {


    // Register new citizen/admin/department officer

    String register(RegisterRequest request);



    // Login user

    String login(LoginRequest request);


}