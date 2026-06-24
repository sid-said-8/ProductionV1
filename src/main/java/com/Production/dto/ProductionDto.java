package com.Production.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class ProductionDto {

    @NotBlank
    @Size(min=2 ,message = "Name should be minimum 2 letter")
    private String name;

    @Email
    private String email;

    @Size(min=10,max=10,message = "mobile number should be 10 digits")
    private String mobile;

    @Size(min=2,message = "username should be unique")
    private String username;
}


