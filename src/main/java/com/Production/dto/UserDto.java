package com.Production.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class UserDto {

    @NotBlank
    @Size(min=2 ,message = "Name should be minimum 2 letter")
    private String name;

    @Email
    private String email;

    @Size(min=2,message = "username should be unique")
    private String username;

    @Size(min=5,message = "password should be minimum 5 letters")
    private String password;
}
