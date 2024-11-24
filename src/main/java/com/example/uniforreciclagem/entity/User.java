package com.example.uniforreciclagem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String username;

    @Email(message = "invalid email")
    private String email;

    @Pattern(regexp = "^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[0-9])[0-9]{3}?[0-9]{4}$", message = "invalid cellphone")
    private String cellphone;

    private String type_profile;

    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
