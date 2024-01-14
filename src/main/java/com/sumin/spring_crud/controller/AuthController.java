package com.sumin.spring_crud.controller;


import com.sumin.spring_crud.payload.LoginDto;
import com.sumin.spring_crud.payload.RegisterDto;
import com.sumin.spring_crud.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;


    public AuthController(AuthService authService){
        this.authService = authService;

    }

    //회원가입
    @PostMapping("signup")
    public ResponseEntity<String> createUser(@Valid @RequestBody RegisterDto registerDto){
        //return new ResponseEntity<>("sucuess signup", HttpStatus.CREATED);
        //return ResponseEntity.ok("success signup");
        return new ResponseEntity<>(authService.registerUser(registerDto),HttpStatus.CREATED);
    }

    //로그인
    @PostMapping("login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto){
        //return new ResponseEntity<>("sucuess login",HttpStatus.OK);
        return ResponseEntity.ok(authService.loginUser(loginDto));
    }








}
