package com.microservice.authserve.repository;

import com.microservice.authserve.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {

    Optional<AuthUser> findByUsername(String username);

    Optional<AuthUser> findByEmail(String email);
}
