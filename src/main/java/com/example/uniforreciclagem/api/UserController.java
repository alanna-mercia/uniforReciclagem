package com.example.uniforreciclagem.api;

import com.example.uniforreciclagem.entity.User;
import com.example.uniforreciclagem.entity.UserLogin;
import com.example.uniforreciclagem.service.LoginUser;
import com.example.uniforreciclagem.service.SaveUser;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final SaveUser saveUser;

    private final LoginUser loginUser;

    @PostMapping("/")
    public ResponseEntity<Object> save(@Valid @RequestBody User user) {
        val result = saveUser.execute(user);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody UserLogin userLogin) {
        val result = loginUser.execute(userLogin);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
