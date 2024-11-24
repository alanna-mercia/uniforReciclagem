package com.example.uniforreciclagem.repo;

import com.example.uniforreciclagem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserByEmail(String email);

    User findUserByEmailAndPassword (String email, String password);

}
