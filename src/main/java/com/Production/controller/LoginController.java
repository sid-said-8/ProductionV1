package com.Production.controller;


import com.Production.dto.LoginDto;
import com.Production.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/production/user")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String>login(@RequestBody LoginDto loginDto){
        Boolean status = loginService.verifyUser(loginDto);

        if(status){
            return new ResponseEntity<>("User logged in", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Invalid Username or Password",HttpStatus.FORBIDDEN);
        }
    }

}
