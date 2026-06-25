package com.Production.service;


import com.Production.dto.LoginDto;
import com.Production.entity.User;
import com.Production.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean verifyUser(LoginDto loginDto) {
        Optional<User> byUsername = userRepository.findByUsername(loginDto.getUsername());

        if(byUsername.isPresent()){
            User user = byUsername.get();
            return BCrypt.checkpw(loginDto.getPassword(),user.getPassword());
        }
        else{
            return false;
        }
    }
}
