package com.sumin.spring_crud.service.impl;

import com.sumin.spring_crud.exception.BlogAPIException;
import com.sumin.spring_crud.model.User;
import com.sumin.spring_crud.payload.LoginDto;
import com.sumin.spring_crud.payload.RegisterDto;
import com.sumin.spring_crud.repository.UserRepository;
import com.sumin.spring_crud.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.BadLocationException;

@Service
public class AuthServiceImpl implements AuthService {


    private UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository){

        this.userRepository = userRepository;
    }

    @Override
    public String loginUser(LoginDto loginDto) {
        return "1111";
    }

    @Override
    public String registerUser(RegisterDto registerDto) {
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"email is already exists");

        }
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(registerDto.getPassword());
        userRepository.save(user);
        return "user registered successfully";
    }
}
