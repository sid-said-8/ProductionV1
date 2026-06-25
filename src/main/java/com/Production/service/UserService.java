package com.Production.service;
import com.Production.dto.UserDto;
import com.Production.entity.Production;
import com.Production.entity.User;
import com.Production.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService {

    private UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository,
                       ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public String createNewUser(UserDto userDto) {
        Optional<User> byEmail = userRepository.findByEmail(userDto.getEmail());
        if(byEmail.isPresent()){
            throw new RuntimeException("Email already exist");
        }

        Optional<User> byUsername = userRepository.findByUsername(userDto.getUsername());
        if(byUsername.isPresent()){
           throw new RuntimeException("Username already present");
        }

        User user=new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(5));
        user.setPassword(encryptedPassword);
        User savedUser = userRepository.save(user);

        return "User Registered Succesfully";
    }

    public List<UserDto> getAllUsers() {
        List<User> all = userRepository.findAll();
        return all.stream().map((u) -> modelMapper.map(u, UserDto.class)).toList();  //u refers to element i.e. user
    }
}
