package com.sumin.spring_crud.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterDto {

    @Email
    private String email;

    @NotEmpty
    @Size(min = 5, message = "Register content should have at least 5 characters")
    private String password;

    @NotEmpty
    @Size(min = 2, message ="Register content should have at least 2 characters")
    private String username;


}
