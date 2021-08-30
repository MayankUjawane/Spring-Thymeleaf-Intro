package com.mayank.SpringThymeleafIntro.repository;

import com.mayank.SpringThymeleafIntro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
