package com.example.uniforreciclagem.dto;

import lombok.Getter;

@Getter
public enum TypeProfile {
    BEGINNER("BEGINNER"),
    INTERMEDIARY("INTERMEDIARY"),
    ADVANCED("ADVANCED");

    private final String typeProfile;

    TypeProfile(final String typeProfile) {
        this.typeProfile = typeProfile;
    }

}
