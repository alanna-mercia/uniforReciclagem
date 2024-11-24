package com.example.uniforreciclagem.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorFieldDto {

    private String message;
    private String field;
}

