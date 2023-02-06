package com.microservice.authserve.repository;

import com.microservice.authserve.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {

    Optional<AuthUser> findByUsername(String username);

    Optional<AuthUser> findByEmail(String email);
}
