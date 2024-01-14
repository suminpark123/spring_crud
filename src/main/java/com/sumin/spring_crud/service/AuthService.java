package com.sumin.spring_crud.service;

import com.sumin.spring_crud.payload.LoginDto;
import com.sumin.spring_crud.payload.RegisterDto;

public interface AuthService {

    String loginUser(LoginDto loginDto);

    String registerUser(RegisterDto registerDto);
}
