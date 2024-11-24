package com.example.uniforreciclagem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BadRequestException extends RuntimeException {
    private final ErrorMessageDto errorMessageDto;
}
