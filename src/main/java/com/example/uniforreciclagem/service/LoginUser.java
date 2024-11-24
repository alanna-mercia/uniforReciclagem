package com.example.uniforreciclagem.service;

import com.example.uniforreciclagem.dto.UserResponseLoginDto;
import com.example.uniforreciclagem.entity.User;
import com.example.uniforreciclagem.entity.UserLogin;
import com.example.uniforreciclagem.exception.BadRequestException;
import com.example.uniforreciclagem.exception.ErrorMessageDto;
import com.example.uniforreciclagem.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@AllArgsConstructor
public class LoginUser {

    private final UserRepository userRepository;

    public UserResponseLoginDto execute(UserLogin userLogin) {

        User resultUserEmail = userRepository.findUserByEmail(userLogin.getEmail());

        if (resultUserEmail == null){
            ErrorMessageDto errorMessageDto = ErrorMessageDto.builder().message("Email/Password not invalid.").build();
            throw new BadRequestException(errorMessageDto);
        }

        if (!Objects.equals(userLogin.getPassword(), resultUserEmail.getPassword())){
            ErrorMessageDto errorMessageDto = ErrorMessageDto.builder().message("Email/Password not invalid.").build();
            throw new BadRequestException(errorMessageDto);
        }

        return UserResponseLoginDto.builder().loginValid(true).build();

    }

}
