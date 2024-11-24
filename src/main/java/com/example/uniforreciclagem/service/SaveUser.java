package com.example.uniforreciclagem.service;

import com.example.uniforreciclagem.dto.TypeProfile;
import com.example.uniforreciclagem.entity.User;
import com.example.uniforreciclagem.exception.BadRequestException;
import com.example.uniforreciclagem.exception.ErrorMessageDto;
import com.example.uniforreciclagem.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SaveUser {

    private final UserRepository userRepository;
    public User execute(User user) {
        validateProfile(user);
        if (validateEmail(user)) {
            ErrorMessageDto errorMessageDto = ErrorMessageDto.builder().message("Email already registered, please use another email.").build();
            throw new BadRequestException(errorMessageDto);
        }
        return userRepository.save(user);
    }

    private void validateProfile(User user) {
        try{
            TypeProfile.valueOf(user.getType_profile());
        }catch (Exception e){
            ErrorMessageDto errorMessageDto = ErrorMessageDto.builder().message("type_profile invalid. The valid type_profile are BEGINNER, INTERMEDIARY and ADVANCED").build();
            throw new BadRequestException(errorMessageDto);
        }
    }

    private boolean validateEmail (User user) {
        return userRepository.findUserByEmail(user.getEmail()) != null;
    }
}
