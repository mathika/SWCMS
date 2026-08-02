package com.socialwelfare.service.impl;


import com.socialwelfare.dto.LoginRequest;
import com.socialwelfare.dto.RegisterRequest;
import com.socialwelfare.entity.User;
import com.socialwelfare.repository.UserRepository;
import com.socialwelfare.service.AuthService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthServiceImpl implements AuthService {



@Autowired
private UserRepository userRepository;


@Autowired
private PasswordEncoder passwordEncoder;



@Override
public String register(RegisterRequest request){


    User user = new User();

    user.setName(request.getName());

    user.setEmail(request.getEmail());

    user.setPassword(
       passwordEncoder.encode(request.getPassword())
    );


    userRepository.save(user);


    return "Registration Successful";

}




@Override
public String login(LoginRequest request){


    User user =
    userRepository.findByEmail(
        request.getEmail()
    );


    if(user!=null &&
       passwordEncoder.matches(
       request.getPassword(),
       user.getPassword())){


        return "Login Successful";

    }


    return "Invalid Credentials";

}


}