package com.sherwin.springit.repository;

import com.sherwin.springit.domain.Link;
import com.sherwin.springit.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndActivationCode(String email,String activationCode);
}
